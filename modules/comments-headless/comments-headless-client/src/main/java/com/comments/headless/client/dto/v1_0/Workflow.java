package com.comments.headless.client.dto.v1_0;

import com.comments.headless.client.function.UnsafeSupplier;
import com.comments.headless.client.serdes.v1_0.WorkflowSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author E2Software-011
 * @generated
 */
@Generated("")
public class Workflow implements Cloneable, Serializable {

	public static Workflow toDTO(String json) {
		return WorkflowSerDes.toDTO(json);
	}

	public String getTaskContent() {
		return TaskContent;
	}

	public void setTaskContent(String TaskContent) {
		this.TaskContent = TaskContent;
	}

	public void setTaskContent(
		UnsafeSupplier<String, Exception> TaskContentUnsafeSupplier) {

		try {
			TaskContent = TaskContentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String TaskContent;

	public AssignableUser[] getAssignableUser() {
		return assignableUser;
	}

	public void setAssignableUser(AssignableUser[] assignableUser) {
		this.assignableUser = assignableUser;
	}

	public void setAssignableUser(
		UnsafeSupplier<AssignableUser[], Exception>
			assignableUserUnsafeSupplier) {

		try {
			assignableUser = assignableUserUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected AssignableUser[] assignableUser;

	public Long getAssigneeUserId() {
		return assigneeUserId;
	}

	public void setAssigneeUserId(Long assigneeUserId) {
		this.assigneeUserId = assigneeUserId;
	}

	public void setAssigneeUserId(
		UnsafeSupplier<Long, Exception> assigneeUserIdUnsafeSupplier) {

		try {
			assigneeUserId = assigneeUserIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long assigneeUserId;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setComment(
		UnsafeSupplier<String, Exception> commentUnsafeSupplier) {

		try {
			comment = commentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String comment;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public void setCompanyId(
		UnsafeSupplier<Long, Exception> companyIdUnsafeSupplier) {

		try {
			companyId = companyIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long companyId;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public void setGroupId(
		UnsafeSupplier<Long, Exception> groupIdUnsafeSupplier) {

		try {
			groupId = groupIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long groupId;

	public Boolean getIsAssignedToSingleUser() {
		return isAssignedToSingleUser;
	}

	public void setIsAssignedToSingleUser(Boolean isAssignedToSingleUser) {
		this.isAssignedToSingleUser = isAssignedToSingleUser;
	}

	public void setIsAssignedToSingleUser(
		UnsafeSupplier<Boolean, Exception>
			isAssignedToSingleUserUnsafeSupplier) {

		try {
			isAssignedToSingleUser = isAssignedToSingleUserUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isAssignedToSingleUser;

	public Boolean getIsWorkflowCompleted() {
		return isWorkflowCompleted;
	}

	public void setIsWorkflowCompleted(Boolean isWorkflowCompleted) {
		this.isWorkflowCompleted = isWorkflowCompleted;
	}

	public void setIsWorkflowCompleted(
		UnsafeSupplier<Boolean, Exception> isWorkflowCompletedUnsafeSupplier) {

		try {
			isWorkflowCompleted = isWorkflowCompletedUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isWorkflowCompleted;

	public String getTransitionName() {
		return transitionName;
	}

	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	}

	public void setTransitionName(
		UnsafeSupplier<String, Exception> transitionNameUnsafeSupplier) {

		try {
			transitionName = transitionNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String transitionName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserId(
		UnsafeSupplier<Long, Exception> userIdUnsafeSupplier) {

		try {
			userId = userIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long userId;

	public WorflowTansition[] getWorflowTansition() {
		return worflowTansition;
	}

	public void setWorflowTansition(WorflowTansition[] worflowTansition) {
		this.worflowTansition = worflowTansition;
	}

	public void setWorflowTansition(
		UnsafeSupplier<WorflowTansition[], Exception>
			worflowTansitionUnsafeSupplier) {

		try {
			worflowTansition = worflowTansitionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected WorflowTansition[] worflowTansition;

	public String getWorkflowTaskAssigneeUserName() {
		return workflowTaskAssigneeUserName;
	}

	public void setWorkflowTaskAssigneeUserName(
		String workflowTaskAssigneeUserName) {

		this.workflowTaskAssigneeUserName = workflowTaskAssigneeUserName;
	}

	public void setWorkflowTaskAssigneeUserName(
		UnsafeSupplier<String, Exception>
			workflowTaskAssigneeUserNameUnsafeSupplier) {

		try {
			workflowTaskAssigneeUserName =
				workflowTaskAssigneeUserNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String workflowTaskAssigneeUserName;

	public Long getWorkflowTaskId() {
		return workflowTaskId;
	}

	public void setWorkflowTaskId(Long workflowTaskId) {
		this.workflowTaskId = workflowTaskId;
	}

	public void setWorkflowTaskId(
		UnsafeSupplier<Long, Exception> workflowTaskIdUnsafeSupplier) {

		try {
			workflowTaskId = workflowTaskIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long workflowTaskId;

	@Override
	public Workflow clone() throws CloneNotSupportedException {
		return (Workflow)super.clone();
	}

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
		return WorkflowSerDes.toJSON(this);
	}

}