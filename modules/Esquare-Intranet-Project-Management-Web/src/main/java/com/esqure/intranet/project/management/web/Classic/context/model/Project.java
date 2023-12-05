/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.esqure.intranet.project.management.web.Classic.context.model;

/**
 * @author Gianmarco Brunialti Masera
 */
public class Project {

	public Project(
		long projectId, String name, String description,
		int code) {

		_projectId = projectId;
		_name = name;
		_description = description;
		_code = code;
	}

	public long getProjectId() {
		return _projectId;
	}

	public String getName() {
		return _name;
	}

	public String getDescription() {
		return _description;
	}

	public int getCode() {
		return _code;
	}


	private final long _projectId;
	private final String _name;
	private final String _description;
	private final int _code;

}