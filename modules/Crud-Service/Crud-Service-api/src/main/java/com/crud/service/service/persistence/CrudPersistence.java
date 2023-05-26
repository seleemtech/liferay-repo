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

package com.crud.service.service.persistence;

import com.crud.service.exception.NoSuchCrudException;
import com.crud.service.model.Crud;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the crud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CrudUtil
 * @generated
 */
@ProviderType
public interface CrudPersistence extends BasePersistence<Crud> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CrudUtil} to access the crud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cruds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cruds
	 */
	public java.util.List<Crud> findByUuid(String uuid);

	/**
	 * Returns a range of all the cruds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of matching cruds
	 */
	public java.util.List<Crud> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the cruds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cruds
	 */
	public java.util.List<Crud> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cruds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cruds
	 */
	public java.util.List<Crud> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public Crud findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Crud>
				orderByComparator)
		throws NoSuchCrudException;

	/**
	 * Returns the first crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public Crud fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Returns the last crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public Crud findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Crud>
				orderByComparator)
		throws NoSuchCrudException;

	/**
	 * Returns the last crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public Crud fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Returns the cruds before and after the current crud in the ordered set where uuid = &#63;.
	 *
	 * @param crudId the primary key of the current crud
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	public Crud[] findByUuid_PrevAndNext(
			long crudId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Crud>
				orderByComparator)
		throws NoSuchCrudException;

	/**
	 * Removes all the cruds where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cruds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cruds
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the cruds where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @return the matching cruds
	 */
	public java.util.List<Crud> findByCrudName(String crudName);

	/**
	 * Returns a range of all the cruds where crudName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudName the crud name
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of matching cruds
	 */
	public java.util.List<Crud> findByCrudName(
		String crudName, int start, int end);

	/**
	 * Returns an ordered range of all the cruds where crudName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudName the crud name
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cruds
	 */
	public java.util.List<Crud> findByCrudName(
		String crudName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cruds where crudName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudName the crud name
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cruds
	 */
	public java.util.List<Crud> findByCrudName(
		String crudName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public Crud findByCrudName_First(
			String crudName,
			com.liferay.portal.kernel.util.OrderByComparator<Crud>
				orderByComparator)
		throws NoSuchCrudException;

	/**
	 * Returns the first crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public Crud fetchByCrudName_First(
		String crudName,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Returns the last crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public Crud findByCrudName_Last(
			String crudName,
			com.liferay.portal.kernel.util.OrderByComparator<Crud>
				orderByComparator)
		throws NoSuchCrudException;

	/**
	 * Returns the last crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public Crud fetchByCrudName_Last(
		String crudName,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Returns the cruds before and after the current crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudId the primary key of the current crud
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	public Crud[] findByCrudName_PrevAndNext(
			long crudId, String crudName,
			com.liferay.portal.kernel.util.OrderByComparator<Crud>
				orderByComparator)
		throws NoSuchCrudException;

	/**
	 * Removes all the cruds where crudName = &#63; from the database.
	 *
	 * @param crudName the crud name
	 */
	public void removeByCrudName(String crudName);

	/**
	 * Returns the number of cruds where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @return the number of matching cruds
	 */
	public int countByCrudName(String crudName);

	/**
	 * Returns all the cruds where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @return the matching cruds
	 */
	public java.util.List<Crud> findByCrudId(long crudId);

	/**
	 * Returns a range of all the cruds where crudId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudId the crud ID
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of matching cruds
	 */
	public java.util.List<Crud> findByCrudId(long crudId, int start, int end);

	/**
	 * Returns an ordered range of all the cruds where crudId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudId the crud ID
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cruds
	 */
	public java.util.List<Crud> findByCrudId(
		long crudId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cruds where crudId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudId the crud ID
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cruds
	 */
	public java.util.List<Crud> findByCrudId(
		long crudId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public Crud findByCrudId_First(
			long crudId,
			com.liferay.portal.kernel.util.OrderByComparator<Crud>
				orderByComparator)
		throws NoSuchCrudException;

	/**
	 * Returns the first crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public Crud fetchByCrudId_First(
		long crudId,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Returns the last crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public Crud findByCrudId_Last(
			long crudId,
			com.liferay.portal.kernel.util.OrderByComparator<Crud>
				orderByComparator)
		throws NoSuchCrudException;

	/**
	 * Returns the last crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public Crud fetchByCrudId_Last(
		long crudId,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Removes all the cruds where crudId = &#63; from the database.
	 *
	 * @param crudId the crud ID
	 */
	public void removeByCrudId(long crudId);

	/**
	 * Returns the number of cruds where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @return the number of matching cruds
	 */
	public int countByCrudId(long crudId);

	/**
	 * Caches the crud in the entity cache if it is enabled.
	 *
	 * @param crud the crud
	 */
	public void cacheResult(Crud crud);

	/**
	 * Caches the cruds in the entity cache if it is enabled.
	 *
	 * @param cruds the cruds
	 */
	public void cacheResult(java.util.List<Crud> cruds);

	/**
	 * Creates a new crud with the primary key. Does not add the crud to the database.
	 *
	 * @param crudId the primary key for the new crud
	 * @return the new crud
	 */
	public Crud create(long crudId);

	/**
	 * Removes the crud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud that was removed
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	public Crud remove(long crudId) throws NoSuchCrudException;

	public Crud updateImpl(Crud crud);

	/**
	 * Returns the crud with the primary key or throws a <code>NoSuchCrudException</code> if it could not be found.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	public Crud findByPrimaryKey(long crudId) throws NoSuchCrudException;

	/**
	 * Returns the crud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud, or <code>null</code> if a crud with the primary key could not be found
	 */
	public Crud fetchByPrimaryKey(long crudId);

	/**
	 * Returns all the cruds.
	 *
	 * @return the cruds
	 */
	public java.util.List<Crud> findAll();

	/**
	 * Returns a range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of cruds
	 */
	public java.util.List<Crud> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cruds
	 */
	public java.util.List<Crud> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cruds
	 */
	public java.util.List<Crud> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crud>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cruds from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cruds.
	 *
	 * @return the number of cruds
	 */
	public int countAll();

}