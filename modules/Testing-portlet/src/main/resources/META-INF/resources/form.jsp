<%@ include file="/init.jsp"%>

<%
	String sessionJS = (String) request.getSession().getId();
%>

<aui:form method="post" name="addObjectEntry"
	onSubmit='<%="event.preventDefault(); " + liferayPortletResponse.getNamespace() + "addObjectEntry();"%>'>
	<aui:input name="message" id="message" />
	<aui:input name="document" id="document" type="file" />
	<aui:button type="submit" value="add"></aui:button>
</aui:form>




<aui:script use="aui-base">
    Liferay.provide(
        window,
        '<portlet:namespace />addObjectEntry',
        () => {
        var sessionId = "<%=sessionJS%>";
        var fileInput = document.getElementById("<portlet:namespace />document");
        var f = fileInput.files[0]; // FileList object
        var reader = new FileReader();
        var fileName = fileInput.files[0].name;
        console.log("File Name:::::::: "+fileName);
          const username = 'test@liferay.com';
        const password = '1234';
        const base64Credentials = btoa(username + ':' + password);
         var message = A.one('#<portlet:namespace />message');
            var companyId ="<%=themeDisplay.getCompanyId()%>";
			var userId ="<%=themeDisplay.getUserId()%>";
			var groupId ="<%=themeDisplay.getScopeGroupId()%>";
        reader.onload = (function(theFile) {
        return function(e) {
          var binaryData = e.target.result;
          var bs = window.btoa(binaryData);
               Liferay.Util.fetch('/o/comments-headless/v1.0/post-comments-entrys', {
               body: JSON.stringify({
                message: message.val(),
                companyId: companyId,
                userId: userId,
                base64Doc: bs,
                fileName: fileName,
                groupId:groupId
            }),
                method: 'POST',
				 headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + base64Credentials,
            },
            }).then(function(response) {
                return response.json();
            }).then(function(response) {
                
             	Liferay.Util.openToast({
                    autoClose: true,
                    message: 'Comments Entry Created',
                    type: 'success'
            });
                
                
            }).catch((error) => {
            console.log(error);
                Liferay.Util.openToast({
                    autoClose: false,
                    message: Liferay.Language.get(
                        'an-unexpected-system-error-occurred'
                    ),
                    type: 'danger',
                });
            });
        };
      })(f);
      reader.readAsBinaryString(f);
        
        },
        ['aui-base','aui-io-request','io', 'liferay-notification','liferay-util-window']
    );
    
</aui:script>
