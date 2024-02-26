/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ApiMapKey service. Represents a row in the &quot;API_ApiMapKey&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ApiMapKeyModel
 * @generated
 */
@ImplementationClassName("api.master.slayer.model.impl.ApiMapKeyImpl")
@ProviderType
public interface ApiMapKey extends ApiMapKeyModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>api.master.slayer.model.impl.ApiMapKeyImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ApiMapKey, Long> API_MAP_KEY_ID_ACCESSOR =
		new Accessor<ApiMapKey, Long>() {

			@Override
			public Long get(ApiMapKey apiMapKey) {
				return apiMapKey.getApiMapKeyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ApiMapKey> getTypeClass() {
				return ApiMapKey.class;
			}

		};

}