/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ApiMapKey}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApiMapKey
 * @generated
 */
public class ApiMapKeyWrapper
	extends BaseModelWrapper<ApiMapKey>
	implements ApiMapKey, ModelWrapper<ApiMapKey> {

	public ApiMapKeyWrapper(ApiMapKey apiMapKey) {
		super(apiMapKey);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("apiMapKeyId", getApiMapKeyId());
		attributes.put("name", getName());
		attributes.put("key", getKey());
		attributes.put("typeSettings", getTypeSettings());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long apiMapKeyId = (Long)attributes.get("apiMapKeyId");

		if (apiMapKeyId != null) {
			setApiMapKeyId(apiMapKeyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public ApiMapKey cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the api map key ID of this api map key.
	 *
	 * @return the api map key ID of this api map key
	 */
	@Override
	public long getApiMapKeyId() {
		return model.getApiMapKeyId();
	}

	/**
	 * Returns the group ID of this api map key.
	 *
	 * @return the group ID of this api map key
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the key of this api map key.
	 *
	 * @return the key of this api map key
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the name of this api map key.
	 *
	 * @return the name of this api map key
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this api map key.
	 *
	 * @return the primary key of this api map key
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type settings of this api map key.
	 *
	 * @return the type settings of this api map key
	 */
	@Override
	public String getTypeSettings() {
		return model.getTypeSettings();
	}

	/**
	 * Returns the user ID of this api map key.
	 *
	 * @return the user ID of this api map key
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this api map key.
	 *
	 * @return the user uuid of this api map key
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this api map key.
	 *
	 * @return the uuid of this api map key
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the api map key ID of this api map key.
	 *
	 * @param apiMapKeyId the api map key ID of this api map key
	 */
	@Override
	public void setApiMapKeyId(long apiMapKeyId) {
		model.setApiMapKeyId(apiMapKeyId);
	}

	/**
	 * Sets the group ID of this api map key.
	 *
	 * @param groupId the group ID of this api map key
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the key of this api map key.
	 *
	 * @param key the key of this api map key
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the name of this api map key.
	 *
	 * @param name the name of this api map key
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this api map key.
	 *
	 * @param primaryKey the primary key of this api map key
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type settings of this api map key.
	 *
	 * @param typeSettings the type settings of this api map key
	 */
	@Override
	public void setTypeSettings(String typeSettings) {
		model.setTypeSettings(typeSettings);
	}

	/**
	 * Sets the user ID of this api map key.
	 *
	 * @param userId the user ID of this api map key
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this api map key.
	 *
	 * @param userUuid the user uuid of this api map key
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this api map key.
	 *
	 * @param uuid the uuid of this api map key
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ApiMapKeyWrapper wrap(ApiMapKey apiMapKey) {
		return new ApiMapKeyWrapper(apiMapKey);
	}

}