package Testing.portlet.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class APIUtil {
	public static String apiPost(String requestBody, String apiUrl, String sessionId) {
		String response = StringPool.BLANK;
		try {

			String email = "test@liferay.com";
			String password = "1234";
			String authCredentials = email + ":" + password;

			String encodedCredentials = Base64.getEncoder().encodeToString(authCredentials.getBytes());

			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);

			connection.setRequestMethod("POST");
//			connection.setRequestProperty("Cookie", "JSESSIONID="+sessionId);
			// Set the request headers
			connection.setRequestProperty("Content-Type", "application/json");

			// Enable input/output streams
			connection.setDoOutput(true);
			connection.setDoInput(true);

			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = requestBody.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			int responseCode = connection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Process the response as before
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuilder content = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				JSONObject responseJson = JSONFactoryUtil.createJSONObject(content.toString());
				response = responseJson.toString();
				System.out.println("API request success. Response Code: " + responseCode + responseJson.toString());
			} else {
				System.out.println("API request failed. Response Code: " + responseCode);
			}

			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
