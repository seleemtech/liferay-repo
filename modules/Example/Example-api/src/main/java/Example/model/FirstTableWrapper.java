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

package Example.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FirstTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FirstTable
 * @generated
 */
public class FirstTableWrapper
	extends BaseModelWrapper<FirstTable>
	implements FirstTable, ModelWrapper<FirstTable> {

	public FirstTableWrapper(FirstTable firstTable) {
		super(firstTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("soId", getSoId());
		attributes.put("Name", getName());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long soId = (Long)attributes.get("soId");

		if (soId != null) {
			setSoId(soId);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public FirstTable cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this first table.
	 *
	 * @return the company ID of this first table
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the name of this first table.
	 *
	 * @return the name of this first table
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this first table.
	 *
	 * @return the primary key of this first table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the so ID of this first table.
	 *
	 * @return the so ID of this first table
	 */
	@Override
	public long getSoId() {
		return model.getSoId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this first table.
	 *
	 * @param companyId the company ID of this first table
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the name of this first table.
	 *
	 * @param Name the name of this first table
	 */
	@Override
	public void setName(String Name) {
		model.setName(Name);
	}

	/**
	 * Sets the primary key of this first table.
	 *
	 * @param primaryKey the primary key of this first table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the so ID of this first table.
	 *
	 * @param soId the so ID of this first table
	 */
	@Override
	public void setSoId(long soId) {
		model.setSoId(soId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FirstTableWrapper wrap(FirstTable firstTable) {
		return new FirstTableWrapper(firstTable);
	}

}