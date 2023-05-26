<%@ include file="/init.jsp"%>
<%
NewsEntry newsEntry =  (NewsEntry)request.getAttribute("newsEntry");
long newsImageId = newsEntry.getNewsImageId();
FileEntry fileEntry = null;
boolean isPrivateLayout = true;
Layout curLayout = null; 

if(newsEntry.getNewsScopeId() > 0){
	curLayout = LayoutLocalServiceUtil.getLayout(newsEntry.getNewsScopeId());
	isPrivateLayout =curLayout.isPrivateLayout();
}

if(Validator.isNotNull(newsImageId))
	fileEntry = DLAppServiceUtil.getFileEntry(newsImageId);
String editURL = "javascript:editURLJS(" + newsEntry.getNewsEntryId() + ","+isPrivateLayout+");";
%>
<liferay-ui:icon image="edit"
	message="Edit News Entry" url="<%=editURL %>" 
/>
<div class="row">
<div style="padding-left: 15px;">News Scope: <%=(Validator.isNotNull(curLayout))?curLayout.getName(themeDisplay.getLocale()):"Home Page News" %></div>
    <c:if test="<%=Validator.isNotNull(fileEntry)%>">
	    <div class="col-md-4" >
	    <img alt="" class="img-thumbnail"
					src="<%=DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay,
								"&imageThumbnail=1")%>"
					style="<%=DLUtil.getThumbnailStyle(true, 0, 256, 256)%>" />
	    </div>
    </c:if>
   <div class="col-md-8" >
   <%=newsEntry.getNewsContent()%>
    </div>

</div>

<script>
AUI().use(
		'node',
		'event','liferay-util-window','liferay-portlet-url',
		function(A) {
Liferay.provide(window, 'editURLJS', function(newsEntryId,isPrivateLayout) {
var url =Liferay.PortletURL.createRenderURL();    
url.setPortletId('com_att_hr_onestop_news_publication_portlet'); 
url.setWindowState('pop_up');  
url.setParameter('newsEntryId',newsEntryId);
url.setParameter('isPrivateLayout',isPrivateLayout.toString());
url.setParameter('mvcPath','/editNewsEntry.jsp');
var messageDialog = Liferay.Util.openWindow(
		{
			dialog: {
				
				centered: true,
				constrain: true,
				destroyOnHide: true,
				height: 800,
				modal: true,
				width: 850,
				after: {
					destroy: function(event) {
						window.location.reload();
					}
				}
			},
			id: 'Dialog',
			title: Liferay.Language.get('Edit News Entry'),
			uri: url
		}
	);

});
});
</script>



      