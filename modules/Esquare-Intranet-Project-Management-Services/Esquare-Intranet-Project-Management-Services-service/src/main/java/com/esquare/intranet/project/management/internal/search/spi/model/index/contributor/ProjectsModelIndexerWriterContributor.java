package com.esquare.intranet.project.management.internal.search.spi.model.index.contributor;

import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.ProjectsLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/** class ProjectsModelIndexerWriterContributor: This class’s method is called when a re-index is triggered from the Search administrative application found in
 * Control Panel → Configuration → Search, or when a CRUD operation is made on the entity,
 *
 */
@Component(
        immediate = true,
        property = "indexer.class.name=com.esquare.intranet.project.management.model.Projects",
        service = ModelIndexerWriterContributor.class
)
public class ProjectsModelIndexerWriterContributor implements ModelIndexerWriterContributor<Projects> {
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        // we don't need to customize the batchIndexingActionable guy, just use as is.

        batchIndexingActionable.setPerformActionMethod((Projects project) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(project);
            batchIndexingActionable.addDocuments(document);
        });
    }


    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(_projectsLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Projects project) {
        return project.getCompanyId();
    }

    @Override
    public IndexerWriterMode getIndexerWriterMode(Projects project) {
        return IndexerWriterMode.UPDATE;
    }

    @Reference
    private ProjectsLocalService _projectsLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}
