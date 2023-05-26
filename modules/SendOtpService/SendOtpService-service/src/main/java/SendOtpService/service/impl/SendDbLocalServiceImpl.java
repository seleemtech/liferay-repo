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

package SendOtpService.service.impl;

import SendOtpService.model.SendDb;
import SendOtpService.service.base.SendDbLocalServiceBaseImpl;


import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=SendOtpService.model.SendDb",
	service = AopService.class
)
public class SendDbLocalServiceImpl extends SendDbLocalServiceBaseImpl {
	public SendDb addData(String Name,long mobileNumber) {
		long sendId=counterLocalService.increment();
		SendDb crd=sendDbPersistence.create(sendId);
		crd.setName(Name);
		crd.setMobileNumber(mobileNumber);
		sendDbPersistence.update(crd);
		return crd;
		
	}
}