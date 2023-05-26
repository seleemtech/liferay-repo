/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package SendOtpService.service.persistence;

import SendOtpService.exception.NoSuchSendDbException;

import SendOtpService.model.SendDb;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the send db service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SendDbUtil
 * @generated
 */
@ProviderType
public interface SendDbPersistence extends BasePersistence<SendDb> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SendDbUtil} to access the send db persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the send dbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching send dbs
	 */
	public java.util.List<SendDb> findByUuid(String uuid);

	/**
	 * Returns a range of all the send dbs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @return the range of matching send dbs
	 */
	public java.util.List<SendDb> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the send dbs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching send dbs
	 */
	public java.util.List<SendDb> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator);

	/**
	 * Returns an ordered range of all the send dbs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching send dbs
	 */
	public java.util.List<SendDb> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first send db in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching send db
	 * @throws NoSuchSendDbException if a matching send db could not be found
	 */
	public SendDb findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SendDb>
				orderByComparator)
		throws NoSuchSendDbException;

	/**
	 * Returns the first send db in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching send db, or <code>null</code> if a matching send db could not be found
	 */
	public SendDb fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator);

	/**
	 * Returns the last send db in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching send db
	 * @throws NoSuchSendDbException if a matching send db could not be found
	 */
	public SendDb findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SendDb>
				orderByComparator)
		throws NoSuchSendDbException;

	/**
	 * Returns the last send db in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching send db, or <code>null</code> if a matching send db could not be found
	 */
	public SendDb fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator);

	/**
	 * Returns the send dbs before and after the current send db in the ordered set where uuid = &#63;.
	 *
	 * @param sendId the primary key of the current send db
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next send db
	 * @throws NoSuchSendDbException if a send db with the primary key could not be found
	 */
	public SendDb[] findByUuid_PrevAndNext(
			long sendId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SendDb>
				orderByComparator)
		throws NoSuchSendDbException;

	/**
	 * Removes all the send dbs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of send dbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching send dbs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching send dbs
	 */
	public java.util.List<SendDb> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @return the range of matching send dbs
	 */
	public java.util.List<SendDb> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching send dbs
	 */
	public java.util.List<SendDb> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator);

	/**
	 * Returns an ordered range of all the send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching send dbs
	 */
	public java.util.List<SendDb> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching send db
	 * @throws NoSuchSendDbException if a matching send db could not be found
	 */
	public SendDb findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SendDb>
				orderByComparator)
		throws NoSuchSendDbException;

	/**
	 * Returns the first send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching send db, or <code>null</code> if a matching send db could not be found
	 */
	public SendDb fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator);

	/**
	 * Returns the last send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching send db
	 * @throws NoSuchSendDbException if a matching send db could not be found
	 */
	public SendDb findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SendDb>
				orderByComparator)
		throws NoSuchSendDbException;

	/**
	 * Returns the last send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching send db, or <code>null</code> if a matching send db could not be found
	 */
	public SendDb fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator);

	/**
	 * Returns the send dbs before and after the current send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sendId the primary key of the current send db
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next send db
	 * @throws NoSuchSendDbException if a send db with the primary key could not be found
	 */
	public SendDb[] findByUuid_C_PrevAndNext(
			long sendId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SendDb>
				orderByComparator)
		throws NoSuchSendDbException;

	/**
	 * Removes all the send dbs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching send dbs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the send db in the entity cache if it is enabled.
	 *
	 * @param sendDb the send db
	 */
	public void cacheResult(SendDb sendDb);

	/**
	 * Caches the send dbs in the entity cache if it is enabled.
	 *
	 * @param sendDbs the send dbs
	 */
	public void cacheResult(java.util.List<SendDb> sendDbs);

	/**
	 * Creates a new send db with the primary key. Does not add the send db to the database.
	 *
	 * @param sendId the primary key for the new send db
	 * @return the new send db
	 */
	public SendDb create(long sendId);

	/**
	 * Removes the send db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sendId the primary key of the send db
	 * @return the send db that was removed
	 * @throws NoSuchSendDbException if a send db with the primary key could not be found
	 */
	public SendDb remove(long sendId) throws NoSuchSendDbException;

	public SendDb updateImpl(SendDb sendDb);

	/**
	 * Returns the send db with the primary key or throws a <code>NoSuchSendDbException</code> if it could not be found.
	 *
	 * @param sendId the primary key of the send db
	 * @return the send db
	 * @throws NoSuchSendDbException if a send db with the primary key could not be found
	 */
	public SendDb findByPrimaryKey(long sendId) throws NoSuchSendDbException;

	/**
	 * Returns the send db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sendId the primary key of the send db
	 * @return the send db, or <code>null</code> if a send db with the primary key could not be found
	 */
	public SendDb fetchByPrimaryKey(long sendId);

	/**
	 * Returns all the send dbs.
	 *
	 * @return the send dbs
	 */
	public java.util.List<SendDb> findAll();

	/**
	 * Returns a range of all the send dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @return the range of send dbs
	 */
	public java.util.List<SendDb> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the send dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of send dbs
	 */
	public java.util.List<SendDb> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator);

	/**
	 * Returns an ordered range of all the send dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of send dbs
	 */
	public java.util.List<SendDb> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SendDb>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the send dbs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of send dbs.
	 *
	 * @return the number of send dbs
	 */
	public int countAll();

}