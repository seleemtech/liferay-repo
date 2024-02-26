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
 * The extended model interface for the MasterMetaData service. Represents a row in the &quot;API_MasterMetaData&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MasterMetaDataModel
 * @generated
 */
@ImplementationClassName("api.master.slayer.model.impl.MasterMetaDataImpl")
@ProviderType
public interface MasterMetaData extends MasterMetaDataModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>api.master.slayer.model.impl.MasterMetaDataImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MasterMetaData, Long> MMD_ID_ACCESSOR =
		new Accessor<MasterMetaData, Long>() {

			@Override
			public Long get(MasterMetaData masterMetaData) {
				return masterMetaData.getMmdId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MasterMetaData> getTypeClass() {
				return MasterMetaData.class;
			}

		};

}