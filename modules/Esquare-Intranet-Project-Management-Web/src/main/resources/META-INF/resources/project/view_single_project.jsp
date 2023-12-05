<%@ include file="/META-INF/resources/init.jsp" %>
<%
  long projectId = ParamUtil.getLong(renderRequest, "projectId");
  Projects project = ProjectsLocalServiceUtil.getProject(projectId);
  String viewPage = ParamUtil.getString(renderRequest, "view");
  ProjectListDisplayContext projectListDisplayContextdddd = (ProjectListDisplayContext) request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
  UnicodeProperties resourceIdSettings = new UnicodeProperties();
  resourceIdSettings.fastLoad(project.getResourceIdSettings());
  List<DLFileEntry>  dlFileEntrys = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), project.getDocumentId());

    List<Date> dateList = new ArrayList<>();
    dateList.add(project.getConfirmedDate());
    dateList.add(project.getEstimatedDate());
    dateList.add(project.getProposedDate());
    dateList.add(project.getDevelopmentStartDate());

  SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy/dd/MM");

  String proposedDateString = dateList.stream()
          .map(date -> outputDateFormat.format(date))
          .findFirst()
          .orElse(StringPool.BLANK);
  String confirmedDateString = dateList.stream()
          .skip(1)
          .map(date -> outputDateFormat.format(date))
          .findFirst()
          .orElse(StringPool.BLANK);
  String developmentDateString = dateList.stream()
          .skip(2)
          .map(date -> outputDateFormat.format(date))
          .findFirst()
          .orElse(StringPool.BLANK);
  String estimateDateString = dateList.stream()
          .skip(3)
          .map(date -> outputDateFormat.format(date))
          .findFirst()
          .orElse(StringPool.BLANK);

%>

