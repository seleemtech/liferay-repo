<%@page
	import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page
	import="com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil"%>

<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoValue"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL name="createUser" var="deactivateUser" />
<%
	List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
	List<Long> userIdsToExclude = Arrays.asList(20101L, 20125L, 42924L);
	users = users.stream().filter(filterUser -> !userIdsToExclude.contains(filterUser.getUserId()))
			.collect(Collectors.toList()); // Exclude user from list
%>

<liferay-ui:search-container total="<%=users.size()%>"
	var="searchContainer" delta="6" deltaConfigurable="true"
	emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">

	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(users, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.model.User" modelVar="user"
		keyProperty="userId">
		<liferay-ui:search-container-column-text name="User Id"
			value="${user.userId}" />
		<liferay-ui:search-container-column-text name="User Name"
			value="${user.screenName}" />
		<liferay-ui:search-container-column-text name="firstName"
			property="firstName" />
		<liferay-ui:search-container-column-text name="lastName"
			property="lastName" />
		<liferay-ui:search-container-column-text name="Email"
			value="${user.emailAddress}" />
		<%
			ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ExpandoValue.class, portalClassLoader);
					dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(user.getUserId()));
					List<ExpandoValue> filteredValue = ExpandoValueLocalServiceUtil.dynamicQuery(dynamicQuery);

					for (ExpandoValue expandoValue : filteredValue) {
					
		%>
		<liferay-ui:search-container-column-text name="Gender">
			<%=expandoValue.getData()%>
		</liferay-ui:search-container-column-text>
		<%
			}
		%>
		<liferay-ui:search-container-column-text name="Status">
			<aui:workflow-status markupView="lexicon" showIcon="<%=false%>"
				showLabel="<%=false%>" status="<%=user.getStatus()%>" />
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Actions">
			<portlet:actionURL name="/activate_user" var="activateUserURL">
				<portlet:param name="userId" value="${user.userId}" />
			</portlet:actionURL>

			<portlet:actionURL name="/deactivate_user" var="deactivateUserURL">
				<portlet:param name="userId" value="${user.userId}" />
			</portlet:actionURL>

			<portlet:renderURL var="updateUser">
				<portlet:param name="mvcPath" value="/userUpdate.jsp" />
				<portlet:param name="userId" value="${user.userId}"></portlet:param>
			</portlet:renderURL>

			<liferay-ui:icon-menu>
				<liferay-ui:icon message="Activate" url="<%=activateUserURL%>" />
				<liferay-ui:icon message="Deactivate" url="<%=deactivateUserURL%>" />
				<liferay-ui:icon message="Update" url="<%=updateUser%>" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>