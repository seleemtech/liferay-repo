package com.comments.headless.client.serdes.v1_0;

import com.comments.headless.client.dto.v1_0.WorflowTansition;
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
public class WorflowTansitionSerDes {

	public static WorflowTansition toDTO(String json) {
		WorflowTansitionJSONParser worflowTansitionJSONParser =
			new WorflowTansitionJSONParser();

		return worflowTansitionJSONParser.parseToDTO(json);
	}

	public static WorflowTansition[] toDTOs(String json) {
		WorflowTansitionJSONParser worflowTansitionJSONParser =
			new WorflowTansitionJSONParser();

		return worflowTansitionJSONParser.parseToDTOs(json);
	}

	public static String toJSON(WorflowTansition worflowTansition) {
		if (worflowTansition == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (worflowTansition.getLabel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"label\": ");

			sb.append("\"");

			sb.append(_escape(worflowTansition.getLabel()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		WorflowTansitionJSONParser worflowTansitionJSONParser =
			new WorflowTansitionJSONParser();

		return worflowTansitionJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(WorflowTansition worflowTansition) {
		if (worflowTansition == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (worflowTansition.getLabel() == null) {
			map.put("label", null);
		}
		else {
			map.put("label", String.valueOf(worflowTansition.getLabel()));
		}

		return map;
	}

	public static class WorflowTansitionJSONParser
		extends BaseJSONParser<WorflowTansition> {

		@Override
		protected WorflowTansition createDTO() {
			return new WorflowTansition();
		}

		@Override
		protected WorflowTansition[] createDTOArray(int size) {
			return new WorflowTansition[size];
		}

		@Override
		protected void setField(
			WorflowTansition worflowTansition, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "label")) {
				if (jsonParserFieldValue != null) {
					worflowTansition.setLabel((String)jsonParserFieldValue);
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