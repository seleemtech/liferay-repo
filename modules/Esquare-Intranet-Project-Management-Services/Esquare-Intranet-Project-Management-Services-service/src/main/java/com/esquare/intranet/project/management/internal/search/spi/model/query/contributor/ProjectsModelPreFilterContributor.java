/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.esquare.intranet.project.management.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.MissingFilter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;
import org.osgi.service.component.annotations.Component;

/**
 * @author Danny Situ
 */
@Component(
        property = "indexer.class.name=com.liferay.commerce.model.CommerceOrder",
        service = ModelPreFilterContributor.class
)
public class ProjectsModelPreFilterContributor
        implements ModelPreFilterContributor {

    @Override
    public void contribute(
            BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
            SearchContext searchContext) {

        _filterByProjectId(booleanFilter, searchContext);
        /*	_filterByGroupIds(booleanFilter, searchContext);*/
        _filterByProjectStatus(booleanFilter, searchContext);
        _filterByProjectCode(booleanFilter, searchContext);
    }

    private void _filterByProjectId(
            BooleanFilter booleanFilter, SearchContext searchContext) {

        long projectId = GetterUtil.getLong(
                searchContext.getAttribute(Field.ENTRY_CLASS_PK));

        if (Validator.isNull(projectId)) {
            return;
        }

        BooleanFilter projectIdBooleanFilter = new BooleanFilter();


        Filter termFilter = new TermFilter(
                "projectId", String.valueOf(projectId));

        projectIdBooleanFilter.add(
                termFilter, BooleanClauseOccur.SHOULD);


        projectIdBooleanFilter.add(
                new MissingFilter("projectId"), BooleanClauseOccur.SHOULD);

        booleanFilter.add(
                projectIdBooleanFilter, BooleanClauseOccur.MUST);
    }

    private void _filterByGroupIds(
            BooleanFilter booleanFilter, SearchContext searchContext) {

        long[] groupIds = searchContext.getGroupIds();

        if ((groupIds == null) || (groupIds.length == 0)) {
            booleanFilter.addTerm(
                    Field.GROUP_ID, "-1", BooleanClauseOccur.MUST);
        }
    }

    private void _filterByProjectStatus(
            BooleanFilter booleanFilter, SearchContext searchContext) {

        String projectStatus = GetterUtil.getString(
                searchContext.getAttribute("status"));

        if (Validator.isNull(projectStatus)) {
            return;
        }

        BooleanFilter projectStatusBooleanFilter = new BooleanFilter();


        Filter termFilter = new TermFilter(
                "status", projectStatus);

        projectStatusBooleanFilter.add(
                termFilter, BooleanClauseOccur.SHOULD);

        projectStatusBooleanFilter.add(
                new MissingFilter("status"), BooleanClauseOccur.SHOULD);


        booleanFilter.add(
                projectStatusBooleanFilter, BooleanClauseOccur.MUST);

    }

    private void _filterByProjectCode(BooleanFilter booleanFilter, SearchContext searchContext) {
        int projectCode = GetterUtil.getInteger(searchContext.getAttribute("code"));
        if (Validator.isNull(projectCode)) {
            return;
        }
        BooleanFilter projectCodeBooleanFilter = new BooleanFilter();
        Filter termFilter = new TermFilter("code", String.valueOf(projectCode));

        projectCodeBooleanFilter.add(termFilter, BooleanClauseOccur.SHOULD);
        projectCodeBooleanFilter.add(new MissingFilter("code"), BooleanClauseOccur.SHOULD);
        booleanFilter.add(projectCodeBooleanFilter, BooleanClauseOccur.MUST);

    }

}