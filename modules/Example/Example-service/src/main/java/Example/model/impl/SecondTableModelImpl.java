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

package Example.model.impl;

import Example.model.SecondTable;
import Example.model.SecondTableModel;

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
 * The base model implementation for the SecondTable service. Represents a row in the &quot;FOO_SecondTable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SecondTableModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SecondTableImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecondTableImpl
 * @generated
 */
@JSON(strict = true)
public class SecondTableModelImpl
	extends BaseModelImpl<SecondTable> implements SecondTableModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a second table model instance should use the <code>SecondTable</code> interface instead.
	 */
	public static final String TABLE_NAME = "FOO_SecondTable";

	public static final Object[][] TABLE_COLUMNS = {
		{"coId", Types.BIGINT}, {"coName", Types.VARCHAR},
		{"companyId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("coId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("coName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table FOO_SecondTable (coId LONG not null primary key,coName VARCHAR(75) null,companyId LONG)";

	public static final String TABLE_SQL_DROP = "drop table FOO_SecondTable";

	public static final String ORDER_BY_JPQL = " ORDER BY secondTable.coId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY FOO_SecondTable.coId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COID_COLUMN_BITMASK = 1L;

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

	public static final String MAPPING_TABLE_FOO_FIRSTTABLES_SECONDTABLES_NAME =
		"FOO_FirstTables_SecondTables";

	public static final Object[][]
		MAPPING_TABLE_FOO_FIRSTTABLES_SECONDTABLES_COLUMNS = {
			{"companyId", Types.BIGINT}, {"soId", Types.BIGINT},
			{"coId", Types.BIGINT}
		};

	public static final String
		MAPPING_TABLE_FOO_FIRSTTABLES_SECONDTABLES_SQL_CREATE =
			"create table FOO_FirstTables_SecondTables (companyId LONG not null,soId LONG not null,coId LONG not null,primary key (soId, coId))";

	public SecondTableModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _coId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _coId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SecondTable.class;
	}

	@Override
	public String getModelClassName() {
		return SecondTable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SecondTable, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SecondTable, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SecondTable, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SecondTable)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SecondTable, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SecondTable, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SecondTable)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SecondTable, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SecondTable, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<SecondTable, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SecondTable, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SecondTable, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SecondTable, Object>>();
		Map<String, BiConsumer<SecondTable, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SecondTable, ?>>();

		attributeGetterFunctions.put("coId", SecondTable::getCoId);
		attributeSetterBiConsumers.put(
			"coId", (BiConsumer<SecondTable, Long>)SecondTable::setCoId);
		attributeGetterFunctions.put("coName", SecondTable::getCoName);
		attributeSetterBiConsumers.put(
			"coName", (BiConsumer<SecondTable, String>)SecondTable::setCoName);
		attributeGetterFunctions.put("companyId", SecondTable::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SecondTable, Long>)SecondTable::setCompanyId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCoId() {
		return _coId;
	}

	@Override
	public void setCoId(long coId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_coId = coId;
	}

	@JSON
	@Override
	public String getCoName() {
		if (_coName == null) {
			return "";
		}
		else {
			return _coName;
		}
	}

	@Override
	public void setCoName(String coName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_coName = coName;
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
			getCompanyId(), SecondTable.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SecondTable toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SecondTable>
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
		SecondTableImpl secondTableImpl = new SecondTableImpl();

		secondTableImpl.setCoId(getCoId());
		secondTableImpl.setCoName(getCoName());
		secondTableImpl.setCompanyId(getCompanyId());

		secondTableImpl.resetOriginalValues();

		return secondTableImpl;
	}

	@Override
	public SecondTable cloneWithOriginalValues() {
		SecondTableImpl secondTableImpl = new SecondTableImpl();

		secondTableImpl.setCoId(this.<Long>getColumnOriginalValue("coId"));
		secondTableImpl.setCoName(
			this.<String>getColumnOriginalValue("coName"));
		secondTableImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));

		return secondTableImpl;
	}

	@Override
	public int compareTo(SecondTable secondTable) {
		long primaryKey = secondTable.getPrimaryKey();

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

		if (!(object instanceof SecondTable)) {
			return false;
		}

		SecondTable secondTable = (SecondTable)object;

		long primaryKey = secondTable.getPrimaryKey();

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
	public CacheModel<SecondTable> toCacheModel() {
		SecondTableCacheModel secondTableCacheModel =
			new SecondTableCacheModel();

		secondTableCacheModel.coId = getCoId();

		secondTableCacheModel.coName = getCoName();

		String coName = secondTableCacheModel.coName;

		if ((coName != null) && (coName.length() == 0)) {
			secondTableCacheModel.coName = null;
		}

		secondTableCacheModel.companyId = getCompanyId();

		return secondTableCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SecondTable, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SecondTable, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SecondTable, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((SecondTable)this);

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

		private static final Function<InvocationHandler, SecondTable>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					SecondTable.class, ModelWrapper.class);

	}

	private long _coId;
	private String _coName;
	private long _companyId;

	public <T> T getColumnValue(String columnName) {
		Function<SecondTable, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((SecondTable)this);
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

		_columnOriginalValues.put("coId", _coId);
		_columnOriginalValues.put("coName", _coName);
		_columnOriginalValues.put("companyId", _companyId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("coId", 1L);

		columnBitmasks.put("coName", 2L);

		columnBitmasks.put("companyId", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private SecondTable _escapedModel;

}