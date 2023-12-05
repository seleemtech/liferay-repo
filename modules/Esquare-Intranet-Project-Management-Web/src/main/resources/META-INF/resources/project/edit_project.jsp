<%@ page import="com.esquare.intranet.helpdesk.web.portlet.workflow.CustomWorkflowConstants" %>
<%@ include file="/META-INF/resources/init.jsp" %>
<%
    Layout clayout = themeDisplay.getLayout();

    long projectId = ParamUtil.getLong(renderRequest, "projectId");
    String proposedDateString = StringPool.BLANK;
    String confirmedDateString = StringPool.BLANK;
    String developmentDateString = StringPool.BLANK;
    String estimateDateString = StringPool.BLANK;
    boolean updateProject = false;
    Projects project = null;
    List<DLFileEntry> dlFileEntrys = new ArrayList<>();
    String viewPage = StringPool.BLANK;
    if (projectId > 0) {
        project = ProjectsLocalServiceUtil.getProject(projectId);
        proposedDateString = project.getProposedDate().toString();
        confirmedDateString = project.getConfirmedDate().toString();
        developmentDateString = project.getDevelopmentStartDate().toString();
        estimateDateString = project.getEstimatedDate().toString();
        updateProject = true;
        dlFileEntrys = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), project.getDocumentId());
    }

%>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-ui:success key="project-created-successfully" message="project-created-successfully"/>
<div id="cover-spin" name="spinner"></div>

