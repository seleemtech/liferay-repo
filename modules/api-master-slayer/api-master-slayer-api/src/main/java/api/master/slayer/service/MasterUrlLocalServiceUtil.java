/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import api.master.slayer.model.MasterUrl;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MasterUrl. This utility wraps
 * <code>api.master.slayer.service.impl.MasterUrlLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MasterUrlLocalService
 * @generated
 */
public class MasterUrlLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>api.master.slayer.service.impl.MasterUrlLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the master url to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterUrlLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterUrl the master url
	 * @return the master url that was added
	 */
	public static MasterUrl addMasterUrl(MasterUrl masterUrl) {
		return getService().addMasterUrl(masterUrl);
	}

	/**
	 * Creates a new master url with the primary key. Does not add the master url to the database.
	 *
	 * @param masterUrlId the primary key for the new master url
	 * @return the new master url
	 */
	public static MasterUrl createMasterUrl(long masterUrlId) {
		return getService().createMasterUrl(masterUrlId);
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
	 * Deletes the master url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterUrlLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url that was removed
	 * @throws PortalException if a master url with the primary key could not be found
	 */
	public static MasterUrl deleteMasterUrl(long masterUrlId)
		throws PortalException {

		return getService().deleteMasterUrl(masterUrlId);
	}

	/**
	 * Deletes the master url from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterUrlLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterUrl the master url
	 * @return the master url that was removed
	 */
	public static MasterUrl deleteMasterUrl(MasterUrl masterUrl) {
		return getService().deleteMasterUrl(masterUrl);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterUrlModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterUrlModelImpl</code>.
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

	public static MasterUrl fetchMasterUrl(long masterUrlId) {
		return getService().fetchMasterUrl(masterUrlId);
	}

	/**
	 * Returns the master url matching the UUID and group.
	 *
	 * @param uuid the master url's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public static MasterUrl fetchMasterUrlByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchMasterUrlByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the master url with the primary key.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url
	 * @throws PortalException if a master url with the primary key could not be found
	 */
	public static MasterUrl getMasterUrl(long masterUrlId)
		throws PortalException {

		return getService().getMasterUrl(masterUrlId);
	}

	/**
	 * Returns the master url matching the UUID and group.
	 *
	 * @param uuid the master url's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master url
	 * @throws PortalException if a matching master url could not be found
	 */
	public static MasterUrl getMasterUrlByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getMasterUrlByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the master urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @return the range of master urls
	 */
	public static List<MasterUrl> getMasterUrls(int start, int end) {
		return getService().getMasterUrls(start, end);
	}

	/**
	 * Returns all the master urls matching the UUID and company.
	 *
	 * @param uuid the UUID of the master urls
	 * @param companyId the primary key of the company
	 * @return the matching master urls, or an empty list if no matches were found
	 */
	public static List<MasterUrl> getMasterUrlsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getMasterUrlsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of master urls matching the UUID and company.
	 *
	 * @param uuid the UUID of the master urls
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching master urls, or an empty list if no matches were found
	 */
	public static List<MasterUrl> getMasterUrlsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator) {

		return getService().getMasterUrlsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of master urls.
	 *
	 * @return the number of master urls
	 */
	public static int getMasterUrlsCount() {
		return getService().getMasterUrlsCount();
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
	 * Updates the master url in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterUrlLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterUrl the master url
	 * @return the master url that was updated
	 */
	public static MasterUrl updateMasterUrl(MasterUrl masterUrl) {
		return getService().updateMasterUrl(masterUrl);
	}

	public static MasterUrlLocalService getService() {
		return _service;
	}

	public static void setService(MasterUrlLocalService service) {
		_service = service;
	}

	private static volatile MasterUrlLocalService _service;

}