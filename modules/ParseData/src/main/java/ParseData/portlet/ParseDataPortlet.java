package ParseData.portlet;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import ParseData.constants.ParseDataPortletKeys;

/**
 * @author DELL
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ParseData", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/test.jsp", "javax.portlet.name=" + ParseDataPortletKeys.PARSEDATA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ParseDataPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		System.out.println("came here");
		// TODO Auto-generated method stub
		long hpPartNumber = ParamUtil.getLong(resourceRequest, "hpPartNumber");
		long num1 = 123;
		long num2 = 456;
		long num3 = 789;
		System.out.println("rowIndexes" + hpPartNumber);
		String partDescription = "seleem";
		String requestQuantity = "ffff";
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		if (num1 == hpPartNumber) {
			jsonResponse.put("partDescription", "first number");
			jsonResponse.put("requestQuantity", "1");
		} else if (num2 == hpPartNumber) {
			jsonResponse.put("partDescription", "second number");
			jsonResponse.put("requestQuantity", "2");
		} else if (num3 == hpPartNumber) {
			jsonResponse.put("partDescription", "third number");
			jsonResponse.put("requestQuantity", "3");
		}

		try {
			resourceResponse.getWriter().write(jsonResponse.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	public void testRMA(ActionRequest actionRequest, ActionResponse actionResponse) {
		int rowCount = ParamUtil.getInteger(actionRequest, "rowCount");
		System.out.println(rowCount);
		for (int i = 0; i <= rowCount; i++) {
			String hpPartNumber = ParamUtil.getString(actionRequest, "hpPartNumber" + i);
			String partDescription = ParamUtil.getString(actionRequest, "partDescription" +i);
			String requestQuantity = ParamUtil.getString(actionRequest, "requestQuantity" +i);
			System.out.println("hpPartNumber::::::::::::" + hpPartNumber);
			System.out.println("hpPartNumber::::::::::::" + partDescription);
			System.out.println("hpPartNumber::::::::::::" + requestQuantity);
		}
	}

	private Log _log = LogFactoryUtil.getLog(ParseDataPortlet.class.getName());

	public void nextPage(ActionRequest request, ActionResponse response) throws Exception {
		// Get the uploaded file
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		// now read your parameters, e.g. like this:
		// long someParameter = ParamUtil.getLong(request, "someParameter");

		System.out.println("Coming inside the controller");
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		File file = uploadRequest.getFile("file");

		String folderName = "Resume Folder";

		try {
			List<DLFolder> dlFolder = DLFolderLocalServiceUtil.getCompanyFolders(companyId, -1, -1);
			for (DLFolder dlFolder2 : dlFolder) {
				System.out.println("File URL: " + dlFolder2.getName());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Set the file path as a request attribute
		String filePath = file.getAbsolutePath();
		request.setAttribute("filePath", filePath);
		System.out.println("file path" + filePath);

		// Forward to the add JSP

		response.getRenderParameters().setValue("jspPage", "/add.jsp");
	}
}