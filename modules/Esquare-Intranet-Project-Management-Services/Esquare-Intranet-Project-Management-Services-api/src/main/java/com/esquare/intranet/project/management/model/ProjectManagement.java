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

package com.esquare.intranet.project.management.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ProjectManagement service. Represents a row in the &quot;Esquare_ProjectManagement&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mahammed Seleem
 * @see ProjectManagementModel
 * @generated
 */
@ImplementationClassName(
	"com.esquare.intranet.project.management.model.impl.ProjectManagementImpl"
)
@ProviderType
public interface ProjectManagement
	extends PersistedModel, ProjectManagementModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.esquare.intranet.project.management.model.impl.ProjectManagementImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProjectManagement, Long>
		PROJECT_MGMT_ID_ACCESSOR = new Accessor<ProjectManagement, Long>() {

			@Override
			public Long get(ProjectManagement projectManagement) {
				return projectManagement.getProjectMgmtId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProjectManagement> getTypeClass() {
				return ProjectManagement.class;
			}

		};

}