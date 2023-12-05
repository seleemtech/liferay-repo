package com.esquare.intranet.project.headless.client.serdes.v1_0;

import com.esquare.intranet.project.headless.client.dto.v1_0.Project;
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
public class ProjectSerDes {

	public static Project toDTO(String json) {
		ProjectJSONParser projectJSONParser = new ProjectJSONParser();

		return projectJSONParser.parseToDTO(json);
	}

	public static Project[] toDTOs(String json) {
		ProjectJSONParser projectJSONParser = new ProjectJSONParser();

		return projectJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Project project) {
		if (project == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (project.getActions() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actions\": ");

			sb.append(_toJSON(project.getActions()));
		}

		if (project.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append(project.getCode());
		}

		if (project.getConfirmedDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"confirmedDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(project.getConfirmedDate()));

			sb.append("\"");
		}

		if (project.getContactEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contactEmail\": ");

			sb.append("\"");

			sb.append(_escape(project.getContactEmail()));

			sb.append("\"");
		}

		if (project.getContactNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contactNumber\": ");

			sb.append("\"");

			sb.append(_escape(project.getContactNumber()));

			sb.append("\"");
		}

		if (project.getDeliveryLead() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"deliveryLead\": ");

			sb.append("\"");

			sb.append(_escape(project.getDeliveryLead()));

			sb.append("\"");
		}

		if (project.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(project.getDescription()));

			sb.append("\"");
		}

		if (project.getDevelopmentStartDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"developmentStartDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					project.getDevelopmentStartDate()));

			sb.append("\"");
		}

		if (project.getDlId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dlId\": ");

			sb.append(project.getDlId());
		}

		if (project.getDurationDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"durationDate\": ");

			sb.append("\"");

			sb.append(_escape(project.getDurationDate()));

			sb.append("\"");
		}

		if (project.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(project.getId());
		}

		if (project.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(project.getName()));

			sb.append("\"");
		}

		if (project.getOlId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"olId\": ");

			sb.append(project.getOlId());
		}

		if (project.getOperationLead() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"operationLead\": ");

			sb.append("\"");

			sb.append(_escape(project.getOperationLead()));

			sb.append("\"");
		}

		if (project.getPmId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pmId\": ");

			sb.append(project.getPmId());
		}

		if (project.getProjectManager() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectManager\": ");

			sb.append("\"");

			sb.append(_escape(project.getProjectManager()));

			sb.append("\"");
		}

		if (project.getProjectName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectName\": ");

			sb.append("\"");

			sb.append(_escape(project.getProjectName()));

			sb.append("\"");
		}

		if (project.getProjectQaLead() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectQaLead\": ");

			sb.append("\"");

			sb.append(_escape(project.getProjectQaLead()));

			sb.append("\"");
		}

		if (project.getProposedDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"proposedDate\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(project.getProposedDate()));

			sb.append("\"");
		}

		if (project.getQlId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"qlId\": ");

			sb.append(project.getQlId());
		}

		if (project.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(String.valueOf(project.getStatus()));
		}

		if (project.getStatusCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusCode\": ");

			sb.append(project.getStatusCode());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProjectJSONParser projectJSONParser = new ProjectJSONParser();

		return projectJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Project project) {
		if (project == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (project.getActions() == null) {
			map.put("actions", null);
		}
		else {
			map.put("actions", String.valueOf(project.getActions()));
		}

		if (project.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(project.getCode()));
		}

		if (project.getConfirmedDate() == null) {
			map.put("confirmedDate", null);
		}
		else {
			map.put(
				"confirmedDate",
				liferayToJSONDateFormat.format(project.getConfirmedDate()));
		}

		if (project.getContactEmail() == null) {
			map.put("contactEmail", null);
		}
		else {
			map.put("contactEmail", String.valueOf(project.getContactEmail()));
		}

		if (project.getContactNumber() == null) {
			map.put("contactNumber", null);
		}
		else {
			map.put(
				"contactNumber", String.valueOf(project.getContactNumber()));
		}

		if (project.getDeliveryLead() == null) {
			map.put("deliveryLead", null);
		}
		else {
			map.put("deliveryLead", String.valueOf(project.getDeliveryLead()));
		}

		if (project.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(project.getDescription()));
		}

		if (project.getDevelopmentStartDate() == null) {
			map.put("developmentStartDate", null);
		}
		else {
			map.put(
				"developmentStartDate",
				liferayToJSONDateFormat.format(
					project.getDevelopmentStartDate()));
		}

		if (project.getDlId() == null) {
			map.put("dlId", null);
		}
		else {
			map.put("dlId", String.valueOf(project.getDlId()));
		}

		if (project.getDurationDate() == null) {
			map.put("durationDate", null);
		}
		else {
			map.put("durationDate", String.valueOf(project.getDurationDate()));
		}

		if (project.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(project.getId()));
		}

		if (project.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(project.getName()));
		}

		if (project.getOlId() == null) {
			map.put("olId", null);
		}
		else {
			map.put("olId", String.valueOf(project.getOlId()));
		}

		if (project.getOperationLead() == null) {
			map.put("operationLead", null);
		}
		else {
			map.put(
				"operationLead", String.valueOf(project.getOperationLead()));
		}

		if (project.getPmId() == null) {
			map.put("pmId", null);
		}
		else {
			map.put("pmId", String.valueOf(project.getPmId()));
		}

		if (project.getProjectManager() == null) {
			map.put("projectManager", null);
		}
		else {
			map.put(
				"projectManager", String.valueOf(project.getProjectManager()));
		}

		if (project.getProjectName() == null) {
			map.put("projectName", null);
		}
		else {
			map.put("projectName", String.valueOf(project.getProjectName()));
		}

		if (project.getProjectQaLead() == null) {
			map.put("projectQaLead", null);
		}
		else {
			map.put(
				"projectQaLead", String.valueOf(project.getProjectQaLead()));
		}

		if (project.getProposedDate() == null) {
			map.put("proposedDate", null);
		}
		else {
			map.put(
				"proposedDate",
				liferayToJSONDateFormat.format(project.getProposedDate()));
		}

		if (project.getQlId() == null) {
			map.put("qlId", null);
		}
		else {
			map.put("qlId", String.valueOf(project.getQlId()));
		}

		if (project.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(project.getStatus()));
		}

		if (project.getStatusCode() == null) {
			map.put("statusCode", null);
		}
		else {
			map.put("statusCode", String.valueOf(project.getStatusCode()));
		}

		return map;
	}

	public static class ProjectJSONParser extends BaseJSONParser<Project> {

		@Override
		protected Project createDTO() {
			return new Project();
		}

		@Override
		protected Project[] createDTOArray(int size) {
			return new Project[size];
		}

		@Override
		protected void setField(
			Project project, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "actions")) {
				if (jsonParserFieldValue != null) {
					project.setActions(
						(Map)ProjectSerDes.toMap((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					project.setCode(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "confirmedDate")) {
				if (jsonParserFieldValue != null) {
					project.setConfirmedDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "contactEmail")) {
				if (jsonParserFieldValue != null) {
					project.setContactEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "contactNumber")) {
				if (jsonParserFieldValue != null) {
					project.setContactNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "deliveryLead")) {
				if (jsonParserFieldValue != null) {
					project.setDeliveryLead((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					project.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "developmentStartDate")) {

				if (jsonParserFieldValue != null) {
					project.setDevelopmentStartDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dlId")) {
				if (jsonParserFieldValue != null) {
					project.setDlId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "durationDate")) {
				if (jsonParserFieldValue != null) {
					project.setDurationDate((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					project.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					project.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "olId")) {
				if (jsonParserFieldValue != null) {
					project.setOlId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "operationLead")) {
				if (jsonParserFieldValue != null) {
					project.setOperationLead((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "pmId")) {
				if (jsonParserFieldValue != null) {
					project.setPmId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectManager")) {
				if (jsonParserFieldValue != null) {
					project.setProjectManager((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectName")) {
				if (jsonParserFieldValue != null) {
					project.setProjectName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "projectQaLead")) {
				if (jsonParserFieldValue != null) {
					project.setProjectQaLead((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "proposedDate")) {
				if (jsonParserFieldValue != null) {
					project.setProposedDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "qlId")) {
				if (jsonParserFieldValue != null) {
					project.setQlId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					project.setStatus(
						StatusSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statusCode")) {
				if (jsonParserFieldValue != null) {
					project.setStatusCode(
						Integer.valueOf((String)jsonParserFieldValue));
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