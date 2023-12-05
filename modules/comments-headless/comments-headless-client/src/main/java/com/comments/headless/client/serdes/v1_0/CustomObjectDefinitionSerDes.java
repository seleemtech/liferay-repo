package com.comments.headless.client.serdes.v1_0;

import com.comments.headless.client.dto.v1_0.CustomObjectDefinition;
import com.comments.headless.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author E2Software-011
 * @generated
 */
@Generated("")
public class CustomObjectDefinitionSerDes {

	public static CustomObjectDefinition toDTO(String json) {
		CustomObjectDefinitionJSONParser customObjectDefinitionJSONParser =
			new CustomObjectDefinitionJSONParser();

		return customObjectDefinitionJSONParser.parseToDTO(json);
	}

	public static CustomObjectDefinition[] toDTOs(String json) {
		CustomObjectDefinitionJSONParser customObjectDefinitionJSONParser =
			new CustomObjectDefinitionJSONParser();

		return customObjectDefinitionJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CustomObjectDefinition customObjectDefinition) {
		if (customObjectDefinition == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (customObjectDefinition.getAccountEntryRestricted() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountEntryRestricted\": ");

			sb.append(customObjectDefinition.getAccountEntryRestricted());
		}

		if (customObjectDefinition.getAccountEntryRestrictedObjectFieldName() !=
				null) {

			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountEntryRestrictedObjectFieldName\": ");

			sb.append("\"");

			sb.append(
				_escape(
					customObjectDefinition.
						getAccountEntryRestrictedObjectFieldName()));

			sb.append("\"");
		}

		if (customObjectDefinition.getActions() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actions\": ");

