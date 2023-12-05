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
 * @Descriptions: This class is used for viewing the project table and configuring columns.
 */
@Component(
        property = "frontend.data.set.name=" + ProjectConstant.PTOJECT_TABLE,
        service = FDSView.class
)
public class ProjectsTableFDSView extends BaseTableFDSView {

    @Override
    public FDSTableSchema getFDSTableSchema(Locale locale) {
        FDSTableSchemaBuilder fdsTableSchemaBuilder =
                _fdsTableSchemaBuilderFactory.create();
        return fdsTableSchemaBuilder.add(
                        "projectName", "Project Name",
                        fdsTableSchemaField -> fdsTableSchemaField.setContentRenderer(
                                "actionLink")
                ).add(
                        "name", "Client Name"
                ).add(
                        "contactEmail", "Email"
                ).add(
                        "proposedDate", "Project ProposedDate"
                ).add(
                        "confirmedDate", "Project ConfirmedDate"
                ).add(
                        "durationDate", "Duration"
                ).add(
                        "status", "status",
                        fdsTableSchemaField -> fdsTableSchemaField.setContentRenderer(
                                "status")
                ).add(
                        "code", "Project Code")
                .add(
                        "projectManager", "Project Manager")
                .add(
                        "deliveryLead", "Delivery Lead")
                .add(
                        "operationLead", "Operation Lead")
                .add(
                        "projectQaLead", "Project Qa Lead"
                ).build();
    }


    @Reference
    private FDSTableSchemaBuilderFactory _fdsTableSchemaBuilderFactory;

}