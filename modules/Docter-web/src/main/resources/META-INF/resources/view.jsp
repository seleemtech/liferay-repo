
<%@ include file="/init.jsp"%>



<%
	String tabs1 = ParamUtil.getString(request, "tabs1");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("tabs1", tabs1);
	List<Docters> crdlist = (List<Docters>) renderRequest.getAttribute("crd");
%>

<portlet:resourceURL var="saveDataUrl" />
<portlet:renderURL var="RenderURL">
	<portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>
<aui:button type="submit" onClick="<%=RenderURL%>" value="add"></aui:button>


<portlet:actionURL var="groupActionURL" name="groupAction"></portlet:actionURL>


<aui:a cssClass="btn btn-default"
	href='<%="javascript:" + renderResponse.getNamespace() + "groupAction('delete');"%>'
	label="Delete" title="Delete"></aui:a>

<aui:form action="<%=groupActionURL.toString()%>" method="post"
	name="fm">
	<aui:input name="docterIds" type="hidden" />
	<aui:input name="<%=Constants.CMD%>" type="hidden" />
	<aui:input name="tabs1" value="<%=tabs1%>" type="hidden" />

	<liferay-ui:search-container delta="5"
		emptyResultsMessage="No docters Found!!" total='<%=crdlist.size()%>'
		rowChecker='<%=new EmptyOnClickRowChecker(renderResponse)%>'>
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(crdlist, searchContainer.getStart(), searchContainer.getEnd())%>" />
		<liferay-ui:search-container-row
			className="com.docter.service.model.Docters" keyProperty="docterId"
			modelVar="crd">
			<liferay-ui:search-container-column-text property="docterId"
				name="docterId" />
			<liferay-ui:search-container-column-text property="docterName"
				name="docterName" />
			<liferay-ui:search-container-column-text name="Workflow Status">
				<aui:workflow-status markupView="lexicon" showIcon="<%=false%>"
					showLabel="<%=false%>" status="<%=crd.getStatus()%>" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>
<aui:form>
<aui:input name="axaxName" id="ddd" />
<aui:button value="AjaxValue" onClick="callServeResource()"></aui:button>
</aui:form>
<h4>
	Serve resource response will be printed here: <span id="spanid"></span>
</h4>

<%-- <aui:script use="aui-base,liferay-util-window,liferay-portlet-url">
	Liferay
			.provide(
					window,
					'<portlet:namespace />groupAction',
					function(cmd) {
						A.one('#<portlet:namespace />cmd').val(cmd);
						var docterIds = Liferay.Util.listCheckedExcept(
								<portlet:namespace />fm,
								'<portlet:namespace />allRowIds');
						if (docterIds == "" || docterIds == null) {
							alert("Please select atleast one record.");
							return;
						}
						A.one('#<portlet:namespace />docterIds').val(
								docterIds);
						if (cmd == 'delete') {
							if (confirm('<%=UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-entries")%>')) {

								submitForm(document.<portlet:namespace />fm);
							}
						}

					});
					
				
	
	
	</aui:script> --%>

<aui:script>
		function callServeResource(){
	 AUI().use('aui-base','aui-io-request', function(A){
	 
					console.log("testing");
					 var name = A.one("#<portlet:namespace />ddd").get('value');
					A.io.request('<%=saveDataUrl%>',{
					dataType: 'json',
					  method: 'POST',
					   data: { <portlet:namespace />axaxName:name},
					on:{
					success:function(){
					var data = this.get('responseData');
					 document.getElementById('spanid').innerHTML=data.axaxName;
					}
					}
					
					});
				
	 
	 });
	
	}
	</aui:script>

