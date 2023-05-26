package appointments.client.serdes.v1_0;

import appointments.client.dto.v1_0.Appoinment;
import appointments.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class AppoinmentSerDes {

	public static Appoinment toDTO(String json) {
		AppoinmentJSONParser appoinmentJSONParser = new AppoinmentJSONParser();

		return appoinmentJSONParser.parseToDTO(json);
	}

	public static Appoinment[] toDTOs(String json) {
		AppoinmentJSONParser appoinmentJSONParser = new AppoinmentJSONParser();

		return appoinmentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Appoinment appoinment) {
		if (appoinment == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (appoinment.getDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(appoinment.getDate()));

			sb.append("\"");
		}

		if (appoinment.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(appoinment.getId());
		}

		if (appoinment.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(appoinment.getTitle()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AppoinmentJSONParser appoinmentJSONParser = new AppoinmentJSONParser();

		return appoinmentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Appoinment appoinment) {
		if (appoinment == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (appoinment.getDate() == null) {
			map.put("date", null);
		}
		else {
			map.put(
				"date", liferayToJSONDateFormat.format(appoinment.getDate()));
		}

		if (appoinment.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(appoinment.getId()));
		}

		if (appoinment.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(appoinment.getTitle()));
		}

		return map;
	}

	public static class AppoinmentJSONParser
		extends BaseJSONParser<Appoinment> {

		@Override
		protected Appoinment createDTO() {
			return new Appoinment();
		}

		@Override
		protected Appoinment[] createDTOArray(int size) {
			return new Appoinment[size];
		}

		@Override
		protected void setField(
			Appoinment appoinment, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "date")) {
				if (jsonParserFieldValue != null) {
					appoinment.setDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					appoinment.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					appoinment.setTitle((String)jsonParserFieldValue);
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