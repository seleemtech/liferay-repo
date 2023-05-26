package com.dynamic.mapping.form.web.portlet;

import com.dynamic.data.mapping.form.web.internal.display.context.DDMFormAdminDisplayContext;
import com.dynamic.data.mapping.form.web.internal.display.context.DDMFormAdminFieldSetDisplayContext;
import com.dynamic.mapping.form.web.constants.DynamicDataMappingWebPortletKeys;
import com.liferay.dynamic.data.mapping.form.builder.context.DDMFormBuilderContextFactory;
import com.liferay.dynamic.data.mapping.form.builder.context.DDMFormContextDeserializer;
import com.liferay.dynamic.data.mapping.form.builder.settings.DDMFormBuilderSettingsRetriever;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeServicesTracker;
import com.liferay.dynamic.data.mapping.form.renderer.DDMFormRenderer;
import com.liferay.dynamic.data.mapping.form.renderer.DDMFormTemplateContextFactory;
import com.liferay.dynamic.data.mapping.form.values.factory.DDMFormValuesFactory;

import com.liferay.dynamic.data.mapping.io.DDMFormFieldTypesSerializer;
import com.liferay.dynamic.data.mapping.io.exporter.DDMFormInstanceRecordWriterTracker;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalService;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalService;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceService;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceVersionLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureService;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterTracker;
import com.liferay.dynamic.data.mapping.util.DDMFormValuesMerger;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Release;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.rms.dynamic.data.mapping.form.web.internal.configuration.activator.DDMFormWebConfigurationActivator;
import com.rms.dynamic.data.mapping.form.web.internal.instance.lifecycle.AddDefaultSharedFormLayoutPortalInstanceLifecycleListener;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Mahammed Seleem
 */
