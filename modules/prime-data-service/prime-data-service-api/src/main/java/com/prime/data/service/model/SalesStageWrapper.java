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
 * This class is a wrapper for {@link SalesStage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesStage
 * @generated
 */
public class SalesStageWrapper
	extends BaseModelWrapper<SalesStage>
	implements ModelWrapper<SalesStage>, SalesStage {

	public SalesStageWrapper(SalesStage salesStage) {
		super(salesStage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("salesStageId", getSalesStageId());
		attributes.put("salesStage", getSalesStage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long salesStageId = (Long)attributes.get("salesStageId");

		if (salesStageId != null) {
			setSalesStageId(salesStageId);
		}

		String salesStage = (String)attributes.get("salesStage");

		if (salesStage != null) {
			setSalesStage(salesStage);
		}
	}

	@Override
	public SalesStage cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this sales stage.
	 *
	 * @return the primary key of this sales stage
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sales stage of this sales stage.
	 *
	 * @return the sales stage of this sales stage
	 */
	@Override
	public String getSalesStage() {
		return model.getSalesStage();
	}

	/**
	 * Returns the sales stage ID of this sales stage.
	 *
	 * @return the sales stage ID of this sales stage
	 */
	@Override
	public long getSalesStageId() {
		return model.getSalesStageId();
	}

	/**
	 * Returns the uuid of this sales stage.
	 *
	 * @return the uuid of this sales stage
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
	 * Sets the primary key of this sales stage.
	 *
	 * @param primaryKey the primary key of this sales stage
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sales stage of this sales stage.
	 *
	 * @param salesStage the sales stage of this sales stage
	 */
	@Override
	public void setSalesStage(String salesStage) {
		model.setSalesStage(salesStage);
	}

	/**
	 * Sets the sales stage ID of this sales stage.
	 *
	 * @param salesStageId the sales stage ID of this sales stage
	 */
	@Override
	public void setSalesStageId(long salesStageId) {
		model.setSalesStageId(salesStageId);
	}

	/**
	 * Sets the uuid of this sales stage.
	 *
	 * @param uuid the uuid of this sales stage
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected SalesStageWrapper wrap(SalesStage salesStage) {
		return new SalesStageWrapper(salesStage);
	}

}