			sb.append(_toJSON(customObjectDefinition.getActions()));
		}

		if (customObjectDefinition.getActive() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"active\": ");

			sb.append(customObjectDefinition.getActive());
		}

		if (customObjectDefinition.getDateCreated() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateCreated\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					customObjectDefinition.getDateCreated()));

			sb.append("\"");
		}

		if (customObjectDefinition.getDateModified() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateModified\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					customObjectDefinition.getDateModified()));

			sb.append("\"");
		}

		if (customObjectDefinition.getDefaultLanguageId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"defaultLanguageId\": ");

			sb.append("\"");

			sb.append(_escape(customObjectDefinition.getDefaultLanguageId()));

			sb.append("\"");
		}

		if (customObjectDefinition.getEnableCategorization() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"enableCategorization\": ");

			sb.append(customObjectDefinition.getEnableCategorization());
		}

		if (customObjectDefinition.getEnableComments() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"enableComments\": ");

			sb.append(customObjectDefinition.getEnableComments());
		}

		if (customObjectDefinition.getEnableLocalization() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"enableLocalization\": ");

			sb.append(customObjectDefinition.getEnableLocalization());
		}

		if (customObjectDefinition.getEnableObjectEntryHistory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"enableObjectEntryHistory\": ");

			sb.append(customObjectDefinition.getEnableObjectEntryHistory());
		}

		if (customObjectDefinition.getExternalReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"externalReferenceCode\": ");

			sb.append("\"");

			sb.append(
				_escape(customObjectDefinition.getExternalReferenceCode()));

			sb.append("\"");
		}

		if (customObjectDefinition.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(customObjectDefinition.getId());
		}

		if (customObjectDefinition.getLabel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"label\": ");

			sb.append(_toJSON(customObjectDefinition.getLabel()));
		}

		if (customObjectDefinition.getModifiable() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiable\": ");

			sb.append(customObjectDefinition.getModifiable());
		}

		if (customObjectDefinition.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(customObjectDefinition.getName()));

			sb.append("\"");
		}

		if (customObjectDefinition.getPanelAppOrder() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"panelAppOrder\": ");

			sb.append("\"");

			sb.append(_escape(customObjectDefinition.getPanelAppOrder()));

			sb.append("\"");
		}

		if (customObjectDefinition.getPanelCategoryKey() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"panelCategoryKey\": ");

			sb.append("\"");

			sb.append(_escape(customObjectDefinition.getPanelCategoryKey()));

			sb.append("\"");
		}

		if (customObjectDefinition.getParameterRequired() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"parameterRequired\": ");

			sb.append(customObjectDefinition.getParameterRequired());
		}

		if (customObjectDefinition.getPluralLabel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pluralLabel\": ");

			sb.append(_toJSON(customObjectDefinition.getPluralLabel()));
		}

		if (customObjectDefinition.getPortlet() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"portlet\": ");

			sb.append(customObjectDefinition.getPortlet());
		}

		if (customObjectDefinition.getRestContextPath() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"restContextPath\": ");

			sb.append("\"");

			sb.append(_escape(customObjectDefinition.getRestContextPath()));

			sb.append("\"");
		}

		if (customObjectDefinition.getScope() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"scope\": ");

			sb.append("\"");

			sb.append(_escape(customObjectDefinition.getScope()));

			sb.append("\"");
		}

		if (customObjectDefinition.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(String.valueOf(customObjectDefinition.getStatus()));
		}

		if (customObjectDefinition.getStorageType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"storageType\": ");

			sb.append("\"");

			sb.append(_escape(customObjectDefinition.getStorageType()));

			sb.append("\"");
		}

		if (customObjectDefinition.getSystem() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"system\": ");

			sb.append(customObjectDefinition.getSystem());
		}

		if (customObjectDefinition.getTitleObjectFieldName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"titleObjectFieldName\": ");

			sb.append("\"");

			sb.append(
				_escape(customObjectDefinition.getTitleObjectFieldName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CustomObjectDefinitionJSONParser customObjectDefinitionJSONParser =
			new CustomObjectDefinitionJSONParser();

		return customObjectDefinitionJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		CustomObjectDefinition customObjectDefinition) {

		if (customObjectDefinition == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (customObjectDefinition.getAccountEntryRestricted() == null) {
			map.put("accountEntryRestricted", null);
		}
		else {
			map.put(
				"accountEntryRestricted",
				String.valueOf(
					customObjectDefinition.getAccountEntryRestricted()));
		}

		if (customObjectDefinition.getAccountEntryRestrictedObjectFieldName() ==
				null) {

			map.put("accountEntryRestrictedObjectFieldName", null);
		}
		else {
			map.put(
				"accountEntryRestrictedObjectFieldName",
				String.valueOf(
					customObjectDefinition.
						getAccountEntryRestrictedObjectFieldName()));
		}

		if (customObjectDefinition.getActions() == null) {
			map.put("actions", null);
		}
		else {
			map.put(
				"actions", String.valueOf(customObjectDefinition.getActions()));
		}

		if (customObjectDefinition.getActive() == null) {
			map.put("active", null);
		}
		else {
			map.put(
				"active", String.valueOf(customObjectDefinition.getActive()));
		}

		if (customObjectDefinition.getDateCreated() == null) {
			map.put("dateCreated", null);
		}
		else {
			map.put(
				"dateCreated",
				liferayToJSONDateFormat.format(
					customObjectDefinition.getDateCreated()));
		}

		if (customObjectDefinition.getDateModified() == null) {
			map.put("dateModified", null);
		}
		else {
			map.put(
				"dateModified",
				liferayToJSONDateFormat.format(
					customObjectDefinition.getDateModified()));
		}

		if (customObjectDefinition.getDefaultLanguageId() == null) {
			map.put("defaultLanguageId", null);
		}
		else {
			map.put(
				"defaultLanguageId",
				String.valueOf(customObjectDefinition.getDefaultLanguageId()));
		}

		if (customObjectDefinition.getEnableCategorization() == null) {
			map.put("enableCategorization", null);
		}
		else {
			map.put(
				"enableCategorization",
				String.valueOf(
					customObjectDefinition.getEnableCategorization()));
		}

		if (customObjectDefinition.getEnableComments() == null) {
			map.put("enableComments", null);
		}
		else {
			map.put(
				"enableComments",
				String.valueOf(customObjectDefinition.getEnableComments()));
		}

		if (customObjectDefinition.getEnableLocalization() == null) {
			map.put("enableLocalization", null);
		}
		else {
			map.put(
				"enableLocalization",
				String.valueOf(customObjectDefinition.getEnableLocalization()));
		}

		if (customObjectDefinition.getEnableObjectEntryHistory() == null) {
			map.put("enableObjectEntryHistory", null);
		}
		else {
			map.put(
				"enableObjectEntryHistory",
				String.valueOf(
					customObjectDefinition.getEnableObjectEntryHistory()));
		}

		if (customObjectDefinition.getExternalReferenceCode() == null) {
			map.put("externalReferenceCode", null);
		}
		else {
			map.put(
				"externalReferenceCode",
				String.valueOf(
					customObjectDefinition.getExternalReferenceCode()));
		}

		if (customObjectDefinition.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(customObjectDefinition.getId()));
		}

		if (customObjectDefinition.getLabel() == null) {
			map.put("label", null);
		}
		else {
			map.put("label", String.valueOf(customObjectDefinition.getLabel()));
		}

		if (customObjectDefinition.getModifiable() == null) {
			map.put("modifiable", null);
		}
		else {
			map.put(
				"modifiable",
				String.valueOf(customObjectDefinition.getModifiable()));
		}

		if (customObjectDefinition.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(customObjectDefinition.getName()));
		}

		if (customObjectDefinition.getPanelAppOrder() == null) {
			map.put("panelAppOrder", null);
		}
		else {
			map.put(
				"panelAppOrder",
				String.valueOf(customObjectDefinition.getPanelAppOrder()));
		}

		if (customObjectDefinition.getPanelCategoryKey() == null) {
			map.put("panelCategoryKey", null);
		}
		else {
			map.put(
				"panelCategoryKey",
				String.valueOf(customObjectDefinition.getPanelCategoryKey()));
		}

		if (customObjectDefinition.getParameterRequired() == null) {
			map.put("parameterRequired", null);
		}
		else {
			map.put(
				"parameterRequired",
				String.valueOf(customObjectDefinition.getParameterRequired()));
		}

		if (customObjectDefinition.getPluralLabel() == null) {
			map.put("pluralLabel", null);
		}
		else {
			map.put(
				"pluralLabel",
				String.valueOf(customObjectDefinition.getPluralLabel()));
		}

		if (customObjectDefinition.getPortlet() == null) {
			map.put("portlet", null);
		}
		else {
			map.put(
				"portlet", String.valueOf(customObjectDefinition.getPortlet()));
		}

		if (customObjectDefinition.getRestContextPath() == null) {
			map.put("restContextPath", null);
		}
		else {
			map.put(
				"restContextPath",
				String.valueOf(customObjectDefinition.getRestContextPath()));
		}

		if (customObjectDefinition.getScope() == null) {
			map.put("scope", null);
		}
		else {
			map.put("scope", String.valueOf(customObjectDefinition.getScope()));
		}

		if (customObjectDefinition.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put(
				"status", String.valueOf(customObjectDefinition.getStatus()));
		}

		if (customObjectDefinition.getStorageType() == null) {
			map.put("storageType", null);
		}
		else {
			map.put(
				"storageType",
				String.valueOf(customObjectDefinition.getStorageType()));
		}

		if (customObjectDefinition.getSystem() == null) {
			map.put("system", null);
		}
		else {
			map.put(
				"system", String.valueOf(customObjectDefinition.getSystem()));
		}

		if (customObjectDefinition.getTitleObjectFieldName() == null) {
			map.put("titleObjectFieldName", null);
		}
		else {
			map.put(
				"titleObjectFieldName",
				String.valueOf(
					customObjectDefinition.getTitleObjectFieldName()));
		}

		return map;
	}

	public static class CustomObjectDefinitionJSONParser
		extends BaseJSONParser<CustomObjectDefinition> {

		@Override
		protected CustomObjectDefinition createDTO() {
			return new CustomObjectDefinition();
		}

		@Override
		protected CustomObjectDefinition[] createDTOArray(int size) {
			return new CustomObjectDefinition[size];
		}

		@Override
		protected void setField(
			CustomObjectDefinition customObjectDefinition,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accountEntryRestricted")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setAccountEntryRestricted(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName,
						"accountEntryRestrictedObjectFieldName")) {

				if (jsonParserFieldValue != null) {
					customObjectDefinition.
						setAccountEntryRestrictedObjectFieldName(
							(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "actions")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setActions(
						(Map)CustomObjectDefinitionSerDes.toMap(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "active")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setActive(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateCreated")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setDateCreated(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateModified")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setDateModified(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "defaultLanguageId")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setDefaultLanguageId(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "enableCategorization")) {

				if (jsonParserFieldValue != null) {
					customObjectDefinition.setEnableCategorization(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "enableComments")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setEnableComments(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "enableLocalization")) {

				if (jsonParserFieldValue != null) {
					customObjectDefinition.setEnableLocalization(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "enableObjectEntryHistory")) {

				if (jsonParserFieldValue != null) {
					customObjectDefinition.setEnableObjectEntryHistory(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "externalReferenceCode")) {

				if (jsonParserFieldValue != null) {
					customObjectDefinition.setExternalReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "label")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setLabel(
						(Map)CustomObjectDefinitionSerDes.toMap(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "modifiable")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setModifiable(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "panelAppOrder")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setPanelAppOrder(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "panelCategoryKey")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setPanelCategoryKey(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "parameterRequired")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setParameterRequired(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "pluralLabel")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setPluralLabel(
						(Map)CustomObjectDefinitionSerDes.toMap(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "portlet")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setPortlet(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "restContextPath")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setRestContextPath(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "scope")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setScope(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setStatus(
						StatusSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "storageType")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setStorageType(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "system")) {
				if (jsonParserFieldValue != null) {
					customObjectDefinition.setSystem(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "titleObjectFieldName")) {

				if (jsonParserFieldValue != null) {
					customObjectDefinition.setTitleObjectFieldName(
						(String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}