//package Testing.portlet.asset;
//
//import com.liferay.asset.kernel.model.AssetRenderer;
//import com.liferay.asset.kernel.model.AssetRendererFactory;
//import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
//import com.liferay.object.constants.ObjectPortletKeys;
//import com.liferay.object.model.ObjectDefinition;
//import com.liferay.object.model.ObjectEntry;
//import com.liferay.object.service.ObjectDefinitionLocalService;
//import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
//import com.liferay.object.service.ObjectEntryLocalService;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.util.PortalUtil;
//
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(immediate = true, service = AssetRendererFactory.class)
//public class CommentsAssetRendererFactory extends BaseAssetRendererFactory<ObjectEntry> {
//
//	public CommentsAssetRendererFactory() {
//		setClassName(getObjectDefinition().getClassName());
//		setSearchable(true);
//		setPortletId(getObjectDefinition().getPortletId());
//	}
//
//	@Override
//	public AssetRenderer<ObjectEntry> getAssetRenderer(long classPK, int type) throws PortalException {
//		// TODO Auto-generated method stub
//		CommentsEntryAssetRenderer commentsEntryAssetRenderer = new CommentsEntryAssetRenderer(
//				_objectEntryLocalService.getObjectEntry(classPK));
//		return commentsEntryAssetRenderer;
//	}
//
//	@Override
//	public String getType() {
//		// TODO Auto-generated method stub
//		return getObjectDefinition().getClassName();
//	}
//
//	public ObjectDefinition getObjectDefinition() {
//		ObjectDefinition objectDefinition = _objectDefinitionLocalService
//				.fetchObjectDefinition(PortalUtil.getDefaultCompanyId(), "C_Department");
//		return objectDefinition;
//	}
//
//	/*
//	 * @Reference(target = "(osgi.web.symbolicname=com.liferay.object.web)", unbind
//	 * = "-") public void setServletContext(ServletContext servletContext) {
//	 * _servletContext = servletContext; }
//	 */
//
//	@Reference
//	private ObjectDefinitionLocalService _objectDefinitionLocalService;
//	@Reference
//	private ObjectEntryLocalService _objectEntryLocalService;
//
//}
