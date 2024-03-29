/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model.impl;

import api.master.slayer.model.ApiMapKey;
import api.master.slayer.service.ApiMapKeyLocalServiceUtil;

/**
 * The extended model base implementation for the ApiMapKey service. Represents a row in the &quot;API_ApiMapKey&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ApiMapKeyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApiMapKeyImpl
 * @see ApiMapKey
 * @generated
 */
public abstract class ApiMapKeyBaseImpl
	extends ApiMapKeyModelImpl implements ApiMapKey {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a api map key model instance should use the <code>ApiMapKey</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ApiMapKeyLocalServiceUtil.addApiMapKey(this);
		}
		else {
			ApiMapKeyLocalServiceUtil.updateApiMapKey(this);
		}
	}

}