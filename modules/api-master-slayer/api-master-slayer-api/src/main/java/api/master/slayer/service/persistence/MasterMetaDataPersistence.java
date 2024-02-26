/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence;

import api.master.slayer.exception.NoSuchMasterMetaDataException;
import api.master.slayer.model.MasterMetaData;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master meta data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterMetaDataUtil
 * @generated
 */
@ProviderType
public interface MasterMetaDataPersistence
	extends BasePersistence<MasterMetaData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterMetaDataUtil} to access the master meta data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master meta datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching master meta datas
	 */
	public java.util.List<MasterMetaData> findByUuid(String uuid);

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
	public java.util.List<MasterMetaData> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MasterMetaData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator);

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
	public java.util.List<MasterMetaData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public MasterMetaData findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
				orderByComparator)
		throws NoSuchMasterMetaDataException;

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public MasterMetaData fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator);

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public MasterMetaData findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
				orderByComparator)
		throws NoSuchMasterMetaDataException;

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public MasterMetaData fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator);

	/**
	 * Returns the master meta datas before and after the current master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param mmdId the primary key of the current master meta data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master meta data
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	public MasterMetaData[] findByUuid_PrevAndNext(
			long mmdId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
				orderByComparator)
		throws NoSuchMasterMetaDataException;

	/**
	 * Removes all the master meta datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of master meta datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching master meta datas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the master meta data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMasterMetaDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public MasterMetaData findByUUID_G(String uuid, long groupId)
		throws NoSuchMasterMetaDataException;

	/**
	 * Returns the master meta data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public MasterMetaData fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the master meta data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public MasterMetaData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the master meta data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the master meta data that was removed
	 */
	public MasterMetaData removeByUUID_G(String uuid, long groupId)
		throws NoSuchMasterMetaDataException;

	/**
	 * Returns the number of master meta datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching master meta datas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching master meta datas
	 */
	public java.util.List<MasterMetaData> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<MasterMetaData> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<MasterMetaData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator);

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
	public java.util.List<MasterMetaData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public MasterMetaData findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
				orderByComparator)
		throws NoSuchMasterMetaDataException;

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public MasterMetaData fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator);

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	public MasterMetaData findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
				orderByComparator)
		throws NoSuchMasterMetaDataException;

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	public MasterMetaData fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator);

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
	public MasterMetaData[] findByUuid_C_PrevAndNext(
			long mmdId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
				orderByComparator)
		throws NoSuchMasterMetaDataException;

	/**
	 * Removes all the master meta datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching master meta datas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the master meta data in the entity cache if it is enabled.
	 *
	 * @param masterMetaData the master meta data
	 */
	public void cacheResult(MasterMetaData masterMetaData);

	/**
	 * Caches the master meta datas in the entity cache if it is enabled.
	 *
	 * @param masterMetaDatas the master meta datas
	 */
	public void cacheResult(java.util.List<MasterMetaData> masterMetaDatas);

	/**
	 * Creates a new master meta data with the primary key. Does not add the master meta data to the database.
	 *
	 * @param mmdId the primary key for the new master meta data
	 * @return the new master meta data
	 */
	public MasterMetaData create(long mmdId);

	/**
	 * Removes the master meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data that was removed
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	public MasterMetaData remove(long mmdId)
		throws NoSuchMasterMetaDataException;

	public MasterMetaData updateImpl(MasterMetaData masterMetaData);

	/**
	 * Returns the master meta data with the primary key or throws a <code>NoSuchMasterMetaDataException</code> if it could not be found.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	public MasterMetaData findByPrimaryKey(long mmdId)
		throws NoSuchMasterMetaDataException;

	/**
	 * Returns the master meta data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data, or <code>null</code> if a master meta data with the primary key could not be found
	 */
	public MasterMetaData fetchByPrimaryKey(long mmdId);

	/**
	 * Returns all the master meta datas.
	 *
	 * @return the master meta datas
	 */
	public java.util.List<MasterMetaData> findAll();

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
	public java.util.List<MasterMetaData> findAll(int start, int end);

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
	public java.util.List<MasterMetaData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator);

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
	public java.util.List<MasterMetaData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterMetaData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master meta datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master meta datas.
	 *
	 * @return the number of master meta datas
	 */
	public int countAll();

}