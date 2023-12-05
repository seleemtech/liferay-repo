package com.comments.headless.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author E2Software-011
 * @generated
 */
@Generated("")
@GraphQLName("Workflow")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Workflow")
public class Workflow implements Serializable {

	public static Workflow toDTO(String json) {
		return ObjectMapperUtil.readValue(Workflow.class, json);
	}

	public static Workflow unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Workflow.class, json);
	}

	@Schema
	public String getTaskContent() {
		return TaskContent;
	}

	public void setTaskContent(String TaskContent) {
		this.TaskContent = TaskContent;
	}

	@JsonIgnore
	public void setTaskContent(
		UnsafeSupplier<String, Exception> TaskContentUnsafeSupplier) {

		try {
			TaskContent = TaskContentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String TaskContent;

	@Schema
	@Valid
	public AssignableUser[] getAssignableUser() {
		return assignableUser;
	}

	public void setAssignableUser(AssignableUser[] assignableUser) {
		this.assignableUser = assignableUser;
	}

	@JsonIgnore
	public void setAssignableUser(
		UnsafeSupplier<AssignableUser[], Exception>
			assignableUserUnsafeSupplier) {

		try {
			assignableUser = assignableUserUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected AssignableUser[] assignableUser;

	@Schema
	public Long getAssigneeUserId() {
		return assigneeUserId;
	}

	public void setAssigneeUserId(Long assigneeUserId) {
		this.assigneeUserId = assigneeUserId;
	}

	@JsonIgnore
	public void setAssigneeUserId(
		UnsafeSupplier<Long, Exception> assigneeUserIdUnsafeSupplier) {

		try {
			assigneeUserId = assigneeUserIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long assigneeUserId;

	@Schema
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@JsonIgnore
	public void setComment(
		UnsafeSupplier<String, Exception> commentUnsafeSupplier) {

		try {
			comment = commentUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String comment;

	@Schema
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@JsonIgnore
	public void setCompanyId(
		UnsafeSupplier<Long, Exception> companyIdUnsafeSupplier) {

		try {
			companyId = companyIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long companyId;

	@Schema
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@JsonIgnore
	public void setGroupId(
		UnsafeSupplier<Long, Exception> groupIdUnsafeSupplier) {

		try {
			groupId = groupIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long groupId;

	@Schema
	public Boolean getIsAssignedToSingleUser() {
		return isAssignedToSingleUser;
	}

	public void setIsAssignedToSingleUser(Boolean isAssignedToSingleUser) {
		this.isAssignedToSingleUser = isAssignedToSingleUser;
	}

	@JsonIgnore
	public void setIsAssignedToSingleUser(
		UnsafeSupplier<Boolean, Exception>
			isAssignedToSingleUserUnsafeSupplier) {

		try {
			isAssignedToSingleUser = isAssignedToSingleUserUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean isAssignedToSingleUser;

	@Schema
	public Boolean getIsWorkflowCompleted() {
		return isWorkflowCompleted;
	}

	public void setIsWorkflowCompleted(Boolean isWorkflowCompleted) {
		this.isWorkflowCompleted = isWorkflowCompleted;
	}

	@JsonIgnore
	public void setIsWorkflowCompleted(
		UnsafeSupplier<Boolean, Exception> isWorkflowCompletedUnsafeSupplier) {

		try {
			isWorkflowCompleted = isWorkflowCompletedUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean isWorkflowCompleted;

	@Schema
	public String getTransitionName() {
		return transitionName;
	}

	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	}

	@JsonIgnore
	public void setTransitionName(
		UnsafeSupplier<String, Exception> transitionNameUnsafeSupplier) {

		try {
			transitionName = transitionNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String transitionName;

	@Schema
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@JsonIgnore
	public void setUserId(
		UnsafeSupplier<Long, Exception> userIdUnsafeSupplier) {

		try {
			userId = userIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long userId;

	@Schema
	@Valid
	public WorflowTansition[] getWorflowTansition() {
		return worflowTansition;
	}

	public void setWorflowTansition(WorflowTansition[] worflowTansition) {
		this.worflowTansition = worflowTansition;
	}

	@JsonIgnore
	public void setWorflowTansition(
		UnsafeSupplier<WorflowTansition[], Exception>
			worflowTansitionUnsafeSupplier) {

		try {
			worflowTansition = worflowTansitionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected WorflowTansition[] worflowTansition;

	@Schema
	public String getWorkflowTaskAssigneeUserName() {
		return workflowTaskAssigneeUserName;
	}

	public void setWorkflowTaskAssigneeUserName(
		String workflowTaskAssigneeUserName) {

		this.workflowTaskAssigneeUserName = workflowTaskAssigneeUserName;
	}

	@JsonIgnore
	public void setWorkflowTaskAssigneeUserName(
		UnsafeSupplier<String, Exception>
			workflowTaskAssigneeUserNameUnsafeSupplier) {

		try {
			workflowTaskAssigneeUserName =
				workflowTaskAssigneeUserNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String workflowTaskAssigneeUserName;

	@Schema
	public Long getWorkflowTaskId() {
		return workflowTaskId;
	}

	public void setWorkflowTaskId(Long workflowTaskId) {
		this.workflowTaskId = workflowTaskId;
	}

	@JsonIgnore
	public void setWorkflowTaskId(
		UnsafeSupplier<Long, Exception> workflowTaskIdUnsafeSupplier) {

		try {
			workflowTaskId = workflowTaskIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long workflowTaskId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Workflow)) {
			return false;
		}

		Workflow workflow = (Workflow)object;

		return Objects.equals(toString(), workflow.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (TaskContent != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"TaskContent\": ");

			sb.append("\"");

			sb.append(_escape(TaskContent));

			sb.append("\"");
		}

		if (assignableUser != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"assignableUser\": ");

			sb.append("[");

			for (int i = 0; i < assignableUser.length; i++) {
				sb.append(String.valueOf(assignableUser[i]));

				if ((i + 1) < assignableUser.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (assigneeUserId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"assigneeUserId\": ");

			sb.append(assigneeUserId);
		}

		if (comment != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"comment\": ");

			sb.append("\"");

			sb.append(_escape(comment));

			sb.append("\"");
		}

		if (companyId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"companyId\": ");

			sb.append(companyId);
		}

		if (groupId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupId\": ");

			sb.append(groupId);
		}

		if (isAssignedToSingleUser != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isAssignedToSingleUser\": ");

			sb.append(isAssignedToSingleUser);
		}

		if (isWorkflowCompleted != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isWorkflowCompleted\": ");

			sb.append(isWorkflowCompleted);
		}

		if (transitionName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"transitionName\": ");

			sb.append("\"");

			sb.append(_escape(transitionName));

			sb.append("\"");
		}

		if (userId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(userId);
		}

		if (worflowTansition != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"worflowTansition\": ");

			sb.append("[");

			for (int i = 0; i < worflowTansition.length; i++) {
				sb.append(String.valueOf(worflowTansition[i]));

				if ((i + 1) < worflowTansition.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (workflowTaskAssigneeUserName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"workflowTaskAssigneeUserName\": ");

			sb.append("\"");

			sb.append(_escape(workflowTaskAssigneeUserName));

			sb.append("\"");
		}

		if (workflowTaskId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"workflowTaskId\": ");

			sb.append(workflowTaskId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.comments.headless.dto.v1_0.Workflow",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}