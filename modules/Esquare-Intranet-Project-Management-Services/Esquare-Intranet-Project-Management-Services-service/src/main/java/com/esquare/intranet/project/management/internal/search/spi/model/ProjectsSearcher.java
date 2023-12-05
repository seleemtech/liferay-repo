/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.esquare.intranet.project.management.internal.search.spi.model;

import com.esquare.intranet.project.management.model.Projects;

import com.liferay.portal.kernel.search.BaseSearcher;
import org.osgi.service.component.annotations.Component;

/**
 * @author Danny Situ
 */
@Component(
        property = "model.class.name=com.esquare.intranet.project.management.model.Projects",
        service = BaseSearcher.class
)
public class ProjectsSearcher extends BaseSearcher {

    public ProjectsSearcher() {
        setFilterSearch(true);
        setPermissionAware(false);
    }

    @Override
    public String getClassName() {
        return _CLASS_NAME;
    }

    private static final String _CLASS_NAME = Projects.class.getName();

}