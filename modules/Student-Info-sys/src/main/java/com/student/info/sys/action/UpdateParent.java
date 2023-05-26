package com.student.info.sys.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.student.info.service.model.Parent;
import com.student.info.service.service.ParentLocalServiceUtil;
import com.student.info.sys.constants.StudentInfoSysPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
@Component(immediate = true, property = { "javax.portlet.name=" + StudentInfoSysPortletKeys.STUDENTINFOSYS,
"mvc.command.name=/updateParent" }, service = MVCActionCommand.class)
public class UpdateParent extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		long parentId=ParamUtil.getLong(actionRequest, "parentId");
		String parentName = ParamUtil.getString(actionRequest, "parentName");
		long parentContact = ParamUtil.getLong(actionRequest, "parentContact");
		Parent parent=ParentLocalServiceUtil.updateParent(parentId, parentName, parentContact);
	}

}
