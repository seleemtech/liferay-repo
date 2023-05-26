<%@page import="com.dynamic.data.mapping.form.web.internal.display.context.DDMFormAdminDisplayContext"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sass.js/0.9.2/sass.min.js" integrity="sha512-mA5b7w9mZvGLWgjIqp9KhWNzkkZ/H3gC4Ua6GOn9m/xl1UF4ghH8GsriKvAYxLsxoKvn6NdebW7kZ6iGB3CGSg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/react" prefix="react" %><%@
taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
/* DDMFormAdminDisplayContext ddmCustomFormAdminDisplayContexts = (DDMFormAdminDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

String dataProviderInstanceParameterSettingsURLs = ddmFormAdminDisplayContexts.getDataProviderInstanceParameterSettingsURL();
String dataProviderInstancesURLs = ddmFormAdminDisplayContexts.getDataProviderInstancesURL();
String displayStyles = ddmFormAdminDisplayContexts.getDisplayStyle();
JSONObject functionsMetadataJSONObjects = ddmFormAdminDisplayContexts.getFunctionsMetadataJSONObject();
String functionsURLs = ddmFormAdminDisplayContexts.getFunctionsURL();
String rolesURLs = ddmFormAdminDisplayContexts.getRolesURL();
JSONArray ddmFormRulesJSONArrays = ddmFormAdminDisplayContexts.getDDMFormRulesJSONArray();
JSONObject formBuilderContextJSONObjects = ddmFormAdminDisplayContexts.getFormBuilderContextJSONObject(); */
%>

<%@ include file="/admin/init-ext.jsp" %>

<aui:script>
	Liferay.namespace('Forms').portletNamespace = '<portlet:namespace />';
</aui:script>