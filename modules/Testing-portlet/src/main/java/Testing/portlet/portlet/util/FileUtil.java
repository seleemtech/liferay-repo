package Testing.portlet.portlet.util;

import java.io.File;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.WebKeys;
	
public class FileUtil {
    @SuppressWarnings("deprecation")
    public static FileEntry uploadFile(UploadPortletRequest uploadPortletRequest) throws PortalException {
        ThemeDisplay td = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String fileName = uploadPortletRequest.getFileName("document");
        File file = uploadPortletRequest.getFile("document");
        String mimeType = uploadPortletRequest.getContentType("document");
        String title = fileName;
        String description = fileName;
        long repositoryId = td.getScopeGroupId();
        ServiceContext servcont = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), uploadPortletRequest);
        System.out.println("Uploaded file is ::::::: "+fileName);
        FileEntry dlFileEntry = DLAppLocalServiceUtil.addFileEntry(td.getUserId(), repositoryId, 0, fileName, mimeType, title, description, "", file, servcont);
        return dlFileEntry;
    }
}