package com.esquare.intranet.project.management.internal.search;


import com.esquare.intranet.project.management.model.Projects;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
/**
 * ProjectsSearchRegistrar use the search framework’s registry to define certain things about our model entity’s ModelSearchDefinition.
 *
 * @author Mahammed Seleem
 */


@Component(immediate = true, service = {ProjectsSearchRegistrar.class})
public class ProjectsSearchRegistrar {
    @Activate
    protected void activate(BundleContext bundleContext) {
        _serviceRegistration = modelSearchRegistrarHelper.register(
                Projects.class, bundleContext,
                modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.COMPANY_ID,
                            Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
                            Field.GROUP_ID, Field.SCOPE_GROUP_ID,
                            Field.UID, Field.NAME, Field.DESCRIPTION, "code","projectName");
                    modelSearchDefinition.setModelIndexWriteContributor(
                            modelIndexWriterContributor);
                    modelSearchDefinition.setModelSummaryContributor(
                            modelSummaryContributor);
                });
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference(
            target = "(indexer.class.name=com.esquare.intranet.project.management.model.Projects)"
    )
    protected ModelIndexerWriterContributor<Projects>
            modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    @Reference(
            target = "(indexer.class.name=com.esquare.intranet.project.management.model.Projects)"
    )
    protected ModelSummaryContributor modelSummaryContributor;

    private ServiceRegistration<?> _serviceRegistration;
}
