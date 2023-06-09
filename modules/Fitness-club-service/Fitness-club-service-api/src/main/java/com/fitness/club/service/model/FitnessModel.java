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

package com.fitness.club.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Fitness service. Represents a row in the &quot;FOO_Fitness&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.fitness.club.service.model.impl.FitnessModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.fitness.club.service.model.impl.FitnessImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Fitness
 * @generated
 */
@ProviderType
public interface FitnessModel extends BaseModel<Fitness> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fitness model instance should use the {@link Fitness} interface instead.
	 */

	/**
	 * Returns the primary key of this fitness.
	 *
	 * @return the primary key of this fitness
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fitness.
	 *
	 * @param primaryKey the primary key of this fitness
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this fitness.
	 *
	 * @return the uuid of this fitness
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this fitness.
	 *
	 * @param uuid the uuid of this fitness
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the trainer ID of this fitness.
	 *
	 * @return the trainer ID of this fitness
	 */
	public long getTrainerId();

	/**
	 * Sets the trainer ID of this fitness.
	 *
	 * @param trainerId the trainer ID of this fitness
	 */
	public void setTrainerId(long trainerId);

	/**
	 * Returns the trainer name of this fitness.
	 *
	 * @return the trainer name of this fitness
	 */
	@AutoEscape
	public String getTrainerName();

	/**
	 * Sets the trainer name of this fitness.
	 *
	 * @param trainerName the trainer name of this fitness
	 */
	public void setTrainerName(String trainerName);

	/**
	 * Returns the gender of this fitness.
	 *
	 * @return the gender of this fitness
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this fitness.
	 *
	 * @param gender the gender of this fitness
	 */
	public void setGender(String gender);

	/**
	 * Returns the age of this fitness.
	 *
	 * @return the age of this fitness
	 */
	public long getAge();

	/**
	 * Sets the age of this fitness.
	 *
	 * @param age the age of this fitness
	 */
	public void setAge(long age);

	/**
	 * Returns the experiance of this fitness.
	 *
	 * @return the experiance of this fitness
	 */
	public long getExperiance();

	/**
	 * Sets the experiance of this fitness.
	 *
	 * @param experiance the experiance of this fitness
	 */
	public void setExperiance(long experiance);

	/**
	 * Returns the type of this fitness.
	 *
	 * @return the type of this fitness
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this fitness.
	 *
	 * @param Type the type of this fitness
	 */
	public void setType(String Type);

	/**
	 * Returns the con number of this fitness.
	 *
	 * @return the con number of this fitness
	 */
	public long getConNumber();

	/**
	 * Sets the con number of this fitness.
	 *
	 * @param conNumber the con number of this fitness
	 */
	public void setConNumber(long conNumber);

	/**
	 * Returns the image of this fitness.
	 *
	 * @return the image of this fitness
	 */
	public long getImage();

	/**
	 * Sets the image of this fitness.
	 *
	 * @param image the image of this fitness
	 */
	public void setImage(long image);

	@Override
	public Fitness cloneWithOriginalValues();

}