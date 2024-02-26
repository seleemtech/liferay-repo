/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.google.app.portlet.actions;


import com.google.app.constants.GoogleAppPortletKeys;import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Mahammed Seleem
 */
@Component(
        property = {
                "javax.portlet.name=" + GoogleAppPortletKeys.GOOGLEAPP,
                "mvc.command.name=get/Api/Data"
        },
        service = MVCRenderCommand.class
)
public class ViewIntegrationMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        renderRequest.setAttribute("pageName", "firstConnection");
        return "/step/first-app-credentials.jsp";
    }

}