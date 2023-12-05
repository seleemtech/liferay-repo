<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ include file="/META-INF/resources/init.jsp" %>
<%
    ProjectListDisplayContext projectListDisplayContext = (ProjectListDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>

<h1><liferay-ui:message key="project-management"/></h1>

<frontend-data-set:headless-display
        apiURL="<%= projectListDisplayContext.getAPIURL() %>"
        creationMenu="<%= projectListDisplayContext.getCreationMenu() %>"
        fdsActionDropdownItems="<%= projectListDisplayContext.getFDSActionDropdownItems() %>"
        formName="fm"
        id="<%= ProjectConstant.PTOJECT_TABLE %>"
        style="fluid"
/>