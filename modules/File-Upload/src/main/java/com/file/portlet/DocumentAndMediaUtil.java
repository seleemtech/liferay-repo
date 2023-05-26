package com.file.portlet;

import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.Date;
import java.util.Locale;

public class DocumentAndMediaUtil {
	public static String getFormattedFileSize(long fileSize) {
		return LanguageUtil.formatStorageSize(fileSize, Locale.getDefault());
	}
	
	public static String getDownloadURL(ThemeDisplay themeDisplay,FileEntry fileEntry) {
		String downloadURL ="";
		try {
			 downloadURL = DLURLHelperUtil.getDownloadURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, String.valueOf(new Date().getTime()));
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return downloadURL;
	}

}
