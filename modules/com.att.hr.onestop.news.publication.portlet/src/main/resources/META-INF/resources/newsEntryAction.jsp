<%@ include file="init.jsp" %>
<%
String tabs1 = ParamUtil.getString(request, "tabs1", "Staged");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
NewsEntry newsEntry = (NewsEntry)row.getObject();
long newsEntryId = newsEntry.getNewsEntryId();
boolean isStaged = themeDisplay.getScopeGroup().isStaged();
boolean stagedNewsEntry = false;

if(isStaged && themeDisplay.getScopeGroup().isStagingGroup() && (newsEntry.getGroupId() == themeDisplay.getScopeGroupId())){
	stagedNewsEntry = true;
}

String previewURL = "javascript:Liferay.Util.getOpener().showPreview(" + newsEntryId + ");";
%>
<%-- <liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>"> --%>
 <liferay-ui:icon-list>
<liferay-portlet:renderURL var="editURL">
<liferay-portlet:param name="newsEntryId" value="<%=String.valueOf(newsEntryId)%>"/>
<liferay-portlet:param name="mvcPath" value="/editNewsEntry.jsp"/>
<liferay-portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent() %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="deleteURL" name="groupAction">
<liferay-portlet:param name="<%=Constants.CMD %>" value="<%=Constants.DELETE%>"/>
<liferay-portlet:param name="tabs1" value="<%=tabs1 %>"/>
<liferay-portlet:param name="newsEntryIds" value="<%=String.valueOf(newsEntryId)%>"/>
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="archiveURL" name="archiveNewsEntry">
<liferay-portlet:param name="newsEntryId" value="<%=String.valueOf(newsEntryId)%>"/>
<liferay-portlet:param name="tabs1" value="<%=tabs1 %>"/>
<liferay-portlet:param name="archive" value="true"/>
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="activateURL" name="archiveNewsEntry">
<liferay-portlet:param name="newsEntryId" value="<%=String.valueOf(newsEntryId)%>"/>
<liferay-portlet:param name="tabs1" value="<%=tabs1 %>"/>
<liferay-portlet:param name="archive" value="false"/>
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="publishToLiveURL" name="groupAction">
<liferay-portlet:param name="<%=Constants.CMD %>" value="<%=Constants.PUBLISH_TO_LIVE%>"/>
<liferay-portlet:param name="newsEntryIds" value="<%=String.valueOf(newsEntryId)%>"/>
<liferay-portlet:param name="tabs1" value="Live"/>
</liferay-portlet:actionURL>

<liferay-ui:icon image="edit"
	message=""
	url="<%= editURL %>"
/>
<liferay-ui:icon  image="delete"
	message=""
	url="<%= deleteURL %>"
/>
<c:choose>
<c:when test="<%=newsEntry.isArchive()%>">
<liferay-ui:icon 
	image="deactivate"
	message=""
	url="<%= activateURL %>"
/>
</c:when>
<c:otherwise>
<liferay-ui:icon
	image="activate"
	message=""
	url="<%= archiveURL %>"
/>
</c:otherwise>
</c:choose>

<liferay-ui:icon image="view"
	message="" url="<%=previewURL %>" 
/>

<c:if test="<%=isStaged && stagedNewsEntry &&  newsEntry.getStatus() == WorkflowConstants.STATUS_APPROVED%>">
<liferay-ui:icon
	src="/o/comatthronestopnewspublicationportlet/icons/workflow.png"
	message=""
	url="<%= publishToLiveURL %>"
/>
</c:if>
</liferay-ui:icon-list>
<%-- </liferay-ui:icon-menu> --%>




