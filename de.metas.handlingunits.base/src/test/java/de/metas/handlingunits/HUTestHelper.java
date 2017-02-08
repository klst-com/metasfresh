package de.metas.handlingunits;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/*
 * #%L
 * de.metas.handlingunits.base
 * %%
 * Copyright (C) 2015 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

import org.adempiere.ad.dao.IQueryBL;
import org.adempiere.ad.dao.IQueryBuilder;
import org.adempiere.ad.modelvalidator.IModelInterceptorRegistry;
import org.adempiere.ad.trx.api.ITrx;
import org.adempiere.ad.trx.api.ITrxManager;
import org.adempiere.exceptions.DBException;
import org.adempiere.inout.service.IMTransactionBL;
import org.adempiere.mm.attributes.api.impl.LotNumberDateAttributeDAO;
import org.adempiere.mm.attributes.model.I_M_Attribute;
import org.adempiere.mm.attributes.spi.impl.WeightGrossAttributeValueCallout;
import org.adempiere.mm.attributes.spi.impl.WeightNetAttributeValueCallout;
import org.adempiere.mm.attributes.spi.impl.WeightTareAdjustAttributeValueCallout;
import org.adempiere.mm.attributes.spi.impl.WeightTareAttributeValueCallout;
import org.adempiere.model.IContextAware;
import org.adempiere.model.InterfaceWrapperHelper;
import org.adempiere.model.PlainContextAware;
import org.adempiere.test.AdempiereTestHelper;
import org.adempiere.util.Check;
import org.adempiere.util.Services;
import org.adempiere.util.time.SystemTime;
import org.compiere.Adempiere;
import org.compiere.model.I_AD_Client;
import org.compiere.model.I_AD_Role;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_UOM;
import org.compiere.model.I_C_UOM_Conversion;
import org.compiere.model.I_M_AttributeValue;
import org.compiere.model.I_M_Product;
import org.compiere.model.I_M_Shipper;
import org.compiere.model.I_M_Transaction;
import org.compiere.model.I_Test;
import org.compiere.model.X_C_UOM;
import org.compiere.model.X_M_Attribute;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;
import org.eevolution.util.DDNetworkBuilder;
import org.eevolution.util.ProductBOMBuilder;
import org.junit.Assert;

import de.metas.adempiere.model.I_C_BPartner_Location;
import de.metas.handlingunits.allocation.IAllocationDestination;
import de.metas.handlingunits.allocation.IAllocationRequest;
import de.metas.handlingunits.allocation.IAllocationResult;
import de.metas.handlingunits.allocation.IAllocationSource;
import de.metas.handlingunits.allocation.IHUContextProcessor;
import de.metas.handlingunits.allocation.ILUTUConfigurationFactory;
import de.metas.handlingunits.allocation.ILUTUProducerAllocationDestination;
import de.metas.handlingunits.allocation.impl.AbstractAllocationSourceDestination;
import de.metas.handlingunits.allocation.impl.AllocationUtils;
import de.metas.handlingunits.allocation.impl.GenericAllocationSourceDestination;
import de.metas.handlingunits.allocation.impl.HUListAllocationSourceDestination;
import de.metas.handlingunits.allocation.impl.HULoader;
import de.metas.handlingunits.allocation.impl.HUProducerDestination;
import de.metas.handlingunits.allocation.impl.IMutableAllocationResult;
import de.metas.handlingunits.allocation.impl.MTransactionAllocationSourceDestination;
import de.metas.handlingunits.allocation.transfer.IHUJoinBL;
import de.metas.handlingunits.allocation.transfer.IHUSplitBuilder;
import de.metas.handlingunits.allocation.transfer.ITUMergeBuilder;
import de.metas.handlingunits.allocation.transfer.impl.HUSplitBuilder;
import de.metas.handlingunits.allocation.transfer.impl.LUTUProducerDestination;
import de.metas.handlingunits.allocation.transfer.impl.TUMergeBuilder;
import de.metas.handlingunits.attribute.Constants;
import de.metas.handlingunits.attribute.IAttributeValue;
import de.metas.handlingunits.attribute.impl.PlainAttributeValue;
import de.metas.handlingunits.attribute.impl.WeightableFactory;
import de.metas.handlingunits.attribute.propagation.impl.HUAttributePropagationContext;
import de.metas.handlingunits.attribute.propagation.impl.NoPropagationHUAttributePropagator;
import de.metas.handlingunits.attribute.storage.IAttributeStorage;
import de.metas.handlingunits.attribute.storage.IAttributeStorageFactory;
import de.metas.handlingunits.attribute.storage.impl.ListAttributeStorage;
import de.metas.handlingunits.attribute.storage.impl.NullAttributeStorage;
import de.metas.handlingunits.attribute.strategy.impl.CopyAttributeSplitterStrategy;
import de.metas.handlingunits.attribute.strategy.impl.CopyHUAttributeTransferStrategy;
import de.metas.handlingunits.attribute.strategy.impl.LinearDistributionAttributeSplitterStrategy;
import de.metas.handlingunits.attribute.strategy.impl.NullAggregationStrategy;
import de.metas.handlingunits.attribute.strategy.impl.NullSplitterStrategy;
import de.metas.handlingunits.attribute.strategy.impl.RedistributeQtyHUAttributeTransferStrategy;
import de.metas.handlingunits.attribute.strategy.impl.SumAggregationStrategy;
import de.metas.handlingunits.impl.CachedHUAndItemsDAO;
import de.metas.handlingunits.impl.HUPIItemProductDAO;
import de.metas.handlingunits.impl.HandlingUnitsDAO;
import de.metas.handlingunits.model.I_DD_NetworkDistribution;
import de.metas.handlingunits.model.I_M_HU;
import de.metas.handlingunits.model.I_M_HU_Attribute;
import de.metas.handlingunits.model.I_M_HU_LUTU_Configuration;
import de.metas.handlingunits.model.I_M_HU_PI;
import de.metas.handlingunits.model.I_M_HU_PI_Attribute;
import de.metas.handlingunits.model.I_M_HU_PI_Item;
import de.metas.handlingunits.model.I_M_HU_PI_Item_Product;
import de.metas.handlingunits.model.I_M_HU_PI_Version;
import de.metas.handlingunits.model.I_M_HU_PackingMaterial;
import de.metas.handlingunits.model.I_M_HU_Trx_Hdr;
import de.metas.handlingunits.model.I_M_Locator;
import de.metas.handlingunits.model.X_M_HU_PI_Attribute;
import de.metas.handlingunits.model.X_M_HU_PI_Item;
import de.metas.handlingunits.storage.impl.PlainProductStorage;
import de.metas.handlingunits.test.HUListAssertsBuilder;
import de.metas.handlingunits.test.misc.builders.HUPIAttributeBuilder;
import de.metas.inoutcandidate.modelvalidator.InOutCandidateValidator;
import de.metas.inoutcandidate.modelvalidator.ReceiptScheduleValidator;
import de.metas.interfaces.I_M_Warehouse;
import de.metas.javaclasses.model.I_AD_JavaClass;

/**
 * This class sets up basic master data like attributes and HU-items that can be used in testing.
 *
 * @author metas-dev <dev@metasfresh.com>
 *
 */
public class HUTestHelper
{
	/**
	 * Default precision
	 */
	private static final int UOM_Precision_0 = 0;

	/**
	 * Standard in ADempiere
	 */
	private static final int UOM_Precision_3 = 3;

	//
	// Initialization flags
	private boolean initialized = false;
	private boolean initAdempiere = true;

	public I_AD_Client adClient;
	public I_AD_Role adRole;

	public static final String NAME_CountryMadeIn_Attribute = "Made In";
	public static final String NAME_Volume_Attribute = "Volume";
	public static final String NAME_FragileSticker_Attribute = "Fragile";

	// we reuse the "production" M_Attribute.Values from WeightableFactory
	public static final String NAME_WeightGross_Attribute = WeightableFactory.ATTR_WeightGross_Value;
	public static final String NAME_WeightNet_Attribute = WeightableFactory.ATTR_WeightNet_Value;
	public static final String NAME_WeightTare_Attribute = WeightableFactory.ATTR_WeightTare_Value;
	public static final String NAME_WeightTareAdjust_Attribute = WeightableFactory.ATTR_WeightTareAdjust_Value;

	public static final String NAME_QualityDiscountPercent_Attribute = "QualityDiscountPercent";
	public static final String NAME_QualityNotice_Attribute = "QualityNotice";
	public static final String NAME_SubProducerBPartner_Attribute = "SubProducerBPartner";

	public static final String NAME_M_Material_Tracking_ID_Attribute = "M_Material_Tracking_ID";

	public static final String NAME_Palet_Product = "Palet";
	public static final String NAME_IFCO_Product = "IFCO";
	public static final String NAME_Bag_Product = "Bag";
	public static final String NAME_Paloxe_Product = "Paloxe";
	public static final String NAME_Blister_Product = "Blister";
	public static final String NAME_Truck_Product = "Truck";

	public static final String NAME_Default_Warehouse = "DefaultWarehouse";
	public static final String NAME_Issue_Warehouse = "IssueWarehouse";

	public IHUTrxBL trxBL;

	public I_C_UOM uomEach;
	public I_C_UOM uomKg;
	public I_C_UOM uomPCE;

	/**
	 * Value: Palet
	 */
	public I_M_Product pPalet; // palets are our packing material
	public final BigDecimal pPalet_Weight_25kg = BigDecimal.valueOf(25);
	public I_M_HU_PackingMaterial pmPalet; // palets are our packing material

	/**
	 * Value: IFCO
	 */
	public I_M_Product pIFCO; // IFCOs are another kind of packing material
	public final BigDecimal pIFCO_Weight_1kg = BigDecimal.ONE;
	public I_M_HU_PackingMaterial pmIFCO; // IFCO Packing Material

	/**
	 * Value: Blister
	 */
	public I_M_Product pBag; // Bags are another kind of packing material
	public final BigDecimal pBag_Weight_0_5Kg = BigDecimal.valueOf(0.5);
	public I_M_HU_PackingMaterial pmBag; // Bag Packing Material

	/**
	 * Value: Paloxe
	 */
	public I_M_Product pPaloxe; // Paloxes are another kind of packing material
	public final BigDecimal pPaloxe_Weight_75kg = BigDecimal.valueOf(75);
	public I_M_HU_PackingMaterial pmPaloxe; // Paloxe Packing Material

	/**
	 * Value: Tomato
	 */
	public I_M_Product pTomato;
	public static final String NAME_Tomato_Product = "Tomato";

	public I_M_Product pSalad;
	public static final String NAME_Salad_Product = "Salad";

