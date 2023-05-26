package com.student.info.sys.portlet;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutFriendlyURL;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.RandomUtil;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutFriendlyURLLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.student.info.sys.constants.StudentInfoSysPortletKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author DELL
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=StudentInfoSys", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StudentInfoSysPortletKeys.STUDENTINFOSYS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class StudentInfoSysPortlet extends MVCPortlet {
	/*
	 * public void render(RenderRequest request, RenderResponse response) throws
	 * PortletException, IOException { List<LayoutFriendlyURL>
	 * out=LayoutFriendlyURLLocalServiceUtil.getLayoutFriendlyURLs(-1, -1); for
	 * (LayoutFriendlyURL layoutFriendlyURL : out) { if
	 * ("/user-information".equals(layoutFriendlyURL.getFriendlyURL())) {
	 * System.out.println("Came heres"); // Include the "page1.jsp" file
	 * include("/META-INF/resources/view-user-list.jsp", request, response);
	 * System.out.println("URL data"+layoutFriendlyURL.getFriendlyURL());
	 * 
	 * } else if("/student-information".equals(layoutFriendlyURL.getFriendlyURL()))
	 * { // Display an error message include("/view.jsp", request, response);
	 * System.out.println("URL student"+layoutFriendlyURL.getFriendlyURL());
	 * 
	 * }
	 * 
	 * } super.render(request, response);
	 * 
	 * } protected void include(String path, RenderRequest renderRequest,
	 * RenderResponse renderResponse) throws IOException, PortletException {
	 * PortletRequestDispatcher portletRequestDispatcher =
	 * getPortletContext().getRequestDispatcher(path); System.out.println("Success"
	 * +path); if (portletRequestDispatcher == null) { System.out.println("Erroes"
	 * +path); } else { portletRequestDispatcher.include(renderRequest,
	 * renderResponse); } }
	 * 
	 */



	public void createUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		int min = 1000;
		int max = 9999;
		int passwordInt = RandomUtil.nextInt(max - min + 1) + min;
		String password = Integer.toString(passwordInt);
		System.out.println("autopassword" + password);
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String date = ParamUtil.getString(actionRequest, "birthday");
		long roleId = ParamUtil.getLong(actionRequest, "usertype");
		long groupId = ParamUtil.getLong(actionRequest, "usergroup");
		String gender = ParamUtil.getString(actionRequest, "gender");
		System.out.println("RoleIDdd::" + groupId);
		
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(User.class.getName());
		ExpandoTable expandoTable = null;
		ExpandoColumn expandoColumn = null;
		try {
			expandoTable = ExpandoTableLocalServiceUtil.getTable(themeDisplay.getCompanyId(), classNameId,
					StudentInfoSysPortletKeys.CUSTOM_USER_TABLE);
			expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(themeDisplay.getCompanyId(), classNameId,
					expandoTable.getName(), StudentInfoSysPortletKeys.CUSTOM_USER_COLUMN);

		} catch (NoSuchTableException nste) {
			try {
				ExpandoTableLocalServiceUtil.addTable(themeDisplay.getCompanyId(), classNameId, "UserCustomTable");
				ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), "UserGender",
						ExpandoColumnConstants.STRING);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PortletRequest portletRequest = (PortletRequest) actionRequest;
		try {
			CaptchaUtil.check(portletRequest);
		} catch (CaptchaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dates = dateFormat.parse(date);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dates);
			int birthdayDay = calendar.get(Calendar.DAY_OF_MONTH);
			int birthdayMonth = calendar.get(Calendar.MONTH) + 1;
			int birthdayYear = calendar.get(Calendar.YEAR);

			boolean autoPassword = false;
			boolean autoScreenName = false;
			Locale locale = Locale.getDefault();
			long prefixListTypeId = 0;
			long suffixListTypeId = 0;
			boolean male = false;
			String jobTitle = "";
			long[] userGroupIds =null;
			if(Validator.isNotNull(groupId)) {
				 userGroupIds = new long[] { groupId };
			}
			long[] groupIds = null;
			long[] organizationIds = null;
			
			long[] roleIds = { roleId };
			boolean sendEmail = false;

			ServiceContext serviceContext = new ServiceContext();
			User user = _userLocalService.addUserWithWorkflow(themeDisplay.getUserId(), companyId, autoPassword,
					password, password, autoScreenName, screenName, emailAddress, locale, firstName, null, lastName,
					prefixListTypeId, suffixListTypeId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
					groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);

			if (user != null) {
				ExpandoValueLocalServiceUtil.addValue(classNameId, expandoTable.getTableId(),
						expandoColumn.getColumnId(), user.getUserId(), gender);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String date = ParamUtil.getString(actionRequest, "birthday");
		String gender = ParamUtil.getString(actionRequest, "gender");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long companyId = PortalUtil.getDefaultCompanyId();
		Date dateString = null;
		try {
			dateString = dateFormat.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long userId = ParamUtil.getLong(actionRequest, "userId");

		User users = null;

		try {
			List<Contact> contacts = ContactLocalServiceUtil.getContacts(-1, -1);
			for (Contact filterContact : contacts) {
				if (filterContact.getClassPK() == userId) {
					Contact updatecontact = ContactLocalServiceUtil.getContact(filterContact.getContactId());
					updatecontact.setBirthday(dateString);
					ContactLocalServiceUtil.updateContact(updatecontact);
				}

			}

			users = UserLocalServiceUtil.getUser(userId);
			users.setFirstName(firstName);
			users.setLastName(lastName);
			UserLocalServiceUtil.updateUser(users);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Validator.isNotNull(users)) {
			ExpandoValue value = ExpandoValueLocalServiceUtil.getValue(companyId, User.class.getName(),
					StudentInfoSysPortletKeys.CUSTOM_USER_TABLE, StudentInfoSysPortletKeys.CUSTOM_USER_COLUMN, userId);
			System.out.println("value" + value);
			value.setData(gender);
			ExpandoValueLocalServiceUtil.updateExpandoValue(value);
		}
	}

	@Reference
	private UserLocalService _userLocalService;
}