<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.student.info.service.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.student.info.service.service.CourseLocalServiceUtil"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name="/addCourse" var="addCourseActionURL" />
<%
	long courseId = ParamUtil.getLong(renderRequest, "courseId");

	System.out.println("jsbj:::::::::::::::::::::::::::::::::" + courseId);

	Course course=null;
	if (courseId > 0) {
		course = CourseLocalServiceUtil.fetchCourse(courseId);
	}
%>


<div class="container mt-5" id="cont">
	<div class="row">
		<div class="col-md-6 mx-auto">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title text-center">Student Portal</h4>
					<aui:form action="<%=addCourseActionURL%>" method="POST" name="fm"
						id="fm">
						<aui:model-context bean="<%=course%>" model="<%=Course.class%>" />
						<div class="form-group">
							<aui:input class="form-control" name="courseId" type="hidden"
								placeholder="Enter Course name">

							</aui:input>
							<aui:input label="Course Name" type="text" class="form-control"
								name="courseName" placeholder="Enter Course name">
								<aui:validator name="required" />
							</aui:input>
						</div>

						<div class="form-group">
							<label>Subject</label>
							<div class="row">
								<div class="col-md-6">
									<aui:input label="Math" type="checkbox" name="subject"
										value="Math"></aui:input>
								</div>
								<div class="col-md-6">
									<aui:input label="Science" type="checkbox" name="subject"
										value="Science"></aui:input>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<aui:input label="English" type="checkbox" name="subject"
										value="English"></aui:input>
								</div>
								<div class="col-md-6">
									<aui:input label="History" type="checkbox" name="subject"
										value="History"></aui:input>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<aui:input label="Geography" type="checkbox" name="subject"
										value="Geography"></aui:input>
								</div>
								<div class="col-md-6">
									<aui:input label="Art" type="checkbox" name="subject"
										value="Art"></aui:input>
								</div>
							</div>
						</div>




						<aui:button type="submit"
							value="<%= (courseId > 0) ? "update Course" : "add Course" %>" />
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
  var subject = '<%=courseId>0?course.getSubject():""%>';
				console.log(subject);
				var subjectsArray = subject.split("&");
				console.log("split value]" + subjectsArray);
				$.each(subjectsArray, function(index, value) {
					$(
							'input[name=<portlet:namespace/>subject][value='
									+ value + ']').prop('checked', true);
				});

			});
</script>


