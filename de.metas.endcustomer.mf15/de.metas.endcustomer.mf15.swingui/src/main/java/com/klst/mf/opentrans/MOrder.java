/*
 * #%L
 * de.metas.endcustomer.mf15.swingui
 * %%
 * Copyright (C) 2016 klst GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package com.klst.mf.opentrans;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

import org.compiere.util.DB;
import org.opentrans.xmlschema._2.ORDERINFO;
import org.opentrans.xmlschema._2.ORDERITEM;
import org.opentrans.xmlschema._2.ORDERSUMMARY;

import com.klst.opentrans.DATETIME;

/* TODO : umstellen und testen mit metasfresh
 *  
 * MOrder-Mapping erweitert MOrder um opentrans-mapping Funktionalität,
 * die zentrale (static)-Methode ist mapping().
 * 
 * Neben den unique keys auf der Tabelle c_order:
 *  - CONSTRAINT c_order_pkey PRIMARY KEY (c_order_id)
 *  - UNIQUE INDEX c_order_documentno ... (documentno COLLATE pg_catalog."default", c_doctype_id, c_bpartner_id)
 *  - UNIQUE INDEX c_order_uu_idx ...     (c_order_uu COLLATE pg_catalog."default")
 * gibt es für die opentrans-Order noch den applikatorischen Ot-Key
 *  - (poreference, dropship_bpartner_id) für Order mit (IsActive='Y' AND isdropship ='Y')
 * und 
 *  poreference == otInfo.getORDERID()
 *  dropship_bpartner_id == dropShipBPartner_ID
 *  
 */
public class MOrder extends org.compiere.model.MOrder
{
	
	private static final long serialVersionUID = 2890231590238517739L;
	
	private static final String SQL_OTORDER = "SELECT C_Order_ID FROM C_Order"
			+ " WHERE IsActive='Y' AND ad_client_id = ? AND ad_org_id IN( 0, ? )" // para 1,2
			+ " AND dropship_bpartner_id = ? "                                    // para 3
			+ " AND poreference = ? "                                             // para 4
//			+ " AND isdropship ='Y'"
			;
	private PreparedStatement pstmtOtOrder; // sucht den Auftrag
	private List<MOrder> existingOrders = null; // Suchergebnisse
	
	private static final String SQL_SHIPPER_DEFAULT = "SELECT * FROM m_shipper"
			+ " WHERE isactive='Y' AND ad_client_id = ? AND ad_org_id IN( 0, ? ) AND isdefault='Y' ";
	private PreparedStatement pstmtDefalutShipper; 
	
	private static final String SQL_CUSTOMER = "SELECT c_bpartner_id FROM c_bpartner"
			+ " WHERE isactive='Y' AND iscustomer = 'Y' AND ( name = ? OR value = ? ) ";
	private PreparedStatement pstmtCustomer;  
	
	private static final String SQL_ORDERLINE = "SELECT * FROM C_OrderLine"
			+ " WHERE isactive='Y' AND ad_client_id = ? AND ad_org_id IN( 0, ? ) AND c_order_id = ? AND line = ?";
	private PreparedStatement pstmtOrderLine; 
	
	public static final boolean ISDROPSHIP = false; // wg. Validation failed - Auftrag null darf nicht als Streckengeschõft markiert werden
	
	private ORDERINFO otInfo = null;
	private String otSupplier = null; // i.A. "Min* AG"
	private String otByuer = null;
	private String otInvoice_recipient = null;
	private String otDelivery = null;
	private DATETIME otDateordered = null;
	
	private List<ORDERITEM> otItems = null;
	private ORDERSUMMARY otSummary = null;
	
	/**
	 * Default Constructor
	 * 
	 * @param ctx
	 * @param C_Order_ID
	 * @param trxName
	 */
	public MOrder(Properties ctx, int C_Order_ID, String trxName) {
		super(ctx, C_Order_ID, trxName);
		pstmtCustomer = DB.prepareStatement(SQL_CUSTOMER, trxName);
		pstmtOrderLine = DB.prepareStatement(SQL_ORDERLINE, trxName);
		pstmtDefalutShipper = DB.prepareStatement(SQL_SHIPPER_DEFAULT, trxName);
	}

}
