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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EducationDetails service. Represents a row in the &quot;INTRANET_EducationDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.intranet.model.impl.EducationDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.intranet.model.impl.EducationDetailsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EducationDetails
 * @generated
 */
@ProviderType
public interface EducationDetailsModel extends BaseModel<EducationDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a education details model instance should use the {@link EducationDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this education details.
	 *
	 * @return the primary key of this education details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this education details.
	 *
	 * @param primaryKey the primary key of this education details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the education ID of this education details.
	 *
	 * @return the education ID of this education details
	 */
	public long getEducationId();

	/**
	 * Sets the education ID of this education details.
	 *
	 * @param educationId the education ID of this education details
	 */
	public void setEducationId(long educationId);

	/**
	 * Returns the employee ID of this education details.
	 *
	 * @return the employee ID of this education details
	 */
	public long getEmployeeID();

	/**
	 * Sets the employee ID of this education details.
	 *
	 * @param employeeID the employee ID of this education details
	 */
	public void setEmployeeID(long employeeID);

	/**
	 * Returns the pg graduation of this education details.
	 *
	 * @return the pg graduation of this education details
	 */
	@AutoEscape
	public String getPgGraduation();

	/**
	 * Sets the pg graduation of this education details.
	 *
	 * @param pgGraduation the pg graduation of this education details
	 */
	public void setPgGraduation(String pgGraduation);

	/**
	 * Returns the pg specialization of this education details.
	 *
	 * @return the pg specialization of this education details
	 */
	@AutoEscape
	public String getPgSpecialization();

	/**
	 * Sets the pg specialization of this education details.
	 *
	 * @param pgSpecialization the pg specialization of this education details
	 */
	public void setPgSpecialization(String pgSpecialization);

	/**
	 * Returns the pg university of this education details.
	 *
	 * @return the pg university of this education details
	 */
	@AutoEscape
	public String getPgUniversity();

	/**
	 * Sets the pg university of this education details.
	 *
	 * @param pgUniversity the pg university of this education details
	 */
	public void setPgUniversity(String pgUniversity);

	/**
	 * Returns the pg passout of this education details.
	 *
	 * @return the pg passout of this education details
	 */
	@AutoEscape
	public String getPgPassout();

	/**
	 * Sets the pg passout of this education details.
	 *
	 * @param pgPassout the pg passout of this education details
	 */
	public void setPgPassout(String pgPassout);

	/**
	 * Returns the pg percentage of this education details.
	 *
	 * @return the pg percentage of this education details
	 */
	@AutoEscape
	public String getPgPercentage();

	/**
	 * Sets the pg percentage of this education details.
	 *
	 * @param pgPercentage the pg percentage of this education details
	 */
	public void setPgPercentage(String pgPercentage);

	/**
	 * Returns the graduation of this education details.
	 *
	 * @return the graduation of this education details
	 */
	@AutoEscape
	public String getGraduation();

	/**
	 * Sets the graduation of this education details.
	 *
	 * @param graduation the graduation of this education details
	 */
	public void setGraduation(String graduation);

	/**
	 * Returns the specialization of this education details.
	 *
	 * @return the specialization of this education details
	 */
	@AutoEscape
	public String getSpecialization();

	/**
	 * Sets the specialization of this education details.
	 *
	 * @param specialization the specialization of this education details
	 */
	public void setSpecialization(String specialization);

	/**
	 * Returns the university of this education details.
	 *
	 * @return the university of this education details
	 */
	@AutoEscape
	public String getUniversity();

	/**
	 * Sets the university of this education details.
	 *
	 * @param university the university of this education details
	 */
	public void setUniversity(String university);

	/**
	 * Returns the passout of this education details.
	 *
	 * @return the passout of this education details
	 */
	@AutoEscape
	public String getPassout();

	/**
	 * Sets the passout of this education details.
	 *
	 * @param passout the passout of this education details
	 */
	public void setPassout(String passout);

	/**
	 * Returns the percentage of this education details.
	 *
	 * @return the percentage of this education details
	 */
	@AutoEscape
	public String getPercentage();

	/**
	 * Sets the percentage of this education details.
	 *
	 * @param percentage the percentage of this education details
	 */
	public void setPercentage(String percentage);

	/**
	 * Returns the hsc school of this education details.
	 *
	 * @return the hsc school of this education details
	 */
	@AutoEscape
	public String getHscSchool();

	/**
	 * Sets the hsc school of this education details.
	 *
	 * @param hscSchool the hsc school of this education details
	 */
	public void setHscSchool(String hscSchool);

	/**
	 * Returns the hsc passout of this education details.
	 *
	 * @return the hsc passout of this education details
	 */
	@AutoEscape
	public String getHscPassout();

	/**
	 * Sets the hsc passout of this education details.
	 *
	 * @param hscPassout the hsc passout of this education details
	 */
	public void setHscPassout(String hscPassout);

	/**
	 * Returns the hsc percentage of this education details.
	 *
	 * @return the hsc percentage of this education details
	 */
	@AutoEscape
	public String getHscPercentage();

	/**
	 * Sets the hsc percentage of this education details.
	 *
	 * @param hscPercentage the hsc percentage of this education details
	 */
	public void setHscPercentage(String hscPercentage);

	/**
	 * Returns the sslc school of this education details.
	 *
	 * @return the sslc school of this education details
	 */
	@AutoEscape
	public String getSslcSchool();

	/**
	 * Sets the sslc school of this education details.
	 *
	 * @param sslcSchool the sslc school of this education details
	 */
	public void setSslcSchool(String sslcSchool);

	/**
	 * Returns the sslc passout of this education details.
	 *
	 * @return the sslc passout of this education details
	 */
	@AutoEscape
	public String getSslcPassout();

	/**
	 * Sets the sslc passout of this education details.
	 *
	 * @param sslcPassout the sslc passout of this education details
	 */
	public void setSslcPassout(String sslcPassout);

	/**
	 * Returns the sslc percentage of this education details.
	 *
	 * @return the sslc percentage of this education details
	 */
	@AutoEscape
	public String getSslcPercentage();

	/**
	 * Sets the sslc percentage of this education details.
	 *
	 * @param sslcPercentage the sslc percentage of this education details
	 */
	public void setSslcPercentage(String sslcPercentage);

	@Override
	public EducationDetails cloneWithOriginalValues();

}