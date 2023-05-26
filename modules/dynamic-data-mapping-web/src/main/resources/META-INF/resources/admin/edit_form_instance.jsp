<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.frontend.icons.FrontendIconsUtil"%>
<%@page import="com.liferay.portal.kernel.util.HashMapBuilder"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.dynamic.data.mapping.model.DDMFormInstance"%>
<%@ include file="/admin/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
		 DDMFormAdminDisplayContext ddmFormAdminDisplayContexts = (DDMFormAdminDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

		 String dataProviderInstanceParameterSettingsURLs = ddmFormAdminDisplayContexts.getDataProviderInstanceParameterSettingsURL();
		 String dataProviderInstancesURLs = ddmFormAdminDisplayContexts.getDataProviderInstancesURL();
		 String displayStyles = ddmFormAdminDisplayContexts.getDisplayStyle();
		 JSONObject functionsMetadataJSONObjects = ddmFormAdminDisplayContexts.getFunctionsMetadataJSONObject();
		 String functionsURLs = ddmFormAdminDisplayContexts.getFunctionsURL();
		 String rolesURLs = ddmFormAdminDisplayContexts.getRolesURL();
		 JSONArray ddmFormRulesJSONArrays = ddmFormAdminDisplayContexts.getDDMFormRulesJSONArray();
		 JSONObject formBuilderContextJSONObjects = ddmFormAdminDisplayContexts.getFormBuilderContextJSONObject();
DDMFormInstance formInstance = ddmFormAdminDisplayContexts.getDDMFormInstance();

long formInstanceId = BeanParamUtil.getLong(formInstance, request, "formInstanceId");
long groupId = BeanParamUtil.getLong(formInstance, request, "groupId", scopeGroupId);
long ddmStructureId = BeanParamUtil.getLong(formInstance, request, "structureId");

boolean disableCopyButton = false;

if (!ddmFormAdminDisplayContexts.isFormPublished()) {
	disableCopyButton = true;
}

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle((formInstance == null) ? LanguageUtil.get(request, "new-form") : LanguageUtil.get(request, "edit-form"));
%>

<portlet:actionURL name="/dynamic_data_mapping_form/save_form_instance" var="saveFormInstanceURL">
	<portlet:param name="mvcRenderCommandName" value="/admin/edit_form_instance" />
</portlet:actionURL>

<portlet:actionURL name="/dynamic_data_mapping_form/publish_form_instance" var="publishFormInstanceURL">
	<portlet:param name="mvcRenderCommandName" value="/admin/edit_form_instance" />
</portlet:actionURL>

<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" id="/dynamic_data_mapping_form/save_form_instance" var="autoSaveFormInstanceURL" />

<div class="lfr-alert-container">
	<clay:container-fluid cssClass="lfr-alert-wrapper"></clay:container-fluid>
</div>

<div class="portlet-forms" id="<portlet:namespace />formContainer">
	<div class="forms-navigation-bar">
		<clay:navigation-bar
			id="formsNavigationBar"
			inverted="<%= true %>"
			navigationItems="<%= ddmFormAdminDisplayContexts.getFormBuilderNavigationItems() %>"
		/>
	</div>

	<nav class="hide management-bar management-bar-light navbar navbar-expand-md toolbar-group-field" id="<portlet:namespace />managementToolbar">
		<clay:container-fluid
			cssClass="autosave-bar d-flex justify-content-between toolbar"
		>
			<div class="autosave-feedback-container navbar-form navbar-form-autofit navbar-overlay toolbar-group-content">
				<span class="autosave-feedback management-bar-text" id="<portlet:namespace />autosaveMessage"></span>
			</div>

			<ul class="navbar-nav toolbar-group-field">
				<li class="nav-item pr-3">
					<button class="btn btn-monospaced btn-outline-borderless btn-outline-secondary btn-sm lfr-ddm-button lfr-ddm-settings-button" title="<%= LanguageUtil.get(request, "settings") %>">
						<svg class="lexicon-icon">
							<use xlink:href="<%= ddmFormAdminDisplayContexts.getLexiconIconsPath() %>cog" />
						</svg>
					</button>
				</li>
				<li class="nav-item pr-2">
					<c:choose>
						<c:when test="<%= disableCopyButton %>">
							<button class="btn btn-secondary btn-sm disabled lfr-ddm-button lfr-ddm-share-url-button share-form-icon" data-original-title="<liferay-ui:message key="share" />" id="<portlet:namespace />publishIcon" title="<%= disableCopyButton ? LanguageUtil.get(request, "publish-the-form-to-get-its-shareable-link") : "" %>" type="button">
								<%= LanguageUtil.get(request, "share") %>
							</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-secondary btn-sm lfr-ddm-button lfr-ddm-share-url-button share-form-icon" id="<portlet:namespace />publishIcon" type="button">
								<%= LanguageUtil.get(request, "share") %>
							</button>
						</c:otherwise>
					</c:choose>
				</li>
				<li class="nav-item pr-2">
					<button class="btn btn-secondary btn-sm lfr-ddm-button lfr-ddm-preview-button" title="<%= LanguageUtil.get(request, "a-form-draft-will-be-saved-before-the-preview") %>">
						<%= LanguageUtil.get(request, "preview") %>
					</button>
				</li>
				<li class="nav-item pl-2 pr-2">
					<button class="btn btn-secondary btn-sm lfr-ddm-button lfr-ddm-save-button">
						<%= LanguageUtil.get(request, "save") %>
					</button>
				</li>
				<li class="nav-item pr-2">
					<button class="btn <%= ddmFormAdminDisplayContexts.isFormPublished() ? "btn-secondary" : "btn-primary" %> btn-sm lfr-ddm-button lfr-ddm-publish-button">
						<%= ddmFormAdminDisplayContexts.isFormPublished() ? LanguageUtil.get(request, "unpublish") : LanguageUtil.get(request, "publish") %>
					</button>
				</li>
				<li class="nav-item">
					<button class="btn btn-primary btn-sm lfr-ddm-add-field lfr-ddm-plus-button nav-btn nav-btn-monospaced" id="addFieldButton" title="<%= LanguageUtil.get(request, "add-elements") %>">
						<svg class="lexicon-icon">
							<use xlink:href="<%= ddmFormAdminDisplayContexts.getLexiconIconsPath() %>plus" />
						</svg>
					</button>
				</li>
			</ul>
		</clay:container-fluid>
	</nav>

	<clay:container-fluid
		cssClass="ddm-translation-manager hide"
	>
		<liferay-frontend:translation-manager
			availableLocales="<%= ddmFormAdminDisplayContexts.getAvailableLocales() %>"
			changeableDefaultLanguage="<%= false %>"
			defaultLanguageId="<%= ddmFormAdminDisplayContexts.getDefaultLanguageId() %>"
			id="translationManager"
		/>
	</clay:container-fluid>

	<aui:form action="<%= saveFormInstanceURL %>" cssClass="ddm-form-builder-form" enctype="multipart/form-data" method="post" name="editForm">
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="formInstanceId" type="hidden" value="<%= formInstanceId %>" />
		<aui:input name="groupId" type="hidden" value="<%= groupId %>" />
		<aui:input name="ddmStructureId" type="hidden" value="<%= ddmStructureId %>" />
		<aui:input name="name" type="hidden" value="<%= ddmFormAdminDisplayContexts.getFormLocalizedNameJSONObject(formInstance) %>" />
		<aui:input name="description" type="hidden" value="<%= ddmFormAdminDisplayContexts.getFormLocalizedDescriptionJSONObject() %>" />
		<aui:input name="serializedFormBuilderContext" type="hidden" value="<%= formBuilderContextJSONObjects %>" />
		<aui:input name="serializedSettingsContext" type="hidden" value="" />

	<%-- 	<%@ include file="/admin/exceptions.jspf" %> --%>
		<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" id="/dynamic_data_mapping_form/get_form_report_data" var="formReportDataURL">
			<portlet:param name="formInstanceId" value="<%= String.valueOf(formInstanceId) %>" />
		</liferay-portlet:resourceURL>

		<div id="<portlet:namespace />-container">
			<react:component
				module="admin/js/App.es"
				props='<%=
						HashMapBuilder.<String, Object>put(
							"autocompleteUserURL", ddmFormAdminDisplayContexts.getAutocompleteUserURL()
						).put(
						"autosaveInterval", ddmFormAdminDisplayContexts.getAutosaveInterval()
					).put(
						"autosaveURL", autoSaveFormInstanceURL.toString()
					).put(
						"availableLanguageIds", ddmFormAdminDisplayContexts.getAvailableLanguageIdsJSONArray()
					).put(
						"context", formBuilderContextJSONObjects
					).put(
						"dataProviderInstanceParameterSettingsURL", dataProviderInstanceParameterSettingsURLs
					).put(
						"dataProviderInstancesURL", dataProviderInstancesURLs
					).put(
						"defaultLanguageId", ddmFormAdminDisplayContexts.getDefaultLanguageId()
					).put(
						"elementSets", ddmFormAdminDisplayContexts.getFieldSetsJSONArray()
					).put(
						"fieldSetDefinitionURL", ddmFormAdminDisplayContexts.getFieldSetDefinitionURL()
					).put(
						"fieldTypes", ddmFormAdminDisplayContexts.getDDMFormFieldTypesJSONArray()
					).put(
						"formInstanceId", formInstanceId
					).put(
						"formReportDataURL", formReportDataURL.toString()
					).put(
						"formSettingsContext", ddmFormAdminDisplayContexts.getDDMFormSettingsContext(pageContext)
					).put(
						"functionsMetadata", functionsMetadataJSONObjects
					).put(
						"functionsURL", functionsURLs
					).put(
						"groupId", groupId
					).put(
						"localizedDescription", ddmFormAdminDisplayContexts.getFormLocalizedDescriptionJSONObject()
					).put(
						"localizedName", ddmFormAdminDisplayContexts.getFormLocalizedNameJSONObject(formInstance)
					).put(
						"mainRequire", ddmFormAdminDisplayContexts.getMainRequire()
					).put(
						"portletNamespace", liferayPortletResponse.getNamespace()
					).put(
						"published", ddmFormAdminDisplayContexts.isFormPublished()
					).put(
						"publishFormInstanceURL", publishFormInstanceURL.toString()
					).put(
						"rolesURL", rolesURLs
					).put(
						"rules", ddmFormRulesJSONArrays
					).put(
						"saved", formInstance != null
					).put(
						"sharedFormURL", ddmFormAdminDisplayContexts.getSharedFormURL()
					).put(
						"shareFormInstanceURL", ddmFormAdminDisplayContexts.getShareFormInstanceURL(formInstance)
					).put(
						"showPublishAlert", ddmFormAdminDisplayContexts.isShowPublishAlert()
					).put(
						"spritemap", FrontendIconsUtil.getSpritemap(themeDisplay)
					).put(
						"view", "formBuilder"
					).build()
				%>'
			/>
		</div>
	</aui:form>
</div>

<aui:script>
	var clearPortletHandlers = function (event) {
		if (event.portletId === '<%= portletDisplay.getRootPortletId() %>') {
			var translationManager = Liferay.component(
				'<portlet:namespace />translationManager'
			);

			Liferay.destroyComponents((component) => {
				var destroy = false;

				if (component === translationManager) {
					destroy = true;
				}

				return destroy;
			});

			Liferay.detach('destroyPortlet', clearPortletHandlers);
		}
	};

	Liferay.on('destroyPortlet', clearPortletHandlers);
</aui:script>