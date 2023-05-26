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

package com.candidate.service.service.persistence;

import com.candidate.service.exception.NoSuchProfessionalDetailsException;
import com.candidate.service.model.ProfessionalDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the professional details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalDetailsUtil
 * @generated
 */
@ProviderType
public interface ProfessionalDetailsPersistence
	extends BasePersistence<ProfessionalDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfessionalDetailsUtil} to access the professional details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the professional detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching professional detailses
	 */
	public java.util.List<ProfessionalDetails> findByUuid(String uuid);

	/**
	 * Returns a range of all the professional detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @return the range of matching professional detailses
	 */
	public java.util.List<ProfessionalDetails> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the professional detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching professional detailses
	 */
	public java.util.List<ProfessionalDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the professional detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching professional detailses
	 */
	public java.util.List<ProfessionalDetails> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first professional details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public ProfessionalDetails findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProfessionalDetails> orderByComparator)
		throws NoSuchProfessionalDetailsException;

	/**
	 * Returns the first professional details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public ProfessionalDetails fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator);

	/**
	 * Returns the last professional details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public ProfessionalDetails findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProfessionalDetails> orderByComparator)
		throws NoSuchProfessionalDetailsException;

	/**
	 * Returns the last professional details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public ProfessionalDetails fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator);

	/**
	 * Returns the professional detailses before and after the current professional details in the ordered set where uuid = &#63;.
	 *
	 * @param professionalDetailsId the primary key of the current professional details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professional details
	 * @throws NoSuchProfessionalDetailsException if a professional details with the primary key could not be found
	 */
	public ProfessionalDetails[] findByUuid_PrevAndNext(
			long professionalDetailsId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProfessionalDetails> orderByComparator)
		throws NoSuchProfessionalDetailsException;

	/**
	 * Removes all the professional detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of professional detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching professional detailses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching professional detailses
	 */
	public java.util.List<ProfessionalDetails> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @return the range of matching professional detailses
	 */
	public java.util.List<ProfessionalDetails> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching professional detailses
	 */
	public java.util.List<ProfessionalDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching professional detailses
	 */
	public java.util.List<ProfessionalDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public ProfessionalDetails findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProfessionalDetails> orderByComparator)
		throws NoSuchProfessionalDetailsException;

	/**
	 * Returns the first professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public ProfessionalDetails fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator);

	/**
	 * Returns the last professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public ProfessionalDetails findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProfessionalDetails> orderByComparator)
		throws NoSuchProfessionalDetailsException;

	/**
	 * Returns the last professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public ProfessionalDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator);

	/**
	 * Returns the professional detailses before and after the current professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param professionalDetailsId the primary key of the current professional details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professional details
	 * @throws NoSuchProfessionalDetailsException if a professional details with the primary key could not be found
	 */
	public ProfessionalDetails[] findByUuid_C_PrevAndNext(
			long professionalDetailsId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ProfessionalDetails> orderByComparator)
		throws NoSuchProfessionalDetailsException;

	/**
	 * Removes all the professional detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching professional detailses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the professional details where candidateId = &#63; or throws a <code>NoSuchProfessionalDetailsException</code> if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public ProfessionalDetails findByCandidateId(long candidateId)
		throws NoSuchProfessionalDetailsException;

	/**
	 * Returns the professional details where candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public ProfessionalDetails fetchByCandidateId(long candidateId);

	/**
	 * Returns the professional details where candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public ProfessionalDetails fetchByCandidateId(
		long candidateId, boolean useFinderCache);

	/**
	 * Removes the professional details where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @return the professional details that was removed
	 */
	public ProfessionalDetails removeByCandidateId(long candidateId)
		throws NoSuchProfessionalDetailsException;

	/**
	 * Returns the number of professional detailses where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching professional detailses
	 */
	public int countByCandidateId(long candidateId);

	/**
	 * Caches the professional details in the entity cache if it is enabled.
	 *
	 * @param professionalDetails the professional details
	 */
	public void cacheResult(ProfessionalDetails professionalDetails);

	/**
	 * Caches the professional detailses in the entity cache if it is enabled.
	 *
	 * @param professionalDetailses the professional detailses
	 */
	public void cacheResult(
		java.util.List<ProfessionalDetails> professionalDetailses);

	/**
	 * Creates a new professional details with the primary key. Does not add the professional details to the database.
	 *
	 * @param professionalDetailsId the primary key for the new professional details
	 * @return the new professional details
	 */
	public ProfessionalDetails create(long professionalDetailsId);

	/**
	 * Removes the professional details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param professionalDetailsId the primary key of the professional details
	 * @return the professional details that was removed
	 * @throws NoSuchProfessionalDetailsException if a professional details with the primary key could not be found
	 */
	public ProfessionalDetails remove(long professionalDetailsId)
		throws NoSuchProfessionalDetailsException;

	public ProfessionalDetails updateImpl(
		ProfessionalDetails professionalDetails);

	/**
	 * Returns the professional details with the primary key or throws a <code>NoSuchProfessionalDetailsException</code> if it could not be found.
	 *
	 * @param professionalDetailsId the primary key of the professional details
	 * @return the professional details
	 * @throws NoSuchProfessionalDetailsException if a professional details with the primary key could not be found
	 */
	public ProfessionalDetails findByPrimaryKey(long professionalDetailsId)
		throws NoSuchProfessionalDetailsException;

	/**
	 * Returns the professional details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param professionalDetailsId the primary key of the professional details
	 * @return the professional details, or <code>null</code> if a professional details with the primary key could not be found
	 */
	public ProfessionalDetails fetchByPrimaryKey(long professionalDetailsId);

	/**
	 * Returns all the professional detailses.
	 *
	 * @return the professional detailses
	 */
	public java.util.List<ProfessionalDetails> findAll();

	/**
	 * Returns a range of all the professional detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @return the range of professional detailses
	 */
	public java.util.List<ProfessionalDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the professional detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of professional detailses
	 */
	public java.util.List<ProfessionalDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the professional detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of professional detailses
	 */
	public java.util.List<ProfessionalDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfessionalDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the professional detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of professional detailses.
	 *
	 * @return the number of professional detailses
	 */
	public int countAll();

}