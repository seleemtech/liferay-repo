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

package com.prime.data.service.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the HighQualHeld service. Represents a row in the &quot;PRIME_HighQualHeld&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see HighQualHeldModel
 * @generated
 */
@ImplementationClassName("com.prime.data.service.model.impl.HighQualHeldImpl")
@ProviderType
public interface HighQualHeld extends HighQualHeldModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.prime.data.service.model.impl.HighQualHeldImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<HighQualHeld, Long>
		HIGH_QUAL_HELD_ID_ACCESSOR = new Accessor<HighQualHeld, Long>() {

			@Override
			public Long get(HighQualHeld highQualHeld) {
				return highQualHeld.getHighQualHeldId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<HighQualHeld> getTypeClass() {
				return HighQualHeld.class;
			}

		};

}