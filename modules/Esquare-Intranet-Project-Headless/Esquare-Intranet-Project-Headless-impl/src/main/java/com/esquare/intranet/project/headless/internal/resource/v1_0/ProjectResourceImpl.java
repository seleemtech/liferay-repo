package com.esquare.intranet.project.headless.internal.resource.v1_0;

import com.esquare.intranet.helpdesk.web.portlet.workflow.CustomWorkflowConstants;
import com.esquare.intranet.project.headless.dto.v1_0.Project;
import com.esquare.intranet.project.headless.dto.v1_0.Status;
import com.esquare.intranet.project.headless.internal.odata.entity.v1_0.ProjectEntityModel;
import com.esquare.intranet.project.headless.resource.v1_0.ProjectResource;

import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.ProjectsService;
import com.esquare.intranet.project.management.service.TeamMembersService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Collections;

/**
 * @author Mahammed Seleem
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/project.properties",
        scope = ServiceScope.PROTOTYPE, service = ProjectResource.class
)
public class ProjectResourceImpl extends BaseProjectResourceImpl {

    @Override
    public Page<Project> getProjectsManagementPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> booleanQuery.getPreBooleanFilter(),
                filter,
                Projects.class.getName(),
                search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> {
                    searchContext.setCompanyId(contextCompany.getCompanyId());
                },
                sorts,
                document -> _toProjectManagement(
                        _projectsService.getProject(
                                GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))));
    }

    @Override
    public Project patchPostProjectStatu(Project project) throws Exception {
        return _toProjectManagement(_projectsService.updateStatus(project.getId(),project.getStatusCode()));
    }

    @Override
    public Project patchPostResource(Project project) throws Exception {
        return _toProjectManagement(_projectsService.addResourceIdSetting(project.getId(), project.getPmId(), project.getDlId(), project.getOlId(), project.getQlId()));
    }

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
        return _entityModel;
    }

    @Override
    public Project getProjectsManagementProject(Long projectId) throws Exception {
        return _toProjectManagement(_projectsService.getProject(projectId));
    }


    private Project _toProjectManagement(
            Projects
                    serviceBuilderProjectManagement) {


        return new Project() {
            {
			/*	actions = HashMapBuilder
						.put(
								"get",
								addAction(
										ActionKeys.VIEW, "getProjectsManagementProject",
										Projects.class.getName(),
										serviceBuilderProjectManagement.getProjectId()
								)
						).build();*/
                name = serviceBuilderProjectManagement.getName();
                description =
                        serviceBuilderProjectManagement.getDescription();
                proposedDate = serviceBuilderProjectManagement.getProposedDate();
                confirmedDate = serviceBuilderProjectManagement.getConfirmedDate();
                developmentStartDate = serviceBuilderProjectManagement.getDevelopmentStartDate();
                durationDate = serviceBuilderProjectManagement.getDurationDate();
                status = new Status() {
                    {
                        code = serviceBuilderProjectManagement.getStatus();
                        label = CustomWorkflowConstants.getStatusLabel(serviceBuilderProjectManagement.getStatus());
                        label_i18n = CustomWorkflowConstants.getStatusLabel(serviceBuilderProjectManagement.getStatus());
                    }
                };
                code = serviceBuilderProjectManagement.getCode();
                projectName = serviceBuilderProjectManagement.getProjectName();
                contactNumber = serviceBuilderProjectManagement.getContactNumber();
                contactEmail = serviceBuilderProjectManagement.getContactEmail();
                id = serviceBuilderProjectManagement.getProjectId();
                UnicodeProperties unicodeProperties = new UnicodeProperties();
                unicodeProperties.fastLoad(serviceBuilderProjectManagement.getResourceIdSettings());
                projectManager = getMemberName(unicodeProperties.getProperty(ProjectConstant.PROJECT_MANAGER_ID));
                deliveryLead = getMemberName(unicodeProperties.getProperty(ProjectConstant.DELIVERY_LEAD_ID));
                operationLead = getMemberName(unicodeProperties.getProperty(ProjectConstant.OPERATION_LEAD_ID));
                projectQaLead = getMemberName(unicodeProperties.getProperty(ProjectConstant.PROJECT_QA_LEAD_ID));
            }
        };
    }

    private String getMemberName(String userId) {
        try {
            return _teamMembersService.getMemberNameByUserId(Long.parseLong(userId));
        } catch (Exception e) {
            if (_log.isDebugEnabled()) {
                _log.debug("Enable to get the userName Based on userId in TeamMember Entity" + e);
            }
        }
        return StringPool.BLANK;
    }

    private static final ProjectEntityModel _entityModel =
            new ProjectEntityModel();
    private static final Log _log = LogFactoryUtil.getLog(ProjectResourceImpl.class);
    @Reference
    private ProjectsService _projectsService;
    @Reference
    private TeamMembersService _teamMembersService;


}