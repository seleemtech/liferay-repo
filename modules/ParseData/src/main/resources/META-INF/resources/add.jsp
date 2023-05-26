<%@page import="java.util.Base64"%>
<%@page import="com.liferay.petra.string.StringUtil"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.io.FileUtils"%>
<%@page import="org.apache.commons.io.IOUtils"%>

<%@page import="java.io.InputStream"%>
<%@ include file="/init.jsp"%>


<%

	String filePath = (String) request.getAttribute("filePath");
String fileName = new File(filePath).getName();
	 System.out.println("came here" + filePath);
	 String fileURL = "http://localhost/" + fileName;
%>
<div>
  <iframe id="file-preview" style="width:100%;height:500px;"></iframe>
</div>

<script>
  $(document).ready(function() {
    var fileURL = '<%= filePath %>';
    $.ajax({
      url: fileURL,
      type: 'GET',
      dataType: 'text',
      success: function(data) {
        $('#file-preview').attr('srcdoc', data);
        console.log(data);
      },
      error: function() {
        console.log('Error fetching file content');
      }
    });
  });
</script>

