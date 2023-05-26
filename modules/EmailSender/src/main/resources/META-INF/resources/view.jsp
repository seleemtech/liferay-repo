<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>

<%@ include file="/init.jsp" %>
<portlet:actionURL name="sendMails" var="actionURL" />


<aui:form action="<%= actionURL %>" method="post" name="fm" >
<aui:input name="frommail" value="<%=user.getEmailAddress() %>" lable="Send Mail"/>
<aui:input name="tomail" value="mseleem969@gmail.com" lable="To Mail"/>
<aui:input name="body" value="Email sent successfully" type="hidden" />
<aui:button type="submit">Submit</aui:button>
</aui:form>
