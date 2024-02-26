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
 * This class is a wrapper for {@link ConnectedAccounts}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectedAccounts
 * @generated
 */
public class ConnectedAccountsWrapper
	extends BaseModelWrapper<ConnectedAccounts>
	implements ConnectedAccounts, ModelWrapper<ConnectedAccounts> {

	public ConnectedAccountsWrapper(ConnectedAccounts connectedAccounts) {
		super(connectedAccounts);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("c_accountId", getC_accountId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("appName", getAppName());
		attributes.put("refreshToken", getRefreshToken());
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

		Long c_accountId = (Long)attributes.get("c_accountId");

		if (c_accountId != null) {
			setC_accountId(c_accountId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String appName = (String)attributes.get("appName");

		if (appName != null) {
			setAppName(appName);
		}

		String refreshToken = (String)attributes.get("refreshToken");

		if (refreshToken != null) {
			setRefreshToken(refreshToken);
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
	public ConnectedAccounts cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the app name of this connected accounts.
	 *
	 * @return the app name of this connected accounts
	 */
	@Override
	public String getAppName() {
		return model.getAppName();
	}

	/**
	 * Returns the c_account ID of this connected accounts.
	 *
	 * @return the c_account ID of this connected accounts
	 */
	@Override
	public long getC_accountId() {
		return model.getC_accountId();
	}

	/**
	 * Returns the company ID of this connected accounts.
	 *
	 * @return the company ID of this connected accounts
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this connected accounts.
	 *
	 * @return the create date of this connected accounts
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email address of this connected accounts.
	 *
	 * @return the email address of this connected accounts
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the group ID of this connected accounts.
	 *
	 * @return the group ID of this connected accounts
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this connected accounts.
	 *
	 * @return the modified date of this connected accounts
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this connected accounts.
	 *
	 * @return the primary key of this connected accounts
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the refresh token of this connected accounts.
	 *
	 * @return the refresh token of this connected accounts
	 */
	@Override
	public String getRefreshToken() {
		return model.getRefreshToken();
	}

	/**
	 * Returns the user ID of this connected accounts.
	 *
	 * @return the user ID of this connected accounts
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this connected accounts.
	 *
	 * @return the user uuid of this connected accounts
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this connected accounts.
	 *
	 * @return the uuid of this connected accounts
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
	 * Sets the app name of this connected accounts.
	 *
	 * @param appName the app name of this connected accounts
	 */
	@Override
	public void setAppName(String appName) {
		model.setAppName(appName);
	}

	/**
	 * Sets the c_account ID of this connected accounts.
	 *
	 * @param c_accountId the c_account ID of this connected accounts
	 */
	@Override
	public void setC_accountId(long c_accountId) {
		model.setC_accountId(c_accountId);
	}

	/**
	 * Sets the company ID of this connected accounts.
	 *
	 * @param companyId the company ID of this connected accounts
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this connected accounts.
	 *
	 * @param createDate the create date of this connected accounts
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email address of this connected accounts.
	 *
	 * @param emailAddress the email address of this connected accounts
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the group ID of this connected accounts.
	 *
	 * @param groupId the group ID of this connected accounts
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this connected accounts.
	 *
	 * @param modifiedDate the modified date of this connected accounts
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this connected accounts.
	 *
	 * @param primaryKey the primary key of this connected accounts
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the refresh token of this connected accounts.
	 *
	 * @param refreshToken the refresh token of this connected accounts
	 */
	@Override
	public void setRefreshToken(String refreshToken) {
		model.setRefreshToken(refreshToken);
	}

	/**
	 * Sets the user ID of this connected accounts.
	 *
	 * @param userId the user ID of this connected accounts
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this connected accounts.
	 *
	 * @param userUuid the user uuid of this connected accounts
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this connected accounts.
	 *
	 * @param uuid the uuid of this connected accounts
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
	protected ConnectedAccountsWrapper wrap(
		ConnectedAccounts connectedAccounts) {

		return new ConnectedAccountsWrapper(connectedAccounts);
	}

}