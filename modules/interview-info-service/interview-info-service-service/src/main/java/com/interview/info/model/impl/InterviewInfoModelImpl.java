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

package com.interview.info.model.impl;

import com.interview.info.model.InterviewInfo;
import com.interview.info.model.InterviewInfoModel;
import com.interview.info.model.InterviewInfoSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the InterviewInfo service. Represents a row in the &quot;RMS_InterviewInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>InterviewInfoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InterviewInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterviewInfoImpl
 * @generated
 */
@JSON(strict = true)
public class InterviewInfoModelImpl
	extends BaseModelImpl<InterviewInfo> implements InterviewInfoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a interview info model instance should use the <code>InterviewInfo</code> interface instead.
	 */
	public static final String TABLE_NAME = "RMS_InterviewInfo";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"interviewId", Types.BIGINT},
		{"interviewName", Types.VARCHAR}, {"postingTitleId", Types.BIGINT},
		{"candidateId", Types.BIGINT}, {"clientId", Types.BIGINT},
		{"interviewFrom", Types.BIGINT}, {"interviewTo", Types.BIGINT},
		{"interviewers", Types.VARCHAR}, {"interviewOwner", Types.BIGINT},
		{"scheduleComments", Types.VARCHAR}, {"location", Types.VARCHAR},
		{"attachmentId", Types.BIGINT}, {"createdBy", Types.BIGINT},
		{"createdDate", Types.BIGINT}, {"modifiedBy", Types.BIGINT},
		{"modifiedDate", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("interviewId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("interviewName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("postingTitleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("candidateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("clientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("interviewFrom", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("interviewTo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("interviewers", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("interviewOwner", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("scheduleComments", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("location", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("attachmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdDate", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table RMS_InterviewInfo (uuid_ VARCHAR(75) null,interviewId LONG not null primary key,interviewName VARCHAR(75) null,postingTitleId LONG,candidateId LONG,clientId LONG,interviewFrom LONG,interviewTo LONG,interviewers VARCHAR(75) null,interviewOwner LONG,scheduleComments VARCHAR(75) null,location VARCHAR(75) null,attachmentId LONG,createdBy LONG,createdDate LONG,modifiedBy LONG,modifiedDate LONG)";

	public static final String TABLE_SQL_DROP = "drop table RMS_InterviewInfo";

	public static final String ORDER_BY_JPQL =
		" ORDER BY interviewInfo.interviewId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY RMS_InterviewInfo.interviewId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ATTACHMENTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long INTERVIEWID_COLUMN_BITMASK = 4L;

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

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static InterviewInfo toModel(InterviewInfoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		InterviewInfo model = new InterviewInfoImpl();

		model.setUuid(soapModel.getUuid());
		model.setInterviewId(soapModel.getInterviewId());
		model.setInterviewName(soapModel.getInterviewName());
		model.setPostingTitleId(soapModel.getPostingTitleId());
		model.setCandidateId(soapModel.getCandidateId());
		model.setClientId(soapModel.getClientId());
		model.setInterviewFrom(soapModel.getInterviewFrom());
		model.setInterviewTo(soapModel.getInterviewTo());
		model.setInterviewers(soapModel.getInterviewers());
		model.setInterviewOwner(soapModel.getInterviewOwner());
		model.setScheduleComments(soapModel.getScheduleComments());
		model.setLocation(soapModel.getLocation());
		model.setAttachmentId(soapModel.getAttachmentId());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedBy(soapModel.getModifiedBy());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<InterviewInfo> toModels(InterviewInfoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<InterviewInfo> models = new ArrayList<InterviewInfo>(
			soapModels.length);

		for (InterviewInfoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public InterviewInfoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _interviewId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInterviewId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _interviewId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return InterviewInfo.class;
	}

	@Override
	public String getModelClassName() {
		return InterviewInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<InterviewInfo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<InterviewInfo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<InterviewInfo, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((InterviewInfo)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<InterviewInfo, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<InterviewInfo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(InterviewInfo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<InterviewInfo, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<InterviewInfo, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, InterviewInfo>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			InterviewInfo.class.getClassLoader(), InterviewInfo.class,
			ModelWrapper.class);

		try {
			Constructor<InterviewInfo> constructor =
				(Constructor<InterviewInfo>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<InterviewInfo, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<InterviewInfo, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<InterviewInfo, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<InterviewInfo, Object>>();
		Map<String, BiConsumer<InterviewInfo, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<InterviewInfo, ?>>();

		attributeGetterFunctions.put("uuid", InterviewInfo::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<InterviewInfo, String>)InterviewInfo::setUuid);
		attributeGetterFunctions.put(
			"interviewId", InterviewInfo::getInterviewId);
		attributeSetterBiConsumers.put(
			"interviewId",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setInterviewId);
		attributeGetterFunctions.put(
			"interviewName", InterviewInfo::getInterviewName);
		attributeSetterBiConsumers.put(
			"interviewName",
			(BiConsumer<InterviewInfo, String>)InterviewInfo::setInterviewName);
		attributeGetterFunctions.put(
			"postingTitleId", InterviewInfo::getPostingTitleId);
		attributeSetterBiConsumers.put(
			"postingTitleId",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setPostingTitleId);
		attributeGetterFunctions.put(
			"candidateId", InterviewInfo::getCandidateId);
		attributeSetterBiConsumers.put(
			"candidateId",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setCandidateId);
		attributeGetterFunctions.put("clientId", InterviewInfo::getClientId);
		attributeSetterBiConsumers.put(
			"clientId",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setClientId);
		attributeGetterFunctions.put(
			"interviewFrom", InterviewInfo::getInterviewFrom);
		attributeSetterBiConsumers.put(
			"interviewFrom",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setInterviewFrom);
		attributeGetterFunctions.put(
			"interviewTo", InterviewInfo::getInterviewTo);
		attributeSetterBiConsumers.put(
			"interviewTo",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setInterviewTo);
		attributeGetterFunctions.put(
			"interviewers", InterviewInfo::getInterviewers);
		attributeSetterBiConsumers.put(
			"interviewers",
			(BiConsumer<InterviewInfo, String>)InterviewInfo::setInterviewers);
		attributeGetterFunctions.put(
			"interviewOwner", InterviewInfo::getInterviewOwner);
		attributeSetterBiConsumers.put(
			"interviewOwner",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setInterviewOwner);
		attributeGetterFunctions.put(
			"scheduleComments", InterviewInfo::getScheduleComments);
		attributeSetterBiConsumers.put(
			"scheduleComments",
			(BiConsumer<InterviewInfo, String>)
				InterviewInfo::setScheduleComments);
		attributeGetterFunctions.put("location", InterviewInfo::getLocation);
		attributeSetterBiConsumers.put(
			"location",
			(BiConsumer<InterviewInfo, String>)InterviewInfo::setLocation);
		attributeGetterFunctions.put(
			"attachmentId", InterviewInfo::getAttachmentId);
		attributeSetterBiConsumers.put(
			"attachmentId",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setAttachmentId);
		attributeGetterFunctions.put("createdBy", InterviewInfo::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setCreatedBy);
		attributeGetterFunctions.put(
			"createdDate", InterviewInfo::getCreatedDate);
		attributeSetterBiConsumers.put(
			"createdDate",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setCreatedDate);
		attributeGetterFunctions.put(
			"modifiedBy", InterviewInfo::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setModifiedBy);
		attributeGetterFunctions.put(
			"modifiedDate", InterviewInfo::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<InterviewInfo, Long>)InterviewInfo::setModifiedDate);

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
	public long getInterviewId() {
		return _interviewId;
	}

	@Override
	public void setInterviewId(long interviewId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_interviewId = interviewId;
	}

	@JSON
	@Override
	public String getInterviewName() {
		if (_interviewName == null) {
			return "";
		}
		else {
			return _interviewName;
		}
	}

	@Override
	public void setInterviewName(String interviewName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_interviewName = interviewName;
	}

	@JSON
	@Override
	public long getPostingTitleId() {
		return _postingTitleId;
	}

	@Override
	public void setPostingTitleId(long postingTitleId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_postingTitleId = postingTitleId;
	}

	@JSON
	@Override
	public long getCandidateId() {
		return _candidateId;
	}

	@Override
	public void setCandidateId(long candidateId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_candidateId = candidateId;
	}

	@JSON
	@Override
	public long getClientId() {
		return _clientId;
	}

	@Override
	public void setClientId(long clientId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_clientId = clientId;
	}

	@JSON
	@Override
	public long getInterviewFrom() {
		return _interviewFrom;
	}

	@Override
	public void setInterviewFrom(long interviewFrom) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_interviewFrom = interviewFrom;
	}

	@JSON
	@Override
	public long getInterviewTo() {
		return _interviewTo;
	}

	@Override
	public void setInterviewTo(long interviewTo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_interviewTo = interviewTo;
	}

	@JSON
	@Override
	public String getInterviewers() {
		if (_interviewers == null) {
			return "";
		}
		else {
			return _interviewers;
		}
	}

	@Override
	public void setInterviewers(String interviewers) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_interviewers = interviewers;
	}

	@JSON
	@Override
	public long getInterviewOwner() {
		return _interviewOwner;
	}

	@Override
	public void setInterviewOwner(long interviewOwner) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_interviewOwner = interviewOwner;
	}

	@JSON
	@Override
	public String getScheduleComments() {
		if (_scheduleComments == null) {
			return "";
		}
		else {
			return _scheduleComments;
		}
	}

	@Override
	public void setScheduleComments(String scheduleComments) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_scheduleComments = scheduleComments;
	}

	@JSON
	@Override
	public String getLocation() {
		if (_location == null) {
			return "";
		}
		else {
			return _location;
		}
	}

	@Override
	public void setLocation(String location) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_location = location;
	}

	@JSON
	@Override
	public long getAttachmentId() {
		return _attachmentId;
	}

	@Override
	public void setAttachmentId(long attachmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_attachmentId = attachmentId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalAttachmentId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("attachmentId"));
	}

	@JSON
	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdBy = createdBy;
	}

	@JSON
	@Override
	public long getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(long createdDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdDate = createdDate;
	}

	@JSON
	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedBy = modifiedBy;
	}

	@JSON
	@Override
	public long getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(long modifiedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
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
			0, InterviewInfo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public InterviewInfo toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, InterviewInfo>
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
		InterviewInfoImpl interviewInfoImpl = new InterviewInfoImpl();

		interviewInfoImpl.setUuid(getUuid());
		interviewInfoImpl.setInterviewId(getInterviewId());
		interviewInfoImpl.setInterviewName(getInterviewName());
		interviewInfoImpl.setPostingTitleId(getPostingTitleId());
		interviewInfoImpl.setCandidateId(getCandidateId());
		interviewInfoImpl.setClientId(getClientId());
		interviewInfoImpl.setInterviewFrom(getInterviewFrom());
		interviewInfoImpl.setInterviewTo(getInterviewTo());
		interviewInfoImpl.setInterviewers(getInterviewers());
		interviewInfoImpl.setInterviewOwner(getInterviewOwner());
		interviewInfoImpl.setScheduleComments(getScheduleComments());
		interviewInfoImpl.setLocation(getLocation());
		interviewInfoImpl.setAttachmentId(getAttachmentId());
		interviewInfoImpl.setCreatedBy(getCreatedBy());
		interviewInfoImpl.setCreatedDate(getCreatedDate());
		interviewInfoImpl.setModifiedBy(getModifiedBy());
		interviewInfoImpl.setModifiedDate(getModifiedDate());

		interviewInfoImpl.resetOriginalValues();

		return interviewInfoImpl;
	}

	@Override
	public InterviewInfo cloneWithOriginalValues() {
		InterviewInfoImpl interviewInfoImpl = new InterviewInfoImpl();

		interviewInfoImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		interviewInfoImpl.setInterviewId(
			this.<Long>getColumnOriginalValue("interviewId"));
		interviewInfoImpl.setInterviewName(
			this.<String>getColumnOriginalValue("interviewName"));
		interviewInfoImpl.setPostingTitleId(
			this.<Long>getColumnOriginalValue("postingTitleId"));
		interviewInfoImpl.setCandidateId(
			this.<Long>getColumnOriginalValue("candidateId"));
		interviewInfoImpl.setClientId(
			this.<Long>getColumnOriginalValue("clientId"));
		interviewInfoImpl.setInterviewFrom(
			this.<Long>getColumnOriginalValue("interviewFrom"));
		interviewInfoImpl.setInterviewTo(
			this.<Long>getColumnOriginalValue("interviewTo"));
		interviewInfoImpl.setInterviewers(
			this.<String>getColumnOriginalValue("interviewers"));
		interviewInfoImpl.setInterviewOwner(
			this.<Long>getColumnOriginalValue("interviewOwner"));
		interviewInfoImpl.setScheduleComments(
			this.<String>getColumnOriginalValue("scheduleComments"));
		interviewInfoImpl.setLocation(
			this.<String>getColumnOriginalValue("location"));
		interviewInfoImpl.setAttachmentId(
			this.<Long>getColumnOriginalValue("attachmentId"));
		interviewInfoImpl.setCreatedBy(
			this.<Long>getColumnOriginalValue("createdBy"));
		interviewInfoImpl.setCreatedDate(
			this.<Long>getColumnOriginalValue("createdDate"));
		interviewInfoImpl.setModifiedBy(
			this.<Long>getColumnOriginalValue("modifiedBy"));
		interviewInfoImpl.setModifiedDate(
			this.<Long>getColumnOriginalValue("modifiedDate"));

		return interviewInfoImpl;
	}

	@Override
	public int compareTo(InterviewInfo interviewInfo) {
		long primaryKey = interviewInfo.getPrimaryKey();

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

		if (!(object instanceof InterviewInfo)) {
			return false;
		}

		InterviewInfo interviewInfo = (InterviewInfo)object;

		long primaryKey = interviewInfo.getPrimaryKey();

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
	public CacheModel<InterviewInfo> toCacheModel() {
		InterviewInfoCacheModel interviewInfoCacheModel =
			new InterviewInfoCacheModel();

		interviewInfoCacheModel.uuid = getUuid();

		String uuid = interviewInfoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			interviewInfoCacheModel.uuid = null;
		}

		interviewInfoCacheModel.interviewId = getInterviewId();

		interviewInfoCacheModel.interviewName = getInterviewName();

		String interviewName = interviewInfoCacheModel.interviewName;

		if ((interviewName != null) && (interviewName.length() == 0)) {
			interviewInfoCacheModel.interviewName = null;
		}

		interviewInfoCacheModel.postingTitleId = getPostingTitleId();

		interviewInfoCacheModel.candidateId = getCandidateId();

		interviewInfoCacheModel.clientId = getClientId();

		interviewInfoCacheModel.interviewFrom = getInterviewFrom();

		interviewInfoCacheModel.interviewTo = getInterviewTo();

		interviewInfoCacheModel.interviewers = getInterviewers();

		String interviewers = interviewInfoCacheModel.interviewers;

		if ((interviewers != null) && (interviewers.length() == 0)) {
			interviewInfoCacheModel.interviewers = null;
		}

		interviewInfoCacheModel.interviewOwner = getInterviewOwner();

		interviewInfoCacheModel.scheduleComments = getScheduleComments();

		String scheduleComments = interviewInfoCacheModel.scheduleComments;

		if ((scheduleComments != null) && (scheduleComments.length() == 0)) {
			interviewInfoCacheModel.scheduleComments = null;
		}

		interviewInfoCacheModel.location = getLocation();

		String location = interviewInfoCacheModel.location;

		if ((location != null) && (location.length() == 0)) {
			interviewInfoCacheModel.location = null;
		}

		interviewInfoCacheModel.attachmentId = getAttachmentId();

		interviewInfoCacheModel.createdBy = getCreatedBy();

		interviewInfoCacheModel.createdDate = getCreatedDate();

		interviewInfoCacheModel.modifiedBy = getModifiedBy();

		interviewInfoCacheModel.modifiedDate = getModifiedDate();

		return interviewInfoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<InterviewInfo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<InterviewInfo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<InterviewInfo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((InterviewInfo)this);

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
		Map<String, Function<InterviewInfo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<InterviewInfo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<InterviewInfo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((InterviewInfo)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, InterviewInfo>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _interviewId;
	private String _interviewName;
	private long _postingTitleId;
	private long _candidateId;
	private long _clientId;
	private long _interviewFrom;
	private long _interviewTo;
	private String _interviewers;
	private long _interviewOwner;
	private String _scheduleComments;
	private String _location;
	private long _attachmentId;
	private long _createdBy;
	private long _createdDate;
	private long _modifiedBy;
	private long _modifiedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<InterviewInfo, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((InterviewInfo)this);
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
		_columnOriginalValues.put("interviewId", _interviewId);
		_columnOriginalValues.put("interviewName", _interviewName);
		_columnOriginalValues.put("postingTitleId", _postingTitleId);
		_columnOriginalValues.put("candidateId", _candidateId);
		_columnOriginalValues.put("clientId", _clientId);
		_columnOriginalValues.put("interviewFrom", _interviewFrom);
		_columnOriginalValues.put("interviewTo", _interviewTo);
		_columnOriginalValues.put("interviewers", _interviewers);
		_columnOriginalValues.put("interviewOwner", _interviewOwner);
		_columnOriginalValues.put("scheduleComments", _scheduleComments);
		_columnOriginalValues.put("location", _location);
		_columnOriginalValues.put("attachmentId", _attachmentId);
		_columnOriginalValues.put("createdBy", _createdBy);
		_columnOriginalValues.put("createdDate", _createdDate);
		_columnOriginalValues.put("modifiedBy", _modifiedBy);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

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

		columnBitmasks.put("interviewId", 2L);

		columnBitmasks.put("interviewName", 4L);

		columnBitmasks.put("postingTitleId", 8L);

		columnBitmasks.put("candidateId", 16L);

		columnBitmasks.put("clientId", 32L);

		columnBitmasks.put("interviewFrom", 64L);

		columnBitmasks.put("interviewTo", 128L);

		columnBitmasks.put("interviewers", 256L);

		columnBitmasks.put("interviewOwner", 512L);

		columnBitmasks.put("scheduleComments", 1024L);

		columnBitmasks.put("location", 2048L);

		columnBitmasks.put("attachmentId", 4096L);

		columnBitmasks.put("createdBy", 8192L);

		columnBitmasks.put("createdDate", 16384L);

		columnBitmasks.put("modifiedBy", 32768L);

		columnBitmasks.put("modifiedDate", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private InterviewInfo _escapedModel;

}