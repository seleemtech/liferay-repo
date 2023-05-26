package com.job.opening.action;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;

public class Uploadfile {

	static Log LOGGER = LogFactoryUtil.getLog(Uploadfile.class);
	private static String ROOT_FOLDER_NAME = "Job";
	private static String ROOT_FOLDER_DESCRIPTION = "Job Resumes";
	private static String DESCRIPTION = "Individual Documents folder";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	@SuppressWarnings("deprecation")
	public static long uploadfileIntoMemeberFolder(String name, String fParam, ActionRequest actionRequest)
			throws PortalException, IOException {
		long fileEntryId = 0l;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName(fParam);
		String title = fileName;
		LOGGER.info("formParam::>" + fileName);
		File file = uploadPortletRequest.getFile(fParam);
		InputStream is = uploadPortletRequest.getInputStream();
		String mimeType = uploadPortletRequest.getContentType(fParam);
		String description = "Job file";
		long repositoryId = themeDisplay.getScopeGroupId();

		Folder folder = getFolder(themeDisplay, actionRequest, name);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		FileEntry existingfileEntry = null;
		FileEntry fileEntry = null;
		try {

			existingfileEntry = DLAppLocalServiceUtil.getFileEntry(repositoryId, folder.getFolderId(), fParam);

			LOGGER.info("existingfileEntry : " + existingfileEntry);

		} catch (PortalException e) {

			LOGGER.error(e.getMessage(), e);

		}

		try {

			if (Validator.isNotNull(existingfileEntry)) {

				fileEntry = DLAppServiceUtil.updateFileEntry(existingfileEntry.getFileEntryId(),
						existingfileEntry.getFileName(), mimeType, title, title, description, "",
						DLVersionNumberIncrease.MAJOR, is, existingfileEntry.getSize(), null, null, serviceContext);

			} else {

				fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), title, mimeType, title,
						description, "", file, serviceContext);

				fileEntryId = fileEntry.getFileEntryId();


			}

		} catch (PortalException e) {

			LOGGER.error(e.getMessage(), e);

		}
		fileEntryId = fileEntry.getFileEntryId();

		return fileEntryId;
	}

	public static Folder getFolder(ThemeDisplay themeDisplay, PortletRequest actionRequest, String name)
			throws PortalException {
		Folder folder = null;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
			if (Validator.isNotNull(folder)) {
				try {
					folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folder.getFolderId(), name);
				} catch (PortalException e) {
					folder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), folder.getFolderId(), name,
							DESCRIPTION, serviceContext);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
			folder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME,
					ROOT_FOLDER_DESCRIPTION, serviceContext);
			folder = DLAppServiceUtil.addFolder(themeDisplay.getScopeGroupId(), folder.getFolderId(), name, DESCRIPTION,
					serviceContext);

		}
		return folder;
	}

}
