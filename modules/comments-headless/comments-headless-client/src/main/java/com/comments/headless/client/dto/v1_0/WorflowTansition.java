package com.comments.headless.client.dto.v1_0;

import com.comments.headless.client.function.UnsafeSupplier;
import com.comments.headless.client.serdes.v1_0.WorflowTansitionSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author E2Software-011
 * @generated
 */
@Generated("")
public class WorflowTansition implements Cloneable, Serializable {

	public static WorflowTansition toDTO(String json) {
		return WorflowTansitionSerDes.toDTO(json);
	}

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

	@Override
	public WorflowTansition clone() throws CloneNotSupportedException {
		return (WorflowTansition)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorflowTansition)) {
			return false;
		}

		WorflowTansition worflowTansition = (WorflowTansition)object;

		return Objects.equals(toString(), worflowTansition.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return WorflowTansitionSerDes.toJSON(this);
	}

}