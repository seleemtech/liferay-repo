package com.comments.headless.client.serdes.v1_0;

import com.comments.headless.client.dto.v1_0.AssignableUser;
import com.comments.headless.client.dto.v1_0.WorflowTansition;
import com.comments.headless.client.dto.v1_0.Workflow;
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
public class WorkflowSerDes {

	public static Workflow toDTO(String json) {
		WorkflowJSONParser workflowJSONParser = new WorkflowJSONParser();

		return workflowJSONParser.parseToDTO(json);
	}

	public static Workflow[] toDTOs(String json) {
		WorkflowJSONParser workflowJSONParser = new WorkflowJSONParser();

		return workflowJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Workflow workflow) {
		if (workflow == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (workflow.getTaskContent() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"TaskContent\": ");

			sb.append("\"");

			sb.append(_escape(workflow.getTaskContent()));

			sb.append("\"");
		}

		if (workflow.getAssignableUser() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"assignableUser\": ");

			sb.append("[");

			for (int i = 0; i < workflow.getAssignableUser().length; i++) {
				sb.append(String.valueOf(workflow.getAssignableUser()[i]));

				if ((i + 1) < workflow.getAssignableUser().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (workflow.getAssigneeUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"assigneeUserId\": ");

			sb.append(workflow.getAssigneeUserId());
		}

		if (workflow.getComment() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"comment\": ");

			sb.append("\"");

			sb.append(_escape(workflow.getComment()));

			sb.append("\"");
		}

		if (workflow.getCompanyId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"companyId\": ");

			sb.append(workflow.getCompanyId());
		}

		if (workflow.getGroupId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(workflow.getGroupId());
		}

		if (workflow.getIsAssignedToSingleUser() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isAssignedToSingleUser\": ");

