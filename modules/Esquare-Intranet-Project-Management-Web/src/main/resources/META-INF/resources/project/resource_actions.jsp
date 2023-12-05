<%@ include file="/init.jsp" %>

<%
    ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    TeamMembers rowObjectTeamMembers = (TeamMembers)row.getObject();
%>

<liferay-ui:icon-menu
        direction="left-side"
        icon="<%= StringPool.BLANK %>"
        markupView="lexicon"
        message="<%= StringPool.BLANK %>"
        showWhenSingleIcon="<%= true %>"
>
        <portlet:actionURL name="project/removeResources" var="deleteResourcesURL">
            <portlet:param name="redirect" value="<%= currentURL %>" />
            <portlet:param name="memberId" value="<%= String.valueOf(rowObjectTeamMembers.getMemberId()) %>" />
        </portlet:actionURL>
        <liferay-ui:icon-delete
                url="<%= deleteResourcesURL %>"
        />
</liferay-ui:icon-menu>