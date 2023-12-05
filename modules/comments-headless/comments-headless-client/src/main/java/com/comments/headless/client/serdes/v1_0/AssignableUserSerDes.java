package com.comments.headless.client.serdes.v1_0;

import com.comments.headless.client.dto.v1_0.AssignableUser;
import com.comments.headless.client.json.BaseJSONParser;

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
public class AssignableUserSerDes {

	public static AssignableUser toDTO(String json) {
		AssignableUserJSONParser assignableUserJSONParser =
			new AssignableUserJSONParser();

		return assignableUserJSONParser.parseToDTO(json);
	}

	public static AssignableUser[] toDTOs(String json) {
		AssignableUserJSONParser assignableUserJSONParser =
			new AssignableUserJSONParser();

		return assignableUserJSONParser.parseToDTOs(json);
	}

	public static String toJSON(AssignableUser assignableUser) {
		if (assignableUser == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (assignableUser.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(assignableUser.getName()));

			sb.append("\"");
		}

		if (assignableUser.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(assignableUser.getUserId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AssignableUserJSONParser assignableUserJSONParser =
			new AssignableUserJSONParser();

		return assignableUserJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(AssignableUser assignableUser) {
		if (assignableUser == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (assignableUser.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(assignableUser.getName()));
		}

		if (assignableUser.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(assignableUser.getUserId()));
		}

		return map;
	}

	public static class AssignableUserJSONParser
		extends BaseJSONParser<AssignableUser> {

		@Override
		protected AssignableUser createDTO() {
			return new AssignableUser();
		}

		@Override
		protected AssignableUser[] createDTOArray(int size) {
			return new AssignableUser[size];
		}

		@Override
		protected void setField(
			AssignableUser assignableUser, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					assignableUser.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					assignableUser.setUserId(
						Long.valueOf((String)jsonParserFieldValue));
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