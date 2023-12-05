//package Testing.portlet.asset;
//
//import com.liferay.asset.kernel.model.BaseAssetRenderer;
//import com.liferay.object.model.ObjectEntry;
//import com.liferay.petra.string.StringPool;
//
//import java.io.Serializable;
//import java.util.Locale;
//import java.util.Map;
//
//import javax.portlet.PortletRequest;
//import javax.portlet.PortletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class CommentsEntryAssetRenderer extends BaseAssetRenderer<ObjectEntry> {
//	public CommentsEntryAssetRenderer(ObjectEntry obectEntry) {
//		_obectEntry = obectEntry;
//	}
//
//	@Override
//	public ObjectEntry getAssetObject() {
//		// TODO Auto-generated method stub
//		return _obectEntry;
//	}
//
//	@Override
//	public long getGroupId() {
//		// TODO Auto-generated method stub
//		return _obectEntry.getGroupId();
//	}
//
//	@Override
//	public long getUserId() {
//		// TODO Auto-generated method stub
//		return _obectEntry.getUserId();
//	}
//
//	@Override
//	public String getUserName() {
//		// TODO Auto-generated method stub
//		return _obectEntry.getUserName();
//	}
//
//	@Override
//	public String getUuid() {
//		// TODO Auto-generated method stub
//		return _obectEntry.getUuid();
//	}
//
//	@Override
//	public String getClassName() {
//		// TODO Auto-generated method stub
//		return _obectEntry.getModelClassName();
//	}
//
//	@Override
//	public long getClassPK() {
//		// TODO Auto-generated method stub
//		return _obectEntry.getObjectEntryId();
//	}
//	
//	public String getJspPath(
//		HttpServletRequest httpServletRequest, String template) {
//
//		if (template.equals(TEMPLATE_ABSTRACT) ||
//			template.equals(TEMPLATE_FULL_CONTENT)) {
//
//			return "/view.jsp";
//		}
//
//		return null;
//	}
//
//	@Override
//	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
//		// TODO Auto-generated method stub
//
//		return StringPool.BLANK;
//	}
//
//	@Override
//	public String getTitle(Locale locale) {
//		// TODO Auto-generated method stub
//		return "Custom" + getMessage();
//	}
//
//	@Override
//	public boolean include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//			String template) throws Exception {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	private String getMessage() {
//		Map<String, Serializable> entryMap = _obectEntry.getValues();
//		String message = (String) entryMap.get("message");
//		return message;
//	}
//
//	private final ObjectEntry _obectEntry;
//}
