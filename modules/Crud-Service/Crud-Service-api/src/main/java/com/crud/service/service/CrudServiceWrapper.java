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

package com.crud.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CrudService}.
 *
 * @author Brian Wing Shun Chan
 * @see CrudService
 * @generated
 */
public class CrudServiceWrapper
	implements CrudService, ServiceWrapper<CrudService> {

	public CrudServiceWrapper() {
		this(null);
	}

	public CrudServiceWrapper(CrudService crudService) {
		_crudService = crudService;
	}

	@Override
	public java.util.List<com.crud.service.model.Crud> getByCrudList(
		long crudId) {

		return _crudService.getByCrudList(crudId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crudService.getOSGiServiceIdentifier();
	}

	@Override
	public CrudService getWrappedService() {
		return _crudService;
	}

	@Override
	public void setWrappedService(CrudService crudService) {
		_crudService = crudService;
	}

	private CrudService _crudService;

}