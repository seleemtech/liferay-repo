/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.esqure.intranet.project.management.web.headless.frontent.table;

import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.liferay.frontend.data.set.view.FDSView;
import com.liferay.frontend.data.set.view.table.BaseTableFDSView;
import com.liferay.frontend.data.set.view.table.FDSTableSchema;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilder;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilderFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

/**
 * @author Mahammed Seleem
 * @Descriptions: This class is used for viewing the task table and configuring columns.
 */
@Component(
        property = "frontend.data.set.name=" + ProjectConstant.TASK_TABLE,
        service = FDSView.class
)
public class TaskTableFDSView extends BaseTableFDSView {

    @Override
    public FDSTableSchema getFDSTableSchema(Locale locale) {
        FDSTableSchemaBuilder fdsTableSchemaBuilder =
                _fdsTableSchemaBuilderFactory.create();
        return fdsTableSchemaBuilder.add(
                        "projectCode", "Project Code"
                ).add(
                        "name", "Task Name"
                ).add(
                        "description", "Description"
                ).add(
                        "taskStartDate", "Start Date"
                ).add(
                        "taskEndDate", "End Date"
                ).add(
                        "status", "status",
                        fdsTableSchemaField -> fdsTableSchemaField.setContentRenderer(
                                "status")
                ).add(
                        "developmentTeam", "Developer Team"
                ).add(
                        "testerTeam", "Tester Team"
                ).
                build();
    }


    @Reference
    private FDSTableSchemaBuilderFactory _fdsTableSchemaBuilderFactory;

}