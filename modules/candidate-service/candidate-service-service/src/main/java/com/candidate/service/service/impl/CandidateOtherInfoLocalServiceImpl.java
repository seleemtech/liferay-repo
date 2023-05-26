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

package com.candidate.service.service.impl;

import com.candidate.service.exception.NoSuchCandidateOtherInfoException;
import com.candidate.service.model.CandidateInfo;
import com.candidate.service.model.CandidateOtherInfo;
import com.candidate.service.service.base.CandidateOtherInfoLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mahammed Seleem
 */
@Component(property = "model.class.name=com.candidate.service.model.CandidateOtherInfo", service = AopService.class)
public class CandidateOtherInfoLocalServiceImpl extends CandidateOtherInfoLocalServiceBaseImpl {

	public CandidateOtherInfo addOrUpdateCandidateOtherInfo(long candidateOtherInfoId, long candidateId,
			String candidateStatus,String candidateStage, String source, String candidateOwner, String institute, String department,
			String degree, String FromDuration, String Toduration, String occupation, String company, String summary,
			String FromWorkDuration, String ToWorkDuration, long folderId, ServiceContext serviceContext) {

		CandidateOtherInfo otherInfo = null;
		try {
			System.out.println("othe Update method");
			otherInfo = candidateOtherInfoPersistence.fetchByPrimaryKey(candidateOtherInfoId);
			otherInfo.setCandidateId(candidateId);
			otherInfo.setCandidateStatus(candidateStatus);
			otherInfo.setCandidateOwner(candidateOwner);
			otherInfo.setSource(source);
			otherInfo.setInstitute(institute);
			otherInfo.setDepartment(department);
			otherInfo.setDegree(degree);
			otherInfo.setFromDuration(FromDuration);
			otherInfo.setToDuration(Toduration);
			otherInfo.setOccupation(occupation);
			otherInfo.setCompany(company);
			otherInfo.setSummary(summary);
			otherInfo.setCandidateStage(candidateStage);
			otherInfo.setFromWorkDuration(FromWorkDuration);
			otherInfo.setToWorkDuration(ToWorkDuration);
			otherInfo.setCompanyId(serviceContext.getCompanyId());
			otherInfo.setUserId(serviceContext.getUserId());
			otherInfo.setFolderId(folderId);
			candidateOtherInfoPersistence.update(otherInfo);
		} catch (Exception e) {
			System.out.println("othe add method");
			candidateOtherInfoId = counterLocalService.increment();
			otherInfo = candidateOtherInfoPersistence.create(candidateOtherInfoId);
			otherInfo.setCandidateId(candidateId);
			otherInfo.setCandidateStatus(candidateStatus);
			otherInfo.setCandidateOwner(candidateOwner);
			otherInfo.setSource(source);
			otherInfo.setInstitute(institute);
			otherInfo.setDepartment(department);
			otherInfo.setDegree(degree);
			otherInfo.setFromDuration(FromDuration);
			otherInfo.setToDuration(Toduration);
			otherInfo.setOccupation(occupation);
			otherInfo.setCompany(company);
			otherInfo.setSummary(summary);
			otherInfo.setCandidateStage(candidateStage);
			otherInfo.setFromWorkDuration(FromWorkDuration);
			otherInfo.setToWorkDuration(ToWorkDuration);
			otherInfo.setCompanyId(serviceContext.getCompanyId());
			otherInfo.setUserId(serviceContext.getUserId());
			otherInfo.setFolderId(folderId);
			candidateOtherInfoPersistence.update(otherInfo);
		}

		return otherInfo;

	}

	public CandidateOtherInfo updateCandidateStatus(long candidateId, String candidateStatus) {
		CandidateOtherInfo candiOtherInfo = candidateOtherInfoPersistence.fetchByCandidateId(candidateId);
		candiOtherInfo.setCandidateStatus(candidateStatus);
		candidateOtherInfoPersistence.update(candiOtherInfo);
		return candiOtherInfo;

	}
public CandidateOtherInfo updateCandidateStage(long candidateId, String candidateStage) {
	CandidateOtherInfo candidateOtherInfo=candidateOtherInfoPersistence.fetchByCandidateId(candidateId);
	candidateOtherInfo.setCandidateStage(candidateStage);
	return candidateOtherInfoPersistence.update(candidateOtherInfo);
	
}
	public CandidateOtherInfo deleCandidateOtherInfo(long candidateOtherInfoId)
			throws NoSuchCandidateOtherInfoException {
		return candidateOtherInfoPersistence.remove(candidateOtherInfoId);
	}

	public CandidateOtherInfo getByCandidtatesId(long candidateId) {
		return candidateOtherInfoPersistence.fetchByCandidatesId(candidateId);
	}

	public int getCandidateStatusCount(String candidateStatus) {
		List<CandidateOtherInfo> candidateStatusList = candidateOtherInfoPersistence
				.findByCandidateStatus(candidateStatus);
		long count = candidateStatusList.stream().count();
		return Math.toIntExact(count);

	}

}