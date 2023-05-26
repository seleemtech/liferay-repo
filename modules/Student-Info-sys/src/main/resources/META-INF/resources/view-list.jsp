
<%@page import="com.student.info.service.service.StudentLocalServiceUtil"%>
<%@page import="com.student.info.service.model.Student"%>
<%@page import="com.student.info.service.model.Parent"%>
<%@page import="com.student.info.service.service.ParentLocalServiceUtil"%>
<%@page import="com.student.info.service.model.Teacher"%>
<%@page
	import="com.student.info.service.service.TeacherLocalServiceUtil"%>
<%@page import="com.student.info.service.service.CourseLocalServiceUtil"%>
<%@page import="com.student.info.service.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ include file="/init.jsp"%>
<%
	List<Course> courses = CourseLocalServiceUtil.getCourses(-1, -1);
	List<Teacher> teacher = TeacherLocalServiceUtil.getTeachers(-1, -1);
	List<Parent> parent=ParentLocalServiceUtil.getParents(-1, -1);
	List<Student> student=StudentLocalServiceUtil.getStudents(-1, -1);
%>

<p style = "font-size:20px">Course List</P>
<liferay-ui:search-container total="<%=courses.size()%>"
	var="searchContainer" delta="3" deltaConfigurable="true"
	emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">

	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(courses, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.student.info.service.model.Course" modelVar="course"
		keyProperty="courseId">
		
    

		<liferay-ui:search-container-column-text name="courseName"
			property="courseName" />
		<liferay-ui:search-container-column-text name="subject"
			property="subject" />



		<liferay-ui:search-container-column-text name="Actions">

			<portlet:actionURL name="/deleteCourseURL" var="deleteCourseURL">
				<portlet:param name="courseId" value="${course.courseId}" />
			</portlet:actionURL>

			<portlet:renderURL var="updateCourseUser">
				<portlet:param name="mvcPath" value="/addCourse.jsp" />
				<portlet:param name="courseId" value="${course.courseId}"></portlet:param>
			</portlet:renderURL>

			<liferay-ui:icon-menu>
				<liferay-ui:icon message="Delete" url="<%=deleteCourseURL%>" />
				<liferay-ui:icon message="Update" url="<%=updateCourseUser%>" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<P>Teacher List</P>
<liferay-ui:search-container total="<%=teacher.size()%>"
	var="searchContainer" delta="6" deltaConfigurable="true"
	emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">

	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(teacher, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.student.info.service.model.Teacher" modelVar="teachers"
		keyProperty="teacherId">

		<liferay-ui:search-container-column-text name="teacherName"
			property="teacherName" />
			<liferay-ui:search-container-column-text name="teacherEmail"
			property="teacherEmail" />
		



		<liferay-ui:search-container-column-text name="Actions">

			<portlet:actionURL name="/deleteTeacherURL" var="deleteTeacherURL">
				<portlet:param name="teacherId" value="${teachers.teacherId}" />
			</portlet:actionURL>

			<portlet:renderURL var="updateTeacherUser">
				<portlet:param name="mvcPath" value="/addTeacher.jsp" />
				<portlet:param name="teacherId" value="${teachers.teacherId}"></portlet:param>
			</portlet:renderURL>

			<liferay-ui:icon-menu>
				<liferay-ui:icon message="Delete" url="<%=deleteTeacherURL%>" />
				<liferay-ui:icon message="Update" url="<%=updateTeacherUser%>" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<p style = "font-size:20px">Parent List</P>
<liferay-ui:search-container total="<%=parent.size()%>"
	var="searchContainer" delta="6" deltaConfigurable="true"
	emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">

	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(parent, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.student.info.service.model.Parent" modelVar="parents"
		keyProperty="parentId">

		<liferay-ui:search-container-column-text name="parentName"
			property="parentName" />
		<liferay-ui:search-container-column-text name="parentContact"
			property="parentContact" />



		<liferay-ui:search-container-column-text name="Actions">

			<portlet:actionURL name="/deleteParentURL" var="deleteParentURL">
				<portlet:param name="parentId" value="${parents.parentId}" />
			</portlet:actionURL>

			<portlet:renderURL var="updateParentURL">
				<portlet:param name="mvcPath" value="/updateParent.jsp" />
				<portlet:param name="parentId" value="${parents.parentId}"></portlet:param>
			</portlet:renderURL>

			<liferay-ui:icon-menu>
				<liferay-ui:icon message="Delete" url="<%=deleteParentURL%>" />
				<liferay-ui:icon message="Update" url="<%=updateParentURL%>" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>


<p style = "font-size:20px">Student List</P>
<liferay-ui:search-container total="<%=student.size()%>"
	var="searchContainer" delta="6" deltaConfigurable="true"
	emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">

	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(student, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.student.info.service.model.Student" modelVar="students"
		keyProperty="studentId">

		<liferay-ui:search-container-column-text name="studentName"
			property="studentName" />
		<liferay-ui:search-container-column-text name="studentPlace"
			property="studentPlace" />

<liferay-ui:search-container-column-text name="studentEmail"
			property="studentEmail" />


		<liferay-ui:search-container-column-text name="Actions">

			<portlet:actionURL name="/deleteStudentURL" var="deleteStudentURL">
				<portlet:param name="studentId" value="${students.studentId}" />
			</portlet:actionURL>

			<portlet:renderURL var="updateStudentURL">
				<portlet:param name="mvcPath" value="/updateStudent.jsp" />
				<portlet:param name="studentId" value="${students.studentId}"></portlet:param>
			</portlet:renderURL>

			<liferay-ui:icon-menu>
				<liferay-ui:icon message="Delete" url="<%=deleteStudentURL%>" />
				<liferay-ui:icon message="Update" url="<%=updateStudentURL%>" />
			</liferay-ui:icon-menu>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>