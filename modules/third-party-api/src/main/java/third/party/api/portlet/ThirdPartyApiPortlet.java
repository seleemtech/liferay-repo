package third.party.api.portlet;

import third.party.api.constants.ThirdPartyApiPortletKeys;
import third.party.web.model.ThirdPartyAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ThirdPartyApi",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ThirdPartyApiPortletKeys.THIRDPARTYAPI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ThirdPartyApiPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		   try {
	            // Create a URL object with the API endpoint
	            URL url = new URL("http://192.168.29.92:8080/o/atozliferay/get-request");

	            // Open a connection to the API URL
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");

	            // Read the response from the API
	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String line;
	        
	            StringBuilder response = new StringBuilder();
	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }
	            reader.close();

	            // Print the JSON response
	            ObjectMapper objectMapper = new ObjectMapper();
	            List<Map<String, Object>> dataList = objectMapper.readValue(response.toString(), new TypeReference<List<Map<String, Object>>>(){});
	           
	            System.out.println("List::::::::::::::"+dataList);
	            renderRequest.setAttribute("dataList", dataList);
	            // Close the connection
	            connection.disconnect();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		// TODO Auto-generated method stub
		super.render(renderRequest, renderResponse);
	}
	
	public void deleteData(ActionRequest actionRequest, ActionResponse actionResponse) {
		// TODO Auto-generated method stub
		
		
		String apiUrl = "http://192.168.29.92:8080/o/atozliferay/delete-request/{id}"; // Replace {id} with the actual ID

        try {
            String id = ParamUtil.getString(actionRequest, "azId");
            System.out.println("id:::::"+id);// Replace with the actual ID value
            apiUrl = apiUrl.replace("{id}", id);

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response Body: " + response.toString());
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
	    
	}
	public void updateListAPi(ActionRequest actionRequest, ActionResponse actionResponse) {
		// TODO Auto-generated method stub
		
		
		ThirdPartyAPI objects=new ThirdPartyAPI();
		objects.setName(ParamUtil.getString(actionRequest, "name"));
		objects.setAge(ParamUtil.getString(actionRequest, "age"));
		objects.setMobileNumber(ParamUtil.getLong(actionRequest, "mobileNumber"));
		objects.setEmail(ParamUtil.getString(actionRequest, "email"));
		  ObjectMapper objectMapper = new ObjectMapper();

	        // Convert the data object to JSON string
		  String payload="";
	        try {
	        	payload = objectMapper.writeValueAsString(objects);
	        	System.out.println("objectMapper:::::::::::::::"+payload);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String apiUrl = "http://192.168.29.92:8080/o/atozliferay/post-request"; 
	        try {
	        	URL url = new URL(apiUrl);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("POST");
		        conn.setRequestProperty("Content-Type", "application/json");
		        conn.setDoOutput(true);

		       
		        try (OutputStream os = conn.getOutputStream()) {
		            byte[] input = payload.getBytes(StandardCharsets.UTF_8);
		            os.write(input, 0, input.length);
		        }

		      
		        int responseCode = conn.getResponseCode();

		        
System.out.println("Resonde Code:::::::::::::::::"+responseCode);
		        
		        conn.disconnect();
	        }catch (Exception e) {
				// TODO: handle exception
			}
	        
	    
	}
}