	/**
	 * No-HU PI
	 */
	public I_M_HU_PI huDefNone;
	/**
	 * No-HU PI Item
	 */
	public I_M_HU_PI_Item huDefItemNone;
	/**
	 * No-HU PI Item Product
	 */
	public I_M_HU_PI_Item_Product huDefItemProductNone;

	/**
	 * Virtual M_HU_PI
	 */
	public I_M_HU_PI huDefVirtual;
	/**
	 * Virtual M_HU_PI Item
	 */
	public I_M_HU_PI_Item huDefItemVirtual;
	/**
	 * Virtual M_HU_PI Item Product
	 */
	public I_M_HU_PI_Item_Product huDefItemProductVirtual;
	public I_M_HU_PI_Attribute huDefVirtual_Attr_CostPrice;

	public static final String COUNTRYMADEIN_DE = "DE";
	public static final String COUNTRYMADEIN_FR = "FR";
	public static final String COUNTRYMADEIN_RO = "RO";

	public static final String QUALITYNOTICE_Test1 = "QUALITYNOTICE_Test1";
	public static final String QUALITYNOTICE_Test2 = "QUALITYNOTICE_Test2";
	public static final String QUALITYNOTICE_Test3 = "QUALITYNOTICE_Test3";

	public I_M_Attribute attr_CountryMadeIn;

	public I_M_Attribute attr_Volume;
	public I_M_Attribute attr_FragileSticker;

	/**
	 * Gross Weight. Calculation in callout: Gross = Net + Tare + TareAdjust
	 */
	public I_M_Attribute attr_WeightGross;
	/**
	 * Net Weight. Calculation in callout: Net = Gross - Tare - TareAdjust
	 */
	public I_M_Attribute attr_WeightNet;
	/**
	 * Tare Weight. Calculation in callout (seed only): Tare + TareChild x ChildrenCount (i.e LUTare = LUTarePackingMaterial + TUTarePackingMaterial x TUCountInLU)
	 */
	public I_M_Attribute attr_WeightTare;
	/**
	 * Tare Weight Adjust. Used in calculating Gross / Net depending on weight fluctuations from the defined normal weight of the packing material.
	 */
	public I_M_Attribute attr_WeightTareAdjust;

	public I_M_Attribute attr_CostPrice;

	public I_M_Attribute attr_LotNumberDate;

	// #653
	public I_M_Attribute attr_LotNumber;

	/**
	 * Mandatory in receipts
	 */
	public I_M_Attribute attr_QualityDiscountPercent;
	/**
	 * Mandatory in receipts
	 */
	public I_M_Attribute attr_QualityNotice;
	/**
	 * Mandatory in receipts
	 */
	public I_M_Attribute attr_SubProducerBPartner;

	/**
	 * Mandatory for integration with the de.metas.materialtracking module
	 */
	public I_M_Attribute attr_M_Material_Tracking_ID;

	public I_M_Attribute attr_PurchaseOrderLine;
	public I_M_Attribute attr_ReceiptInOutLine;

	//
	// Default warehouses
	public I_M_Warehouse defaultWarehouse;
	public I_M_Warehouse issueWarehouse;
	// Empties:
	public I_M_Warehouse warehouse_Empties;
	private DDNetworkBuilder emptiesDDNetworkBuilder;

	public Properties ctx;
	public String trxName;
	private Timestamp today;
	public final IContextAware contextProvider = new IContextAware()
	{
		@Override
		public Properties getCtx()
		{
			return ctx;
		}

		@Override
		public String getTrxName()
		{
			return trxName;
		}
	};
	private IMutableHUContext huContext;

	/**
	 * Invokes {@link #HUTestHelper(boolean)} with init=<code>true</code>.
	 */
	public HUTestHelper()
	{
		this(true);
	}

	/**
	 *
	 * @param init if <code>true</code>, the the constructor directly calls {@link #init()}.
	 */
	public HUTestHelper(final boolean init)
	{
		if (init)
		{
			init();
		}
	}

	public void setInitAdempiere(final boolean initAdempiere)
	{
		Check.assume(!initialized, "helper not initialized");
		this.initAdempiere = initAdempiere;
	}

	/**
	 * Final, because its called by a constructor.
	 */
	public final void init()
	{
		if (initialized)
		{
			return;
		}

		if (initAdempiere)
		{
			AdempiereTestHelper.get().init();
		}

		CachedHUAndItemsDAO.DEBUG = false;

		ctx = Env.getCtx();
		final ITrxManager trxManager = Services.get(ITrxManager.class);
		trxName = createAndStartTransaction();
		trxManager.setThreadInheritedTrxName(trxName);

		//
		// Setup context: #AD_Client_ID
		adClient = InterfaceWrapperHelper.create(ctx, I_AD_Client.class, ITrx.TRXNAME_None);
		InterfaceWrapperHelper.save(adClient);
		Env.setContext(ctx, Env.CTXNAME_AD_Client_ID, adClient.getAD_Client_ID());

		//
		// Setup context: #AD_Role_ID
		adRole = InterfaceWrapperHelper.create(ctx, I_AD_Role.class, ITrx.TRXNAME_None);
		adRole.setName("TestRole");
		InterfaceWrapperHelper.save(adRole);
		Env.setContext(ctx, Env.CTXNAME_AD_Role_ID, adRole.getAD_Role_ID());

		//
		// Setup context: #Date
		today = TimeUtil.getDay(2013, 11, 1);
		Env.setContext(ctx, Env.CTXNAME_Date, today);

		//
		// Setup module interceptors
		setupModuleInterceptors_HU();
		setupModuleInterceptors_InOutSchedule();

		//
		// Common used services
		trxBL = Services.get(IHUTrxBL.class);

		setupMasterData();

		huContext = createInitialHUContext(contextProvider);

		initialized = true;

		afterInitialized();
	}

	protected void afterInitialized()
	{
		// nothing here
	}

	/**
	 * Setup module interceptors: "de.metas.handlingunits" module
	 */
	protected void setupModuleInterceptors_HU()
	{
		setupModuleInterceptors_HU_Minimal();

		// NOTE: atm we cannot just register the model validator because there are some tests which are saving partial data
		// and we get NPE on many model validators
		// Suggestion: we shall register the model validator only for "Integration Tests" only
		// setupModuleInterceptors_HU_Full();
	}

	/**
	 * Setup module interceptors: "de.metas.handlingunits" module - Minimal (used by almost all tests)
	 */
	protected final void setupModuleInterceptors_HU_Minimal()
	{
		//
		// Handling units model validator
		new de.metas.handlingunits.model.validator.Main().registerFactories();

		final IModelInterceptorRegistry modelInterceptorRegistry = Services.get(IModelInterceptorRegistry.class);

		// We need to manually register M_Movement interceptor, else we won't get the packing material lines on movements
		modelInterceptorRegistry
				.addModelInterceptor(de.metas.handlingunits.model.validator.M_Movement.instance);
	}

	/**
	 * Setup module interceptors: "de.metas.handlingunits" module - FULL (interceptors, factories, etc), like in production (used by some integration tests)
	 */
	protected final void setupModuleInterceptors_HU_Full()
	{
		Services.get(IModelInterceptorRegistry.class)
				.addModelInterceptor(new de.metas.handlingunits.model.validator.Main());
	}

	/**
	 * Setup module interceptors: Receipt Schedule/Shipment Schedule
	 */
	protected final void setupModuleInterceptors_InOutSchedule()
	{
		//
		// Mimic ModelValidator behaviour
		Services.get(IModelInterceptorRegistry.class)
				.addModelInterceptor(ReceiptScheduleValidator.instance);
		InOutCandidateValidator.registerSSAggregationKeyDependencies();
	}

	/**
	 * Creates and starts database transaction
	 *
	 * @return trxName
	 */
	protected String createAndStartTransaction()
	{
		final String trxNamePrefix = "HUTest";
		return createAndStartTransaction(trxNamePrefix);
	}

	protected String createAndStartTransaction(final String trxNamePrefix)
	{
		final ITrxManager trxManager = Services.get(ITrxManager.class);
		final String trxName = trxManager.createTrxName(trxNamePrefix);
		return trxName;
	}

	protected IMutableHUContext createInitialHUContext(final IContextAware contextProvider)
	{
		return Services.get(IHandlingUnitsBL.class).createMutableHUContext(contextProvider);
	}

	public final void commitThreadInheritedTrx(final IHUContext huContext)
	{
		final ITrxManager trxManager = Services.get(ITrxManager.class);

		final String trxName = huContext.getTrxName();
		if (trxManager.isNull(trxName))
		{
			// nothing to do
			return;
		}

		try
		{
			final ITrx trx = trxManager.getTrx(trxName);
			trx.commit(true);
		}
		catch (final SQLException e)
		{
			throw new DBException("Error while commiting trx", e);
		}
	}

