<%@page import="com.crud.service.service.CrudLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.crud.service.model.Crud"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page
	import="com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil"%>
<%@page import="com.liferay.dynamic.data.mapping.model.DDMStructure"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ include file="/init.jsp"%>

<portlet:renderURL var="RenderURL">
	<portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>

<aui:button type="submit" onClick="<%=RenderURL%>" value="add"></aui:button>


<%
	List<Crud> crdlist = null;
	if (request.getAttribute("Findstud") != null) {
		crdlist = (List<Crud>) request.getAttribute("Findstud");
	} else {
		crdlist = CrudLocalServiceUtil.getCruds(-1, -1);
	}
%>
<portlet:actionURL name="addArticle" var="addArticlUrl" />
<aui:form name="fm" method="POST" action="<%=addArticlUrl.toString()%>">
<aui:input type="text" label="" name="dynaTitle"
		 />
		 <aui:button type="submit" value="addArticle" />
		</aui:form>
		
		
		
		
<portlet:actionURL name="searchstudent" var="studURL" />
<aui:form name="fm" method="POST" action="<%=studURL.toString()%>">
	<aui:input type="text" label="" name="crudName"
		placeholder="Search By Crud Name" />
	<aui:button type="submit" value="Search" />
</aui:form>

<liferay-ui:search-container total='<%=crdlist.size()%>'>
	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(crdlist, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.crud.service.model.Crud" modelVar="crd">
		<liferay-ui:search-container-column-text property="crudId"
			name="crudId" />
		<liferay-ui:search-container-column-text property="crudName"
			name="crudName" />

		<liferay-ui:search-container-column-text property="crudNo"
			name="crudNo" />



		<liferay-ui:search-container-column-text name="Actions">

			<portlet:actionURL name="deleteData" var="deleteCrudURL">
				<portlet:param name="crudId"
					value="<%=String.valueOf(crd.getCrudId())%>" />
			</portlet:actionURL>


			<portlet:renderURL var="updateCrud">
				<portlet:param name="mvcPath" value="/add.jsp" />
				<portlet:param name="crudId"
					value="<%=String.valueOf(crd.getCrudId())%>"></portlet:param>
			</portlet:renderURL>



			<liferay-ui:icon-menu>
				<liferay-ui:icon message="Delete" url="<%=deleteCrudURL%>" />
				<liferay-ui:icon message="Update" url="<%=updateCrud%>" />
			</liferay-ui:icon-menu>



		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<div id="onestop_news_list">

<div class="table-responsive">
		<table
			class="table table-condensed table-bordered table-hover view-list" id="view-list-table">
		</table>
	</div>
	
	</div>



<portlet:actionURL name="submitForm" var="addURL" />
<aui:form action="${addURL}" method="POST" enctype="multipart/form-data">
 <aui:select id="options" name="strucName" label=""  >
	<aui:option value="" label="Select Structure" ></aui:option>
			<%
				List<DDMStructure> strinf = DDMStructureLocalServiceUtil.getDDMStructures(-1, -1);
				for (DDMStructure p : strinf) {
					
			%>
		
	<aui:option  value="<%=String.valueOf(p.getStructureId())%>"><%=p.getName(Locale.US, true)%>
	</aui:option>
	

	
			<%
			}
			%>
</aui:select>

  
</aui:form>

<%-- <liferay-ddm:html id="some"   defaultLocale="<%=locale%>"
		groupId="<%=themeDisplay.getScopeGroupId()%>"
		defaultEditLocale="<%=locale%>" localizable="true"
		requestedLocale="<%=locale%>" classPK="40302"
		classNameId="<%=PortalUtil.getClassNameId(DDMStructure.class)%>"></liferay-ddm:html>  --%> 

	<%-- <aui:input name="dynaTitle" label=""
		prefix="Enter title and description">
		<aui:validator name="required" />
	</aui:input>
	<select name="strucName" label="" id="myInput1"
	onClick="myChangeFunction()"
	placeholder="type something then tab out">
	<option value="" label="Select Structure"></option>
	<%
		List<DDMStructure> strinf = DDMStructureLocalServiceUtil.getDDMStructures(-1, -1);
		for (DDMStructure p : strinf) {
	%>

	<option value="<%=p.getStructureId()%>"><%=p.getName(Locale.US, true)%>

		
	
		</option>
		
	
	<%
		}
	%>
</select>
	<aui:button type="submit" value="save" />
	<liferay-ddm:html name="mm"  defaultLocale="<%=locale%>"
		groupId="<%=themeDisplay.getScopeGroupId()%>"
		defaultEditLocale="<%=locale%>" localizable="true"
		requestedLocale="<%=locale%>" classPK="40256"
		classNameId="<%=PortalUtil.getClassNameId(DDMStructure.class)%>"></liferay-ddm:html>

</aui:form> --%>

<!-- <aui:script use=" node">
AUI().use('aui-base','event', function(A) {
      var option = A.one('#<portlet:namespace/>options')
option.on('click', function(event){
var exactValue=option.attr('value');
console.log(exactValue);
var secondInput=A.one('#<portlet:namespace/>some')
console.log(secondInput.attr('value'));


});
    });



</aui:script> -->
<!-- <script type="text/javascript">
$("document").ready(function(){
	
$(".strucName").click(function(data){
	var value = data.
	console.log(value);
})

	
	
})

	
</script>  -->



	
