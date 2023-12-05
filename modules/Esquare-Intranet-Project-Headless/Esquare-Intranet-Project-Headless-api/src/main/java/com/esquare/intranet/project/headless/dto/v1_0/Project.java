package com.esquare.intranet.project.headless.dto.v1_0;

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mahammed Seleem
 * @generated
 */
@Generated("")
@GraphQLName("Project")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Project")
public class Project implements Serializable {

	public static Project toDTO(String json) {
		return ObjectMapperUtil.readValue(Project.class, json);
	}

	public static Project unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Project.class, json);
	}

	@Schema
	@Valid
	public Map<String, Map<String, String>> getActions() {
		return actions;
	}

	public void setActions(Map<String, Map<String, String>> actions) {
		this.actions = actions;
	}

	@JsonIgnore
	public void setActions(
		UnsafeSupplier<Map<String, Map<String, String>>, Exception>
			actionsUnsafeSupplier) {

		try {
			actions = actionsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Map<String, Map<String, String>> actions;

	@Schema
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@JsonIgnore
	public void setCode(UnsafeSupplier<Integer, Exception> codeUnsafeSupplier) {
		try {
			code = codeUnsafeSupplier.get();
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
	protected Integer code;

	@Schema
	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	@JsonIgnore
	public void setConfirmedDate(
		UnsafeSupplier<Date, Exception> confirmedDateUnsafeSupplier) {

		try {
			confirmedDate = confirmedDateUnsafeSupplier.get();
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
	protected Date confirmedDate;

	@Schema
	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@JsonIgnore
	public void setContactEmail(
		UnsafeSupplier<String, Exception> contactEmailUnsafeSupplier) {

		try {
			contactEmail = contactEmailUnsafeSupplier.get();
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
	protected String contactEmail;

	@Schema
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@JsonIgnore
	public void setContactNumber(
		UnsafeSupplier<String, Exception> contactNumberUnsafeSupplier) {

		try {
			contactNumber = contactNumberUnsafeSupplier.get();
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
	protected String contactNumber;

	@Schema
	public String getDeliveryLead() {
		return deliveryLead;
	}

	public void setDeliveryLead(String deliveryLead) {
		this.deliveryLead = deliveryLead;
	}

	@JsonIgnore
	public void setDeliveryLead(
		UnsafeSupplier<String, Exception> deliveryLeadUnsafeSupplier) {

		try {
			deliveryLead = deliveryLeadUnsafeSupplier.get();
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
	protected String deliveryLead;

	@Schema
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
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
	protected String description;

	@Schema
	public Date getDevelopmentStartDate() {
		return developmentStartDate;
	}

	public void setDevelopmentStartDate(Date developmentStartDate) {
		this.developmentStartDate = developmentStartDate;
	}

	@JsonIgnore
	public void setDevelopmentStartDate(
		UnsafeSupplier<Date, Exception> developmentStartDateUnsafeSupplier) {

		try {
			developmentStartDate = developmentStartDateUnsafeSupplier.get();
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
	protected Date developmentStartDate;

	@Schema
	public Long getDlId() {
		return dlId;
	}

	public void setDlId(Long dlId) {
		this.dlId = dlId;
	}

	@JsonIgnore
	public void setDlId(UnsafeSupplier<Long, Exception> dlIdUnsafeSupplier) {
		try {
			dlId = dlIdUnsafeSupplier.get();
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
	protected Long dlId;

	@Schema
	public String getDurationDate() {
		return durationDate;
	}

	public void setDurationDate(String durationDate) {
		this.durationDate = durationDate;
	}

	@JsonIgnore
	public void setDurationDate(
		UnsafeSupplier<String, Exception> durationDateUnsafeSupplier) {

		try {
			durationDate = durationDateUnsafeSupplier.get();
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
	protected String durationDate;

	@Schema
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
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
	protected Long id;

	@Schema(description = "The client name.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The client name.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String name;

	@Schema
	public Long getOlId() {
		return olId;
	}

	public void setOlId(Long olId) {
		this.olId = olId;
	}

	@JsonIgnore
	public void setOlId(UnsafeSupplier<Long, Exception> olIdUnsafeSupplier) {
		try {
			olId = olIdUnsafeSupplier.get();
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
	protected Long olId;

	@Schema
	public String getOperationLead() {
		return operationLead;
	}

	public void setOperationLead(String operationLead) {
		this.operationLead = operationLead;
	}

	@JsonIgnore
	public void setOperationLead(
		UnsafeSupplier<String, Exception> operationLeadUnsafeSupplier) {

		try {
			operationLead = operationLeadUnsafeSupplier.get();
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
	protected String operationLead;

	@Schema
	public Long getPmId() {
		return pmId;
	}

	public void setPmId(Long pmId) {
		this.pmId = pmId;
	}

	@JsonIgnore
	public void setPmId(UnsafeSupplier<Long, Exception> pmIdUnsafeSupplier) {
		try {
			pmId = pmIdUnsafeSupplier.get();
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
	protected Long pmId;

	@Schema
	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	@JsonIgnore
	public void setProjectManager(
		UnsafeSupplier<String, Exception> projectManagerUnsafeSupplier) {

		try {
			projectManager = projectManagerUnsafeSupplier.get();
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
	protected String projectManager;

	@Schema
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@JsonIgnore
	public void setProjectName(
		UnsafeSupplier<String, Exception> projectNameUnsafeSupplier) {

		try {
			projectName = projectNameUnsafeSupplier.get();
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
	protected String projectName;

	@Schema
	public String getProjectQaLead() {
		return projectQaLead;
	}

	public void setProjectQaLead(String projectQaLead) {
		this.projectQaLead = projectQaLead;
	}

	@JsonIgnore
	public void setProjectQaLead(
		UnsafeSupplier<String, Exception> projectQaLeadUnsafeSupplier) {

		try {
			projectQaLead = projectQaLeadUnsafeSupplier.get();
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
	protected String projectQaLead;

	@Schema
	public Date getProposedDate() {
		return proposedDate;
	}

	public void setProposedDate(Date proposedDate) {
		this.proposedDate = proposedDate;
	}

	@JsonIgnore
	public void setProposedDate(
		UnsafeSupplier<Date, Exception> proposedDateUnsafeSupplier) {

		try {
			proposedDate = proposedDateUnsafeSupplier.get();
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
	protected Date proposedDate;

	@Schema
	public Long getQlId() {
		return qlId;
	}

	public void setQlId(Long qlId) {
		this.qlId = qlId;
	}

	@JsonIgnore
	public void setQlId(UnsafeSupplier<Long, Exception> qlIdUnsafeSupplier) {
		try {
			qlId = qlIdUnsafeSupplier.get();
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
	protected Long qlId;

	@Schema
	@Valid
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonIgnore
	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
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
	protected Status status;

	@Schema
	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@JsonIgnore
	public void setStatusCode(
		UnsafeSupplier<Integer, Exception> statusCodeUnsafeSupplier) {

		try {
			statusCode = statusCodeUnsafeSupplier.get();
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
	protected Integer statusCode;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Project)) {
			return false;
		}

		Project project = (Project)object;

		return Objects.equals(toString(), project.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (actions != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actions\": ");

			sb.append(_toJSON(actions));
		}

		if (code != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append(code);
		}

		if (confirmedDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"confirmedDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(confirmedDate));

			sb.append("\"");
		}

		if (contactEmail != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contactEmail\": ");

			sb.append("\"");

			sb.append(_escape(contactEmail));

			sb.append("\"");
		}

		if (contactNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contactNumber\": ");

			sb.append("\"");

			sb.append(_escape(contactNumber));

			sb.append("\"");
		}

		if (deliveryLead != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"deliveryLead\": ");

			sb.append("\"");

			sb.append(_escape(deliveryLead));

			sb.append("\"");
		}

		if (description != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(description));

			sb.append("\"");
		}

		if (developmentStartDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"developmentStartDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(developmentStartDate));

			sb.append("\"");
		}

		if (dlId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dlId\": ");

			sb.append(dlId);
		}

		if (durationDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"durationDate\": ");

			sb.append("\"");

			sb.append(_escape(durationDate));

			sb.append("\"");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (olId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"olId\": ");

			sb.append(olId);
		}

		if (operationLead != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"operationLead\": ");

			sb.append("\"");

			sb.append(_escape(operationLead));

			sb.append("\"");
		}

		if (pmId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"pmId\": ");

			sb.append(pmId);
		}

		if (projectManager != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectManager\": ");

			sb.append("\"");

			sb.append(_escape(projectManager));

			sb.append("\"");
		}

		if (projectName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectName\": ");

			sb.append("\"");

			sb.append(_escape(projectName));

			sb.append("\"");
		}

		if (projectQaLead != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"projectQaLead\": ");

			sb.append("\"");

			sb.append(_escape(projectQaLead));

			sb.append("\"");
		}

		if (proposedDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"proposedDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(proposedDate));

			sb.append("\"");
		}

		if (qlId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"qlId\": ");

			sb.append(qlId);
		}

		if (status != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append(String.valueOf(status));
		}

		if (statusCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusCode\": ");

			sb.append(statusCode);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.esquare.intranet.project.headless.dto.v1_0.Project",
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