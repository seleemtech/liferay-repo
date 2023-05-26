package com.rms.dynamic.data.mapping.form.web.internal.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.PortletRequest;
/**
 * @author Mahammed Seleem
 */
public class DDMFormInstaceSearchTerms extends DDMFormInstanceDisplayTerms {

	public DDMFormInstaceSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		description = DAOParamUtil.getString(portletRequest, DESCRIPTION);
		name = DAOParamUtil.getString(portletRequest, NAME);
	}


}
