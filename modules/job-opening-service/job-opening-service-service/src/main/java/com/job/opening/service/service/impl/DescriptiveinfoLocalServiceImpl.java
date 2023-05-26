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

import com.job.opening.service.model.Descriptiveinfo;
import com.job.opening.service.service.DescriptiveinfoLocalServiceUtil;
import com.job.opening.service.service.base.DescriptiveinfoLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.job.opening.service.model.Descriptiveinfo", service = AopService.class)
public class DescriptiveinfoLocalServiceImpl extends DescriptiveinfoLocalServiceBaseImpl {
	public Descriptiveinfo findByjobId(long jobId) {
		return descriptiveinfoPersistence.fetchByjobId(jobId);
	}

	public Descriptiveinfo createDescription(String jobDescription, String requirements, String benefits, long jobId)
			throws PortalException {
		Descriptiveinfo di = DescriptiveinfoLocalServiceUtil.createDescriptiveinfo(CounterLocalServiceUtil.increment());
		di.setJobDescription(jobDescription);
		di.setRequirements(requirements);
		di.setBenefits(benefits);
		di.setJobId(jobId);
		return DescriptiveinfoLocalServiceUtil.addDescriptiveinfo(di);
	}

	public Descriptiveinfo updateDescription(String jobDescription, String requirements, String benefits, long jobId)
			throws PortalException {
		Descriptiveinfo di = DescriptiveinfoLocalServiceUtil.findByjobId(jobId);
		di.setJobDescription(jobDescription);
		di.setRequirements(requirements);
		di.setBenefits(benefits);
		di.setJobId(jobId);
		return DescriptiveinfoLocalServiceUtil.updateDescriptiveinfo(di);
	}
}