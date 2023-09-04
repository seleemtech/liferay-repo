<%@ page import="com.esquare.intranet.picklist.web.display.context.ViewCustomListTypeDefinitionsDisplayContext" %>
<%@ page import="com.esquare.intranet.picklist.web.constants.EsquareIntranetPickListWebPortletKeys" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.list.type.model.ListTypeEntry" %>
<%@ page import="com.liferay.list.type.service.ListTypeEntryLocalServiceUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Locale" %>
<%@ include file="/init.jsp" %>

<%
	ViewCustomListTypeDefinitionsDisplayContext viewCustomListTypeDefinitionsDisplayContext = (ViewCustomListTypeDefinitionsDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
	Map<Long,String> listType = (Map<Long,String>) renderRequest.getAttribute("listTypeName");
	List<String> listEntryName = new ArrayList<>();
	listType.forEach((id, name) -> {
		if(Validator.isNotNull(name) && "Education".equals(name)){
			List<ListTypeEntry> listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntries(id);
			listTypeEntry.stream().map(entry -> entry.getName(Locale.ENGLISH)).forEach(listEntryName::add);
		}
	});
%>

<frontend-data-set:headless-display
		apiURL="<%= viewCustomListTypeDefinitionsDisplayContext.getAPIURL() %>"
		creationMenu="<%= viewCustomListTypeDefinitionsDisplayContext.getCreationMenu() %>"
		formName="fm"
		id="<%= EsquareIntranetPickListWebPortletKeys.LIST_TYPE_DEFINITIONS %>"
		style="fluid"
/>
