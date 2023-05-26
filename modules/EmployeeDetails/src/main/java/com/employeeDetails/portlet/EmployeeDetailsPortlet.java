package com.employeeDetails.portlet;

import com.employeeDetails.constants.EmployeeDetailsPortletKeys;
import com.intranet.model.EmployeeDetails;
import com.intranet.service.EmployeeDetailsLocalService;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author DELL
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmployeeDetails Portlet", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + EmployeeDetailsPortletKeys.employee,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class EmployeeDetailsPortlet extends MVCPortlet {

	private static Configuration configuration = ConfigurationFactoryUtil
			.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	private static String ROOT_FOLDER_NAME = configuration.get("fileupload.folder.name");
	private static String ROOT_FOLDER_DESCRIPTION = configuration.get("fileupload.folder.description");
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	@ProcessAction(name = "updateEmployee")
	public void updateEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws FileNotFoundException, PortalException {
		// TODO Auto-generated method stub

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
		SimpleDateFormat smd = new SimpleDateFormat("MM/dd/yyyy");
		Date joiningDate = ParamUtil.getDate(actionRequest, "joiningDate", smd);
		Date dob = ParamUtil.getDate(actionRequest, "dob", df);
		Date anniversaryDate = ParamUtil.getDate(actionRequest, "anniversaryDate", smd);
		boolean maritalstatus = ParamUtil.getBoolean(actionRequest, "maritalstatus");
		String domain = ParamUtil.getString(actionRequest, "domain");
		String gender = ParamUtil.getString(actionRequest, "gender");
		long contact = ParamUtil.getLong(actionRequest, "contact");
		String address = ParamUtil.getString(actionRequest, "address");
		String pannumber = ParamUtil.getString(actionRequest, "pannumber");
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String passportNumber = ParamUtil.getString(actionRequest, "passportNumber");
		String aadhar = ParamUtil.getString(actionRequest, "Aadhar");
		long educationId = ParamUtil.getLong(actionRequest, "educationId");
		String employeename = ParamUtil.getString(actionRequest, "employeename");
		String email = ParamUtil.getString(actionRequest, "email");
		long employeeID = ParamUtil.getLong(actionRequest, "employeeID");

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName("uploadedFile");
		long fileEntryId = 0;
		try {
			File file = uploadPortletRequest.getFile("uploadedFile");
			String mimeType = uploadPortletRequest.getContentType("uploadedFile");
			String title = fileName;
			String description = "This file is added via programatically";
			long repositoryId = themeDisplay.getScopeGroupId();
			Folder folder = getFolder(actionRequest, themeDisplay);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					actionRequest);
			InputStream is = new FileInputStream(file);

			FileEntry dlFileEntry;

			dlFileEntry = DLAppLocalServiceUtil.addFileEntry(description, themeDisplay.getUserId(), repositoryId,
					folder.getFolderId(), employeeID + "-" + fileName, mimeType, title, description, "", description,
					is, file.length(), anniversaryDate, anniversaryDate, serviceContext);

			System.out.println(dlFileEntry);
			fileEntryId = dlFileEntry.getFileEntryId();
			System.out.println(fileEntryId);
		} catch (PortalException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		EmployeeDetails emp;

		if (Validator.isNotNull(Long.valueOf(employeeID))) {
			System.out.println("Edit with value#######################");
			_employeeDetailsLocalService.updateEmployee(employeeID, employeename, gender, domain, contact, email,
					address, pannumber, passportNumber, aadhar, joiningDate, dob, maritalstatus, anniversaryDate,
					fileEntryId);
		} else {
			_employeeDetailsLocalService.addEmployee(employeename, gender, domain, contact, email, address, pannumber,
					passportNumber, aadhar, joiningDate, dob, maritalstatus, anniversaryDate, fileEntryId);
		}

		createNewFolder(actionRequest, themeDisplay);

		// Redirect page

		/* actionResponse.setRenderParameter("jspPage", "/display.jsp"); */
		actionRequest.setAttribute("employeeTabs", EmployeeDetailsPortletKeys.VIEW_EMPLOYEE_DETAILS);

	}

	public Folder createNewFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay)

	{
		boolean folderExist = isFolderExist(themeDisplay);
		Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
						actionRequest);
				folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), repositoryId, PARENT_FOLDER_ID,
						ROOT_FOLDER_NAME, ROOT_FOLDER_DESCRIPTION, serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		}
		return folder;
	}

	public boolean isFolderExist(ThemeDisplay themeDisplay) {
		boolean folderExist = false;
		try {
			DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
			folderExist = true;
			System.out.println("Folder is already Exist");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return folderExist;
	}

	public Folder getFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		Folder folder = null;
		try {

			folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID,
					ROOT_FOLDER_NAME);
		} catch (Exception e) {
			createNewFolder(actionRequest, themeDisplay);
			System.out.println(e.getMessage());
		}
		return folder;
	}

	public Map<String, String> getAllFileLink(ThemeDisplay themeDisplay) {
		Map<String, String> urlMap = new HashMap<String, String>();// key = file
																	// name
																	// ,value =
																	// url
		long repositoryId = themeDisplay.getScopeGroupId();
		try {
			Folder folder = getFolder(null, themeDisplay);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry file : fileEntries) {
				String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
						+ themeDisplay.getScopeGroupId() + "/" + file.getFolderId() + "/" + file.getTitle();
				urlMap.put(file.getTitle().split("\\.")[0], url);// remove jpg
																	// or pdf

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return urlMap;

	}

	private EmployeeDetailsLocalService _employeeDetailsLocalService;

	// Creating Folder in Documents and Media Ends here
}