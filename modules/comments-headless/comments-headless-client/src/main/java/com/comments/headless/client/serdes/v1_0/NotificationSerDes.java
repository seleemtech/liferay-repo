package com.comments.headless.client.serdes.v1_0;

import com.comments.headless.client.dto.v1_0.Notification;
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
public class NotificationSerDes {

	public static Notification toDTO(String json) {
		NotificationJSONParser notificationJSONParser =
			new NotificationJSONParser();

		return notificationJSONParser.parseToDTO(json);
	}

	public static Notification[] toDTOs(String json) {
		NotificationJSONParser notificationJSONParser =
			new NotificationJSONParser();

		return notificationJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Notification notification) {
		if (notification == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (notification.getNotificationEventId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"notificationEventId\": ");

			sb.append(notification.getNotificationEventId());
		}

		if (notification.getNotificationMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"notificationMessage\": ");

			sb.append("\"");

			sb.append(_escape(notification.getNotificationMessage()));

			sb.append("\"");
		}

		if (notification.getNotificationTimeDiff() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"notificationTimeDiff\": ");

			sb.append("\"");

			sb.append(_escape(notification.getNotificationTimeDiff()));

			sb.append("\"");
		}

		if (notification.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(notification.getUserId());
		}

		if (notification.getWorkflowTaskId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"workflowTaskId\": ");

			sb.append(notification.getWorkflowTaskId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		NotificationJSONParser notificationJSONParser =
			new NotificationJSONParser();

		return notificationJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Notification notification) {
		if (notification == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (notification.getNotificationEventId() == null) {
			map.put("notificationEventId", null);
		}
		else {
			map.put(
				"notificationEventId",
				String.valueOf(notification.getNotificationEventId()));
		}

		if (notification.getNotificationMessage() == null) {
			map.put("notificationMessage", null);
		}
		else {
			map.put(
				"notificationMessage",
				String.valueOf(notification.getNotificationMessage()));
		}

		if (notification.getNotificationTimeDiff() == null) {
			map.put("notificationTimeDiff", null);
		}
		else {
			map.put(
				"notificationTimeDiff",
				String.valueOf(notification.getNotificationTimeDiff()));
		}

		if (notification.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(notification.getUserId()));
		}

		if (notification.getWorkflowTaskId() == null) {
			map.put("workflowTaskId", null);
		}
		else {
			map.put(
				"workflowTaskId",
				String.valueOf(notification.getWorkflowTaskId()));
		}

		return map;
	}

	public static class NotificationJSONParser
		extends BaseJSONParser<Notification> {

		@Override
		protected Notification createDTO() {
			return new Notification();
		}

		@Override
		protected Notification[] createDTOArray(int size) {
			return new Notification[size];
		}

		@Override
		protected void setField(
			Notification notification, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "notificationEventId")) {
				if (jsonParserFieldValue != null) {
					notification.setNotificationEventId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "notificationMessage")) {

				if (jsonParserFieldValue != null) {
					notification.setNotificationMessage(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "notificationTimeDiff")) {

				if (jsonParserFieldValue != null) {
					notification.setNotificationTimeDiff(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					notification.setUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "workflowTaskId")) {
				if (jsonParserFieldValue != null) {
					notification.setWorkflowTaskId(
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