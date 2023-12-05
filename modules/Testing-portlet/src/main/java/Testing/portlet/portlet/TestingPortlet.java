package Testing.portlet.portlet;

import Testing.portlet.constants.TestingPortletKeys;
import Testing.portlet.display.context.CustomWorkflowTaskDisplayContext;

import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.scope.ObjectScopeProvider;
import com.liferay.object.scope.ObjectScopeProviderRegistry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author E2Software-011
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Testing", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + TestingPortletKeys.TESTING,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TestingPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			ObjectDefinition objectDefinition =_objectDefinitionLocalService.getObjectDefinition(51325);
			ObjectScopeProvider objectScopeProvider = _objectScopeProviderRegistry
					.getObjectScopeProvider(objectDefinition.getScope());

			long id = objectScopeProvider.getGroupId(_portal.getHttpServletRequest(renderRequest));
			System.out.println("idL:::::::::::"+id);
			
		}catch (Exception e) {
			// TODO: handle exception
		}

		
		
		renderRequest.setAttribute(
				WebKeys.PORTLET_DISPLAY_CONTEXT,
				new CustomWorkflowTaskDisplayContext(
					_portal.getLiferayPortletRequest(renderRequest),
					_portal.getLiferayPortletResponse(renderResponse)));
		try {
			WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), 49500);
		} catch (WorkflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<UserNotificationEvent> UserNotificationEventList = UserNotificationEventLocalServiceUtil
				.getDeliveredUserNotificationEvents(themeDisplay.getUserId(), _DELIVERY_TYPE, true, false, -1, -1);

		for (UserNotificationEvent userNotificationEvent : UserNotificationEventList) {
		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
		super.render(renderRequest, renderResponse);
	}
	@Reference
	private ObjectDefinitionLocalService _objectDefinitionLocalService;
	@Reference
	private ObjectScopeProviderRegistry _objectScopeProviderRegistry;

	@Reference
	private Portal _portal;

	private static final int _DELIVERY_TYPE = UserNotificationDeliveryConstants.TYPE_WEBSITE;
}