<aui:form id="editProjectFm" name="editProjectFms" method="post"
          onSubmit='<%=  liferayPortletResponse.getNamespace() + "processProjectInfo();" %>'>
    <aui:model-context bean="<%=project%>" model="<%=Projects.class%>"/>
    <aui:fieldset>
        <c:choose>
            <c:when test="<%=updateProject%>">
                <h3>
                    Edit <%=project.getProjectName()%>
                </h3>
            </c:when>
            <c:otherwise>
                <h3>
                    Create New Project
                </h3>
            </c:otherwise>

        </c:choose>


        <div class="field-group row">
            <aui:input name="projectId" type="hidden"/>
            <aui:input name="clientId" type="hidden">
            </aui:input>
            <div class="col-md-4">
                <aui:input label="Project Name" name="projectName" required="true" type="text">
                    <aui:validator name="custom" errorMessage="Please enter only alphanumeric characters.">
                                function (value) {
                                    var regex = /^[A-Za-z0-9\s]+$/;
                                    return regex.test(value);
                                }
                    </aui:validator>
                </aui:input>
            </div>
            <div class="col-md-4">
                <aui:input label="Project Description" name="description" required="true">
                    <aui:validator name="custom" errorMessage="Please enter only alphanumeric characters.">
                                function (value) {
                                    var regex = /^[A-Za-z0-9\s]+$/;
                                    return regex.test(value);
                                }
                    </aui:validator>
                </aui:input>
            </div>
            <div class="col-md-4">
                <aui:input label="Client Name" name="name" required="true" type="text">
                    <aui:validator name="custom" errorMessage="Please enter only alphanumeric characters.">
                                function (value) {
                                    var regex = /^[A-Za-z0-9\s]+$/;
                                    return regex.test(value);
                                }
                    </aui:validator>
                </aui:input>
            </div>
        </div>

        <!-- Second Group of Fields -->
        <div class="field-group row">
            <div class="col-md-4">
                <aui:input label="Client Contact Phone" name="contactNumber">
                    <aui:validator name="digits"/>
                </aui:input>
            </div>
            <div class="col-md-4">
                <aui:input label="Client Contact Email" name="contactEmail" required="true">
                    <aui:validator name="email"/>
                </aui:input>
            </div>
            <div class="col-md-4">
                <aui:input label="Project Proposed Date" name="proposedDate" required="true" type="date"
                           id="projectProposedDate">
                    <aui:validator
                            name="date"/></aui:input>
            </div>
        </div>

        <!-- Third Group of Fields -->
        <div class="field-group row">
            <div class="col-md-4">
                <aui:input label="Project Confirmed Date" name="confirmedDate" id="projectConfirmedDate"
                           required="true" type="date">
                    <aui:validator name="date"/>
                </aui:input>
            </div>
            <div class="col-md-4">
                <aui:input label="Project Development Start Date" name="developmentStartDate" id="developmentStartDate"
                           required="true"
                           type="date">
                    <aui:validator name="custom" errorMessage="Development date cannot be less than confirmed date">
                        function(val, fieldNode, ruleValue) {
                        var confirmedDateValue, estimatedDateValue;
                        const confirmedDate = A.one('#<portlet:namespace/>projectConfirmedDate');
                        if (confirmedDate && val) {
                        confirmedDateValue = new Date(confirmedDate.val());
                        estimatedDateValue = new Date(val);
                        }
                        return confirmedDateValue <= estimatedDateValue;
                        }
                    </aui:validator>
                </aui:input>
            </div>
            <div class="col-md-4">
                <aui:input label="Delivery Estimated Date" name="estimatedDate" id="deliveryEstimatedDate"
                           type="date" required="true">
                    <aui:validator name="custom" errorMessage="Estimated date cannot be less than confirmed date">
                        function(val, fieldNode, ruleValue) {
                        var confirmedDateValue, estimatedDateValue;
                        const confirmedDate = A.one('#<portlet:namespace/>projectConfirmedDate');
                        if (confirmedDate && val) {
                        confirmedDateValue = new Date(confirmedDate.val());
                        estimatedDateValue = new Date(val);
                        }
                        return confirmedDateValue <= estimatedDateValue;
                        }
                    </aui:validator>
                </aui:input>

            </div>
        </div>

        <!-- Additional Fields -->
        <div class="field-group row">
            <div class="col-md-4">
                <aui:input label="Project Duration" name="durationDate" id="projectDuration" type="text" readonly="true"
                           required="true"><aui:validator name="digits"
                                                          errorMessage="Project duration cannot be negative"/></aui:input>
            </div>
            <div class="col-md-4">
                <aui:input label="Project Status" name="status" value="<%=CustomWorkflowConstants.STATUS_NEW%>" required="true" type="text"
                           readOnly="readOnly">
                    <aui:validator name="required"/>
                </aui:input>
            </div>

            <c:if test="<%= updateProject %>">
                <div class="col-md-4">
                    <aui:input label="Project Code" name="code" readonly="true" type="text"/>
                </div>
            </c:if>

            <div class="col-md-4">

                <c:choose>
                    <c:when test="<%= updateProject %>">
                        <aui:input label="Project Documents" name="updateProjectDocuments" type="file" multiple="true"/>
                        <div style="display: flex">
                            <%
                                for (DLFileEntry dlFileEntry : dlFileEntrys) {
                                    if (null != dlFileEntry) {
                                        FileEntry fileEntry = DLAppServiceUtil.getFileEntry(dlFileEntry.getFileEntryId());
                                        FileVersion fileVersion = fileEntry.getFileVersion();
                                        String thumbnailSrc = DLURLHelperUtil.getThumbnailSrc(
                                                fileVersion.getFileEntry(), fileVersion, themeDisplay);
                                        String previewURL = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK, false, true);
                            %>
                            <%@ include file="/META-INF/resources/project/view_file.jspf" %>
                            <%
                                    }
                                }
                            %>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <!-- Code to execute when 'updateProject' is false -->
                        <aui:input label="Project Documents" name="projectDocuments" type="file" multiple="true"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>


        <aui:button-row>
            <aui:button type="submit" value="Submit"/>
            <aui:button type="cancel" value="Cancel" href="<%=themeDisplay.getLayoutFriendlyURL(clayout)%>"/>
        </aui:button-row>
    </aui:fieldset>

</aui:form>

<style>

    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
