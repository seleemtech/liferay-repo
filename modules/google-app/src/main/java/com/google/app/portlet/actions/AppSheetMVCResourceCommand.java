package com.google.app.portlet.actions;


import com.google.app.Util.APIUtil;
import com.google.app.Util.JsonUtil;
import com.google.app.constants.GoogleAppPortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mashape.unirest.http.HttpResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + GoogleAppPortletKeys.GOOGLEAPP,
                "mvc.command.name=app/sheets"
        },
        service = MVCResourceCommand.class
)
public class AppSheetMVCResourceCommand extends BaseMVCResourceCommand {

    private static final String USERDETAILSURL = "https://www.googleapis.com/drive/v3/about?fields=user(displayName,emailAddress)";
    private static  final String GETSHEETURL = "https://www.googleapis.com/drive/v3/files?q=mimeType%3D%27application%2Fvnd.google-apps.spreadsheet%27";
    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        String refreshToken = ParamUtil.getString(resourceRequest, "refreshToken");

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String accessToken = APIUtil.getAccessToken(themeDisplay,refreshToken);
        HttpResponse<String> response = APIUtil.getMethod(GETSHEETURL,accessToken);
        HttpResponse<String> userDetailsResponse = APIUtil.getMethod(USERDETAILSURL,accessToken);
        String emailAddress = JsonUtil.getUserEmailAddressFromJson(userDetailsResponse.getBody());

        JSONObject jsonObject = _jsonFactory.createJSONObject();
        jsonObject.put("emailAddress",emailAddress);
        jsonObject.put("sheet", getSheetName(response.getBody()));
        jsonObject.put("refreshToken",refreshToken);
        JSONPortletResponseUtil.writeJSON(
                resourceRequest, resourceResponse, jsonObject);
    }
    private  String getSheetName(String sheet) throws JSONException {
        JSONObject jsonObject =_jsonFactory.createJSONObject(sheet);
        JSONArray jsonArray = _jsonFactory.createJSONArray();
        JSONArray filesArray =  jsonObject.getJSONArray("files");
        for(int i=0 ; i < filesArray.length() ; i++) {
            JSONObject fileObject = _jsonFactory.createJSONObject(filesArray.getJSONObject(i).toString());
            JSONObject mapObject =_jsonFactory.createJSONObject();
            mapObject.put("name", fileObject.getString("name"));
            mapObject.put("id", fileObject.getString("id"));
            jsonArray.put(mapObject);
        }
        return jsonArray.toString();
    }


    private static final Log logger = LogFactoryUtil.getLog(AppSheetMVCResourceCommand.class);
    @Reference
    private JSONFactory _jsonFactory;
}