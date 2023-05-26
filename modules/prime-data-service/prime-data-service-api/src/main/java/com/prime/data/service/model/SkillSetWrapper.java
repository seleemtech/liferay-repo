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
 * This class is a wrapper for {@link SkillSet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SkillSet
 * @generated
 */
public class SkillSetWrapper
	extends BaseModelWrapper<SkillSet>
	implements ModelWrapper<SkillSet>, SkillSet {

	public SkillSetWrapper(SkillSet skillSet) {
		super(skillSet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("skillSetId", getSkillSetId());
		attributes.put("skillCategory", getSkillCategory());
		attributes.put("skillCategoryTools", getSkillCategoryTools());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long skillSetId = (Long)attributes.get("skillSetId");

		if (skillSetId != null) {
			setSkillSetId(skillSetId);
		}

		String skillCategory = (String)attributes.get("skillCategory");

		if (skillCategory != null) {
			setSkillCategory(skillCategory);
		}

		String skillCategoryTools = (String)attributes.get(
			"skillCategoryTools");

		if (skillCategoryTools != null) {
			setSkillCategoryTools(skillCategoryTools);
		}
	}

	@Override
	public SkillSet cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this skill set.
	 *
	 * @return the primary key of this skill set
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the skill category of this skill set.
	 *
	 * @return the skill category of this skill set
	 */
	@Override
	public String getSkillCategory() {
		return model.getSkillCategory();
	}

	/**
	 * Returns the skill category tools of this skill set.
	 *
	 * @return the skill category tools of this skill set
	 */
	@Override
	public String getSkillCategoryTools() {
		return model.getSkillCategoryTools();
	}

	/**
	 * Returns the skill set ID of this skill set.
	 *
	 * @return the skill set ID of this skill set
	 */
	@Override
	public long getSkillSetId() {
		return model.getSkillSetId();
	}

	/**
	 * Returns the uuid of this skill set.
	 *
	 * @return the uuid of this skill set
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
	 * Sets the primary key of this skill set.
	 *
	 * @param primaryKey the primary key of this skill set
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the skill category of this skill set.
	 *
	 * @param skillCategory the skill category of this skill set
	 */
	@Override
	public void setSkillCategory(String skillCategory) {
		model.setSkillCategory(skillCategory);
	}

	/**
	 * Sets the skill category tools of this skill set.
	 *
	 * @param skillCategoryTools the skill category tools of this skill set
	 */
	@Override
	public void setSkillCategoryTools(String skillCategoryTools) {
		model.setSkillCategoryTools(skillCategoryTools);
	}

	/**
	 * Sets the skill set ID of this skill set.
	 *
	 * @param skillSetId the skill set ID of this skill set
	 */
	@Override
	public void setSkillSetId(long skillSetId) {
		model.setSkillSetId(skillSetId);
	}

	/**
	 * Sets the uuid of this skill set.
	 *
	 * @param uuid the uuid of this skill set
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected SkillSetWrapper wrap(SkillSet skillSet) {
		return new SkillSetWrapper(skillSet);
	}

}