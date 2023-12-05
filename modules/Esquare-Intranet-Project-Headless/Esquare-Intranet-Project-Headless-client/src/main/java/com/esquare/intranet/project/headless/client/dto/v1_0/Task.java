package com.esquare.intranet.project.headless.client.dto.v1_0;

import com.esquare.intranet.project.headless.client.function.UnsafeSupplier;
import com.esquare.intranet.project.headless.client.serdes.v1_0.TaskSerDes;

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
public class Task implements Cloneable, Serializable {

	public static Task toDTO(String json) {
		return TaskSerDes.toDTO(json);
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

	public String getDevelopmentTeam() {
		return developmentTeam;
	}

	public void setDevelopmentTeam(String developmentTeam) {
		this.developmentTeam = developmentTeam;
	}

	public void setDevelopmentTeam(
		UnsafeSupplier<String, Exception> developmentTeamUnsafeSupplier) {

		try {
			developmentTeam = developmentTeamUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String developmentTeam;

	public String getDevelopmentTeamIds() {
		return developmentTeamIds;
	}

	public void setDevelopmentTeamIds(String developmentTeamIds) {
		this.developmentTeamIds = developmentTeamIds;
	}

	public void setDevelopmentTeamIds(
		UnsafeSupplier<String, Exception> developmentTeamIdsUnsafeSupplier) {

		try {
			developmentTeamIds = developmentTeamIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String developmentTeamIds;

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

	public Long getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(Long projectCode) {
		this.projectCode = projectCode;
	}

	public void setProjectCode(
		UnsafeSupplier<Long, Exception> projectCodeUnsafeSupplier) {

		try {
			projectCode = projectCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long projectCode;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public void setProjectId(
		UnsafeSupplier<Long, Exception> projectIdUnsafeSupplier) {

		try {
			projectId = projectIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long projectId;

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

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public void setTaskEndDate(
		UnsafeSupplier<Date, Exception> taskEndDateUnsafeSupplier) {

		try {
			taskEndDate = taskEndDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date taskEndDate;

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public void setTaskStartDate(
		UnsafeSupplier<Date, Exception> taskStartDateUnsafeSupplier) {

		try {
			taskStartDate = taskStartDateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date taskStartDate;

	public String getTesterTeam() {
		return testerTeam;
	}

	public void setTesterTeam(String testerTeam) {
		this.testerTeam = testerTeam;
	}

	public void setTesterTeam(
		UnsafeSupplier<String, Exception> testerTeamUnsafeSupplier) {

		try {
			testerTeam = testerTeamUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String testerTeam;

	public String getTesterTeamIds() {
		return testerTeamIds;
	}

	public void setTesterTeamIds(String testerTeamIds) {
		this.testerTeamIds = testerTeamIds;
	}

	public void setTesterTeamIds(
		UnsafeSupplier<String, Exception> testerTeamIdsUnsafeSupplier) {

		try {
			testerTeamIds = testerTeamIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String testerTeamIds;

	@Override
	public Task clone() throws CloneNotSupportedException {
		return (Task)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Task)) {
			return false;
		}

		Task task = (Task)object;

		return Objects.equals(toString(), task.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TaskSerDes.toJSON(this);
	}

}