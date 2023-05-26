<%@ include file="init.jsp"%>
<%
	String redirectURL = ParamUtil.getString(renderRequest, "redirect");
	long newsEntryId = 0;
	long groupId = themeDisplay.getScopeGroupId();
	
	boolean isPrivateLayout = themeDisplay.getLayout().isPrivateLayout();
	if (Validator.isNotNull(request.getParameter("isPrivateLayout"))) {
		isPrivateLayout = Boolean.parseBoolean(request.getParameter("isPrivateLayout"));
	}
	boolean fileValidationrequired = true;  
	if (Validator.isNotNull(request.getParameter("newsEntryId"))) {
		newsEntryId = Long.parseLong(request.getParameter("newsEntryId"));
		fileValidationrequired = false;
	}

	NewsEntry newsEntry = null;
	try {
		newsEntry = NewsEntryLocalServiceUtil.getNewsEntry(newsEntryId);
	} catch (NoSuchNewsEntryException e) {

	}
	if (Validator.isNotNull(newsEntry)) {
		groupId = newsEntry.getGroupId();
		
	}
	String newsContent = "";
	long layoutId = 0;
	long newsImageId = 0;
	boolean isAllowedInDashBoard = false;

	if (Validator.isNotNull(newsEntry)) {
		newsContent = newsEntry.getNewsContent();
		layoutId = newsEntry.getNewsScopeId();
		isAllowedInDashBoard = newsEntry.getAllowedInDashBoard();
// 		newsImageId = newsEntry.getNewsImageId();
	}
	
	List<Layout> layouts2 = LayoutLocalServiceUtil.getLayouts(groupId, isPrivateLayout, 0l);
	boolean isApproved = true;
	String publishButtonLabel = "publish";

	if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, NewsEntry.class.getName())) {
		publishButtonLabel = "submit-for-publication";
		isApproved = false;
	}
	
%>
<liferay-portlet:actionURL var="editNewsEntryURL" name="editNewsEntry" />
<c:if test="<%=Validator.isNotNull(redirectURL) %>">
<liferay-ui:header title="back" backURL="<%=redirectURL%>" />
</c:if>

<aui:form action="<%=editNewsEntryURL.toString()%>" name="fm1"
	method="POST" enctype="multipart/form-data"
	onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveNewsEntry();" %>'>
	<aui:model-context bean="<%=newsEntry%>" model="<%=NewsEntry.class%>" />
	<aui:input name="redirect" value="<%=redirectURL%>" type="hidden"/>
	<aui:input name="isApproved" value="<%=isApproved%>" type="hidden"/>
	<aui:input name="newsEntryId" type="hidden" />
	<aui:input name="newsTitle" label="News Title" />
	<aui:input name="newsSummary" label="News Summary" />
	<liferay-ui:input-editor contents="<%=newsContent%>"
		editorName='ckeditor' name="contentEditor" placeholder="content" />

	<aui:input name="newsContent" type="hidden" />
	<aui:select name="newsScope" label="News Scope" onChange="" >
	<aui:option label="Select..."
			value="" />
	<aui:option label="Home Page News"
			value="0"
			selected="<%=(Validator.isNotNull(newsEntryId) && layoutId == 0)?true:false%>" />
	<%
			for (Layout curLayout : layouts2) {
						boolean isPillarPage = false;
						try {
							ExpandoBridge ex = curLayout.getExpandoBridge();
							if (ex.hasAttribute("isPillarPage")) {
								String value = ex.getAttribute("isPillarPage").toString();
								if (value != null && value.equalsIgnoreCase("true"))
									isPillarPage = true;
							}
							if (!isPillarPage) {
								continue;
							}
						} catch (Exception exception) {
							continue;
						}
		%>

		<aui:option label="<%=curLayout.getName(locale)%>"
			value="<%=curLayout.getPlid()%>"
			selected="<%=(layoutId == curLayout.getPlid())%>" />

		<%
			}
		%>
	</aui:select>

	<aui:input name="expireDate" label="Expire Date" />
	<aui:input name="allowedInDashBoard" label="Allowed In DashBoard" value="<%=(Validator.isNotNull(newsEntry))?newsEntry.isAllowedInDashBoard():false %>"
		type="toggle-switch" />
	<%-- <c:if test="<%=newsImageId > 0%>">
		<%
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(newsImageId);
		%>
		<div>
			<img alt="" class="img-thumbnail"
				src="<%=DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay,
							"&imageThumbnail=1")%>"
				style="<%=DLUtil.getThumbnailStyle(true, 0, 256, 256)%>" />
		</div>
		<div onclick="javascript:<portlet:namespace />showFileUpload();">Change
			Image</div>
	</c:if>

	<aui:row id="fileUpload" cssClass='<%=(newsImageId > 0) ? "hide" : ""%>'>
		<aui:col columnWidth="50">
			<aui:input type="file" class="multi" maxlength="10"
				name="attachedFile" label="Upload Image" title="Upload Image" />
			<aui:input name="newsImageId" type="hidden" />
		</aui:col>
	</aui:row> --%>
	
	<%
			boolean pending = false;

			if (newsEntry != null) {
				pending = newsEntry.isPending();
				if(pending){
					publishButtonLabel = "save";
				}
			}
			%>

			<c:if test="<%= pending %>">
				<div class="alert alert-info">
					<liferay-ui:message key="there-is-a-publication-workflow-in-process" />
				</div>
			</c:if>
	<aui:input name="ToEmail" label="Email Address"></aui:input>
	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" value='<%=publishButtonLabel %>' />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base,aui-form-validator">
var fileValidation = <%=fileValidationrequired %>;	
var rules = {
		<portlet:namespace />newsTitle: {
	       required: true
	    },
	    <portlet:namespace />newsSummary: {
		       required: true
		} ,<portlet:namespace />newsScope: {
		       required: true
		}  
		/* ,
	    <portlet:namespace />attachedFile: {
		       required: fileValidation,
		       acceptFiles: 'jpg, gif, png',
		} */
	}

	var fieldStrings = {
		<portlet:namespace />newsTitle: {
	       required: "Please enter the news title." 
	    },<portlet:namespace />newsSummary: {
	       required: "Please enter the news summary." 
	    } ,<portlet:namespace />newsScope: {
	       required: "Please select the scope of news." 
	    }  /* ,<portlet:namespace />attachedFile: {
	       required: "Please attach a Image." ,
	       acceptFiles: "Please upload only JPG,GIF,PNG files"
	    } */
	}

	
	     var validator1 =  new A.FormValidator(
	         {
	          boundingBox:'#<portlet:namespace />fm1',
	          fieldStrings: fieldStrings,
	          rules: rules,
	          showAllMessages: true
	         }
	       );
Liferay.provide(window, '<portlet:namespace />saveNewsEntry', function(){
	var contentEditor = window.<portlet:namespace />contentEditor.getHTML();
	A.one('#<portlet:namespace />newsContent').val(contentEditor);
	validator1.validate();
	if(!validator1.hasErrors()){
	submitForm(document.<portlet:namespace />fm1);
	}
});
var newsScope =A.one("#<portlet:namespace/>newsScope"); 
	newsScope.on('change',function(){
	var newsScopeVal =  newsScope.val();
	if(newsScopeVal.toString() == "0" ){
		 $('#<portlet:namespace />allowedInDashBoard').prop('checked', true);
	}else{
		$('#<portlet:namespace />allowedInDashBoard').prop('checked', false);
	}
	});

/* Liferay.provide(window, '<portlet:namespace />showFileUpload', function(){
	A.one('#<portlet:namespace />fileUpload').show();
}); */

	   

</aui:script>