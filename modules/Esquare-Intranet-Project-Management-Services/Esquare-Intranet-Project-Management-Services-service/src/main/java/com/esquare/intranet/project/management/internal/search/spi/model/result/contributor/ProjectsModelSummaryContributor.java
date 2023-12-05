package com.esquare.intranet.project.management.internal.search.spi.model.result.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;
/**
 * class ProjectsModelSummaryContributor: classes get the Summary object created for each search document,
 * so you can manipulate it by adding specific fields or setting the length of the displayed content.
 *
 * @author Mahammed Seleem
 */
@Component(
        immediate = true,
        property = "indexer.class.name=com.esquare.intranet.project.management.model.Projects",
        service = ModelSummaryContributor.class
)
public class ProjectsModelSummaryContributor implements ModelSummaryContributor {

    @Override
    public Summary getSummary(
            Document document, Locale locale, String snippet) {

        Summary summary = new Summary(
                document.get(Field.NAME),
                document.get(Field.DESCRIPTION));

        summary.setMaxContentLength(200);

        return summary;
    }
}
