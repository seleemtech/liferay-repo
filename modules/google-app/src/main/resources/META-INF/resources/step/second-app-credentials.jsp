<%@ include file="../init.jsp" %>
<liferay-util:include page="/step/step-tracker.jsp" servletContext="<%= application %>"/>

<%
    String pageName = (String) request.getAttribute("pageName");
    String firstAppName = ParamUtil.getString(renderRequest, "firstAppName");
    String secondAppName = ParamUtil.getString(renderRequest, "secondAppName");
    GoogleAppDisplayContext formIntegrationDisplayContext = new GoogleAppDisplayContext(renderRequest, renderResponse);
%>
<aui:input name="accessToken" id="accessToken" type="hidden"/>
<aui:input name="emailAddress" id="emailAddress" type="hidden"/>
<aui:input name="refreshToken" id="refreshToken" type="hidden"/>
<portlet:resourceURL id="app/sheets" var="appSheetUrls"/>
<portlet:resourceURL id="app/work/sheets" var="appWorkSheetUrls"/>
<div class="main-connection-div">

    <div class="connection-img">
        <img src="http://localhost:8080/documents/d/guest/1" alt=""/>
    </div>

    <div class="connection-alert">
        <span class="exclamation">!</span> <span class="alert-text">Select
                Connection</span>
    </div>
    <c:forEach items="<%=formIntegrationDisplayContext.getAccountsByUserId(themeDisplay.getUserId(),firstAppName)%>"
               var="account">
        <div class="connection-select">
            <label class="connection">
                <input type="radio" name="connection" value="${account.getRefreshToken()}"
                       onclick="handleRadioClick(this)"/> Google Sheets - ${account.getEmailAddress()}
            </label>
        </div>
    </c:forEach>

    <a href="" class="add-connection">Add Connection</a>
</div>
<div class="row justify-content-center margin-auto-main">
    <div class="select-option-div col-md-6">
        <div class="connection-img">
            <img src="http://localhost:8080/documents/d/guest/1" alt=""/>
        </div>
        <div class="normal-text"><span>Spreadsheet row is created or updated in Google Sheets</span></div>
        <div class="option-div-info"><span style="color: rgb(245,110,79);">Requirement: </span><span> First row of sheet should have column names</span>
        </div>
        <label class="input-label-custom" for="spreadsheetName">Select Spreadsheet <span
                style="color: rgb(245,110,79);font-size: .688rem;">Required</span></label>
        <aui:input name="spreadsheetName" label="" id="spreadsheetName"/>
        <aui:input name="spreadsheetValue" id="spreadsheetValue" type="hidden"/>
        <label class="input-label-custom" for="workSheet">Select Worksheet <span
                style="color: rgb(245,110,79);font-size: .688rem;">Required</span></label>
        <aui:input name="workSheet" label="" id="workSheet"/>
        <aui:input name="workSheetValue" label="" id="workSheetValue" type="hidden"/>
        <aui:button-row>
            <aui:button cssClass="pull-right" name="continue1"
                        onclick='<%= liferayPortletResponse.getNamespace() + "nextStepUrl();" %>' type="submit"
                        value="continue"/>
        </aui:button-row>
    </div>

    <div class="select-data col-md-4">

    </div>
    <div class="select-data-value col-md-4">

    </div>
</div>

