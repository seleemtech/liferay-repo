package com.candidate.resume.parse.action;

import java.io.File;
import java.nio.file.Files;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.candidate.web.constants.CandidateCreateWebPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.PortalUtil;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component(property = { "javax.portlet.name=" + CandidateCreateWebPortletKeys.CANDIDATECREATEWEB,
		"mvc.command.name=parseDocument" }, service = MVCActionCommand.class)

public class DocumentParseCommand extends BaseMVCActionCommand {
	private static final Log logger = LogFactoryUtil.getLog(DocumentParseCommand.class);
	@Override
	protected void doProcessAction(ActionRequest arg0, ActionResponse arg1) throws Exception {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(arg0);
		File file = uploadPortletRequest.getFile("toParse");
		byte[] bite = Files.readAllBytes(file.toPath());
		String base64String = Base64.encode(bite);
		logger.info("Base 64 of document " + base64String);
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("doc_base64", base64String);
		jsonObject.put("doc_type", "pdf");
		jsonObject.put("req_id", "myres");
		
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("application/json");
		@SuppressWarnings("deprecation")
		RequestBody body = RequestBody.create(mediaType, jsonObject.toJSONString());
		Request request = new Request.Builder()
				.url("https://ping.arya.ai/api/v1/resume-parser")
				.method("POST", body)
				.addHeader("token", "9a24aac4f3306fc4a42ee7b01a84ff1b")
				.build();
		Response response = client.newCall(request).execute();
		logger.info(response.body().string());
	}
}
