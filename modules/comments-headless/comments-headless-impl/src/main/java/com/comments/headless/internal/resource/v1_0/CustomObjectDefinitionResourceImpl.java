package com.comments.headless.internal.resource.v1_0;

import com.comments.headless.dto.v1_0.CustomObjectDefinition;
import com.comments.headless.dto.v1_0.Status;
import com.comments.headless.resource.v1_0.CustomObjectDefinitionResource;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.object.system.SystemObjectDefinitionManager;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.feature.flag.FeatureFlagManagerUtil;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.vulcan.aggregation.Aggregation;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.LocalizedMapUtil;
import com.liferay.portal.vulcan.util.SearchUtil;

import java.util.Collections;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author E2Software-011
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/custom-object-definition.properties", scope = ServiceScope.PROTOTYPE, service = CustomObjectDefinitionResource.class)
public class CustomObjectDefinitionResourceImpl extends BaseCustomObjectDefinitionResourceImpl {
	@Override
	public Page<CustomObjectDefinition> getObjectDefinitionsPage(String search, Aggregation aggregation, Filter filter,
			Pagination pagination, Sort[] sorts) throws Exception {
		// TODO Auto-generated method stub
		return SearchUtil.search(Collections.emptyMap(), booleanQuery -> {
		}, filter, com.liferay.object.model.ObjectDefinition.class.getName(), search, pagination,
				queryConfig -> queryConfig.setSelectedFieldNames(Field.ENTRY_CLASS_PK), searchContext -> {
					searchContext.addVulcanAggregation(aggregation);
					searchContext.setAttribute(Field.NAME, search);
					searchContext.setCompanyId(contextCompany.getCompanyId());
				}, sorts, document -> _toObjectDefinition(_objectDefinitionService
						.getObjectDefinition(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))));
	}

	private CustomObjectDefinition _toObjectDefinition(com.liferay.object.model.ObjectDefinition objectDefinition) {

		return new CustomObjectDefinition() {
			{
				accountEntryRestricted = objectDefinition.isAccountEntryRestricted();

				active = objectDefinition.isActive();
				dateCreated = objectDefinition.getCreateDate();
				dateModified = objectDefinition.getModifiedDate();
				defaultLanguageId = _localization.getDefaultLanguageId(objectDefinition.getLabel());
				enableCategorization = objectDefinition.getEnableCategorization();
				enableComments = objectDefinition.getEnableComments();

				if (FeatureFlagManagerUtil.isEnabled("LPS-172017")) {
					enableLocalization = objectDefinition.getEnableLocalization();
				}

				enableObjectEntryHistory = objectDefinition.getEnableObjectEntryHistory();
				externalReferenceCode = objectDefinition.getExternalReferenceCode();
				id = objectDefinition.getObjectDefinitionId();
				label = LocalizedMapUtil.getLanguageIdMap(objectDefinition.getLabelMap());

				if (FeatureFlagManagerUtil.isEnabled("LPS-167253")) {
					modifiable = objectDefinition.getModifiable();
				}

				name = objectDefinition.getShortName();

				panelCategoryKey = objectDefinition.getPanelCategoryKey();
				pluralLabel = LocalizedMapUtil.getLanguageIdMap(objectDefinition.getPluralLabelMap());
				portlet = objectDefinition.getPortlet();

				scope = objectDefinition.getScope();
				status = new Status() {
					{
						code = objectDefinition.getStatus();
						label = WorkflowConstants.getStatusLabel(objectDefinition.getStatus());
						label_i18n = WorkflowConstants.getStatusLabel(objectDefinition.getStatus());
					}
				};

				if (FeatureFlagManagerUtil.isEnabled("LPS-135430")) {
					storageType = objectDefinition.getStorageType();
				}

				system = objectDefinition.isSystem();

			}
		};
	}

	@Reference
	private ObjectDefinitionService _objectDefinitionService;
	@Reference
	private Localization _localization;
	@Reference
	private Language _language;
}
