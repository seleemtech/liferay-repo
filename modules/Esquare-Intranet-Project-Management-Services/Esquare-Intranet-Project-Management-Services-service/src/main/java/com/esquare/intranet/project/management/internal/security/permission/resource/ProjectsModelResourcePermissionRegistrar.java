/*

package com.esquare.intranet.project.management.internal.security.permission.resource;

import com.esquare.intranet.project.management.constant.ProjectConstant;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.ProjectsLocalService;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.MapUtil;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import java.util.Dictionary;

@Component(immediate = true)
public class ProjectsModelResourcePermissionRegistrar {

    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("model.class.name", Projects.class.getName());
        _serviceRegistration = bundleContext.registerService(
                (Class<ModelResourcePermission<Projects>>)
                        (Class<?>)ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(
                        Projects.class, Projects::getProjectId,
                        _projectsLocalService::getProjects,
                        _portletResourcePermission,
                        (modelResourcePermission, consumer) -> {
                        }),
                MapUtil.singletonDictionary(
                        "model.class.name", Projects.class.getName()));


    }

    @Deactivate
    public void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference(target = "(resource.name=" + ProjectConstant.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private  ProjectsLocalService _projectsLocalService;

    private ServiceRegistration<ModelResourcePermission<Projects>>
            _serviceRegistration;
}

*/
