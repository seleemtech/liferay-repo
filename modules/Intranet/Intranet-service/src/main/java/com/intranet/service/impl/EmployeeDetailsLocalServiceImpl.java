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

package com.intranet.service.impl;

import com.intranet.exception.NoSuchEmployeeDetailsException;
import com.intranet.model.EmployeeDetails;
import com.intranet.service.base.EmployeeDetailsLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.intranet.model.EmployeeDetails",
	service = AopService.class
)
public class EmployeeDetailsLocalServiceImpl
	extends EmployeeDetailsLocalServiceBaseImpl {
	public EmployeeDetails addEmployee(String employeename,String gender,String domain,long contact,String email,String address,String pannumber,String passportNumber,String aadhar,Date joiningDate,Date dob,boolean maritalstatus,Date anniversaryDate,long fileEntryId) throws PortalException {
		ServiceContext serviceContext=new ServiceContext();
		
		long creatorUserId = serviceContext.getUserId();
		    User user = UserLocalServiceUtil.addUser(creatorUserId, serviceContext.getCompanyId(), false, "test", "test", 
					false, employeename, email, serviceContext.getLocale(), employeename, "", employeename,
					0, 0, true, 1, 12, 1995, null, null, null, 
					null, null, false,  serviceContext);
		    
		    long employeeID = user.getUserId();
	    employeeID=counterLocalService.increment();
		EmployeeDetails employee=employeeDetailsPersistence.create(employeeID);
		employee.setEmployeename(employeename);
		employee.setGender(gender);
		employee.setDomain(domain);
		employee.setContact(contact);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setPannumber(pannumber);
		employee.setPassportNumber(passportNumber);
		employee.setAadhar(aadhar);
		employee.setJoiningDate(joiningDate);
		employee.setDob(dob);
		employee.setMaritalstatus(maritalstatus);
		employee.setAnniversaryDate(anniversaryDate);
		employee.setFileEntryId(fileEntryId);
		employeeDetailsPersistence.update(employee);
		
		
		return employee;
		
	}
	
	public EmployeeDetails updateEmployee(long employeeID, String employeename,String gender,String domain,long contact,String email,String address,String pannumber,String passportNumber,String aadhar,Date joiningDate,Date dob,boolean maritalstatus,Date anniversaryDate,long fileEntryId)
	{
		
		EmployeeDetails employee=employeeDetailsPersistence.fetchByPrimaryKey(employeeID);
		employee.setEmployeename(employeename);
		employee.setGender(gender);
		employee.setDomain(domain);
		employee.setContact(contact);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setPannumber(pannumber);
		employee.setPassportNumber(passportNumber);
		employee.setAadhar(aadhar);
		employee.setJoiningDate(joiningDate);
		employee.setDob(dob);
		employee.setMaritalstatus(maritalstatus);
		employee.setAnniversaryDate(anniversaryDate);
		employee.setFileEntryId(fileEntryId);
		employeeDetailsPersistence.update(employee);
		return employee;
		
	}
	public EmployeeDetails deleteEmployee(long employeeID) throws NoSuchEmployeeDetailsException {
		return employeeDetailsPersistence.remove(employeeID);
	}
}