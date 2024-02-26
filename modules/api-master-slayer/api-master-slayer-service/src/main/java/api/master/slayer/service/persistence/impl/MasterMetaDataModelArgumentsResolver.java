/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence.impl;

import api.master.slayer.model.MasterMetaDataTable;
import api.master.slayer.model.impl.MasterMetaDataImpl;
import api.master.slayer.model.impl.MasterMetaDataModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from MasterMetaData.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=api.master.slayer.model.impl.MasterMetaDataImpl",
		"table.name=API_MasterMetaData"
	},
	service = ArgumentsResolver.class
)
public class MasterMetaDataModelArgumentsResolver implements ArgumentsResolver {

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

		MasterMetaDataModelImpl masterMetaDataModelImpl =
			(MasterMetaDataModelImpl)baseModel;

		long columnBitmask = masterMetaDataModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(masterMetaDataModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					masterMetaDataModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(masterMetaDataModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return MasterMetaDataImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return MasterMetaDataTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		MasterMetaDataModelImpl masterMetaDataModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = masterMetaDataModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = masterMetaDataModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}