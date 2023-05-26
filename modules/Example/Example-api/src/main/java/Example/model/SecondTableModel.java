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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SecondTable service. Represents a row in the &quot;FOO_SecondTable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>Example.model.impl.SecondTableModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>Example.model.impl.SecondTableImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecondTable
 * @generated
 */
@ProviderType
public interface SecondTableModel extends BaseModel<SecondTable>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a second table model instance should use the {@link SecondTable} interface instead.
	 */

	/**
	 * Returns the primary key of this second table.
	 *
	 * @return the primary key of this second table
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this second table.
	 *
	 * @param primaryKey the primary key of this second table
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the co ID of this second table.
	 *
	 * @return the co ID of this second table
	 */
	public long getCoId();

	/**
	 * Sets the co ID of this second table.
	 *
	 * @param coId the co ID of this second table
	 */
	public void setCoId(long coId);

	/**
	 * Returns the co name of this second table.
	 *
	 * @return the co name of this second table
	 */
	@AutoEscape
	public String getCoName();

	/**
	 * Sets the co name of this second table.
	 *
	 * @param coName the co name of this second table
	 */
	public void setCoName(String coName);

	/**
	 * Returns the company ID of this second table.
	 *
	 * @return the company ID of this second table
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this second table.
	 *
	 * @param companyId the company ID of this second table
	 */
	@Override
	public void setCompanyId(long companyId);

	@Override
	public SecondTable cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}