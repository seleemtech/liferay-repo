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

package SendOtpService.model.impl;

import SendOtpService.model.SendDb;
import SendOtpService.model.SendDbModel;

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
 * The base model implementation for the SendDb service. Represents a row in the &quot;FOO_SendDb&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SendDbModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SendDbImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SendDbImpl
 * @generated
 */
@JSON(strict = true)
public class SendDbModelImpl
	extends BaseModelImpl<SendDb> implements SendDbModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a send db model instance should use the <code>SendDb</code> interface instead.
	 */
	public static final String TABLE_NAME = "FOO_SendDb";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"sendId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"mobileNumber", Types.BIGINT},
		{"Name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sendId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobileNumber", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("Name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table FOO_SendDb (uuid_ VARCHAR(75) null,sendId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,mobileNumber LONG,Name VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table FOO_SendDb";

	public static final String ORDER_BY_JPQL = " ORDER BY sendDb.sendId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY FOO_SendDb.sendId ASC";

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
	public static final long SENDID_COLUMN_BITMASK = 4L;

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

	public SendDbModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _sendId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSendId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sendId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SendDb.class;
	}

	@Override
	public String getModelClassName() {
		return SendDb.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SendDb, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SendDb, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SendDb, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((SendDb)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SendDb, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SendDb, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SendDb)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SendDb, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SendDb, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<SendDb, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SendDb, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SendDb, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SendDb, Object>>();
		Map<String, BiConsumer<SendDb, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SendDb, ?>>();

		attributeGetterFunctions.put("uuid", SendDb::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<SendDb, String>)SendDb::setUuid);
		attributeGetterFunctions.put("sendId", SendDb::getSendId);
		attributeSetterBiConsumers.put(
			"sendId", (BiConsumer<SendDb, Long>)SendDb::setSendId);
		attributeGetterFunctions.put("companyId", SendDb::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<SendDb, Long>)SendDb::setCompanyId);
		attributeGetterFunctions.put("userId", SendDb::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<SendDb, Long>)SendDb::setUserId);
		attributeGetterFunctions.put("userName", SendDb::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<SendDb, String>)SendDb::setUserName);
		attributeGetterFunctions.put("mobileNumber", SendDb::getMobileNumber);
		attributeSetterBiConsumers.put(
			"mobileNumber", (BiConsumer<SendDb, Long>)SendDb::setMobileNumber);
		attributeGetterFunctions.put("Name", SendDb::getName);
		attributeSetterBiConsumers.put(
			"Name", (BiConsumer<SendDb, String>)SendDb::setName);

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
	public long getSendId() {
		return _sendId;
	}

	@Override
	public void setSendId(long sendId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sendId = sendId;
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
	public long getMobileNumber() {
		return _mobileNumber;
	}

	@Override
	public void setMobileNumber(long mobileNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mobileNumber = mobileNumber;
	}

	@JSON
	@Override
	public String getName() {
		if (_Name == null) {
			return "";
		}
		else {
			return _Name;
		}
	}

	@Override
	public void setName(String Name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_Name = Name;
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
			getCompanyId(), SendDb.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SendDb toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SendDb>
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
		SendDbImpl sendDbImpl = new SendDbImpl();

		sendDbImpl.setUuid(getUuid());
		sendDbImpl.setSendId(getSendId());
		sendDbImpl.setCompanyId(getCompanyId());
		sendDbImpl.setUserId(getUserId());
		sendDbImpl.setUserName(getUserName());
		sendDbImpl.setMobileNumber(getMobileNumber());
		sendDbImpl.setName(getName());

		sendDbImpl.resetOriginalValues();

		return sendDbImpl;
	}

	@Override
	public SendDb cloneWithOriginalValues() {
		SendDbImpl sendDbImpl = new SendDbImpl();

		sendDbImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		sendDbImpl.setSendId(this.<Long>getColumnOriginalValue("sendId"));
		sendDbImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		sendDbImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		sendDbImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		sendDbImpl.setMobileNumber(
			this.<Long>getColumnOriginalValue("mobileNumber"));
		sendDbImpl.setName(this.<String>getColumnOriginalValue("Name"));

		return sendDbImpl;
	}

	@Override
	public int compareTo(SendDb sendDb) {
		long primaryKey = sendDb.getPrimaryKey();

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

		if (!(object instanceof SendDb)) {
			return false;
		}

		SendDb sendDb = (SendDb)object;

		long primaryKey = sendDb.getPrimaryKey();

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
	public CacheModel<SendDb> toCacheModel() {
		SendDbCacheModel sendDbCacheModel = new SendDbCacheModel();

		sendDbCacheModel.uuid = getUuid();

		String uuid = sendDbCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			sendDbCacheModel.uuid = null;
		}

		sendDbCacheModel.sendId = getSendId();

		sendDbCacheModel.companyId = getCompanyId();

		sendDbCacheModel.userId = getUserId();

		sendDbCacheModel.userName = getUserName();

		String userName = sendDbCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			sendDbCacheModel.userName = null;
		}

		sendDbCacheModel.mobileNumber = getMobileNumber();

		sendDbCacheModel.Name = getName();

		String Name = sendDbCacheModel.Name;

		if ((Name != null) && (Name.length() == 0)) {
			sendDbCacheModel.Name = null;
		}

		return sendDbCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SendDb, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SendDb, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SendDb, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((SendDb)this);

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
		Map<String, Function<SendDb, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SendDb, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SendDb, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SendDb)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SendDb>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					SendDb.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _sendId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private long _mobileNumber;
	private String _Name;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<SendDb, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((SendDb)this);
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
		_columnOriginalValues.put("sendId", _sendId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("mobileNumber", _mobileNumber);
		_columnOriginalValues.put("Name", _Name);
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

		columnBitmasks.put("sendId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("mobileNumber", 32L);

		columnBitmasks.put("Name", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private SendDb _escapedModel;

}