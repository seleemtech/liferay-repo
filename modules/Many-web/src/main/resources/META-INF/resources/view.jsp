<%@ include file="/init.jsp" %>

<portlet:actionURL name="addStudent" var="actionURL" />


<aui:form action="<%= actionURL %>" method="post" name="fm" >

  <aui:input  name ="studentName"   value=""/>
  <aui:input  name ="studentPlace" value=""/>
  <aui:input  name ="studentCollege" value=""/>
 
 
  
 
  <aui:button type="submit" > </aui:button>

</aui:form>