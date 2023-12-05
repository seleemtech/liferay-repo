package com.esquare.intranet.project.headless.resource.v1_0.test;

import com.esquare.intranet.project.headless.client.dto.v1_0.Project;
import com.esquare.intranet.project.headless.client.http.HttpInvoker;
import com.esquare.intranet.project.headless.client.pagination.Page;
import com.esquare.intranet.project.headless.client.pagination.Pagination;
import com.esquare.intranet.project.headless.client.resource.v1_0.ProjectResource;
import com.esquare.intranet.project.headless.client.serdes.v1_0.ProjectSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.function.transform.TransformUtil;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Mahammed Seleem
 * @generated
 */
@Generated("")
public abstract class BaseProjectResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_projectResource.setContextCompany(testCompany);

		ProjectResource.Builder builder = ProjectResource.builder();

		projectResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Project project1 = randomProject();

		String json = objectMapper.writeValueAsString(project1);

		Project project2 = ProjectSerDes.toDTO(json);

		Assert.assertTrue(equals(project1, project2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Project project = randomProject();

		String json1 = objectMapper.writeValueAsString(project);
		String json2 = ProjectSerDes.toJSON(project);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Project project = randomProject();

		project.setContactEmail(regex);
		project.setContactNumber(regex);
		project.setDeliveryLead(regex);
		project.setDescription(regex);
		project.setDurationDate(regex);
		project.setName(regex);
		project.setOperationLead(regex);
		project.setProjectManager(regex);
		project.setProjectName(regex);
		project.setProjectQaLead(regex);

		String json = ProjectSerDes.toJSON(project);

		Assert.assertFalse(json.contains(regex));

		project = ProjectSerDes.toDTO(json);

		Assert.assertEquals(regex, project.getContactEmail());
		Assert.assertEquals(regex, project.getContactNumber());
		Assert.assertEquals(regex, project.getDeliveryLead());
		Assert.assertEquals(regex, project.getDescription());
		Assert.assertEquals(regex, project.getDurationDate());
		Assert.assertEquals(regex, project.getName());
		Assert.assertEquals(regex, project.getOperationLead());
		Assert.assertEquals(regex, project.getProjectManager());
		Assert.assertEquals(regex, project.getProjectName());
		Assert.assertEquals(regex, project.getProjectQaLead());
	}

	@Test
	public void testGetProjectsManagementPage() throws Exception {
		Page<Project> page = projectResource.getProjectsManagementPage(
			null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		Project project1 = testGetProjectsManagementPage_addProject(
			randomProject());

		Project project2 = testGetProjectsManagementPage_addProject(
			randomProject());

		page = projectResource.getProjectsManagementPage(
			null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(project1, (List<Project>)page.getItems());
		assertContains(project2, (List<Project>)page.getItems());
		assertValid(page, testGetProjectsManagementPage_getExpectedActions());
	}

	protected Map<String, Map<String, String>>
			testGetProjectsManagementPage_getExpectedActions()
		throws Exception {

		Map<String, Map<String, String>> expectedActions = new HashMap<>();

		return expectedActions;
	}

	@Test
	public void testGetProjectsManagementPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = randomProject();

		project1 = testGetProjectsManagementPage_addProject(project1);

		for (EntityField entityField : entityFields) {
			Page<Project> page = projectResource.getProjectsManagementPage(
				null, getFilterString(entityField, "between", project1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(project1),
				(List<Project>)page.getItems());
		}
	}

	@Test
	public void testGetProjectsManagementPageWithFilterDoubleEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DOUBLE);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = testGetProjectsManagementPage_addProject(
			randomProject());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project2 = testGetProjectsManagementPage_addProject(
			randomProject());

		for (EntityField entityField : entityFields) {
			Page<Project> page = projectResource.getProjectsManagementPage(
				null, getFilterString(entityField, "eq", project1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(project1),
				(List<Project>)page.getItems());
		}
	}

	@Test
	public void testGetProjectsManagementPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = testGetProjectsManagementPage_addProject(
			randomProject());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project2 = testGetProjectsManagementPage_addProject(
			randomProject());

		for (EntityField entityField : entityFields) {
			Page<Project> page = projectResource.getProjectsManagementPage(
				null, getFilterString(entityField, "eq", project1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(project1),
				(List<Project>)page.getItems());
		}
	}

	@Test
	public void testGetProjectsManagementPageWithPagination() throws Exception {
		Page<Project> totalPage = projectResource.getProjectsManagementPage(
			null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		Project project1 = testGetProjectsManagementPage_addProject(
			randomProject());

		Project project2 = testGetProjectsManagementPage_addProject(
			randomProject());

		Project project3 = testGetProjectsManagementPage_addProject(
			randomProject());

		Page<Project> page1 = projectResource.getProjectsManagementPage(
			null, null, Pagination.of(1, totalCount + 2), null);

		List<Project> projects1 = (List<Project>)page1.getItems();

		Assert.assertEquals(
			projects1.toString(), totalCount + 2, projects1.size());

		Page<Project> page2 = projectResource.getProjectsManagementPage(
			null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<Project> projects2 = (List<Project>)page2.getItems();

		Assert.assertEquals(projects2.toString(), 1, projects2.size());

		Page<Project> page3 = projectResource.getProjectsManagementPage(
			null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(project1, (List<Project>)page3.getItems());
		assertContains(project2, (List<Project>)page3.getItems());
		assertContains(project3, (List<Project>)page3.getItems());
	}

	@Test
	public void testGetProjectsManagementPageWithSortDateTime()
		throws Exception {

		testGetProjectsManagementPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, project1, project2) -> {
				BeanTestUtil.setProperty(
					project1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetProjectsManagementPageWithSortDouble() throws Exception {
		testGetProjectsManagementPageWithSort(
			EntityField.Type.DOUBLE,
			(entityField, project1, project2) -> {
				BeanTestUtil.setProperty(project1, entityField.getName(), 0.1);
				BeanTestUtil.setProperty(project2, entityField.getName(), 0.5);
			});
	}

	@Test
	public void testGetProjectsManagementPageWithSortInteger()
		throws Exception {

		testGetProjectsManagementPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, project1, project2) -> {
				BeanTestUtil.setProperty(project1, entityField.getName(), 0);
				BeanTestUtil.setProperty(project2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetProjectsManagementPageWithSortString() throws Exception {
		testGetProjectsManagementPageWithSort(
			EntityField.Type.STRING,
			(entityField, project1, project2) -> {
				Class<?> clazz = project1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanTestUtil.setProperty(
						project1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanTestUtil.setProperty(
						project2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanTestUtil.setProperty(
						project1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanTestUtil.setProperty(
						project2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanTestUtil.setProperty(
						project1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanTestUtil.setProperty(
						project2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetProjectsManagementPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Project, Project, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = randomProject();
		Project project2 = randomProject();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, project1, project2);
		}

		project1 = testGetProjectsManagementPage_addProject(project1);

		project2 = testGetProjectsManagementPage_addProject(project2);

		for (EntityField entityField : entityFields) {
			Page<Project> ascPage = projectResource.getProjectsManagementPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(project1, project2),
				(List<Project>)ascPage.getItems());

			Page<Project> descPage = projectResource.getProjectsManagementPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(project2, project1),
				(List<Project>)descPage.getItems());
		}
	}

	protected Project testGetProjectsManagementPage_addProject(Project project)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteProjectsManagementProject() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project = testDeleteProjectsManagementProject_addProject();

		assertHttpResponseStatusCode(
			204,
			projectResource.deleteProjectsManagementProjectHttpResponse(
				project.getId()));

		assertHttpResponseStatusCode(
			404,
			projectResource.getProjectsManagementProjectHttpResponse(
				project.getId()));

		assertHttpResponseStatusCode(
			404, projectResource.getProjectsManagementProjectHttpResponse(0L));
	}

	protected Project testDeleteProjectsManagementProject_addProject()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetProjectsManagementProject() throws Exception {
		Project postProject = testGetProjectsManagementProject_addProject();

		Project getProject = projectResource.getProjectsManagementProject(
			postProject.getId());

		assertEquals(postProject, getProject);
		assertValid(getProject);
	}

	protected Project testGetProjectsManagementProject_addProject()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetProjectsManagementProject() throws Exception {
		Project project = testGraphQLGetProjectsManagementProject_addProject();

		Assert.assertTrue(
			equals(
				project,
				ProjectSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"projectsManagementProject",
								new HashMap<String, Object>() {
									{
										put("projectId", project.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data",
						"Object/projectsManagementProject"))));
	}

	@Test
	public void testGraphQLGetProjectsManagementProjectNotFound()
		throws Exception {

		Long irrelevantProjectId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"projectsManagementProject",
						new HashMap<String, Object>() {
							{
								put("projectId", irrelevantProjectId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	protected Project testGraphQLGetProjectsManagementProject_addProject()
		throws Exception {

		return testGraphQLProject_addProject();
	}

	@Test
	public void testPatchPostResource() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPatchPostProjectStatu() throws Exception {
		Assert.assertTrue(false);
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Project testGraphQLProject_addProject() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Project project, List<Project> projects) {
		boolean contains = false;

		for (Project item : projects) {
			if (equals(project, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(projects + " does not contain " + project, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Project project1, Project project2) {
		Assert.assertTrue(
			project1 + " does not equal " + project2,
			equals(project1, project2));
	}

	protected void assertEquals(
		List<Project> projects1, List<Project> projects2) {

		Assert.assertEquals(projects1.size(), projects2.size());

		for (int i = 0; i < projects1.size(); i++) {
			Project project1 = projects1.get(i);
			Project project2 = projects2.get(i);

			assertEquals(project1, project2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Project> projects1, List<Project> projects2) {

		Assert.assertEquals(projects1.size(), projects2.size());

		for (Project project1 : projects1) {
			boolean contains = false;

			for (Project project2 : projects2) {
				if (equals(project1, project2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				projects2 + " does not contain " + project1, contains);
		}
	}

	protected void assertValid(Project project) throws Exception {
		boolean valid = true;

		if (project.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (project.getActions() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (project.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("confirmedDate", additionalAssertFieldName)) {
				if (project.getConfirmedDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("contactEmail", additionalAssertFieldName)) {
				if (project.getContactEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("contactNumber", additionalAssertFieldName)) {
				if (project.getContactNumber() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("deliveryLead", additionalAssertFieldName)) {
				if (project.getDeliveryLead() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (project.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"developmentStartDate", additionalAssertFieldName)) {

				if (project.getDevelopmentStartDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dlId", additionalAssertFieldName)) {
				if (project.getDlId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("durationDate", additionalAssertFieldName)) {
				if (project.getDurationDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (project.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("olId", additionalAssertFieldName)) {
				if (project.getOlId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("operationLead", additionalAssertFieldName)) {
				if (project.getOperationLead() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("pmId", additionalAssertFieldName)) {
				if (project.getPmId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectManager", additionalAssertFieldName)) {
				if (project.getProjectManager() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectName", additionalAssertFieldName)) {
				if (project.getProjectName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectQaLead", additionalAssertFieldName)) {
				if (project.getProjectQaLead() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("proposedDate", additionalAssertFieldName)) {
				if (project.getProposedDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("qlId", additionalAssertFieldName)) {
				if (project.getQlId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (project.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statusCode", additionalAssertFieldName)) {
				if (project.getStatusCode() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Project> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<Project> page, Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<Project> projects = page.getItems();

		int size = projects.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);

		Map<String, Map<String, String>> actions = page.getActions();

		for (String key : expectedActions.keySet()) {
			Map action = actions.get(key);

			Assert.assertNotNull(key + " does not contain an action", action);

			Map expectedAction = expectedActions.get(key);

			Assert.assertEquals(
				expectedAction.get("method"), action.get("method"));
			Assert.assertEquals(expectedAction.get("href"), action.get("href"));
		}
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.esquare.intranet.project.headless.dto.v1_0.Project.
						class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Project project1, Project project2) {
		if (project1 == project2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (!equals(
						(Map)project1.getActions(),
						(Map)project2.getActions())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getCode(), project2.getCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("confirmedDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getConfirmedDate(),
						project2.getConfirmedDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("contactEmail", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getContactEmail(),
						project2.getContactEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("contactNumber", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getContactNumber(),
						project2.getContactNumber())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("deliveryLead", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getDeliveryLead(),
						project2.getDeliveryLead())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getDescription(), project2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"developmentStartDate", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						project1.getDevelopmentStartDate(),
						project2.getDevelopmentStartDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dlId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getDlId(), project2.getDlId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("durationDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getDurationDate(),
						project2.getDurationDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(project1.getId(), project2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getName(), project2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("olId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getOlId(), project2.getOlId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("operationLead", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getOperationLead(),
						project2.getOperationLead())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("pmId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getPmId(), project2.getPmId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectManager", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getProjectManager(),
						project2.getProjectManager())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getProjectName(), project2.getProjectName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectQaLead", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getProjectQaLead(),
						project2.getProjectQaLead())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("proposedDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getProposedDate(),
						project2.getProposedDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("qlId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getQlId(), project2.getQlId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getStatus(), project2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("statusCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getStatusCode(), project2.getStatusCode())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		return TransformUtil.transform(
			ReflectionUtil.getDeclaredFields(clazz),
			field -> {
				if (field.isSynthetic()) {
					return null;
				}

				return field;
			},
			java.lang.reflect.Field.class);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_projectResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_projectResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		if (entityModel == null) {
			return Collections.emptyList();
		}

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		return TransformUtil.transform(
			getEntityFields(),
			entityField -> {
				if (!Objects.equals(entityField.getType(), type) ||
					ArrayUtil.contains(
						getIgnoredEntityFieldNames(), entityField.getName())) {

					return null;
				}

				return entityField;
			});
	}

	protected String getFilterString(
		EntityField entityField, String operator, Project project) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("actions")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("code")) {
			sb.append(String.valueOf(project.getCode()));

			return sb.toString();
		}

		if (entityFieldName.equals("confirmedDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getConfirmedDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getConfirmedDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getConfirmedDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("contactEmail")) {
			sb.append("'");
			sb.append(String.valueOf(project.getContactEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("contactNumber")) {
			sb.append("'");
			sb.append(String.valueOf(project.getContactNumber()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("deliveryLead")) {
			sb.append("'");
			sb.append(String.valueOf(project.getDeliveryLead()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(project.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("developmentStartDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							project.getDevelopmentStartDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							project.getDevelopmentStartDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(
					_dateFormat.format(project.getDevelopmentStartDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("dlId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("durationDate")) {
			sb.append("'");
			sb.append(String.valueOf(project.getDurationDate()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(project.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("olId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("operationLead")) {
			sb.append("'");
			sb.append(String.valueOf(project.getOperationLead()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("pmId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("projectManager")) {
			sb.append("'");
			sb.append(String.valueOf(project.getProjectManager()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("projectName")) {
			sb.append("'");
			sb.append(String.valueOf(project.getProjectName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("projectQaLead")) {
			sb.append("'");
			sb.append(String.valueOf(project.getProjectQaLead()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("proposedDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getProposedDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getProposedDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getProposedDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("qlId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("statusCode")) {
			sb.append(String.valueOf(project.getStatusCode()));

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Project randomProject() throws Exception {
		return new Project() {
			{
				code = RandomTestUtil.randomInt();
				confirmedDate = RandomTestUtil.nextDate();
				contactEmail = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				contactNumber = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				deliveryLead = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				developmentStartDate = RandomTestUtil.nextDate();
				dlId = RandomTestUtil.randomLong();
				durationDate = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				olId = RandomTestUtil.randomLong();
				operationLead = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				pmId = RandomTestUtil.randomLong();
				projectManager = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				projectName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				projectQaLead = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				proposedDate = RandomTestUtil.nextDate();
				qlId = RandomTestUtil.randomLong();
				statusCode = RandomTestUtil.randomInt();
			}
		};
	}

	protected Project randomIrrelevantProject() throws Exception {
		Project randomIrrelevantProject = randomProject();

		return randomIrrelevantProject;
	}

	protected Project randomPatchProject() throws Exception {
		return randomProject();
	}

	protected ProjectResource projectResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = _getSuperClass(source.getClass());

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					sourceClass.getDeclaredFields()) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				Method setMethod = _getMethod(
					targetClass, field.getName(), "set",
					getMethod.getReturnType());

				setMethod.invoke(target, getMethod.invoke(source));
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Class<?> _getSuperClass(Class<?> clazz) {
			Class<?> superClass = clazz.getSuperclass();

			if ((superClass == null) || (superClass == Object.class)) {
				return clazz;
			}

			return superClass;
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseProjectResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.esquare.intranet.project.headless.resource.v1_0.ProjectResource
		_projectResource;

}