<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.file.portlet.DocumentAndMediaUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name='uploadFile' var="uploadFileURL"
	windowState="normal" />

<aui:form action="<%=uploadFileURL%>" method="POST" name="fm"
	enctype="multipart/form-data">
	<aui:fieldset>

		<aui:input type="file" name="file-to-upload" />

		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>

	</aui:fieldset>
</aui:form>


<%
	List<FileEntry> files = (List<FileEntry>) request.getAttribute("fileList");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>

<liferay-portlet:renderURL varImpl="iteratorURL" />
<liferay-ui:search-container total="<%=files.size()%>" delta="10"
	emptyResultsMessage=" Please add some documents in Testing folder"
	iteratorURL="<%=iteratorURL%>">

	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(files, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.repository.model.FileEntry"
		modelVar="file" keyProperty="fileEntryId">
		<liferay-ui:search-container-column-text name="Title"
			value="${file.title}" />
		<liferay-ui:search-container-column-text name="Type"
			value="${file.extension}" />

		<c:set var="file" value="${file}" />

		<%
			FileEntry fileEntry = (FileEntry) pageContext.getAttribute("file");
					String formattedSize = DocumentAndMediaUtil.getFormattedFileSize(fileEntry.getSize());
					String downloadURL = DocumentAndMediaUtil.getDownloadURL(themeDisplay, fileEntry);
					String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
							+ themeDisplay.getScopeGroupId() + StringPool.SLASH + fileEntry.getUuid();
		%>

		<liferay-ui:search-container-column-text name="size"
			value="<%=formattedSize%>" />
		<liferay-ui:search-container-column-text name="Last Updated By"
			value="<%=sdf.format(file.getModifiedDate())%>" />
		<liferay-ui:search-container-column-text name="Download"
			value="Click Here" href="<%=downloadURL%>" />
		<liferay-ui:search-container-column-text name="Preview File">
			<a href="#" onClick="return Popup('<%=url%>')">Click</a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="deleteFile">

			<portlet:actionURL name="delete" var="deleteCrudURL">
				<portlet:param name="fileEntryId"
					value="${file.getFileEntryId()}" />
			</portlet:actionURL>
			<liferay-ui:icon-menu>
				<liferay-ui:icon message="Delete" url="<%=deleteCrudURL%>" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>



<script type="text/javascript">
	function Popup(url) {
		newwindow = window.open(url, 'name', 'height=500,width=900');
		if (window.focus) {
			newwindow.focus()
		}
		return false;

	}
</script>