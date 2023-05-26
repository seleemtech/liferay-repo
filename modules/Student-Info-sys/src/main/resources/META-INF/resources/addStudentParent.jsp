<%@page import="com.student.info.service.service.CourseLocalServiceUtil"%>
<%@page import="com.student.info.service.model.Course"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name="/addStudentParent" var="addStudentActionURL" />



<div class="container mt-5" id="cont">
	<div class="row">
		<div class="col-md-6 mx-auto">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title text-center">Student Portal</h4>
					<aui:form action="<%=addStudentActionURL%>" method="POST" name="fm"
						id="fm">

						<div class="form-group">
							<aui:input label="Student Name" type="text" class="form-control"
								name="studentName" placeholder="Enter Student name">
								<aui:validator name="required" />
							</aui:input>
						</div>
						<div class="form-group">
							<aui:input label="Student Address" type="text" class="form-control"
								name="studentPlace" placeholder="Enter Student Address">
								<aui:validator name="required" />
							</aui:input>
						</div>
							<div class="form-group">
							<aui:input label="Student Email" type="text" class="form-control"
								name="studentEmail" placeholder="Enter Student Email">
								<aui:validator name="required" />
							</aui:input>
						</div>
							<div class="form-group">
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
						<div class="form-group">
							<aui:select label="Class" required="true" class="form-control"
								id="courseId" name="courseId" >
								<aui:option value="">Select Class</aui:option>
								<%
									List<Course> courses = CourseLocalServiceUtil.getCourses(-1, -1);

											for (Course course : courses) {
								%>
								<aui:option value="<%=course.getCourseId()%>"><%=course.getCourseName()%></aui:option>
								<%
									}
								%>
								<aui:validator name="required" />
							</aui:select>
						</div>

						<aui:button type="submit" value="add Teacher" />
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
