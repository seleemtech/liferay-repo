/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.intranet.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EducationDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EducationDetails
 * @generated
 */
public class EducationDetailsWrapper
	extends BaseModelWrapper<EducationDetails>
	implements EducationDetails, ModelWrapper<EducationDetails> {

	public EducationDetailsWrapper(EducationDetails educationDetails) {
		super(educationDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("educationId", getEducationId());
		attributes.put("employeeID", getEmployeeID());
		attributes.put("pgGraduation", getPgGraduation());
		attributes.put("pgSpecialization", getPgSpecialization());
		attributes.put("pgUniversity", getPgUniversity());
		attributes.put("pgPassout", getPgPassout());
		attributes.put("pgPercentage", getPgPercentage());
		attributes.put("graduation", getGraduation());
		attributes.put("specialization", getSpecialization());
		attributes.put("university", getUniversity());
		attributes.put("passout", getPassout());
		attributes.put("percentage", getPercentage());
		attributes.put("hscSchool", getHscSchool());
		attributes.put("hscPassout", getHscPassout());
		attributes.put("hscPercentage", getHscPercentage());
		attributes.put("sslcSchool", getSslcSchool());
		attributes.put("sslcPassout", getSslcPassout());
		attributes.put("sslcPercentage", getSslcPercentage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long educationId = (Long)attributes.get("educationId");

		if (educationId != null) {
			setEducationId(educationId);
		}

		Long employeeID = (Long)attributes.get("employeeID");

		if (employeeID != null) {
			setEmployeeID(employeeID);
		}

		String pgGraduation = (String)attributes.get("pgGraduation");

		if (pgGraduation != null) {
			setPgGraduation(pgGraduation);
		}

		String pgSpecialization = (String)attributes.get("pgSpecialization");

		if (pgSpecialization != null) {
			setPgSpecialization(pgSpecialization);
		}

		String pgUniversity = (String)attributes.get("pgUniversity");

		if (pgUniversity != null) {
			setPgUniversity(pgUniversity);
		}

		String pgPassout = (String)attributes.get("pgPassout");

		if (pgPassout != null) {
			setPgPassout(pgPassout);
		}

		String pgPercentage = (String)attributes.get("pgPercentage");

		if (pgPercentage != null) {
			setPgPercentage(pgPercentage);
		}

		String graduation = (String)attributes.get("graduation");

		if (graduation != null) {
			setGraduation(graduation);
		}

		String specialization = (String)attributes.get("specialization");

		if (specialization != null) {
			setSpecialization(specialization);
		}

		String university = (String)attributes.get("university");

		if (university != null) {
			setUniversity(university);
		}

		String passout = (String)attributes.get("passout");

		if (passout != null) {
			setPassout(passout);
		}

		String percentage = (String)attributes.get("percentage");

		if (percentage != null) {
			setPercentage(percentage);
		}

		String hscSchool = (String)attributes.get("hscSchool");

		if (hscSchool != null) {
			setHscSchool(hscSchool);
		}

		String hscPassout = (String)attributes.get("hscPassout");

		if (hscPassout != null) {
			setHscPassout(hscPassout);
		}

		String hscPercentage = (String)attributes.get("hscPercentage");

		if (hscPercentage != null) {
			setHscPercentage(hscPercentage);
		}

		String sslcSchool = (String)attributes.get("sslcSchool");

		if (sslcSchool != null) {
			setSslcSchool(sslcSchool);
		}

		String sslcPassout = (String)attributes.get("sslcPassout");

		if (sslcPassout != null) {
			setSslcPassout(sslcPassout);
		}

		String sslcPercentage = (String)attributes.get("sslcPercentage");

		if (sslcPercentage != null) {
			setSslcPercentage(sslcPercentage);
		}
	}

	@Override
	public EducationDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the education ID of this education details.
	 *
	 * @return the education ID of this education details
	 */
	@Override
	public long getEducationId() {
		return model.getEducationId();
	}

	/**
	 * Returns the employee ID of this education details.
	 *
	 * @return the employee ID of this education details
	 */
	@Override
	public long getEmployeeID() {
		return model.getEmployeeID();
	}

	/**
	 * Returns the graduation of this education details.
	 *
	 * @return the graduation of this education details
	 */
	@Override
	public String getGraduation() {
		return model.getGraduation();
	}

	/**
	 * Returns the hsc passout of this education details.
	 *
	 * @return the hsc passout of this education details
	 */
	@Override
	public String getHscPassout() {
		return model.getHscPassout();
	}

	/**
	 * Returns the hsc percentage of this education details.
	 *
	 * @return the hsc percentage of this education details
	 */
	@Override
	public String getHscPercentage() {
		return model.getHscPercentage();
	}

	/**
	 * Returns the hsc school of this education details.
	 *
	 * @return the hsc school of this education details
	 */
	@Override
	public String getHscSchool() {
		return model.getHscSchool();
	}

	/**
	 * Returns the passout of this education details.
	 *
	 * @return the passout of this education details
	 */
	@Override
	public String getPassout() {
		return model.getPassout();
	}

	/**
	 * Returns the percentage of this education details.
	 *
	 * @return the percentage of this education details
	 */
	@Override
	public String getPercentage() {
		return model.getPercentage();
	}

	/**
	 * Returns the pg graduation of this education details.
	 *
	 * @return the pg graduation of this education details
	 */
	@Override
	public String getPgGraduation() {
		return model.getPgGraduation();
	}

	/**
	 * Returns the pg passout of this education details.
	 *
	 * @return the pg passout of this education details
	 */
	@Override
	public String getPgPassout() {
		return model.getPgPassout();
	}

	/**
	 * Returns the pg percentage of this education details.
	 *
	 * @return the pg percentage of this education details
	 */
	@Override
	public String getPgPercentage() {
		return model.getPgPercentage();
	}

	/**
	 * Returns the pg specialization of this education details.
	 *
	 * @return the pg specialization of this education details
	 */
	@Override
	public String getPgSpecialization() {
		return model.getPgSpecialization();
	}

	/**
	 * Returns the pg university of this education details.
	 *
	 * @return the pg university of this education details
	 */
	@Override
	public String getPgUniversity() {
		return model.getPgUniversity();
	}

	/**
	 * Returns the primary key of this education details.
	 *
	 * @return the primary key of this education details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the specialization of this education details.
	 *
	 * @return the specialization of this education details
	 */
	@Override
	public String getSpecialization() {
		return model.getSpecialization();
	}

	/**
	 * Returns the sslc passout of this education details.
	 *
	 * @return the sslc passout of this education details
	 */
	@Override
	public String getSslcPassout() {
		return model.getSslcPassout();
	}

	/**
	 * Returns the sslc percentage of this education details.
	 *
	 * @return the sslc percentage of this education details
	 */
	@Override
	public String getSslcPercentage() {
		return model.getSslcPercentage();
	}

	/**
	 * Returns the sslc school of this education details.
	 *
	 * @return the sslc school of this education details
	 */
	@Override
	public String getSslcSchool() {
		return model.getSslcSchool();
	}

	/**
	 * Returns the university of this education details.
	 *
	 * @return the university of this education details
	 */
	@Override
	public String getUniversity() {
		return model.getUniversity();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the education ID of this education details.
	 *
	 * @param educationId the education ID of this education details
	 */
	@Override
	public void setEducationId(long educationId) {
		model.setEducationId(educationId);
	}

	/**
	 * Sets the employee ID of this education details.
	 *
	 * @param employeeID the employee ID of this education details
	 */
	@Override
	public void setEmployeeID(long employeeID) {
		model.setEmployeeID(employeeID);
	}

	/**
	 * Sets the graduation of this education details.
	 *
	 * @param graduation the graduation of this education details
	 */
	@Override
	public void setGraduation(String graduation) {
		model.setGraduation(graduation);
	}

	/**
	 * Sets the hsc passout of this education details.
	 *
	 * @param hscPassout the hsc passout of this education details
	 */
	@Override
	public void setHscPassout(String hscPassout) {
		model.setHscPassout(hscPassout);
	}

	/**
	 * Sets the hsc percentage of this education details.
	 *
	 * @param hscPercentage the hsc percentage of this education details
	 */
	@Override
	public void setHscPercentage(String hscPercentage) {
		model.setHscPercentage(hscPercentage);
	}

	/**
	 * Sets the hsc school of this education details.
	 *
	 * @param hscSchool the hsc school of this education details
	 */
	@Override
	public void setHscSchool(String hscSchool) {
		model.setHscSchool(hscSchool);
	}

	/**
	 * Sets the passout of this education details.
	 *
	 * @param passout the passout of this education details
	 */
	@Override
	public void setPassout(String passout) {
		model.setPassout(passout);
	}

	/**
	 * Sets the percentage of this education details.
	 *
	 * @param percentage the percentage of this education details
	 */
	@Override
	public void setPercentage(String percentage) {
		model.setPercentage(percentage);
	}

	/**
	 * Sets the pg graduation of this education details.
	 *
	 * @param pgGraduation the pg graduation of this education details
	 */
	@Override
	public void setPgGraduation(String pgGraduation) {
		model.setPgGraduation(pgGraduation);
	}

	/**
	 * Sets the pg passout of this education details.
	 *
	 * @param pgPassout the pg passout of this education details
	 */
	@Override
	public void setPgPassout(String pgPassout) {
		model.setPgPassout(pgPassout);
	}

	/**
	 * Sets the pg percentage of this education details.
	 *
	 * @param pgPercentage the pg percentage of this education details
	 */
	@Override
	public void setPgPercentage(String pgPercentage) {
		model.setPgPercentage(pgPercentage);
	}

	/**
	 * Sets the pg specialization of this education details.
	 *
	 * @param pgSpecialization the pg specialization of this education details
	 */
	@Override
	public void setPgSpecialization(String pgSpecialization) {
		model.setPgSpecialization(pgSpecialization);
	}

	/**
	 * Sets the pg university of this education details.
	 *
	 * @param pgUniversity the pg university of this education details
	 */
	@Override
	public void setPgUniversity(String pgUniversity) {
		model.setPgUniversity(pgUniversity);
	}

	/**
	 * Sets the primary key of this education details.
	 *
	 * @param primaryKey the primary key of this education details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the specialization of this education details.
	 *
	 * @param specialization the specialization of this education details
	 */
	@Override
	public void setSpecialization(String specialization) {
		model.setSpecialization(specialization);
	}

	/**
	 * Sets the sslc passout of this education details.
	 *
	 * @param sslcPassout the sslc passout of this education details
	 */
	@Override
	public void setSslcPassout(String sslcPassout) {
		model.setSslcPassout(sslcPassout);
	}

	/**
	 * Sets the sslc percentage of this education details.
	 *
	 * @param sslcPercentage the sslc percentage of this education details
	 */
	@Override
	public void setSslcPercentage(String sslcPercentage) {
		model.setSslcPercentage(sslcPercentage);
	}

	/**
	 * Sets the sslc school of this education details.
	 *
	 * @param sslcSchool the sslc school of this education details
	 */
	@Override
	public void setSslcSchool(String sslcSchool) {
		model.setSslcSchool(sslcSchool);
	}

	/**
	 * Sets the university of this education details.
	 *
	 * @param university the university of this education details
	 */
	@Override
	public void setUniversity(String university) {
		model.setUniversity(university);
	}

	@Override
	protected EducationDetailsWrapper wrap(EducationDetails educationDetails) {
		return new EducationDetailsWrapper(educationDetails);
	}

}