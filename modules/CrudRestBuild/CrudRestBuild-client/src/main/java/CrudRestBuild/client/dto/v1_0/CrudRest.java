package CrudRestBuild.client.dto.v1_0;

import CrudRestBuild.client.function.UnsafeSupplier;
import CrudRestBuild.client.serdes.v1_0.CrudRestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author DELL
 * @generated
 */
@Generated("")
public class CrudRest implements Cloneable, Serializable {

	public static CrudRest toDTO(String json) {
		return CrudRestSerDes.toDTO(json);
	}

	public Long getCrudId() {
		return crudId;
	}

	public void setCrudId(Long crudId) {
		this.crudId = crudId;
	}

	public void setCrudId(
		UnsafeSupplier<Long, Exception> crudIdUnsafeSupplier) {

		try {
			crudId = crudIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long crudId;

	public String getCrudName() {
		return crudName;
	}

	public void setCrudName(String crudName) {
		this.crudName = crudName;
	}

	public void setCrudName(
		UnsafeSupplier<String, Exception> crudNameUnsafeSupplier) {

		try {
			crudName = crudNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String crudName;

	public Long getCrudNo() {
		return crudNo;
	}

	public void setCrudNo(Long crudNo) {
		this.crudNo = crudNo;
	}

	public void setCrudNo(
		UnsafeSupplier<Long, Exception> crudNoUnsafeSupplier) {

		try {
			crudNo = crudNoUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long crudNo;

	@Override
	public CrudRest clone() throws CloneNotSupportedException {
		return (CrudRest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CrudRest)) {
			return false;
		}

		CrudRest crudRest = (CrudRest)object;

		return Objects.equals(toString(), crudRest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CrudRestSerDes.toJSON(this);
	}

}