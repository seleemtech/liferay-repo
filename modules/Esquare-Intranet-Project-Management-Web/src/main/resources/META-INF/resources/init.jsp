<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@
        taglib uri="http://liferay.com/tld/document-library" prefix="liferay-document-library" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@
        taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@
        taglib uri="http://liferay.com/tld/clay" prefix="clay" %>
<%@
        taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>


<%@
        taglib uri="http://liferay.com/tld/react" prefix="react" %>

<%@
        taglib uri="http://liferay.com/tld/frontend-data-set" prefix="frontend-data-set" %>
<liferay-theme:defineObjects />
<liferay-frontend:defineObjects />
<portlet:defineObjects />

<script src="https://code.jquery.com/jquery-3.7.1.slim.min.js" integrity="sha256-kmHvs0B+OpCW5GVHUNjv9rOmY0IvSIRcf7zGUDTDQM8=" crossorigin="anonymous"></script>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Layout" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.esquare.intranet.project.management.model.Projects" %>
<%@ page import="com.esquare.intranet.project.management.service.ProjectsLocalServiceUtil" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileVersion" %>
<%@ page import="com.liferay.document.library.util.DLURLHelperUtil" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.list.type.model.ListTypeEntry" %>
<%@ page import="com.liferay.list.type.service.ListTypeEntryLocalServiceUtil" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.esqure.intranet.project.management.web.headless.display.context.ProjectListDisplayContext" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.esquare.intranet.project.management.constants.ProjectConstant" %>
<%@ page import="com.esquare.intranet.project.management.service.TasksLocalServiceUtil" %>
<%@ page import="com.esquare.intranet.project.management.model.Tasks" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>
<%@ page import="com.esquare.intranet.project.management.model.TeamMembers" %>
<%@ page import="com.esqure.intranet.project.management.web.headless.display.context.TaskListDisplayContext" %>
