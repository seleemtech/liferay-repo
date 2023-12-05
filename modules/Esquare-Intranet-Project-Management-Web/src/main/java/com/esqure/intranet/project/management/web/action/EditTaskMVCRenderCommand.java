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

package com.esqure.intranet.project.management.web.action;

import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.esqure.intranet.project.management.web.headless.display.context.TaskListDisplayContext;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.site.configuration.MenuAccessConfiguration;
import com.liferay.site.configuration.manager.MenuAccessConfigurationManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Mahammed Seleem
 * @Description This class is used for redirect to  edit task jsp.
 * @Creation_Date 29/8/2023
 * @Version : 2
 * @module :
 */
@Component(
        property = {
                "javax.portlet.name=" + ProjectConstant.PROJECT_MANAGEMENT_PORTLET,
                "mvc.command.name=/task_admin/assign_task_to_resources"
        },
        service = MVCRenderCommand.class
)
public class EditTaskMVCRenderCommand
        implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        hideHeaderAndFooter(themeDisplay);

        renderRequest.setAttribute(
                "taskDisplayContext",
                new TaskListDisplayContext(
                        _portal.getHttpServletRequest(renderRequest), renderRequest, renderResponse));
        return "/Task/edit_task.jsp";
    }
    /**
     * @Description This method is used to hide a header and footer in react popup jsp.
     */
    private void hideHeaderAndFooter(ThemeDisplay themeDisplay) {
        Layout layout = themeDisplay.getLayout();
        UnicodeProperties typeSettingsUnicodeProperties =
                new UnicodeProperties();
        typeSettingsUnicodeProperties.fastLoad(layout.getTypeSettings());
        typeSettingsUnicodeProperties.setProperty(
                "lfr-theme:regular:show-footer", Boolean.FALSE.toString());
        typeSettingsUnicodeProperties.setProperty(
                "lfr-theme:regular:show-header", Boolean.FALSE.toString());
        layout.setTypeSettingsProperties(typeSettingsUnicodeProperties);
    }


    @Reference
    private Portal _portal;

}