@Component(
	immediate = true,
	property = {
			
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DynamicDataMappingWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/admin/edit_form_instance.jsp",
		"javax.portlet.name=" + DynamicDataMappingWebPortletKeys.DYNAMICDATAMAPPINGWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DynamicDataMappingWebPortlet extends MVCPortlet {
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		try {
			setRenderRequestAttributes(renderRequest, renderResponse);
		}
		catch (Exception exception) {
			if (isSessionErrorException(exception)) {
				if (_log.isWarnEnabled()) {
					_log.warn(exception);
				}

				SessionErrors.add(renderRequest, exception.getClass());
			}
			else {
				_log.error(exception);

				throw new PortletException(exception);
			}
		}

		hideDefaultErrorMessage(renderRequest);

		super.render(renderRequest, renderResponse);
	}

	@Override
	protected boolean isSessionErrorException(Throwable throwable) {
		if ((throwable instanceof SystemException) ||
			super.isSessionErrorException(throwable)) {

			return true;
		}

		return false;
	}


	protected void setRelease(Release release) {
	}

	protected void setRenderRequestAttributes(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortalException {

		String currentTab = ParamUtil.getString(
			renderRequest, "currentTab", "forms");

		if (currentTab.equals("element-set")) {
			renderRequest.setAttribute(
				WebKeys.PORTLET_DISPLAY_CONTEXT,
				new DDMFormAdminFieldSetDisplayContext(
					renderRequest, renderResponse,
					_addDefaultSharedFormLayoutPortalInstanceLifecycleListener,
					_ddmFormBuilderContextFactory,
					_ddmFormBuilderSettingsRetriever,
					_ddmFormContextToDDMFormValues,
					_ddmFormFieldTypeServicesTracker,
					_ddmFormFieldTypesSerializer, _ddmFormInstanceLocalService,
					_ddmFormInstanceRecordLocalService,
					_ddmFormInstanceRecordWriterTracker,
					_ddmFormInstanceService,
					_ddmFormInstanceVersionLocalService, _ddmFormRenderer,
					_ddmFormTemplateContextFactory, _ddmFormValuesFactory,
					_ddmFormValuesMerger,
					_ddmFormWebConfigurationActivator.
						getDDMFormWebConfiguration(),
					_ddmStorageAdapterTracker, _ddmStructureLocalService,
					_ddmStructureService, _jsonFactory, _npmResolver,
					_objectDefinitionLocalService, _portal));
		}
		else {
			renderRequest.setAttribute(
				WebKeys.PORTLET_DISPLAY_CONTEXT,
				new DDMFormAdminDisplayContext(
					renderRequest, renderResponse,
					_addDefaultSharedFormLayoutPortalInstanceLifecycleListener,
					_ddmFormBuilderContextFactory,
					_ddmFormBuilderSettingsRetriever,
					_ddmFormContextToDDMFormValues,
					_ddmFormFieldTypeServicesTracker,
					_ddmFormFieldTypesSerializer, _ddmFormInstanceLocalService,
					_ddmFormInstanceRecordLocalService,
					_ddmFormInstanceRecordWriterTracker,
					_ddmFormInstanceService,
					_ddmFormInstanceVersionLocalService, _ddmFormRenderer,
					_ddmFormTemplateContextFactory, _ddmFormValuesFactory,
					_ddmFormValuesMerger,
					_ddmFormWebConfigurationActivator.
						getDDMFormWebConfiguration(),
					_ddmStorageAdapterTracker, _ddmStructureLocalService,
					_ddmStructureService, _jsonFactory, _npmResolver,
					_objectDefinitionLocalService, _portal));
		}
	}

	protected void unsetDDMFormWebConfigurationActivator(
		DDMFormWebConfigurationActivator ddmFormWebConfigurationActivator) {

		_ddmFormWebConfigurationActivator = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
			DynamicDataMappingWebPortlet.class);

	@Reference
	private AddDefaultSharedFormLayoutPortalInstanceLifecycleListener
		_addDefaultSharedFormLayoutPortalInstanceLifecycleListener;

	@Reference
	private DDMFormBuilderContextFactory _ddmFormBuilderContextFactory;

	@Reference
	private DDMFormBuilderSettingsRetriever _ddmFormBuilderSettingsRetriever;

	@Reference(
		target = "(dynamic.data.mapping.form.builder.context.deserializer.type=formValues)"
	)
	private DDMFormContextDeserializer<DDMFormValues>
		_ddmFormContextToDDMFormValues;

	@Reference
	private DDMFormFieldTypeServicesTracker _ddmFormFieldTypeServicesTracker;

	@Reference(target = "(ddm.form.field.types.serializer.type=json)")
	private DDMFormFieldTypesSerializer _ddmFormFieldTypesSerializer;

	@Reference
	private DDMFormInstanceLocalService _ddmFormInstanceLocalService;

	@Reference
	private DDMFormInstanceRecordLocalService
		_ddmFormInstanceRecordLocalService;

	@Reference
	private DDMFormInstanceRecordWriterTracker
		_ddmFormInstanceRecordWriterTracker;

	@Reference
	private DDMFormInstanceService _ddmFormInstanceService;

	@Reference
	private DDMFormInstanceVersionLocalService
		_ddmFormInstanceVersionLocalService;

	@Reference
	private DDMFormRenderer _ddmFormRenderer;

	@Reference
	private DDMFormTemplateContextFactory _ddmFormTemplateContextFactory;

	@Reference
	private DDMFormValuesFactory _ddmFormValuesFactory;

	@Reference
	private DDMFormValuesMerger _ddmFormValuesMerger;

	@Reference(
		cardinality = ReferenceCardinality.OPTIONAL,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		unbind = "unsetDDMFormWebConfigurationActivator"
	)
	private volatile DDMFormWebConfigurationActivator
		_ddmFormWebConfigurationActivator;

	@Reference
	private DDMStorageAdapterTracker _ddmStorageAdapterTracker;

	@Reference
	private DDMStructureLocalService _ddmStructureLocalService;

	@Reference
	private DDMStructureService _ddmStructureService;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private NPMResolver _npmResolver;

	@Reference
	private ObjectDefinitionLocalService _objectDefinitionLocalService;

	@Reference
	private Portal _portal;

}