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
 * This class is a wrapper for {@link SecondTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecondTable
 * @generated
 */
public class SecondTableWrapper
	extends BaseModelWrapper<SecondTable>
	implements ModelWrapper<SecondTable>, SecondTable {

	public SecondTableWrapper(SecondTable secondTable) {
		super(secondTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("coId", getCoId());
		attributes.put("coName", getCoName());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long coId = (Long)attributes.get("coId");

		if (coId != null) {
			setCoId(coId);
		}

		String coName = (String)attributes.get("coName");

		if (coName != null) {
			setCoName(coName);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public SecondTable cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the co ID of this second table.
	 *
	 * @return the co ID of this second table
	 */
	@Override
	public long getCoId() {
		return model.getCoId();
	}

	/**
	 * Returns the company ID of this second table.
	 *
	 * @return the company ID of this second table
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the co name of this second table.
	 *
	 * @return the co name of this second table
	 */
	@Override
	public String getCoName() {
		return model.getCoName();
	}

	/**
	 * Returns the primary key of this second table.
	 *
	 * @return the primary key of this second table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the co ID of this second table.
	 *
	 * @param coId the co ID of this second table
	 */
	@Override
	public void setCoId(long coId) {
		model.setCoId(coId);
	}

	/**
	 * Sets the company ID of this second table.
	 *
	 * @param companyId the company ID of this second table
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the co name of this second table.
	 *
	 * @param coName the co name of this second table
	 */
	@Override
	public void setCoName(String coName) {
		model.setCoName(coName);
	}

	/**
	 * Sets the primary key of this second table.
	 *
	 * @param primaryKey the primary key of this second table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SecondTableWrapper wrap(SecondTable secondTable) {
		return new SecondTableWrapper(secondTable);
	}

}