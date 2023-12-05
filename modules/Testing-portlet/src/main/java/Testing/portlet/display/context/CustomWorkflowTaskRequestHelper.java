package Testing.portlet.display.context;

import com.liferay.portal.kernel.display.context.helper.BaseRequestHelper;

import javax.servlet.http.HttpServletRequest;

public class CustomWorkflowTaskRequestHelper  extends BaseRequestHelper{
	public CustomWorkflowTaskRequestHelper(HttpServletRequest httpServletRequest) {
		super(httpServletRequest);
	}
}