	/**
	 * Sets up all the nice fields this helper offers. Called by the {@link #init()} method.
	 */
	protected void setupMasterData()
	{
		uomEach = createUOM("Ea", X_C_UOM.UOMTYPE_Weigth, UOM_Precision_0);

		uomKg = createUOM("Kg", X_C_UOM.UOMTYPE_Weigth, UOM_Precision_3);
		uomKg.setX12DE355("KGM");
		InterfaceWrapperHelper.save(uomKg);

		uomPCE = createUOM("PCE", null, UOM_Precision_0);

		attr_CountryMadeIn = createM_Attribute(HUTestHelper.NAME_CountryMadeIn_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_List, true);
		createAttributeListValues(attr_CountryMadeIn,
				HUTestHelper.COUNTRYMADEIN_RO,
				HUTestHelper.COUNTRYMADEIN_DE,
				HUTestHelper.COUNTRYMADEIN_FR);

		attr_Volume = createM_Attribute(HUTestHelper.NAME_Volume_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, true);
		attr_FragileSticker = createM_Attribute(HUTestHelper.NAME_FragileSticker_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_StringMax40, false);

		attr_WeightGross = createM_Attribute(HUTestHelper.NAME_WeightGross_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, WeightGrossAttributeValueCallout.class, uomKg, true);
		attr_WeightNet = createM_Attribute(HUTestHelper.NAME_WeightNet_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, WeightNetAttributeValueCallout.class, uomKg, true);
		attr_WeightTare = createM_Attribute(HUTestHelper.NAME_WeightTare_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, WeightTareAttributeValueCallout.class, uomKg, true);
		attr_WeightTareAdjust = createM_Attribute(HUTestHelper.NAME_WeightTareAdjust_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, WeightTareAdjustAttributeValueCallout.class, uomKg, true);

		attr_CostPrice = createM_Attribute(Constants.ATTR_CostPrice, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, null, null, true);

		attr_QualityDiscountPercent = createM_Attribute(HUTestHelper.NAME_QualityDiscountPercent_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, true);
		attr_QualityNotice = createM_Attribute(HUTestHelper.NAME_QualityNotice_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_List, true);
		{
			//
			// Create values
			createAttributeListValue(attr_QualityNotice, QUALITYNOTICE_Test1, QUALITYNOTICE_Test1);
			createAttributeListValue(attr_QualityNotice, QUALITYNOTICE_Test2, QUALITYNOTICE_Test2);
			createAttributeListValue(attr_QualityNotice, QUALITYNOTICE_Test3, QUALITYNOTICE_Test3);
		}
		attr_SubProducerBPartner = createM_Attribute(HUTestHelper.NAME_SubProducerBPartner_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_StringMax40, true);

		attr_M_Material_Tracking_ID = createM_Attribute(HUTestHelper.NAME_M_Material_Tracking_ID_Attribute, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, true);

		attr_LotNumberDate = createM_Attribute(Constants.ATTR_LotNumberDate, X_M_Attribute.ATTRIBUTEVALUETYPE_Date, true);

		attr_LotNumber = createM_Attribute(LotNumberDateAttributeDAO.LotNumberAttribute, X_M_Attribute.ATTRIBUTEVALUETYPE_StringMax40, true);

		attr_PurchaseOrderLine = createM_Attribute(Constants.ATTR_PurchaseOrderLine_ID, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, true);
		attr_ReceiptInOutLine = createM_Attribute(Constants.ATTR_ReceiptInOutLine_ID, X_M_Attribute.ATTRIBUTEVALUETYPE_Number, true);

		// FIXME: this is a workaround because we are not handling the UOM conversions in our HU tests
		createUOMConversion(
				null,  // product,
				uomEach,  // uomFrom,
				uomKg, // uomTo,
				BigDecimal.ONE,
				BigDecimal.ONE);

		// Create 1-to-1 conversion between "Each" and PCE / Stk
		createUOMConversion(
				null,  // product,
				uomEach,  // uomFrom,
				uomPCE, // uomTo,
				BigDecimal.ONE,
				BigDecimal.ONE);

		//
		// Create and configure Pallete
		pPalet = createProduct(HUTestHelper.NAME_Palet_Product, uomEach, pPalet_Weight_25kg); // Pallets are our packing material
		pmPalet = createPackingMaterial("Palet-PM", pPalet);

		//
		// Create and configure IFCO
		pIFCO = createProduct(HUTestHelper.NAME_IFCO_Product, uomEach, pIFCO_Weight_1kg); // IFCOs are another kind of packing material
		pmIFCO = createPackingMaterial("IFCO-PM", pIFCO);

		//
		// Create and configure Bag
		pBag = createProduct(HUTestHelper.NAME_Bag_Product, uomEach, pBag_Weight_0_5Kg); // Bags are another kind of packing material
		pmBag = createPackingMaterial("Bag-PM", pBag);

		//
		// Create and configure Paloxe
		pPaloxe = createProduct(HUTestHelper.NAME_Paloxe_Product, uomEach, pPaloxe_Weight_75kg); // Paloxes are another kind of packing material
		pmPaloxe = createPackingMaterial("Paloxe-PM", pPaloxe);

		pTomato = createProduct(HUTestHelper.NAME_Tomato_Product, uomEach);
		pSalad = createProduct(HUTestHelper.NAME_Salad_Product, uomEach);

		//
		// No-PI
		huDefNone = createNoPI();

		//
		// Virtual PI
		huDefVirtual = createVirtualPI();

		setupNoPIAttributes();
		setupVirtualPIAttributes();
		setupEmptiesWarehouse();

		defaultWarehouse = createWarehouse(NAME_Default_Warehouse, false); // issueWarehouse
		issueWarehouse = createWarehouse(NAME_Issue_Warehouse, true);
	}

	protected void customInit()
	{
		// nothing
	}

	private I_M_HU_PI createNoPI()
	{
		final I_M_HU_PI huDefNone = InterfaceWrapperHelper.create(ctx, I_M_HU_PI.class, ITrx.TRXNAME_None);
		huDefNone.setName("NoPI");
		huDefNone.setM_HU_PI_ID(HandlingUnitsDAO.NO_HU_PI_ID);
		InterfaceWrapperHelper.save(huDefNone);

		final String huUnitType = null; // any
		createVersion(huDefNone, true, huUnitType, HandlingUnitsDAO.NO_HU_PI_Version_ID);

		huDefItemNone = createHU_PI_Item_Material(huDefNone, HandlingUnitsDAO.NO_HU_PI_Item_ID);
		huDefItemProductNone = assignProductAny(huDefItemNone, HUPIItemProductDAO.NO_HU_PI_Item_Product_ID);

		return huDefNone;
	}

	private I_M_HU_PI createVirtualPI()
	{
		final I_M_HU_PI huDefVirtual = InterfaceWrapperHelper.create(ctx, I_M_HU_PI.class, ITrx.TRXNAME_None);
		huDefVirtual.setName("VirtualPI");
		huDefVirtual.setM_HU_PI_ID(HandlingUnitsDAO.VIRTUAL_HU_PI_ID);
		InterfaceWrapperHelper.save(huDefVirtual);

		final String huUnitType = null; // any
		createVersion(huDefVirtual, true, huUnitType, HandlingUnitsDAO.VIRTUAL_HU_PI_Version_ID);

		huDefItemVirtual = createHU_PI_Item_Material(huDefVirtual, HandlingUnitsDAO.VIRTUAL_HU_PI_Item_ID);
		huDefItemProductVirtual = assignProductAny(huDefItemVirtual, HUPIItemProductDAO.VIRTUAL_HU_PI_Item_Product_ID);

		return huDefVirtual;
	}

