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

package com.prime.data.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NamePrefix}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NamePrefix
 * @generated
 */
public class NamePrefixWrapper
	extends BaseModelWrapper<NamePrefix>
	implements ModelWrapper<NamePrefix>, NamePrefix {

	public NamePrefixWrapper(NamePrefix namePrefix) {
		super(namePrefix);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("namePrefixId", getNamePrefixId());
		attributes.put("namePrefix", getNamePrefix());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long namePrefixId = (Long)attributes.get("namePrefixId");

		if (namePrefixId != null) {
			setNamePrefixId(namePrefixId);
		}

		String namePrefix = (String)attributes.get("namePrefix");

		if (namePrefix != null) {
			setNamePrefix(namePrefix);
		}
	}

	@Override
	public NamePrefix cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the name prefix of this name prefix.
	 *
	 * @return the name prefix of this name prefix
	 */
	@Override
	public String getNamePrefix() {
		return model.getNamePrefix();
	}

	/**
	 * Returns the name prefix ID of this name prefix.
	 *
	 * @return the name prefix ID of this name prefix
	 */
	@Override
	public long getNamePrefixId() {
		return model.getNamePrefixId();
	}

	/**
	 * Returns the primary key of this name prefix.
	 *
	 * @return the primary key of this name prefix
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this name prefix.
	 *
	 * @return the uuid of this name prefix
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
	 * Sets the name prefix of this name prefix.
	 *
	 * @param namePrefix the name prefix of this name prefix
	 */
	@Override
	public void setNamePrefix(String namePrefix) {
		model.setNamePrefix(namePrefix);
	}

	/**
	 * Sets the name prefix ID of this name prefix.
	 *
	 * @param namePrefixId the name prefix ID of this name prefix
	 */
	@Override
	public void setNamePrefixId(long namePrefixId) {
		model.setNamePrefixId(namePrefixId);
	}

	/**
	 * Sets the primary key of this name prefix.
	 *
	 * @param primaryKey the primary key of this name prefix
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this name prefix.
	 *
	 * @param uuid the uuid of this name prefix
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected NamePrefixWrapper wrap(NamePrefix namePrefix) {
		return new NamePrefixWrapper(namePrefix);
	}

}