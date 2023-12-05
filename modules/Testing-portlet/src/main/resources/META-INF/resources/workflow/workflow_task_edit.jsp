<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="Testing.portlet.constants.TestingPortletKeys"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTransition"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetRendererFactory"%>
<%@page import="com.liferay.asset.kernel.model.AssetRenderer"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowHandler"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page
	import="Testing.portlet.display.context.CustomWorkflowTaskDisplayContext"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ include file="/./init.jsp"%>

<%

String randomId = StringUtil.randomId();


	long workflowId = ParamUtil.getLong(renderRequest, "workflowId");
	WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(),
			workflowId);
	CustomWorkflowTaskDisplayContext customWorkflowTaskDisplayContext = (CustomWorkflowTaskDisplayContext) renderRequest
			.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
	String currentURL = customWorkflowTaskDisplayContext.getCurrentURL();
	long classPK = customWorkflowTaskDisplayContext.getWorkflowContextEntryClassPK(workflowTask);
	String languageId = LanguageUtil.getLanguageId(request);
	WorkflowHandler<?> workflowHandler = customWorkflowTaskDisplayContext.getWorkflowHandler(workflowTask);
	AssetRenderer<?> assetRenderer = workflowHandler.getAssetRenderer(classPK);

	AssetRendererFactory<?> assetRendererFactory = null;

	AssetEntry assetEntry = null;

	if (assetRenderer != null) {
		assetRendererFactory = assetRenderer.getAssetRendererFactory();

		if (assetRendererFactory != null) {
			assetEntry = assetRendererFactory.getAssetEntry(workflowHandler.getClassName(),
					assetRenderer.getClassPK());
		}

		String[] availableLanguageIds = assetRenderer.getAvailableLanguageIds();

		if (ArrayUtil.isNotEmpty(availableLanguageIds)
				&& !ArrayUtil.contains(availableLanguageIds, languageId)) {
			languageId = assetRenderer.getDefaultLanguageId();
		}
	}
	
	
	
	
	System.out.println("workflowTask.getAssigneeUserId()::::::"+workflowTask.getAssigneeUserId());	
	System.out.println("workflowTaskAssigneeUserName::::::"+HtmlUtil.escape(customWorkflowTaskDisplayContext
			.getWorkflowTaskAssigneeUserName(workflowTask)));
	System.out.println("workflowId::::::"+workflowId);	
%>

<clay:container-fluid>
	<clay:col cssClass="lfr-asset-column lfr-asset-column-details">
		<div class="sheet">
			<div class="panel-group panel-group-flush">
					<%@ include file="/workflow/workflow_task_action.jsp"%>
				
				<clay:col md="6">
					<aui:field-wrapper label="assigned-to">
						<aui:fieldset>
							<div class="align-items-center card-row">
								<c:choose>
									<c:when test="<%=workflowTask.isAssignedToSingleUser()%>">
										<div class="card-col-field mr-2">
											<div class="list-group-card-icon">
												<liferay-ui:user-portrait
													userId="<%=workflowTask.getAssigneeUserId()%>" />
											</div>
										</div>

										<div class="card-col-content card-col-gutters">
											<div class="lfr-asset-assigned">
												<%=HtmlUtil.escape(customWorkflowTaskDisplayContext
												.getWorkflowTaskAssigneeUserName(workflowTask))%>
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<div
											class="card-col-content card-col-gutters lfr-asset-assigned">
											<div class="lfr-asset-assigned">
												<%=customWorkflowTaskDisplayContext.getWorkflowTaskUnassignedUserName()%>
											</div>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</aui:fieldset>
					</aui:field-wrapper>

					<aui:field-wrapper label="task-name">
						<aui:fieldset>
							<%=workflowTask.getLabel(customWorkflowTaskDisplayContext.getTaskContentLocale())%>
						</aui:fieldset>
					</aui:field-wrapper>
				</clay:col>



				<liferay-ui:panel-container cssClass="task-panel-container"
					extended="<%=false%>">
					<c:if test="<%=assetRenderer != null%>">
						<liferay-ui:panel extended="<%=true%>" markupView="lexicon"
							title="<%=customWorkflowTaskDisplayContext.getPreviewOfTitle(workflowTask)%>">
							<c:if test="<%=assetRenderer.isLocalizable()%>">
								<div class="locale-actions">
									<liferay-ui:language formAction=""
										languageId="<%=languageId%>"
										languageIds="<%=assetRenderer.getAvailableLanguageIds()%>" />
								</div>
							</c:if>

							<span class="h3 task-content-title"> <liferay-ui:icon
									icon="<%=workflowHandler.getIconCssClass()%>"
									label="<%=true%>" markupView="lexicon"
									message="<%=HtmlUtil.escape(customWorkflowTaskDisplayContext.getAssetTitle(workflowTask))%>" />
							</span>

							<liferay-asset:asset-display assetRenderer="<%=assetRenderer%>"
								template="<%=AssetRenderer.TEMPLATE_ABSTRACT%>" />

							<c:if test="<%=assetEntry != null%>">
								<span class="h4 task-content-author"> <liferay-ui:message
										key="author" />
								</span>

								<liferay-asset:asset-metadata
									className="<%=assetEntry.getClassName()%>"
									classPK="<%=assetEntry.getClassPK()%>"
									metadataFields='<%=new String[] { "author", "categories", "tags" }%>' />
							</c:if>
						</liferay-ui:panel>

					</c:if>

					<liferay-ui:panel markupView="lexicon" title="activities">
						<%-- <%@ include file="/workflow_logs.jspf" %> --%>
					</liferay-ui:panel>
				</liferay-ui:panel-container>

			</div>
		</div>
	</clay:col>
</clay:container-fluid>




