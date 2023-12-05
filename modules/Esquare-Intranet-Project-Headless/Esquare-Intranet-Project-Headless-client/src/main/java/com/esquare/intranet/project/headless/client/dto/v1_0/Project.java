package com.esquare.intranet.project.headless.client.dto.v1_0;

import com.esquare.intranet.project.headless.client.function.UnsafeSupplier;
import com.esquare.intranet.project.headless.client.serdes.v1_0.ProjectSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Mahammed Seleem
 * @generated
 */
@Generated("")
public class Project implements Cloneable, Serializable {

	public static Project toDTO(String json) {
		return ProjectSerDes.toDTO(json);
	}

	public Map<String, Map<String, String>> getActions() {
		return actions;
	}

	public void setActions(Map<String, Map<String, String>> actions) {
		this.actions = actions;
	}

	public void setActions(
		UnsafeSupplier<Map<String, Map<String, String>>, Exception>
			actionsUnsafeSupplier) {

		try {
			actions = actionsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Map<String, Map<String, String>> actions;

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

	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public void setConfirmedDate(
		UnsafeSupplier<Date, Exception> confirmedDateUnsafeSupplier) {

		try {
			confirmedDate = confirmedDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date confirmedDate;

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public void setContactEmail(
		UnsafeSupplier<String, Exception> contactEmailUnsafeSupplier) {

		try {
			contactEmail = contactEmailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String contactEmail;

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setContactNumber(
		UnsafeSupplier<String, Exception> contactNumberUnsafeSupplier) {

		try {
			contactNumber = contactNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String contactNumber;

	public String getDeliveryLead() {
		return deliveryLead;
	}

	public void setDeliveryLead(String deliveryLead) {
		this.deliveryLead = deliveryLead;
	}

	public void setDeliveryLead(
		UnsafeSupplier<String, Exception> deliveryLeadUnsafeSupplier) {

		try {
			deliveryLead = deliveryLeadUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String deliveryLead;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public Date getDevelopmentStartDate() {
		return developmentStartDate;
	}

	public void setDevelopmentStartDate(Date developmentStartDate) {
		this.developmentStartDate = developmentStartDate;
	}

	public void setDevelopmentStartDate(
		UnsafeSupplier<Date, Exception> developmentStartDateUnsafeSupplier) {

		try {
			developmentStartDate = developmentStartDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date developmentStartDate;

	public Long getDlId() {
		return dlId;
	}

	public void setDlId(Long dlId) {
		this.dlId = dlId;
	}

	public void setDlId(UnsafeSupplier<Long, Exception> dlIdUnsafeSupplier) {
		try {
			dlId = dlIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long dlId;

	public String getDurationDate() {
		return durationDate;
	}

	public void setDurationDate(String durationDate) {
		this.durationDate = durationDate;
	}

	public void setDurationDate(
		UnsafeSupplier<String, Exception> durationDateUnsafeSupplier) {

		try {
			durationDate = durationDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String durationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

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

	public Long getOlId() {
		return olId;
	}

	public void setOlId(Long olId) {
		this.olId = olId;
	}

	public void setOlId(UnsafeSupplier<Long, Exception> olIdUnsafeSupplier) {
		try {
			olId = olIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long olId;

	public String getOperationLead() {
		return operationLead;
	}

	public void setOperationLead(String operationLead) {
		this.operationLead = operationLead;
	}

	public void setOperationLead(
		UnsafeSupplier<String, Exception> operationLeadUnsafeSupplier) {

		try {
			operationLead = operationLeadUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String operationLead;

	public Long getPmId() {
		return pmId;
	}

	public void setPmId(Long pmId) {
		this.pmId = pmId;
	}

	public void setPmId(UnsafeSupplier<Long, Exception> pmIdUnsafeSupplier) {
		try {
			pmId = pmIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long pmId;

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public void setProjectManager(
		UnsafeSupplier<String, Exception> projectManagerUnsafeSupplier) {

		try {
			projectManager = projectManagerUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String projectManager;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectName(
		UnsafeSupplier<String, Exception> projectNameUnsafeSupplier) {

		try {
			projectName = projectNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String projectName;

	public String getProjectQaLead() {
		return projectQaLead;
	}

	public void setProjectQaLead(String projectQaLead) {
		this.projectQaLead = projectQaLead;
	}

	public void setProjectQaLead(
		UnsafeSupplier<String, Exception> projectQaLeadUnsafeSupplier) {

		try {
			projectQaLead = projectQaLeadUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String projectQaLead;

	public Date getProposedDate() {
		return proposedDate;
	}

	public void setProposedDate(Date proposedDate) {
		this.proposedDate = proposedDate;
	}

	public void setProposedDate(
		UnsafeSupplier<Date, Exception> proposedDateUnsafeSupplier) {

		try {
			proposedDate = proposedDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date proposedDate;

	public Long getQlId() {
		return qlId;
	}

	public void setQlId(Long qlId) {
		this.qlId = qlId;
	}

	public void setQlId(UnsafeSupplier<Long, Exception> qlIdUnsafeSupplier) {
		try {
			qlId = qlIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long qlId;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<Status, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Status status;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public void setStatusCode(
		UnsafeSupplier<Integer, Exception> statusCodeUnsafeSupplier) {

		try {
			statusCode = statusCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer statusCode;

	@Override
	public Project clone() throws CloneNotSupportedException {
		return (Project)super.clone();
	}

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
		return ProjectSerDes.toJSON(this);
	}

}