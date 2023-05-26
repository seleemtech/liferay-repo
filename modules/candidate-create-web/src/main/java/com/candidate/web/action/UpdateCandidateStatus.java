package com.candidate.web.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.candidate.service.service.CandidateOtherInfoLocalService;
import com.candidate.web.constants.CandidateCreateWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + CandidateCreateWebPortletKeys.CANDIDATECREATEWEB,
		"mvc.command.name=/UpdateStatus" }, service = MVCActionCommand.class)
public class UpdateCandidateStatus extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		long candidateId = ParamUtil.getLong(actionRequest, "candidateId");
		String candidateStatus = ParamUtil.getString(actionRequest, "candidateStatus");
		_candidateOtherInfoLocalService.updateCandidateStatus(candidateId, candidateStatus);
	}

	@Reference
	private CandidateOtherInfoLocalService _candidateOtherInfoLocalService;

}
