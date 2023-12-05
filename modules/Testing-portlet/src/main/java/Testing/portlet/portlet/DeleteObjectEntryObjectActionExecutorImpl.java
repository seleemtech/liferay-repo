package Testing.portlet.portlet;

import com.liferay.object.action.executor.ObjectActionExecutor;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.UnicodeProperties;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Trash.Employee.Service.service.TrashEmployeeDataLocalService;

@Component(service = ObjectActionExecutor.class)
public class DeleteObjectEntryObjectActionExecutorImpl implements ObjectActionExecutor {

	@Override
	public void execute(long companyId, UnicodeProperties parametersUnicodeProperties, JSONObject payloadJSONObject,
			long userId) throws Exception {
		JSONObject payloadJSONObjects = JSONFactoryUtil.createJSONObject(payloadJSONObject.toString());
		JSONObject originalObjectEntry = payloadJSONObjects.getJSONObject("originalObjectEntry");

		JSONObject valuesObject = originalObjectEntry.getJSONObject("values");
		String employeeName =  valuesObject.getString("firstName").concat(StringPool.SPACE + valuesObject.getString("lastName"));
		_trashEmployeeDataLocalService.addTrashEmployeeData(payloadJSONObjects.getLong("classPK"), employeeName, valuesObject.getString("department"), valuesObject.getLong("mobileNumber"), valuesObject.getLong("age"));
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "Delete an Object Entry";
	}

	@Reference
	private TrashEmployeeDataLocalService _trashEmployeeDataLocalService;
}
