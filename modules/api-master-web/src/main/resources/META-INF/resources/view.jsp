<%@page import="api.master.slayer.model.MasterUrl"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
<p>
	<b><liferay-ui:message key="apimasterweb.caption" /></b>
</p>
<%
	List<MasterUrl> masterUrls = (List) request.getAttribute("MasterUrlList");
%>
<portlet:renderURL var="addMasterUrl">
	<portlet:param name="mvcPath" value="/add-master-url.jsp" />
</portlet:renderURL>
<button>
	<a href="${addMasterUrl}" onClick="spinner();"> <span class="glyphicon glyphicon-plus"></span>Add
		URL
	</a>
</button>
<table id="masterUrlTable">
	<thead>
		<tr>
			<th>ID</th>
			<th>Application Name</th>
			<th>Base URL</th>
			<th>Icon</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<%
			for (MasterUrl masterUrlItem : masterUrls) {
		%>
		<portlet:renderURL var="deleteURL">
			<portlet:param name="mvcRenderCommandName"
				value="/delete/masterapplication" />
			<portlet:param name="masterUrlId"
				value="<%=String.valueOf(masterUrlItem.getMasterUrlId())%>" />
		</portlet:renderURL>
		<tr>
			<td><%=masterUrlItem.getMasterUrlId()%></td>
			<td><%=masterUrlItem.getAppName()%></td>
			<td><%=masterUrlItem.getBaseUrl()%></td>
			<td><%=masterUrlItem.getSvgIcon()%></td>
			<td><a href="#"> <i class="glyphicon glyphicon-pencil"></i>
					Edit
			</a> <a href="${deleteURL}"> <i class="glyphicon glyphicon-trash"></i>
					Delete
			</a></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script>
	$('#masterUrlTable').DataTable({
		responsive : true
	});
</script>