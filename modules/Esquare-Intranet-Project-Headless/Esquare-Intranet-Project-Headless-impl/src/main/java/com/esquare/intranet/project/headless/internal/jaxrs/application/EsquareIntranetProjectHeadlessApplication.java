package com.esquare.intranet.project.headless.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mahammed Seleem
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/esquare/intranet/project/headless",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=EsquareIntranetProjectHeadless"
	},
	service = Application.class
)
@Generated("")
public class EsquareIntranetProjectHeadlessApplication extends Application {
}