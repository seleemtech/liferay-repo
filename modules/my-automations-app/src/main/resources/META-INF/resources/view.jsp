<%@page import="api.master.slayer.model.ConnectedAccounts" %>
<%@page import="java.util.List" %>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %>
<%@page import="javax.portlet.PortletURL" %>
<%@ page import="com.my.automations.app.display.context.MyAutomationDisplayContext" %>
<%@ include file="/init.jsp" %>


<%
    MyAutomationDisplayContext myAutomationDisplayContext = new MyAutomationDisplayContext(renderRequest, renderResponse);
%>
<aui:input name="appName" id="appName" type="hidden"/>
<div class="add-connect">
    <h1 class="head-text">My connected accounts</h1>
    <button class="add-btn" id="<portlet:namespace/>new-automation">
        <span>+</span>
        <a href=""> New Account</a>
    </button>
</div>
<div class="row">
    <%
        for (ConnectedAccounts account : myAutomationDisplayContext.getAccountsByUserId(themeDisplay.getUserId())) {

    %>
    <div class="col-md-4 mt-3">

        <div class="card connected-card">
            <div class="row m-4">
                <div class="col-md-3 m-auto">
                    <div class="connection-img">
                        <img src="http://localhost:8080/documents/d/guest/1" alt=""/>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="card-body p-1">

                        <h5 class="card-title"><%=account.getAppName()%> - <%=account.getEmailAddress()%>
                        </h5>
                        <p class="ac-create">Created on : <%=account.getCreateDate()%>, Used
                            in <%=myAutomationDisplayContext.countIdsPresent(account.getC_accountId(), themeDisplay.getUserId())%>
                            automations</p>

                    </div>
                </div>
            </div>
            <div class="card-footer">
                <button class="card-btn" onclick="reConnect('<%=account.getAppName()%>')">
                    <svg
                            viewBox="0 0 48 48"
                            width="16"
                    >
                        <path fill="#918e9f"
                              d="M37.8,15.7l-8,8h6c0,6.6-5.4,12-12,12c-2,0-3.9-0.5-5.6-1.4l-2.9,2.9c2.5,1.5,5.4,2.5,8.5,2.5 c8.8,0,16-7.2,16-16h6L37.8,15.7z M11.8,23.7c0-6.6,5.4-12,12-12c2,0,3.9,0.5,5.6,1.4l2.9-2.9c-2.5-1.6-5.4-2.5-8.5-2.5 c-8.8,0-16,7.2-16,16h-6l8,8l8-8H11.8z"></path>
                    </svg>
                    Reconnect
                </button>
                <button class="card-btn"
                        <%=myAutomationDisplayContext.isIdPresent(account.getC_accountId(), themeDisplay.getUserId()) ? "disabled" : "" %>
                        onclick="disConnect('<%=account.getC_accountId()%>')">
                    <svg
                            viewBox="0 0 48 48"
                            width="16"
                    >
                        <path fill="#918e9f"
                              d="M26,6h-4v20h4V6z M35.7,10.3l-2.8,2.8C36,15.7,38,19.6,38,24c0,7.7-6.3,14-14,14s-14-6.3-14-14 c0-4.4,2-8.3,5.2-10.8l-2.8-2.8C8.5,13.6,6,18.5,6,24c0,9.9,8.1,18,18,18s18-8.1,18-18C42,18.5,39.5,13.6,35.7,10.3z"></path>
                    </svg>
                    Disconnect
                </button>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
<portlet:resourceURL id="get/authorization/url" var="getAuthorizationUrl"/>
<portlet:resourceURL id="add/user/accounts" var="addUserAccountsUrl"/>
<portlet:resourceURL id="revoke/accounts" var="revokeAccountsUrl"/>
<div class="card  new-auto" style="display: none;">
    <input type="text" class="search-bar" placeholder="Search...">
    <div class="icons-container">
        <div class="icon" onclick="selectIcon(this)">
            <img src="http://localhost:8080/documents/d/guest/1" alt="Google Sheet">
            <span class="icon-name">Google Sheet</span>
        </div>
        <div class="icon" onclick="selectIcon(this)">
            <img src="http://localhost:8080/documents/d/guest/2" alt="Gmail">
            <span class="icon-name">Gmail</span>
        </div>
    </div>
</div>

<script>
    $('#<portlet:namespace/>new-automation').click(function () {
        $('.new-auto').show();

    });
    $(document).ready(function () {
        var params = new URLSearchParams(window.location.search);
        var accessCode = params.get('code');
        if (accessCode !== null) {
            var containerSpinner = document.getElementById('container-spinner');
            containerSpinner.style.display = 'flex';
            var appName = sessionStorage.getItem("appName");
            sessionStorage.removeItem('appName');
            // setTimeout(function () {
            $.ajax({
                type: 'GET',
                data: {'<portlet:namespace/>accessCode': accessCode, '<portlet:namespace/>appName': appName},
                dataType: 'json',
                url: "<%=addUserAccountsUrl%>",
                async: false,
                cache: false,
                success: function (data) {
                    containerSpinner.style.display = 'none';

                    if (data.redirectUrl !== null) {
                        Liferay.Util.openToast({
                            autoClose: true,
                            message: 'Application Connected Successfully',
                            type: 'success'
                        });
                        setTimeout(function () {
                            document.location.href = data.redirectUrl;
                        }, 1000);
                    }
                },

                error: function (xhr, textStatus, errorThrown) {
                    containerSpinner.style.display = 'none';
                    Liferay.Util.openToast({
                        autoClose: false,
                        message: Liferay.Language.get(
                            'an-unexpected-system-error-occurred'
                        ),
                        type: 'danger',
                    });
                }
            });
            // }, 2000);
        }else{
            sessionStorage.removeItem('appName');
        }


    });

    function selectIcon(iconElement) {
        const appName = iconElement.querySelector('.icon-name').innerText;
        var containerSpinner = document.getElementById('container-spinner');
        containerSpinner.style.display = 'flex';
        sessionStorage.setItem("appName",appName);
        $.ajax({
            type: 'GET',
            data: {'<portlet:namespace/>appName': appName},
            dataType: 'json',
            url: "<%=getAuthorizationUrl%>",
            async: false,
            cache: false,
            success: function (data) {
                // Hide loader after receiving the response
                containerSpinner.style.display = 'none';

                if (data.url !== null) {
                    var url = data.url;
                    window.location.replace(url);
                }
            },
            error: function (xhr, textStatus, errorThrown) {
                containerSpinner.style.display = 'none';
                Liferay.Util.openToast({
                    autoClose: false,
                    message: Liferay.Language.get(
                        'an-unexpected-system-error-occurred'
                    ),
                    type: 'danger',
                });
            }
        });
    }

    function reConnect(appName) {

        var containerSpinner = document.getElementById('container-spinner');
        containerSpinner.style.display = 'flex';
        sessionStorage.setItem("appName",appName);
        $.ajax({
            type: 'GET',
            data: {'<portlet:namespace/>appName': appName},
            dataType: 'json',
            url: "<%=getAuthorizationUrl%>",
            async: false,
            cache: false,
            success: function (data) {
                // Hide loader after receiving the response
                containerSpinner.style.display = 'none';

                if (data.url !== null) {
                    var url = data.url;
                    window.location.replace(url);
                }
            },
            error: function (xhr, textStatus, errorThrown) {
                containerSpinner.style.display = 'none';
                console.error("Error:", errorThrown);
            }
        });
    }

    function disConnect(accountId) {
        var containerSpinner = document.getElementById('container-spinner');
        containerSpinner.style.display = 'flex';
        $.ajax({
            type: 'GET',
            data: {'<portlet:namespace/>accountId': accountId},
            dataType: 'json',
            url: "<%=revokeAccountsUrl%>",
            async: false,
            cache: false,
            success: function (data) {
                // Hide loader after receiving the response
                containerSpinner.style.display = 'none';

                if (data.message) {
                    var url = data.URL;
                    Liferay.Util.openToast({
                        autoClose: true,
                        message: data.message,
                        type: 'success'
                    });
                    setTimeout(function () {
                        window.location.replace(url);
                    }, 1000);

                }
            },
            error: function (xhr, textStatus, errorThrown) {
                containerSpinner.style.display = 'none';
                Liferay.Util.openToast({
                    autoClose: false,
                    message: Liferay.Language.get(
                        'an-unexpected-system-error-occurred'
                    ),
                    type: 'danger',
                });
            }
        });
    }
</script>