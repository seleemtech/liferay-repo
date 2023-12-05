package com.comments.headless.internal.resource.v1_0.util;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.Base64;

public class FileUtil {
	private static final Log logger = LogFactoryUtil.getLog(FileUtil.class);
	public static FileEntry uploadFile(String fileName, String base64Doc,long userId,long groupId) throws PortalException {
		long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		byte[] bytes = Base64.getDecoder().decode(base64Doc);
		ServiceContext serviceContext = new ServiceContext();
		FileEntry fileEntry = null;
		try {
			fileEntry = DLAppLocalServiceUtil.getFileEntryByFileName(groupId, folderId, fileName);
			if(Validator.isNotNull(fileEntry)) {
				logger.info("::::::::::: Validator.isNotNull(fileEntry) :::::::::: check");
				fileEntry = DLAppLocalServiceUtil.updateFileEntry(fileEntry.getUserId(), fileEntry.getFileEntryId(), 
						fileEntry.getFileName(), StringPool.BLANK, fileEntry.getFileName(), StringPool.BLANK, 
						fileEntry.getDescription(), StringPool.BLANK, DLVersionNumberIncrease.MAJOR, bytes, fileEntry.getExpirationDate(), 
						fileEntry.getReviewDate(), serviceContext);
			}
		} catch (Exception e) {
			if(Validator.isNull(fileEntry)) {
				logger.info("::::::::::: Validator.isNull(fileEntry) :::::::::: check");
				fileEntry = DLAppLocalServiceUtil.addFileEntry(StringPool.BLANK, userId, groupId, folderId, 
						fileName, StringPool.BLANK, bytes, null, null, serviceContext);
			}
			logger.error("Exceptions from File Util:::::::::" +e.getMessage());
		}
		logger.info("File entry from util class before return statement ::::::::: "+fileEntry);
		return fileEntry;
	}
	private FileUtil() {
	}

}
