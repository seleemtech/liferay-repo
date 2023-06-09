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

package com.candidate.service.model.impl;

import com.candidate.service.model.CandidateInfo;
import com.candidate.service.model.CandidateInfoModel;
import com.candidate.service.model.CandidateInfoSoap;

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
 * The base model implementation for the CandidateInfo service. Represents a row in the &quot;RMS_CandidateInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CandidateInfoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CandidateInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateInfoImpl
 * @generated
 */
@JSON(strict = true)
public class CandidateInfoModelImpl
	extends BaseModelImpl<CandidateInfo> implements CandidateInfoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a candidate info model instance should use the <code>CandidateInfo</code> interface instead.
	 */
	public static final String TABLE_NAME = "RMS_CandidateInfo";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"candidateId", Types.BIGINT},
		{"firstName", Types.VARCHAR}, {"lastName", Types.VARCHAR},
		{"email", Types.VARCHAR}, {"secondaryEmail", Types.VARCHAR},
		{"mobileNumber", Types.VARCHAR}, {"street", Types.VARCHAR},
		{"country", Types.VARCHAR}, {"city", Types.VARCHAR},
		{"state_", Types.VARCHAR}, {"zipCode", Types.VARCHAR},
		{"houseNumber", Types.VARCHAR}, {"website", Types.VARCHAR},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("candidateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("secondaryEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobileNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("street", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("country", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zipCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("houseNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("website", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table RMS_CandidateInfo (uuid_ VARCHAR(75) null,candidateId LONG not null primary key,firstName VARCHAR(75) null,lastName VARCHAR(75) null,email VARCHAR(75) null,secondaryEmail VARCHAR(75) null,mobileNumber VARCHAR(75) null,street VARCHAR(75) null,country VARCHAR(75) null,city VARCHAR(75) null,state_ VARCHAR(75) null,zipCode VARCHAR(75) null,houseNumber VARCHAR(75) null,website VARCHAR(75) null,companyId LONG,userId LONG)";

	public static final String TABLE_SQL_DROP = "drop table RMS_CandidateInfo";

	public static final String ORDER_BY_JPQL =
		" ORDER BY candidateInfo.candidateId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY RMS_CandidateInfo.candidateId ASC";

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
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CANDIDATEID_COLUMN_BITMASK = 4L;

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
	public static CandidateInfo toModel(CandidateInfoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CandidateInfo model = new CandidateInfoImpl();

		model.setUuid(soapModel.getUuid());
		model.setCandidateId(soapModel.getCandidateId());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setEmail(soapModel.getEmail());
		model.setSecondaryEmail(soapModel.getSecondaryEmail());
		model.setMobileNumber(soapModel.getMobileNumber());
		model.setStreet(soapModel.getStreet());
		model.setCountry(soapModel.getCountry());
		model.setCity(soapModel.getCity());
		model.setState(soapModel.getState());
		model.setZipCode(soapModel.getZipCode());
		model.setHouseNumber(soapModel.getHouseNumber());
		model.setWebsite(soapModel.getWebsite());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());

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
	public static List<CandidateInfo> toModels(CandidateInfoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CandidateInfo> models = new ArrayList<CandidateInfo>(
			soapModels.length);

		for (CandidateInfoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CandidateInfoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _candidateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCandidateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateInfo.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CandidateInfo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CandidateInfo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CandidateInfo, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CandidateInfo)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CandidateInfo, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CandidateInfo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CandidateInfo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CandidateInfo, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CandidateInfo, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CandidateInfo>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CandidateInfo.class.getClassLoader(), CandidateInfo.class,
			ModelWrapper.class);

		try {
			Constructor<CandidateInfo> constructor =
				(Constructor<CandidateInfo>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CandidateInfo, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CandidateInfo, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CandidateInfo, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CandidateInfo, Object>>();
		Map<String, BiConsumer<CandidateInfo, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CandidateInfo, ?>>();

		attributeGetterFunctions.put("uuid", CandidateInfo::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CandidateInfo, String>)CandidateInfo::setUuid);
		attributeGetterFunctions.put(
			"candidateId", CandidateInfo::getCandidateId);
		attributeSetterBiConsumers.put(
			"candidateId",
			(BiConsumer<CandidateInfo, Long>)CandidateInfo::setCandidateId);
		attributeGetterFunctions.put("firstName", CandidateInfo::getFirstName);
		attributeSetterBiConsumers.put(
			"firstName",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setFirstName);
		attributeGetterFunctions.put("lastName", CandidateInfo::getLastName);
		attributeSetterBiConsumers.put(
			"lastName",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setLastName);
		attributeGetterFunctions.put("email", CandidateInfo::getEmail);
		attributeSetterBiConsumers.put(
			"email",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setEmail);
		attributeGetterFunctions.put(
			"secondaryEmail", CandidateInfo::getSecondaryEmail);
		attributeSetterBiConsumers.put(
			"secondaryEmail",
			(BiConsumer<CandidateInfo, String>)
				CandidateInfo::setSecondaryEmail);
		attributeGetterFunctions.put(
			"mobileNumber", CandidateInfo::getMobileNumber);
		attributeSetterBiConsumers.put(
			"mobileNumber",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setMobileNumber);
		attributeGetterFunctions.put("street", CandidateInfo::getStreet);
		attributeSetterBiConsumers.put(
			"street",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setStreet);
		attributeGetterFunctions.put("country", CandidateInfo::getCountry);
		attributeSetterBiConsumers.put(
			"country",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setCountry);
		attributeGetterFunctions.put("city", CandidateInfo::getCity);
		attributeSetterBiConsumers.put(
			"city", (BiConsumer<CandidateInfo, String>)CandidateInfo::setCity);
		attributeGetterFunctions.put("state", CandidateInfo::getState);
		attributeSetterBiConsumers.put(
			"state",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setState);
		attributeGetterFunctions.put("zipCode", CandidateInfo::getZipCode);
		attributeSetterBiConsumers.put(
			"zipCode",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setZipCode);
		attributeGetterFunctions.put(
			"houseNumber", CandidateInfo::getHouseNumber);
		attributeSetterBiConsumers.put(
			"houseNumber",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setHouseNumber);
		attributeGetterFunctions.put("website", CandidateInfo::getWebsite);
		attributeSetterBiConsumers.put(
			"website",
			(BiConsumer<CandidateInfo, String>)CandidateInfo::setWebsite);
		attributeGetterFunctions.put("companyId", CandidateInfo::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CandidateInfo, Long>)CandidateInfo::setCompanyId);
		attributeGetterFunctions.put("userId", CandidateInfo::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CandidateInfo, Long>)CandidateInfo::setUserId);

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
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastName = lastName;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	@JSON
	@Override
	public String getSecondaryEmail() {
		if (_secondaryEmail == null) {
			return "";
		}
		else {
			return _secondaryEmail;
		}
	}

	@Override
	public void setSecondaryEmail(String secondaryEmail) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_secondaryEmail = secondaryEmail;
	}

	@JSON
	@Override
	public String getMobileNumber() {
		if (_mobileNumber == null) {
			return "";
		}
		else {
			return _mobileNumber;
		}
	}

	@Override
	public void setMobileNumber(String mobileNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mobileNumber = mobileNumber;
	}

	@JSON
	@Override
	public String getStreet() {
		if (_street == null) {
			return "";
		}
		else {
			return _street;
		}
	}

	@Override
	public void setStreet(String street) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_street = street;
	}

	@JSON
	@Override
	public String getCountry() {
		if (_country == null) {
			return "";
		}
		else {
			return _country;
		}
	}

	@Override
	public void setCountry(String country) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_country = country;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return "";
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_city = city;
	}

	@JSON
	@Override
	public String getState() {
		if (_state == null) {
			return "";
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_state = state;
	}

	@JSON
	@Override
	public String getZipCode() {
		if (_zipCode == null) {
			return "";
		}
		else {
			return _zipCode;
		}
	}

	@Override
	public void setZipCode(String zipCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_zipCode = zipCode;
	}

	@JSON
	@Override
	public String getHouseNumber() {
		if (_houseNumber == null) {
			return "";
		}
		else {
			return _houseNumber;
		}
	}

	@Override
	public void setHouseNumber(String houseNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_houseNumber = houseNumber;
	}

	@JSON
	@Override
	public String getWebsite() {
		if (_website == null) {
			return "";
		}
		else {
			return _website;
		}
	}

	@Override
	public void setWebsite(String website) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_website = website;
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
			getCompanyId(), CandidateInfo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CandidateInfo toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CandidateInfo>
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
		CandidateInfoImpl candidateInfoImpl = new CandidateInfoImpl();

		candidateInfoImpl.setUuid(getUuid());
		candidateInfoImpl.setCandidateId(getCandidateId());
		candidateInfoImpl.setFirstName(getFirstName());
		candidateInfoImpl.setLastName(getLastName());
		candidateInfoImpl.setEmail(getEmail());
		candidateInfoImpl.setSecondaryEmail(getSecondaryEmail());
		candidateInfoImpl.setMobileNumber(getMobileNumber());
		candidateInfoImpl.setStreet(getStreet());
		candidateInfoImpl.setCountry(getCountry());
		candidateInfoImpl.setCity(getCity());
		candidateInfoImpl.setState(getState());
		candidateInfoImpl.setZipCode(getZipCode());
		candidateInfoImpl.setHouseNumber(getHouseNumber());
		candidateInfoImpl.setWebsite(getWebsite());
		candidateInfoImpl.setCompanyId(getCompanyId());
		candidateInfoImpl.setUserId(getUserId());

		candidateInfoImpl.resetOriginalValues();

		return candidateInfoImpl;
	}

	@Override
	public CandidateInfo cloneWithOriginalValues() {
		CandidateInfoImpl candidateInfoImpl = new CandidateInfoImpl();

		candidateInfoImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		candidateInfoImpl.setCandidateId(
			this.<Long>getColumnOriginalValue("candidateId"));
		candidateInfoImpl.setFirstName(
			this.<String>getColumnOriginalValue("firstName"));
		candidateInfoImpl.setLastName(
			this.<String>getColumnOriginalValue("lastName"));
		candidateInfoImpl.setEmail(
			this.<String>getColumnOriginalValue("email"));
		candidateInfoImpl.setSecondaryEmail(
			this.<String>getColumnOriginalValue("secondaryEmail"));
		candidateInfoImpl.setMobileNumber(
			this.<String>getColumnOriginalValue("mobileNumber"));
		candidateInfoImpl.setStreet(
			this.<String>getColumnOriginalValue("street"));
		candidateInfoImpl.setCountry(
			this.<String>getColumnOriginalValue("country"));
		candidateInfoImpl.setCity(this.<String>getColumnOriginalValue("city"));
		candidateInfoImpl.setState(
			this.<String>getColumnOriginalValue("state_"));
		candidateInfoImpl.setZipCode(
			this.<String>getColumnOriginalValue("zipCode"));
		candidateInfoImpl.setHouseNumber(
			this.<String>getColumnOriginalValue("houseNumber"));
		candidateInfoImpl.setWebsite(
			this.<String>getColumnOriginalValue("website"));
		candidateInfoImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		candidateInfoImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));

		return candidateInfoImpl;
	}

	@Override
	public int compareTo(CandidateInfo candidateInfo) {
		long primaryKey = candidateInfo.getPrimaryKey();

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

		if (!(object instanceof CandidateInfo)) {
			return false;
		}

		CandidateInfo candidateInfo = (CandidateInfo)object;

		long primaryKey = candidateInfo.getPrimaryKey();

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
	public CacheModel<CandidateInfo> toCacheModel() {
		CandidateInfoCacheModel candidateInfoCacheModel =
			new CandidateInfoCacheModel();

		candidateInfoCacheModel.uuid = getUuid();

		String uuid = candidateInfoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			candidateInfoCacheModel.uuid = null;
		}

		candidateInfoCacheModel.candidateId = getCandidateId();

		candidateInfoCacheModel.firstName = getFirstName();

		String firstName = candidateInfoCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			candidateInfoCacheModel.firstName = null;
		}

		candidateInfoCacheModel.lastName = getLastName();

		String lastName = candidateInfoCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			candidateInfoCacheModel.lastName = null;
		}

		candidateInfoCacheModel.email = getEmail();

		String email = candidateInfoCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			candidateInfoCacheModel.email = null;
		}

		candidateInfoCacheModel.secondaryEmail = getSecondaryEmail();

		String secondaryEmail = candidateInfoCacheModel.secondaryEmail;

		if ((secondaryEmail != null) && (secondaryEmail.length() == 0)) {
			candidateInfoCacheModel.secondaryEmail = null;
		}

		candidateInfoCacheModel.mobileNumber = getMobileNumber();

		String mobileNumber = candidateInfoCacheModel.mobileNumber;

		if ((mobileNumber != null) && (mobileNumber.length() == 0)) {
			candidateInfoCacheModel.mobileNumber = null;
		}

		candidateInfoCacheModel.street = getStreet();

		String street = candidateInfoCacheModel.street;

		if ((street != null) && (street.length() == 0)) {
			candidateInfoCacheModel.street = null;
		}

		candidateInfoCacheModel.country = getCountry();

		String country = candidateInfoCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			candidateInfoCacheModel.country = null;
		}

		candidateInfoCacheModel.city = getCity();

		String city = candidateInfoCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			candidateInfoCacheModel.city = null;
		}

		candidateInfoCacheModel.state = getState();

		String state = candidateInfoCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			candidateInfoCacheModel.state = null;
		}

		candidateInfoCacheModel.zipCode = getZipCode();

		String zipCode = candidateInfoCacheModel.zipCode;

		if ((zipCode != null) && (zipCode.length() == 0)) {
			candidateInfoCacheModel.zipCode = null;
		}

		candidateInfoCacheModel.houseNumber = getHouseNumber();

		String houseNumber = candidateInfoCacheModel.houseNumber;

		if ((houseNumber != null) && (houseNumber.length() == 0)) {
			candidateInfoCacheModel.houseNumber = null;
		}

		candidateInfoCacheModel.website = getWebsite();

		String website = candidateInfoCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			candidateInfoCacheModel.website = null;
		}

		candidateInfoCacheModel.companyId = getCompanyId();

		candidateInfoCacheModel.userId = getUserId();

		return candidateInfoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CandidateInfo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CandidateInfo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CandidateInfo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CandidateInfo)this);

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
		Map<String, Function<CandidateInfo, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CandidateInfo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CandidateInfo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CandidateInfo)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CandidateInfo>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _candidateId;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _secondaryEmail;
	private String _mobileNumber;
	private String _street;
	private String _country;
	private String _city;
	private String _state;
	private String _zipCode;
	private String _houseNumber;
	private String _website;
	private long _companyId;
	private long _userId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CandidateInfo, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CandidateInfo)this);
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
		_columnOriginalValues.put("candidateId", _candidateId);
		_columnOriginalValues.put("firstName", _firstName);
		_columnOriginalValues.put("lastName", _lastName);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("secondaryEmail", _secondaryEmail);
		_columnOriginalValues.put("mobileNumber", _mobileNumber);
		_columnOriginalValues.put("street", _street);
		_columnOriginalValues.put("country", _country);
		_columnOriginalValues.put("city", _city);
		_columnOriginalValues.put("state_", _state);
		_columnOriginalValues.put("zipCode", _zipCode);
		_columnOriginalValues.put("houseNumber", _houseNumber);
		_columnOriginalValues.put("website", _website);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("state_", "state");

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

		columnBitmasks.put("candidateId", 2L);

		columnBitmasks.put("firstName", 4L);

		columnBitmasks.put("lastName", 8L);

		columnBitmasks.put("email", 16L);

		columnBitmasks.put("secondaryEmail", 32L);

		columnBitmasks.put("mobileNumber", 64L);

		columnBitmasks.put("street", 128L);

		columnBitmasks.put("country", 256L);

		columnBitmasks.put("city", 512L);

		columnBitmasks.put("state_", 1024L);

		columnBitmasks.put("zipCode", 2048L);

		columnBitmasks.put("houseNumber", 4096L);

		columnBitmasks.put("website", 8192L);

		columnBitmasks.put("companyId", 16384L);

		columnBitmasks.put("userId", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CandidateInfo _escapedModel;

}