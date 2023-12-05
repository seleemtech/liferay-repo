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

package com.esquare.intranet.project.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NotesService}.
 *
 * @author Mahammed Seleem
 * @see NotesService
 * @generated
 */
public class NotesServiceWrapper
	implements NotesService, ServiceWrapper<NotesService> {

	public NotesServiceWrapper() {
		this(null);
	}

	public NotesServiceWrapper(NotesService notesService) {
		_notesService = notesService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _notesService.getOSGiServiceIdentifier();
	}

	@Override
	public NotesService getWrappedService() {
		return _notesService;
	}

	@Override
	public void setWrappedService(NotesService notesService) {
		_notesService = notesService;
	}

	private NotesService _notesService;

}