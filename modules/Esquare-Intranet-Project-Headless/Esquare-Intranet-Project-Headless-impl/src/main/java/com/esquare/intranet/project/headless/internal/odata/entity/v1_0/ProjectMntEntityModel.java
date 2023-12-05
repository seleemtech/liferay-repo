package com.esquare.intranet.project.headless.internal.odata.entity.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.*;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * class VitaminEntityModel: An important note - in order to support filtering on data or sorting on data,
 * the fields to allow must be listed in this entity model class.
 *
 * You don't need to have every field of your component class listed in here, you just need the ones that
 * will be used for filtering and sorting.
 */
public class ProjectMntEntityModel implements EntityModel {
    public ProjectMntEntityModel() {
        _entityFieldsMap = Stream.of(
                // chemicalNames is a string array of the chemical names of the vitamins/minerals

                // we'll support filtering based upon user creator id.

                // sorting/filtering on name is okay too
                new StringEntityField(
                        "name", locale -> Field.getSortableFieldName(Field.NAME)),

                // as is sorting/filtering on the vitamin group

                // and the type (vitamin, mineral, other).
                new StringEntityField(
                        "description", locale -> Field.getSortableFieldName("description"))
        ).collect(
                Collectors.toMap(EntityField::getName, Function.identity())
        );
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    private final Map<String, EntityField> _entityFieldsMap;
}