package com.candidate.web.action;

import com.candidate.service.model.CandidateInfo;
import com.candidate.service.service.CandidateInfoLocalService;
import com.candidate.service.service.CandidateInfoService;
import com.candidate.service.service.CandidateOtherInfoLocalService;
import com.candidate.service.service.ProfessionalDetailsLocalService;
import com.candidate.web.constants.CandidateCreateWebPortletKeys;
import com.candidate.web.constants.CandidateStageConstant;
import com.candidate.web.constants.FileTitleConstant;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;

import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import com.prime.data.service.service.DocumentMapperLocalService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CandidateCreateWebPortletKeys.CANDIDATECREATEWEB,
		"mvc.command.name=/addORUpdateCandidate" }, service = MVCActionCommand.class)
public class AddORUpdateCandidate extends BaseMVCActionCommand {
	private static Log _log = LogFactoryUtil.getLog(AddORUpdateCandidate.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionresponse) throws Exception {
		ServiceContext serviceContext = null;
		serviceContext = ServiceContextFactory.getInstance(AddORUpdateCandidate.class.getName(), actionRequest);
		long candidateId = ParamUtil.getLong(actionRequest, "candidateId");
		long professionalDetailsId = ParamUtil.getLong(actionRequest, "professionalDetailsId");
		long candidateOtherInfoId = ParamUtil.getLong(actionRequest, "candidateOtherInfoId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String email = ParamUtil.getString(actionRequest, "email");
		String secondaryEmail = ParamUtil.getString(actionRequest, "secondaryEmail");
		String mobileNumber = ParamUtil.getString(actionRequest, "mobileNumber");
		String country = ParamUtil.getString(actionRequest, "country");
		String state = ParamUtil.getString(actionRequest, "state");
		String street = ParamUtil.getString(actionRequest, "street");
		String city = ParamUtil.getString(actionRequest, "city");
		String zipCode = ParamUtil.getString(actionRequest, "postalCode");
		String website = ParamUtil.getString(actionRequest, "website");
		String houseNumber = ParamUtil.getString(actionRequest, "houseNumber");

		double expectedSalary = ParamUtil.getDouble(actionRequest, "expectedSalary");
		double currentSalary = ParamUtil.getDouble(actionRequest, "currentSalary");
		String skillSet = ParamUtil.getString(actionRequest, "skillSet");
		String workType = ParamUtil.getString(actionRequest, "workType");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		String qualification = ParamUtil.getString(actionRequest, "qualification");
		String experience = ParamUtil.getString(actionRequest, "experienceinYears");
		String additionalInfo = ParamUtil.getString(actionRequest, "additionalInfo");
		String currentEmployer = ParamUtil.getString(actionRequest, "currentEmployer");

		String candidateStatus = ParamUtil.getString(actionRequest, "candidateStatus");
		String source = ParamUtil.getString(actionRequest, "source");
		String candidateOwner = ParamUtil.getString(actionRequest, "candidateOwner");
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		String educationIndexString = ParamUtil.getString(actionRequest, "autofieldscontainer");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");

		String formattedFromDuration = null;
		String formattedToDuration = null;
		String formattedFromWorkDuration = null;
		String formattedToWorkDuration = null;
		String[] educationIndexs = StringUtil.split(educationIndexString);
		StringBuilder InstituteBuild = new StringBuilder();
		StringBuilder DepartmentBuild = new StringBuilder();
		StringBuilder DegreeBuild = new StringBuilder();
		StringBuilder FromDurationBuild = new StringBuilder();
		StringBuilder ToDurationBuild = new StringBuilder();
		for (String educationIndex : educationIndexs) {
			String Institute = ParamUtil.getString(actionRequest, "institute" + educationIndex);
			String Department = ParamUtil.getString(actionRequest, "department" + educationIndex);
			String Degree = ParamUtil.getString(actionRequest, "degree" + educationIndex);
			String FromDuration = ParamUtil.getString(actionRequest, "FromDuration" + educationIndex);
			String ToDuration = ParamUtil.getString(actionRequest, "ToDuration" + educationIndex);

			Date fromDate = dateFormat.parse(FromDuration);
			formattedFromDuration = new SimpleDateFormat("MMMM yyyy").format(fromDate);
			Date ToDate = dateFormat.parse(ToDuration);
			formattedToDuration = new SimpleDateFormat("MMMM yyyy").format(ToDate);

			appendValueToStringBuilder(InstituteBuild, Institute, StringPool.COMMA);
			appendValueToStringBuilder(DepartmentBuild, Department, StringPool.COMMA);
			appendValueToStringBuilder(DegreeBuild, Degree, StringPool.COMMA);
			appendValueToStringBuilder(FromDurationBuild, formattedFromDuration, StringPool.COMMA);
			appendValueToStringBuilder(ToDurationBuild, formattedToDuration, StringPool.COMMA);
		}

		String experienceIndexString = ParamUtil.getString(actionRequest, "autofieldscontainer1");
		String[] experianceIndexs = StringUtil.split(experienceIndexString);
		StringBuilder OccupationBuild = new StringBuilder();
		StringBuilder CompanyBuild = new StringBuilder();
		StringBuilder SummaryBuild = new StringBuilder();
		StringBuilder FromWorkDurationBuild = new StringBuilder();
		StringBuilder ToWorkDurationBuild = new StringBuilder();
		for (String experianceIndex : experianceIndexs) {
			String Occupation = ParamUtil.getString(actionRequest, "occupation" + experianceIndex);
			String Company = ParamUtil.getString(actionRequest, "company" + experianceIndex);
			String Summary = ParamUtil.getString(actionRequest, "summary" + experianceIndex);
			String FromWorkDuration = ParamUtil.getString(actionRequest, "FromworkDuration" + experianceIndex);
			String ToWorkDuration = ParamUtil.getString(actionRequest, "ToworkDuration" + experianceIndex);

			Date fromWorkDate = dateFormat.parse(FromWorkDuration);
			formattedFromWorkDuration = new SimpleDateFormat("MMMM yyyy").format(fromWorkDate);

			Date toWorkDate = dateFormat.parse(ToWorkDuration);
			formattedToWorkDuration = new SimpleDateFormat("MMMM yyyy").format(toWorkDate);
			appendValueToStringBuilder(OccupationBuild, Occupation, StringPool.COMMA);
			appendValueToStringBuilder(CompanyBuild, Company, StringPool.COMMA);
			appendValueToStringBuilder(SummaryBuild, Summary, StringPool.COMMA);
			appendValueToStringBuilder(FromWorkDurationBuild, formattedFromWorkDuration, StringPool.COMMA);
			appendValueToStringBuilder(ToWorkDurationBuild, formattedToWorkDuration, StringPool.COMMA);

		}

		CandidateInfo candidateInfo = null;

		candidateInfo = _candidateInfoLocalService.addOrUpdateCandidate(candidateId, firstName, lastName, email,
				secondaryEmail, mobileNumber, country, street, city, state, zipCode, houseNumber, website,
				serviceContext);
		long repositoryId = serviceContext.getScopeGroupId();
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		String Foldername = lastName + candidateInfo.getCandidateId();
		Folder folder = null;
		long recordId = 0;
		try {
			folder = DLAppServiceUtil.getFolder(folderId);
		} catch (Exception e) {
			folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, Foldername, "", serviceContext);
		}
		if (Validator.isNotNull(candidateInfo)) {
			_professionalDetailsLocalService.updateProfDetails(professionalDetailsId, candidateInfo.getCandidateId(),
					expectedSalary, currentSalary, skillSet, additionalInfo, currentEmployer, workType, experience,
					qualification, jobTitle, serviceContext);
			_candidateOtherInfoLocalService.addOrUpdateCandidateOtherInfo(candidateOtherInfoId,
					candidateInfo.getCandidateId(), candidateStatus,CandidateStageConstant.NEWSTAGE, source, candidateOwner, InstituteBuild.toString(),
					DepartmentBuild.toString(), DegreeBuild.toString(), FromDurationBuild.toString(),
					ToDurationBuild.toString(), OccupationBuild.toString(), CompanyBuild.toString(),
					SummaryBuild.toString(), FromWorkDurationBuild.toString(), ToWorkDurationBuild.toString(),
					 folder.getFolderId(), serviceContext);

			if (Validator.isNotNull(folder)) {
				UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				File[] fileItems = { uploadRequest.getFile("resumeFile"), uploadRequest.getFile("coverLetterFile"),
						uploadRequest.getFile("otherFiles"), uploadRequest.getFile("offerFile"),
						uploadRequest.getFile("contractFiles") };
				String[] fileNames = { uploadRequest.getFileName("resumeFile"),
						uploadRequest.getFileName("coverLetterFile"), uploadRequest.getFileName("otherFiles"),
						uploadRequest.getFileName("offerFile"), uploadRequest.getFileName("contractFiles") };
				String[] Filetitles = { FileTitleConstant.RESUME, FileTitleConstant.COVERLETTER,
						FileTitleConstant.OTHERS, FileTitleConstant.OFFER, FileTitleConstant.CONTRACTS };
				try {

					for (int i = 0; i < fileItems.length; i++) {
						File fileItem = fileItems[i];
						if (fileItem != null && fileItem.exists()) {
							String fileName = fileNames[i];
							String fileTitle = Filetitles[i];
							System.out.println("fileNames:::::::::::::::::" + fileName);

							FileEntry entry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(),
									repositoryId, folder.getFolderId(), fileName,
									MimeTypesUtil.getContentType(fileItem), fileTitle, "", "", fileItem,
									serviceContext);

							_documentMappingLocalService.AddOrUpdateDocument(recordId, "Candidate",
									candidateInfo.getCandidateId(), entry.getFileName(), entry.getFileEntryId(),
									new Date(), new Date(), serviceContext);

						}
					}
				} catch (Exception e) {
				}

			}
		}

		actionresponse.getRenderParameters().setValue("jspPage", "/candidate-list.jsp");
	}

	private void appendValueToStringBuilder(StringBuilder stringBuilder, String value, String separator) {
		stringBuilder.append(String.valueOf(value));
		stringBuilder.append(separator);
	}

	@Reference
	private DLAppService _dlAppService;
	@Reference
	private CandidateInfoLocalService _candidateInfoLocalService;
	@Reference
	private ProfessionalDetailsLocalService _professionalDetailsLocalService;
	@Reference
	private CandidateOtherInfoLocalService _candidateOtherInfoLocalService;

	@Reference
	private DocumentMapperLocalService _documentMappingLocalService;

}
