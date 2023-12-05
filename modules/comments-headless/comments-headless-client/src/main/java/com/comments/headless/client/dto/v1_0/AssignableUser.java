package com.comments.headless.client.dto.v1_0;

import com.comments.headless.client.function.UnsafeSupplier;
import com.comments.headless.client.serdes.v1_0.AssignableUserSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author E2Software-011
 * @generated
 */
@Generated("")
public class AssignableUser implements Cloneable, Serializable {

	public static AssignableUser toDTO(String json) {
		return AssignableUserSerDes.toDTO(json);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

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

	@Override
	public AssignableUser clone() throws CloneNotSupportedException {
		return (AssignableUser)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AssignableUser)) {
			return false;
		}

		AssignableUser assignableUser = (AssignableUser)object;

		return Objects.equals(toString(), assignableUser.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return AssignableUserSerDes.toJSON(this);
	}

}