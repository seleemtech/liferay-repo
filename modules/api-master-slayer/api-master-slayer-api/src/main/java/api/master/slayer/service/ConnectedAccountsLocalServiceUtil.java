/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import api.master.slayer.model.ConnectedAccounts;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ConnectedAccounts. This utility wraps
 * <code>api.master.slayer.service.impl.ConnectedAccountsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectedAccountsLocalService
 * @generated
 */
public class ConnectedAccountsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>api.master.slayer.service.impl.ConnectedAccountsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static ConnectedAccounts addConnectedAccounts(
		ConnectedAccounts connectedAccounts) {

		return getService().addConnectedAccounts(connectedAccounts);
	}

	/**
	 * Creates a new connected accounts with the primary key. Does not add the connected accounts to the database.
	 *
	 * @param c_accountId the primary key for the new connected accounts
	 * @return the new connected accounts
	 */
	public static ConnectedAccounts createConnectedAccounts(long c_accountId) {
		return getService().createConnectedAccounts(c_accountId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static ConnectedAccounts deleteConnectedAccounts(
		ConnectedAccounts connectedAccounts) {

		return getService().deleteConnectedAccounts(connectedAccounts);
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
	public static ConnectedAccounts deleteConnectedAccounts(long c_accountId)
		throws PortalException {

		return getService().deleteConnectedAccounts(c_accountId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ConnectedAccounts fetchConnectedAccounts(long c_accountId) {
		return getService().fetchConnectedAccounts(c_accountId);
	}

	/**
	 * Returns the connected accounts matching the UUID and group.
	 *
	 * @param uuid the connected accounts's UUID
	 * @param groupId the primary key of the group
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchConnectedAccountsByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchConnectedAccountsByUuidAndGroupId(
			uuid, groupId);
	}

	public static ConnectedAccounts getAccountByEmailAndAppName(
		String appName, String emailAddress) {

		return getService().getAccountByEmailAndAppName(appName, emailAddress);
	}

	public static List<ConnectedAccounts> getAccountsByUserId(long userId) {
		return getService().getAccountsByUserId(userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the connected accounts with the primary key.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts
	 * @throws PortalException if a connected accounts with the primary key could not be found
	 */
	public static ConnectedAccounts getConnectedAccounts(long c_accountId)
		throws PortalException {

		return getService().getConnectedAccounts(c_accountId);
	}

	/**
	 * Returns the connected accounts matching the UUID and group.
	 *
	 * @param uuid the connected accounts's UUID
	 * @param groupId the primary key of the group
	 * @return the matching connected accounts
	 * @throws PortalException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts getConnectedAccountsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getConnectedAccountsByUuidAndGroupId(uuid, groupId);
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
	public static List<ConnectedAccounts> getConnectedAccountses(
		int start, int end) {

		return getService().getConnectedAccountses(start, end);
	}

	/**
	 * Returns all the connected accountses matching the UUID and company.
	 *
	 * @param uuid the UUID of the connected accountses
	 * @param companyId the primary key of the company
	 * @return the matching connected accountses, or an empty list if no matches were found
	 */
	public static List<ConnectedAccounts>
		getConnectedAccountsesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getConnectedAccountsesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ConnectedAccounts>
		getConnectedAccountsesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getService().getConnectedAccountsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of connected accountses.
	 *
	 * @return the number of connected accountses
	 */
	public static int getConnectedAccountsesCount() {
		return getService().getConnectedAccountsesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static ConnectedAccounts updateConnectedAccounts(
		ConnectedAccounts connectedAccounts) {

		return getService().updateConnectedAccounts(connectedAccounts);
	}

	public static ConnectedAccountsLocalService getService() {
		return _service;
	}

	public static void setService(ConnectedAccountsLocalService service) {
		_service = service;
	}

	private static volatile ConnectedAccountsLocalService _service;

}