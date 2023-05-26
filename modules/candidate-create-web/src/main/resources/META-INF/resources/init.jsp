<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>


<%-- <!-- Jquery Main cdn  Start-->
 <script defer type="text/javascript" charset="utf8" src="<%= request.getContextPath() %>/js/jquery.main.js?v=116"></script> 
<!-- Jquery Main cdn  End--> --%>

<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Candidate Stage CSS File Start-->
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/candidateStage.css" /> 
<!-- Candidate Stage CSS File End-->

<!-- Drag and Drop Column  Start-->
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/drag&drop/drag&drop.css" /> 
<%-- <script defer src="<%= request.getContextPath() %>/js/drag&drop-column/dragdrop.table.column.3.2.js?v=39"></script>
<!-- Drag and Drop Column  End--> 

<!-- Table column Toggle  Start-->
 <script defer src="<%= request.getContextPath() %>/js/table-column-toggle/table.column.toggle.js?v=39"></script> 
<!-- Table column Toggle   End-->
 --%>
  <script type="text/javascript"  src="<%= request.getContextPath() %>/js/drag&drop-column/dragdrop.table.column.3.2.js?v=126"></script> 
<script type="text/javascript" src="<%= request.getContextPath() %>/js/table-column-toggle/table.column.toggle.js?v=125"></script>  

<liferay-theme:defineObjects />

<portlet:defineObjects />