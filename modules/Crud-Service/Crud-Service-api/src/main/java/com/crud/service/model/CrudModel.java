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

package com.crud.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Crud service. Represents a row in the &quot;FOO_Crud&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.crud.service.model.impl.CrudModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.crud.service.model.impl.CrudImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Crud
 * @generated
 */
@ProviderType
public interface CrudModel extends BaseModel<Crud> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a crud model instance should use the {@link Crud} interface instead.
	 */

	/**
	 * Returns the primary key of this crud.
	 *
	 * @return the primary key of this crud
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this crud.
	 *
	 * @param primaryKey the primary key of this crud
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this crud.
	 *
	 * @return the uuid of this crud
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this crud.
	 *
	 * @param uuid the uuid of this crud
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the crud ID of this crud.
	 *
	 * @return the crud ID of this crud
	 */
	public long getCrudId();

	/**
	 * Sets the crud ID of this crud.
	 *
	 * @param crudId the crud ID of this crud
	 */
	public void setCrudId(long crudId);

	/**
	 * Returns the crud no of this crud.
	 *
	 * @return the crud no of this crud
	 */
	public long getCrudNo();

	/**
	 * Sets the crud no of this crud.
	 *
	 * @param crudNo the crud no of this crud
	 */
	public void setCrudNo(long crudNo);

	/**
	 * Returns the crud name of this crud.
	 *
	 * @return the crud name of this crud
	 */
	@AutoEscape
	public String getCrudName();

	/**
	 * Sets the crud name of this crud.
	 *
	 * @param crudName the crud name of this crud
	 */
	public void setCrudName(String crudName);

	@Override
	public Crud cloneWithOriginalValues();

}