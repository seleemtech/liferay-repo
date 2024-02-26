/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link MasterMetaDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MasterMetaDataLocalService
 * @generated
 */
public class MasterMetaDataLocalServiceWrapper
	implements MasterMetaDataLocalService,
			   ServiceWrapper<MasterMetaDataLocalService> {

	public MasterMetaDataLocalServiceWrapper() {
		this(null);
	}

	public MasterMetaDataLocalServiceWrapper(
		MasterMetaDataLocalService masterMetaDataLocalService) {

		_masterMetaDataLocalService = masterMetaDataLocalService;
	}

	/**
	 * Adds the master meta data to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterMetaDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterMetaData the master meta data
	 * @return the master meta data that was added
	 */
	@Override
	public api.master.slayer.model.MasterMetaData addMasterMetaData(
		api.master.slayer.model.MasterMetaData masterMetaData) {

		return _masterMetaDataLocalService.addMasterMetaData(masterMetaData);
	}

	/**
	 * Creates a new master meta data with the primary key. Does not add the master meta data to the database.
	 *
	 * @param mmdId the primary key for the new master meta data
	 * @return the new master meta data
	 */
	@Override
	public api.master.slayer.model.MasterMetaData createMasterMetaData(
		long mmdId) {

		return _masterMetaDataLocalService.createMasterMetaData(mmdId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterMetaDataLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the master meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterMetaDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data that was removed
	 * @throws PortalException if a master meta data with the primary key could not be found
	 */
	@Override
	public api.master.slayer.model.MasterMetaData deleteMasterMetaData(
			long mmdId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterMetaDataLocalService.deleteMasterMetaData(mmdId);
	}

	/**
	 * Deletes the master meta data from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterMetaDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterMetaData the master meta data
	 * @return the master meta data that was removed
	 */
	@Override
	public api.master.slayer.model.MasterMetaData deleteMasterMetaData(
		api.master.slayer.model.MasterMetaData masterMetaData) {

		return _masterMetaDataLocalService.deleteMasterMetaData(masterMetaData);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterMetaDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _masterMetaDataLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _masterMetaDataLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterMetaDataLocalService.dynamicQuery();
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

		return _masterMetaDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterMetaDataModelImpl</code>.
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

		return _masterMetaDataLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterMetaDataModelImpl</code>.
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

		return _masterMetaDataLocalService.dynamicQuery(
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

		return _masterMetaDataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterMetaDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public api.master.slayer.model.MasterMetaData fetchMasterMetaData(
		long mmdId) {

		return _masterMetaDataLocalService.fetchMasterMetaData(mmdId);
	}

	/**
	 * Returns the master meta data matching the UUID and group.
	 *
	 * @param uuid the master meta data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	@Override
	public api.master.slayer.model.MasterMetaData
		fetchMasterMetaDataByUuidAndGroupId(String uuid, long groupId) {

		return _masterMetaDataLocalService.fetchMasterMetaDataByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterMetaDataLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _masterMetaDataLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterMetaDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master meta data with the primary key.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data
	 * @throws PortalException if a master meta data with the primary key could not be found
	 */
	@Override
	public api.master.slayer.model.MasterMetaData getMasterMetaData(long mmdId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterMetaDataLocalService.getMasterMetaData(mmdId);
	}

	/**
	 * Returns the master meta data matching the UUID and group.
	 *
	 * @param uuid the master meta data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master meta data
	 * @throws PortalException if a matching master meta data could not be found
	 */
	@Override
	public api.master.slayer.model.MasterMetaData
			getMasterMetaDataByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterMetaDataLocalService.getMasterMetaDataByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the master meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @return the range of master meta datas
	 */
	@Override
	public java.util.List<api.master.slayer.model.MasterMetaData>
		getMasterMetaDatas(int start, int end) {

		return _masterMetaDataLocalService.getMasterMetaDatas(start, end);
	}

	/**
	 * Returns all the master meta datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the master meta datas
	 * @param companyId the primary key of the company
	 * @return the matching master meta datas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<api.master.slayer.model.MasterMetaData>
		getMasterMetaDatasByUuidAndCompanyId(String uuid, long companyId) {

		return _masterMetaDataLocalService.getMasterMetaDatasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of master meta datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the master meta datas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching master meta datas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<api.master.slayer.model.MasterMetaData>
		getMasterMetaDatasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<api.master.slayer.model.MasterMetaData> orderByComparator) {

		return _masterMetaDataLocalService.getMasterMetaDatasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of master meta datas.
	 *
	 * @return the number of master meta datas
	 */
	@Override
	public int getMasterMetaDatasCount() {
		return _masterMetaDataLocalService.getMasterMetaDatasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterMetaDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterMetaDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the master meta data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterMetaDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterMetaData the master meta data
	 * @return the master meta data that was updated
	 */
	@Override
	public api.master.slayer.model.MasterMetaData updateMasterMetaData(
		api.master.slayer.model.MasterMetaData masterMetaData) {

		return _masterMetaDataLocalService.updateMasterMetaData(masterMetaData);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _masterMetaDataLocalService.getBasePersistence();
	}

	@Override
	public MasterMetaDataLocalService getWrappedService() {
		return _masterMetaDataLocalService;
	}

	@Override
	public void setWrappedService(
		MasterMetaDataLocalService masterMetaDataLocalService) {

		_masterMetaDataLocalService = masterMetaDataLocalService;
	}

	private MasterMetaDataLocalService _masterMetaDataLocalService;

}