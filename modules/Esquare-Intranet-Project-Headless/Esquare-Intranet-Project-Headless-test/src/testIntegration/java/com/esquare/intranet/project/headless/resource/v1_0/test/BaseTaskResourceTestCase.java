package com.esquare.intranet.project.headless.resource.v1_0.test;

import com.esquare.intranet.project.headless.client.dto.v1_0.Task;
import com.esquare.intranet.project.headless.client.http.HttpInvoker;
import com.esquare.intranet.project.headless.client.pagination.Page;
import com.esquare.intranet.project.headless.client.resource.v1_0.TaskResource;
import com.esquare.intranet.project.headless.client.serdes.v1_0.TaskSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
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
public abstract class BaseTaskResourceTestCase {

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

		_taskResource.setContextCompany(testCompany);

		TaskResource.Builder builder = TaskResource.builder();

		taskResource = builder.authentication(
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

		Task task1 = randomTask();

		String json = objectMapper.writeValueAsString(task1);

		Task task2 = TaskSerDes.toDTO(json);

		Assert.assertTrue(equals(task1, task2));
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

		Task task = randomTask();

		String json1 = objectMapper.writeValueAsString(task);
		String json2 = TaskSerDes.toJSON(task);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Task task = randomTask();

		task.setDescription(regex);
		task.setDevelopmentTeam(regex);
		task.setDevelopmentTeamIds(regex);
		task.setName(regex);
		task.setTesterTeam(regex);
		task.setTesterTeamIds(regex);

		String json = TaskSerDes.toJSON(task);

		Assert.assertFalse(json.contains(regex));

		task = TaskSerDes.toDTO(json);

		Assert.assertEquals(regex, task.getDescription());
		Assert.assertEquals(regex, task.getDevelopmentTeam());
		Assert.assertEquals(regex, task.getDevelopmentTeamIds());
		Assert.assertEquals(regex, task.getName());
		Assert.assertEquals(regex, task.getTesterTeam());
		Assert.assertEquals(regex, task.getTesterTeamIds());
	}

