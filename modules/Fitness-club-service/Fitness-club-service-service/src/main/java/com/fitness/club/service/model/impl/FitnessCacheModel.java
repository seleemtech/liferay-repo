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

package com.fitness.club.service.model.impl;

import com.fitness.club.service.model.Fitness;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Fitness in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FitnessCacheModel implements CacheModel<Fitness>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FitnessCacheModel)) {
			return false;
		}

		FitnessCacheModel fitnessCacheModel = (FitnessCacheModel)object;

		if (trainerId == fitnessCacheModel.trainerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, trainerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", trainerId=");
		sb.append(trainerId);
		sb.append(", trainerName=");
		sb.append(trainerName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", age=");
		sb.append(age);
		sb.append(", experiance=");
		sb.append(experiance);
		sb.append(", Type=");
		sb.append(Type);
		sb.append(", conNumber=");
		sb.append(conNumber);
		sb.append(", image=");
		sb.append(image);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Fitness toEntityModel() {
		FitnessImpl fitnessImpl = new FitnessImpl();

		if (uuid == null) {
			fitnessImpl.setUuid("");
		}
		else {
			fitnessImpl.setUuid(uuid);
		}

		fitnessImpl.setTrainerId(trainerId);

		if (trainerName == null) {
			fitnessImpl.setTrainerName("");
		}
		else {
			fitnessImpl.setTrainerName(trainerName);
		}

		if (gender == null) {
			fitnessImpl.setGender("");
		}
		else {
			fitnessImpl.setGender(gender);
		}

		fitnessImpl.setAge(age);
		fitnessImpl.setExperiance(experiance);

		if (Type == null) {
			fitnessImpl.setType("");
		}
		else {
			fitnessImpl.setType(Type);
		}

		fitnessImpl.setConNumber(conNumber);
		fitnessImpl.setImage(image);

		fitnessImpl.resetOriginalValues();

		return fitnessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		trainerId = objectInput.readLong();
		trainerName = objectInput.readUTF();
		gender = objectInput.readUTF();

		age = objectInput.readLong();

		experiance = objectInput.readLong();
		Type = objectInput.readUTF();

		conNumber = objectInput.readLong();

		image = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(trainerId);

		if (trainerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trainerName);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeLong(age);

		objectOutput.writeLong(experiance);

		if (Type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Type);
		}

		objectOutput.writeLong(conNumber);

		objectOutput.writeLong(image);
	}

	public String uuid;
	public long trainerId;
	public String trainerName;
	public String gender;
	public long age;
	public long experiance;
	public String Type;
	public long conNumber;
	public long image;

}