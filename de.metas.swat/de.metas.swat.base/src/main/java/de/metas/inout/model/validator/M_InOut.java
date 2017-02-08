package de.metas.inout.model.validator;

import java.util.List;
import java.util.Properties;

import org.adempiere.ad.modelvalidator.annotations.DocValidate;
import org.adempiere.ad.modelvalidator.annotations.Init;
import org.adempiere.ad.modelvalidator.annotations.ModelChange;
import org.adempiere.ad.modelvalidator.annotations.Validator;
import org.adempiere.model.InterfaceWrapperHelper;
import org.adempiere.util.Services;
import org.compiere.model.I_M_MatchInv;
import org.compiere.model.ModelValidator;

import de.metas.document.IDocumentLocationBL;
import de.metas.event.IEventBusFactory;
import de.metas.inout.IInOutBL;
import de.metas.inout.IInOutDAO;
import de.metas.inout.api.IInOutMovementBL;
import de.metas.inout.api.IMaterialBalanceDetailBL;
import de.metas.inout.api.IMaterialBalanceDetailDAO;
import de.metas.inout.event.InOutProcessedEventBus;
import de.metas.inout.model.I_M_InOut;
import de.metas.request.service.IRequestCreator;

@Validator(I_M_InOut.class)
public class M_InOut
{
	@Init
	public void onInit()
	{
		// Setup event bus topics on which swing client notification listener shall subscribe
		Services.get(IEventBusFactory.class).addAvailableUserNotificationsTopic(InOutProcessedEventBus.EVENTBUS_TOPIC);
	}

	@ModelChange(timings = { ModelValidator.TYPE_BEFORE_NEW, ModelValidator.TYPE_BEFORE_CHANGE }, ifColumnsChanged = {
			I_M_InOut.COLUMNNAME_C_BPartner_ID, I_M_InOut.COLUMNNAME_C_BPartner_Location_ID, I_M_InOut.COLUMNNAME_AD_User_ID })
	public void updateBPartnerAddress(final I_M_InOut doc)
	{
		Services.get(IDocumentLocationBL.class).setBPartnerAddress(doc);
	}

	@ModelChange(timings = { ModelValidator.TYPE_BEFORE_NEW, ModelValidator.TYPE_BEFORE_CHANGE }, ifColumnsChanged = {
			I_M_InOut.COLUMNNAME_DropShip_BPartner_ID, I_M_InOut.COLUMNNAME_DropShip_Location_ID, I_M_InOut.COLUMNNAME_DropShip_User_ID })
	public void updateDeliveryToAddress(final I_M_InOut doc)
	{
		Services.get(IDocumentLocationBL.class).setDeliveryToAddress(doc);
	}

	/**
	 * Generate movements from receipt (if needed).
	 *
	 * This is the counter-part of {@link #reverseMovements(I_M_InOut)}.
	 *
	 * @param inout
	 */
	@DocValidate(timings = { ModelValidator.TIMING_AFTER_COMPLETE })
	public void generateMovement(final I_M_InOut inout)
	{
		// We are generating movements only for receipts
		if (inout.isSOTrx())
		{
			return;
		}

		// Don't generate movements for a reversal document
		if (Services.get(IInOutBL.class).isReversal(inout))
		{
			return;
		}

		// Actually generate the movements
		final IInOutMovementBL inoutMovementBL = Services.get(IInOutMovementBL.class);
		inoutMovementBL.generateMovementFromReceipt(inout);
	}

	/**
	 * Reverse linked movements.
	 *
	 * This is the counter-part of {@link #generateMovement(I_M_InOut)}.
	 *
	 * @param inout
	 */
	@DocValidate(timings = { ModelValidator.TIMING_BEFORE_REVERSECORRECT, ModelValidator.TIMING_BEFORE_REVERSEACCRUAL, ModelValidator.TIMING_BEFORE_VOID, ModelValidator.TIMING_BEFORE_REACTIVATE
	})
	public void reverseMovements(final I_M_InOut inout)
	{
		final IInOutMovementBL inoutMovementBL = Services.get(IInOutMovementBL.class);
		inoutMovementBL.reverseMovements(inout);
	}

	/**
	 * Reverse {@link I_M_MatchInv} assignments.
	 *
	 * @param inout
	 */
	@DocValidate(timings = { ModelValidator.TIMING_BEFORE_REVERSECORRECT, ModelValidator.TIMING_BEFORE_REVERSEACCRUAL, ModelValidator.TIMING_BEFORE_VOID, ModelValidator.TIMING_BEFORE_REACTIVATE
	})
	public void removeMatchInvAssignments(final I_M_InOut inout)
	{
		Services.get(IInOutBL.class).deleteMatchInvs(inout); // task 08531
	}

	@DocValidate(timings = { ModelValidator.TIMING_BEFORE_COMPLETE })
	public void addInoutToBalance(final I_M_InOut inout)
	{

		final boolean isReversal = Services.get(IInOutBL.class).isReversal(inout);

		// do nothing in case of reversal
		if (!isReversal)
		{
			final IMaterialBalanceDetailBL materialBalanceDetailBL = Services.get(IMaterialBalanceDetailBL.class);

			materialBalanceDetailBL.addInOutToBalance(inout);

		}
	}

	@DocValidate(timings = {
			ModelValidator.TIMING_BEFORE_REACTIVATE,
			ModelValidator.TIMING_BEFORE_REVERSECORRECT,
			ModelValidator.TIMING_BEFORE_VOID,
			ModelValidator.TIMING_AFTER_REVERSEACCRUAL,
			ModelValidator.TIMING_AFTER_CLOSE
	})
	public void removeInoutFromBalance(final I_M_InOut inout)
	{
		final IMaterialBalanceDetailDAO materialBalanceDetailDAO = Services.get(IMaterialBalanceDetailDAO.class);

		materialBalanceDetailDAO.removeInOutFromBalance(inout);
	}

	/**
	 * After an inout is completed, check if it contains lines with quality discount percent.
	 * In case it does, create a request for each line that has a discount percent and fill it with the information from the line and the inout.
	 * 
	 * @param inOut
	 */
	@DocValidate(timings = { ModelValidator.TIMING_AFTER_COMPLETE })
	public void onComplete_QualityIssues(final I_M_InOut inOut)
	{
		// retrieve all lines with issues (quality discount percent)
		final List<Integer> linesWithQualityIssues = Services.get(IInOutDAO.class).retrieveLinesWithQualityIssues(inOut);

		if (linesWithQualityIssues.isEmpty())
		{
			// nothing to do
			return;
		}

		final Properties ctx = InterfaceWrapperHelper.getCtx(inOut);
		final String trxName = InterfaceWrapperHelper.getTrxName(inOut);

		// In case there are lines with issues, trigger the request creation for them.
		// Note: The request creation will be done async
		Services.get(IRequestCreator.class).createRequests(ctx, linesWithQualityIssues, trxName);
	}

}
