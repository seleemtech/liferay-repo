package com.student.info.sys.hook;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "key=application.startup.events" }, service = LifecycleAction.class)

public class StartupAction extends SimpleAction {
	private final Log logger = LogFactoryUtil.getLog(StartupAction.class);

	private static String[] CUSTOM_ROLES = { "Student", "Parent", "Instructor" };
	private static String[] CUSTOM_USER_GROUPS = { "Department", "Standard" };
	private static final long COMPANY_ID = 20097;
	private static final long USER_ID = 20101;

	@Override

	public void run(String[] ids) throws ActionException {

		int roleType = RoleConstants.TYPE_REGULAR;
		long compaId = PortalUtil.getDefaultCompanyId();
		logger.info("Company Id created using startup events ::::::::::::::::::::: " + compaId);
		for (String role : CUSTOM_ROLES) {

			try {

				Role roleObject = RoleLocalServiceUtil.addRole(USER_ID, null, 0, role, null, null, roleType, null,
						null);

				logger.info("Custom Roles created using startup events ::::::::::::::::::::: " + roleObject.getName());

			} catch (PortalException e) {

				logger.error("Exceptions in Creating custom roles :::::::::::::::::::: " + e.getMessage());

			}

		}

		for (String ug : CUSTOM_USER_GROUPS) {

			try {
				UserGroup userGroup = UserGroupLocalServiceUtil.addUserGroup(USER_ID, compaId, ug, null, null);
				logger.info("Custom Roles created using startup events ::::::::::::::::::::: " + userGroup.getName());

			} catch (PortalException e) {

				logger.error("Exceptions in Creating custom roles :::::::::::::::::::: " + e.getMessage());

			}

		}

	}

}