<div class="sheet">
  <div class="sheet-header">
    <h4 class="sheet-title"><%=project.getProjectName()%> Information</h4>
  </div>
  <div class="panel-group panel-group-flush">
    <!-- Client Panel -->
    <div class="panel panel-unstyled">
      <button class="btn btn-unstyled panel-header panel-header-link" onclick="togglePanel('collapseSheetPanelOne')">
        <span class="panel-title">Client</span>
        <span class="custom-icon">
          <i class="fas fa-plus-circle"></i>
        </span>
      </button>
      <div class="panel-collapse collapse" id="collapseSheetPanelOne">
        <div class="panel-body">
          <div class="row">
            <div class="column" >
              <h2>Client Name:</h2>
              <p><%=project.getName()%></p>
            </div>
            <div class="column" >
              <h2>Contact Number:</h2>
              <p><%=project.getContactNumber()%></p>
            </div>
            <div class="column" >
              <h2>Email Address:</h2>
              <p><%=project.getContactEmail()%></p>
            </div>
          </div>

        </div>
      </div>
    </div>

    <!-- Project Panel-->
    <div class="panel panel-unstyled">
      <button class="btn btn-unstyled panel-header panel-header-link" onclick="togglePanel('collapseSheetPanelTwo')">
        <span class="panel-title">Project</span>
        <span class="custom-icon">
          <i class="fas fa-plus-circle"></i>
        </span>
      </button>
      <div class="panel-collapse collapse" id="collapseSheetPanelTwo">
        <div class="panel-body">
          <div class="row">
            <div class="column">
              <h2>Project Name:</h2>
              <p><%=project.getName()%></p>
            </div>
            <div class="column">
              <h2>Project Description:</h2>
              <p><%=project.getDescription()%></p>
            </div>
            <div class="column">
              <h2>Project Code:</h2>
              <p><%=project.getCode()%></p>
            </div>
          </div>
          <div class="row">
            <div class="column">
              <h2>Project Status:</h2>
              <p><%=project.getStatus()%></p>
            </div>
            <div class="column">
              <h2>Project Duration:</h2>
              <p><%=project.getDurationDate()%> days</p>
            </div>
            <div class="column">
              <h2>Proposed Date:</h2>
              <p><%=proposedDateString%></p>
            </div>
          </div>
          <div class="row">
            <div class="column">
              <h2>Confirmed Date:</h2>
              <p><%=confirmedDateString%></p>
            </div>
            <div class="column">
              <h2>Development Start Date:</h2>
              <p><%=developmentDateString%></p>
            </div>
            <div class="column">
              <h2>Estimated Date:</h2>
              <p><%=estimateDateString%></p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Resource Panel-->
    <div class="panel panel-unstyled">
      <button class="btn btn-unstyled panel-header panel-header-link" onclick="togglePanel('collapseSheetPanelThree')">
        <span class="panel-title">Resources</span>
        <span class="custom-icon">
          <i class="fas fa-plus-circle"></i>
        </span>
      </button>
      <div class="panel-collapse collapse" id="collapseSheetPanelThree">
        <div class="panel-body">
          <div class="row">
            <div class="column">
              <h2>Project Manager</h2>
              <p><%=projectListDisplayContextdddd.getMemberNameByUserId(resourceIdSettings.get(ProjectConstant.PROJECT_MANAGER_ID))%></p>
            </div>
            <div class="column">
              <h2>Delivery Lead</h2>
              <p><%=projectListDisplayContextdddd.getMemberNameByUserId(resourceIdSettings.get(ProjectConstant.DELIVERY_LEAD_ID))%></p>
            </div>
            <div class="column">
              <h2>Operational Lead</h2>
              <p><%=projectListDisplayContextdddd.getMemberNameByUserId(resourceIdSettings.get(ProjectConstant.OPERATION_LEAD_ID))%></p>
            </div>
            <div class="column">
              <h2>Project QA Lead</h2>
              <p><%=projectListDisplayContextdddd.getMemberNameByUserId(resourceIdSettings.get(ProjectConstant.PROJECT_QA_LEAD_ID))%></p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Attachment Panel-->
    <div class="panel panel-unstyled">
      <button class="btn btn-unstyled panel-header panel-header-link" onclick="togglePanel('collapseSheetPanelFour')">
        <span class="panel-title">Attachment</span>
        <span class="custom-icon">
          <i class="fas fa-plus-circle"></i>
        </span>
      </button>
      <div class="panel-collapse collapse" id="collapseSheetPanelFour">
        <div class="panel-body">
          <div style="display: flex">
            <%
              for (DLFileEntry dlFileEntry : dlFileEntrys) {
                if (null != dlFileEntry) {
                  FileEntry fileEntry = DLAppServiceUtil.getFileEntry(dlFileEntry.getFileEntryId());
                  FileVersion fileVersion =  fileEntry.getFileVersion();
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
        </div>
      </div>
    </div>
  </div>
</div>

<script>

  function togglePanel(panelId) {
    const panel = document.getElementById(panelId);
    const button = document.querySelector(`[aria-controls="${panelId}"] .custom-icon i`);

    if (panel) {
      if (panel.classList.contains('collapse')) {
        panel.classList.remove('collapse');
        button.classList.remove('fa-plus-circle');
        button.classList.add('fa-minus-circle');
      } else {
        panel.classList.add('collapse');
        button.classList.remove('fa-minus-circle');
        button.classList.add('fa-plus-circle');
      }
    }
  }

</script>



<style>
  .row {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 10px 0;
  }

  .column {
    flex: 1;
    padding: 20px;
    text-align: center;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    background-color: #f8f8f8;
    margin: 10px;
  }

  h2 {
    font-size: 1.5em;
    color: #333;
  }

  p {
    font-size: 1em;
    color: #666;
  }

  /* Add hover effect for columns */
  .column:hover {
    background-color: #e8e8e8;
    transform: translateY(-5px);
    transition: background-color 0.3s, transform 0.3s;
  }

  /* Media query for smaller screens */
  @media (max-width: 768px) {
    .row {
      flex-direction: column;
    }
  }

</style>

