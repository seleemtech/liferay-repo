package com.student.info.sys.hook;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.ProtectedActionRequest;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "key=login.events.post" }, service = LifecycleAction.class)
public class CustomLoginAction extends Action {

	private static final Log _log = LogFactoryUtil.getLog(CustomLoginAction.class);

	@Override
	public void run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ActionException {
		// TODO Auto-generated method stub
		HttpSession ses = httpServletRequest.getSession();
		LastPath lastPath = null;
		try {
			User user = PortalUtil.getUser(httpServletRequest);
			System.out.println("Came Custom login" + user.getUserId());
			String redirectPath = null;
			if (user != null) {
				List<Role> roles = RoleLocalServiceUtil.getUserRoles(user.getUserId());
				if (!roles.isEmpty()) {
					for (Role role : roles) {
						if (role.getName().equals("Student")) {
							redirectPath = "/web/student";
						} else if (role.getName().equalsIgnoreCase("Parent")) {
							redirectPath = "/web/parent";

						} else if (role.getName().equalsIgnoreCase("Instructor")) {
							redirectPath = "/web/instructor";
						}
					}

				} else {
					redirectPath = "/c/portal/login";
				}
				if (user.getEmailAddress().startsWith("test")) {
					redirectPath = "/";

				}
			}
			lastPath = new LastPath(redirectPath, "");
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		if (Validator.isNotNull(lastPath)) {
			ses.setAttribute(WebKeys.LAST_PATH, lastPath);
		}

	}

}
