/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence.impl;

import api.master.slayer.model.ApiMapKeyTable;
import api.master.slayer.model.impl.ApiMapKeyImpl;
import api.master.slayer.model.impl.ApiMapKeyModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from ApiMapKey.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=api.master.slayer.model.impl.ApiMapKeyImpl",
		"table.name=API_ApiMapKey"
	},
	service = ArgumentsResolver.class
)
public class ApiMapKeyModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		ApiMapKeyModelImpl apiMapKeyModelImpl = (ApiMapKeyModelImpl)baseModel;

		long columnBitmask = apiMapKeyModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(apiMapKeyModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= apiMapKeyModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(apiMapKeyModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ApiMapKeyImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ApiMapKeyTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ApiMapKeyModelImpl apiMapKeyModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = apiMapKeyModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = apiMapKeyModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}