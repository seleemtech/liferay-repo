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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Fitness}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Fitness
 * @generated
 */
public class FitnessWrapper
	extends BaseModelWrapper<Fitness>
	implements Fitness, ModelWrapper<Fitness> {

	public FitnessWrapper(Fitness fitness) {
		super(fitness);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("trainerId", getTrainerId());
		attributes.put("trainerName", getTrainerName());
		attributes.put("gender", getGender());
		attributes.put("age", getAge());
		attributes.put("experiance", getExperiance());
		attributes.put("Type", getType());
		attributes.put("conNumber", getConNumber());
		attributes.put("image", getImage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long trainerId = (Long)attributes.get("trainerId");

		if (trainerId != null) {
			setTrainerId(trainerId);
		}

		String trainerName = (String)attributes.get("trainerName");

		if (trainerName != null) {
			setTrainerName(trainerName);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long age = (Long)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Long experiance = (Long)attributes.get("experiance");

		if (experiance != null) {
			setExperiance(experiance);
		}

		String Type = (String)attributes.get("Type");

		if (Type != null) {
			setType(Type);
		}

		Long conNumber = (Long)attributes.get("conNumber");

		if (conNumber != null) {
			setConNumber(conNumber);
		}

		Long image = (Long)attributes.get("image");

		if (image != null) {
			setImage(image);
		}
	}

	@Override
	public Fitness cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the age of this fitness.
	 *
	 * @return the age of this fitness
	 */
	@Override
	public long getAge() {
		return model.getAge();
	}

	/**
	 * Returns the con number of this fitness.
	 *
	 * @return the con number of this fitness
	 */
	@Override
	public long getConNumber() {
		return model.getConNumber();
	}

	/**
	 * Returns the experiance of this fitness.
	 *
	 * @return the experiance of this fitness
	 */
	@Override
	public long getExperiance() {
		return model.getExperiance();
	}

	/**
	 * Returns the gender of this fitness.
	 *
	 * @return the gender of this fitness
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the image of this fitness.
	 *
	 * @return the image of this fitness
	 */
	@Override
	public long getImage() {
		return model.getImage();
	}

	/**
	 * Returns the primary key of this fitness.
	 *
	 * @return the primary key of this fitness
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the trainer ID of this fitness.
	 *
	 * @return the trainer ID of this fitness
	 */
	@Override
	public long getTrainerId() {
		return model.getTrainerId();
	}

	/**
	 * Returns the trainer name of this fitness.
	 *
	 * @return the trainer name of this fitness
	 */
	@Override
	public String getTrainerName() {
		return model.getTrainerName();
	}

	/**
	 * Returns the type of this fitness.
	 *
	 * @return the type of this fitness
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the uuid of this fitness.
	 *
	 * @return the uuid of this fitness
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
	 * Sets the age of this fitness.
	 *
	 * @param age the age of this fitness
	 */
	@Override
	public void setAge(long age) {
		model.setAge(age);
	}

	/**
	 * Sets the con number of this fitness.
	 *
	 * @param conNumber the con number of this fitness
	 */
	@Override
	public void setConNumber(long conNumber) {
		model.setConNumber(conNumber);
	}

	/**
	 * Sets the experiance of this fitness.
	 *
	 * @param experiance the experiance of this fitness
	 */
	@Override
	public void setExperiance(long experiance) {
		model.setExperiance(experiance);
	}

	/**
	 * Sets the gender of this fitness.
	 *
	 * @param gender the gender of this fitness
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the image of this fitness.
	 *
	 * @param image the image of this fitness
	 */
	@Override
	public void setImage(long image) {
		model.setImage(image);
	}

	/**
	 * Sets the primary key of this fitness.
	 *
	 * @param primaryKey the primary key of this fitness
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the trainer ID of this fitness.
	 *
	 * @param trainerId the trainer ID of this fitness
	 */
	@Override
	public void setTrainerId(long trainerId) {
		model.setTrainerId(trainerId);
	}

	/**
	 * Sets the trainer name of this fitness.
	 *
	 * @param trainerName the trainer name of this fitness
	 */
	@Override
	public void setTrainerName(String trainerName) {
		model.setTrainerName(trainerName);
	}

	/**
	 * Sets the type of this fitness.
	 *
	 * @param Type the type of this fitness
	 */
	@Override
	public void setType(String Type) {
		model.setType(Type);
	}

	/**
	 * Sets the uuid of this fitness.
	 *
	 * @param uuid the uuid of this fitness
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected FitnessWrapper wrap(Fitness fitness) {
		return new FitnessWrapper(fitness);
	}

}