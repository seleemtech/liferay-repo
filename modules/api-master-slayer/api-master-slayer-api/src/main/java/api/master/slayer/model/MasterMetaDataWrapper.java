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
 * This class is a wrapper for {@link MasterMetaData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterMetaData
 * @generated
 */
public class MasterMetaDataWrapper
	extends BaseModelWrapper<MasterMetaData>
	implements MasterMetaData, ModelWrapper<MasterMetaData> {

	public MasterMetaDataWrapper(MasterMetaData masterMetaData) {
		super(masterMetaData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("mmdId", getMmdId());
		attributes.put("masterUrlId", getMasterUrlId());
		attributes.put("appSubUrl", getAppSubUrl());
		attributes.put("httpMethod", getHttpMethod());
		attributes.put("httpMethodName", getHttpMethodName());
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

		Long mmdId = (Long)attributes.get("mmdId");

		if (mmdId != null) {
			setMmdId(mmdId);
		}

		Long masterUrlId = (Long)attributes.get("masterUrlId");

		if (masterUrlId != null) {
			setMasterUrlId(masterUrlId);
		}

		String appSubUrl = (String)attributes.get("appSubUrl");

		if (appSubUrl != null) {
			setAppSubUrl(appSubUrl);
		}

		String httpMethod = (String)attributes.get("httpMethod");

		if (httpMethod != null) {
			setHttpMethod(httpMethod);
		}

		String httpMethodName = (String)attributes.get("httpMethodName");

		if (httpMethodName != null) {
			setHttpMethodName(httpMethodName);
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
	public MasterMetaData cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the app sub url of this master meta data.
	 *
	 * @return the app sub url of this master meta data
	 */
	@Override
	public String getAppSubUrl() {
		return model.getAppSubUrl();
	}

	/**
	 * Returns the company ID of this master meta data.
	 *
	 * @return the company ID of this master meta data
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this master meta data.
	 *
	 * @return the create date of this master meta data
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this master meta data.
	 *
	 * @return the group ID of this master meta data
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the http method of this master meta data.
	 *
	 * @return the http method of this master meta data
	 */
	@Override
	public String getHttpMethod() {
		return model.getHttpMethod();
	}

	/**
	 * Returns the http method name of this master meta data.
	 *
	 * @return the http method name of this master meta data
	 */
	@Override
	public String getHttpMethodName() {
		return model.getHttpMethodName();
	}

	/**
	 * Returns the master url ID of this master meta data.
	 *
	 * @return the master url ID of this master meta data
	 */
	@Override
	public long getMasterUrlId() {
		return model.getMasterUrlId();
	}

	/**
	 * Returns the mmd ID of this master meta data.
	 *
	 * @return the mmd ID of this master meta data
	 */
	@Override
	public long getMmdId() {
		return model.getMmdId();
	}

	/**
	 * Returns the modified date of this master meta data.
	 *
	 * @return the modified date of this master meta data
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this master meta data.
	 *
	 * @return the primary key of this master meta data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this master meta data.
	 *
	 * @return the user ID of this master meta data
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this master meta data.
	 *
	 * @return the user uuid of this master meta data
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this master meta data.
	 *
	 * @return the uuid of this master meta data
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
	 * Sets the app sub url of this master meta data.
	 *
	 * @param appSubUrl the app sub url of this master meta data
	 */
	@Override
	public void setAppSubUrl(String appSubUrl) {
		model.setAppSubUrl(appSubUrl);
	}

	/**
	 * Sets the company ID of this master meta data.
	 *
	 * @param companyId the company ID of this master meta data
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this master meta data.
	 *
	 * @param createDate the create date of this master meta data
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this master meta data.
	 *
	 * @param groupId the group ID of this master meta data
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the http method of this master meta data.
	 *
	 * @param httpMethod the http method of this master meta data
	 */
	@Override
	public void setHttpMethod(String httpMethod) {
		model.setHttpMethod(httpMethod);
	}

	/**
	 * Sets the http method name of this master meta data.
	 *
	 * @param httpMethodName the http method name of this master meta data
	 */
	@Override
	public void setHttpMethodName(String httpMethodName) {
		model.setHttpMethodName(httpMethodName);
	}

	/**
	 * Sets the master url ID of this master meta data.
	 *
	 * @param masterUrlId the master url ID of this master meta data
	 */
	@Override
	public void setMasterUrlId(long masterUrlId) {
		model.setMasterUrlId(masterUrlId);
	}

	/**
	 * Sets the mmd ID of this master meta data.
	 *
	 * @param mmdId the mmd ID of this master meta data
	 */
	@Override
	public void setMmdId(long mmdId) {
		model.setMmdId(mmdId);
	}

	/**
	 * Sets the modified date of this master meta data.
	 *
	 * @param modifiedDate the modified date of this master meta data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this master meta data.
	 *
	 * @param primaryKey the primary key of this master meta data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this master meta data.
	 *
	 * @param userId the user ID of this master meta data
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this master meta data.
	 *
	 * @param userUuid the user uuid of this master meta data
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this master meta data.
	 *
	 * @param uuid the uuid of this master meta data
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
	protected MasterMetaDataWrapper wrap(MasterMetaData masterMetaData) {
		return new MasterMetaDataWrapper(masterMetaData);
	}

}