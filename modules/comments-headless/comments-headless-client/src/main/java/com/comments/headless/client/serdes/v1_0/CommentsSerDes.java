package com.comments.headless.client.serdes.v1_0;

import com.comments.headless.client.dto.v1_0.Comments;
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
public class CommentsSerDes {

	public static Comments toDTO(String json) {
		CommentsJSONParser commentsJSONParser = new CommentsJSONParser();

		return commentsJSONParser.parseToDTO(json);
	}

	public static Comments[] toDTOs(String json) {
		CommentsJSONParser commentsJSONParser = new CommentsJSONParser();

		return commentsJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Comments comments) {
		if (comments == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (comments.getBase64Doc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"base64Doc\": ");

			sb.append("\"");

			sb.append(_escape(comments.getBase64Doc()));

			sb.append("\"");
		}

		if (comments.getCompanyId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"companyId\": ");

			sb.append(comments.getCompanyId());
		}

		if (comments.getFileName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileName\": ");

			sb.append("\"");

			sb.append(_escape(comments.getFileName()));

			sb.append("\"");
		}

		if (comments.getGroupId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(comments.getGroupId());
		}

		if (comments.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(comments.getMessage()));

			sb.append("\"");
		}

		if (comments.getObjectDefinitionId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"objectDefinitionId\": ");

			sb.append(comments.getObjectDefinitionId());
		}

		if (comments.getObjectDefinitionName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"objectDefinitionName\": ");

			sb.append("\"");

			sb.append(_escape(comments.getObjectDefinitionName()));

			sb.append("\"");
		}

		if (comments.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(String.valueOf(comments.getStatus()));
		}

		if (comments.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(comments.getUserId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CommentsJSONParser commentsJSONParser = new CommentsJSONParser();

		return commentsJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Comments comments) {
		if (comments == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (comments.getBase64Doc() == null) {
			map.put("base64Doc", null);
		}
		else {
			map.put("base64Doc", String.valueOf(comments.getBase64Doc()));
		}

		if (comments.getCompanyId() == null) {
			map.put("companyId", null);
		}
		else {
			map.put("companyId", String.valueOf(comments.getCompanyId()));
		}

		if (comments.getFileName() == null) {
			map.put("fileName", null);
		}
		else {
			map.put("fileName", String.valueOf(comments.getFileName()));
		}

		if (comments.getGroupId() == null) {
			map.put("groupId", null);
		}
		else {
			map.put("groupId", String.valueOf(comments.getGroupId()));
		}

		if (comments.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(comments.getMessage()));
		}

		if (comments.getObjectDefinitionId() == null) {
			map.put("objectDefinitionId", null);
		}
		else {
			map.put(
				"objectDefinitionId",
				String.valueOf(comments.getObjectDefinitionId()));
		}

		if (comments.getObjectDefinitionName() == null) {
			map.put("objectDefinitionName", null);
		}
		else {
			map.put(
				"objectDefinitionName",
				String.valueOf(comments.getObjectDefinitionName()));
		}

		if (comments.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(comments.getStatus()));
		}

		if (comments.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(comments.getUserId()));
		}

		return map;
	}

	public static class CommentsJSONParser extends BaseJSONParser<Comments> {

		@Override
		protected Comments createDTO() {
			return new Comments();
		}

		@Override
		protected Comments[] createDTOArray(int size) {
			return new Comments[size];
		}

		@Override
		protected void setField(
			Comments comments, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "base64Doc")) {
				if (jsonParserFieldValue != null) {
					comments.setBase64Doc((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "companyId")) {
				if (jsonParserFieldValue != null) {
					comments.setCompanyId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileName")) {
				if (jsonParserFieldValue != null) {
					comments.setFileName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupId")) {
				if (jsonParserFieldValue != null) {
					comments.setGroupId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					comments.setMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "objectDefinitionId")) {

				if (jsonParserFieldValue != null) {
					comments.setObjectDefinitionId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "objectDefinitionName")) {

				if (jsonParserFieldValue != null) {
					comments.setObjectDefinitionName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					comments.setStatus(
						StatusSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					comments.setUserId(
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