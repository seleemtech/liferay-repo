/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.impl;

import api.master.slayer.model.ApiMapKey;
import api.master.slayer.service.base.ApiMapKeyLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=api.master.slayer.model.ApiMapKey",
        service = AopService.class
)
public class ApiMapKeyLocalServiceImpl extends ApiMapKeyLocalServiceBaseImpl {

    public ApiMapKey getApiKeyData(String name) {
        return apiMapKeyPersistence.fetchByName(name);
    }


    public List<ApiMapKey> getApiMapKeysByUserId(long userId) {
        return apiMapKeyPersistence.findByUserId(userId);
    }
}