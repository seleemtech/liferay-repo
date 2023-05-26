package CrudRest.client.serdes.v1_0;

import CrudRest.client.dto.v1_0.CrudRest;
import CrudRest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author DELL
 * @generated
 */
@Generated("")
public class CrudRestSerDes {

	public static CrudRest toDTO(String json) {
		CrudRestJSONParser crudRestJSONParser = new CrudRestJSONParser();

		return crudRestJSONParser.parseToDTO(json);
	}

	public static CrudRest[] toDTOs(String json) {
		CrudRestJSONParser crudRestJSONParser = new CrudRestJSONParser();

		return crudRestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CrudRest crudRest) {
		if (crudRest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (crudRest.getCrudId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"crudId\": ");

			sb.append(crudRest.getCrudId());
		}

		if (crudRest.getCrudName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"crudName\": ");

			sb.append("\"");

			sb.append(_escape(crudRest.getCrudName()));

			sb.append("\"");
		}

		if (crudRest.getCrudNo() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"crudNo\": ");

			sb.append(crudRest.getCrudNo());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CrudRestJSONParser crudRestJSONParser = new CrudRestJSONParser();

		return crudRestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CrudRest crudRest) {
		if (crudRest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (crudRest.getCrudId() == null) {
			map.put("crudId", null);
		}
		else {
			map.put("crudId", String.valueOf(crudRest.getCrudId()));
		}

		if (crudRest.getCrudName() == null) {
			map.put("crudName", null);
		}
		else {
			map.put("crudName", String.valueOf(crudRest.getCrudName()));
		}

		if (crudRest.getCrudNo() == null) {
			map.put("crudNo", null);
		}
		else {
			map.put("crudNo", String.valueOf(crudRest.getCrudNo()));
		}

		return map;
	}

	public static class CrudRestJSONParser extends BaseJSONParser<CrudRest> {

		@Override
		protected CrudRest createDTO() {
			return new CrudRest();
		}

		@Override
		protected CrudRest[] createDTOArray(int size) {
			return new CrudRest[size];
		}

		@Override
		protected void setField(
			CrudRest crudRest, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "crudId")) {
				if (jsonParserFieldValue != null) {
					crudRest.setCrudId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "crudName")) {
				if (jsonParserFieldValue != null) {
					crudRest.setCrudName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "crudNo")) {
				if (jsonParserFieldValue != null) {
					crudRest.setCrudNo(
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