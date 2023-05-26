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
 * This class is a wrapper for {@link Specialization}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Specialization
 * @generated
 */
public class SpecializationWrapper
	extends BaseModelWrapper<Specialization>
	implements ModelWrapper<Specialization>, Specialization {

	public SpecializationWrapper(Specialization specialization) {
		super(specialization);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("graduationCode", getGraduationCode());
		attributes.put("specializationName", getSpecializationName());
		attributes.put("spCode", getSpCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String graduationCode = (String)attributes.get("graduationCode");

		if (graduationCode != null) {
			setGraduationCode(graduationCode);
		}

		String specializationName = (String)attributes.get(
			"specializationName");

		if (specializationName != null) {
			setSpecializationName(specializationName);
		}

		Long spCode = (Long)attributes.get("spCode");

		if (spCode != null) {
			setSpCode(spCode);
		}
	}

	@Override
	public Specialization cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the graduation code of this specialization.
	 *
	 * @return the graduation code of this specialization
	 */
	@Override
	public String getGraduationCode() {
		return model.getGraduationCode();
	}

	/**
	 * Returns the primary key of this specialization.
	 *
	 * @return the primary key of this specialization
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sp code of this specialization.
	 *
	 * @return the sp code of this specialization
	 */
	@Override
	public long getSpCode() {
		return model.getSpCode();
	}

	/**
	 * Returns the specialization name of this specialization.
	 *
	 * @return the specialization name of this specialization
	 */
	@Override
	public String getSpecializationName() {
		return model.getSpecializationName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the graduation code of this specialization.
	 *
	 * @param graduationCode the graduation code of this specialization
	 */
	@Override
	public void setGraduationCode(String graduationCode) {
		model.setGraduationCode(graduationCode);
	}

	/**
	 * Sets the primary key of this specialization.
	 *
	 * @param primaryKey the primary key of this specialization
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sp code of this specialization.
	 *
	 * @param spCode the sp code of this specialization
	 */
	@Override
	public void setSpCode(long spCode) {
		model.setSpCode(spCode);
	}

	/**
	 * Sets the specialization name of this specialization.
	 *
	 * @param specializationName the specialization name of this specialization
	 */
	@Override
	public void setSpecializationName(String specializationName) {
		model.setSpecializationName(specializationName);
	}

	@Override
	protected SpecializationWrapper wrap(Specialization specialization) {
		return new SpecializationWrapper(specialization);
	}

}