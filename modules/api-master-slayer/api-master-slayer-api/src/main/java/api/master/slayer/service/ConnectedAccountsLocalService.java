/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import api.master.slayer.model.ConnectedAccounts;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ConnectedAccounts. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectedAccountsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ConnectedAccountsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>api.master.slayer.service.impl.ConnectedAccountsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the connected accounts local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ConnectedAccountsLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the connected accounts to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectedAccountsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectedAccounts the connected accounts
	 * @return the connected accounts that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ConnectedAccounts addConnectedAccounts(
		ConnectedAccounts connectedAccounts);

	/**
	 * Creates a new connected accounts with the primary key. Does not add the connected accounts to the database.
	 *
	 * @param c_accountId the primary key for the new connected accounts
	 * @return the new connected accounts
	 */
	@Transactional(enabled = false)
	public ConnectedAccounts createConnectedAccounts(long c_accountId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the connected accounts from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectedAccountsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectedAccounts the connected accounts
	 * @return the connected accounts that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ConnectedAccounts deleteConnectedAccounts(
		ConnectedAccounts connectedAccounts);

	/**
	 * Deletes the connected accounts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectedAccountsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts that was removed
	 * @throws PortalException if a connected accounts with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ConnectedAccounts deleteConnectedAccounts(long c_accountId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ConnectedAccounts fetchConnectedAccounts(long c_accountId);

	/**
	 * Returns the connected accounts matching the UUID and group.
	 *
	 * @param uuid the connected accounts's UUID
	 * @param groupId the primary key of the group
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ConnectedAccounts fetchConnectedAccountsByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ConnectedAccounts getAccountByEmailAndAppName(
		String appName, String emailAddress);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConnectedAccounts> getAccountsByUserId(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the connected accounts with the primary key.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts
	 * @throws PortalException if a connected accounts with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ConnectedAccounts getConnectedAccounts(long c_accountId)
		throws PortalException;

	/**
	 * Returns the connected accounts matching the UUID and group.
	 *
	 * @param uuid the connected accounts's UUID
	 * @param groupId the primary key of the group
	 * @return the matching connected accounts
	 * @throws PortalException if a matching connected accounts could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ConnectedAccounts getConnectedAccountsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the connected accountses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of connected accountses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConnectedAccounts> getConnectedAccountses(int start, int end);

	/**
	 * Returns all the connected accountses matching the UUID and company.
	 *
	 * @param uuid the UUID of the connected accountses
	 * @param companyId the primary key of the company
	 * @return the matching connected accountses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConnectedAccounts> getConnectedAccountsesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of connected accountses matching the UUID and company.
	 *
	 * @param uuid the UUID of the connected accountses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching connected accountses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConnectedAccounts> getConnectedAccountsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator);

	/**
	 * Returns the number of connected accountses.
	 *
	 * @return the number of connected accountses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getConnectedAccountsesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the connected accounts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectedAccountsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectedAccounts the connected accounts
	 * @return the connected accounts that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ConnectedAccounts updateConnectedAccounts(
		ConnectedAccounts connectedAccounts);

}