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

import com.candidate.service.exception.NoSuchCandidateInfoException;
import com.candidate.service.model.CandidateInfo;
import com.candidate.service.service.base.CandidateInfoLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.candidate.service.model.CandidateInfo",
	service = AopService.class
)
public class CandidateInfoLocalServiceImpl
	extends CandidateInfoLocalServiceBaseImpl {
	public CandidateInfo addOrUpdateCandidate(long candidateId,String firstName,String lastName,String email,String secondaryEmail,String mobileNumber,String country,String street,String city,String state,String zipCode,String houseNumber,String website,ServiceContext serviceContext) {
		CandidateInfo candidate=null;
		try {
			System.out.println("Update method");
		    candidate = candidateInfoPersistence.findByPrimaryKey(candidateId);
		    candidate.setFirstName(firstName);
		    candidate.setLastName(lastName);
		    candidate.setEmail(email);
		    candidate.setMobileNumber(mobileNumber);
		    candidate.setStreet(street);
		    candidate.setCity(city);
		    candidate.setState(state);
		    candidate.setZipCode(zipCode);
		    candidate.setCountry(country);
		    candidate.setHouseNumber(houseNumber);
		    candidate.setWebsite(website);
		    candidate.setSecondaryEmail(secondaryEmail);
		    candidate.setCompanyId(serviceContext.getCompanyId());
		    candidate.setUserId(serviceContext.getUserId());
		    candidateInfoPersistence.update(candidate);
		} catch (NoSuchCandidateInfoException e) {
			System.out.println("Add method");
			candidateId=counterLocalService.increment();
		    candidate = candidateInfoPersistence.create(candidateId);
		    candidate.setFirstName(firstName);
		    candidate.setLastName(lastName);
		    candidate.setEmail(email);
		    candidate.setMobileNumber(mobileNumber);
		    candidate.setStreet(street);
		    candidate.setCity(city);
		    candidate.setState(state);
		    candidate.setZipCode(zipCode);
		    candidate.setCountry(country);
		    candidate.setHouseNumber(houseNumber);
		    candidate.setWebsite(website);
		    candidate.setSecondaryEmail(secondaryEmail);
		    candidate.setCompanyId(serviceContext.getCompanyId());
		    candidate.setUserId(serviceContext.getUserId());
		    candidateInfoPersistence.update(candidate);
		}

		
		return candidate;
		
	}
	public CandidateInfo deleteCandidate(long candidateId) throws NoSuchCandidateInfoException {
		return candidateInfoPersistence.remove(candidateId);
		
	}
}