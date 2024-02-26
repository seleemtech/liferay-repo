<%@ include file="../init.jsp" %>

<liferay-util:include page="/step/step-tracker.jsp" servletContext="<%= application %>"  />

<%
    GoogleAppDisplayContext formIntegrationDisplayContext = new GoogleAppDisplayContext(renderRequest, renderResponse);

    String pageName = (String) request.getAttribute("pageName");
    String firstAppName = ParamUtil.getString(renderRequest,"firstAppName");
    String secondAppName = ParamUtil.getString(renderRequest,"secondAppName");
%>

<portlet:actionURL name="sync/integration/Data" var="actionURL"/>
<portlet:resourceURL id="app/work/sheets/data" var="appWorkSheetDataUrls"/>
<portlet:resourceURL id="add/app/map/key/data" var="addAppMapKeyDataUrls"/>

<div class="row justify-content-center margin-auto-main">
<aui:form  method="post" style="width: 100%" onSubmit='<%=liferayPortletResponse.getNamespace()+"addMapKeyData();"%>' name="editMapKeyDataFm" id="editMapKeyDataFm">
    <aui:input name="keys" id="keys" type="hidden"/>
    <aui:input name="firstAppSpreadSheetId" id="firstAppSpreadSheetId" type="hidden"/>
    <aui:input name="secondAppSpreadSheetId" id="secondAppSpreadSheetId" type="hidden"/>
    <aui:input name="firstAppWorkSheetName" id="firstAppWorkSheetName" type="hidden"/>
    <aui:input name="secondAppWorkSheetName" id="secondAppWorkSheetName" type="hidden"/>
    <aui:input name="firstAppUserEmailAddress" id="firstAppUserEmailAddress" type="hidden"/>
    <aui:input name="secondAppUserEmailAddress" id="secondAppUserEmailAddress" type="hidden"/>
    <aui:input name="firstAppRefreshToken" id="firstAppRefreshToken" type="hidden"/>
    <aui:input name="secondAppRefreshToken" id="secondAppRefreshToken" type="hidden"/>
    <aui:input name="firstAppName" id="firstAppName"  value="<%=firstAppName%>" type="hidden"/>
    <aui:input name="secondAppName" id="secondAppName" value="<%=secondAppName%>" type="hidden"/>
<div class="main-connection-div col-md-4">

    <div class="connection-alert">
         <span class="alert-text" style="color: black">Reference Data
                </span>
    </div>
    <div class="input-div">

    </div>

</div>
    <div class="main-connection-div col-md-4">

        <div class="connection-alert">
         <span class="alert-text" style="color: black">Map Keys
                </span>
        </div>
        <div class="input-integrate-div">

        </div>
        <aui:button type="submit" value="save"></aui:button>
    </div>
</aui:form>
</div>

