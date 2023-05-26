
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/init.jsp" %>

<portlet:renderURL var="secondJspURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>


<portlet:renderURL var="second" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<aui:button id="popupButton" value="Open Popup Using AUI Script " />
<aui:button onClick="${second}" useDialog="true" value="Open Popup Using useDialog" />

<aui:script position="inline" use="aui-base">
var popupButton = A.one('#<portlet:namespace />popupButton');
popupButton.on('click',
	function() {
		Liferay.Util.openWindow(
			{
				dialog: {
					//cssClass: 'aui-popup-example',
					destroyOnHide: true,
					height: 400,
					width: 400
				},
				dialogIframe: {
					//bodyCssClass: 'custom-css-class'
				},
				title: 'My Own Title(400x400 Window Size)',
				uri: '<%=secondJspURL.toString()%>'
			}
		);
	}
);
</aui:script>