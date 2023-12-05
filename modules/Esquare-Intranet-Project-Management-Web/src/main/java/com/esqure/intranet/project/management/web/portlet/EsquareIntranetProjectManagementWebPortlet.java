package com.esqure.intranet.project.management.web.portlet;



import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.ProjectsLocalService;
import com.esquare.intranet.project.management.service.ProjectsLocalServiceUtil;
import com.esqure.intranet.project.management.web.headless.display.context.ProjectListDisplayContext;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mahammed Seleem
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ProjectConstant.PROJECT_MANAGEMENT_PORTLET,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class EsquareIntranetProjectManagementWebPortlet extends MVCPortlet {

    @Override
    public void render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        List<ListTypeDefinition> listTypeDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitions(-1, -1);
        Map<Long, String> listTypeName = listTypeDefinition.stream().collect(Collectors.toMap(ListTypeDefinition::getListTypeDefinitionId, listType -> extractNameFromXML(listType.getName())));
        renderRequest.setAttribute("listTypeName", listTypeName);
       List<Projects> projectsList = ProjectsLocalServiceUtil.getProjectses(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
        renderRequest.setAttribute(
                WebKeys.PORTLET_DISPLAY_CONTEXT,
                new ProjectListDisplayContext(
                        _portal.getHttpServletRequest(renderRequest),renderRequest, renderResponse,projectsList));

        super.render(renderRequest, renderResponse);
    }

    private static String extractNameFromXML(String xmlContent) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(xmlContent));
            Document doc = dBuilder.parse(inputSource);

            doc.getDocumentElement().normalize();
            NodeList nameList = doc.getElementsByTagName("Name");
            if (nameList.getLength() > 0) {
                Node nameNode = nameList.item(0);
                return nameNode.getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StringPool.BLANK;
    }
/*    @Reference(
            target = "(model.class.name=com.esquare.intranet.project.management.model.Projects)"
    )
    private ModelResourcePermission<Projects>
            _projectModelResourcePermission;*/
    @Reference
    private Portal _portal;

}