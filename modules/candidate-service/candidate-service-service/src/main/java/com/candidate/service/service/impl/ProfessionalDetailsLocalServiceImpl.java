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

import com.candidate.service.exception.NoSuchProfessionalDetailsException;
import com.candidate.service.model.ProfessionalDetails;
import com.candidate.service.service.base.ProfessionalDetailsLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.candidate.service.model.ProfessionalDetails", service = AopService.class)
public class ProfessionalDetailsLocalServiceImpl extends ProfessionalDetailsLocalServiceBaseImpl {
	public ProfessionalDetails getByCandidateId(long candidateId) throws NoSuchProfessionalDetailsException {
		return professionalDetailsPersistence.findByCandidateId(candidateId);
	}

	public ProfessionalDetails updateProfDetails(long professionalDetailsId, long candidateId, double expectedSalary,
			double currentSalary, String skillSet, String additionalInfo, String currentEmployer, String workType,
			String experience, String qualification, String jobTitle, ServiceContext serviceContext) {
		ProfessionalDetails profDetails =null;
		try {
			System.out.println(" Profes Update method");
		    profDetails = professionalDetailsPersistence.fetchByPrimaryKey(professionalDetailsId);
		    profDetails.setCandidateId(candidateId);
		    profDetails.setExpectedSalary(expectedSalary);
		    profDetails.setCurrentSalary(currentSalary);
		    profDetails.setSkillSet(skillSet);
		    profDetails.setAdditionalInfo(additionalInfo);
		    profDetails.setCurrentEmployer(currentEmployer);
		    profDetails.setWorkType(workType);
		    profDetails.setExperience(experience);
		    profDetails.setQualification(qualification);
		    profDetails.setJobTitle(jobTitle);
		    profDetails.setCompanyId(serviceContext.getCompanyId());
		    profDetails.setUserId(serviceContext.getUserId());
		    professionalDetailsPersistence.update(profDetails);
		} catch (Exception e) {
		    // handle the exception
			System.out.println(" Profes add method");
			professionalDetailsId=counterLocalService.increment();
		     profDetails = professionalDetailsPersistence.create(professionalDetailsId);
		    profDetails.setCandidateId(candidateId);
		    profDetails.setExpectedSalary(expectedSalary);
		    profDetails.setCurrentSalary(currentSalary);
		    profDetails.setSkillSet(skillSet);
		    profDetails.setAdditionalInfo(additionalInfo);
		    profDetails.setCurrentEmployer(currentEmployer);
		    profDetails.setWorkType(workType);
		    profDetails.setExperience(experience);
		    profDetails.setQualification(qualification);
		    profDetails.setJobTitle(jobTitle);
		    profDetails.setCompanyId(serviceContext.getCompanyId());
		    profDetails.setUserId(serviceContext.getUserId());
		    professionalDetailsPersistence.update(profDetails);
		}

	
		return profDetails;

	}
	public ProfessionalDetails deleteProfessionalDetails(long professionalDetailsId) throws PortalException{
		return professionalDetailsPersistence.remove(professionalDetailsId);
	}
}