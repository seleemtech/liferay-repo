package com.comments.headless.client.dto.v1_0;

import com.comments.headless.client.function.UnsafeSupplier;
import com.comments.headless.client.serdes.v1_0.NotificationSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author E2Software-011
 * @generated
 */
@Generated("")
public class Notification implements Cloneable, Serializable {

	public static Notification toDTO(String json) {
		return NotificationSerDes.toDTO(json);
	}

	public Long getNotificationEventId() {
		return notificationEventId;
	}

	public void setNotificationEventId(Long notificationEventId) {
		this.notificationEventId = notificationEventId;
	}

	public void setNotificationEventId(
		UnsafeSupplier<Long, Exception> notificationEventIdUnsafeSupplier) {

		try {
			notificationEventId = notificationEventIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long notificationEventId;

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public void setNotificationMessage(
		UnsafeSupplier<String, Exception> notificationMessageUnsafeSupplier) {

		try {
			notificationMessage = notificationMessageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String notificationMessage;

	public String getNotificationTimeDiff() {
		return notificationTimeDiff;
	}

	public void setNotificationTimeDiff(String notificationTimeDiff) {
		this.notificationTimeDiff = notificationTimeDiff;
	}

	public void setNotificationTimeDiff(
		UnsafeSupplier<String, Exception> notificationTimeDiffUnsafeSupplier) {

		try {
			notificationTimeDiff = notificationTimeDiffUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String notificationTimeDiff;

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
	public Notification clone() throws CloneNotSupportedException {
		return (Notification)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Notification)) {
			return false;
		}

		Notification notification = (Notification)object;

		return Objects.equals(toString(), notification.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return NotificationSerDes.toJSON(this);
	}

}