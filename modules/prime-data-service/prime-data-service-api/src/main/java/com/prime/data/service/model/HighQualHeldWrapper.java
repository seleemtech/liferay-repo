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
 * This class is a wrapper for {@link HighQualHeld}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HighQualHeld
 * @generated
 */
public class HighQualHeldWrapper
	extends BaseModelWrapper<HighQualHeld>
	implements HighQualHeld, ModelWrapper<HighQualHeld> {

	public HighQualHeldWrapper(HighQualHeld highQualHeld) {
		super(highQualHeld);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("highQualHeldId", getHighQualHeldId());
		attributes.put("highQualHeld", getHighQualHeld());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long highQualHeldId = (Long)attributes.get("highQualHeldId");

		if (highQualHeldId != null) {
			setHighQualHeldId(highQualHeldId);
		}

		String highQualHeld = (String)attributes.get("highQualHeld");

		if (highQualHeld != null) {
			setHighQualHeld(highQualHeld);
		}
	}

	@Override
	public HighQualHeld cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the high qual held of this high qual held.
	 *
	 * @return the high qual held of this high qual held
	 */
	@Override
	public String getHighQualHeld() {
		return model.getHighQualHeld();
	}

	/**
	 * Returns the high qual held ID of this high qual held.
	 *
	 * @return the high qual held ID of this high qual held
	 */
	@Override
	public long getHighQualHeldId() {
		return model.getHighQualHeldId();
	}

	/**
	 * Returns the primary key of this high qual held.
	 *
	 * @return the primary key of this high qual held
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this high qual held.
	 *
	 * @return the uuid of this high qual held
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
	 * Sets the high qual held of this high qual held.
	 *
	 * @param highQualHeld the high qual held of this high qual held
	 */
	@Override
	public void setHighQualHeld(String highQualHeld) {
		model.setHighQualHeld(highQualHeld);
	}

	/**
	 * Sets the high qual held ID of this high qual held.
	 *
	 * @param highQualHeldId the high qual held ID of this high qual held
	 */
	@Override
	public void setHighQualHeldId(long highQualHeldId) {
		model.setHighQualHeldId(highQualHeldId);
	}

	/**
	 * Sets the primary key of this high qual held.
	 *
	 * @param primaryKey the primary key of this high qual held
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this high qual held.
	 *
	 * @param uuid the uuid of this high qual held
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected HighQualHeldWrapper wrap(HighQualHeld highQualHeld) {
		return new HighQualHeldWrapper(highQualHeld);
	}

}