package com.esquare.intranet.project.management.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
/**
 * class ProjectsKeywordQueryContributor: This class contribute clauses to the ongoing search query.
 * This is called at search time.
 *
 * @author Mahammed Seleem
 */
@Component(
        immediate = true,
        property = "indexer.class.name=com.esquare.intranet.project.management.model.Projects",
        service = KeywordQueryContributor.class
)
public class ProjectsKeywordQueryContributor implements KeywordQueryContributor {
    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.ENTRY_CLASS_PK, false);
        // description is already in there...
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.NAME, false);

        // we want to add the code field
        queryHelper.addSearchTerm(
                booleanQuery, searchContext, "code", false);

        queryHelper.addSearchTerm(
                booleanQuery, searchContext, "projectName", false);
       /* queryHelper.addSearchTerm(
                booleanQuery, searchContext, Field.STATUS, false);*/
/*
 String code = GetterUtil.getString(
                searchContext.getAttribute("code"));

        if (!Validator.isBlank(code)) {
            booleanQuery.addTerm(
                   "code", code, Boolean.MUST);
        }
*/

    }

    @Reference
    protected QueryHelper queryHelper;
}
