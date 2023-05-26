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

package com.intranet.service.persistence.impl;

import com.intranet.exception.NoSuchEmployeeDetailsException;
import com.intranet.model.EmployeeDetails;
import com.intranet.model.EmployeeDetailsTable;
import com.intranet.model.impl.EmployeeDetailsImpl;
import com.intranet.model.impl.EmployeeDetailsModelImpl;
import com.intranet.service.persistence.EmployeeDetailsPersistence;
import com.intranet.service.persistence.EmployeeDetailsUtil;
import com.intranet.service.persistence.impl.constants.INTRANETPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {EmployeeDetailsPersistence.class, BasePersistence.class})
public class EmployeeDetailsPersistenceImpl
	extends BasePersistenceImpl<EmployeeDetails>
	implements EmployeeDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeDetailsUtil</code> to access the employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByemployeeID;
	private FinderPath _finderPathWithoutPaginationFindByemployeeID;
	private FinderPath _finderPathCountByemployeeID;

	/**
	 * Returns all the employee detailses where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @return the matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByemployeeID(long employeeID) {
		return findByemployeeID(
			employeeID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses where employeeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeID the employee ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByemployeeID(
		long employeeID, int start, int end) {

		return findByemployeeID(employeeID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses where employeeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeID the employee ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByemployeeID(
		long employeeID, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return findByemployeeID(
			employeeID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses where employeeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeID the employee ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByemployeeID(
		long employeeID, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByemployeeID;
				finderArgs = new Object[] {employeeID};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByemployeeID;
			finderArgs = new Object[] {
				employeeID, start, end, orderByComparator
			};
		}

		List<EmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetails employeeDetails : list) {
					if (employeeID != employeeDetails.getEmployeeID()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeID);

				list = (List<EmployeeDetails>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByemployeeID_First(
			long employeeID,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByemployeeID_First(
			employeeID, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeID=");
		sb.append(employeeID);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByemployeeID_First(
		long employeeID, OrderByComparator<EmployeeDetails> orderByComparator) {

		List<EmployeeDetails> list = findByemployeeID(
			employeeID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByemployeeID_Last(
			long employeeID,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByemployeeID_Last(
			employeeID, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeID=");
		sb.append(employeeID);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByemployeeID_Last(
		long employeeID, OrderByComparator<EmployeeDetails> orderByComparator) {

		int count = countByemployeeID(employeeID);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetails> list = findByemployeeID(
			employeeID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the employee detailses where employeeID = &#63; from the database.
	 *
	 * @param employeeID the employee ID
	 */
	@Override
	public void removeByemployeeID(long employeeID) {
		for (EmployeeDetails employeeDetails :
				findByemployeeID(
					employeeID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByemployeeID(long employeeID) {
		FinderPath finderPath = _finderPathCountByemployeeID;

		Object[] finderArgs = new Object[] {employeeID};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeID);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 =
		"employeeDetails.employeeID = ?";

	private FinderPath _finderPathWithPaginationFindByemployeename;
	private FinderPath _finderPathWithoutPaginationFindByemployeename;
	private FinderPath _finderPathCountByemployeename;

	/**
	 * Returns all the employee detailses where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @return the matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByemployeename(String employeename) {
		return findByemployeename(
			employeename, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses where employeename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeename the employeename
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByemployeename(
		String employeename, int start, int end) {

		return findByemployeename(employeename, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses where employeename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeename the employeename
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByemployeename(
		String employeename, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return findByemployeename(
			employeename, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses where employeename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeename the employeename
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	@Override
	public List<EmployeeDetails> findByemployeename(
		String employeename, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		employeename = Objects.toString(employeename, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByemployeename;
				finderArgs = new Object[] {employeename};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByemployeename;
			finderArgs = new Object[] {
				employeename, start, end, orderByComparator
			};
		}

		List<EmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetails employeeDetails : list) {
					if (!employeename.equals(
							employeeDetails.getEmployeename())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

			boolean bindEmployeename = false;

			if (employeename.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3);
			}
			else {
				bindEmployeename = true;

				sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmployeename) {
					queryPos.add(employeename);
				}

				list = (List<EmployeeDetails>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByemployeename_First(
			String employeename,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByemployeename_First(
			employeename, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeename=");
		sb.append(employeename);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the first employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByemployeename_First(
		String employeename,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		List<EmployeeDetails> list = findByemployeename(
			employeename, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails findByemployeename_Last(
			String employeename,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByemployeename_Last(
			employeename, orderByComparator);

		if (employeeDetails != null) {
			return employeeDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeename=");
		sb.append(employeename);

		sb.append("}");

		throw new NoSuchEmployeeDetailsException(sb.toString());
	}

	/**
	 * Returns the last employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	@Override
	public EmployeeDetails fetchByemployeename_Last(
		String employeename,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		int count = countByemployeename(employeename);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetails> list = findByemployeename(
			employeename, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeeID the primary key of the current employee details
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails[] findByemployeename_PrevAndNext(
			long employeeID, String employeename,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws NoSuchEmployeeDetailsException {

		employeename = Objects.toString(employeename, "");

		EmployeeDetails employeeDetails = findByPrimaryKey(employeeID);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetails[] array = new EmployeeDetailsImpl[3];

			array[0] = getByemployeename_PrevAndNext(
				session, employeeDetails, employeename, orderByComparator,
				true);

			array[1] = employeeDetails;

			array[2] = getByemployeename_PrevAndNext(
				session, employeeDetails, employeename, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDetails getByemployeename_PrevAndNext(
		Session session, EmployeeDetails employeeDetails, String employeename,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEEDETAILS_WHERE);

		boolean bindEmployeename = false;

		if (employeename.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3);
		}
		else {
			bindEmployeename = true;

			sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmployeename) {
			queryPos.add(employeename);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						employeeDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmployeeDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee detailses where employeename = &#63; from the database.
	 *
	 * @param employeename the employeename
	 */
	@Override
	public void removeByemployeename(String employeename) {
		for (EmployeeDetails employeeDetails :
				findByemployeename(
					employeename, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @return the number of matching employee detailses
	 */
	@Override
	public int countByemployeename(String employeename) {
		employeename = Objects.toString(employeename, "");

		FinderPath finderPath = _finderPathCountByemployeename;

		Object[] finderArgs = new Object[] {employeename};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEEDETAILS_WHERE);

			boolean bindEmployeename = false;

			if (employeename.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3);
			}
			else {
				bindEmployeename = true;

				sb.append(_FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmployeename) {
					queryPos.add(employeename);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_2 =
		"employeeDetails.employeename = ?";

	private static final String _FINDER_COLUMN_EMPLOYEENAME_EMPLOYEENAME_3 =
		"(employeeDetails.employeename IS NULL OR employeeDetails.employeename = '')";

	public EmployeeDetailsPersistenceImpl() {
		setModelClass(EmployeeDetails.class);

		setModelImplClass(EmployeeDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(EmployeeDetailsTable.INSTANCE);
	}

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	@Override
	public void cacheResult(EmployeeDetails employeeDetails) {
		entityCache.putResult(
			EmployeeDetailsImpl.class, employeeDetails.getPrimaryKey(),
			employeeDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employee detailses in the entity cache if it is enabled.
	 *
	 * @param employeeDetailses the employee detailses
	 */
	@Override
	public void cacheResult(List<EmployeeDetails> employeeDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employeeDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmployeeDetails employeeDetails : employeeDetailses) {
			if (entityCache.getResult(
					EmployeeDetailsImpl.class,
					employeeDetails.getPrimaryKey()) == null) {

				cacheResult(employeeDetails);
			}
		}
	}

	/**
	 * Clears the cache for all employee detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDetailsImpl.class);

		finderCache.clearCache(EmployeeDetailsImpl.class);
	}

	/**
	 * Clears the cache for the employee details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDetails employeeDetails) {
		entityCache.removeResult(EmployeeDetailsImpl.class, employeeDetails);
	}

	@Override
	public void clearCache(List<EmployeeDetails> employeeDetailses) {
		for (EmployeeDetails employeeDetails : employeeDetailses) {
			entityCache.removeResult(
				EmployeeDetailsImpl.class, employeeDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmployeeDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param employeeID the primary key for the new employee details
	 * @return the new employee details
	 */
	@Override
	public EmployeeDetails create(long employeeID) {
		EmployeeDetails employeeDetails = new EmployeeDetailsImpl();

		employeeDetails.setNew(true);
		employeeDetails.setPrimaryKey(employeeID);

		return employeeDetails;
	}

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails remove(long employeeID)
		throws NoSuchEmployeeDetailsException {

		return remove((Serializable)employeeID);
	}

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails remove(Serializable primaryKey)
		throws NoSuchEmployeeDetailsException {

		Session session = null;

		try {
			session = openSession();

			EmployeeDetails employeeDetails = (EmployeeDetails)session.get(
				EmployeeDetailsImpl.class, primaryKey);

			if (employeeDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employeeDetails);
		}
		catch (NoSuchEmployeeDetailsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmployeeDetails removeImpl(EmployeeDetails employeeDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDetails)) {
				employeeDetails = (EmployeeDetails)session.get(
					EmployeeDetailsImpl.class,
					employeeDetails.getPrimaryKeyObj());
			}

			if (employeeDetails != null) {
				session.delete(employeeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employeeDetails != null) {
			clearCache(employeeDetails);
		}

		return employeeDetails;
	}

	@Override
	public EmployeeDetails updateImpl(EmployeeDetails employeeDetails) {
		boolean isNew = employeeDetails.isNew();

		if (!(employeeDetails instanceof EmployeeDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					employeeDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDetails implementation " +
					employeeDetails.getClass());
		}

		EmployeeDetailsModelImpl employeeDetailsModelImpl =
			(EmployeeDetailsModelImpl)employeeDetails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employeeDetails);
			}
			else {
				employeeDetails = (EmployeeDetails)session.merge(
					employeeDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeDetailsImpl.class, employeeDetailsModelImpl, false, true);

		if (isNew) {
			employeeDetails.setNew(false);
		}

		employeeDetails.resetOriginalValues();

		return employeeDetails;
	}

	/**
	 * Returns the employee details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDetailsException {

		EmployeeDetails employeeDetails = fetchByPrimaryKey(primaryKey);

		if (employeeDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employeeDetails;
	}

	/**
	 * Returns the employee details with the primary key or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails findByPrimaryKey(long employeeID)
		throws NoSuchEmployeeDetailsException {

		return findByPrimaryKey((Serializable)employeeID);
	}

	/**
	 * Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	 */
	@Override
	public EmployeeDetails fetchByPrimaryKey(long employeeID) {
		return fetchByPrimaryKey((Serializable)employeeID);
	}

	/**
	 * Returns all the employee detailses.
	 *
	 * @return the employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee detailses
	 */
	@Override
	public List<EmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<EmployeeDetails> list = null;

		if (useFinderCache) {
			list = (List<EmployeeDetails>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEEDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDETAILS;

				sql = sql.concat(EmployeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmployeeDetails>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the employee detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDetails employeeDetails : findAll()) {
			remove(employeeDetails);
		}
	}

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEEDETAILS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "employeeID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEEDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee details persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByemployeeID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeID",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeID"}, true);

		_finderPathWithoutPaginationFindByemployeeID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeID",
			new String[] {Long.class.getName()}, new String[] {"employeeID"},
			true);

		_finderPathCountByemployeeID = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeID",
			new String[] {Long.class.getName()}, new String[] {"employeeID"},
			false);

		_finderPathWithPaginationFindByemployeename = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeename",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeename"}, true);

		_finderPathWithoutPaginationFindByemployeename = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeename",
			new String[] {String.class.getName()},
			new String[] {"employeename"}, true);

		_finderPathCountByemployeename = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeename",
			new String[] {String.class.getName()},
			new String[] {"employeename"}, false);

		_setEmployeeDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEmployeeDetailsUtilPersistence(null);

		entityCache.removeCache(EmployeeDetailsImpl.class.getName());
	}

	private void _setEmployeeDetailsUtilPersistence(
		EmployeeDetailsPersistence employeeDetailsPersistence) {

		try {
			Field field = EmployeeDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, employeeDetailsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMPLOYEEDETAILS =
		"SELECT employeeDetails FROM EmployeeDetails employeeDetails";

	private static final String _SQL_SELECT_EMPLOYEEDETAILS_WHERE =
		"SELECT employeeDetails FROM EmployeeDetails employeeDetails WHERE ";

	private static final String _SQL_COUNT_EMPLOYEEDETAILS =
		"SELECT COUNT(employeeDetails) FROM EmployeeDetails employeeDetails";

	private static final String _SQL_COUNT_EMPLOYEEDETAILS_WHERE =
		"SELECT COUNT(employeeDetails) FROM EmployeeDetails employeeDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmployeeDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmployeeDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeDetailsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private EmployeeDetailsModelArgumentsResolver
		_employeeDetailsModelArgumentsResolver;

}