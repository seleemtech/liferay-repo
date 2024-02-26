/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link MasterUrlLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MasterUrlLocalService
 * @generated
 */
public class MasterUrlLocalServiceWrapper
	implements MasterUrlLocalService, ServiceWrapper<MasterUrlLocalService> {

	public MasterUrlLocalServiceWrapper() {
		this(null);
	}

	public MasterUrlLocalServiceWrapper(
		MasterUrlLocalService masterUrlLocalService) {

		_masterUrlLocalService = masterUrlLocalService;
	}

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
	@Override
	public api.master.slayer.model.MasterUrl addMasterUrl(
		api.master.slayer.model.MasterUrl masterUrl) {

		return _masterUrlLocalService.addMasterUrl(masterUrl);
	}

	/**
	 * Creates a new master url with the primary key. Does not add the master url to the database.
	 *
	 * @param masterUrlId the primary key for the new master url
	 * @return the new master url
	 */
	@Override
	public api.master.slayer.model.MasterUrl createMasterUrl(long masterUrlId) {
		return _masterUrlLocalService.createMasterUrl(masterUrlId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterUrlLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public api.master.slayer.model.MasterUrl deleteMasterUrl(long masterUrlId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterUrlLocalService.deleteMasterUrl(masterUrlId);
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
	@Override
	public api.master.slayer.model.MasterUrl deleteMasterUrl(
		api.master.slayer.model.MasterUrl masterUrl) {

		return _masterUrlLocalService.deleteMasterUrl(masterUrl);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterUrlLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _masterUrlLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _masterUrlLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterUrlLocalService.dynamicQuery();
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

		return _masterUrlLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _masterUrlLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _masterUrlLocalService.dynamicQuery(
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

		return _masterUrlLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterUrlLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public api.master.slayer.model.MasterUrl fetchMasterUrl(long masterUrlId) {
		return _masterUrlLocalService.fetchMasterUrl(masterUrlId);
	}

	/**
	 * Returns the master url matching the UUID and group.
	 *
	 * @param uuid the master url's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public api.master.slayer.model.MasterUrl fetchMasterUrlByUuidAndGroupId(
		String uuid, long groupId) {

		return _masterUrlLocalService.fetchMasterUrlByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterUrlLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _masterUrlLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterUrlLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master url with the primary key.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url
	 * @throws PortalException if a master url with the primary key could not be found
	 */
	@Override
	public api.master.slayer.model.MasterUrl getMasterUrl(long masterUrlId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterUrlLocalService.getMasterUrl(masterUrlId);
	}

	/**
	 * Returns the master url matching the UUID and group.
	 *
	 * @param uuid the master url's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master url
	 * @throws PortalException if a matching master url could not be found
	 */
	@Override
	public api.master.slayer.model.MasterUrl getMasterUrlByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterUrlLocalService.getMasterUrlByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<api.master.slayer.model.MasterUrl> getMasterUrls(
		int start, int end) {

		return _masterUrlLocalService.getMasterUrls(start, end);
	}

	/**
	 * Returns all the master urls matching the UUID and company.
	 *
	 * @param uuid the UUID of the master urls
	 * @param companyId the primary key of the company
	 * @return the matching master urls, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<api.master.slayer.model.MasterUrl>
		getMasterUrlsByUuidAndCompanyId(String uuid, long companyId) {

		return _masterUrlLocalService.getMasterUrlsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<api.master.slayer.model.MasterUrl>
		getMasterUrlsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<api.master.slayer.model.MasterUrl> orderByComparator) {

		return _masterUrlLocalService.getMasterUrlsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of master urls.
	 *
	 * @return the number of master urls
	 */
	@Override
	public int getMasterUrlsCount() {
		return _masterUrlLocalService.getMasterUrlsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterUrlLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterUrlLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public api.master.slayer.model.MasterUrl updateMasterUrl(
		api.master.slayer.model.MasterUrl masterUrl) {

		return _masterUrlLocalService.updateMasterUrl(masterUrl);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _masterUrlLocalService.getBasePersistence();
	}

	@Override
	public MasterUrlLocalService getWrappedService() {
		return _masterUrlLocalService;
	}

	@Override
	public void setWrappedService(MasterUrlLocalService masterUrlLocalService) {
		_masterUrlLocalService = masterUrlLocalService;
	}

	private MasterUrlLocalService _masterUrlLocalService;

}