</style>
<script>
    Liferay.provide(
        window,
        '<portlet:namespace />processProjectInfo',
        () => {
            const form = document.getElementById('<portlet:namespace />editProjectFms');
            const spinner = document.getElementById('cover-spin');
            spinner.style.display = 'block';
            Liferay.Util.fetch('<portlet:actionURL name="/project_admin/edit_project" />', {
                body: new FormData(form),
                method: 'POST',
            })
                .then((response) => response.json())
                .then((response) => {
                    if (!response.error) {
                        document.location.href = response.redirect;
                    }
                })
                .finally(() => {
                    spinner.style.display = 'none';
                });
            // Send an AJAX request using AUI's io.request
        },
        ['aui-base', 'aui-io-request', 'io', 'liferay-notification', 'liferay-util-window']
    );


    Liferay.provide(
        window,
        'deleteFile',
        (fileEntryId) => {
            console.log(fileEntryId);
            const confirmation = confirm("Are you sure you want to delete this file?");
            if (confirmation) {
                const formData = new FormData();
                formData.append('<portlet:namespace />fileEntryId', fileEntryId);
                Liferay.Util.fetch('<portlet:actionURL name="/project_admin/deleteFile" />', {
                    body: formData,
                    method: 'POST',
                })
                    .then((response) => response.json())
                    .then((response) => {
                        if (response.success) {
                            location.reload();
                            Liferay.Util.openToast({
                                autoClose: true,
                                message: response.success,
                                toastProps: {
                                    onClose: null,
                                },
                                type: 'success'
                            });
                        }
                    })
                    .catch((error) => {
                        Liferay.Util.openToast({
                            autoClose: false,
                            message: Liferay.Language.get(
                                'an-unexpected-system-error-occurred'
                            ),
                            type: 'danger',
                        });
                    });
            }

            // Send an AJAX request using AUI's io.request
        },
        ['aui-base', 'io', 'liferay-notification', 'liferay-util-window']
    );


    AUI().ready('aui-node', function (A) {
        const projectProposedInput = A.one('#<portlet:namespace/>projectProposedDate');
        const confirmedDateInput = A.one('#<portlet:namespace/>projectConfirmedDate');
        const estimatedDateInput = A.one('#<portlet:namespace/>deliveryEstimatedDate');
        const developmentDateInput = A.one('#<portlet:namespace/>developmentStartDate');
        const durationInput = A.one('#<portlet:namespace/>projectDuration');

        confirmedDateInput.on('change', calculateDuration);
        estimatedDateInput.on('change', calculateDuration);

        function calculateDuration() {
            const confirmDate = new Date(confirmedDateInput.val());
            const estimateDate = new Date(estimatedDateInput.val());

            if (!isNaN(confirmDate.getTime()) && !isNaN((estimateDate.getTime()))) {
                const timeDiff = estimateDate.getTime() - confirmDate.getTime();
                const daysDiff = Math.ceil(timeDiff / (1000 * 3600 * 24));

                durationInput.val(daysDiff);
            }
        }


        const dateInputs = [
            {inputField: projectProposedInput, dateString: '<%= proposedDateString %>'},
            {inputField: confirmedDateInput, dateString: '<%= confirmedDateString %>'},
            {inputField: developmentDateInput, dateString: '<%= developmentDateString %>'},
            {inputField: estimatedDateInput, dateString: '<%= estimateDateString %>'},
            // Add more input fields and date strings as needed
        ];

        dateInputs.forEach(item => {
            const {inputField, dateString} = item;
            console.log("inputField:::" + inputField);
            console.log("dateString:::" + dateString);
            if (dateString) {
                convertToDate(dateString, inputField);
            }
        })

        function convertToDate(dateString, inputField) {
            const selectedDate = new Date(dateString);
            const formattedDate = selectedDate.toISOString().substring(0, 10);

            if (inputField) {
                inputField.val(formattedDate);
            }
        }


    });



</script>



