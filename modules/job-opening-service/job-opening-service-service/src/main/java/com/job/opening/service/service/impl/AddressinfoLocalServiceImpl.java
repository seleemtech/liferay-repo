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

import com.job.opening.service.model.Addressinfo;
import com.job.opening.service.service.AddressinfoLocalServiceUtil;
import com.job.opening.service.service.base.AddressinfoLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.job.opening.service.model.Addressinfo", service = AopService.class)
public class AddressinfoLocalServiceImpl extends AddressinfoLocalServiceBaseImpl {
	public Addressinfo findByjobId(long jobId) {
		return addressinfoPersistence.fetchByjobId(jobId);
	}

	public Addressinfo createAddress(String city, String country, String state, long postalCode, long jobId)
			throws PortalException {
		Addressinfo ai = AddressinfoLocalServiceUtil.createAddressinfo(CounterLocalServiceUtil.increment());
		ai.setCountry(country);
		ai.setState(state);
		ai.setCity(city);
		ai.setPostalCode(postalCode);
		ai.setJobId(jobId);
		return AddressinfoLocalServiceUtil.addAddressinfo(ai);
	}

	public Addressinfo updateAddress(String city, String country, String state, long postalCode, long jobId)
			throws PortalException {
		Addressinfo ai = AddressinfoLocalServiceUtil.findByjobId(jobId);
		ai.setCountry(country);
		ai.setState(state);
		ai.setCity(city);
		ai.setPostalCode(postalCode);
		ai.setJobId(jobId);
		return AddressinfoLocalServiceUtil.updateAddressinfo(ai);
	}
}