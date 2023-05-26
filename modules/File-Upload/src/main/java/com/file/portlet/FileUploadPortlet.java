package com.file.portlet;

import com.file.constants.FileUploadPortletKeys;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.petra.io.StreamUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author DELL
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FileUpload", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + FileUploadPortletKeys.FILEUPLOAD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class FileUploadPortlet extends MVCPortlet {

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getSiteGroupId();

		List<FileEntry> files = Collections.emptyList();
		try {
			Folder folder = dlAppService.getFolder(groupId, 0, "Seleem");
			files = dlAppService.getFileEntries(groupId, folder.getFolderId());
		} catch (PortalException e) {
			e.printStackTrace();
		}
		renderRequest.setAttribute("fileList", files);
		super.render(renderRequest, renderResponse);
	}

	public void uploadFile(ActionRequest request, ActionResponse response) throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(FileUploadPortlet.class.getName(),
				uploadRequest);

		this.uploadFileEntity(serviceContext, uploadRequest);

		response.setRenderParameter("mvcPath", "/view.jsp");
	}

	private void uploadFileEntity(ServiceContext serviceContext, UploadPortletRequest request)
			throws PortalException, SystemException {

		String filename = "";
		String description = "File description";

		try {

			// serviceContext.scopeGroupId is the groupId of a site
			long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

			Folder f = DLAppLocalServiceUtil.getFolder(repositoryId, 0L, "Seleem");
			long folderId = f.getFolderId();

			File file = request.getFile("file-to-upload");
			filename = request.getFileName("file-to-upload");
			String mimeType = MimeTypesUtil.getContentType(file);

			FileEntry entry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId, folderId,
					filename, mimeType, filename, description, "", file, serviceContext);

		} catch (PortalException e) {
			_log.error("An exception occured uploading file: " + e.getMessage());
			throw e;
		} catch (SystemException e) {
			_log.error("An exception occured uploading file: " + e.getMessage());
			throw e;
		}
	}
	
	public void delete(ActionRequest actionRequest,ActionResponse actionResponse) {
		long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId");
		try {
			dlAppService.deleteFileEntry(fileEntryId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static Log _log = LogFactoryUtil.getLog(FileUploadPortlet.class);

	@Reference
	private DLAppService dlAppService;

}