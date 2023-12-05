package com.comments.headless.resource.v1_0.test;

import com.comments.headless.client.dto.v1_0.Workflow;
import com.comments.headless.client.http.HttpInvoker;
import com.comments.headless.client.pagination.Page;
import com.comments.headless.client.resource.v1_0.WorkflowResource;
import com.comments.headless.client.serdes.v1_0.WorkflowSerDes;

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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author E2Software-011
 * @generated
 */
@Generated("")
public abstract class BaseWorkflowResourceTestCase {

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

		_workflowResource.setContextCompany(testCompany);

		WorkflowResource.Builder builder = WorkflowResource.builder();

		workflowResource = builder.authentication(
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

		Workflow workflow1 = randomWorkflow();

		String json = objectMapper.writeValueAsString(workflow1);

		Workflow workflow2 = WorkflowSerDes.toDTO(json);

		Assert.assertTrue(equals(workflow1, workflow2));
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

		Workflow workflow = randomWorkflow();

		String json1 = objectMapper.writeValueAsString(workflow);
		String json2 = WorkflowSerDes.toJSON(workflow);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Workflow workflow = randomWorkflow();

		workflow.setTaskContent(regex);
		workflow.setComment(regex);
		workflow.setTransitionName(regex);
		workflow.setWorkflowTaskAssigneeUserName(regex);

		String json = WorkflowSerDes.toJSON(workflow);

		Assert.assertFalse(json.contains(regex));

		workflow = WorkflowSerDes.toDTO(json);

		Assert.assertEquals(regex, workflow.getTaskContent());
		Assert.assertEquals(regex, workflow.getComment());
		Assert.assertEquals(regex, workflow.getTransitionName());
		Assert.assertEquals(regex, workflow.getWorkflowTaskAssigneeUserName());
	}

	@Test
	public void testAssignToMe() throws Exception {
		Workflow randomWorkflow = randomWorkflow();

		Workflow postWorkflow = testAssignToMe_addWorkflow(randomWorkflow);

		assertEquals(randomWorkflow, postWorkflow);
		assertValid(postWorkflow);
	}

	protected Workflow testAssignToMe_addWorkflow(Workflow workflow)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testCompleteAssignTask() throws Exception {
		Workflow randomWorkflow = randomWorkflow();

		Workflow postWorkflow = testCompleteAssignTask_addWorkflow(
			randomWorkflow);

		assertEquals(randomWorkflow, postWorkflow);
		assertValid(postWorkflow);
	}

