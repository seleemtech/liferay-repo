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

package com.prime.data.service.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.prime.data.service.model.NamePrefix;
import com.prime.data.service.model.NamePrefixModel;
import com.prime.data.service.model.NamePrefixSoap;

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
 * The base model implementation for the NamePrefix service. Represents a row in the &quot;PRIME_NamePrefix&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>NamePrefixModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NamePrefixImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NamePrefixImpl
 * @generated
 */
@JSON(strict = true)
public class NamePrefixModelImpl
	extends BaseModelImpl<NamePrefix> implements NamePrefixModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a name prefix model instance should use the <code>NamePrefix</code> interface instead.
	 */
	public static final String TABLE_NAME = "PRIME_NamePrefix";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"namePrefixId", Types.BIGINT},
		{"namePrefix", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("namePrefixId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("namePrefix", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PRIME_NamePrefix (uuid_ VARCHAR(75) null,namePrefixId LONG not null primary key,namePrefix VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table PRIME_NamePrefix";

	public static final String ORDER_BY_JPQL =
		" ORDER BY namePrefix.namePrefixId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PRIME_NamePrefix.namePrefixId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAMEPREFIXID_COLUMN_BITMASK = 2L;

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
	public static NamePrefix toModel(NamePrefixSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		NamePrefix model = new NamePrefixImpl();

		model.setUuid(soapModel.getUuid());
		model.setNamePrefixId(soapModel.getNamePrefixId());
		model.setNamePrefix(soapModel.getNamePrefix());

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
	public static List<NamePrefix> toModels(NamePrefixSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<NamePrefix> models = new ArrayList<NamePrefix>(soapModels.length);

		for (NamePrefixSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public NamePrefixModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _namePrefixId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNamePrefixId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _namePrefixId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NamePrefix.class;
	}

	@Override
	public String getModelClassName() {
		return NamePrefix.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<NamePrefix, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<NamePrefix, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NamePrefix, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((NamePrefix)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<NamePrefix, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<NamePrefix, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(NamePrefix)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<NamePrefix, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<NamePrefix, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, NamePrefix>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			NamePrefix.class.getClassLoader(), NamePrefix.class,
			ModelWrapper.class);

		try {
			Constructor<NamePrefix> constructor =
				(Constructor<NamePrefix>)proxyClass.getConstructor(
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

	private static final Map<String, Function<NamePrefix, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<NamePrefix, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<NamePrefix, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<NamePrefix, Object>>();
		Map<String, BiConsumer<NamePrefix, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<NamePrefix, ?>>();

		attributeGetterFunctions.put("uuid", NamePrefix::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<NamePrefix, String>)NamePrefix::setUuid);
		attributeGetterFunctions.put(
			"namePrefixId", NamePrefix::getNamePrefixId);
		attributeSetterBiConsumers.put(
			"namePrefixId",
			(BiConsumer<NamePrefix, Long>)NamePrefix::setNamePrefixId);
		attributeGetterFunctions.put("namePrefix", NamePrefix::getNamePrefix);
		attributeSetterBiConsumers.put(
			"namePrefix",
			(BiConsumer<NamePrefix, String>)NamePrefix::setNamePrefix);

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
	public long getNamePrefixId() {
		return _namePrefixId;
	}

	@Override
	public void setNamePrefixId(long namePrefixId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_namePrefixId = namePrefixId;
	}

	@JSON
	@Override
	public String getNamePrefix() {
		if (_namePrefix == null) {
			return "";
		}
		else {
			return _namePrefix;
		}
	}

	@Override
	public void setNamePrefix(String namePrefix) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_namePrefix = namePrefix;
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
			0, NamePrefix.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NamePrefix toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, NamePrefix>
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
		NamePrefixImpl namePrefixImpl = new NamePrefixImpl();

		namePrefixImpl.setUuid(getUuid());
		namePrefixImpl.setNamePrefixId(getNamePrefixId());
		namePrefixImpl.setNamePrefix(getNamePrefix());

		namePrefixImpl.resetOriginalValues();

		return namePrefixImpl;
	}

	@Override
	public NamePrefix cloneWithOriginalValues() {
		NamePrefixImpl namePrefixImpl = new NamePrefixImpl();

		namePrefixImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		namePrefixImpl.setNamePrefixId(
			this.<Long>getColumnOriginalValue("namePrefixId"));
		namePrefixImpl.setNamePrefix(
			this.<String>getColumnOriginalValue("namePrefix"));

		return namePrefixImpl;
	}

	@Override
	public int compareTo(NamePrefix namePrefix) {
		long primaryKey = namePrefix.getPrimaryKey();

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

		if (!(object instanceof NamePrefix)) {
			return false;
		}

		NamePrefix namePrefix = (NamePrefix)object;

		long primaryKey = namePrefix.getPrimaryKey();

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
	public CacheModel<NamePrefix> toCacheModel() {
		NamePrefixCacheModel namePrefixCacheModel = new NamePrefixCacheModel();

		namePrefixCacheModel.uuid = getUuid();

		String uuid = namePrefixCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			namePrefixCacheModel.uuid = null;
		}

		namePrefixCacheModel.namePrefixId = getNamePrefixId();

		namePrefixCacheModel.namePrefix = getNamePrefix();

		String namePrefix = namePrefixCacheModel.namePrefix;

		if ((namePrefix != null) && (namePrefix.length() == 0)) {
			namePrefixCacheModel.namePrefix = null;
		}

		return namePrefixCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<NamePrefix, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<NamePrefix, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NamePrefix, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((NamePrefix)this);

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
		Map<String, Function<NamePrefix, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<NamePrefix, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NamePrefix, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((NamePrefix)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, NamePrefix>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _namePrefixId;
	private String _namePrefix;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<NamePrefix, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((NamePrefix)this);
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
		_columnOriginalValues.put("namePrefixId", _namePrefixId);
		_columnOriginalValues.put("namePrefix", _namePrefix);
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

		columnBitmasks.put("namePrefixId", 2L);

		columnBitmasks.put("namePrefix", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private NamePrefix _escapedModel;

}