<script>
    Liferay.provide(
        window,
        '<portlet:namespace />nextStepUrl',
        () => {
            var containerSpinner = document.getElementById('container-spinner');
            containerSpinner.style.display = 'flex';
            var firstAppName = "<%=firstAppName%>";
            var secondAppName = "<%=secondAppName%>";
            const parts = Liferay.currentURL.split("?");


            var spreadsheetValueInput = $('#<portlet:namespace/>spreadsheetValue');
            var workSheetInput = $('#<portlet:namespace/>workSheet');

            var refreshTokenInput = $('#<portlet:namespace/>refreshToken');
            var emailAddressInput = $('#<portlet:namespace/>emailAddress');
            sessionStorage.setItem('secondAppRefreshToken', refreshTokenInput.val());
            sessionStorage.setItem('secondAppUserEmailAddress', emailAddressInput.val());
            sessionStorage.setItem('secondAppSpreadSheetId', spreadsheetValueInput.val());
            sessionStorage.setItem('secondAppWorkSheetName', workSheetInput.val());

            const baseUrl = parts[0];

            var portletURL = Liferay.PortletURL.createURL(baseUrl);

            portletURL.setLifecycle(0);
            portletURL.setParameter('firstAppName', firstAppName);
            portletURL.setParameter('secondAppName', secondAppName);
            portletURL.setParameter('mvcRenderCommandName', 'form/app/integration');
            portletURL.setPortletId('com_google_app_GoogleAppPortlet');

            console.log("portletURL" + portletURL);
            window.location.replace(portletURL.toString());
        },
        ['liferay-portlet-url']
    );
    Liferay.provide(
        window,
        '<portlet:namespace />previousStepURL',
        () => {
            var firstAppName = "<%=firstAppName%>";
            var secondAppName = "<%=secondAppName%>";
            const parts = Liferay.currentURL.split("?");

            const baseUrl = parts[0];
            var portletURL = Liferay.PortletURL.createURL(baseUrl);

            portletURL.setLifecycle(0);
            portletURL.setParameter('firstAppName', firstAppName);
            portletURL.setParameter('secondAppName', secondAppName);
            portletURL.setParameter('mvcRenderCommandName', 'firstConnectionName');
            portletURL.setPortletId('com_google_app_GoogleAppPortlet');
            window.location.replace(portletURL.toString());
        },
        ['liferay-portlet-url']
    );

    function handleRadioClick(radioButton) {
        var containerSpinner = document.getElementById('container-spinner');
        containerSpinner.style.display = 'flex';
        var refreshToken = radioButton.value;
        var pageName = "<%=pageName%>";

        var refreshTokenInput = $('#<portlet:namespace/>refreshToken');
        var emailAddressInput = $('#<portlet:namespace/>emailAddress');


        $.ajax({
            type: 'GET',
            data: {
                '<portlet:namespace/>refreshToken': refreshToken
            },
            dataType: 'json',
            url: "<%=appSheetUrls%>",
            async: false,
            cache: false,
            success: function (data) {
                //modified code
                if (data.refreshToken !== null) {

                    emailAddressInput.val(data.emailAddress);
                    $(".exclamation").text("");
                    $(".alert-text").text("Connected"); // Change the text content to "Connected"
                    $(".alert-text").removeClass("alert-text").addClass("success-text");
                    $(".exclamation").removeClass("exclamation").addClass("right");

                    setTimeout(function () {
                        containerSpinner.style.display = 'none';
                        $(".main-connection-div").hide();
                        $(".select-option-div").show();

                        var selectDataDiv = $(".select-data");
                        refreshTokenInput.val(data.refreshToken);
                        selectDataDiv.empty();
                        var jsonArray = JSON.parse(data.sheet);
                        jsonArray.forEach(function (spreadsheet) {
                            var name = spreadsheet.name;
                            var id = spreadsheet.id;

                            var radioButton = $('<input>').attr({
                                type: 'radio',
                                name: 'connection',
                                value: id + '&' + name,
                            }).on('click', function () {
                                handleSelectSheet(this);
                            });

                            var label = $('<label>').addClass('connection-data').text(name);

                            var connectionSelectDiv = $('<div>').addClass('connection-select-data').append(radioButton, label);

                            selectDataDiv.append(connectionSelectDiv);
                        });
                    }, 3000);
                }


            },
            error: function (xhr, textStatus, errorThrown) {
                containerSpinner.style.display = 'none';
                console.error("Error:", errorThrown);
            }
        });
    }

    function handleSelectSheet(sheet) {
        // Clear the input fields
        var spreadSheetInput = $('#<portlet:namespace/>spreadsheetName');
        var spreadSheetValueInput = $('#<portlet:namespace/>spreadsheetValue');
        spreadSheetInput.val('');
        spreadSheetValueInput.val('');

        // Split the combined value into id and name
        var combinedValue = sheet.value;
        var values = combinedValue.split('&');
        var id = values[0];
        var name = values[1];

        console.log("ID:", id);
        console.log("Name:", name);

        // Set the values in the input fields
        spreadSheetValueInput.val(id);
        spreadSheetInput.val(name);
    }

    $(document).ready(function () {
        $('#<portlet:namespace/>spreadsheetName').click(function () {
            $('.select-data').toggle();
            $('.select-data-value').hide();

        });

        $('#<portlet:namespace/>workSheet').click(function () {
            var containerSpinner = document.getElementById('container-spinner');
            containerSpinner.style.display = 'flex';
            $(".select-data").hide();
            $('.select-data-value').toggle();

            var spreadSheetValueInput = $('#<portlet:namespace/>spreadsheetValue');
            var accessTokenInput = $('#<portlet:namespace/>accessToken');
            var refreshTokenInput = $('#<portlet:namespace/>refreshToken');
            // Check if spreadSheetValueInput is empty
            if (spreadSheetValueInput.val() === '') {
                containerSpinner.style.display = 'none';
                $(".select-data-value").append('<div class="no-records-div"><p>No Records Found</p></div>');
            } else {

                // Remove the no-records-div if spreadSheetValueInput is not empty
                $(".no-records-div").remove();
                $.ajax({
                    type: 'GET',
                    data: {
                        '<portlet:namespace/>spreadSheetKey': spreadSheetValueInput.val(),
                        '<portlet:namespace/>accessToken': accessTokenInput.val(),
                        '<portlet:namespace/>refreshToken': refreshTokenInput.val()
                    },
                    dataType: 'json',
                    url: "<%=appWorkSheetUrls%>",
                    async: false,
                    cache: false,
                    success: function (data) {
                        containerSpinner.style.display = 'none';
                        var selectDataValueDiv = $(".select-data-value");
                        selectDataValueDiv.empty();
                        var jsonArray = JSON.parse(data.workSheet);
                        jsonArray.forEach(function (spreadsheet) {
                            var name = spreadsheet.sheetName;
                            var id = spreadsheet.sheetId;

                            var radioButton = $('<input>').attr({
                                type: 'radio',
                                name: 'connection',
                                value: id + '&' + name,
                            }).on('click', function () {
                                handleSelectWorkSheet(this);
                            });

                            var label = $('<label>').addClass('connection-data').text(name);

                            var connectionSelectDiv = $('<div>').addClass('connection-select-data').append(radioButton, label);

                            selectDataValueDiv.append(connectionSelectDiv);
                        });

                    },
                    error: function (xhr, textStatus, errorThrown) {
                        containerSpinner.style.display = 'none';
                        console.error("Error:", errorThrown);
                    }
                });
            }

        });


        function handleSelectWorkSheet(sheet) {
            // Clear the input fields
            var workSheetInput = $('#<portlet:namespace/>workSheet');
            var workSheetValueInput = $('#<portlet:namespace/>workSheetValue');
            workSheetInput.val('');
            workSheetValueInput.val('');

            // Split the combined value into id and name
            var combinedValue = sheet.value;
            var values = combinedValue.split('&');
            var id = values[0];
            var name = values[1];

            console.log("ID:", id);
            console.log("Name:", name);

            // Set the values in the input fields
            workSheetValueInput.val(id);
            workSheetInput.val(name);
        }

        function handleSelectSheet(sheet) {
            // Clear the input fields
            var spreadSheetInput = $('#<portlet:namespace/>spreadsheetName');
            var spreadSheetValueInput = $('#<portlet:namespace/>spreadsheetValue');
            spreadSheetInput.val('');
            spreadSheetValueInput.val('');

            // Split the combined value into id and name
            var combinedValue = sheet.value;
            var values = combinedValue.split('&');
            var id = values[0];
            var name = values[1];

            console.log("ID:", id);
            console.log("Name:", name);

            // Set the values in the input fields
            spreadSheetValueInput.val(id);
            spreadSheetInput.val(name);
        }
    });


</script>