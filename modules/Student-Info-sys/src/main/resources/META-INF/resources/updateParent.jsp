<%@page import="com.student.info.service.service.ParentLocalServiceUtil"%>
<%@page import="com.student.info.service.model.Parent"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name="/updateParent" var="updateParentActionURL" />
<%
long parentId=ParamUtil.getLong(renderRequest, "parentId");
Parent parent=ParentLocalServiceUtil.getParent(parentId);

%>


<div class="container mt-5" id="cont">
	<div class="row">
		<div class="col-md-6 mx-auto">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title text-center">Student Portal</h4>
					<aui:form action="<%=updateParentActionURL%>" method="POST" name="fm"
						id="fm">

						<aui:model-context bean="<%= parent%>" model="<%=Parent.class %>" />
							<div class="form-group">
							<aui:input type="hidden" class="form-control"
								name="parentId"/>
								
							<aui:input label="Parent Name" type="text" class="form-control"
								name="parentName" placeholder="Enter Parent Name">
								<aui:validator name="required" />
							</aui:input>
						</div>
							<div class="form-group">
							<aui:input label="Parent Contact" type="number" class="form-control"
								name="parentContact" placeholder="Enter Contact Number">
								<aui:validator name="required" />
							</aui:input>
						</div>
						

						<aui:button type="submit" value="update Parent" />
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
