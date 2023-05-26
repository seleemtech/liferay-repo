package com.att.hr.onestop.news.publication.portlet;

import com.att.hr.onestop.services.model.NewsEntry;
import com.att.hr.onestop.services.service.NewsEntryLocalService;
import com.att.hr.onestop.services.service.NewsEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false", "com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.display-name=News Publication Portlet", "javax.portlet.name=" + NewsPortletKeys.NewsPortletName,
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.security-role-ref=power-user,user,guest" }, service = Portlet.class)
public class NewsPublicationActionPortlet extends MVCPortlet {

	public static final String TEMP_FOLDER_NAME = NewsPublicationActionPortlet.class.getName();

	public void editNewsEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
		// ThemeDisplay themeDisplay = (ThemeDisplay)
		// actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// UploadPortletRequest uploadPortletRequest =
		// PortalUtil.getUploadPortletRequest(actionRequest);
		
		// String sourceFileName =
		// uploadPortletRequest.getFileName("attachedFile");
		long newsEntryId = ParamUtil.getLong(actionRequest, "newsEntryId", 0l);
		String newsTitle = ParamUtil.getString(actionRequest, "newsTitle");
		String newsSummary = ParamUtil.getString(actionRequest, "newsSummary");
		String newsContent = ParamUtil.getString(actionRequest, "newsContent");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US);
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		Date expireDate = null;
		try {
			expireDate = df.parse(actionRequest.getParameter("expireDate") + StringPool.SPACE
					+ actionRequest.getParameter("expireDateTime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		boolean archive = ParamUtil.getBoolean(actionRequest, "archive", false);
		boolean isApproved = ParamUtil.getBoolean(actionRequest, "isApproved", false);
		boolean allowedInDashBoard = ParamUtil.getBoolean(actionRequest, "allowedInDashBoard", false);
		long newsScopeId = ParamUtil.getLong(actionRequest, "newsScope", 0);
		String ToEmail = ParamUtil.getString(actionRequest, "ToEmail");
		ServiceContext serviceContext = null;
		/*
		 * Layout layout = null; try { serviceContext =
		 * ServiceContextFactory.getInstance(NewsEntry.class.getName(),
		 * actionRequest); layout =
		 * LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(),
		 * true, newsScopeId); } catch (PortalException e) {
		 * e.printStackTrace(); }
		 */
	
		try {
			/*
			 * String pillarFolderName = layout.getName(Locale.US); Folder
			 * pillarDLFolder = getPillarDLFolder(actionRequest,
			 * pillarFolderName, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
			 * Folder pillarNewsFolder = getPillarDLFolder(actionRequest,
			 * pillarFolderName + StringPool.SPACE + "News Image Folder",
			 * pillarDLFolder.getFolderId()); File file =
			 * uploadPortletRequest.getFile("attachedFile"); String mimeType =
			 * uploadPortletRequest.getContentType("attachedFile");
			 * 
			 * FileEntry fileEntry = null;
			 * 
			 * try { if (newsEntryId > 0) { newsEntry =
			 * NewsEntryLocalServiceUtil.getNewsEntry(newsEntryId); if
			 * (Validator.isNotNull(sourceFileName)) { fileEntry =
			 * DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),
			 * pillarNewsFolder.getFolderId(), sourceFileName, mimeType,
			 * sourceFileName + StringPool.UNDERLINE + new Date().getTime(),
			 * sourceFileName, null, file, serviceContext);
			 * 
			 * DLAppServiceUtil.deleteFileEntry(newsEntry.getNewsImageId()); }
			 * else { fileEntry =
			 * DLAppServiceUtil.getFileEntry(newsEntry.getNewsImageId()); } }
			 * else if (newsEntryId == 0) { fileEntry =
			 * DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(),
			 * pillarNewsFolder.getFolderId(), sourceFileName, mimeType,
			 * sourceFileName + StringPool.UNDERLINE + new Date().getTime(),
			 * sourceFileName, null, file, serviceContext); }
			 */
			serviceContext = ServiceContextFactory.getInstance(NewsEntry.class.getName(), actionRequest);
			NewsEntryLocalServiceUtil.updateNewsEntry(newsEntryId, newsTitle, newsSummary, newsContent, 0,
					newsScopeId, expireDate, archive, isApproved, allowedInDashBoard, ToEmail, serviceContext);
			if (newsEntryId > 0) {
				actionResponse.setRenderParameter("newsEntryId", String.valueOf(newsEntryId));
				actionResponse.setRenderParameter("mvcPath", "/editNewsEntry.jsp");
				actionResponse.setRenderParameter("redirect", redirect);
			} else {
				if (Validator.isNotNull(redirect))
					actionResponse.sendRedirect(redirect);
			}
		} catch (SystemException | PortalException e) {
			e.printStackTrace();
		}
	}

	public void groupAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		long[] newsEntryIds = StringUtil.split(ParamUtil.getString(actionRequest, "newsEntryIds"), 0L);
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String tabs1 = ParamUtil.getString(actionRequest, "tabs1");
		if (cmd.equalsIgnoreCase(Constants.DELETE)) {
			try {
				for (long newsEntryId : newsEntryIds) {

					NewsEntryLocalServiceUtil.deleteNewsEntryById(newsEntryId);
					// DLAppServiceUtil.deleteFileEntry(newsEntry.getNewsImageId());
				}
			} catch (PortalException e) {
				e.printStackTrace();
			}
		} else if (cmd.equalsIgnoreCase(Constants.PUBLISH_TO_LIVE)) {
			ServiceContext serviceContext = null;
			try {
				serviceContext = ServiceContextFactory.getInstance(NewsEntry.class.getName(), actionRequest);
				for (long newsEntryId : newsEntryIds) {

					NewsEntryLocalServiceUtil.publishToLive(newsEntryId, serviceContext);
				}
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		actionResponse.setRenderParameter("tabs1", tabs1);
	}

	public void archiveNewsEntry(ActionRequest actionRequest, ActionResponse actionResponse) {
		long newsEntryId = ParamUtil.getLong(actionRequest, "newsEntryId", 0l);
		boolean archive = ParamUtil.getBoolean(actionRequest, "archive", false);
		String tabs1 = ParamUtil.getString(actionRequest, "tabs1");
		try {
			NewsEntryLocalServiceUtil.toggleArchiveNewsEntry(newsEntryId, archive);
		} catch (SystemException | PortalException e) {
			e.printStackTrace();
		}
		actionResponse.setRenderParameter("tabs1", tabs1);
	}

	/*
	 * private Folder getPillarDLFolder(PortletRequest portletRequest, String
	 * folderName, long parentFolderId) { Folder folder = null; ThemeDisplay
	 * themeDisplay = (ThemeDisplay)
	 * portletRequest.getAttribute(WebKeys.THEME_DISPLAY); try { folder =
	 * DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
	 * parentFolderId, folderName); } catch (PortalException e) { if (e
	 * instanceof NoSuchFolderException) { ServiceContext serviceContext; try {
	 * serviceContext =
	 * ServiceContextFactory.getInstance(DLAppService.class.getName(),
	 * portletRequest); folder =
	 * DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(),
	 * themeDisplay.getScopeGroupId(), parentFolderId, folderName, folderName,
	 * serviceContext); } catch (PortalException e1) {
	 * _log.debug(e.getMessage()); }
	 * 
	 * } else { _log.debug(e.getMessage()); } } return folder; }
	 */

	Log _log = LogFactoryUtil.getLog(NewsPublicationActionPortlet.class.getName());


}