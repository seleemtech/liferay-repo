/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import api.master.slayer.model.MasterMetaData;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MasterMetaData. This utility wraps
 * <code>api.master.slayer.service.impl.MasterMetaDataLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MasterMetaDataLocalService
 * @generated
 */
public class MasterMetaDataLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>api.master.slayer.service.impl.MasterMetaDataLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static MasterMetaData addMasterMetaData(
		MasterMetaData masterMetaData) {

		return getService().addMasterMetaData(masterMetaData);
	}

	/**
	 * Creates a new master meta data with the primary key. Does not add the master meta data to the database.
	 *
	 * @param mmdId the primary key for the new master meta data
	 * @return the new master meta data
	 */
	public static MasterMetaData createMasterMetaData(long mmdId) {
		return getService().createMasterMetaData(mmdId);
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
	public static MasterMetaData deleteMasterMetaData(long mmdId)
		throws PortalException {

		return getService().deleteMasterMetaData(mmdId);
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
	public static MasterMetaData deleteMasterMetaData(
		MasterMetaData masterMetaData) {

		return getService().deleteMasterMetaData(masterMetaData);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterMetaDataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterMetaDataModelImpl</code>.
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

	public static MasterMetaData fetchMasterMetaData(long mmdId) {
		return getService().fetchMasterMetaData(mmdId);
	}

	/**
	 * Returns the master meta data matching the UUID and group.
	 *
	 * @param uuid the master meta data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public static MasterMetaData fetchMasterMetaDataByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchMasterMetaDataByUuidAndGroupId(uuid, groupId);
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
	 * Returns the master meta data with the primary key.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data
	 * @throws PortalException if a master meta data with the primary key could not be found
	 */
	public static MasterMetaData getMasterMetaData(long mmdId)
		throws PortalException {

		return getService().getMasterMetaData(mmdId);
	}

	/**
	 * Returns the master meta data matching the UUID and group.
	 *
	 * @param uuid the master meta data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master meta data
	 * @throws PortalException if a matching master meta data could not be found
	 */
	public static MasterMetaData getMasterMetaDataByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getMasterMetaDataByUuidAndGroupId(uuid, groupId);
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
	public static List<MasterMetaData> getMasterMetaDatas(int start, int end) {
		return getService().getMasterMetaDatas(start, end);
	}

	/**
	 * Returns all the master meta datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the master meta datas
	 * @param companyId the primary key of the company
	 * @return the matching master meta datas, or an empty list if no matches were found
	 */
	public static List<MasterMetaData> getMasterMetaDatasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getMasterMetaDatasByUuidAndCompanyId(
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
	public static List<MasterMetaData> getMasterMetaDatasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return getService().getMasterMetaDatasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of master meta datas.
	 *
	 * @return the number of master meta datas
	 */
	public static int getMasterMetaDatasCount() {
		return getService().getMasterMetaDatasCount();
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
	 * Updates the master meta data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterMetaDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterMetaData the master meta data
	 * @return the master meta data that was updated
	 */
	public static MasterMetaData updateMasterMetaData(
		MasterMetaData masterMetaData) {

		return getService().updateMasterMetaData(masterMetaData);
	}

	public static MasterMetaDataLocalService getService() {
		return _service;
	}

	public static void setService(MasterMetaDataLocalService service) {
		_service = service;
	}

	private static volatile MasterMetaDataLocalService _service;

}