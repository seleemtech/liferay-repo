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

package com.intranet.service.persistence;

import com.intranet.exception.NoSuchSpecializationException;
import com.intranet.model.Specialization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the specialization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecializationUtil
 * @generated
 */
@ProviderType
public interface SpecializationPersistence
	extends BasePersistence<Specialization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpecializationUtil} to access the specialization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the specializations where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @return the matching specializations
	 */
	public java.util.List<Specialization> findBygraduationCode(
		String graduationCode);

	/**
	 * Returns a range of all the specializations where graduationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param graduationCode the graduation code
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @return the range of matching specializations
	 */
	public java.util.List<Specialization> findBygraduationCode(
		String graduationCode, int start, int end);

	/**
	 * Returns an ordered range of all the specializations where graduationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param graduationCode the graduation code
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specializations
	 */
	public java.util.List<Specialization> findBygraduationCode(
		String graduationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specialization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specializations where graduationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param graduationCode the graduation code
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specializations
	 */
	public java.util.List<Specialization> findBygraduationCode(
		String graduationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specialization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialization
	 * @throws NoSuchSpecializationException if a matching specialization could not be found
	 */
	public Specialization findBygraduationCode_First(
			String graduationCode,
			com.liferay.portal.kernel.util.OrderByComparator<Specialization>
				orderByComparator)
		throws NoSuchSpecializationException;

	/**
	 * Returns the first specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialization, or <code>null</code> if a matching specialization could not be found
	 */
	public Specialization fetchBygraduationCode_First(
		String graduationCode,
		com.liferay.portal.kernel.util.OrderByComparator<Specialization>
			orderByComparator);

	/**
	 * Returns the last specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialization
	 * @throws NoSuchSpecializationException if a matching specialization could not be found
	 */
	public Specialization findBygraduationCode_Last(
			String graduationCode,
			com.liferay.portal.kernel.util.OrderByComparator<Specialization>
				orderByComparator)
		throws NoSuchSpecializationException;

	/**
	 * Returns the last specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialization, or <code>null</code> if a matching specialization could not be found
	 */
	public Specialization fetchBygraduationCode_Last(
		String graduationCode,
		com.liferay.portal.kernel.util.OrderByComparator<Specialization>
			orderByComparator);

	/**
	 * Returns the specializations before and after the current specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param spCode the primary key of the current specialization
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specialization
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	public Specialization[] findBygraduationCode_PrevAndNext(
			long spCode, String graduationCode,
			com.liferay.portal.kernel.util.OrderByComparator<Specialization>
				orderByComparator)
		throws NoSuchSpecializationException;

	/**
	 * Removes all the specializations where graduationCode = &#63; from the database.
	 *
	 * @param graduationCode the graduation code
	 */
	public void removeBygraduationCode(String graduationCode);

	/**
	 * Returns the number of specializations where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @return the number of matching specializations
	 */
	public int countBygraduationCode(String graduationCode);

	/**
	 * Caches the specialization in the entity cache if it is enabled.
	 *
	 * @param specialization the specialization
	 */
	public void cacheResult(Specialization specialization);

	/**
	 * Caches the specializations in the entity cache if it is enabled.
	 *
	 * @param specializations the specializations
	 */
	public void cacheResult(java.util.List<Specialization> specializations);

	/**
	 * Creates a new specialization with the primary key. Does not add the specialization to the database.
	 *
	 * @param spCode the primary key for the new specialization
	 * @return the new specialization
	 */
	public Specialization create(long spCode);

	/**
	 * Removes the specialization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCode the primary key of the specialization
	 * @return the specialization that was removed
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	public Specialization remove(long spCode)
		throws NoSuchSpecializationException;

	public Specialization updateImpl(Specialization specialization);

	/**
	 * Returns the specialization with the primary key or throws a <code>NoSuchSpecializationException</code> if it could not be found.
	 *
	 * @param spCode the primary key of the specialization
	 * @return the specialization
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	public Specialization findByPrimaryKey(long spCode)
		throws NoSuchSpecializationException;

	/**
	 * Returns the specialization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCode the primary key of the specialization
	 * @return the specialization, or <code>null</code> if a specialization with the primary key could not be found
	 */
	public Specialization fetchByPrimaryKey(long spCode);

	/**
	 * Returns all the specializations.
	 *
	 * @return the specializations
	 */
	public java.util.List<Specialization> findAll();

	/**
	 * Returns a range of all the specializations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @return the range of specializations
	 */
	public java.util.List<Specialization> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the specializations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of specializations
	 */
	public java.util.List<Specialization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specialization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the specializations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of specializations
	 */
	public java.util.List<Specialization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Specialization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the specializations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of specializations.
	 *
	 * @return the number of specializations
	 */
	public int countAll();

}