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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SkillSet service. Represents a row in the &quot;PRIME_SkillSet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.prime.data.service.model.impl.SkillSetModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.prime.data.service.model.impl.SkillSetImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SkillSet
 * @generated
 */
@ProviderType
public interface SkillSetModel extends BaseModel<SkillSet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a skill set model instance should use the {@link SkillSet} interface instead.
	 */

	/**
	 * Returns the primary key of this skill set.
	 *
	 * @return the primary key of this skill set
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this skill set.
	 *
	 * @param primaryKey the primary key of this skill set
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this skill set.
	 *
	 * @return the uuid of this skill set
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this skill set.
	 *
	 * @param uuid the uuid of this skill set
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the skill set ID of this skill set.
	 *
	 * @return the skill set ID of this skill set
	 */
	public long getSkillSetId();

	/**
	 * Sets the skill set ID of this skill set.
	 *
	 * @param skillSetId the skill set ID of this skill set
	 */
	public void setSkillSetId(long skillSetId);

	/**
	 * Returns the skill category of this skill set.
	 *
	 * @return the skill category of this skill set
	 */
	@AutoEscape
	public String getSkillCategory();

	/**
	 * Sets the skill category of this skill set.
	 *
	 * @param skillCategory the skill category of this skill set
	 */
	public void setSkillCategory(String skillCategory);

	/**
	 * Returns the skill category tools of this skill set.
	 *
	 * @return the skill category tools of this skill set
	 */
	@AutoEscape
	public String getSkillCategoryTools();

	/**
	 * Sets the skill category tools of this skill set.
	 *
	 * @param skillCategoryTools the skill category tools of this skill set
	 */
	public void setSkillCategoryTools(String skillCategoryTools);

	@Override
	public SkillSet cloneWithOriginalValues();

}