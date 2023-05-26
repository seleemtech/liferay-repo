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

package com.intranet.model.impl;

import com.intranet.model.EmployeeDetails;
import com.intranet.model.EmployeeDetailsModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * The base model implementation for the EmployeeDetails service. Represents a row in the &quot;INTRANET_EmployeeDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeDetailsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsImpl
 * @generated
 */
public class EmployeeDetailsModelImpl
	extends BaseModelImpl<EmployeeDetails> implements EmployeeDetailsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee details model instance should use the <code>EmployeeDetails</code> interface instead.
	 */
	public static final String TABLE_NAME = "INTRANET_EmployeeDetails";

	public static final Object[][] TABLE_COLUMNS = {
		{"employeeID", Types.BIGINT}, {"employeename", Types.VARCHAR},
		{"gender", Types.VARCHAR}, {"domain", Types.VARCHAR},
		{"contact", Types.BIGINT}, {"email", Types.VARCHAR},
		{"address", Types.VARCHAR}, {"pannumber", Types.VARCHAR},
		{"passportNumber", Types.VARCHAR}, {"aadhar", Types.VARCHAR},
		{"joiningDate", Types.TIMESTAMP}, {"dob", Types.TIMESTAMP},
		{"maritalstatus", Types.BOOLEAN}, {"anniversaryDate", Types.TIMESTAMP},
		{"fileEntryId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("employeeID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeename", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("gender", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("domain", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contact", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pannumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("passportNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("aadhar", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("joiningDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dob", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("maritalstatus", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("anniversaryDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table INTRANET_EmployeeDetails (employeeID LONG not null primary key,employeename VARCHAR(75) null,gender VARCHAR(75) null,domain VARCHAR(75) null,contact LONG,email VARCHAR(75) null,address VARCHAR(75) null,pannumber VARCHAR(75) null,passportNumber VARCHAR(75) null,aadhar VARCHAR(75) null,joiningDate DATE null,dob DATE null,maritalstatus BOOLEAN,anniversaryDate DATE null,fileEntryId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table INTRANET_EmployeeDetails";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeDetails.employeeID ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY INTRANET_EmployeeDetails.employeeID ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMPLOYEENAME_COLUMN_BITMASK = 2L;

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

	public EmployeeDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeDetails.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeDetails, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeDetails)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeDetails, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeDetails, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeDetails)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeDetails, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeDetails, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<EmployeeDetails, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EmployeeDetails, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EmployeeDetails, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<EmployeeDetails, Object>>();
		Map<String, BiConsumer<EmployeeDetails, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<EmployeeDetails, ?>>();

		attributeGetterFunctions.put(
			"employeeID", EmployeeDetails::getEmployeeID);
		attributeSetterBiConsumers.put(
			"employeeID",
			(BiConsumer<EmployeeDetails, Long>)EmployeeDetails::setEmployeeID);
		attributeGetterFunctions.put(
			"employeename", EmployeeDetails::getEmployeename);
		attributeSetterBiConsumers.put(
			"employeename",
			(BiConsumer<EmployeeDetails, String>)
				EmployeeDetails::setEmployeename);
		attributeGetterFunctions.put("gender", EmployeeDetails::getGender);
		attributeSetterBiConsumers.put(
			"gender",
			(BiConsumer<EmployeeDetails, String>)EmployeeDetails::setGender);
		attributeGetterFunctions.put("domain", EmployeeDetails::getDomain);
		attributeSetterBiConsumers.put(
			"domain",
			(BiConsumer<EmployeeDetails, String>)EmployeeDetails::setDomain);
		attributeGetterFunctions.put("contact", EmployeeDetails::getContact);
		attributeSetterBiConsumers.put(
			"contact",
			(BiConsumer<EmployeeDetails, Long>)EmployeeDetails::setContact);
		attributeGetterFunctions.put("email", EmployeeDetails::getEmail);
		attributeSetterBiConsumers.put(
			"email",
			(BiConsumer<EmployeeDetails, String>)EmployeeDetails::setEmail);
		attributeGetterFunctions.put("address", EmployeeDetails::getAddress);
		attributeSetterBiConsumers.put(
			"address",
			(BiConsumer<EmployeeDetails, String>)EmployeeDetails::setAddress);
		attributeGetterFunctions.put(
			"pannumber", EmployeeDetails::getPannumber);
		attributeSetterBiConsumers.put(
			"pannumber",
			(BiConsumer<EmployeeDetails, String>)EmployeeDetails::setPannumber);
		attributeGetterFunctions.put(
			"passportNumber", EmployeeDetails::getPassportNumber);
		attributeSetterBiConsumers.put(
			"passportNumber",
			(BiConsumer<EmployeeDetails, String>)
				EmployeeDetails::setPassportNumber);
		attributeGetterFunctions.put("aadhar", EmployeeDetails::getAadhar);
		attributeSetterBiConsumers.put(
			"aadhar",
			(BiConsumer<EmployeeDetails, String>)EmployeeDetails::setAadhar);
		attributeGetterFunctions.put(
			"joiningDate", EmployeeDetails::getJoiningDate);
		attributeSetterBiConsumers.put(
			"joiningDate",
			(BiConsumer<EmployeeDetails, Date>)EmployeeDetails::setJoiningDate);
		attributeGetterFunctions.put("dob", EmployeeDetails::getDob);
		attributeSetterBiConsumers.put(
			"dob", (BiConsumer<EmployeeDetails, Date>)EmployeeDetails::setDob);
		attributeGetterFunctions.put(
			"maritalstatus", EmployeeDetails::getMaritalstatus);
		attributeSetterBiConsumers.put(
			"maritalstatus",
			(BiConsumer<EmployeeDetails, Boolean>)
				EmployeeDetails::setMaritalstatus);
		attributeGetterFunctions.put(
			"anniversaryDate", EmployeeDetails::getAnniversaryDate);
		attributeSetterBiConsumers.put(
			"anniversaryDate",
			(BiConsumer<EmployeeDetails, Date>)
				EmployeeDetails::setAnniversaryDate);
		attributeGetterFunctions.put(
			"fileEntryId", EmployeeDetails::getFileEntryId);
		attributeSetterBiConsumers.put(
			"fileEntryId",
			(BiConsumer<EmployeeDetails, Long>)EmployeeDetails::setFileEntryId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getEmployeeID() {
		return _employeeID;
	}

	@Override
	public void setEmployeeID(long employeeID) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeID = employeeID;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEmployeeID() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("employeeID"));
	}

	@Override
	public String getEmployeename() {
		if (_employeename == null) {
			return "";
		}
		else {
			return _employeename;
		}
	}

	@Override
	public void setEmployeename(String employeename) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeename = employeename;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalEmployeename() {
		return getColumnOriginalValue("employeename");
	}

	@Override
	public String getGender() {
		if (_gender == null) {
			return "";
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gender = gender;
	}

	@Override
	public String getDomain() {
		if (_domain == null) {
			return "";
		}
		else {
			return _domain;
		}
	}

	@Override
	public void setDomain(String domain) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_domain = domain;
	}

	@Override
	public long getContact() {
		return _contact;
	}

	@Override
	public void setContact(long contact) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_contact = contact;
	}

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

	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_address = address;
	}

	@Override
	public String getPannumber() {
		if (_pannumber == null) {
			return "";
		}
		else {
			return _pannumber;
		}
	}

	@Override
	public void setPannumber(String pannumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_pannumber = pannumber;
	}

	@Override
	public String getPassportNumber() {
		if (_passportNumber == null) {
			return "";
		}
		else {
			return _passportNumber;
		}
	}

	@Override
	public void setPassportNumber(String passportNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_passportNumber = passportNumber;
	}

	@Override
	public String getAadhar() {
		if (_aadhar == null) {
			return "";
		}
		else {
			return _aadhar;
		}
	}

	@Override
	public void setAadhar(String aadhar) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_aadhar = aadhar;
	}

	@Override
	public Date getJoiningDate() {
		return _joiningDate;
	}

	@Override
	public void setJoiningDate(Date joiningDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_joiningDate = joiningDate;
	}

	@Override
	public Date getDob() {
		return _dob;
	}

	@Override
	public void setDob(Date dob) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dob = dob;
	}

	@Override
	public boolean getMaritalstatus() {
		return _maritalstatus;
	}

	@Override
	public boolean isMaritalstatus() {
		return _maritalstatus;
	}

	@Override
	public void setMaritalstatus(boolean maritalstatus) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_maritalstatus = maritalstatus;
	}

	@Override
	public Date getAnniversaryDate() {
		return _anniversaryDate;
	}

	@Override
	public void setAnniversaryDate(Date anniversaryDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_anniversaryDate = anniversaryDate;
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileEntryId = fileEntryId;
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
			0, EmployeeDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeDetails toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeDetails>
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
		EmployeeDetailsImpl employeeDetailsImpl = new EmployeeDetailsImpl();

		employeeDetailsImpl.setEmployeeID(getEmployeeID());
		employeeDetailsImpl.setEmployeename(getEmployeename());
		employeeDetailsImpl.setGender(getGender());
		employeeDetailsImpl.setDomain(getDomain());
		employeeDetailsImpl.setContact(getContact());
		employeeDetailsImpl.setEmail(getEmail());
		employeeDetailsImpl.setAddress(getAddress());
		employeeDetailsImpl.setPannumber(getPannumber());
		employeeDetailsImpl.setPassportNumber(getPassportNumber());
		employeeDetailsImpl.setAadhar(getAadhar());
		employeeDetailsImpl.setJoiningDate(getJoiningDate());
		employeeDetailsImpl.setDob(getDob());
		employeeDetailsImpl.setMaritalstatus(isMaritalstatus());
		employeeDetailsImpl.setAnniversaryDate(getAnniversaryDate());
		employeeDetailsImpl.setFileEntryId(getFileEntryId());

		employeeDetailsImpl.resetOriginalValues();

		return employeeDetailsImpl;
	}

	@Override
	public EmployeeDetails cloneWithOriginalValues() {
		EmployeeDetailsImpl employeeDetailsImpl = new EmployeeDetailsImpl();

		employeeDetailsImpl.setEmployeeID(
			this.<Long>getColumnOriginalValue("employeeID"));
		employeeDetailsImpl.setEmployeename(
			this.<String>getColumnOriginalValue("employeename"));
		employeeDetailsImpl.setGender(
			this.<String>getColumnOriginalValue("gender"));
		employeeDetailsImpl.setDomain(
			this.<String>getColumnOriginalValue("domain"));
		employeeDetailsImpl.setContact(
			this.<Long>getColumnOriginalValue("contact"));
		employeeDetailsImpl.setEmail(
			this.<String>getColumnOriginalValue("email"));
		employeeDetailsImpl.setAddress(
			this.<String>getColumnOriginalValue("address"));
		employeeDetailsImpl.setPannumber(
			this.<String>getColumnOriginalValue("pannumber"));
		employeeDetailsImpl.setPassportNumber(
			this.<String>getColumnOriginalValue("passportNumber"));
		employeeDetailsImpl.setAadhar(
			this.<String>getColumnOriginalValue("aadhar"));
		employeeDetailsImpl.setJoiningDate(
			this.<Date>getColumnOriginalValue("joiningDate"));
		employeeDetailsImpl.setDob(this.<Date>getColumnOriginalValue("dob"));
		employeeDetailsImpl.setMaritalstatus(
			this.<Boolean>getColumnOriginalValue("maritalstatus"));
		employeeDetailsImpl.setAnniversaryDate(
			this.<Date>getColumnOriginalValue("anniversaryDate"));
		employeeDetailsImpl.setFileEntryId(
			this.<Long>getColumnOriginalValue("fileEntryId"));

		return employeeDetailsImpl;
	}

	@Override
	public int compareTo(EmployeeDetails employeeDetails) {
		long primaryKey = employeeDetails.getPrimaryKey();

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

		if (!(object instanceof EmployeeDetails)) {
			return false;
		}

		EmployeeDetails employeeDetails = (EmployeeDetails)object;

		long primaryKey = employeeDetails.getPrimaryKey();

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
	public CacheModel<EmployeeDetails> toCacheModel() {
		EmployeeDetailsCacheModel employeeDetailsCacheModel =
			new EmployeeDetailsCacheModel();

		employeeDetailsCacheModel.employeeID = getEmployeeID();

		employeeDetailsCacheModel.employeename = getEmployeename();

		String employeename = employeeDetailsCacheModel.employeename;

		if ((employeename != null) && (employeename.length() == 0)) {
			employeeDetailsCacheModel.employeename = null;
		}

		employeeDetailsCacheModel.gender = getGender();

		String gender = employeeDetailsCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			employeeDetailsCacheModel.gender = null;
		}

		employeeDetailsCacheModel.domain = getDomain();

		String domain = employeeDetailsCacheModel.domain;

		if ((domain != null) && (domain.length() == 0)) {
			employeeDetailsCacheModel.domain = null;
		}

		employeeDetailsCacheModel.contact = getContact();

		employeeDetailsCacheModel.email = getEmail();

		String email = employeeDetailsCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			employeeDetailsCacheModel.email = null;
		}

		employeeDetailsCacheModel.address = getAddress();

		String address = employeeDetailsCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			employeeDetailsCacheModel.address = null;
		}

		employeeDetailsCacheModel.pannumber = getPannumber();

		String pannumber = employeeDetailsCacheModel.pannumber;

		if ((pannumber != null) && (pannumber.length() == 0)) {
			employeeDetailsCacheModel.pannumber = null;
		}

		employeeDetailsCacheModel.passportNumber = getPassportNumber();

		String passportNumber = employeeDetailsCacheModel.passportNumber;

		if ((passportNumber != null) && (passportNumber.length() == 0)) {
			employeeDetailsCacheModel.passportNumber = null;
		}

		employeeDetailsCacheModel.aadhar = getAadhar();

		String aadhar = employeeDetailsCacheModel.aadhar;

		if ((aadhar != null) && (aadhar.length() == 0)) {
			employeeDetailsCacheModel.aadhar = null;
		}

		Date joiningDate = getJoiningDate();

		if (joiningDate != null) {
			employeeDetailsCacheModel.joiningDate = joiningDate.getTime();
		}
		else {
			employeeDetailsCacheModel.joiningDate = Long.MIN_VALUE;
		}

		Date dob = getDob();

		if (dob != null) {
			employeeDetailsCacheModel.dob = dob.getTime();
		}
		else {
			employeeDetailsCacheModel.dob = Long.MIN_VALUE;
		}

		employeeDetailsCacheModel.maritalstatus = isMaritalstatus();

		Date anniversaryDate = getAnniversaryDate();

		if (anniversaryDate != null) {
			employeeDetailsCacheModel.anniversaryDate =
				anniversaryDate.getTime();
		}
		else {
			employeeDetailsCacheModel.anniversaryDate = Long.MIN_VALUE;
		}

		employeeDetailsCacheModel.fileEntryId = getFileEntryId();

		return employeeDetailsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((EmployeeDetails)this);

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
		Map<String, Function<EmployeeDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmployeeDetails)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeeDetails>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					EmployeeDetails.class, ModelWrapper.class);

	}

	private long _employeeID;
	private String _employeename;
	private String _gender;
	private String _domain;
	private long _contact;
	private String _email;
	private String _address;
	private String _pannumber;
	private String _passportNumber;
	private String _aadhar;
	private Date _joiningDate;
	private Date _dob;
	private boolean _maritalstatus;
	private Date _anniversaryDate;
	private long _fileEntryId;

	public <T> T getColumnValue(String columnName) {
		Function<EmployeeDetails, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeDetails)this);
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

		_columnOriginalValues.put("employeeID", _employeeID);
		_columnOriginalValues.put("employeename", _employeename);
		_columnOriginalValues.put("gender", _gender);
		_columnOriginalValues.put("domain", _domain);
		_columnOriginalValues.put("contact", _contact);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("address", _address);
		_columnOriginalValues.put("pannumber", _pannumber);
		_columnOriginalValues.put("passportNumber", _passportNumber);
		_columnOriginalValues.put("aadhar", _aadhar);
		_columnOriginalValues.put("joiningDate", _joiningDate);
		_columnOriginalValues.put("dob", _dob);
		_columnOriginalValues.put("maritalstatus", _maritalstatus);
		_columnOriginalValues.put("anniversaryDate", _anniversaryDate);
		_columnOriginalValues.put("fileEntryId", _fileEntryId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("employeeID", 1L);

		columnBitmasks.put("employeename", 2L);

		columnBitmasks.put("gender", 4L);

		columnBitmasks.put("domain", 8L);

		columnBitmasks.put("contact", 16L);

		columnBitmasks.put("email", 32L);

		columnBitmasks.put("address", 64L);

		columnBitmasks.put("pannumber", 128L);

		columnBitmasks.put("passportNumber", 256L);

		columnBitmasks.put("aadhar", 512L);

		columnBitmasks.put("joiningDate", 1024L);

		columnBitmasks.put("dob", 2048L);

		columnBitmasks.put("maritalstatus", 4096L);

		columnBitmasks.put("anniversaryDate", 8192L);

		columnBitmasks.put("fileEntryId", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeDetails _escapedModel;

}