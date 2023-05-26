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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.SkillSetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SkillSetSoap implements Serializable {

	public static SkillSetSoap toSoapModel(SkillSet model) {
		SkillSetSoap soapModel = new SkillSetSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSkillSetId(model.getSkillSetId());
		soapModel.setSkillCategory(model.getSkillCategory());
		soapModel.setSkillCategoryTools(model.getSkillCategoryTools());

		return soapModel;
	}

	public static SkillSetSoap[] toSoapModels(SkillSet[] models) {
		SkillSetSoap[] soapModels = new SkillSetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SkillSetSoap[][] toSoapModels(SkillSet[][] models) {
		SkillSetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SkillSetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SkillSetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SkillSetSoap[] toSoapModels(List<SkillSet> models) {
		List<SkillSetSoap> soapModels = new ArrayList<SkillSetSoap>(
			models.size());

		for (SkillSet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SkillSetSoap[soapModels.size()]);
	}

	public SkillSetSoap() {
	}

	public long getPrimaryKey() {
		return _skillSetId;
	}

	public void setPrimaryKey(long pk) {
		setSkillSetId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSkillSetId() {
		return _skillSetId;
	}

	public void setSkillSetId(long skillSetId) {
		_skillSetId = skillSetId;
	}

	public String getSkillCategory() {
		return _skillCategory;
	}

	public void setSkillCategory(String skillCategory) {
		_skillCategory = skillCategory;
	}

	public String getSkillCategoryTools() {
		return _skillCategoryTools;
	}

	public void setSkillCategoryTools(String skillCategoryTools) {
		_skillCategoryTools = skillCategoryTools;
	}

	private String _uuid;
	private long _skillSetId;
	private String _skillCategory;
	private String _skillCategoryTools;

}