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

package com.candidate.service.model.impl;

import com.candidate.service.model.ProfessionalDetails;
import com.candidate.service.service.ProfessionalDetailsLocalServiceUtil;

/**
 * The extended model base implementation for the ProfessionalDetails service. Represents a row in the &quot;RMS_ProfessionalDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProfessionalDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalDetailsImpl
 * @see ProfessionalDetails
 * @generated
 */
public abstract class ProfessionalDetailsBaseImpl
	extends ProfessionalDetailsModelImpl implements ProfessionalDetails {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a professional details model instance should use the <code>ProfessionalDetails</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ProfessionalDetailsLocalServiceUtil.addProfessionalDetails(this);
		}
		else {
			ProfessionalDetailsLocalServiceUtil.updateProfessionalDetails(this);
		}
	}

}