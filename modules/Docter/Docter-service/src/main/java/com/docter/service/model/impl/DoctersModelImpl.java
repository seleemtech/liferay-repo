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

package com.docter.service.model.impl;

import com.docter.service.model.Docters;
import com.docter.service.model.DoctersModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
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
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

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
 * The base model implementation for the Docters service. Represents a row in the &quot;DOC_Docters&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DoctersModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DoctersImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DoctersImpl
 * @generated
 */
@JSON(strict = true)
public class DoctersModelImpl
	extends BaseModelImpl<Docters> implements DoctersModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a docters model instance should use the <code>Docters</code> interface instead.
	 */
	public static final String TABLE_NAME = "DOC_Docters";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"docterId", Types.BIGINT},
		{"docterName", Types.VARCHAR}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"STATUS", Types.INTEGER}, {"STATUS_BY_USER_ID", Types.BIGINT},
		{"STATUS_BY_USER_NAME", Types.VARCHAR}, {"STATUS_DATE", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("docterId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("docterName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("STATUS", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("STATUS_BY_USER_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("STATUS_BY_USER_NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("STATUS_DATE", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DOC_Docters (uuid_ VARCHAR(75) null,docterId LONG not null primary key,docterName VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,STATUS INTEGER,STATUS_BY_USER_ID LONG,STATUS_BY_USER_NAME VARCHAR(75) null,STATUS_DATE DATE null)";

	public static final String TABLE_SQL_DROP = "drop table DOC_Docters";

	public static final String ORDER_BY_JPQL = " ORDER BY docters.docterId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DOC_Docters.docterId ASC";

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
	public static final long DOCTERID_COLUMN_BITMASK = 8L;

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

	public DoctersModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _docterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDocterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _docterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Docters.class;
	}

	@Override
	public String getModelClassName() {
		return Docters.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Docters, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Docters, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Docters, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Docters)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Docters, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Docters, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Docters)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Docters, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Docters, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Docters, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Docters, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Docters, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Docters, Object>>();
		Map<String, BiConsumer<Docters, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Docters, ?>>();

		attributeGetterFunctions.put("uuid", Docters::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Docters, String>)Docters::setUuid);
		attributeGetterFunctions.put("docterId", Docters::getDocterId);
		attributeSetterBiConsumers.put(
			"docterId", (BiConsumer<Docters, Long>)Docters::setDocterId);
		attributeGetterFunctions.put("docterName", Docters::getDocterName);
		attributeSetterBiConsumers.put(
			"docterName", (BiConsumer<Docters, String>)Docters::setDocterName);
		attributeGetterFunctions.put("groupId", Docters::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Docters, Long>)Docters::setGroupId);
		attributeGetterFunctions.put("companyId", Docters::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Docters, Long>)Docters::setCompanyId);
		attributeGetterFunctions.put("userId", Docters::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Docters, Long>)Docters::setUserId);
		attributeGetterFunctions.put("createDate", Docters::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Docters, Date>)Docters::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Docters::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Docters, Date>)Docters::setModifiedDate);
		attributeGetterFunctions.put("status", Docters::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Docters, Integer>)Docters::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", Docters::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<Docters, Long>)Docters::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", Docters::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<Docters, String>)Docters::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", Docters::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate", (BiConsumer<Docters, Date>)Docters::setStatusDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public long getDocterId() {
		return _docterId;
	}

	@Override
	public void setDocterId(long docterId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_docterId = docterId;
	}

	@JSON
	@Override
	public String getDocterName() {
		if (_docterName == null) {
			return "";
		}
		else {
			return _docterName;
		}
	}

	@Override
	public void setDocterName(String docterName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_docterName = docterName;
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
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
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Docters.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
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
			getCompanyId(), Docters.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Docters toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Docters>
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
		DoctersImpl doctersImpl = new DoctersImpl();

		doctersImpl.setUuid(getUuid());
		doctersImpl.setDocterId(getDocterId());
		doctersImpl.setDocterName(getDocterName());
		doctersImpl.setGroupId(getGroupId());
		doctersImpl.setCompanyId(getCompanyId());
		doctersImpl.setUserId(getUserId());
		doctersImpl.setCreateDate(getCreateDate());
		doctersImpl.setModifiedDate(getModifiedDate());
		doctersImpl.setStatus(getStatus());
		doctersImpl.setStatusByUserId(getStatusByUserId());
		doctersImpl.setStatusByUserName(getStatusByUserName());
		doctersImpl.setStatusDate(getStatusDate());

		doctersImpl.resetOriginalValues();

		return doctersImpl;
	}

	@Override
	public Docters cloneWithOriginalValues() {
		DoctersImpl doctersImpl = new DoctersImpl();

		doctersImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		doctersImpl.setDocterId(this.<Long>getColumnOriginalValue("docterId"));
		doctersImpl.setDocterName(
			this.<String>getColumnOriginalValue("docterName"));
		doctersImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		doctersImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		doctersImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		doctersImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		doctersImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		doctersImpl.setStatus(this.<Integer>getColumnOriginalValue("STATUS"));
		doctersImpl.setStatusByUserId(
			this.<Long>getColumnOriginalValue("STATUS_BY_USER_ID"));
		doctersImpl.setStatusByUserName(
			this.<String>getColumnOriginalValue("STATUS_BY_USER_NAME"));
		doctersImpl.setStatusDate(
			this.<Date>getColumnOriginalValue("STATUS_DATE"));

		return doctersImpl;
	}

	@Override
	public int compareTo(Docters docters) {
		long primaryKey = docters.getPrimaryKey();

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

		if (!(object instanceof Docters)) {
			return false;
		}

		Docters docters = (Docters)object;

		long primaryKey = docters.getPrimaryKey();

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

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Docters> toCacheModel() {
		DoctersCacheModel doctersCacheModel = new DoctersCacheModel();

		doctersCacheModel.uuid = getUuid();

		String uuid = doctersCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			doctersCacheModel.uuid = null;
		}

		doctersCacheModel.docterId = getDocterId();

		doctersCacheModel.docterName = getDocterName();

		String docterName = doctersCacheModel.docterName;

		if ((docterName != null) && (docterName.length() == 0)) {
			doctersCacheModel.docterName = null;
		}

		doctersCacheModel.groupId = getGroupId();

		doctersCacheModel.companyId = getCompanyId();

		doctersCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			doctersCacheModel.createDate = createDate.getTime();
		}
		else {
			doctersCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			doctersCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			doctersCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		doctersCacheModel.status = getStatus();

		doctersCacheModel.statusByUserId = getStatusByUserId();

		doctersCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = doctersCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			doctersCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			doctersCacheModel.statusDate = statusDate.getTime();
		}
		else {
			doctersCacheModel.statusDate = Long.MIN_VALUE;
		}

		return doctersCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Docters, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Docters, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Docters, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Docters)this);

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

	@Override
	public String toXmlString() {
		Map<String, Function<Docters, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Docters, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Docters, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Docters)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Docters>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Docters.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _docterId;
	private String _docterName;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Docters, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Docters)this);
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
		_columnOriginalValues.put("docterId", _docterId);
		_columnOriginalValues.put("docterName", _docterName);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("STATUS", _status);
		_columnOriginalValues.put("STATUS_BY_USER_ID", _statusByUserId);
		_columnOriginalValues.put("STATUS_BY_USER_NAME", _statusByUserName);
		_columnOriginalValues.put("STATUS_DATE", _statusDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("STATUS", "status");
		attributeNames.put("STATUS_BY_USER_ID", "statusByUserId");
		attributeNames.put("STATUS_BY_USER_NAME", "statusByUserName");
		attributeNames.put("STATUS_DATE", "statusDate");

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

		columnBitmasks.put("docterId", 2L);

		columnBitmasks.put("docterName", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("STATUS", 256L);

		columnBitmasks.put("STATUS_BY_USER_ID", 512L);

		columnBitmasks.put("STATUS_BY_USER_NAME", 1024L);

		columnBitmasks.put("STATUS_DATE", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Docters _escapedModel;

}