/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.instances.web.internal.portlet;

import com.liferay.portal.instances.web.internal.constants.PortalInstancesPortletKeys;
import com.liferay.portal.instances.web.internal.constants.PortalInstancesWebKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.site.initializer.SiteInitializerRegistry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author Pei-Jung Lan
 */
@Component(
        property = {
                "com.liferay.portlet.css-class-wrapper=portlet-portal-instances",
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.icon=/icons/portal_instances.png",
                "com.liferay.portlet.preferences-owned-by-group=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.struts-path=portal_instances",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=Virtual Instances custom",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.name=" + PortalInstancesPortletKeys.PORTAL_INSTANCES,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator",
                "javax.portlet.version=3.0"
        },
        service = Portlet.class
)
public class PortalInstancesPortlet extends MVCPortlet {

    @Override
    protected void doDispatch(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        System.out.println("------------>");
        renderRequest.setAttribute(
                PortalInstancesWebKeys.SITE_INITIALIZER_REGISTRY,
                _siteInitializerRegistry);

        super.doDispatch(renderRequest, renderResponse);
    }

    @Reference
    private SiteInitializerRegistry _siteInitializerRegistry;

}