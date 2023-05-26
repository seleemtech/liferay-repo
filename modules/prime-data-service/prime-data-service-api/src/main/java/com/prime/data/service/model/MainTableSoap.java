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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.MainTableServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MainTableSoap implements Serializable {

	public static MainTableSoap toSoapModel(MainTable model) {
		MainTableSoap soapModel = new MainTableSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCategory(model.getCategory());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static MainTableSoap[] toSoapModels(MainTable[] models) {
		MainTableSoap[] soapModels = new MainTableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MainTableSoap[][] toSoapModels(MainTable[][] models) {
		MainTableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MainTableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MainTableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MainTableSoap[] toSoapModels(List<MainTable> models) {
		List<MainTableSoap> soapModels = new ArrayList<MainTableSoap>(
			models.size());

		for (MainTable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MainTableSoap[soapModels.size()]);
	}

	public MainTableSoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _uuid;
	private long _categoryId;
	private String _category;
	private String _name;

}