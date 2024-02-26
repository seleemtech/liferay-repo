package com.google.app.portlet;


import com.google.app.constants.GoogleAppPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;


/**
 * @author Vinoth-kumar
 */
@Component(immediate = true, property = {"com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
        "javax.portlet.display-name=GoogleApp", "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + GoogleAppPortletKeys.GOOGLEAPP,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"}, service = Portlet.class)
public class GoogleAppPortlet extends MVCPortlet {
}