<script>

    $(document).ready(function () {
        var containerSpinner = document.getElementById('container-spinner');
        containerSpinner.style.display = 'flex';
    var firstAppRefreshToken = sessionStorage.getItem('firstAppRefreshToken');
    var firstAppUserEmailAddress = sessionStorage.getItem('firstAppUserEmailAddress');
    var firstAppSpreadSheetId = sessionStorage.getItem('firstAppSpreadSheetId');
    var firstAppWorkSheetName = sessionStorage.getItem('firstAppWorkSheetName');

    var secondAppRefreshToken = sessionStorage.getItem('secondAppRefreshToken');
    var secondAppUserEmailAddress = sessionStorage.getItem('secondAppUserEmailAddress');
    var secondAppSpreadSheetId = sessionStorage.getItem('secondAppSpreadSheetId');
    var secondAppWorkSheetName = sessionStorage.getItem('secondAppWorkSheetName');
        $('#<portlet:namespace/>firstAppSpreadSheetId').val(firstAppSpreadSheetId);
        $('#<portlet:namespace/>secondAppSpreadSheetId').val(secondAppSpreadSheetId);
        $('#<portlet:namespace/>firstAppUserEmailAddress').val(firstAppUserEmailAddress);
        $('#<portlet:namespace/>secondAppUserEmailAddress').val(secondAppUserEmailAddress);
        $('#<portlet:namespace/>firstAppWorkSheetName').val(firstAppWorkSheetName);
        $('#<portlet:namespace/>secondAppWorkSheetName').val(secondAppWorkSheetName);
        $('#<portlet:namespace/>firstAppRefreshToken').val(firstAppRefreshToken);
        $('#<portlet:namespace/>secondAppRefreshToken').val(secondAppRefreshToken);
        $.ajax({
            type: 'GET',
            data: {'<portlet:namespace/>firstAppSpreadSheetId': firstAppSpreadSheetId,'<portlet:namespace/>firstAppRefreshToken': firstAppRefreshToken,'<portlet:namespace/>secondAppRefreshToken': secondAppRefreshToken,'<portlet:namespace/>secondAppSpreadSheetId': secondAppSpreadSheetId,'<portlet:namespace/>firstAppWorkSheetName': firstAppWorkSheetName,'<portlet:namespace/>secondAppWorkSheetName': secondAppWorkSheetName},
            dataType: 'json',
            url: "<%=appWorkSheetDataUrls%>",
            async: false,
            cache: false,
            success: function (data) {

                var jsonObject = JSON.parse(data.firstAppLastJsonObject);
                var firstAppJsonObjectKeys = JSON.parse(data.firstAppJsonObjectKeys);
                var secondAppJsonObjectKeys = JSON.parse(data.secondAppJsonObjectKeys);
                $('#<portlet:namespace/>keys').val(data.secondAppJsonObjectKeys);
                var newDiv1 = $('<div>').addClass('input-fields');
                Object.keys(jsonObject).forEach(function(key) {
                    var label = $('<label>').text(key).addClass('custom-input-label');
                    var input = $('<input>').attr({
                        type: 'text',
                        value: jsonObject[key],
                        disabled: true
                    }).addClass('input');
                    var container = $('<div>').addClass('input-container');
                    container.append(label, input);
                    newDiv1.append(container);
                });
                $('.input-div').append(newDiv1); // Append to the first input container

                // Create a new div for the second set of input fields
                var newDiv2 = $('<div>').addClass('input-fields');

                Object.keys(secondAppJsonObjectKeys).forEach(function(key) {
                    var label = $('<label>').text(key).addClass('custom-input-label');
                    var select = $('<select>').addClass('input').attr({id: key, name: '<portlet:namespace/>' + key});

                    select.append($('<option>').text('Select field').val(''));

                    Object.keys(firstAppJsonObjectKeys).forEach(function(optionKey) {
                        var option = $('<option>').text(optionKey).val(optionKey);
                        if (optionKey === key) {
                            option.prop('selected', true);
                        }
                        select.append(option);
                    });

                    var container = $('<div>').addClass('input-container');
                    container.append(label, select);
                    newDiv2.append(container);
                });

                $('.input-integrate-div').append(newDiv2);
                containerSpinner.style.display = 'none';
            },
            error: function (xhr, textStatus, errorThrown) {
                containerSpinner.style.display = 'none';
                console.error("Error:", errorThrown);
            }
        });
    });

    Liferay.provide(
        window,
        '<portlet:namespace />addMapKeyData',
        () => {
            var containerSpinner = document.getElementById('container-spinner');
            containerSpinner.style.display = 'flex';
            console.log("insde the addMapKeyData");
            const form = document.getElementById('<portlet:namespace />editMapKeyDataFm');
            Liferay.Util.fetch('<portlet:resourceURL id="add/app/map/key/data" />', {
                body: new FormData(form),
                method: 'POST',
            })
                .then((response) => response.json())
                .then((response) => {
                    if (response.url !== null) {
                        containerSpinner.style.display = 'none';
                        Liferay.Util.openToast({
                            autoClose: true,
                            message: 'Application Integrated Successfully',
                            type: 'success'
                        });
                        setTimeout(function () {
                            document.location.href = response.url;
                        }, 1000);

                    } else {
                        containerSpinner.style.display = 'none';
                        Liferay.Util.openToast({
                            autoClose: false,
                            message: response.error,
                            type: 'danger'
                        });
                    }
                })
                .catch((error) => {
                    containerSpinner.style.display = 'none';
                    Liferay.Util.openToast({
                        autoClose: false,
                        message: Liferay.Language.get(
                            'an-unexpected-system-error-occurred'
                        ),
                        type: 'danger',
                    });
                })
                .finally(() => {
                });
            // Send an AJAX request using AUI's io.request
        },
        ['aui-base', 'aui-io-request', 'io', 'liferay-notification', 'liferay-util-window']
    );

</script>