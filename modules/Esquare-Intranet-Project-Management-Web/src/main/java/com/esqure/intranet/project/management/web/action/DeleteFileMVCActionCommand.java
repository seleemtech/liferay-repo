package com.esqure.intranet.project.management.web.action;

import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
/**
 * @author Mahammed Seleem
 * @Description This class is used for deleting attachment from the project.
 * @Creation_Date 29/8/2023
 * @Version : 2
 * @module :
 */
@Component(
        property = {
                "javax.portlet.name=" + ProjectConstant.PROJECT_MANAGEMENT_PORTLET,
                "mvc.command.name=/project_admin/deleteFile"
        },
        service = MVCActionCommand.class
)
public class DeleteFileMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId");
       _dlAppService.deleteFileEntry(fileEntryId);
        JSONObject response = _jsonFactory.createJSONObject();
        response.put(
                "success",
                "File Deleted SuccessFully");
        JSONPortletResponseUtil.writeJSON(actionRequest, actionResponse, response);
    }
    @Reference
    private JSONFactory _jsonFactory;
    @Reference
    private DLAppService _dlAppService;

}
