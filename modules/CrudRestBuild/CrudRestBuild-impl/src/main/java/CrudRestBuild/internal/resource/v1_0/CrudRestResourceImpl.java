package CrudRestBuild.internal.resource.v1_0;

import CrudRestBuild.resource.v1_0.CrudRestResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author DELL
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/crud-rest.properties",
	scope = ServiceScope.PROTOTYPE, service = CrudRestResource.class
)
public class CrudRestResourceImpl extends BaseCrudRestResourceImpl {
}