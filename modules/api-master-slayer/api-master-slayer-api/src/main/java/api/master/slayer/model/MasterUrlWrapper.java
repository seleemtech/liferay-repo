/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MasterUrl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterUrl
 * @generated
 */
public class MasterUrlWrapper
	extends BaseModelWrapper<MasterUrl>
	implements MasterUrl, ModelWrapper<MasterUrl> {

	public MasterUrlWrapper(MasterUrl masterUrl) {
		super(masterUrl);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("masterUrlId", getMasterUrlId());
		attributes.put("appName", getAppName());
		attributes.put("baseUrl", getBaseUrl());
		attributes.put("svgIcon", getSvgIcon());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long masterUrlId = (Long)attributes.get("masterUrlId");

		if (masterUrlId != null) {
			setMasterUrlId(masterUrlId);
		}

		String appName = (String)attributes.get("appName");

		if (appName != null) {
			setAppName(appName);
		}

		String baseUrl = (String)attributes.get("baseUrl");

		if (baseUrl != null) {
			setBaseUrl(baseUrl);
		}

		String svgIcon = (String)attributes.get("svgIcon");

		if (svgIcon != null) {
			setSvgIcon(svgIcon);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public MasterUrl cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the app name of this master url.
	 *
	 * @return the app name of this master url
	 */
	@Override
	public String getAppName() {
		return model.getAppName();
	}

	/**
	 * Returns the base url of this master url.
	 *
	 * @return the base url of this master url
	 */
	@Override
	public String getBaseUrl() {
		return model.getBaseUrl();
	}

	/**
	 * Returns the company ID of this master url.
	 *
	 * @return the company ID of this master url
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master url.
	 *
	 * @return the create date of this master url
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this master url.
	 *
	 * @return the group ID of this master url
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the master url ID of this master url.
	 *
	 * @return the master url ID of this master url
	 */
	@Override
	public long getMasterUrlId() {
		return model.getMasterUrlId();
	}

	/**
	 * Returns the modified date of this master url.
	 *
	 * @return the modified date of this master url
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this master url.
	 *
	 * @return the primary key of this master url
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the svg icon of this master url.
	 *
	 * @return the svg icon of this master url
	 */
	@Override
	public String getSvgIcon() {
		return model.getSvgIcon();
	}

	/**
	 * Returns the user ID of this master url.
	 *
	 * @return the user ID of this master url
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this master url.
	 *
	 * @return the user uuid of this master url
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this master url.
	 *
	 * @return the uuid of this master url
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
	 * Sets the app name of this master url.
	 *
	 * @param appName the app name of this master url
	 */
	@Override
	public void setAppName(String appName) {
		model.setAppName(appName);
	}

	/**
	 * Sets the base url of this master url.
	 *
	 * @param baseUrl the base url of this master url
	 */
	@Override
	public void setBaseUrl(String baseUrl) {
		model.setBaseUrl(baseUrl);
	}

	/**
	 * Sets the company ID of this master url.
	 *
	 * @param companyId the company ID of this master url
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master url.
	 *
	 * @param createDate the create date of this master url
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this master url.
	 *
	 * @param groupId the group ID of this master url
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the master url ID of this master url.
	 *
	 * @param masterUrlId the master url ID of this master url
	 */
	@Override
	public void setMasterUrlId(long masterUrlId) {
		model.setMasterUrlId(masterUrlId);
	}

	/**
	 * Sets the modified date of this master url.
	 *
	 * @param modifiedDate the modified date of this master url
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this master url.
	 *
	 * @param primaryKey the primary key of this master url
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the svg icon of this master url.
	 *
	 * @param svgIcon the svg icon of this master url
	 */
	@Override
	public void setSvgIcon(String svgIcon) {
		model.setSvgIcon(svgIcon);
	}

	/**
	 * Sets the user ID of this master url.
	 *
	 * @param userId the user ID of this master url
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this master url.
	 *
	 * @param userUuid the user uuid of this master url
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this master url.
	 *
	 * @param uuid the uuid of this master url
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected MasterUrlWrapper wrap(MasterUrl masterUrl) {
		return new MasterUrlWrapper(masterUrl);
	}

}