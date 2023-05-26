<%@page import="com.student.info.service.model.Teacher"%>
<%@page
	import="com.student.info.service.service.TeacherLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.student.info.service.service.CourseLocalServiceUtil"%>
<%@page import="com.student.info.service.model.Course"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<portlet:actionURL name="/addTeacher" var="addTeacherActionURL" />
<%
	long teacherId = 0;
	try {
		teacherId = ParamUtil.getLong(renderRequest, "teacherId");

	} catch (Exception e) {

	}

	Teacher teacher = null;
	long courseId = 0;
	if (teacherId > 0) {
		teacher = TeacherLocalServiceUtil.fetchTeacher(teacherId);
		List<Course> listcourses = CourseLocalServiceUtil.getTeacherCourses(teacherId);
		for (Course course : listcourses) {
			courseId = course.getCourseId();
		}
	}
%>

<portlet:resourceURL id="/getSubjects" var="resourceURL" />
<div class="container mt-5" id="cont">
	<div class="row">
		<div class="col-md-6 mx-auto">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title text-center">Student Portal</h4>
					<aui:form action="<%=addTeacherActionURL%>" method="POST"
						name="form" id="form">
						<aui:model-context bean="<%=teacher%>" model="<%=Teacher.class%>" />
						<div class="form-group">
							<aui:input class="form-control" name="teacherId" type="hidden"
								placeholder="Enter Course name" />
							<aui:input label="Teacher Name" type="text" class="form-control"
								name="teacherName" placeholder="Enter Teacher name">
								<aui:validator name="required" />
							</aui:input>
						</div>
						<div class="form-group">
							<aui:input label="Email Address" type="text" class="form-control"
								name="teacherEmail" placeholder="Enter Email">
								<aui:validator name="required" />
							</aui:input>
						</div>
						<div class="form-group">
							<aui:select label="Class" required="true" class="form-control"
								id="courseId" name="courseId">
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
						<div class="form-group" id="subjectList"></div>
						<aui:button type="submit" value="add Teacher" />
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>

<aui:script>
AUI().use('aui-base','aui-io-request','aui-node', function(A){
A.one("#<portlet:namespace />courseId").on('change',function(){
 alert("Hi yont and Thank You");
 var courseId = this.get('value');
 console.log("dsndknkn"+courseId);

  A.io.request('<%=resourceURL%>', {
            method: 'post',
            data: $("#<portlet:namespace />form").serialize(),
            dataType: 'JSON',
            on: {
                success: function(data) {
                
    console.log(data);
                },
                failure: function() {
                    // handle failure
                }
            }
        });
})
  $(document).ready(function() {
    var selectedCourseId = <%=courseId%>;
    $('#<portlet:namespace />courseId').val(selectedCourseId);
  });
});

</aui:script>
