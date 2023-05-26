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

package com.job.opening.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Addressinfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Addressinfo
 * @generated
 */
public class AddressinfoWrapper
	extends BaseModelWrapper<Addressinfo>
	implements Addressinfo, ModelWrapper<Addressinfo> {

	public AddressinfoWrapper(Addressinfo addressinfo) {
		super(addressinfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("addressId", getAddressId());
		attributes.put("jobId", getJobId());
		attributes.put("remote", isRemote());
		attributes.put("city", getCity());
		attributes.put("country", getCountry());
		attributes.put("state", getState());
		attributes.put("postalCode", getPostalCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		Boolean remote = (Boolean)attributes.get("remote");

		if (remote != null) {
			setRemote(remote);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Long postalCode = (Long)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}
	}

	@Override
	public Addressinfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address ID of this addressinfo.
	 *
	 * @return the address ID of this addressinfo
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * Returns the city of this addressinfo.
	 *
	 * @return the city of this addressinfo
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the country of this addressinfo.
	 *
	 * @return the country of this addressinfo
	 */
	@Override
	public String getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the job ID of this addressinfo.
	 *
	 * @return the job ID of this addressinfo
	 */
	@Override
	public long getJobId() {
		return model.getJobId();
	}

	/**
	 * Returns the postal code of this addressinfo.
	 *
	 * @return the postal code of this addressinfo
	 */
	@Override
	public long getPostalCode() {
		return model.getPostalCode();
	}

	/**
	 * Returns the primary key of this addressinfo.
	 *
	 * @return the primary key of this addressinfo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remote of this addressinfo.
	 *
	 * @return the remote of this addressinfo
	 */
	@Override
	public boolean getRemote() {
		return model.getRemote();
	}

	/**
	 * Returns the state of this addressinfo.
	 *
	 * @return the state of this addressinfo
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the uuid of this addressinfo.
	 *
	 * @return the uuid of this addressinfo
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this addressinfo is remote.
	 *
	 * @return <code>true</code> if this addressinfo is remote; <code>false</code> otherwise
	 */
	@Override
	public boolean isRemote() {
		return model.isRemote();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address ID of this addressinfo.
	 *
	 * @param addressId the address ID of this addressinfo
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the city of this addressinfo.
	 *
	 * @param city the city of this addressinfo
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the country of this addressinfo.
	 *
	 * @param country the country of this addressinfo
	 */
	@Override
	public void setCountry(String country) {
		model.setCountry(country);
	}

	/**
	 * Sets the job ID of this addressinfo.
	 *
	 * @param jobId the job ID of this addressinfo
	 */
	@Override
	public void setJobId(long jobId) {
		model.setJobId(jobId);
	}

	/**
	 * Sets the postal code of this addressinfo.
	 *
	 * @param postalCode the postal code of this addressinfo
	 */
	@Override
	public void setPostalCode(long postalCode) {
		model.setPostalCode(postalCode);
	}

	/**
	 * Sets the primary key of this addressinfo.
	 *
	 * @param primaryKey the primary key of this addressinfo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this addressinfo is remote.
	 *
	 * @param remote the remote of this addressinfo
	 */
	@Override
	public void setRemote(boolean remote) {
		model.setRemote(remote);
	}

	/**
	 * Sets the state of this addressinfo.
	 *
	 * @param state the state of this addressinfo
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the uuid of this addressinfo.
	 *
	 * @param uuid the uuid of this addressinfo
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected AddressinfoWrapper wrap(Addressinfo addressinfo) {
		return new AddressinfoWrapper(addressinfo);
	}

}