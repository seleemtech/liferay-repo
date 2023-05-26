package CrudRest.dto.v1_0;

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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author DELL
 * @generated
 */
@Generated("")
@GraphQLName(description = "Represents appointment.", value = "CrudRest")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "CrudRest")
public class CrudRest implements Serializable {

	public static CrudRest toDTO(String json) {
		return ObjectMapperUtil.readValue(CrudRest.class, json);
	}

	public static CrudRest unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(CrudRest.class, json);
	}

	@Schema
	public Long getCrudId() {
		return crudId;
	}

	public void setCrudId(Long crudId) {
		this.crudId = crudId;
	}

	@JsonIgnore
	public void setCrudId(
		UnsafeSupplier<Long, Exception> crudIdUnsafeSupplier) {

		try {
			crudId = crudIdUnsafeSupplier.get();
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
	protected Long crudId;

	@Schema
	public String getCrudName() {
		return crudName;
	}

	public void setCrudName(String crudName) {
		this.crudName = crudName;
	}

	@JsonIgnore
	public void setCrudName(
		UnsafeSupplier<String, Exception> crudNameUnsafeSupplier) {

		try {
			crudName = crudNameUnsafeSupplier.get();
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
	protected String crudName;

	@Schema
	public Long getCrudNo() {
		return crudNo;
	}

	public void setCrudNo(Long crudNo) {
		this.crudNo = crudNo;
	}

	@JsonIgnore
	public void setCrudNo(
		UnsafeSupplier<Long, Exception> crudNoUnsafeSupplier) {

		try {
			crudNo = crudNoUnsafeSupplier.get();
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
	protected Long crudNo;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (crudId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"crudId\": ");

			sb.append(crudId);
		}

		if (crudName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"crudName\": ");

			sb.append("\"");

			sb.append(_escape(crudName));

			sb.append("\"");
		}

		if (crudNo != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"crudNo\": ");

			sb.append(crudNo);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "CrudRest.dto.v1_0.CrudRest", name = "x-class-name"
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