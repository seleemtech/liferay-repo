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

package com.esquare.intranet.project.management.model.impl;

import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.model.ProjectsModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Projects service. Represents a row in the &quot;Esquare_Projects&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProjectsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectsImpl}.
 * </p>
 *
 * @author Mahammed Seleem
 * @see ProjectsImpl
 * @generated
 */
@JSON(strict = true)
public class ProjectsModelImpl
	extends BaseModelImpl<Projects> implements ProjectsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a projects model instance should use the <code>Projects</code> interface instead.
	 */
	public static final String TABLE_NAME = "Esquare_Projects";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"projectId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"projectName", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"proposedDate", Types.TIMESTAMP}, {"confirmedDate", Types.TIMESTAMP},
		{"developmentStartDate", Types.TIMESTAMP},
		{"estimatedDate", Types.TIMESTAMP}, {"durationDate", Types.VARCHAR},
		{"status", Types.INTEGER}, {"code_", Types.INTEGER},
		{"documentId", Types.BIGINT}, {"resourceIdSettings", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"contactNumber", Types.VARCHAR},
		{"contactEmail", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("proposedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("confirmedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("developmentStartDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("estimatedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("durationDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("code_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("documentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("resourceIdSettings", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactEmail", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Esquare_Projects (uuid_ VARCHAR(75) null,projectId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,projectName VARCHAR(75) null,description VARCHAR(75) null,proposedDate DATE null,confirmedDate DATE null,developmentStartDate DATE null,estimatedDate DATE null,durationDate VARCHAR(75) null,status INTEGER,code_ INTEGER,documentId LONG,resourceIdSettings VARCHAR(75) null,name VARCHAR(75) null,contactNumber VARCHAR(75) null,contactEmail VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Esquare_Projects";

	public static final String ORDER_BY_JPQL =
		" ORDER BY projects.projectId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Esquare_Projects.projectId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROJECTID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public ProjectsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Projects.class;
	}

	@Override
	public String getModelClassName() {
		return Projects.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Projects, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Projects, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Projects, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Projects)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Projects, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Projects, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Projects)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Projects, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Projects, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Projects, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Projects, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Projects, Object>>();

			attributeGetterFunctions.put("uuid", Projects::getUuid);
			attributeGetterFunctions.put("projectId", Projects::getProjectId);
			attributeGetterFunctions.put("groupId", Projects::getGroupId);
			attributeGetterFunctions.put("companyId", Projects::getCompanyId);
			attributeGetterFunctions.put("userId", Projects::getUserId);
			attributeGetterFunctions.put("userName", Projects::getUserName);
			attributeGetterFunctions.put(
				"projectName", Projects::getProjectName);
			attributeGetterFunctions.put(
				"description", Projects::getDescription);
			attributeGetterFunctions.put(
				"proposedDate", Projects::getProposedDate);
			attributeGetterFunctions.put(
				"confirmedDate", Projects::getConfirmedDate);
			attributeGetterFunctions.put(
				"developmentStartDate", Projects::getDevelopmentStartDate);
			attributeGetterFunctions.put(
				"estimatedDate", Projects::getEstimatedDate);
			attributeGetterFunctions.put(
				"durationDate", Projects::getDurationDate);
			attributeGetterFunctions.put("status", Projects::getStatus);
			attributeGetterFunctions.put("code", Projects::getCode);
			attributeGetterFunctions.put("documentId", Projects::getDocumentId);
			attributeGetterFunctions.put(
				"resourceIdSettings", Projects::getResourceIdSettings);
			attributeGetterFunctions.put("name", Projects::getName);
			attributeGetterFunctions.put(
				"contactNumber", Projects::getContactNumber);
			attributeGetterFunctions.put(
				"contactEmail", Projects::getContactEmail);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Projects, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Projects, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Projects, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<Projects, String>)Projects::setUuid);
			attributeSetterBiConsumers.put(
				"projectId",
				(BiConsumer<Projects, Long>)Projects::setProjectId);
			attributeSetterBiConsumers.put(
				"groupId", (BiConsumer<Projects, Long>)Projects::setGroupId);
			attributeSetterBiConsumers.put(
				"companyId",
				(BiConsumer<Projects, Long>)Projects::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<Projects, Long>)Projects::setUserId);
			attributeSetterBiConsumers.put(
				"userName",
				(BiConsumer<Projects, String>)Projects::setUserName);
			attributeSetterBiConsumers.put(
				"projectName",
				(BiConsumer<Projects, String>)Projects::setProjectName);
			attributeSetterBiConsumers.put(
				"description",
				(BiConsumer<Projects, String>)Projects::setDescription);
			attributeSetterBiConsumers.put(
				"proposedDate",
				(BiConsumer<Projects, Date>)Projects::setProposedDate);
			attributeSetterBiConsumers.put(
				"confirmedDate",
				(BiConsumer<Projects, Date>)Projects::setConfirmedDate);
			attributeSetterBiConsumers.put(
				"developmentStartDate",
				(BiConsumer<Projects, Date>)Projects::setDevelopmentStartDate);
			attributeSetterBiConsumers.put(
				"estimatedDate",
				(BiConsumer<Projects, Date>)Projects::setEstimatedDate);
			attributeSetterBiConsumers.put(
				"durationDate",
				(BiConsumer<Projects, String>)Projects::setDurationDate);
			attributeSetterBiConsumers.put(
				"status", (BiConsumer<Projects, Integer>)Projects::setStatus);
			attributeSetterBiConsumers.put(
				"code", (BiConsumer<Projects, Integer>)Projects::setCode);
			attributeSetterBiConsumers.put(
				"documentId",
				(BiConsumer<Projects, Long>)Projects::setDocumentId);
			attributeSetterBiConsumers.put(
				"resourceIdSettings",
				(BiConsumer<Projects, String>)Projects::setResourceIdSettings);
			attributeSetterBiConsumers.put(
				"name", (BiConsumer<Projects, String>)Projects::setName);
			attributeSetterBiConsumers.put(
				"contactNumber",
				(BiConsumer<Projects, String>)Projects::setContactNumber);
			attributeSetterBiConsumers.put(
				"contactEmail",
				(BiConsumer<Projects, String>)Projects::setContactEmail);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_projectId = projectId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public String getProjectName() {
		if (_projectName == null) {
			return "";
		}
		else {
			return _projectName;
		}
	}

	@Override
	public void setProjectName(String projectName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_projectName = projectName;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public Date getProposedDate() {
		return _proposedDate;
	}

	@Override
	public void setProposedDate(Date proposedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_proposedDate = proposedDate;
	}

	@JSON
	@Override
	public Date getConfirmedDate() {
		return _confirmedDate;
	}

	@Override
	public void setConfirmedDate(Date confirmedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_confirmedDate = confirmedDate;
	}

	@JSON
	@Override
	public Date getDevelopmentStartDate() {
		return _developmentStartDate;
	}

	@Override
	public void setDevelopmentStartDate(Date developmentStartDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_developmentStartDate = developmentStartDate;
	}

	@JSON
	@Override
	public Date getEstimatedDate() {
		return _estimatedDate;
	}

	@Override
	public void setEstimatedDate(Date estimatedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_estimatedDate = estimatedDate;
	}

	@JSON
	@Override
	public String getDurationDate() {
		if (_durationDate == null) {
			return "";
		}
		else {
			return _durationDate;
		}
	}

	@Override
	public void setDurationDate(String durationDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_durationDate = durationDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@JSON
	@Override
	public int getCode() {
		return _code;
	}

	@Override
	public void setCode(int code) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_code = code;
	}

	@JSON
	@Override
	public long getDocumentId() {
		return _documentId;
	}

	@Override
	public void setDocumentId(long documentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_documentId = documentId;
	}

	@JSON
	@Override
	public String getResourceIdSettings() {
		if (_resourceIdSettings == null) {
			return "";
		}
		else {
			return _resourceIdSettings;
		}
	}

	@Override
	public void setResourceIdSettings(String resourceIdSettings) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_resourceIdSettings = resourceIdSettings;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public String getContactNumber() {
		if (_contactNumber == null) {
			return "";
		}
		else {
			return _contactNumber;
		}
	}

	@Override
	public void setContactNumber(String contactNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_contactNumber = contactNumber;
	}

	@JSON
	@Override
	public String getContactEmail() {
		if (_contactEmail == null) {
			return "";
		}
		else {
			return _contactEmail;
		}
	}

	@Override
	public void setContactEmail(String contactEmail) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_contactEmail = contactEmail;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Projects.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Projects toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Projects>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectsImpl projectsImpl = new ProjectsImpl();

		projectsImpl.setUuid(getUuid());
		projectsImpl.setProjectId(getProjectId());
		projectsImpl.setGroupId(getGroupId());
		projectsImpl.setCompanyId(getCompanyId());
		projectsImpl.setUserId(getUserId());
		projectsImpl.setUserName(getUserName());
		projectsImpl.setProjectName(getProjectName());
		projectsImpl.setDescription(getDescription());
		projectsImpl.setProposedDate(getProposedDate());
		projectsImpl.setConfirmedDate(getConfirmedDate());
		projectsImpl.setDevelopmentStartDate(getDevelopmentStartDate());
		projectsImpl.setEstimatedDate(getEstimatedDate());
		projectsImpl.setDurationDate(getDurationDate());
		projectsImpl.setStatus(getStatus());
		projectsImpl.setCode(getCode());
		projectsImpl.setDocumentId(getDocumentId());
		projectsImpl.setResourceIdSettings(getResourceIdSettings());
		projectsImpl.setName(getName());
		projectsImpl.setContactNumber(getContactNumber());
		projectsImpl.setContactEmail(getContactEmail());

		projectsImpl.resetOriginalValues();

		return projectsImpl;
	}

	@Override
	public Projects cloneWithOriginalValues() {
		ProjectsImpl projectsImpl = new ProjectsImpl();

		projectsImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		projectsImpl.setProjectId(
			this.<Long>getColumnOriginalValue("projectId"));
		projectsImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		projectsImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		projectsImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		projectsImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		projectsImpl.setProjectName(
			this.<String>getColumnOriginalValue("projectName"));
		projectsImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		projectsImpl.setProposedDate(
			this.<Date>getColumnOriginalValue("proposedDate"));
		projectsImpl.setConfirmedDate(
			this.<Date>getColumnOriginalValue("confirmedDate"));
		projectsImpl.setDevelopmentStartDate(
			this.<Date>getColumnOriginalValue("developmentStartDate"));
		projectsImpl.setEstimatedDate(
			this.<Date>getColumnOriginalValue("estimatedDate"));
		projectsImpl.setDurationDate(
			this.<String>getColumnOriginalValue("durationDate"));
		projectsImpl.setStatus(this.<Integer>getColumnOriginalValue("status"));
		projectsImpl.setCode(this.<Integer>getColumnOriginalValue("code_"));
		projectsImpl.setDocumentId(
			this.<Long>getColumnOriginalValue("documentId"));
		projectsImpl.setResourceIdSettings(
			this.<String>getColumnOriginalValue("resourceIdSettings"));
		projectsImpl.setName(this.<String>getColumnOriginalValue("name"));
		projectsImpl.setContactNumber(
			this.<String>getColumnOriginalValue("contactNumber"));
		projectsImpl.setContactEmail(
			this.<String>getColumnOriginalValue("contactEmail"));

		return projectsImpl;
	}

	@Override
	public int compareTo(Projects projects) {
		long primaryKey = projects.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Projects)) {
			return false;
		}

		Projects projects = (Projects)object;

		long primaryKey = projects.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Projects> toCacheModel() {
		ProjectsCacheModel projectsCacheModel = new ProjectsCacheModel();

		projectsCacheModel.uuid = getUuid();

		String uuid = projectsCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			projectsCacheModel.uuid = null;
		}

		projectsCacheModel.projectId = getProjectId();

		projectsCacheModel.groupId = getGroupId();

		projectsCacheModel.companyId = getCompanyId();

		projectsCacheModel.userId = getUserId();

		projectsCacheModel.userName = getUserName();

		String userName = projectsCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			projectsCacheModel.userName = null;
		}

		projectsCacheModel.projectName = getProjectName();

		String projectName = projectsCacheModel.projectName;

		if ((projectName != null) && (projectName.length() == 0)) {
			projectsCacheModel.projectName = null;
		}

		projectsCacheModel.description = getDescription();

		String description = projectsCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			projectsCacheModel.description = null;
		}

		Date proposedDate = getProposedDate();

		if (proposedDate != null) {
			projectsCacheModel.proposedDate = proposedDate.getTime();
		}
		else {
			projectsCacheModel.proposedDate = Long.MIN_VALUE;
		}

		Date confirmedDate = getConfirmedDate();

		if (confirmedDate != null) {
			projectsCacheModel.confirmedDate = confirmedDate.getTime();
		}
		else {
			projectsCacheModel.confirmedDate = Long.MIN_VALUE;
		}

		Date developmentStartDate = getDevelopmentStartDate();

		if (developmentStartDate != null) {
			projectsCacheModel.developmentStartDate =
				developmentStartDate.getTime();
		}
		else {
			projectsCacheModel.developmentStartDate = Long.MIN_VALUE;
		}

		Date estimatedDate = getEstimatedDate();

		if (estimatedDate != null) {
			projectsCacheModel.estimatedDate = estimatedDate.getTime();
		}
		else {
			projectsCacheModel.estimatedDate = Long.MIN_VALUE;
		}

		projectsCacheModel.durationDate = getDurationDate();

		String durationDate = projectsCacheModel.durationDate;

		if ((durationDate != null) && (durationDate.length() == 0)) {
			projectsCacheModel.durationDate = null;
		}

		projectsCacheModel.status = getStatus();

		projectsCacheModel.code = getCode();

		projectsCacheModel.documentId = getDocumentId();

		projectsCacheModel.resourceIdSettings = getResourceIdSettings();

		String resourceIdSettings = projectsCacheModel.resourceIdSettings;

		if ((resourceIdSettings != null) &&
			(resourceIdSettings.length() == 0)) {

			projectsCacheModel.resourceIdSettings = null;
		}

		projectsCacheModel.name = getName();

		String name = projectsCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			projectsCacheModel.name = null;
		}

		projectsCacheModel.contactNumber = getContactNumber();

		String contactNumber = projectsCacheModel.contactNumber;

		if ((contactNumber != null) && (contactNumber.length() == 0)) {
			projectsCacheModel.contactNumber = null;
		}

		projectsCacheModel.contactEmail = getContactEmail();

		String contactEmail = projectsCacheModel.contactEmail;

		if ((contactEmail != null) && (contactEmail.length() == 0)) {
			projectsCacheModel.contactEmail = null;
		}

		return projectsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Projects, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Projects, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Projects, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Projects)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Projects>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Projects.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _projectId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private String _projectName;
	private String _description;
	private Date _proposedDate;
	private Date _confirmedDate;
	private Date _developmentStartDate;
	private Date _estimatedDate;
	private String _durationDate;
	private int _status;
	private int _code;
	private long _documentId;
	private String _resourceIdSettings;
	private String _name;
	private String _contactNumber;
	private String _contactEmail;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Projects, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Projects)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("projectId", _projectId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("projectName", _projectName);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("proposedDate", _proposedDate);
		_columnOriginalValues.put("confirmedDate", _confirmedDate);
		_columnOriginalValues.put(
			"developmentStartDate", _developmentStartDate);
		_columnOriginalValues.put("estimatedDate", _estimatedDate);
		_columnOriginalValues.put("durationDate", _durationDate);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("code_", _code);
		_columnOriginalValues.put("documentId", _documentId);
		_columnOriginalValues.put("resourceIdSettings", _resourceIdSettings);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("contactNumber", _contactNumber);
		_columnOriginalValues.put("contactEmail", _contactEmail);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("code_", "code");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("projectId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("projectName", 64L);

		columnBitmasks.put("description", 128L);

		columnBitmasks.put("proposedDate", 256L);

		columnBitmasks.put("confirmedDate", 512L);

		columnBitmasks.put("developmentStartDate", 1024L);

		columnBitmasks.put("estimatedDate", 2048L);

		columnBitmasks.put("durationDate", 4096L);

		columnBitmasks.put("status", 8192L);

		columnBitmasks.put("code_", 16384L);

		columnBitmasks.put("documentId", 32768L);

		columnBitmasks.put("resourceIdSettings", 65536L);

		columnBitmasks.put("name", 131072L);

		columnBitmasks.put("contactNumber", 262144L);

		columnBitmasks.put("contactEmail", 524288L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Projects _escapedModel;

}