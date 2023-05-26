<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.file.portlet.DocumentAndMediaUtil"%>
<%@ include file="/init.jsp"%>



 <c:set var="file" value="${file}"/>
<%
FileEntry fileEntry = (FileEntry) pageContext.getAttribute("file");
String downloadURL = DocumentAndMediaUtil.getDownloadURL(themeDisplay,
fileEntry);
%>
<a href="" onClick="return Popup('<%=downloadURL%>')">Preview</a>





<script type="text/javascript">
	function Popup(downloadURL) {
		newwindow = window.open(downloadURL, 'name', 'height=500,width=900');
		if (window.focus) {
			newwindow.focus()
		}
		return false;

	}
</script>