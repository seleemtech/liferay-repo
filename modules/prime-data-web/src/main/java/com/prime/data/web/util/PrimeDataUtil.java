package com.prime.data.web.util;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.prime.data.service.model.MainTable;
import com.prime.data.service.service.CandidateStatusLocalServiceUtil;
import com.prime.data.service.service.CurrJobTitleLocalServiceUtil;
import com.prime.data.service.service.HighQualHeldLocalServiceUtil;
import com.prime.data.service.service.IndustryLocalServiceUtil;
import com.prime.data.service.service.InterviewNameLocalServiceUtil;
import com.prime.data.service.service.JobOpeningStatusLocalServiceUtil;
import com.prime.data.service.service.JobTypeLocalServiceUtil;
import com.prime.data.service.service.MainTableLocalServiceUtil;
import com.prime.data.service.service.NamePrefixLocalServiceUtil;
import com.prime.data.service.service.PriorityLocalServiceUtil;
import com.prime.data.service.service.ProjectStatusLocalServiceUtil;
import com.prime.data.service.service.SalaryRangeLocalServiceUtil;
import com.prime.data.service.service.SalesStageLocalServiceUtil;
import com.prime.data.service.service.SkillSetLocalServiceUtil;
import com.prime.data.service.service.SourceByLocalServiceUtil;
import com.prime.data.service.service.WorkExperienceLocalServiceUtil;
import com.prime.data.service.service.WorkTypeLocalServiceUtil;

public class PrimeDataUtil {
	
public static void addCategory(ActionRequest actionRequest) {
	String category = ParamUtil.getString(actionRequest, "category");
	String name = ParamUtil.getString(actionRequest, "name");
	
	MainTable mainTable = MainTableLocalServiceUtil.createMainTable(0);
	mainTable.setCategory(category);
	mainTable.setName(name);
	MainTableLocalServiceUtil.addMainTable(mainTable);
}

public static void addJobType(ActionRequest actionRequest) {
	String jobType = ParamUtil.getString(actionRequest, "jobType");
	JobTypeLocalServiceUtil.addJobType(jobType);
}
public static void addJobOpeningStatus(ActionRequest actionRequest) {
	String jobOpeningStatus = ParamUtil.getString(actionRequest, "jobOpeningStatus");
	JobOpeningStatusLocalServiceUtil.addJobOpeningStatus(jobOpeningStatus);
}
public static void addProjectStatus(ActionRequest actionRequest) {
	String projectStatusName = ParamUtil.getString(actionRequest, "projectStatusName");
	ProjectStatusLocalServiceUtil.addProjectStatus(projectStatusName);
}
public static void addIndustry(ActionRequest actionRequest) {
	String industryName = ParamUtil.getString(actionRequest, "industryName");
	IndustryLocalServiceUtil.addIndustry(industryName);
}
public static void addSalaryRange(ActionRequest actionRequest) {
	String salaryRange = ParamUtil.getString(actionRequest, "salaryRange");
	SalaryRangeLocalServiceUtil.addSalaryRange(salaryRange);
}
public static void addWorkExperience(ActionRequest actionRequest) {
	String workExpRange = ParamUtil.getString(actionRequest, "workExpRange");
	WorkExperienceLocalServiceUtil.addWorkExperience(workExpRange);
}
public static void addSalesStage(ActionRequest actionRequest) {
	String salesStage = ParamUtil.getString(actionRequest, "salesStage");
	SalesStageLocalServiceUtil.addSalesStage(salesStage);
}
public static void addNamePrefix(ActionRequest actionRequest) {
	String namePrefix = ParamUtil.getString(actionRequest, "namePrefix");
	NamePrefixLocalServiceUtil.addNamePrefix(namePrefix);
}
public static void addHighQualHeld(ActionRequest actionRequest) {
	String highQualHeld = ParamUtil.getString(actionRequest, "highQualHeld");
	HighQualHeldLocalServiceUtil.addHighQualHeld(highQualHeld);
}
public static void addCurrJobTitle(ActionRequest actionRequest) {
	String currentJobTitle = ParamUtil.getString(actionRequest, "currentJobTitle");
	CurrJobTitleLocalServiceUtil.addCurrJobTitle(currentJobTitle);
}
public static void addSkillSet(ActionRequest actionRequest) {
	SkillSetLocalServiceUtil.addSkillSet(actionRequest);
}
public static void addCandidateStatus(ActionRequest actionRequest) {
	String candidateStatus = ParamUtil.getString(actionRequest, "candidateStatus");
	CandidateStatusLocalServiceUtil.addCandidateStatus(candidateStatus);
}
public static void addSource(ActionRequest actionRequest) {
	String sourceBy = ParamUtil.getString(actionRequest, "sourceBy");
	SourceByLocalServiceUtil.addSource(sourceBy);
}
public static void addPriority(ActionRequest actionRequest) {
	String priorityName = ParamUtil.getString(actionRequest, "priorityName");
	PriorityLocalServiceUtil.addPriority(priorityName);
}
public static void addWorkType(ActionRequest actionRequest) {
	String workTypeName = ParamUtil.getString(actionRequest, "workTypeName");
	WorkTypeLocalServiceUtil.addWorkType(workTypeName);
}
public static void addInterviewName(ActionRequest actionRequest) {
	String interviewName = ParamUtil.getString(actionRequest, "interviewName");
	InterviewNameLocalServiceUtil.addInterviewName(interviewName);
}
}
