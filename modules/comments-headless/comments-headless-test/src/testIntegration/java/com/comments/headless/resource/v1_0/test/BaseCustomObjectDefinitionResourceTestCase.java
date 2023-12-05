package com.comments.headless.resource.v1_0.test;

import com.comments.headless.client.dto.v1_0.CustomObjectDefinition;
import com.comments.headless.client.http.HttpInvoker;
import com.comments.headless.client.pagination.Page;
import com.comments.headless.client.pagination.Pagination;
import com.comments.headless.client.resource.v1_0.CustomObjectDefinitionResource;
import com.comments.headless.client.serdes.v1_0.CustomObjectDefinitionSerDes;

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
 * @author E2Software-011
 * @generated
 */
@Generated("")
public abstract class BaseCustomObjectDefinitionResourceTestCase {

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

		_customObjectDefinitionResource.setContextCompany(testCompany);

		CustomObjectDefinitionResource.Builder builder =
			CustomObjectDefinitionResource.builder();

		customObjectDefinitionResource = builder.authentication(
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

		CustomObjectDefinition customObjectDefinition1 =
			randomCustomObjectDefinition();

		String json = objectMapper.writeValueAsString(customObjectDefinition1);

		CustomObjectDefinition customObjectDefinition2 =
			CustomObjectDefinitionSerDes.toDTO(json);

		Assert.assertTrue(
			equals(customObjectDefinition1, customObjectDefinition2));
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

		CustomObjectDefinition customObjectDefinition =
			randomCustomObjectDefinition();

		String json1 = objectMapper.writeValueAsString(customObjectDefinition);
		String json2 = CustomObjectDefinitionSerDes.toJSON(
			customObjectDefinition);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		CustomObjectDefinition customObjectDefinition =
			randomCustomObjectDefinition();

		customObjectDefinition.setAccountEntryRestrictedObjectFieldName(regex);
		customObjectDefinition.setDefaultLanguageId(regex);
		customObjectDefinition.setExternalReferenceCode(regex);
		customObjectDefinition.setName(regex);
		customObjectDefinition.setPanelAppOrder(regex);
		customObjectDefinition.setPanelCategoryKey(regex);
		customObjectDefinition.setRestContextPath(regex);
		customObjectDefinition.setScope(regex);
		customObjectDefinition.setStorageType(regex);
		customObjectDefinition.setTitleObjectFieldName(regex);

		String json = CustomObjectDefinitionSerDes.toJSON(
			customObjectDefinition);

		Assert.assertFalse(json.contains(regex));

		customObjectDefinition = CustomObjectDefinitionSerDes.toDTO(json);

		Assert.assertEquals(
			regex,
			customObjectDefinition.getAccountEntryRestrictedObjectFieldName());
		Assert.assertEquals(
			regex, customObjectDefinition.getDefaultLanguageId());
		Assert.assertEquals(
			regex, customObjectDefinition.getExternalReferenceCode());
		Assert.assertEquals(regex, customObjectDefinition.getName());
		Assert.assertEquals(regex, customObjectDefinition.getPanelAppOrder());
		Assert.assertEquals(
			regex, customObjectDefinition.getPanelCategoryKey());
		Assert.assertEquals(regex, customObjectDefinition.getRestContextPath());
		Assert.assertEquals(regex, customObjectDefinition.getScope());
		Assert.assertEquals(regex, customObjectDefinition.getStorageType());
		Assert.assertEquals(
			regex, customObjectDefinition.getTitleObjectFieldName());
	}

	@Test
	public void testGetObjectDefinitionsPage() throws Exception {
		Page<CustomObjectDefinition> page =
			customObjectDefinitionResource.getObjectDefinitionsPage(
				null, null, null, Pagination.of(1, 10), null);

		long totalCount = page.getTotalCount();

		CustomObjectDefinition customObjectDefinition1 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				randomCustomObjectDefinition());

