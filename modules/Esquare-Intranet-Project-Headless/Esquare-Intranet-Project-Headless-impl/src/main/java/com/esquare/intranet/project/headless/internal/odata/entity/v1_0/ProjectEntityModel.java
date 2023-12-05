/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.esquare.intranet.project.headless.internal.odata.entity.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.*;

import java.util.Map;

/**
 * @author Mahammed Seleem
 */
public class ProjectEntityModel implements EntityModel {

    public ProjectEntityModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new StringEntityField(
                        "name", locale -> Field.getSortableFieldName(Field.NAME)),
                new StringEntityField(
                        "description", locale -> Field.getSortableFieldName(Field.DESCRIPTION)),
                new DateTimeEntityField(
                        "proposedDate",
                        locale -> Field.getSortableFieldName("proposedDate"),
                        locale -> "proposedDate"),
                new DateTimeEntityField(
                        "confirmedDate",
                        locale -> Field.getSortableFieldName("confirmedDate"),
                        locale -> "confirmedDate"),
                new DateTimeEntityField(
                        "developmentStartDate",
                        locale -> Field.getSortableFieldName("developmentStartDate"),
                        locale -> "developmentStartDate"),
                new StringEntityField(
                        "durationDate", locale -> Field.getSortableFieldName("durationDate")),
                new StringEntityField(
                        "status", locale -> Field.getSortableFieldName("status")),
                new StringEntityField(
                        "code", locale -> Field.getSortableFieldName("code")),
                new StringEntityField(
                        "projectName", locale -> Field.getSortableFieldName("projectName")),
                new StringEntityField(
                        "contactNumber", locale -> Field.getSortableFieldName("contactNumber")),
                new StringEntityField(
                        "contactEmail", locale -> Field.getSortableFieldName("contactEmail"))
        )   ;
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;

}