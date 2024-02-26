/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.impl;

import api.master.slayer.model.ConnectedAccounts;import api.master.slayer.service.base.ConnectedAccountsLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=api.master.slayer.model.ConnectedAccounts",
	service = AopService.class
)
public class ConnectedAccountsLocalServiceImpl
	extends ConnectedAccountsLocalServiceBaseImpl {

	public List<ConnectedAccounts> getAccountsByUserId(long userId){
		return connectedAccountsPersistence.findByUserId(userId);
	}

	public ConnectedAccounts getAccountByEmailAndAppName(String appName,String emailAddress){
		return connectedAccountsPersistence.fetchByGetAccount(appName,emailAddress);
	}
}