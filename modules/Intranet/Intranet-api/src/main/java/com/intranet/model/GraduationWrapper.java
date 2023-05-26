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

package com.intranet.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Graduation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Graduation
 * @generated
 */
public class GraduationWrapper
	extends BaseModelWrapper<Graduation>
	implements Graduation, ModelWrapper<Graduation> {

	public GraduationWrapper(Graduation graduation) {
		super(graduation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("graduationCode", getGraduationCode());
		attributes.put("graduationName", getGraduationName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String graduationCode = (String)attributes.get("graduationCode");

		if (graduationCode != null) {
			setGraduationCode(graduationCode);
		}

		String graduationName = (String)attributes.get("graduationName");

		if (graduationName != null) {
			setGraduationName(graduationName);
		}
	}

	@Override
	public Graduation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the graduation code of this graduation.
	 *
	 * @return the graduation code of this graduation
	 */
	@Override
	public String getGraduationCode() {
		return model.getGraduationCode();
	}

	/**
	 * Returns the graduation name of this graduation.
	 *
	 * @return the graduation name of this graduation
	 */
	@Override
	public String getGraduationName() {
		return model.getGraduationName();
	}

	/**
	 * Returns the primary key of this graduation.
	 *
	 * @return the primary key of this graduation
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the graduation code of this graduation.
	 *
	 * @param graduationCode the graduation code of this graduation
	 */
	@Override
	public void setGraduationCode(String graduationCode) {
		model.setGraduationCode(graduationCode);
	}

	/**
	 * Sets the graduation name of this graduation.
	 *
	 * @param graduationName the graduation name of this graduation
	 */
	@Override
	public void setGraduationName(String graduationName) {
		model.setGraduationName(graduationName);
	}

	/**
	 * Sets the primary key of this graduation.
	 *
	 * @param primaryKey the primary key of this graduation
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GraduationWrapper wrap(Graduation graduation) {
		return new GraduationWrapper(graduation);
	}

}