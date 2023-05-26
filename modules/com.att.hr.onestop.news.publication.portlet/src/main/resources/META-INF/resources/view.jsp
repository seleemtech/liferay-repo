<%@ page import="com.att.hr.onestop.services.service.NewsEntryLocalService" %>
<%@ include file="init.jsp"%>
<%

	String tabs1 = ParamUtil.getString(request, "tabs1", "Staged");
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("tabs1", tabs1);
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("tabs1", tabs1);
	Group scopeGroup = themeDisplay.getScopeGroup();
	long groupId = themeDisplay.getScopeGroupId();
	boolean isStaged = themeDisplay.getScopeGroup().isStaged() && scopeGroup.isStagingGroup();
	boolean showIcons = isStaged || !themeDisplay.getScopeGroup().isStaged();
	if (isStaged && tabs1.equalsIgnoreCase("Staged")) {
		groupId = themeDisplay.getScopeGroupId();
	} else if (isStaged && tabs1.equalsIgnoreCase("Live")) {
		groupId = scopeGroup.getLiveGroupId();
	}
	List<NewsEntry> newsEntries = NewsEntryLocalServiceUtil.getNewsEntryByGroupId(groupId);

%>



<c:if test="<%=isStaged%>">
	<liferay-ui:tabs names="Staged,Live" url="<%=portletURL.toString()%>" />
</c:if>

<liferay-portlet:renderURL var="addNewsEntryURL">
	<liferay-portlet:param name="mvcPath" value="/editNewsEntry.jsp" />
	<liferay-portlet:param name="redirect"
		value="<%=themeDisplay.getURLCurrent()%>" />
</liferay-portlet:renderURL>
<liferay-portlet:actionURL var="groupActionURL" name="groupAction">
</liferay-portlet:actionURL>
<c:if test="<%=showIcons%>">
	<c:if test="<%=tabs1.equalsIgnoreCase("Staged")%>">
		<aui:a cssClass="btn btn-default"
			href="<%=addNewsEntryURL.toString()%>" label="Add News"
			title="Add News"></aui:a>
	</c:if>
	<aui:a cssClass="btn btn-default"
		href='<%="javascript:" + renderResponse.getNamespace() + "groupAction('delete');"%>'
		label="Delete" title="Delete"></aui:a>
	<c:if test="<%=isStaged && tabs1.equalsIgnoreCase("Staged")%>">
		<aui:a cssClass="btn btn-default"
			href='<%="javascript:" + renderResponse.getNamespace() + "groupAction('publish_to_live');"%>'
			label="Publish To Live" title="Publish To Live"></aui:a>
	</c:if>
</c:if>
<aui:form action="<%=groupActionURL.toString()%>" method="post"
	name="fm">
	<aui:input name="newsEntryIds" type="hidden" />
	<aui:input name="<%=Constants.CMD%>" type="hidden" />
	<aui:input name="tabs1" type="hidden" value="<%=tabs1%>" />
	<liferay-ui:search-container delta="5" emptyResultsMessage="No news Found!!" iteratorURL="<%=iteratorURL%>" total="<%= newsEntries.size() %>" rowChecker='<%=(showIcons)?new EmptyOnClickRowChecker(renderResponse):null%>'>
	<liferay-ui:search-container-results
				results="<%=ListUtil.subList(newsEntries, searchContainer.getStart(), searchContainer.getEnd())%>"  />
		<liferay-ui:search-container-row
			className="com.att.hr.onestop.services.model.NewsEntry"
			keyProperty="newsEntryId" modelVar="newsEntry">
			<liferay-ui:search-container-column-text name="News Title"
				property="newsTitle"  />
			<liferay-ui:search-container-column-text name="News Summary"
				property="newsSummary" />
			<liferay-ui:search-container-column-text name="News Scope" value='<%=(newsEntry.getNewsScopeId() > 0)?(LayoutLocalServiceUtil.getLayout(newsEntry.getNewsScopeId()).getName(themeDisplay.getLocale())):"Home Page News"%>' />	
				
			<liferay-ui:search-container-column-text name="Workflow Status">
				<aui:workflow-status markupView="lexicon" showIcon="<%=false%>"
					showLabel="<%=false%>" status="<%=newsEntry.getStatus()%>" />
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Status"
				value='<%=(newsEntry.getArchive()) ? "In Active" : "Active"%>' />
			<c:if test="<%=showIcons%>">
				<liferay-ui:search-container-column-jsp path="/newsEntryAction.jsp"
					align="right" name="action" />
			</c:if>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />

	</liferay-ui:search-container>
</aui:form>
<aui:script use="aui-base,liferay-util-window,liferay-portlet-url">
	Liferay
			.provide(
					window,
					'<portlet:namespace />groupAction',
					function(cmd) {
						A.one('#<portlet:namespace />cmd').val(cmd);
						var newsEntryIds = Liferay.Util.listCheckedExcept(
								<portlet:namespace />fm,
								'<portlet:namespace />allRowIds');
						if (newsEntryIds == "" || newsEntryIds == null) {
							alert("Please select atleast one record.");
							return;
						}
						A.one('#<portlet:namespace />newsEntryIds').val(
								newsEntryIds);
						if (cmd == 'delete') {
							if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-entries") %>')) {

								submitForm(document.<portlet:namespace />fm);
							}
						} else if (cmd == 'publish_to_live') {
							A.one('#<portlet:namespace />tabs1').val('Live');
							if (confirm('Are you sure you want to publish the selected entries.Please note that only approved entries will be published ... ')) {
								submitForm(document.<portlet:namespace />fm);
							}
						}

					});
	
	Liferay.provide(window, 'showPreview', function(entryId) {
		var instance = this;
	    var url =Liferay.PortletURL.createRenderURL();  
	    var portletId = '<portlet:namespace />';
	    portletId =  portletId.slice(1, -1);
	    url.setPortletId(portletId); 
	    url.setWindowState('pop_up'); 
	    url.setParameter('newsEntryId',entryId); 
	    url.setParameter('mvcPath','/previewNewsEntry.jsp');
	    var messageDialog = Liferay.Util.openWindow(
				{
					dialog: {
						
						centered: true,
						constrain: true,
						destroyOnHide: true,
						height: 400,
						modal: true,
						width: 450
					},
					id: 'Dialog',
					title: Liferay.Language.get('preview'),
					uri: url
				}
			);
	
	});

	
</aui:script>

