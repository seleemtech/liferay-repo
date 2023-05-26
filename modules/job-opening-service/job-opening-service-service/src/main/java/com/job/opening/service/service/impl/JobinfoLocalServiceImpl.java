/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.job.opening.service.service.impl;

import com.job.opening.service.model.Jobinfo;
import com.job.opening.service.service.JobinfoLocalServiceUtil;
import com.job.opening.service.service.base.JobinfoLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.job.opening.service.model.Jobinfo", service = AopService.class)
public class JobinfoLocalServiceImpl extends JobinfoLocalServiceBaseImpl {
	public Jobinfo createJob(long groupId, long companyId, long userId, String userName, String postingTitle,
			String title, String assignedRecruiter, String clientName, Date targetDate, String jobopeningStatus,
			String industry, String jobResource, String hiringManager, String positions, Date dateOpened,
			String jobType, String workExperience, String skillSet, String projectStatus, long summaryId, long otherId)
			throws PortalException {
		Jobinfo ji = JobinfoLocalServiceUtil.createJobinfo(CounterLocalServiceUtil.increment());
		ji.setGroupId(groupId);
		ji.setCompanyId(companyId);
		ji.setUserId(userId);
		ji.setUserName(userName);
		ji.setPostingTitle(postingTitle);
		ji.setTitle(title);
		ji.setAssignedRecruiter(assignedRecruiter);
		ji.setClientName(clientName);
		ji.setTargetDate(targetDate);
		ji.setJobopeningStatus(jobopeningStatus);
		ji.setIndustry(industry);
		ji.setJobResource(jobResource);
		ji.setHiringManager(hiringManager);
		ji.setPositions(positions);
		ji.setDateOpened(dateOpened);
		ji.setJobType(jobType);
		ji.setSkillSet(skillSet);
		ji.setWorkExperience(workExperience);
		ji.setProjectStatus(projectStatus);
		ji.setSummaryId(summaryId);
		ji.setOtherId(otherId);
		ji = JobinfoLocalServiceUtil.addJobinfo(ji);
		return ji;

	}

	public Jobinfo updateJob(long groupId, long companyId, long userId, String userName, long jobId,
			String postingTitle, String title, String assignedRecruiter, String clientName, Date targetDate,
			String jobopeningStatus, String industry, String jobResource, String hiringManager, String positions,
			Date dateOpened, String jobType, String workExperience, String skillSet, String projectStatus,
			long summaryId, long otherId) throws PortalException {
		Jobinfo ji = JobinfoLocalServiceUtil.getJobinfo(jobId);
		ji.setGroupId(groupId);
		ji.setCompanyId(companyId);
		ji.setUserId(userId);
		ji.setUserName(userName);
		ji.setPostingTitle(postingTitle);
		ji.setTitle(title);
		ji.setAssignedRecruiter(assignedRecruiter);
		ji.setClientName(clientName);
		ji.setTargetDate(targetDate);
		ji.setJobopeningStatus(jobopeningStatus);
		ji.setIndustry(industry);
		ji.setJobResource(jobResource);
		ji.setHiringManager(hiringManager);
		ji.setPositions(positions);
		ji.setDateOpened(dateOpened);
		ji.setJobType(jobType);
		ji.setSkillSet(skillSet);
		ji.setWorkExperience(workExperience);
		ji.setProjectStatus(projectStatus);
		ji.setSummaryId(summaryId);
		ji.setOtherId(otherId);
		ji = JobinfoLocalServiceUtil.updateJobinfo(ji);
		return ji;

	}
}