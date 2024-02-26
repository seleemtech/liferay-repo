/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the MasterMetaData service. Represents a row in the &quot;API_MasterMetaData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>api.master.slayer.model.impl.MasterMetaDataModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>api.master.slayer.model.impl.MasterMetaDataImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterMetaData
 * @generated
 */
@ProviderType
public interface MasterMetaDataModel
	extends BaseModel<MasterMetaData>, ShardedModel, StagedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a master meta data model instance should use the {@link MasterMetaData} interface instead.
	 */

	/**
	 * Returns the primary key of this master meta data.
	 *
	 * @return the primary key of this master meta data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this master meta data.
	 *
	 * @param primaryKey the primary key of this master meta data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this master meta data.
	 *
	 * @return the uuid of this master meta data
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this master meta data.
	 *
	 * @param uuid the uuid of this master meta data
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the mmd ID of this master meta data.
	 *
	 * @return the mmd ID of this master meta data
	 */
	public long getMmdId();

	/**
	 * Sets the mmd ID of this master meta data.
	 *
	 * @param mmdId the mmd ID of this master meta data
	 */
	public void setMmdId(long mmdId);

	/**
	 * Returns the master url ID of this master meta data.
	 *
	 * @return the master url ID of this master meta data
	 */
	public long getMasterUrlId();

	/**
	 * Sets the master url ID of this master meta data.
	 *
	 * @param masterUrlId the master url ID of this master meta data
	 */
	public void setMasterUrlId(long masterUrlId);

	/**
	 * Returns the app sub url of this master meta data.
	 *
	 * @return the app sub url of this master meta data
	 */
	@AutoEscape
	public String getAppSubUrl();

	/**
	 * Sets the app sub url of this master meta data.
	 *
	 * @param appSubUrl the app sub url of this master meta data
	 */
	public void setAppSubUrl(String appSubUrl);

	/**
	 * Returns the http method of this master meta data.
	 *
	 * @return the http method of this master meta data
	 */
	@AutoEscape
	public String getHttpMethod();

	/**
	 * Sets the http method of this master meta data.
	 *
	 * @param httpMethod the http method of this master meta data
	 */
	public void setHttpMethod(String httpMethod);

	/**
	 * Returns the http method name of this master meta data.
	 *
	 * @return the http method name of this master meta data
	 */
	@AutoEscape
	public String getHttpMethodName();

	/**
	 * Sets the http method name of this master meta data.
	 *
	 * @param httpMethodName the http method name of this master meta data
	 */
	public void setHttpMethodName(String httpMethodName);

	/**
	 * Returns the user ID of this master meta data.
	 *
	 * @return the user ID of this master meta data
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this master meta data.
	 *
	 * @param userId the user ID of this master meta data
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this master meta data.
	 *
	 * @return the user uuid of this master meta data
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this master meta data.
	 *
	 * @param userUuid the user uuid of this master meta data
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this master meta data.
	 *
	 * @return the group ID of this master meta data
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this master meta data.
	 *
	 * @param groupId the group ID of this master meta data
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this master meta data.
	 *
	 * @return the company ID of this master meta data
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this master meta data.
	 *
	 * @param companyId the company ID of this master meta data
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this master meta data.
	 *
	 * @return the create date of this master meta data
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this master meta data.
	 *
	 * @param createDate the create date of this master meta data
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this master meta data.
	 *
	 * @return the modified date of this master meta data
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this master meta data.
	 *
	 * @param modifiedDate the modified date of this master meta data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public MasterMetaData cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}