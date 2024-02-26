/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence;

import api.master.slayer.model.MasterMetaData;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master meta data service. This utility wraps <code>api.master.slayer.service.persistence.impl.MasterMetaDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterMetaDataPersistence
 * @generated
 */
public class MasterMetaDataUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MasterMetaData masterMetaData) {
		getPersistence().clearCache(masterMetaData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, MasterMetaData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterMetaData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterMetaData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterMetaData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterMetaData update(MasterMetaData masterMetaData) {
		return getPersistence().update(masterMetaData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterMetaData update(
		MasterMetaData masterMetaData, ServiceContext serviceContext) {

		return getPersistence().update(masterMetaData, serviceContext);
	}

	/**
	 * Returns all the master meta datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching master meta datas
	 */
	public static List<MasterMetaData> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the master meta datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @return the range of matching master meta datas
	 */
	public static List<MasterMetaData> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the master meta datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master meta datas
	 */
	public static List<MasterMetaData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master meta datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master meta datas
	 */
	public static List<MasterMetaData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public static MasterMetaData findByUuid_First(
			String uuid, OrderByComparator<MasterMetaData> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public static MasterMetaData fetchByUuid_First(
		String uuid, OrderByComparator<MasterMetaData> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public static MasterMetaData findByUuid_Last(
			String uuid, OrderByComparator<MasterMetaData> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public static MasterMetaData fetchByUuid_Last(
		String uuid, OrderByComparator<MasterMetaData> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the master meta datas before and after the current master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param mmdId the primary key of the current master meta data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master meta data
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	public static MasterMetaData[] findByUuid_PrevAndNext(
			long mmdId, String uuid,
			OrderByComparator<MasterMetaData> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().findByUuid_PrevAndNext(
			mmdId, uuid, orderByComparator);
	}

	/**
	 * Removes all the master meta datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of master meta datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching master meta datas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the master meta data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMasterMetaDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public static MasterMetaData findByUUID_G(String uuid, long groupId)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the master meta data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public static MasterMetaData fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the master meta data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public static MasterMetaData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the master meta data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the master meta data that was removed
	 */
	public static MasterMetaData removeByUUID_G(String uuid, long groupId)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of master meta datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching master meta datas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching master meta datas
	 */
	public static List<MasterMetaData> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @return the range of matching master meta datas
	 */
	public static List<MasterMetaData> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master meta datas
	 */
	public static List<MasterMetaData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master meta datas
	 */
	public static List<MasterMetaData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public static MasterMetaData findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MasterMetaData> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public static MasterMetaData fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public static MasterMetaData findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MasterMetaData> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public static MasterMetaData fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the master meta datas before and after the current master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param mmdId the primary key of the current master meta data
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master meta data
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	public static MasterMetaData[] findByUuid_C_PrevAndNext(
			long mmdId, String uuid, long companyId,
			OrderByComparator<MasterMetaData> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().findByUuid_C_PrevAndNext(
			mmdId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the master meta datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching master meta datas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the master meta data in the entity cache if it is enabled.
	 *
	 * @param masterMetaData the master meta data
	 */
	public static void cacheResult(MasterMetaData masterMetaData) {
		getPersistence().cacheResult(masterMetaData);
	}

	/**
	 * Caches the master meta datas in the entity cache if it is enabled.
	 *
	 * @param masterMetaDatas the master meta datas
	 */
	public static void cacheResult(List<MasterMetaData> masterMetaDatas) {
		getPersistence().cacheResult(masterMetaDatas);
	}

	/**
	 * Creates a new master meta data with the primary key. Does not add the master meta data to the database.
	 *
	 * @param mmdId the primary key for the new master meta data
	 * @return the new master meta data
	 */
	public static MasterMetaData create(long mmdId) {
		return getPersistence().create(mmdId);
	}

	/**
	 * Removes the master meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data that was removed
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	public static MasterMetaData remove(long mmdId)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().remove(mmdId);
	}

	public static MasterMetaData updateImpl(MasterMetaData masterMetaData) {
		return getPersistence().updateImpl(masterMetaData);
	}

	/**
	 * Returns the master meta data with the primary key or throws a <code>NoSuchMasterMetaDataException</code> if it could not be found.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	public static MasterMetaData findByPrimaryKey(long mmdId)
		throws api.master.slayer.exception.NoSuchMasterMetaDataException {

		return getPersistence().findByPrimaryKey(mmdId);
	}

	/**
	 * Returns the master meta data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data, or <code>null</code> if a master meta data with the primary key could not be found
	 */
	public static MasterMetaData fetchByPrimaryKey(long mmdId) {
		return getPersistence().fetchByPrimaryKey(mmdId);
	}

	/**
	 * Returns all the master meta datas.
	 *
	 * @return the master meta datas
	 */
	public static List<MasterMetaData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @return the range of master meta datas
	 */
	public static List<MasterMetaData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master meta datas
	 */
	public static List<MasterMetaData> findAll(
		int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master meta datas
	 */
	public static List<MasterMetaData> findAll(
		int start, int end, OrderByComparator<MasterMetaData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master meta datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master meta datas.
	 *
	 * @return the number of master meta datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterMetaDataPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(MasterMetaDataPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile MasterMetaDataPersistence _persistence;

}