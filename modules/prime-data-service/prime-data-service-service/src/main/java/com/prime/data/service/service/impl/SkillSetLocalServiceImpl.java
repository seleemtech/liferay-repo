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

package com.prime.data.service.service.impl;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.prime.data.service.model.SkillSet;
import com.prime.data.service.service.SkillSetLocalServiceUtil;
import com.prime.data.service.service.base.SkillSetLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.prime.data.service.model.SkillSet",
	service = AopService.class
)
public class SkillSetLocalServiceImpl extends SkillSetLocalServiceBaseImpl {
	public void addSkillSet(ActionRequest actionRequest) {
		String skillCategory = ParamUtil.getString(actionRequest, "skillCategory");
		String skillTools = actionRequest.getParameter("rowIndexesSkillTools");
		String[] indexOfRows = skillTools.split(",");
		for (int i = 0; i < indexOfRows.length; i++) {
		String tools = ParamUtil.getString(actionRequest, "skillCategoryTools" + indexOfRows[i]);
		SkillSet skillSet = SkillSetLocalServiceUtil.createSkillSet(0);
		skillSet.setSkillCategory(skillCategory);
		skillSet.setSkillCategoryTools(tools);
		SkillSetLocalServiceUtil.addSkillSet(skillSet);
		}
	}
}