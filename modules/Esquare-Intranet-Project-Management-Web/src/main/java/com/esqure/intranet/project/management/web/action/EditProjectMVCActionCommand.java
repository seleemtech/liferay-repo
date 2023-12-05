package com.esqure.intranet.project.management.web.action;

import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.ProjectsLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Mahammed Seleem
 * @Description This class is used for getting values from the form, and passing to service layer.
 * @Creation_Date 29/8/2023
 * @Version : 2
 * @module :
 */
@Component(
        property = {
                "javax.portlet.name=" + ProjectConstant.PROJECT_MANAGEMENT_PORTLET,
                "mvc.command.name=/project_admin/edit_project"
        },
        service = MVCActionCommand.class
)
public class EditProjectMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Layout layout = themeDisplay.getLayout();


        try {
            createProject(actionRequest, themeDisplay);
        } catch (Exception exception) {
            if (_log.isDebugEnabled()) {
                _log.debug(exception);
            }
        }

        JSONObject response = _jsonFactory.createJSONObject();
        SessionMessages.add(actionRequest, "project-created-successfully");
        response.put(
                "redirect",
                themeDisplay.getPortalURL() + themeDisplay.getLayoutFriendlyURL(layout));
        JSONPortletResponseUtil.writeJSON(actionRequest, actionResponse, response);


    }


    private void createProject(ActionRequest actionRequest, ThemeDisplay themeDisplay) throws Exception {

        /** Project Fields */
        long projectId = ParamUtil.getLong(actionRequest, "projectId");
        String projectName = ParamUtil.getString(actionRequest, "projectName");
        String projectDescription = ParamUtil.getString(actionRequest, "description");
        Date projectProposedDate = _convertToDate(ParamUtil.getString(actionRequest, "proposedDate"));
        Date projectConfirmedDate = _convertToDate(ParamUtil.getString(actionRequest, "confirmedDate"));
        Date projectStartDate = _convertToDate(ParamUtil.getString(actionRequest, "developmentStartDate"));
        Date deliveryEstimatedDate = _convertToDate(ParamUtil.getString(actionRequest, "estimatedDate"));

        String projectDuration = ParamUtil.getString(actionRequest, "durationDate");
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Projects.class.getName(), actionRequest);
        int projectStatus = ParamUtil.getInteger(actionRequest, "status");
        String clientName = ParamUtil.getString(actionRequest, "name");
        String clientContactPhone = ParamUtil.getString(actionRequest, "contactNumber");
        String clientContactEmail = ParamUtil.getString(actionRequest, "contactEmail");
        long folderId = getFolderId(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), projectName, serviceContext);
        _addFileEntry(actionRequest, folderId, themeDisplay, projectId);
        int projectCode = getProjectCode(ParamUtil.getString(actionRequest, "code"));
        _projectLocalService.editProject(projectId, projectName, projectDescription, projectProposedDate, projectConfirmedDate, projectStartDate, deliveryEstimatedDate, projectDuration, projectStatus, projectCode, folderId, clientName, clientContactPhone, clientContactEmail, serviceContext);
    }

    private int getProjectCode(String projectCode) {
        if (Validator.isNotNull(projectCode)) {
            return Integer.parseInt(projectCode);
        }
        return (int) _counterLocalService.increment();
    }

    private Date _convertToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void _addFileEntry(
            ActionRequest actionRequest, long folderId, ThemeDisplay themeDisplay, long projectId)

            throws PortalException, IOException {
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        /** Get the uploaded files and their names  */

        File[] fileEntries;
        String[] fileNames;

        if (projectId <= 0) {
            fileEntries = uploadPortletRequest.getFiles("projectDocuments");
            fileNames = uploadPortletRequest.getFileNames("projectDocuments");
        } else {
            fileEntries = uploadPortletRequest.getFiles("updateProjectDocuments");
            fileNames = uploadPortletRequest.getFileNames("updateProjectDocuments");
        }

        if (fileEntries != null && fileNames != null && fileEntries.length > 0 && !fileNames[0].isEmpty()) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                    DLFileEntry.class.getName(), actionRequest);

            for (int i = 0; i < fileEntries.length; i++) {
                File fileItem = fileEntries[i];
                String fileName = fileNames[i];

                try {
                    byte[] fileData;
                    try (InputStream inputStream = new FileInputStream(fileItem)) {
                        /** Read the data from the InputStream into a byte array */
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            baos.write(buffer, 0, bytesRead);
                        }
                        fileData = baos.toByteArray();
                    }

                    /** Create a new InputStream from the byte array */
                    try (InputStream newInputStream = new ByteArrayInputStream(fileData)) {
                        _dlAppService.addFileEntry(
                                StringPool.BLANK, themeDisplay.getScopeGroupId(), folderId, fileName,
                                uploadPortletRequest.getContentType(fileName), fileName,
                                StringPool.BLANK, StringPool.BLANK,
                                StringPool.BLANK, newInputStream, fileData.length, null, new Date(),
                                serviceContext);
                    }
                } catch (IOException e) {
                    if (_log.isDebugEnabled()) {
                        _log.debug(e);
                    }
                }
            }
        }


    }

    protected long getFolderId(
            long userId, long groupId, String ProjectName, ServiceContext serviceContext)
            throws Exception {

        DLFolder dlFolder = _dlFolderLocalService.fetchFolder(
                groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, ProjectName);

        if (null != dlFolder) {
            return dlFolder.getFolderId();
        }

        Folder folder = _dlAppLocalService.addFolder(
                StringPool.BLANK, userId,
                serviceContext.getScopeGroupId(),
                DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, ProjectName, StringPool.BLANK,
                serviceContext);

        return folder.getFolderId();
    }

    @Reference
    private CounterLocalService _counterLocalService;
    @Reference
    private DLAppService _dlAppService;
    @Reference
    private DLAppLocalService _dlAppLocalService;
    @Reference
    private DLFolderLocalService _dlFolderLocalService;
    @Reference
    private ProjectsLocalService _projectLocalService;

    private Log _log = LogFactoryUtil.getLog(EditProjectMVCActionCommand.class);
    @Reference
    private JSONFactory _jsonFactory;
}
