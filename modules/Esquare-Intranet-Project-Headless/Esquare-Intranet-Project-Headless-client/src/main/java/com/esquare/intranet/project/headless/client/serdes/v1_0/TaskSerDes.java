package com.esquare.intranet.project.headless.client.serdes.v1_0;

import com.esquare.intranet.project.headless.client.dto.v1_0.Task;
import com.esquare.intranet.project.headless.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Mahammed Seleem
 * @generated
 */
@Generated("")
public class TaskSerDes {

	public static Task toDTO(String json) {
		TaskJSONParser taskJSONParser = new TaskJSONParser();

		return taskJSONParser.parseToDTO(json);
	}

	public static Task[] toDTOs(String json) {
		TaskJSONParser taskJSONParser = new TaskJSONParser();

		return taskJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Task task) {
		if (task == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (task.getActions() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actions\": ");

			sb.append(_toJSON(task.getActions()));
		}

		if (task.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(task.getDescription()));

			sb.append("\"");
		}

		if (task.getDevelopmentTeam() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"developmentTeam\": ");

			sb.append("\"");

			sb.append(_escape(task.getDevelopmentTeam()));

			sb.append("\"");
		}

		if (task.getDevelopmentTeamIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"developmentTeamIds\": ");

			sb.append("\"");

			sb.append(_escape(task.getDevelopmentTeamIds()));

			sb.append("\"");
		}

		if (task.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(task.getId());
		}

		if (task.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(task.getName()));

			sb.append("\"");
		}

		if (task.getProjectCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectCode\": ");

			sb.append(task.getProjectCode());
		}

		if (task.getProjectId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectId\": ");

			sb.append(task.getProjectId());
		}

		if (task.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(String.valueOf(task.getStatus()));
		}

		if (task.getTaskEndDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taskEndDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(task.getTaskEndDate()));

			sb.append("\"");
		}

		if (task.getTaskStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taskStartDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(task.getTaskStartDate()));

			sb.append("\"");
		}

		if (task.getTesterTeam() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"testerTeam\": ");

			sb.append("\"");

			sb.append(_escape(task.getTesterTeam()));

			sb.append("\"");
		}

		if (task.getTesterTeamIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"testerTeamIds\": ");

			sb.append("\"");

			sb.append(_escape(task.getTesterTeamIds()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TaskJSONParser taskJSONParser = new TaskJSONParser();

		return taskJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Task task) {
		if (task == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (task.getActions() == null) {
			map.put("actions", null);
		}
		else {
			map.put("actions", String.valueOf(task.getActions()));
		}

		if (task.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(task.getDescription()));
		}

		if (task.getDevelopmentTeam() == null) {
			map.put("developmentTeam", null);
		}
		else {
			map.put(
				"developmentTeam", String.valueOf(task.getDevelopmentTeam()));
		}

		if (task.getDevelopmentTeamIds() == null) {
			map.put("developmentTeamIds", null);
		}
		else {
			map.put(
				"developmentTeamIds",
				String.valueOf(task.getDevelopmentTeamIds()));
		}

		if (task.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(task.getId()));
		}

		if (task.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(task.getName()));
		}

		if (task.getProjectCode() == null) {
			map.put("projectCode", null);
		}
		else {
			map.put("projectCode", String.valueOf(task.getProjectCode()));
		}

		if (task.getProjectId() == null) {
			map.put("projectId", null);
		}
		else {
			map.put("projectId", String.valueOf(task.getProjectId()));
		}

		if (task.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(task.getStatus()));
		}

		if (task.getTaskEndDate() == null) {
			map.put("taskEndDate", null);
		}
		else {
			map.put(
				"taskEndDate",
				liferayToJSONDateFormat.format(task.getTaskEndDate()));
		}

		if (task.getTaskStartDate() == null) {
			map.put("taskStartDate", null);
		}
		else {
			map.put(
				"taskStartDate",
				liferayToJSONDateFormat.format(task.getTaskStartDate()));
		}

		if (task.getTesterTeam() == null) {
			map.put("testerTeam", null);
		}
		else {
			map.put("testerTeam", String.valueOf(task.getTesterTeam()));
		}

		if (task.getTesterTeamIds() == null) {
			map.put("testerTeamIds", null);
		}
		else {
			map.put("testerTeamIds", String.valueOf(task.getTesterTeamIds()));
		}

		return map;
	}

	public static class TaskJSONParser extends BaseJSONParser<Task> {

		@Override
		protected Task createDTO() {
			return new Task();
		}

		@Override
		protected Task[] createDTOArray(int size) {
			return new Task[size];
		}

		@Override
		protected void setField(
			Task task, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "actions")) {
				if (jsonParserFieldValue != null) {
					task.setActions(
						(Map)TaskSerDes.toMap((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					task.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "developmentTeam")) {
				if (jsonParserFieldValue != null) {
					task.setDevelopmentTeam((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "developmentTeamIds")) {

				if (jsonParserFieldValue != null) {
					task.setDevelopmentTeamIds((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					task.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					task.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectCode")) {
				if (jsonParserFieldValue != null) {
					task.setProjectCode(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectId")) {
				if (jsonParserFieldValue != null) {
					task.setProjectId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					task.setStatus(
						StatusSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "taskEndDate")) {
				if (jsonParserFieldValue != null) {
					task.setTaskEndDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "taskStartDate")) {
				if (jsonParserFieldValue != null) {
					task.setTaskStartDate(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "testerTeam")) {
				if (jsonParserFieldValue != null) {
					task.setTesterTeam((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "testerTeamIds")) {
				if (jsonParserFieldValue != null) {
					task.setTesterTeamIds((String)jsonParserFieldValue);
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