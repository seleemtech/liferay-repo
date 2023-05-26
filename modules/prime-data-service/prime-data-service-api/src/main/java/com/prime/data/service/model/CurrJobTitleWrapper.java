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
 * This class is a wrapper for {@link CurrJobTitle}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrJobTitle
 * @generated
 */
public class CurrJobTitleWrapper
	extends BaseModelWrapper<CurrJobTitle>
	implements CurrJobTitle, ModelWrapper<CurrJobTitle> {

	public CurrJobTitleWrapper(CurrJobTitle currJobTitle) {
		super(currJobTitle);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("currJobTitleId", getCurrJobTitleId());
		attributes.put("currentJobTitle", getCurrentJobTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long currJobTitleId = (Long)attributes.get("currJobTitleId");

		if (currJobTitleId != null) {
			setCurrJobTitleId(currJobTitleId);
		}

		String currentJobTitle = (String)attributes.get("currentJobTitle");

		if (currentJobTitle != null) {
			setCurrentJobTitle(currentJobTitle);
		}
	}

	@Override
	public CurrJobTitle cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the current job title of this curr job title.
	 *
	 * @return the current job title of this curr job title
	 */
	@Override
	public String getCurrentJobTitle() {
		return model.getCurrentJobTitle();
	}

	/**
	 * Returns the curr job title ID of this curr job title.
	 *
	 * @return the curr job title ID of this curr job title
	 */
	@Override
	public long getCurrJobTitleId() {
		return model.getCurrJobTitleId();
	}

	/**
	 * Returns the primary key of this curr job title.
	 *
	 * @return the primary key of this curr job title
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this curr job title.
	 *
	 * @return the uuid of this curr job title
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
	 * Sets the current job title of this curr job title.
	 *
	 * @param currentJobTitle the current job title of this curr job title
	 */
	@Override
	public void setCurrentJobTitle(String currentJobTitle) {
		model.setCurrentJobTitle(currentJobTitle);
	}

	/**
	 * Sets the curr job title ID of this curr job title.
	 *
	 * @param currJobTitleId the curr job title ID of this curr job title
	 */
	@Override
	public void setCurrJobTitleId(long currJobTitleId) {
		model.setCurrJobTitleId(currJobTitleId);
	}

	/**
	 * Sets the primary key of this curr job title.
	 *
	 * @param primaryKey the primary key of this curr job title
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this curr job title.
	 *
	 * @param uuid the uuid of this curr job title
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CurrJobTitleWrapper wrap(CurrJobTitle currJobTitle) {
		return new CurrJobTitleWrapper(currJobTitle);
	}

}