			sb.append(workflow.getIsAssignedToSingleUser());
		}

		if (workflow.getIsWorkflowCompleted() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isWorkflowCompleted\": ");

			sb.append(workflow.getIsWorkflowCompleted());
		}

		if (workflow.getTransitionName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"transitionName\": ");

			sb.append("\"");

			sb.append(_escape(workflow.getTransitionName()));

			sb.append("\"");
		}

		if (workflow.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(workflow.getUserId());
		}

		if (workflow.getWorflowTansition() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"worflowTansition\": ");

			sb.append("[");

			for (int i = 0; i < workflow.getWorflowTansition().length; i++) {
				sb.append(String.valueOf(workflow.getWorflowTansition()[i]));

				if ((i + 1) < workflow.getWorflowTansition().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (workflow.getWorkflowTaskAssigneeUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"workflowTaskAssigneeUserName\": ");

			sb.append("\"");

			sb.append(_escape(workflow.getWorkflowTaskAssigneeUserName()));

			sb.append("\"");
		}

		if (workflow.getWorkflowTaskId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"workflowTaskId\": ");

			sb.append(workflow.getWorkflowTaskId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		WorkflowJSONParser workflowJSONParser = new WorkflowJSONParser();

		return workflowJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Workflow workflow) {
		if (workflow == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (workflow.getTaskContent() == null) {
			map.put("TaskContent", null);
		}
		else {
			map.put("TaskContent", String.valueOf(workflow.getTaskContent()));
		}

		if (workflow.getAssignableUser() == null) {
			map.put("assignableUser", null);
		}
		else {
			map.put(
				"assignableUser", String.valueOf(workflow.getAssignableUser()));
		}

		if (workflow.getAssigneeUserId() == null) {
			map.put("assigneeUserId", null);
		}
		else {
			map.put(
				"assigneeUserId", String.valueOf(workflow.getAssigneeUserId()));
		}

		if (workflow.getComment() == null) {
			map.put("comment", null);
		}
		else {
			map.put("comment", String.valueOf(workflow.getComment()));
		}

		if (workflow.getCompanyId() == null) {
			map.put("companyId", null);
		}
		else {
			map.put("companyId", String.valueOf(workflow.getCompanyId()));
		}

		if (workflow.getGroupId() == null) {
			map.put("groupId", null);
		}
		else {
			map.put("groupId", String.valueOf(workflow.getGroupId()));
		}

		if (workflow.getIsAssignedToSingleUser() == null) {
			map.put("isAssignedToSingleUser", null);
		}
		else {
			map.put(
				"isAssignedToSingleUser",
				String.valueOf(workflow.getIsAssignedToSingleUser()));
		}

		if (workflow.getIsWorkflowCompleted() == null) {
			map.put("isWorkflowCompleted", null);
		}
		else {
			map.put(
				"isWorkflowCompleted",
				String.valueOf(workflow.getIsWorkflowCompleted()));
		}

		if (workflow.getTransitionName() == null) {
			map.put("transitionName", null);
		}
		else {
			map.put(
				"transitionName", String.valueOf(workflow.getTransitionName()));
		}

		if (workflow.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(workflow.getUserId()));
		}

		if (workflow.getWorflowTansition() == null) {
			map.put("worflowTansition", null);
		}
		else {
			map.put(
				"worflowTansition",
				String.valueOf(workflow.getWorflowTansition()));
		}

		if (workflow.getWorkflowTaskAssigneeUserName() == null) {
			map.put("workflowTaskAssigneeUserName", null);
		}
		else {
			map.put(
				"workflowTaskAssigneeUserName",
				String.valueOf(workflow.getWorkflowTaskAssigneeUserName()));
		}

		if (workflow.getWorkflowTaskId() == null) {
			map.put("workflowTaskId", null);
		}
		else {
			map.put(
				"workflowTaskId", String.valueOf(workflow.getWorkflowTaskId()));
		}

		return map;
	}

	public static class WorkflowJSONParser extends BaseJSONParser<Workflow> {

		@Override
		protected Workflow createDTO() {
			return new Workflow();
		}

		@Override
		protected Workflow[] createDTOArray(int size) {
			return new Workflow[size];
		}

		@Override
		protected void setField(
			Workflow workflow, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "TaskContent")) {
				if (jsonParserFieldValue != null) {
					workflow.setTaskContent((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "assignableUser")) {
				if (jsonParserFieldValue != null) {
					Object[] jsonParserFieldValues =
						(Object[])jsonParserFieldValue;

					AssignableUser[] assignableUserArray =
						new AssignableUser[jsonParserFieldValues.length];

					for (int i = 0; i < assignableUserArray.length; i++) {
						assignableUserArray[i] = AssignableUserSerDes.toDTO(
							(String)jsonParserFieldValues[i]);
					}

					workflow.setAssignableUser(assignableUserArray);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "assigneeUserId")) {
				if (jsonParserFieldValue != null) {
					workflow.setAssigneeUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "comment")) {
				if (jsonParserFieldValue != null) {
					workflow.setComment((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "companyId")) {
				if (jsonParserFieldValue != null) {
					workflow.setCompanyId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupId")) {
				if (jsonParserFieldValue != null) {
					workflow.setGroupId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "isAssignedToSingleUser")) {

				if (jsonParserFieldValue != null) {
					workflow.setIsAssignedToSingleUser(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "isWorkflowCompleted")) {

				if (jsonParserFieldValue != null) {
					workflow.setIsWorkflowCompleted(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "transitionName")) {
				if (jsonParserFieldValue != null) {
					workflow.setTransitionName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					workflow.setUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "worflowTansition")) {
				if (jsonParserFieldValue != null) {
					Object[] jsonParserFieldValues =
						(Object[])jsonParserFieldValue;

					WorflowTansition[] worflowTansitionArray =
						new WorflowTansition[jsonParserFieldValues.length];

					for (int i = 0; i < worflowTansitionArray.length; i++) {
						worflowTansitionArray[i] = WorflowTansitionSerDes.toDTO(
							(String)jsonParserFieldValues[i]);
					}

					workflow.setWorflowTansition(worflowTansitionArray);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "workflowTaskAssigneeUserName")) {

				if (jsonParserFieldValue != null) {
					workflow.setWorkflowTaskAssigneeUserName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "workflowTaskId")) {
				if (jsonParserFieldValue != null) {
					workflow.setWorkflowTaskId(
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