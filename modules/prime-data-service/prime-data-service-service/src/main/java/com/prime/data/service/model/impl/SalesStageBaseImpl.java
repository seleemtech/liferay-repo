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

import com.prime.data.service.model.SalesStage;
import com.prime.data.service.service.SalesStageLocalServiceUtil;

/**
 * The extended model base implementation for the SalesStage service. Represents a row in the &quot;PRIME_SalesStage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SalesStageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesStageImpl
 * @see SalesStage
 * @generated
 */
public abstract class SalesStageBaseImpl
	extends SalesStageModelImpl implements SalesStage {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sales stage model instance should use the <code>SalesStage</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			SalesStageLocalServiceUtil.addSalesStage(this);
		}
		else {
			SalesStageLocalServiceUtil.updateSalesStage(this);
		}
	}

}