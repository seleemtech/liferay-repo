package Rest.web.application;

import com.Authenticate.StudentRestAuthKey;
import com.crud.service.model.Crud;
import com.crud.service.service.CrudLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.test.rule.PortalProps;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Rest.get.model.Student;
import Rest.get.service.StudentLocalServiceUtil;

/**
 * @author DELL
 */
@Component(configurationPid = "com.Authenticate.StudentRestAuthKey", property = { "liferay.access.control.disable=true",
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest" }, service = Application.class)
public class RestWebApplication extends Application {
	private static final Logger log = LoggerFactory.getLogger(RestWebApplication.class);

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Path("/crud/{crudId}")
	@Produces("application/json")
	public List<Crud> getCrud(@PathParam("crudId") long crudId) throws Exception {
		return CrudLocalServiceUtil.getByCrudId(crudId);
	}

	/*
	 * @GET
	 * 
	 * @Produces("text/plain") public String working() { return "It works!"; }
	 */

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(@PathParam("name") String name, @QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}

	@GET
	@Path("/token")
	@Produces("application/json")
	public Response gettoken(@Context HttpServletRequest request) {

		// Get request headers
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		log.info("nafath : " + httpRequest);

		// Fetch authorization header
		final Enumeration<String> headerNames = httpRequest.getHeaders("Authorization");
		log.info("nafath : " + headerNames);

		String authorization = null;
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				authorization = headerNames.nextElement();
				// If no authorization information present; block access
				if (authorization == null || authorization.isEmpty()) {
					return Response.status(Response.Status.FORBIDDEN).build();
				}
			}
		}

		log.info("authorization hearder:: " + authorization);
		log.info("authorization from properties:: " + _configuration.getAuthenticationKey());

		if (authorization.split(" ")[1].equalsIgnoreCase(_configuration.getAuthenticationKey())) {

			return Response.status(Response.Status.OK).entity(authorization).build();
		} else {

			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}

	@POST
	@Path("/addCrud")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCrud(NewCrud newCruds) {
		JSONObject entity = JSONFactoryUtil.createJSONObject();
		try {

			Crud crd = CrudLocalServiceUtil.createCrud(newCruds.crudId);
			crd.setCrudName(newCruds.getCrudName());
			crd.setCrudNo(newCruds.getCrudNo());
			CrudLocalServiceUtil.addCrud(crd);
			entity.put("message", "Request successfully completed");

			return Response.status(Response.Status.OK).entity(entity.toString()).build();
		} catch (Exception e) {
			// TODO: handle exception
			entity.put("message", e.getMessage());

		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(entity.toString()).build();

	}

	@PUT
	@Path("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateRequestStatus(NewCrud newCruds) {

		JSONObject entity = JSONFactoryUtil.createJSONObject();
		try {
			Crud crd = CrudLocalServiceUtil.fetchCrud(newCruds.crudId);
			crd.setCrudName(newCruds.getCrudName());
			crd.setCrudNo(newCruds.getCrudNo());
			CrudLocalServiceUtil.updateCrud(crd);

			entity.put("message", "Request successfully completed");
			return Response.status(Response.Status.OK).entity(entity.toString()).build();

		} catch (Exception e) {
			entity.put("message", e.getMessage());

		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(entity.toString()).build();
	}
	
	@DELETE
	@Path("/delete/{crudId}")
	public Response deleteRecord(@PathParam("crudId") long crudId) {
		JSONObject entity = JSONFactoryUtil.createJSONObject();
	    try {
	        // Perform delete operation
	    	 CrudLocalServiceUtil.deleteCrud(crudId);
	    	 entity.put("message", "Request successfully completed");
	    	 return Response.status(Response.Status.OK).entity(entity.toString()).build();
	    } catch (Exception e) {
	    	entity.put("message", e.getMessage());
	    }
	    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(entity.toString()).build();
	}

	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(StudentRestAuthKey.class, properties);
	}

	private volatile StudentRestAuthKey _configuration;

}