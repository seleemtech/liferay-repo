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

package com.prime.data.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.prime.data.service.exception.NoSuchSalesStageException;
import com.prime.data.service.model.SalesStage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sales stage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesStageUtil
 * @generated
 */
@ProviderType
public interface SalesStagePersistence extends BasePersistence<SalesStage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalesStageUtil} to access the sales stage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sales stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales stages
	 */
	public java.util.List<SalesStage> findByUuid(String uuid);

	/**
	 * Returns a range of all the sales stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @return the range of matching sales stages
	 */
	public java.util.List<SalesStage> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the sales stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales stages
	 */
	public java.util.List<SalesStage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesStage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sales stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales stages
	 */
	public java.util.List<SalesStage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesStage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales stage
	 * @throws NoSuchSalesStageException if a matching sales stage could not be found
	 */
	public SalesStage findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SalesStage>
				orderByComparator)
		throws NoSuchSalesStageException;

	/**
	 * Returns the first sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales stage, or <code>null</code> if a matching sales stage could not be found
	 */
	public SalesStage fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SalesStage>
			orderByComparator);

	/**
	 * Returns the last sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales stage
	 * @throws NoSuchSalesStageException if a matching sales stage could not be found
	 */
	public SalesStage findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SalesStage>
				orderByComparator)
		throws NoSuchSalesStageException;

	/**
	 * Returns the last sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales stage, or <code>null</code> if a matching sales stage could not be found
	 */
	public SalesStage fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SalesStage>
			orderByComparator);

	/**
	 * Returns the sales stages before and after the current sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param salesStageId the primary key of the current sales stage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales stage
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	public SalesStage[] findByUuid_PrevAndNext(
			long salesStageId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SalesStage>
				orderByComparator)
		throws NoSuchSalesStageException;

	/**
	 * Removes all the sales stages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sales stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales stages
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the sales stage in the entity cache if it is enabled.
	 *
	 * @param salesStage the sales stage
	 */
	public void cacheResult(SalesStage salesStage);

	/**
	 * Caches the sales stages in the entity cache if it is enabled.
	 *
	 * @param salesStages the sales stages
	 */
	public void cacheResult(java.util.List<SalesStage> salesStages);

	/**
	 * Creates a new sales stage with the primary key. Does not add the sales stage to the database.
	 *
	 * @param salesStageId the primary key for the new sales stage
	 * @return the new sales stage
	 */
	public SalesStage create(long salesStageId);

	/**
	 * Removes the sales stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage that was removed
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	public SalesStage remove(long salesStageId)
		throws NoSuchSalesStageException;

	public SalesStage updateImpl(SalesStage salesStage);

	/**
	 * Returns the sales stage with the primary key or throws a <code>NoSuchSalesStageException</code> if it could not be found.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	public SalesStage findByPrimaryKey(long salesStageId)
		throws NoSuchSalesStageException;

	/**
	 * Returns the sales stage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage, or <code>null</code> if a sales stage with the primary key could not be found
	 */
	public SalesStage fetchByPrimaryKey(long salesStageId);

	/**
	 * Returns all the sales stages.
	 *
	 * @return the sales stages
	 */
	public java.util.List<SalesStage> findAll();

	/**
	 * Returns a range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @return the range of sales stages
	 */
	public java.util.List<SalesStage> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sales stages
	 */
	public java.util.List<SalesStage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesStage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sales stages
	 */
	public java.util.List<SalesStage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalesStage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sales stages from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sales stages.
	 *
	 * @return the number of sales stages
	 */
	public int countAll();

}