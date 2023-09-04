package com.stealthkart.headless.client.serdes.v1_0;

import com.stealthkart.headless.client.dto.v1_0.Instance;
import com.stealthkart.headless.client.json.BaseJSONParser;

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
public class InstanceSerDes {

	public static Instance toDTO(String json) {
		InstanceJSONParser instanceJSONParser = new InstanceJSONParser();

		return instanceJSONParser.parseToDTO(json);
	}

	public static Instance[] toDTOs(String json) {
		InstanceJSONParser instanceJSONParser = new InstanceJSONParser();

		return instanceJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Instance instance) {
		if (instance == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (instance.getCompanyId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"companyId\": ");

			sb.append(instance.getCompanyId());
		}

		if (instance.getEmailAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailAddress\": ");

			sb.append("\"");

			sb.append(_escape(instance.getEmailAddress()));

			sb.append("\"");
		}

		if (instance.getInstanceName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"instanceName\": ");

			sb.append("\"");

			sb.append(_escape(instance.getInstanceName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		InstanceJSONParser instanceJSONParser = new InstanceJSONParser();

		return instanceJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Instance instance) {
		if (instance == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (instance.getCompanyId() == null) {
			map.put("companyId", null);
		}
		else {
			map.put("companyId", String.valueOf(instance.getCompanyId()));
		}

		if (instance.getEmailAddress() == null) {
			map.put("emailAddress", null);
		}
		else {
			map.put("emailAddress", String.valueOf(instance.getEmailAddress()));
		}

		if (instance.getInstanceName() == null) {
			map.put("instanceName", null);
		}
		else {
			map.put("instanceName", String.valueOf(instance.getInstanceName()));
		}

		return map;
	}

	public static class InstanceJSONParser extends BaseJSONParser<Instance> {

		@Override
		protected Instance createDTO() {
			return new Instance();
		}

		@Override
		protected Instance[] createDTOArray(int size) {
			return new Instance[size];
		}

		@Override
		protected void setField(
			Instance instance, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "companyId")) {
				if (jsonParserFieldValue != null) {
					instance.setCompanyId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "emailAddress")) {
				if (jsonParserFieldValue != null) {
					instance.setEmailAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "instanceName")) {
				if (jsonParserFieldValue != null) {
					instance.setInstanceName((String)jsonParserFieldValue);
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