package com.esquare.intranet.project.headless.client.dto.v1_0;

import com.esquare.intranet.project.headless.client.function.UnsafeSupplier;
import com.esquare.intranet.project.headless.client.serdes.v1_0.StatusSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Mahammed Seleem
 * @generated
 */
@Generated("")
public class Status implements Cloneable, Serializable {

	public static Status toDTO(String json) {
		return StatusSerDes.toDTO(json);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setCode(UnsafeSupplier<Integer, Exception> codeUnsafeSupplier) {
		try {
			code = codeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer code;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setLabel(
		UnsafeSupplier<String, Exception> labelUnsafeSupplier) {

		try {
			label = labelUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String label;

	public String getLabel_i18n() {
		return label_i18n;
	}

	public void setLabel_i18n(String label_i18n) {
		this.label_i18n = label_i18n;
	}

	public void setLabel_i18n(
		UnsafeSupplier<String, Exception> label_i18nUnsafeSupplier) {

		try {
			label_i18n = label_i18nUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String label_i18n;

	@Override
	public Status clone() throws CloneNotSupportedException {
		return (Status)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Status)) {
			return false;
		}

		Status status = (Status)object;

		return Objects.equals(toString(), status.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return StatusSerDes.toJSON(this);
	}

}