		CustomObjectDefinition customObjectDefinition2 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				randomCustomObjectDefinition());

		page = customObjectDefinitionResource.getObjectDefinitionsPage(
			null, null, null, Pagination.of(1, 10), null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			customObjectDefinition1,
			(List<CustomObjectDefinition>)page.getItems());
		assertContains(
			customObjectDefinition2,
			(List<CustomObjectDefinition>)page.getItems());
		assertValid(page, testGetObjectDefinitionsPage_getExpectedActions());
	}

	protected Map<String, Map<String, String>>
			testGetObjectDefinitionsPage_getExpectedActions()
		throws Exception {

		Map<String, Map<String, String>> expectedActions = new HashMap<>();

		return expectedActions;
	}

	@Test
	public void testGetObjectDefinitionsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		CustomObjectDefinition customObjectDefinition1 =
			randomCustomObjectDefinition();

		customObjectDefinition1 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				customObjectDefinition1);

		for (EntityField entityField : entityFields) {
			Page<CustomObjectDefinition> page =
				customObjectDefinitionResource.getObjectDefinitionsPage(
					null, null,
					getFilterString(
						entityField, "between", customObjectDefinition1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(customObjectDefinition1),
				(List<CustomObjectDefinition>)page.getItems());
		}
	}

	@Test
	public void testGetObjectDefinitionsPageWithFilterDoubleEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DOUBLE);

		if (entityFields.isEmpty()) {
			return;
		}

		CustomObjectDefinition customObjectDefinition1 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				randomCustomObjectDefinition());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		CustomObjectDefinition customObjectDefinition2 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				randomCustomObjectDefinition());

		for (EntityField entityField : entityFields) {
			Page<CustomObjectDefinition> page =
				customObjectDefinitionResource.getObjectDefinitionsPage(
					null, null,
					getFilterString(entityField, "eq", customObjectDefinition1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(customObjectDefinition1),
				(List<CustomObjectDefinition>)page.getItems());
		}
	}

	@Test
	public void testGetObjectDefinitionsPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		CustomObjectDefinition customObjectDefinition1 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				randomCustomObjectDefinition());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		CustomObjectDefinition customObjectDefinition2 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				randomCustomObjectDefinition());

		for (EntityField entityField : entityFields) {
			Page<CustomObjectDefinition> page =
				customObjectDefinitionResource.getObjectDefinitionsPage(
					null, null,
					getFilterString(entityField, "eq", customObjectDefinition1),
					Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(customObjectDefinition1),
				(List<CustomObjectDefinition>)page.getItems());
		}
	}

	@Test
	public void testGetObjectDefinitionsPageWithPagination() throws Exception {
		Page<CustomObjectDefinition> totalPage =
			customObjectDefinitionResource.getObjectDefinitionsPage(
				null, null, null, null, null);

		int totalCount = GetterUtil.getInteger(totalPage.getTotalCount());

		CustomObjectDefinition customObjectDefinition1 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				randomCustomObjectDefinition());

		CustomObjectDefinition customObjectDefinition2 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				randomCustomObjectDefinition());

		CustomObjectDefinition customObjectDefinition3 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				randomCustomObjectDefinition());

		Page<CustomObjectDefinition> page1 =
			customObjectDefinitionResource.getObjectDefinitionsPage(
				null, null, null, Pagination.of(1, totalCount + 2), null);

		List<CustomObjectDefinition> customObjectDefinitions1 =
			(List<CustomObjectDefinition>)page1.getItems();

		Assert.assertEquals(
			customObjectDefinitions1.toString(), totalCount + 2,
			customObjectDefinitions1.size());

		Page<CustomObjectDefinition> page2 =
			customObjectDefinitionResource.getObjectDefinitionsPage(
				null, null, null, Pagination.of(2, totalCount + 2), null);

		Assert.assertEquals(totalCount + 3, page2.getTotalCount());

		List<CustomObjectDefinition> customObjectDefinitions2 =
			(List<CustomObjectDefinition>)page2.getItems();

		Assert.assertEquals(
			customObjectDefinitions2.toString(), 1,
			customObjectDefinitions2.size());

		Page<CustomObjectDefinition> page3 =
			customObjectDefinitionResource.getObjectDefinitionsPage(
				null, null, null, Pagination.of(1, totalCount + 3), null);

		assertContains(
			customObjectDefinition1,
			(List<CustomObjectDefinition>)page3.getItems());
		assertContains(
			customObjectDefinition2,
			(List<CustomObjectDefinition>)page3.getItems());
		assertContains(
			customObjectDefinition3,
			(List<CustomObjectDefinition>)page3.getItems());
	}

	@Test
	public void testGetObjectDefinitionsPageWithSortDateTime()
		throws Exception {

		testGetObjectDefinitionsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, customObjectDefinition1, customObjectDefinition2) -> {
				BeanTestUtil.setProperty(
					customObjectDefinition1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetObjectDefinitionsPageWithSortDouble() throws Exception {
		testGetObjectDefinitionsPageWithSort(
			EntityField.Type.DOUBLE,
			(entityField, customObjectDefinition1, customObjectDefinition2) -> {
				BeanTestUtil.setProperty(
					customObjectDefinition1, entityField.getName(), 0.1);
				BeanTestUtil.setProperty(
					customObjectDefinition2, entityField.getName(), 0.5);
			});
	}

	@Test
	public void testGetObjectDefinitionsPageWithSortInteger() throws Exception {
		testGetObjectDefinitionsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, customObjectDefinition1, customObjectDefinition2) -> {
				BeanTestUtil.setProperty(
					customObjectDefinition1, entityField.getName(), 0);
				BeanTestUtil.setProperty(
					customObjectDefinition2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetObjectDefinitionsPageWithSortString() throws Exception {
		testGetObjectDefinitionsPageWithSort(
			EntityField.Type.STRING,
			(entityField, customObjectDefinition1, customObjectDefinition2) -> {
				Class<?> clazz = customObjectDefinition1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanTestUtil.setProperty(
						customObjectDefinition1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanTestUtil.setProperty(
						customObjectDefinition2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanTestUtil.setProperty(
						customObjectDefinition1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanTestUtil.setProperty(
						customObjectDefinition2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanTestUtil.setProperty(
						customObjectDefinition1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanTestUtil.setProperty(
						customObjectDefinition2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetObjectDefinitionsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer
				<EntityField, CustomObjectDefinition, CustomObjectDefinition,
				 Exception> unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		CustomObjectDefinition customObjectDefinition1 =
			randomCustomObjectDefinition();
		CustomObjectDefinition customObjectDefinition2 =
			randomCustomObjectDefinition();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(
				entityField, customObjectDefinition1, customObjectDefinition2);
		}

		customObjectDefinition1 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				customObjectDefinition1);

		customObjectDefinition2 =
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				customObjectDefinition2);

		for (EntityField entityField : entityFields) {
			Page<CustomObjectDefinition> ascPage =
				customObjectDefinitionResource.getObjectDefinitionsPage(
					null, null, null, Pagination.of(1, 2),
					entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(customObjectDefinition1, customObjectDefinition2),
				(List<CustomObjectDefinition>)ascPage.getItems());

			Page<CustomObjectDefinition> descPage =
				customObjectDefinitionResource.getObjectDefinitionsPage(
					null, null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(customObjectDefinition2, customObjectDefinition1),
				(List<CustomObjectDefinition>)descPage.getItems());
		}
	}

	protected CustomObjectDefinition
			testGetObjectDefinitionsPage_addCustomObjectDefinition(
				CustomObjectDefinition customObjectDefinition)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected CustomObjectDefinition
			testGraphQLCustomObjectDefinition_addCustomObjectDefinition()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		CustomObjectDefinition customObjectDefinition,
		List<CustomObjectDefinition> customObjectDefinitions) {

		boolean contains = false;

		for (CustomObjectDefinition item : customObjectDefinitions) {
			if (equals(customObjectDefinition, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			customObjectDefinitions + " does not contain " +
				customObjectDefinition,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		CustomObjectDefinition customObjectDefinition1,
		CustomObjectDefinition customObjectDefinition2) {

		Assert.assertTrue(
			customObjectDefinition1 + " does not equal " +
				customObjectDefinition2,
			equals(customObjectDefinition1, customObjectDefinition2));
	}

	protected void assertEquals(
		List<CustomObjectDefinition> customObjectDefinitions1,
		List<CustomObjectDefinition> customObjectDefinitions2) {

		Assert.assertEquals(
			customObjectDefinitions1.size(), customObjectDefinitions2.size());

		for (int i = 0; i < customObjectDefinitions1.size(); i++) {
			CustomObjectDefinition customObjectDefinition1 =
				customObjectDefinitions1.get(i);
			CustomObjectDefinition customObjectDefinition2 =
				customObjectDefinitions2.get(i);

			assertEquals(customObjectDefinition1, customObjectDefinition2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<CustomObjectDefinition> customObjectDefinitions1,
		List<CustomObjectDefinition> customObjectDefinitions2) {

		Assert.assertEquals(
			customObjectDefinitions1.size(), customObjectDefinitions2.size());

		for (CustomObjectDefinition customObjectDefinition1 :
				customObjectDefinitions1) {

			boolean contains = false;

			for (CustomObjectDefinition customObjectDefinition2 :
					customObjectDefinitions2) {

				if (equals(customObjectDefinition1, customObjectDefinition2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				customObjectDefinitions2 + " does not contain " +
					customObjectDefinition1,
				contains);
		}
	}

	protected void assertValid(CustomObjectDefinition customObjectDefinition)
		throws Exception {

		boolean valid = true;

		if (customObjectDefinition.getDateCreated() == null) {
			valid = false;
		}

		if (customObjectDefinition.getDateModified() == null) {
			valid = false;
		}

		if (customObjectDefinition.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals(
					"accountEntryRestricted", additionalAssertFieldName)) {

				if (customObjectDefinition.getAccountEntryRestricted() ==
						null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"accountEntryRestrictedObjectFieldName",
					additionalAssertFieldName)) {

				if (customObjectDefinition.
						getAccountEntryRestrictedObjectFieldName() == null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (customObjectDefinition.getActions() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("active", additionalAssertFieldName)) {
				if (customObjectDefinition.getActive() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"defaultLanguageId", additionalAssertFieldName)) {

				if (customObjectDefinition.getDefaultLanguageId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"enableCategorization", additionalAssertFieldName)) {

				if (customObjectDefinition.getEnableCategorization() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("enableComments", additionalAssertFieldName)) {
				if (customObjectDefinition.getEnableComments() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"enableLocalization", additionalAssertFieldName)) {

				if (customObjectDefinition.getEnableLocalization() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"enableObjectEntryHistory", additionalAssertFieldName)) {

				if (customObjectDefinition.getEnableObjectEntryHistory() ==
						null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (customObjectDefinition.getExternalReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("label", additionalAssertFieldName)) {
				if (customObjectDefinition.getLabel() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("modifiable", additionalAssertFieldName)) {
				if (customObjectDefinition.getModifiable() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (customObjectDefinition.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("panelAppOrder", additionalAssertFieldName)) {
				if (customObjectDefinition.getPanelAppOrder() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("panelCategoryKey", additionalAssertFieldName)) {
				if (customObjectDefinition.getPanelCategoryKey() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"parameterRequired", additionalAssertFieldName)) {

				if (customObjectDefinition.getParameterRequired() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("pluralLabel", additionalAssertFieldName)) {
				if (customObjectDefinition.getPluralLabel() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("portlet", additionalAssertFieldName)) {
				if (customObjectDefinition.getPortlet() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("restContextPath", additionalAssertFieldName)) {
				if (customObjectDefinition.getRestContextPath() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("scope", additionalAssertFieldName)) {
				if (customObjectDefinition.getScope() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (customObjectDefinition.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("storageType", additionalAssertFieldName)) {
				if (customObjectDefinition.getStorageType() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("system", additionalAssertFieldName)) {
				if (customObjectDefinition.getSystem() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"titleObjectFieldName", additionalAssertFieldName)) {

				if (customObjectDefinition.getTitleObjectFieldName() == null) {
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

	protected void assertValid(Page<CustomObjectDefinition> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<CustomObjectDefinition> page,
		Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<CustomObjectDefinition> customObjectDefinitions =
			page.getItems();

		int size = customObjectDefinitions.size();

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
					com.comments.headless.dto.v1_0.CustomObjectDefinition.
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

	protected boolean equals(
		CustomObjectDefinition customObjectDefinition1,
		CustomObjectDefinition customObjectDefinition2) {

		if (customObjectDefinition1 == customObjectDefinition2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals(
					"accountEntryRestricted", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						customObjectDefinition1.getAccountEntryRestricted(),
						customObjectDefinition2.getAccountEntryRestricted())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"accountEntryRestrictedObjectFieldName",
					additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						customObjectDefinition1.
							getAccountEntryRestrictedObjectFieldName(),
						customObjectDefinition2.
							getAccountEntryRestrictedObjectFieldName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (!equals(
						(Map)customObjectDefinition1.getActions(),
						(Map)customObjectDefinition2.getActions())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("active", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getActive(),
						customObjectDefinition2.getActive())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateCreated", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getDateCreated(),
						customObjectDefinition2.getDateCreated())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateModified", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getDateModified(),
						customObjectDefinition2.getDateModified())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"defaultLanguageId", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						customObjectDefinition1.getDefaultLanguageId(),
						customObjectDefinition2.getDefaultLanguageId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"enableCategorization", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						customObjectDefinition1.getEnableCategorization(),
						customObjectDefinition2.getEnableCategorization())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("enableComments", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getEnableComments(),
						customObjectDefinition2.getEnableComments())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"enableLocalization", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						customObjectDefinition1.getEnableLocalization(),
						customObjectDefinition2.getEnableLocalization())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"enableObjectEntryHistory", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						customObjectDefinition1.getEnableObjectEntryHistory(),
						customObjectDefinition2.
							getEnableObjectEntryHistory())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"externalReferenceCode", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						customObjectDefinition1.getExternalReferenceCode(),
						customObjectDefinition2.getExternalReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getId(),
						customObjectDefinition2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("label", additionalAssertFieldName)) {
				if (!equals(
						(Map)customObjectDefinition1.getLabel(),
						(Map)customObjectDefinition2.getLabel())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("modifiable", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getModifiable(),
						customObjectDefinition2.getModifiable())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getName(),
						customObjectDefinition2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("panelAppOrder", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getPanelAppOrder(),
						customObjectDefinition2.getPanelAppOrder())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("panelCategoryKey", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getPanelCategoryKey(),
						customObjectDefinition2.getPanelCategoryKey())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"parameterRequired", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						customObjectDefinition1.getParameterRequired(),
						customObjectDefinition2.getParameterRequired())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("pluralLabel", additionalAssertFieldName)) {
				if (!equals(
						(Map)customObjectDefinition1.getPluralLabel(),
						(Map)customObjectDefinition2.getPluralLabel())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("portlet", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getPortlet(),
						customObjectDefinition2.getPortlet())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("restContextPath", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getRestContextPath(),
						customObjectDefinition2.getRestContextPath())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("scope", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getScope(),
						customObjectDefinition2.getScope())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getStatus(),
						customObjectDefinition2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("storageType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getStorageType(),
						customObjectDefinition2.getStorageType())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("system", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						customObjectDefinition1.getSystem(),
						customObjectDefinition2.getSystem())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"titleObjectFieldName", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						customObjectDefinition1.getTitleObjectFieldName(),
						customObjectDefinition2.getTitleObjectFieldName())) {

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

		if (!(_customObjectDefinitionResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_customObjectDefinitionResource;

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
		EntityField entityField, String operator,
		CustomObjectDefinition customObjectDefinition) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("accountEntryRestricted")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("accountEntryRestrictedObjectFieldName")) {
			sb.append("'");
			sb.append(
				String.valueOf(
					customObjectDefinition.
						getAccountEntryRestrictedObjectFieldName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("actions")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("active")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("dateCreated")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							customObjectDefinition.getDateCreated(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							customObjectDefinition.getDateCreated(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(
					_dateFormat.format(
						customObjectDefinition.getDateCreated()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("dateModified")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							customObjectDefinition.getDateModified(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							customObjectDefinition.getDateModified(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(
					_dateFormat.format(
						customObjectDefinition.getDateModified()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("defaultLanguageId")) {
			sb.append("'");
			sb.append(
				String.valueOf(customObjectDefinition.getDefaultLanguageId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("enableCategorization")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("enableComments")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("enableLocalization")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("enableObjectEntryHistory")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("externalReferenceCode")) {
			sb.append("'");
			sb.append(
				String.valueOf(
					customObjectDefinition.getExternalReferenceCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("label")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("modifiable")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(customObjectDefinition.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("panelAppOrder")) {
			sb.append("'");
			sb.append(
				String.valueOf(customObjectDefinition.getPanelAppOrder()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("panelCategoryKey")) {
			sb.append("'");
			sb.append(
				String.valueOf(customObjectDefinition.getPanelCategoryKey()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("parameterRequired")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("pluralLabel")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("portlet")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("restContextPath")) {
			sb.append("'");
			sb.append(
				String.valueOf(customObjectDefinition.getRestContextPath()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("scope")) {
			sb.append("'");
			sb.append(String.valueOf(customObjectDefinition.getScope()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("storageType")) {
			sb.append("'");
			sb.append(String.valueOf(customObjectDefinition.getStorageType()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("system")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("titleObjectFieldName")) {
			sb.append("'");
			sb.append(
				String.valueOf(
					customObjectDefinition.getTitleObjectFieldName()));
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

	protected CustomObjectDefinition randomCustomObjectDefinition()
		throws Exception {

		return new CustomObjectDefinition() {
			{
				accountEntryRestricted = RandomTestUtil.randomBoolean();
				accountEntryRestrictedObjectFieldName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				active = RandomTestUtil.randomBoolean();
				dateCreated = RandomTestUtil.nextDate();
				dateModified = RandomTestUtil.nextDate();
				defaultLanguageId = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				enableCategorization = RandomTestUtil.randomBoolean();
				enableComments = RandomTestUtil.randomBoolean();
				enableLocalization = RandomTestUtil.randomBoolean();
				enableObjectEntryHistory = RandomTestUtil.randomBoolean();
				externalReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				modifiable = RandomTestUtil.randomBoolean();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				panelAppOrder = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				panelCategoryKey = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				parameterRequired = RandomTestUtil.randomBoolean();
				portlet = RandomTestUtil.randomBoolean();
				restContextPath = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				scope = StringUtil.toLowerCase(RandomTestUtil.randomString());
				storageType = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				system = RandomTestUtil.randomBoolean();
				titleObjectFieldName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected CustomObjectDefinition randomIrrelevantCustomObjectDefinition()
		throws Exception {

		CustomObjectDefinition randomIrrelevantCustomObjectDefinition =
			randomCustomObjectDefinition();

		return randomIrrelevantCustomObjectDefinition;
	}

	protected CustomObjectDefinition randomPatchCustomObjectDefinition()
		throws Exception {

		return randomCustomObjectDefinition();
	}

	protected CustomObjectDefinitionResource customObjectDefinitionResource;
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
		LogFactoryUtil.getLog(BaseCustomObjectDefinitionResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.comments.headless.resource.v1_0.CustomObjectDefinitionResource
		_customObjectDefinitionResource;

}