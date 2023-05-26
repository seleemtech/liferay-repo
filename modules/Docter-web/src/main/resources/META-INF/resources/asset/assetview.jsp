<%@page import="com.docter.service.model.Docters"%>
<%@ include file="../init.jsp"%>
<%
	Docters docter = (Docters) request.getAttribute("docter");
%>
<div class="col-md-8">
	<%=docter.getDocterName()%>
</div>