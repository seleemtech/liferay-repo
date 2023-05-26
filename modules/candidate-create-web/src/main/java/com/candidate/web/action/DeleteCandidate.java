package com.candidate.web.action;

import com.candidate.service.model.CandidateInfo;
import com.candidate.service.model.CandidateOtherInfo;
import com.candidate.service.model.ProfessionalDetails;
import com.candidate.service.service.CandidateInfoLocalService;
import com.candidate.service.service.CandidateOtherInfoLocalService;
import com.candidate.service.service.CandidateOtherInfoLocalServiceUtil;
import com.candidate.service.service.ProfessionalDetailsLocalService;
import com.candidate.service.service.ProfessionalDetailsLocalServiceUtil;
import com.candidate.web.constants.CandidateCreateWebPortletKeys;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CandidateCreateWebPortletKeys.CANDIDATECREATEWEB,
		"mvc.command.name=/DeleteCandidate" }, service = MVCActionCommand.class)
public class DeleteCandidate extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside the Delete Command");
		long candidateId = ParamUtil.getLong(actionRequest, "candidateId");
		System.out.println("" + candidateId);
		CandidateInfo candidate = _candidateInfoLocalService.deleteCandidate(candidateId);
		if (Validator.isNotNull(candidate)) {
			ProfessionalDetails prof = ProfessionalDetailsLocalServiceUtil.getByCandidateId(candidateId);
			System.out.println("Candidate " + prof.getProfessionalDetailsId());
			_professionalDetailsLocalService.deleteProfessionalDetails(prof.getProfessionalDetailsId());
			CandidateOtherInfo candidateOther = CandidateOtherInfoLocalServiceUtil.getByCandidtatesId(candidateId);
			System.out.println("Candidate otherInfo" + candidateOther.getCandidateId());
			_candidateOtherInfoLocalService.deleCandidateOtherInfo(candidateOther.getCandidateOtherInfoId());
			if(Validator.isNotNull(candidateOther.getFolderId())) {
				DLAppServiceUtil.deleteFolder(candidateOther.getFolderId());
			}
			

		}

	}

	@Reference
	private CandidateInfoLocalService _candidateInfoLocalService;
	@Reference
	private ProfessionalDetailsLocalService _professionalDetailsLocalService;
	@Reference
	private CandidateOtherInfoLocalService _candidateOtherInfoLocalService;

}
