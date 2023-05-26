package com.student.info.sys.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.student.info.sys.constants.StudentInfoSysPortletKeys;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "javax.portlet.name=" + StudentInfoSysPortletKeys.STUDENTINFOSYS,
		"mvc.command.name=/checkUSer" }, service = MVCResourceCommand.class)
public class CheckUserMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Came for update email");
		String name = ParamUtil.getString(resourceRequest, "screenName");
		String email = ParamUtil.getString(resourceRequest, "emailAddress");
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		boolean userExists = checkUserExists(name);
		boolean emailExists = checkEmailExists(email);
		jsonResponse.put("exists", userExists);
		jsonResponse.put("emailExists", emailExists);
		try {
			resourceResponse.getWriter().write(jsonResponse.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private boolean checkUserExists(String name) {
		try {
			User user = UserLocalServiceUtil.getUserByScreenName(PortalUtil.getDefaultCompanyId(), name);
			return user != null;
		} catch (PortalException e) {
			return false;
		}
	}

	private boolean checkEmailExists(String email) {
		try {
			User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), email);
			return user != null;
		} catch (PortalException e) {
			return false;
		}
	}

}
