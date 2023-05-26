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

package com.rigistration.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Register}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Register
 * @generated
 */
public class RegisterWrapper
	extends BaseModelWrapper<Register>
	implements ModelWrapper<Register>, Register {

	public RegisterWrapper(Register register) {
		super(register);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("registerId", getRegisterId());
		attributes.put("firstName", getFirstName());
		attributes.put("phone", getPhone());
		attributes.put("userName", getUserName());
		attributes.put("password", getPassword());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long registerId = (Long)attributes.get("registerId");

		if (registerId != null) {
			setRegisterId(registerId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		Long phone = (Long)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}
	}

	@Override
	public Register cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the first name of this register.
	 *
	 * @return the first name of this register
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the password of this register.
	 *
	 * @return the password of this register
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the phone of this register.
	 *
	 * @return the phone of this register
	 */
	@Override
	public long getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this register.
	 *
	 * @return the primary key of this register
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the register ID of this register.
	 *
	 * @return the register ID of this register
	 */
	@Override
	public long getRegisterId() {
		return model.getRegisterId();
	}

	/**
	 * Returns the user name of this register.
	 *
	 * @return the user name of this register
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this register.
	 *
	 * @return the uuid of this register
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the first name of this register.
	 *
	 * @param firstName the first name of this register
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the password of this register.
	 *
	 * @param password the password of this register
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the phone of this register.
	 *
	 * @param phone the phone of this register
	 */
	@Override
	public void setPhone(long phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this register.
	 *
	 * @param primaryKey the primary key of this register
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the register ID of this register.
	 *
	 * @param registerId the register ID of this register
	 */
	@Override
	public void setRegisterId(long registerId) {
		model.setRegisterId(registerId);
	}

	/**
	 * Sets the user name of this register.
	 *
	 * @param userName the user name of this register
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this register.
	 *
	 * @param uuid the uuid of this register
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected RegisterWrapper wrap(Register register) {
		return new RegisterWrapper(register);
	}

}