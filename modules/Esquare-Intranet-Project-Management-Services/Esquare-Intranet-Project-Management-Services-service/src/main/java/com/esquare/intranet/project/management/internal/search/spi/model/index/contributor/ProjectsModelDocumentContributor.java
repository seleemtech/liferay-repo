package com.esquare.intranet.project.management.internal.search.spi.model.index.contributor;

import com.esquare.intranet.project.management.model.Projects;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

/**
 * class ProjectsModelDocumentContributor: This classes specify which database fields are indexed in the model entity’s search engine document.
 * This class’s contribute method is called each time the add and update methods in the entity’s service layer are called.
 *
 * @author Mahammed Seleem
 */
@Component(
        immediate = true,
        property = "indexer.class.name=com.esquare.intranet.project.management.model.Projects",
        service = ModelDocumentContributor.class
)
public class ProjectsModelDocumentContributor implements ModelDocumentContributor<Projects> {
    @Override
    public void contribute(Document document, Projects project) {
        document.addText(Field.DESCRIPTION, project.getDescription());
        document.addText(Field.NAME, project.getName());
        document.addKeyword(Field.ENTRY_CLASS_PK,project.getProjectId());
        document.addKeyword(

                "projectName", project.getProjectName());

        document.addKeyword("code", project.getCode());
     /*   document.addKeyword(Field.STATUS, project.getStatus());*/
       /* document.addText(Field.STATUS, project.getStatus());*/
        document.addKeywordSortable(
                Field.getSortableFieldName(Field.NAME),
                project.getName());
    }

}