	/**
	 * Create NoPI Attributes (i.e. template attributes)
	 */
	private void setupNoPIAttributes()
	{
		int piAttrSeqNo = 10;

		//
		// Weight Gross
		{
			final I_M_HU_PI_Attribute piAttr_WeightGross = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_WeightGross)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_NoPropagation));
			piAttr_WeightGross.setIsReadOnly(false);
			piAttr_WeightGross.setSeqNo(piAttrSeqNo);
			piAttr_WeightGross.setUseInASI(false);
			InterfaceWrapperHelper.save(piAttr_WeightGross);
			piAttrSeqNo += 10;
		}

		//
		// Weight Net
		{
			final I_M_HU_PI_Attribute piAttr_WeightNet = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_WeightNet)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_TopDown)
					.setSplitterStrategyClass(LinearDistributionAttributeSplitterStrategy.class)
					.setAggregationStrategyClass(SumAggregationStrategy.class)
					.setTransferStrategyClass(RedistributeQtyHUAttributeTransferStrategy.class));
			piAttr_WeightNet.setIsReadOnly(true);
			piAttr_WeightNet.setSeqNo(piAttrSeqNo);
			piAttr_WeightNet.setUseInASI(false);
			InterfaceWrapperHelper.save(piAttr_WeightNet);
			piAttrSeqNo += 10;
		}

		//
		// Weight Tare
		{
			final I_M_HU_PI_Attribute piAttr_WeightTare = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_WeightTare)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_BottomUp)
					.setAggregationStrategyClass(SumAggregationStrategy.class));
			piAttr_WeightTare.setIsReadOnly(true);
			piAttr_WeightTare.setSeqNo(piAttrSeqNo);
			piAttr_WeightTare.setUseInASI(false);
			InterfaceWrapperHelper.save(piAttr_WeightTare);
			piAttrSeqNo += 10;
		}

		//
		// Weight Tare Adjust
		{
			final I_M_HU_PI_Attribute piAttr_WeightTareAdjust = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_WeightTareAdjust)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_NoPropagation));
			piAttr_WeightTareAdjust.setIsReadOnly(true);
			piAttr_WeightTareAdjust.setSeqNo(piAttrSeqNo);
			piAttr_WeightTareAdjust.setUseInASI(false);
			InterfaceWrapperHelper.save(piAttr_WeightTareAdjust);
			piAttrSeqNo += 10;
		}

		//
		// Attributes used in ASI
		{
			final I_M_HU_PI_Attribute piAttr_CountryMadeIn = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_CountryMadeIn)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_TopDown));
			piAttr_CountryMadeIn.setIsReadOnly(true);
			piAttr_CountryMadeIn.setSeqNo(piAttrSeqNo);
			piAttr_CountryMadeIn.setUseInASI(true);
			InterfaceWrapperHelper.save(piAttr_CountryMadeIn);
			piAttrSeqNo += 10;
		}

		{
			final I_M_HU_PI_Attribute piAttr_FragileSticker = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_FragileSticker)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_BottomUp));
			piAttr_FragileSticker.setIsReadOnly(true);
			piAttr_FragileSticker.setSeqNo(piAttrSeqNo);
			piAttr_FragileSticker.setUseInASI(true);
			InterfaceWrapperHelper.save(piAttr_FragileSticker);
			piAttrSeqNo += 10;
		}

		{
			final I_M_HU_PI_Attribute piAttr_QualityDiscountPercent = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_QualityDiscountPercent)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_TopDown));
			piAttr_QualityDiscountPercent.setIsReadOnly(true);
			piAttr_QualityDiscountPercent.setSeqNo(piAttrSeqNo);
			piAttr_QualityDiscountPercent.setUseInASI(false);
			InterfaceWrapperHelper.save(piAttr_QualityDiscountPercent);
			piAttrSeqNo += 10;
		}

		{
			final I_M_HU_PI_Attribute piAttr_QualityNotice = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_QualityNotice)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_TopDown));
			piAttr_QualityNotice.setIsReadOnly(true);
			piAttr_QualityNotice.setSeqNo(piAttrSeqNo);
			piAttr_QualityNotice.setUseInASI(false);
			InterfaceWrapperHelper.save(piAttr_QualityNotice);
			piAttrSeqNo += 10;
		}

		{
			final I_M_HU_PI_Attribute piAttr_LotNumberDate = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_LotNumberDate)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_TopDown)
					.setSplitterStrategyClass(CopyAttributeSplitterStrategy.class)
					.setAggregationStrategyClass(NullAggregationStrategy.class)
					.setTransferStrategyClass(CopyHUAttributeTransferStrategy.class));
			piAttr_LotNumberDate.setIsReadOnly(false);
			piAttr_LotNumberDate.setSeqNo(piAttrSeqNo);
			piAttr_LotNumberDate.setUseInASI(true);
			InterfaceWrapperHelper.save(piAttr_LotNumberDate);
			piAttrSeqNo += 10;
		}

		// #653
		{
			final I_M_HU_PI_Attribute piAttr_LotNumber = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_LotNumber)
					.setM_HU_PI(huDefNone)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_TopDown)
					.setSplitterStrategyClass(CopyAttributeSplitterStrategy.class)
					.setAggregationStrategyClass(NullAggregationStrategy.class)
					.setTransferStrategyClass(CopyHUAttributeTransferStrategy.class));
			piAttr_LotNumber.setIsReadOnly(false);
			piAttr_LotNumber.setSeqNo(piAttrSeqNo);
			piAttr_LotNumber.setUseInASI(true);
			InterfaceWrapperHelper.save(piAttr_LotNumber);
			piAttrSeqNo += 10;
		}

		{
			final I_M_HU_PI_Attribute piAttr_PurchaseOrderLine = createM_HU_PI_Attribute(
					new HUPIAttributeBuilder(attr_PurchaseOrderLine)
							.setM_HU_PI(huDefNone)
							.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_TopDown)
							.setSplitterStrategyClass(CopyAttributeSplitterStrategy.class)
							.setAggregationStrategyClass(NullAggregationStrategy.class)
							.setTransferStrategyClass(CopyHUAttributeTransferStrategy.class));
			piAttr_PurchaseOrderLine.setIsReadOnly(true);
			piAttr_PurchaseOrderLine.setIsDisplayed(false);
			piAttr_PurchaseOrderLine.setSeqNo(piAttrSeqNo);
			piAttr_PurchaseOrderLine.setUseInASI(false);
			InterfaceWrapperHelper.save(piAttr_PurchaseOrderLine);
			piAttrSeqNo += 10;
		}

		{
			final I_M_HU_PI_Attribute piAttr_ReceiptInOutLine = createM_HU_PI_Attribute(
					new HUPIAttributeBuilder(attr_ReceiptInOutLine)
							.setM_HU_PI(huDefNone)
							.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_TopDown)
							.setSplitterStrategyClass(CopyAttributeSplitterStrategy.class)
							.setAggregationStrategyClass(NullAggregationStrategy.class)
							.setTransferStrategyClass(CopyHUAttributeTransferStrategy.class));
			piAttr_ReceiptInOutLine.setIsReadOnly(true);
			piAttr_ReceiptInOutLine.setIsDisplayed(false);
			piAttr_ReceiptInOutLine.setSeqNo(piAttrSeqNo);
			piAttr_ReceiptInOutLine.setUseInASI(false);
			InterfaceWrapperHelper.save(piAttr_ReceiptInOutLine);
			piAttrSeqNo += 10;
		}

	}

	private void setupVirtualPIAttributes()
	{
		int piAttrSeqNo = 10;

		//
		// CostPrice
		{
			huDefVirtual_Attr_CostPrice = createM_HU_PI_Attribute(new HUPIAttributeBuilder(attr_CostPrice)
					.setM_HU_PI(huDefVirtual)
					.setPropagationType(X_M_HU_PI_Attribute.PROPAGATIONTYPE_NoPropagation)
					.setSplitterStrategyClass(NullSplitterStrategy.class)
					.setAggregationStrategyClass(NullAggregationStrategy.class)
					.setTransferStrategyClass(CopyHUAttributeTransferStrategy.class));
			huDefVirtual_Attr_CostPrice.setIsReadOnly(true);
			huDefVirtual_Attr_CostPrice.setSeqNo(piAttrSeqNo);
			huDefVirtual_Attr_CostPrice.setUseInASI(false);
			InterfaceWrapperHelper.save(huDefVirtual_Attr_CostPrice);
			piAttrSeqNo += 10;
		}
	}

	private void setupEmptiesWarehouse()
	{
		final PlainContextAware context = PlainContextAware.newOutOfTrx(getCtx());

		warehouse_Empties = createWarehouse("Empties warehouse");

		final I_C_BPartner emptiesShipperBP = createBPartner("Empties Shipper BPartner");
		final I_M_Shipper emptiesShipper = InterfaceWrapperHelper.newInstance(I_M_Shipper.class, context);
		emptiesShipper.setName("Empties shipper");
		emptiesShipper.setC_BPartner_ID(emptiesShipperBP.getC_BPartner_ID());
		InterfaceWrapperHelper.save(emptiesShipper);

		emptiesDDNetworkBuilder = new DDNetworkBuilder()
				.setContext(context)
				.name("Empties distribution network")
				.shipper(emptiesShipper);

		final I_DD_NetworkDistribution emptiesDDNetwork = emptiesDDNetworkBuilder.getDD_NetworkDistribution(I_DD_NetworkDistribution.class);
		emptiesDDNetwork.setIsHUDestroyed(true);
		InterfaceWrapperHelper.save(emptiesDDNetwork);
	}

	/**
	 * Creates a link between given warehouse and empties warehouse
	 *
	 * @param warehouse
	 * @see IHandlingUnitsBL#getEmptiesWarehouse(Properties, org.compiere.model.I_M_Warehouse, String)
	 */
	public void addEmptiesNetworkLine(final org.compiere.model.I_M_Warehouse warehouse)
	{
		emptiesDDNetworkBuilder.createDDNetworkLine(warehouse, warehouse_Empties);
	}

	public Properties getCtx()
	{
		return ctx;
	}

	public IContextAware getContextProvider()
	{
		return contextProvider;
	}

	public IMutableHUContext getHUContext()
	{
		return huContext;
	}

	public IMutableHUContext createMutableHUContextForProcessing(final String trxName)
	{
		final IContextAware contextProvider = PlainContextAware.newWithTrxName(ctx, trxName);
		return Services.get(IHandlingUnitsBL.class).createMutableHUContextForProcessing(contextProvider);
	}

	/**
	 * Creates an {@link IMutableHUContext} based on {@link #getContextProvider()}.
	 *
	 * @return
	 */
	public IMutableHUContext createMutableHUContext()
	{
		return Services.get(IHandlingUnitsBL.class).createMutableHUContext(getContextProvider());
	}

	public IMutableHUContext createMutableHUContextOutOfTransaction()
	{
		return Services.get(IHandlingUnitsBL.class).createMutableHUContext(ctx, ITrx.TRXNAME_None);
	}

	public IMutableHUContext createMutableHUContextInNewTransaction()
	{
		final String trxName = createAndStartTransaction("HUTestHelper_createMutableHUContextInNewTransaction");
		return Services.get(IHandlingUnitsBL.class).createMutableHUContext(ctx, trxName);
	}

	public Date getTodayDate()
	{
		return today;
	}

	public Timestamp getTodayTimestamp()
	{
		return today;
	}

	public I_C_UOM createUOM(final String name, final String uomType, final int stdPrecision)
	{
		final I_C_UOM uom = createUOM(name, stdPrecision, 0);
		uom.setUOMType(uomType);

		InterfaceWrapperHelper.save(uom);
		return uom;
	}

	public I_C_UOM createUOM(final String name, final int stdPrecision, final int costingPrecission)
	{
		final I_C_UOM uom = createUOM(name);
		uom.setStdPrecision(stdPrecision);
		uom.setCostingPrecision(costingPrecission);
		InterfaceWrapperHelper.save(uom);
		return uom;
	}

	public I_C_UOM createUOM(final String name)
	{
		final String x12de355 = name;
		return createUOM(name, x12de355);
	}

	public I_C_UOM createUOM(final String name, final String x12de355)
	{
		final I_C_UOM uom = InterfaceWrapperHelper.create(ctx, I_C_UOM.class, ITrx.TRXNAME_None);
		uom.setName(name);
		uom.setUOMSymbol(name);
		uom.setX12DE355(x12de355);

		InterfaceWrapperHelper.save(uom);

		return uom;
	}

	public I_C_UOM_Conversion createUOMConversion(
			final I_M_Product product,
			final I_C_UOM uomFrom,
			final I_C_UOM uomTo,
			final BigDecimal multiplyRate,
			final BigDecimal divideRate)
	{
		final I_C_UOM_Conversion conversion = InterfaceWrapperHelper.create(Env.getCtx(), I_C_UOM_Conversion.class, ITrx.TRXNAME_None);

		if (product != null)
		{
			conversion.setM_Product_ID(product.getM_Product_ID());
		}
		conversion.setC_UOM_ID(uomFrom.getC_UOM_ID());
		conversion.setC_UOM_To_ID(uomTo.getC_UOM_ID());
		conversion.setMultiplyRate(multiplyRate);
		conversion.setDivideRate(divideRate);

		InterfaceWrapperHelper.save(conversion, ITrx.TRXNAME_None);

		return conversion;
	}

	/**
	 *
	 * @param name
	 * @param uom
	 * @param weightKg product weight (Kg); mainly used for packing materials
	 * @return
	 */
	public I_M_Product createProduct(final String name, final I_C_UOM uom, final BigDecimal weightKg)
	{
		final I_M_Product product = InterfaceWrapperHelper.create(ctx, I_M_Product.class, ITrx.TRXNAME_None);
		product.setValue(name);
		product.setName(name);
		product.setC_UOM_ID(uom.getC_UOM_ID());
		if (weightKg != null)
		{
			product.setWeight(weightKg);
		}
		InterfaceWrapperHelper.save(product);

		return product;
	}

	public I_M_Product createProduct(final String name, final I_C_UOM uom)
	{
		final BigDecimal weightKg = null; // N/A
		return createProduct(name, uom, weightKg);
	}

	public I_M_HU_PackingMaterial createPackingMaterial(final String name, final I_M_Product product)
	{
		final I_M_HU_PackingMaterial packingMaterial = InterfaceWrapperHelper.create(ctx, I_M_HU_PackingMaterial.class, ITrx.TRXNAME_None);
		packingMaterial.setName(name);
		packingMaterial.setM_Product(product);
		InterfaceWrapperHelper.save(packingMaterial);

		return packingMaterial;
	}

	public I_M_HU_PI createHUDefinition(final String name)
	{
		final String huUnitType = null;
		return createHUDefinition(name, huUnitType);
	}

	public I_M_HU_PI createHUDefinition(final String name, final String huUnitType)
	{
		final I_M_HU_PI pi = InterfaceWrapperHelper.create(ctx, I_M_HU_PI.class, ITrx.TRXNAME_None);
		pi.setName(name);
		InterfaceWrapperHelper.save(pi);

		// // Create some several dummy versions
		// createVersion(hu, false);
		// createVersion(hu, false);

		// Create the current version
		final Integer huPIVersionId = null;
		createVersion(pi, true, huUnitType, huPIVersionId);

		return pi;
	}

	public I_M_HU_PI_Version createVersion(final I_M_HU_PI handlingUnit, final boolean current)
	{
		final String huUnitType = null;
		final Integer huPIVersionId = null;
		return createVersion(handlingUnit, current, huUnitType, huPIVersionId);
	}

	private I_M_HU_PI_Version createVersion(final I_M_HU_PI pi, final boolean current, final String huUnitType, final Integer huPIVersionId)
	{
		final I_M_HU_PI_Version version = InterfaceWrapperHelper.create(ctx, I_M_HU_PI_Version.class, ITrx.TRXNAME_None);
		version.setName(pi.getName());
		version.setM_HU_PI(pi);
		version.setIsCurrent(current);
		if (huUnitType != null)
		{
			version.setHU_UnitType(huUnitType);
		}
		if (huPIVersionId != null)
		{
			version.setM_HU_PI_Version_ID(huPIVersionId);
		}
		InterfaceWrapperHelper.save(version);
		return version;
	}

	public static final BigDecimal QTY_NA = null;

	public I_M_HU_PI_Item createHU_PI_Item_Material(final I_M_HU_PI pi)
	{
		final int piItemId = -1;
		return createHU_PI_Item_Material(pi, piItemId);
	}

	public I_M_HU_PI_Item createHU_PI_Item_Material(final I_M_HU_PI pi, final int piItemId)
	{
		final I_M_HU_PI_Version version = Services.get(IHandlingUnitsDAO.class).retrievePICurrentVersion(pi);

		final I_M_HU_PI_Item piItem = InterfaceWrapperHelper.newInstance(I_M_HU_PI_Item.class, version);
		piItem.setItemType(X_M_HU_PI_Item.ITEMTYPE_Material);
		piItem.setM_HU_PI_Version(version);
		if (piItemId > 0)
		{
			piItem.setM_HU_PI_Item_ID(piItemId);
		}

		InterfaceWrapperHelper.save(piItem);
		return piItem;
	}

	/**
	 * Invokes {@link #createHU_PI_Item_IncludedHU(I_M_HU_PI, I_M_HU_PI, BigDecimal, I_C_BPartner)} with bPartner being {@code null}.
	 * 
	 * @param huDefinition
	 * @param includedHuDefinition
	 * @param qty
	 * @return
	 */
	public I_M_HU_PI_Item createHU_PI_Item_IncludedHU(final I_M_HU_PI huDefinition,
			final I_M_HU_PI includedHuDefinition,
			final BigDecimal qty)
	{
		final I_C_BPartner bpartner = null;
		return createHU_PI_Item_IncludedHU(huDefinition, includedHuDefinition, qty, bpartner);
	}

	/**
	 * Creates an {@link I_M_HU_PI_Item} with the given {@code qty} ("capacity") and {@code pPartner}<br>
	 * and links it with the given {@code huDefinition} and {@code includedHuDefinition}.
	 * 
	 * @param huDefinition
	 * @param includedHuDefinition
	 * @param qty
	 * @param bPartner
	 * @return
	 */
	public I_M_HU_PI_Item createHU_PI_Item_IncludedHU(final I_M_HU_PI huDefinition,
			final I_M_HU_PI includedHuDefinition,
			final BigDecimal qty,
			final I_C_BPartner bPartner)
	{
		final I_M_HU_PI_Version version = Services.get(IHandlingUnitsDAO.class).retrievePICurrentVersion(huDefinition);

		final I_M_HU_PI_Item itemDefinition = InterfaceWrapperHelper.newInstance(I_M_HU_PI_Item.class, version);
		itemDefinition.setItemType(X_M_HU_PI_Item.ITEMTYPE_HandlingUnit);
		itemDefinition.setIncluded_HU_PI(includedHuDefinition);
		itemDefinition.setM_HU_PI_Version(version);
		itemDefinition.setC_BPartner(bPartner);
		if (!Objects.equals(qty, QTY_NA))
		{
			itemDefinition.setQty(qty);
		}

		InterfaceWrapperHelper.save(itemDefinition);
		return itemDefinition;
	}

	/**
	 * 
	 * @param huDefinition
	 * @param huPackingMaterial
	 * @return
	 */
	public I_M_HU_PI_Item createHU_PI_Item_PackingMaterial(final I_M_HU_PI huDefinition, final I_M_HU_PackingMaterial huPackingMaterial)
	{
		Check.assumeNotNull(huDefinition, "Parameter huDefinition is not null");
		Check.assumeNotNull(huPackingMaterial, "Parameter pmProduct is not null");
		final I_M_HU_PI_Version version = Services.get(IHandlingUnitsDAO.class).retrievePICurrentVersion(huDefinition);

		final I_M_HU_PI_Item piItem = InterfaceWrapperHelper.newInstance(I_M_HU_PI_Item.class, version);
		piItem.setM_HU_PI_Version(version);

		piItem.setItemType(X_M_HU_PI_Item.ITEMTYPE_PackingMaterial);
		piItem.setM_HU_PackingMaterial(huPackingMaterial);
		piItem.setQty(BigDecimal.ONE);

		InterfaceWrapperHelper.save(piItem);
		return piItem;
	}

	public I_M_HU_PI_Item_Product assignProduct(final I_M_HU_PI_Item itemPI, final I_M_Product product, final BigDecimal qty, final I_C_UOM uom)
	{
		final I_C_BPartner bpartner = null;
		return assignProduct(itemPI, product, qty, uom, bpartner);
	}

	public I_M_HU_PI_Item_Product assignProduct(final I_M_HU_PI_Item itemPI, final I_M_Product product, final BigDecimal qty, final I_C_UOM uom, final I_C_BPartner bpartner)
	{
		Check.errorUnless(Objects.equals(itemPI.getItemType(), X_M_HU_PI_Item.ITEMTYPE_Material), "Param 'itemPI' needs to have ItemType={}, not={}; itemPI={} material item", X_M_HU_PI_Item.ITEMTYPE_Material, itemPI.getItemType(), itemPI);

		final I_M_HU_PI_Item_Product itemDefProduct = InterfaceWrapperHelper.newInstance(I_M_HU_PI_Item_Product.class, itemPI);
		itemDefProduct.setM_HU_PI_Item(itemPI);
		itemDefProduct.setM_Product(product);
		itemDefProduct.setQty(qty);
		itemDefProduct.setC_UOM(uom);
		itemDefProduct.setValidFrom(TimeUtil.getDay(1970, 1, 1));
		itemDefProduct.setC_BPartner(bpartner);
		InterfaceWrapperHelper.save(itemDefProduct);
		return itemDefProduct;
	}

	public I_M_HU_PI_Item_Product assignProductAny(final I_M_HU_PI_Item itemPI, final int huPIItemProductId)
	{
		final I_M_HU_PI_Item_Product itemDefProduct = InterfaceWrapperHelper.newInstance(I_M_HU_PI_Item_Product.class, itemPI);
		itemDefProduct.setM_HU_PI_Item(itemPI);

		itemDefProduct.setIsAllowAnyProduct(true);
		itemDefProduct.setM_Product(null);

		itemDefProduct.setIsInfiniteCapacity(true);
		itemDefProduct.setQty(null);
		itemDefProduct.setC_UOM(null);

		itemDefProduct.setValidFrom(TimeUtil.getDay(1970, 1, 1));

		if (huPIItemProductId > 0)
		{
			itemDefProduct.setM_HU_PI_Item_Product_ID(huPIItemProductId);
		}

		InterfaceWrapperHelper.save(itemDefProduct);
		return itemDefProduct;
	}

	public I_M_Transaction createMTransaction(final String movementType, final I_M_Product product, final BigDecimal qty)
	{
		final I_M_Transaction mtrx = InterfaceWrapperHelper.newInstance(I_M_Transaction.class, contextProvider);
		mtrx.setM_Product_ID(product.getM_Product_ID());
		mtrx.setMovementQty(qty);
		mtrx.setMovementType(movementType);
		mtrx.setMovementDate(getTodayTimestamp());
		InterfaceWrapperHelper.save(mtrx);
		return mtrx;
	}

	public I_M_Transaction createMTransactionReversal(final I_M_Transaction mtrx)
	{
		final I_M_Transaction mtrxReversal = InterfaceWrapperHelper.newInstance(I_M_Transaction.class, mtrx);
		InterfaceWrapperHelper.copyValues(mtrx, mtrxReversal, false); // honorIsCalculated=false, else we get an exception
		mtrxReversal.setMovementQty(mtrx.getMovementQty().negate());
		InterfaceWrapperHelper.save(mtrxReversal);
		return mtrxReversal;
	}

	protected HUListAssertsBuilder assertHUList(final String name, final List<I_M_HU> list)
	{
		return new HUListAssertsBuilder(null, name, list);
	}

	public I_M_Attribute createM_Attribute(final String name,
			final String valueType,
			final boolean isInstanceAttribute)
	{
		final Class<?> javaClass = null;
		final I_M_Attribute attr = createM_Attribute(name, valueType, javaClass, isInstanceAttribute);
		InterfaceWrapperHelper.save(attr);

		return attr;
	}

	public I_M_Attribute createM_Attribute(final String name,
			final String valueType,
			final Class<?> javaClass,
			final boolean isInstanceAttribute)
	{
		final I_C_UOM uom = null;
		return createM_Attribute(name, valueType, javaClass, uom, isInstanceAttribute);
	}

	public I_M_Attribute createM_Attribute(final String name,
			final String valueType,
			final Class<?> javaClass,
			final I_C_UOM uom,
			final boolean isInstanceAttribute)
	{

		// make sure the attribute was not already defined
		final I_M_Attribute existingAttribute = retrieveAttributeBuValue(name);

		final I_AD_JavaClass javaClassDef;
		if (javaClass != null)
		{
			javaClassDef = InterfaceWrapperHelper.newInstance(I_AD_JavaClass.class, contextProvider);
			javaClassDef.setName(javaClass.getName());
			javaClassDef.setClassname(javaClass.getName());
			InterfaceWrapperHelper.save(javaClassDef);
		}
		else
		{
			javaClassDef = null;
		}

		final I_M_Attribute attr;

		if (existingAttribute != null)
		{
			attr = existingAttribute;
		}

		else
		{
			attr = InterfaceWrapperHelper.newInstance(I_M_Attribute.class, contextProvider);
		}
		attr.setValue(name);
		attr.setName(name);
		attr.setAttributeValueType(valueType);

		//
		// Assume all attributes active and non-mandatory
		attr.setIsActive(true);
		attr.setIsMandatory(false);

		//
		// Configure ASI usage
		attr.setIsInstanceAttribute(isInstanceAttribute);

		//
		// Configure JC
		attr.setAD_JavaClass(javaClassDef);

		//
		// Configure UOM
		attr.setC_UOM(uom);

		InterfaceWrapperHelper.save(attr);
		return attr;
	}

	/**
	 * Method needed to make sure the attribute was not already created
	 * Normally, this will never happen anywhere else except testing
	 * 
	 * @param name
	 * @return
	 */
	private I_M_Attribute retrieveAttributeBuValue(String name)
	{
		return Services.get(IQueryBL.class)
				.createQueryBuilder(I_M_Attribute.class, ctx, ITrx.TRXNAME_None).addOnlyActiveRecordsFilter()
				.addEqualsFilter(I_M_Attribute.COLUMNNAME_Value, name)
				.create()
				.firstOnly(I_M_Attribute.class);
	}

	/**
	 * Create an {@link I_M_HU_Attribute} for the given {@link HUPIAttributeBuilder}.
	 *
	 * @param attributeBuilder
	 * @return {@link I_M_HU_Attribute} created by the builder
	 */
	public I_M_HU_PI_Attribute createM_HU_PI_Attribute(final HUPIAttributeBuilder attributeBuilder)
	{
		return attributeBuilder.create(ctx);
	}

	public void setAttributeValue(final I_M_HU hu, final I_M_Attribute attribute, final Object value)
	{
		final IAttributeStorageFactory storageFactory = getHUContext().getHUAttributeStorageFactory();
		final IAttributeStorage attributes = storageFactory.getAttributeStorage(hu);
		attributes.setValue(attribute, value);
	}

	public void createAttributeListValues(final org.compiere.model.I_M_Attribute attribute, final String... values)
	{
		for (final String value : values)
		{
			final String name = "Name_" + value;
			createAttributeListValue(attribute, value, name);
		}
	}

	public void createAttributeListValue(final org.compiere.model.I_M_Attribute attribute, final String value, final String name)
	{
		final I_M_AttributeValue alv = InterfaceWrapperHelper.newInstance(I_M_AttributeValue.class, attribute);
		alv.setM_Attribute_ID(attribute.getM_Attribute_ID());
		alv.setValue(value);
		alv.setName(name);
		InterfaceWrapperHelper.save(alv);
	}

	public IAttributeValue createAttributeValue(final org.compiere.model.I_M_Attribute attribute, final Object value)
	{
		final IAttributeValue av = new PlainAttributeValue(NullAttributeStorage.instance, attribute);
		av.setValue(new HUAttributePropagationContext(NullAttributeStorage.instance, new NoPropagationHUAttributePropagator(), attribute), value);
		return av;
	}

	public IAttributeStorage createAttributeSetStorage(final IAttributeValue... attributeValues)
	{
		final List<IAttributeValue> list = Arrays.asList(attributeValues);
		final IAttributeStorageFactory attributeStorageFactory = getHUContext().getHUAttributeStorageFactory();
		return new ListAttributeStorage(attributeStorageFactory, list);
	}

	public Object createDummyReferenceModel()
	{
		final I_C_BPartner bpartner = null;
		return createDummyReferenceModel(bpartner);
	}

	public Object createDummyReferenceModel(final I_C_BPartner bpartner)
	{
		final I_Test referencedModel = InterfaceWrapperHelper.newInstance(I_Test.class, contextProvider);

		if (bpartner != null)
		{
			referencedModel.setC_BPartner_ID(bpartner.getC_BPartner_ID());
		}

		InterfaceWrapperHelper.save(referencedModel);
		return referencedModel;

	}

	public AbstractAllocationSourceDestination createDummySourceDestination(
			final I_M_Product product,
			final BigDecimal qtyCapacity,
			final boolean fullyLoaded)
	{
		return createDummySourceDestination(product, qtyCapacity, uomEach, fullyLoaded);
	}

	public AbstractAllocationSourceDestination createDummySourceDestination(
			final I_M_Product product,
			final BigDecimal qtyCapacity,
			final I_C_UOM uom,
			final boolean fullyLoaded)
	{
		final IHUCapacityDefinition capacity = Services.get(IHUCapacityBL.class).createCapacity(
				qtyCapacity,
				product,
				uom,
				false // allowNegativeCapacity
		);
		final BigDecimal qtyInitial = fullyLoaded ? qtyCapacity : BigDecimal.ZERO;
		final PlainProductStorage storage = new PlainProductStorage(capacity, qtyInitial);

		final Object referencedModel = createDummyReferenceModel();
		return new GenericAllocationSourceDestination(storage, referencedModel);
	}

	/**
	 * Create HUs using {@link HUProducerDestination}.
	 *
	 * @param huPI
	 * @param productToLoad
	 * @param qtyToLoad
	 * @param qtyToLoadUOM
	 * @return created HUs
	 */
	public List<I_M_HU> createHUs(
			final IHUContext huContext,
			final I_M_HU_PI huPI,
			final I_M_Product productToLoad,
			final BigDecimal qtyToLoad,
			final I_C_UOM qtyToLoadUOM)
	{
		final IAllocationSource source = createDummySourceDestination(productToLoad,
				new BigDecimal("100000000"),  // qtyCapacity
				qtyToLoadUOM,  // UOM
				true // fullyLoaded => empty
		);

		final HUProducerDestination destination = new HUProducerDestination(huPI);

		final HULoader loader = new HULoader(source, destination);

		final Object referenceModel = null;
		final IAllocationRequest request = AllocationUtils.createQtyRequest(
				huContext,
				productToLoad,
				qtyToLoad,
				qtyToLoadUOM,
				getTodayDate(),  // date
				referenceModel);

		loader.load(request);

		return destination.getCreatedHUs();
	}

	/**
	 * Generate HUs for given Customer Unit qty
	 *
	 * @param huContext
	 * @param allocationDestination
	 * @param cuQty
	 * @return created HUs
	 */
	public List<I_M_HU> createHUs(
			final IHUContext huContext,
			final ILUTUProducerAllocationDestination allocationDestination,
			final BigDecimal cuQty)
	{
		final IHUCapacityDefinition tuCapacity = allocationDestination.getTUCapacity();
		final I_M_Product cuProduct = tuCapacity.getM_Product();
		final I_C_UOM cuUOM = tuCapacity.getC_UOM();

		final AbstractAllocationSourceDestination allocationSource = createDummySourceDestination(cuProduct,
				IHUCapacityDefinition.INFINITY,
				cuProduct.getC_UOM(),
				true // fullyLoaded
		);
		final Object referencedModel = allocationSource.getReferenceModel();

		final IAllocationRequest request = AllocationUtils.createQtyRequest(huContext,
				cuProduct,
				cuQty,
				cuUOM,
				getTodayDate(),
				referencedModel);

		//
		// Execute transfer => HUs will be generated
		final HULoader loader = new HULoader(allocationSource, allocationDestination);
		final IAllocationResult result = loader.load(request);
		Assert.assertTrue("Result shall be completed: " + result, result.isCompleted());

		//
		// Get generated HUs and set them to HUContext's transaction
		// NOTE: we do this because in case we were processing out of transaction then an internal transaction will be created
		// and those HUs will be returned using internal trx
		final List<I_M_HU> hus = allocationDestination.getCreatedHUs();
		for (final I_M_HU hu : hus)
		{
			InterfaceWrapperHelper.setTrxName(hu, huContext.getTrxName());
		}
		return hus;
	}

	public List<I_M_HU> createLUs(final IHUContext huContext,
			final I_M_HU_PI_Item loadingUnitPIItem,
			final I_M_HU_PI_Item_Product tuPIItemProduct,
			final BigDecimal totalQtyCU)
	{
		final I_C_BPartner bpartner = null;
		final int bpartnerLocationId = -1;
		final I_M_Product cuProduct = tuPIItemProduct.getM_Product();
		final I_C_UOM cuUOM = tuPIItemProduct.getC_UOM();

		final ILUTUConfigurationFactory lutuConfigurationFactory = Services.get(ILUTUConfigurationFactory.class);
		final I_M_HU_LUTU_Configuration lutuConfiguration = lutuConfigurationFactory.createLUTUConfiguration(tuPIItemProduct, cuProduct, cuUOM, bpartner);
		lutuConfiguration.setC_BPartner(bpartner);
		lutuConfiguration.setC_BPartner_Location_ID(bpartnerLocationId);
		lutuConfigurationFactory.save(lutuConfiguration);

		final ILUTUProducerAllocationDestination luProducerDestination = lutuConfigurationFactory.createLUTUProducerAllocationDestination(lutuConfiguration);
		luProducerDestination.setLUPI(loadingUnitPIItem.getM_HU_PI_Version().getM_HU_PI());
		luProducerDestination.setLUItemPI(loadingUnitPIItem);
		luProducerDestination.setMaxLUsInfinite(); // allow creating as much LUs as needed

		//
		// Create LUs
		final List<I_M_HU> luHUs = createHUs(huContext, luProducerDestination, totalQtyCU);
		return luHUs;
	}

	public I_M_HU createLU(final IHUContext huContext,
			final I_M_HU_PI_Item loadingUnitPIItem,
			final I_M_HU_PI_Item_Product tuPIItemProduct,
			final BigDecimal totalQtyCU)
	{
		final List<I_M_HU> luHUs = createLUs(huContext, loadingUnitPIItem, tuPIItemProduct, totalQtyCU);
		if (luHUs.isEmpty())
		{
			throw new IllegalStateException("We expected only one LU but we got none");
		}
		else if (luHUs.size() == 1)
		{
			return luHUs.get(0);
		}
		else
		{
			throw new IllegalStateException("We exected only one LU  but we got " + luHUs.size() + ": " + luHUs);
		}
	}

	public List<I_M_HU> retrieveAllHandlingUnits()
	{
		final IQueryBuilder<I_M_HU> queryBuilder = Services.get(IQueryBL.class)
				.createQueryBuilder(I_M_HU.class, contextProvider);

		queryBuilder.orderBy()
				.addColumn(I_M_HU.COLUMNNAME_M_HU_ID);

		return queryBuilder
				.create()
				.list(I_M_HU.class);
	}

	public List<I_M_HU> retrieveAllHandlingUnitsOfType(final I_M_HU_PI huPI)
	{
		final List<I_M_HU> result = new ArrayList<I_M_HU>();

		// Filter
		for (final I_M_HU hu : retrieveAllHandlingUnits())
		{
			if (hu.getM_HU_PI_Version().getM_HU_PI_ID() != huPI.getM_HU_PI_ID())
			{
				continue;
			}

			result.add(hu);
		}

		return result;
	}

	/**
	 * Take the given {@code lutuProducer} and load the given {@code loadCuQty} and {@code loadCuUOM} of the given {@code cuProduct} into new HUs.
	 * <p>
	 * You can use {@link LUTUProducerDestination#getCreatedHUs()} to collect the results after the loading.
	 * 
	 * @param lutuProducer used as the loader's {@link IAllocationDestination}
	 * @param cuProduct
	 * @param loadCuQty
	 * @param loadCuUOM
	 */
	public final void load(
			final LUTUProducerDestination lutuProducer,
			final I_M_Product cuProduct,
			final BigDecimal loadCuQty,
			final I_C_UOM loadCuUOM)
	{
		final IAllocationSource source = createDummySourceDestination(cuProduct, IHUCapacityDefinition.INFINITY, loadCuUOM, true);

		final HULoader huLoader = new HULoader(source, lutuProducer);
		huLoader.setAllowPartialUnloads(false);
		huLoader.setAllowPartialLoads(false);

		final IMutableHUContext huContext0 = createMutableHUContextOutOfTransaction();
		final IAllocationRequest request = AllocationUtils.createQtyRequest(huContext0,
				cuProduct, // product
				loadCuQty, // qty
				loadCuUOM, // uom
				SystemTime.asTimestamp());

		huLoader.load(request);
	}

	/**
	 * Creates LUs with TUs and loads the products from the given {@code mtrx} into them.<br>
	 * <b>Important:</b> only works if the given {@code huPI} has exactly one HU PI-item for the TU.
	 * 
	 * This method contains the code that used to be in {@link IHUTrxBL} {@code transferIncomingToHUs()}.<br>
	 * When it was there, that method was used only by test cases and also doesn't make a lot of sense for production.
	 * 
	 * @param mtrx the load's source. Also provides the context.
	 * @param huPI a "simple" PI that contains one HU-item which links to one child-HU PI
	 * @return
	 */
	public List<I_M_HU> createHUsFromSimplePI(final I_M_Transaction mtrx, final I_M_HU_PI huPI)
	{
		Check.assume(Services.get(IMTransactionBL.class).isInboundTransaction(mtrx),
				"mtrx shall be inbound transaction: {}", mtrx);

		final IContextAware contextProvider = InterfaceWrapperHelper.getContextAware(mtrx);
		final IMutableHUContext huContext = Services.get(IHandlingUnitsBL.class).createMutableHUContext(contextProvider);

		final IAllocationSource source = new MTransactionAllocationSourceDestination(mtrx);
		// final HUProducerDestination destination = new HUProducerDestination(huPI);

		final LUTUProducerDestination lutuProducer = new LUTUProducerDestination();
		lutuProducer.setLUPI(huPI);

		final IHandlingUnitsDAO handlingUnitsDAO = Services.get(IHandlingUnitsDAO.class);
		final I_M_HU_PI_Version currentPIVersion = handlingUnitsDAO.retrievePICurrentVersion(huPI);
		final List<I_M_HU_PI_Item> piItemsForChildHU = handlingUnitsDAO.retrievePIItems(currentPIVersion, null).stream()
				.filter(piItem -> Objects.equals(X_M_HU_PI_Item.ITEMTYPE_HandlingUnit, piItem.getItemType()))
				.collect(Collectors.toList());
		assertThat("This method only works if the given 'huPI' has exactly one child-HU item", piItemsForChildHU.size(), is(1));

		lutuProducer.setLUItemPI(piItemsForChildHU.get(0));
		lutuProducer.setTUPI(piItemsForChildHU.get(0).getIncluded_HU_PI());

		final HULoader loader = new HULoader(source, lutuProducer);

		final I_C_UOM uom = Services.get(IHandlingUnitsBL.class).getC_UOM(mtrx);
		final IAllocationRequest request = AllocationUtils.createQtyRequest(
				huContext,
				mtrx.getM_Product(),
				mtrx.getMovementQty(),
				uom, mtrx.getMovementDate(),
				mtrx);

		loader.load(request);

		return lutuProducer.getCreatedHUs();
	}
	
	/**
	 * Sets up a {@link HUListAllocationSourceDestination} for the given {@code sourceHUs} and loads them to the given {@code lutuProducer}.
	 * <p>
	 * You can use {@link LUTUProducerDestination#getCreatedHUs()} to collect the results after the loading.
	 * Note that this method does less than {@link IHUSplitBuilder}. E.g. it does not:
	 * <li>propagate the source HUs' Locator, Status etc
	 * <li>destroy empty source HUs
	 * 
	 * @param sourceHUs
	 * @param lutuProducer used as the loader's {@link IAllocationDestination}
	 * @param qty
	 * @param product
	 * @param uom
	 * @return
	 */
	public void transferMaterialToNewHUs(final List<I_M_HU> sourceHUs,
			final LUTUProducerDestination lutuProducer,
			final BigDecimal qty,
			final I_M_Product product,
			final I_C_UOM uom)
	{
		Check.assume(Adempiere.isUnitTestMode(), "This method shall be executed only in JUnit test mode");

		final IMutableHUContext huContext = getHUContext();
		final Date date = Env.getContextAsDate(Env.getCtx(), "#Date"); // FIXME use context date for now

		final IAllocationSource source = new HUListAllocationSourceDestination(sourceHUs);

		final HULoader loader = new HULoader(source, lutuProducer);

		// allowing partial loads and unloads because that's interesting cases to test
		loader.setAllowPartialUnloads(true);
		loader.setAllowPartialLoads(true);

		final IAllocationRequest request = AllocationUtils.createQtyRequest(huContext, product, qty, uom, date);

		loader.load(request); // use context date for now
	}

	/**
	 * This method creates one or many new HU(s) by "taking" the given product and qty out of the given source HU(s). The source HU's items are modified in this process. It also creates a
	 * {@link I_M_HU_Trx_Hdr} to document from which source items (of <code>sourceHU</code>) to which destination items (of the new HU) the qtys were moved. That trx-hdr has a one line for every
	 * {@link de.metas.handlingunits.model.I_M_HU_Item} of the source HU and one line for
	 *
	 * @param sourceHUs the HUs from which the given product and qty shall be taken
	 * @param qty the qty of <code>product</code> that shall be included in the new HU(s)
	 * @param product the product the shall be taken out of the <code>sourceHUs</code>
	 * @param destinationHuPI the definition of the new HU that shall be created with the given product and qty
	 * @return the newly created HUs that are "split off" the source HU
	 * 
	 * @deprecated uses {@link HUProducerDestination}; deprecated for the same reasons as {@link #transferIncomingToHUs(I_M_Transaction, I_M_HU_PI)}.
	 *             Please consider calling {@link #transferMaterialToNewHUs(List, LUTUProducerDestination, BigDecimal, I_M_Product, I_C_UOM, I_M_HU_PI)}.
	 */
	@Deprecated
	public List<I_M_HU> transferMaterialToNewHUs(final List<I_M_HU> sourceHUs, final BigDecimal qty, final I_M_Product product, final I_M_HU_PI destinationHuPI)
	{
		Check.assume(Adempiere.isUnitTestMode(), "This method shall be executed only in JUnit test mode");

		final IMutableHUContext huContext = getHUContext();
		final Date date = Env.getContextAsDate(Env.getCtx(), "#Date"); // FIXME use context date for now

		final IAllocationSource source = new HUListAllocationSourceDestination(sourceHUs);
		final HUProducerDestination destination = new HUProducerDestination(destinationHuPI);
		final HULoader loader = new HULoader(source, destination);

		final I_C_UOM uom = Services.get(IHandlingUnitsBL.class).getHandlingUOM(product);
		final IAllocationRequest request = AllocationUtils.createQtyRequest(huContext, product, qty, uom, date);

		loader.load(request); // use context date for now

		return destination.getCreatedHUs();
	}

	/**
	 * This method "destroys" one or many HU(s) according to the given transaction document (e.g. shipment). The source HUs' items are modified in this process. Note that the qtys contained in the
	 * given source HUs need to be sufficient for the products and qtys of the transaction document. If the given source HUs contain more material than required for the transaction document, then the
	 * rest is "left back" in the source HU(s).
	 *
	 * The method also creates a {@link I_M_HU_Trx_Hdr} which references the given transactionDoc. That trx-hdr has a one line for every {@link de.metas.handlingunits.model.I_M_HU_Item} of every
	 * source HU and one line for every {@link org.compiere.model.I_M_TransactionAllocation} of the given transaction doc.
	 *
	 *
	 * @param outgoingTrxDoc
	 * @param sourceHUs
	 *
	 */
	public void transferHUsToOutgoing(final I_M_Transaction outgoingTrx, final List<I_M_HU> sourceHUs)
	{
		final IMutableHUContext huContext = getHUContext();
		final Date date = getTodayDate();

		final IAllocationSource source = new HUListAllocationSourceDestination(sourceHUs);
		final IAllocationDestination destination = new MTransactionAllocationSourceDestination(outgoingTrx);
		final HULoader loader = new HULoader(source, destination);

		final I_M_Product product = outgoingTrx.getM_Product();
		final I_C_UOM uom = Services.get(IHandlingUnitsBL.class).getC_UOM(outgoingTrx);
		final BigDecimal qtyAbs = outgoingTrx.getMovementQty();
		final BigDecimal qty = qtyAbs.negate();

		final IAllocationRequest request = AllocationUtils.createQtyRequest(huContext, product, qty, uom, date, outgoingTrx);

		loader.load(request);
	}

	/**
	 * This method creates one or many HU(s) and distributes the products and Qtys of the given transaction document (e.g. material receipt) among those instances' material-HU-items. The method also
	 * creates a {@link de.metas.handlingunits.model.I_M_HU_Trx_Hdr} which references the given transactionDoc. The trx-hdr has a one line for every
	 * {@link org.compiere.model.I_M_TransactionAllocation} of the given transaction doc and one line for every created {@link de.metas.handlingunits.model.I_M_HU_Item}.
	 *
	 * @param incomingTrxDoc the material transaction (inventory, receipt etc) that document the "origin" of the products to be added to the new HU
	 * @param huPI
	 * @return the newly created HUs that were created from the transaction doc.
	 * 
	 * @deprecated this method only uses {@link HUProducerDestination} which will only create a simple plain HU. In almost every scenario that's not what you want test-wise.
	 *             Please remove the deprecation flag and update the doc if and when a good class of testcases come up which justify having the method in this helper..
	 */
	@Deprecated
	public List<I_M_HU> transferIncomingToHUs(final I_M_Transaction mtrx, final I_M_HU_PI huPI)
	{
		Check.assume(Services.get(IMTransactionBL.class).isInboundTransaction(mtrx),
				"mtrx shall be inbound transaction: {}", mtrx);

		final IAllocationSource source = new MTransactionAllocationSourceDestination(mtrx);
		final HUProducerDestination destination = new HUProducerDestination(huPI);
		final HULoader loader = new HULoader(source, destination);

		//
		// Create allocation request
		final IMutableHUContext huContext = getHUContext();
		final I_C_UOM uom = Services.get(IHandlingUnitsBL.class).getC_UOM(mtrx);
		final IAllocationRequest request = AllocationUtils.createQtyRequest(
				huContext,
				mtrx.getM_Product(),
				mtrx.getMovementQty(),
				uom, mtrx.getMovementDate(),
				mtrx);

		//
		// Execute transfer
		loader.load(request);

		return destination.getCreatedHUs();
	}

	/**
	 * 
	 * @param sourceHUs
	 * @param destinationHUs
	 * @param product
	 * @param qty
	 * @param uom
	 * 
	 * 
	 */
	public void transferMaterialToExistingHUs(final List<I_M_HU> sourceHUs, final List<I_M_HU> destinationHUs, final I_M_Product product, final BigDecimal qty, final I_C_UOM uom)
	{
		final IAllocationSource source = new HUListAllocationSourceDestination(sourceHUs);
		final IAllocationDestination destination = new HUListAllocationSourceDestination(destinationHUs);
		final HULoader loader = new HULoader(source, destination);

		//
		// Create allocation request
		final IMutableHUContext huContext = getHUContext();
		final Date date = getTodayDate();
		final IAllocationRequest request = AllocationUtils.createQtyRequest(huContext, product, qty, uom, date);

		//
		// Execute transfer
		loader.load(request);
	}

	public I_C_BPartner createBPartner(final String name)
	{
		final I_C_BPartner bpartner = InterfaceWrapperHelper.newInstance(I_C_BPartner.class, contextProvider);
		bpartner.setValue(name);
		bpartner.setName(name);
		InterfaceWrapperHelper.save(bpartner);

		return bpartner;
	}

	public I_C_BPartner_Location createBPartnerLocation(final I_C_BPartner bpartner)
	{
		final I_C_BPartner_Location bpl = InterfaceWrapperHelper.newInstance(I_C_BPartner_Location.class, bpartner);
		bpl.setC_BPartner_ID(bpartner.getC_BPartner_ID());
		bpl.setIsShipTo(true);
		bpl.setIsBillTo(true);
		InterfaceWrapperHelper.save(bpl);
		return bpl;
	}

	/**
	 * Calls {@link #createWarehouse(String, boolean)} with {@code isIssueWarehouse == false}
	 * 
	 * @param name
	 * @return
	 */
	public I_M_Warehouse createWarehouse(final String name)
	{
		final boolean isIssueWarehouse = false;
		return createWarehouse(name, isIssueWarehouse);
	}

	/**
	 * Creates a warehouse and one (default) locator.
	 * 
	 * @param name
	 * @param isIssueWarehouse
	 * @return
	 */
	public I_M_Warehouse createWarehouse(final String name, final boolean isIssueWarehouse)
	{
		final de.metas.interfaces.I_M_Warehouse warehouse = InterfaceWrapperHelper.newInstance(de.metas.interfaces.I_M_Warehouse.class, contextProvider);
		warehouse.setValue(name);
		warehouse.setName(name);
		warehouse.setIsIssueWarehouse(isIssueWarehouse);
		InterfaceWrapperHelper.save(warehouse);

		final I_M_Locator locator = createLocator(name + "-default", warehouse);
		locator.setIsDefault(true);
		InterfaceWrapperHelper.save(locator);

		return warehouse;
	}

	public I_M_Locator createLocator(final String name, final I_M_Warehouse warehouse)
	{
		final I_M_Locator locator = InterfaceWrapperHelper.newInstance(I_M_Locator.class, contextProvider);
		locator.setIsDefault(true);
		locator.setValue(name);
		locator.setIsActive(true);
		locator.setM_Warehouse_ID(warehouse.getM_Warehouse_ID());
		InterfaceWrapperHelper.save(locator);
		return locator;
	}

	public boolean isNoPI(final I_M_HU_PI pi)
	{
		return pi.getM_HU_PI_ID() == Services.get(IHandlingUnitsDAO.class).getNo_HU_PI_ID();
	}

	public boolean isVirtualPI(final I_M_HU_PI pi)
	{
		return pi.getM_HU_PI_ID() == Services.get(IHandlingUnitsDAO.class).getVirtual_HU_PI_ID();
	}

	public boolean isVirtualPIItem(final I_M_HU_PI_Item piItem)
	{
		return piItem.getM_HU_PI_Item_ID() == Services.get(IHandlingUnitsDAO.class).getVirtual_HU_PI_Item_ID();
	}

	public boolean isVirtualPIItemProduct(final I_M_HU_PI_Item_Product piItemProduct)
	{
		return piItemProduct.getM_HU_PI_Item_Product_ID() == Services.get(IHUPIItemProductDAO.class).retrieveVirtualPIMaterialItemProduct(ctx).getM_HU_PI_Item_Product_ID();
	}

	/**
	 * @param huToSplit
	 * @param documentLine
	 * @param cuProduct
	 * @param cuQty
	 * @param cuUOM
	 * @param cuPerTU
	 * @param tuPerLU
	 * @param maxLUToAllocate
	 * @param tuPIItem
	 * @param luPIItem
	 *
	 * @return HUs which were split
	 */
	public List<I_M_HU> splitHUs(
			final IHUContext huContext,
			final I_M_HU huToSplit,
			final I_M_Product cuProduct,
			final BigDecimal cuQty,
			final I_C_UOM cuUOM,
			final BigDecimal cuPerTU,
			final BigDecimal tuPerLU,
			final BigDecimal maxLUToAllocate,
			final I_M_HU_PI_Item tuPIItem,
			final I_M_HU_PI_Item luPIItem)
	{
		return newSplitBuilder(huContext, huToSplit, cuProduct, cuQty, cuUOM, cuPerTU, tuPerLU, maxLUToAllocate, tuPIItem, luPIItem)
				.split();
	}

	public IHUSplitBuilder newSplitBuilder(
			final IHUContext huContext,
			final I_M_HU huToSplit,
			final I_M_Product cuProduct,
			final BigDecimal cuQty,
			final I_C_UOM cuUOM,
			final BigDecimal cuPerTU,
			final BigDecimal tuPerLU,
			final BigDecimal maxLUToAllocate,
			final I_M_HU_PI_Item tuPIItem,
			final I_M_HU_PI_Item luPIItem)
	{
		final IHUSplitBuilder splitBuilder = new HUSplitBuilder(huContext);

		//
		// "Our" HU, the one which the user selected for split
		splitBuilder.setHUToSplit(huToSplit);

		//
		// Create Allocation Request for all Qty from CU Key

		splitBuilder.setCUProduct(cuProduct);
		splitBuilder.setCUQty(cuQty);
		splitBuilder.setCUUOM(cuUOM);

		splitBuilder.setCUPerTU(cuPerTU);
		splitBuilder.setTUPerLU(tuPerLU);
		splitBuilder.setMaxLUToAllocate(maxLUToAllocate);

		splitBuilder.setTU_M_HU_PI_Item(tuPIItem);
		splitBuilder.setLU_M_HU_PI_Item(luPIItem);

		final boolean splitOnNoPI = isNoPI(luPIItem.getM_HU_PI_Version().getM_HU_PI());
		splitBuilder.setSplitOnNoPI(splitOnNoPI); // huDefNone

		return splitBuilder;
	}

	/**
	 * Join given <code>tradingUnits</code> to the <code>loadingUnit</code>
	 *
	 * @param loadingUnit
	 * @param tradingUnits
	 */
	public void joinHUs(final IHUContext huContext, final I_M_HU loadingUnit, final Collection<I_M_HU> tradingUnits)
	{
		Check.assumeNotNull(tradingUnits, "PAram 'tradingUnits' is not null; other params: huContext={}, loadingUnit={}", huContext, loadingUnit);
		final IHUJoinBL huJoinBL = Services.get(IHUJoinBL.class);

		tradingUnits
				.forEach(tradingUnit -> huJoinBL.assignTradingUnitToLoadingUnit(huContext, loadingUnit, tradingUnit));
	}

	/**
	 * Join given <code>tradingUnits</code> to the <code>loadingUnit</code>
	 *
	 * @param loadingUnit
	 * @param tradingUnits
	 */
	public void joinHUs(final IHUContext huContext, final I_M_HU loadingUnit, final I_M_HU... tradingUnits)
	{
		trxBL.createHUContextProcessorExecutor(huContext)
				.run(new IHUContextProcessor()
				{

					@Override
					public IMutableAllocationResult process(IHUContext huContextLocal)
					{
						joinHUs(huContextLocal, loadingUnit, Arrays.asList(tradingUnits));
						return NULL_RESULT;
					}
				});
	}

	/**
	 * Configure and use {@link ITUMergeBuilder} to move given <code>sourceHUs</code> customer units (products) on the <code>targetHU</code> with the qty, UOM of that product
	 *
	 * @param huContext
	 * @param sourceHUs
	 * @param targetHU
	 * @param cuProduct
	 * @param cuQty
	 * @param cuUOM
	 */
	public void mergeTUs(final IHUContext huContext, final List<I_M_HU> sourceHUs, final I_M_HU targetHU, final I_M_Product cuProduct, final BigDecimal cuQty, final I_C_UOM cuUOM)
	{
		final ITUMergeBuilder mergeBuilder = new TUMergeBuilder(huContext);
		mergeBuilder.setSourceHUs(sourceHUs);
		mergeBuilder.setTargetTU(targetHU);

		mergeBuilder.setCUProduct(cuProduct);
		mergeBuilder.setCUQty(cuQty);
		mergeBuilder.setCUUOM(cuUOM);

		mergeBuilder.setCUTrxReferencedModel(targetHU);

		mergeBuilder.mergeTUs();
	}

	public ProductBOMBuilder newProductBOM()
	{
		return new ProductBOMBuilder()
				.setContext(contextProvider);
	}

	/**
	 * Commits {@link #trxName} and writes the given {@code hu} as XML to std-out. The commit might break some tests.
	 * Please only use this method temporarily to debug tests and comment it out again when the tests are fixed.
	 * 
	 * @param hu
	 * @deprecated please only use temporarily for debugging.
	 */
	@Deprecated
	public void commitAndDumpHU(I_M_HU hu)
	{
		Services.get(ITrxManager.class).commit(trxName);
		System.out.println(HUXmlConverter.toString(HUXmlConverter.toXml(hu)));
	}
}
