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

package SendOtpService.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SendDb}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SendDb
 * @generated
 */
public class SendDbWrapper
	extends BaseModelWrapper<SendDb> implements ModelWrapper<SendDb>, SendDb {

	public SendDbWrapper(SendDb sendDb) {
		super(sendDb);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sendId", getSendId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("Name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sendId = (Long)attributes.get("sendId");

		if (sendId != null) {
			setSendId(sendId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long mobileNumber = (Long)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}
	}

	@Override
	public SendDb cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this send db.
	 *
	 * @return the company ID of this send db
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the mobile number of this send db.
	 *
	 * @return the mobile number of this send db
	 */
	@Override
	public long getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the name of this send db.
	 *
	 * @return the name of this send db
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this send db.
	 *
	 * @return the primary key of this send db
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the send ID of this send db.
	 *
	 * @return the send ID of this send db
	 */
	@Override
	public long getSendId() {
		return model.getSendId();
	}

	/**
	 * Returns the user ID of this send db.
	 *
	 * @return the user ID of this send db
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this send db.
	 *
	 * @return the user name of this send db
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this send db.
	 *
	 * @return the user uuid of this send db
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this send db.
	 *
	 * @return the uuid of this send db
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
	 * Sets the company ID of this send db.
	 *
	 * @param companyId the company ID of this send db
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the mobile number of this send db.
	 *
	 * @param mobileNumber the mobile number of this send db
	 */
	@Override
	public void setMobileNumber(long mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the name of this send db.
	 *
	 * @param Name the name of this send db
	 */
	@Override
	public void setName(String Name) {
		model.setName(Name);
	}

	/**
	 * Sets the primary key of this send db.
	 *
	 * @param primaryKey the primary key of this send db
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the send ID of this send db.
	 *
	 * @param sendId the send ID of this send db
	 */
	@Override
	public void setSendId(long sendId) {
		model.setSendId(sendId);
	}

	/**
	 * Sets the user ID of this send db.
	 *
	 * @param userId the user ID of this send db
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this send db.
	 *
	 * @param userName the user name of this send db
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this send db.
	 *
	 * @param userUuid the user uuid of this send db
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this send db.
	 *
	 * @param uuid the uuid of this send db
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected SendDbWrapper wrap(SendDb sendDb) {
		return new SendDbWrapper(sendDb);
	}

}