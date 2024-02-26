/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ConnectedAccountsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectedAccountsLocalService
 * @generated
 */
public class ConnectedAccountsLocalServiceWrapper
	implements ConnectedAccountsLocalService,
			   ServiceWrapper<ConnectedAccountsLocalService> {

	public ConnectedAccountsLocalServiceWrapper() {
		this(null);
	}

	public ConnectedAccountsLocalServiceWrapper(
		ConnectedAccountsLocalService connectedAccountsLocalService) {

		_connectedAccountsLocalService = connectedAccountsLocalService;
	}

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
	@Override
	public api.master.slayer.model.ConnectedAccounts addConnectedAccounts(
		api.master.slayer.model.ConnectedAccounts connectedAccounts) {

		return _connectedAccountsLocalService.addConnectedAccounts(
			connectedAccounts);
	}

	/**
	 * Creates a new connected accounts with the primary key. Does not add the connected accounts to the database.
	 *
	 * @param c_accountId the primary key for the new connected accounts
	 * @return the new connected accounts
	 */
	@Override
	public api.master.slayer.model.ConnectedAccounts createConnectedAccounts(
		long c_accountId) {

		return _connectedAccountsLocalService.createConnectedAccounts(
			c_accountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectedAccountsLocalService.createPersistedModel(
			primaryKeyObj);
	}

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
	@Override
	public api.master.slayer.model.ConnectedAccounts deleteConnectedAccounts(
		api.master.slayer.model.ConnectedAccounts connectedAccounts) {

		return _connectedAccountsLocalService.deleteConnectedAccounts(
			connectedAccounts);
	}

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
	@Override
	public api.master.slayer.model.ConnectedAccounts deleteConnectedAccounts(
			long c_accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectedAccountsLocalService.deleteConnectedAccounts(
			c_accountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectedAccountsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _connectedAccountsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _connectedAccountsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _connectedAccountsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _connectedAccountsLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _connectedAccountsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _connectedAccountsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _connectedAccountsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _connectedAccountsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public api.master.slayer.model.ConnectedAccounts fetchConnectedAccounts(
		long c_accountId) {

		return _connectedAccountsLocalService.fetchConnectedAccounts(
			c_accountId);
	}

	/**
	 * Returns the connected accounts matching the UUID and group.
	 *
	 * @param uuid the connected accounts's UUID
	 * @param groupId the primary key of the group
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public api.master.slayer.model.ConnectedAccounts
		fetchConnectedAccountsByUuidAndGroupId(String uuid, long groupId) {

		return _connectedAccountsLocalService.
			fetchConnectedAccountsByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public api.master.slayer.model.ConnectedAccounts
		getAccountByEmailAndAppName(String appName, String emailAddress) {

		return _connectedAccountsLocalService.getAccountByEmailAndAppName(
			appName, emailAddress);
	}

	@Override
	public java.util.List<api.master.slayer.model.ConnectedAccounts>
		getAccountsByUserId(long userId) {

		return _connectedAccountsLocalService.getAccountsByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _connectedAccountsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the connected accounts with the primary key.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts
	 * @throws PortalException if a connected accounts with the primary key could not be found
	 */
	@Override
	public api.master.slayer.model.ConnectedAccounts getConnectedAccounts(
			long c_accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectedAccountsLocalService.getConnectedAccounts(c_accountId);
	}

	/**
	 * Returns the connected accounts matching the UUID and group.
	 *
	 * @param uuid the connected accounts's UUID
	 * @param groupId the primary key of the group
	 * @return the matching connected accounts
	 * @throws PortalException if a matching connected accounts could not be found
	 */
	@Override
	public api.master.slayer.model.ConnectedAccounts
			getConnectedAccountsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectedAccountsLocalService.
			getConnectedAccountsByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<api.master.slayer.model.ConnectedAccounts>
		getConnectedAccountses(int start, int end) {

		return _connectedAccountsLocalService.getConnectedAccountses(
			start, end);
	}

	/**
	 * Returns all the connected accountses matching the UUID and company.
	 *
	 * @param uuid the UUID of the connected accountses
	 * @param companyId the primary key of the company
	 * @return the matching connected accountses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<api.master.slayer.model.ConnectedAccounts>
		getConnectedAccountsesByUuidAndCompanyId(String uuid, long companyId) {

		return _connectedAccountsLocalService.
			getConnectedAccountsesByUuidAndCompanyId(uuid, companyId);
	}

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
	@Override
	public java.util.List<api.master.slayer.model.ConnectedAccounts>
		getConnectedAccountsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<api.master.slayer.model.ConnectedAccounts> orderByComparator) {

		return _connectedAccountsLocalService.
			getConnectedAccountsesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of connected accountses.
	 *
	 * @return the number of connected accountses
	 */
	@Override
	public int getConnectedAccountsesCount() {
		return _connectedAccountsLocalService.getConnectedAccountsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _connectedAccountsLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _connectedAccountsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _connectedAccountsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _connectedAccountsLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public api.master.slayer.model.ConnectedAccounts updateConnectedAccounts(
		api.master.slayer.model.ConnectedAccounts connectedAccounts) {

		return _connectedAccountsLocalService.updateConnectedAccounts(
			connectedAccounts);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _connectedAccountsLocalService.getBasePersistence();
	}

	@Override
	public ConnectedAccountsLocalService getWrappedService() {
		return _connectedAccountsLocalService;
	}

	@Override
	public void setWrappedService(
		ConnectedAccountsLocalService connectedAccountsLocalService) {

		_connectedAccountsLocalService = connectedAccountsLocalService;
	}

	private ConnectedAccountsLocalService _connectedAccountsLocalService;

}