	protected Workflow testCompleteAssignTask_addWorkflow(Workflow workflow)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetWorkflowTask() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetWorkflowTask() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetWorkflowTaskNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertContains(Workflow workflow, List<Workflow> workflows) {
		boolean contains = false;

		for (Workflow item : workflows) {
			if (equals(workflow, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			workflows + " does not contain " + workflow, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Workflow workflow1, Workflow workflow2) {
		Assert.assertTrue(
			workflow1 + " does not equal " + workflow2,
			equals(workflow1, workflow2));
	}

	protected void assertEquals(
		List<Workflow> workflows1, List<Workflow> workflows2) {

		Assert.assertEquals(workflows1.size(), workflows2.size());

		for (int i = 0; i < workflows1.size(); i++) {
			Workflow workflow1 = workflows1.get(i);
			Workflow workflow2 = workflows2.get(i);

			assertEquals(workflow1, workflow2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Workflow> workflows1, List<Workflow> workflows2) {

		Assert.assertEquals(workflows1.size(), workflows2.size());

		for (Workflow workflow1 : workflows1) {
			boolean contains = false;

			for (Workflow workflow2 : workflows2) {
				if (equals(workflow1, workflow2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				workflows2 + " does not contain " + workflow1, contains);
		}
	}

	protected void assertValid(Workflow workflow) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("TaskContent", additionalAssertFieldName)) {
				if (workflow.getTaskContent() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("assignableUser", additionalAssertFieldName)) {
				if (workflow.getAssignableUser() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("assigneeUserId", additionalAssertFieldName)) {
				if (workflow.getAssigneeUserId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("comment", additionalAssertFieldName)) {
				if (workflow.getComment() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("companyId", additionalAssertFieldName)) {
				if (workflow.getCompanyId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (workflow.getGroupId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"isAssignedToSingleUser", additionalAssertFieldName)) {

				if (workflow.getIsAssignedToSingleUser() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"isWorkflowCompleted", additionalAssertFieldName)) {

				if (workflow.getIsWorkflowCompleted() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("transitionName", additionalAssertFieldName)) {
				if (workflow.getTransitionName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (workflow.getUserId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("worflowTansition", additionalAssertFieldName)) {
				if (workflow.getWorflowTansition() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"workflowTaskAssigneeUserName",
					additionalAssertFieldName)) {

				if (workflow.getWorkflowTaskAssigneeUserName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("workflowTaskId", additionalAssertFieldName)) {
				if (workflow.getWorkflowTaskId() == null) {
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

	protected void assertValid(Page<Workflow> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<Workflow> page, Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<Workflow> workflows = page.getItems();

		int size = workflows.size();

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
					com.comments.headless.dto.v1_0.Workflow.class)) {

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

	protected boolean equals(Workflow workflow1, Workflow workflow2) {
		if (workflow1 == workflow2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("TaskContent", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getTaskContent(),
						workflow2.getTaskContent())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("assignableUser", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getAssignableUser(),
						workflow2.getAssignableUser())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("assigneeUserId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getAssigneeUserId(),
						workflow2.getAssigneeUserId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("comment", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getComment(), workflow2.getComment())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("companyId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getCompanyId(), workflow2.getCompanyId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("groupId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getGroupId(), workflow2.getGroupId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"isAssignedToSingleUser", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						workflow1.getIsAssignedToSingleUser(),
						workflow2.getIsAssignedToSingleUser())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"isWorkflowCompleted", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						workflow1.getIsWorkflowCompleted(),
						workflow2.getIsWorkflowCompleted())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("transitionName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getTransitionName(),
						workflow2.getTransitionName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getUserId(), workflow2.getUserId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("worflowTansition", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getWorflowTansition(),
						workflow2.getWorflowTansition())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"workflowTaskAssigneeUserName",
					additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						workflow1.getWorkflowTaskAssigneeUserName(),
						workflow2.getWorkflowTaskAssigneeUserName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("workflowTaskId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						workflow1.getWorkflowTaskId(),
						workflow2.getWorkflowTaskId())) {

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

		if (!(_workflowResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_workflowResource;

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
		EntityField entityField, String operator, Workflow workflow) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("TaskContent")) {
			sb.append("'");
			sb.append(String.valueOf(workflow.getTaskContent()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("assignableUser")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("assigneeUserId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("comment")) {
			sb.append("'");
			sb.append(String.valueOf(workflow.getComment()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("companyId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("groupId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("isAssignedToSingleUser")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("isWorkflowCompleted")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("transitionName")) {
			sb.append("'");
			sb.append(String.valueOf(workflow.getTransitionName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("userId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("worflowTansition")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("workflowTaskAssigneeUserName")) {
			sb.append("'");
			sb.append(
				String.valueOf(workflow.getWorkflowTaskAssigneeUserName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("workflowTaskId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
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

	protected Workflow randomWorkflow() throws Exception {
		return new Workflow() {
			{
				TaskContent = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				assigneeUserId = RandomTestUtil.randomLong();
				comment = StringUtil.toLowerCase(RandomTestUtil.randomString());
				companyId = RandomTestUtil.randomLong();
				groupId = RandomTestUtil.randomLong();
				isAssignedToSingleUser = RandomTestUtil.randomBoolean();
				isWorkflowCompleted = RandomTestUtil.randomBoolean();
				transitionName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				userId = RandomTestUtil.randomLong();
				workflowTaskAssigneeUserName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				workflowTaskId = RandomTestUtil.randomLong();
			}
		};
	}

	protected Workflow randomIrrelevantWorkflow() throws Exception {
		Workflow randomIrrelevantWorkflow = randomWorkflow();

		return randomIrrelevantWorkflow;
	}

	protected Workflow randomPatchWorkflow() throws Exception {
		return randomWorkflow();
	}

	protected WorkflowResource workflowResource;
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
		LogFactoryUtil.getLog(BaseWorkflowResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.comments.headless.resource.v1_0.WorkflowResource
		_workflowResource;

}