	@Test
	public void testGetGetTasksProjectPage() throws Exception {
		Long projectId = testGetGetTasksProjectPage_getProjectId();
		Long irrelevantProjectId =
			testGetGetTasksProjectPage_getIrrelevantProjectId();

		Page<Task> page = taskResource.getGetTasksProjectPage(projectId);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantProjectId != null) {
			Task irrelevantTask = testGetGetTasksProjectPage_addTask(
				irrelevantProjectId, randomIrrelevantTask());

			page = taskResource.getGetTasksProjectPage(irrelevantProjectId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantTask), (List<Task>)page.getItems());
			assertValid(
				page,
				testGetGetTasksProjectPage_getExpectedActions(
					irrelevantProjectId));
		}

		Task task1 = testGetGetTasksProjectPage_addTask(
			projectId, randomTask());

		Task task2 = testGetGetTasksProjectPage_addTask(
			projectId, randomTask());

		page = taskResource.getGetTasksProjectPage(projectId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(task1, task2), (List<Task>)page.getItems());
		assertValid(
			page, testGetGetTasksProjectPage_getExpectedActions(projectId));
	}

	protected Map<String, Map<String, String>>
			testGetGetTasksProjectPage_getExpectedActions(Long projectId)
		throws Exception {

		Map<String, Map<String, String>> expectedActions = new HashMap<>();

		return expectedActions;
	}

	protected Task testGetGetTasksProjectPage_addTask(Long projectId, Task task)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetGetTasksProjectPage_getProjectId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetGetTasksProjectPage_getIrrelevantProjectId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostPostTask() throws Exception {
		Task randomTask = randomTask();

		Task postTask = testPostPostTask_addTask(randomTask);

		assertEquals(randomTask, postTask);
		assertValid(postTask);
	}

	protected Task testPostPostTask_addTask(Task task) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostUpdateTask() throws Exception {
		Task randomTask = randomTask();

		Task postTask = testPostUpdateTask_addTask(randomTask);

		assertEquals(randomTask, postTask);
		assertValid(postTask);
	}

	protected Task testPostUpdateTask_addTask(Task task) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Task testGraphQLTask_addTask() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Task task, List<Task> tasks) {
		boolean contains = false;

		for (Task item : tasks) {
			if (equals(task, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(tasks + " does not contain " + task, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Task task1, Task task2) {
		Assert.assertTrue(
			task1 + " does not equal " + task2, equals(task1, task2));
	}

	protected void assertEquals(List<Task> tasks1, List<Task> tasks2) {
		Assert.assertEquals(tasks1.size(), tasks2.size());

		for (int i = 0; i < tasks1.size(); i++) {
			Task task1 = tasks1.get(i);
			Task task2 = tasks2.get(i);

			assertEquals(task1, task2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Task> tasks1, List<Task> tasks2) {

		Assert.assertEquals(tasks1.size(), tasks2.size());

		for (Task task1 : tasks1) {
			boolean contains = false;

			for (Task task2 : tasks2) {
				if (equals(task1, task2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(tasks2 + " does not contain " + task1, contains);
		}
	}

	protected void assertValid(Task task) throws Exception {
		boolean valid = true;

		if (task.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (task.getActions() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (task.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("developmentTeam", additionalAssertFieldName)) {
				if (task.getDevelopmentTeam() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"developmentTeamIds", additionalAssertFieldName)) {

				if (task.getDevelopmentTeamIds() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (task.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectCode", additionalAssertFieldName)) {
				if (task.getProjectCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (task.getProjectId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (task.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("taskEndDate", additionalAssertFieldName)) {
				if (task.getTaskEndDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("taskStartDate", additionalAssertFieldName)) {
				if (task.getTaskStartDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("testerTeam", additionalAssertFieldName)) {
				if (task.getTesterTeam() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("testerTeamIds", additionalAssertFieldName)) {
				if (task.getTesterTeamIds() == null) {
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

	protected void assertValid(Page<Task> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<Task> page, Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<Task> tasks = page.getItems();

		int size = tasks.size();

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
					com.esquare.intranet.project.headless.dto.v1_0.Task.
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

	protected boolean equals(Task task1, Task task2) {
		if (task1 == task2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (!equals((Map)task1.getActions(), (Map)task2.getActions())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						task1.getDescription(), task2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("developmentTeam", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						task1.getDevelopmentTeam(),
						task2.getDevelopmentTeam())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"developmentTeamIds", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						task1.getDevelopmentTeamIds(),
						task2.getDevelopmentTeamIds())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(task1.getId(), task2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(task1.getName(), task2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("projectCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						task1.getProjectCode(), task2.getProjectCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						task1.getProjectId(), task2.getProjectId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(task1.getStatus(), task2.getStatus())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("taskEndDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						task1.getTaskEndDate(), task2.getTaskEndDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("taskStartDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						task1.getTaskStartDate(), task2.getTaskStartDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("testerTeam", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						task1.getTesterTeam(), task2.getTesterTeam())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("testerTeamIds", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						task1.getTesterTeamIds(), task2.getTesterTeamIds())) {

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

		if (!(_taskResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_taskResource;

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
		EntityField entityField, String operator, Task task) {

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

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(task.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("developmentTeam")) {
			sb.append("'");
			sb.append(String.valueOf(task.getDevelopmentTeam()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("developmentTeamIds")) {
			sb.append("'");
			sb.append(String.valueOf(task.getDevelopmentTeamIds()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(task.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("projectCode")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("projectId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("taskEndDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(task.getTaskEndDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(task.getTaskEndDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(task.getTaskEndDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("taskStartDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(task.getTaskStartDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(task.getTaskStartDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(task.getTaskStartDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("testerTeam")) {
			sb.append("'");
			sb.append(String.valueOf(task.getTesterTeam()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("testerTeamIds")) {
			sb.append("'");
			sb.append(String.valueOf(task.getTesterTeamIds()));
			sb.append("'");

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

	protected Task randomTask() throws Exception {
		return new Task() {
			{
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				developmentTeam = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				developmentTeamIds = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				projectCode = RandomTestUtil.randomLong();
				projectId = RandomTestUtil.randomLong();
				taskEndDate = RandomTestUtil.nextDate();
				taskStartDate = RandomTestUtil.nextDate();
				testerTeam = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				testerTeamIds = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected Task randomIrrelevantTask() throws Exception {
		Task randomIrrelevantTask = randomTask();

		return randomIrrelevantTask;
	}

	protected Task randomPatchTask() throws Exception {
		return randomTask();
	}

	protected TaskResource taskResource;
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
		LogFactoryUtil.getLog(BaseTaskResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.esquare.intranet.project.headless.resource.v1_0.TaskResource
		_taskResource;

}