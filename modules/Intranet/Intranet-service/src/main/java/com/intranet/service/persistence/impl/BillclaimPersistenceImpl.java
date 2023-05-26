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

import com.intranet.exception.NoSuchBillclaimException;
import com.intranet.model.Billclaim;
import com.intranet.model.BillclaimTable;
import com.intranet.model.impl.BillclaimImpl;
import com.intranet.model.impl.BillclaimModelImpl;
import com.intranet.service.persistence.BillclaimPersistence;
import com.intranet.service.persistence.BillclaimUtil;
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
 * The persistence implementation for the billclaim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {BillclaimPersistence.class, BasePersistence.class})
public class BillclaimPersistenceImpl
	extends BasePersistenceImpl<Billclaim> implements BillclaimPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BillclaimUtil</code> to access the billclaim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BillclaimImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByuserName;
	private FinderPath _finderPathWithoutPaginationFindByuserName;
	private FinderPath _finderPathCountByuserName;

	/**
	 * Returns all the billclaims where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching billclaims
	 */
	@Override
	public List<Billclaim> findByuserName(String userName) {
		return findByuserName(
			userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the billclaims where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @return the range of matching billclaims
	 */
	@Override
	public List<Billclaim> findByuserName(String userName, int start, int end) {
		return findByuserName(userName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the billclaims where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching billclaims
	 */
	@Override
	public List<Billclaim> findByuserName(
		String userName, int start, int end,
		OrderByComparator<Billclaim> orderByComparator) {

		return findByuserName(userName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billclaims where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching billclaims
	 */
	@Override
	public List<Billclaim> findByuserName(
		String userName, int start, int end,
		OrderByComparator<Billclaim> orderByComparator,
		boolean useFinderCache) {

		userName = Objects.toString(userName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserName;
				finderArgs = new Object[] {userName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserName;
			finderArgs = new Object[] {userName, start, end, orderByComparator};
		}

		List<Billclaim> list = null;

		if (useFinderCache) {
			list = (List<Billclaim>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Billclaim billclaim : list) {
					if (!userName.equals(billclaim.getUserName())) {
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

			sb.append(_SQL_SELECT_BILLCLAIM_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BillclaimModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
				}

				list = (List<Billclaim>)QueryUtil.list(
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
	 * Returns the first billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billclaim
	 * @throws NoSuchBillclaimException if a matching billclaim could not be found
	 */
	@Override
	public Billclaim findByuserName_First(
			String userName, OrderByComparator<Billclaim> orderByComparator)
		throws NoSuchBillclaimException {

		Billclaim billclaim = fetchByuserName_First(
			userName, orderByComparator);

		if (billclaim != null) {
			return billclaim;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userName=");
		sb.append(userName);

		sb.append("}");

		throw new NoSuchBillclaimException(sb.toString());
	}

	/**
	 * Returns the first billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billclaim, or <code>null</code> if a matching billclaim could not be found
	 */
	@Override
	public Billclaim fetchByuserName_First(
		String userName, OrderByComparator<Billclaim> orderByComparator) {

		List<Billclaim> list = findByuserName(
			userName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billclaim
	 * @throws NoSuchBillclaimException if a matching billclaim could not be found
	 */
	@Override
	public Billclaim findByuserName_Last(
			String userName, OrderByComparator<Billclaim> orderByComparator)
		throws NoSuchBillclaimException {

		Billclaim billclaim = fetchByuserName_Last(userName, orderByComparator);

		if (billclaim != null) {
			return billclaim;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userName=");
		sb.append(userName);

		sb.append("}");

		throw new NoSuchBillclaimException(sb.toString());
	}

	/**
	 * Returns the last billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billclaim, or <code>null</code> if a matching billclaim could not be found
	 */
	@Override
	public Billclaim fetchByuserName_Last(
		String userName, OrderByComparator<Billclaim> orderByComparator) {

		int count = countByuserName(userName);

		if (count == 0) {
			return null;
		}

		List<Billclaim> list = findByuserName(
			userName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the billclaims before and after the current billclaim in the ordered set where userName = &#63;.
	 *
	 * @param fooId the primary key of the current billclaim
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next billclaim
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	@Override
	public Billclaim[] findByuserName_PrevAndNext(
			long fooId, String userName,
			OrderByComparator<Billclaim> orderByComparator)
		throws NoSuchBillclaimException {

		userName = Objects.toString(userName, "");

		Billclaim billclaim = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			Billclaim[] array = new BillclaimImpl[3];

			array[0] = getByuserName_PrevAndNext(
				session, billclaim, userName, orderByComparator, true);

			array[1] = billclaim;

			array[2] = getByuserName_PrevAndNext(
				session, billclaim, userName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Billclaim getByuserName_PrevAndNext(
		Session session, Billclaim billclaim, String userName,
		OrderByComparator<Billclaim> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BILLCLAIM_WHERE);

		boolean bindUserName = false;

		if (userName.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
		}
		else {
			bindUserName = true;

			sb.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
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
			sb.append(BillclaimModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUserName) {
			queryPos.add(userName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(billclaim)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Billclaim> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the billclaims where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	@Override
	public void removeByuserName(String userName) {
		for (Billclaim billclaim :
				findByuserName(
					userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(billclaim);
		}
	}

	/**
	 * Returns the number of billclaims where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching billclaims
	 */
	@Override
	public int countByuserName(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathCountByuserName;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BILLCLAIM_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
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

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 =
		"billclaim.userName = ?";

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 =
		"(billclaim.userName IS NULL OR billclaim.userName = '')";

	public BillclaimPersistenceImpl() {
		setModelClass(Billclaim.class);

		setModelImplClass(BillclaimImpl.class);
		setModelPKClass(long.class);

		setTable(BillclaimTable.INSTANCE);
	}

	/**
	 * Caches the billclaim in the entity cache if it is enabled.
	 *
	 * @param billclaim the billclaim
	 */
	@Override
	public void cacheResult(Billclaim billclaim) {
		entityCache.putResult(
			BillclaimImpl.class, billclaim.getPrimaryKey(), billclaim);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the billclaims in the entity cache if it is enabled.
	 *
	 * @param billclaims the billclaims
	 */
	@Override
	public void cacheResult(List<Billclaim> billclaims) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (billclaims.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Billclaim billclaim : billclaims) {
			if (entityCache.getResult(
					BillclaimImpl.class, billclaim.getPrimaryKey()) == null) {

				cacheResult(billclaim);
			}
		}
	}

	/**
	 * Clears the cache for all billclaims.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BillclaimImpl.class);

		finderCache.clearCache(BillclaimImpl.class);
	}

	/**
	 * Clears the cache for the billclaim.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Billclaim billclaim) {
		entityCache.removeResult(BillclaimImpl.class, billclaim);
	}

	@Override
	public void clearCache(List<Billclaim> billclaims) {
		for (Billclaim billclaim : billclaims) {
			entityCache.removeResult(BillclaimImpl.class, billclaim);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BillclaimImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BillclaimImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new billclaim with the primary key. Does not add the billclaim to the database.
	 *
	 * @param fooId the primary key for the new billclaim
	 * @return the new billclaim
	 */
	@Override
	public Billclaim create(long fooId) {
		Billclaim billclaim = new BillclaimImpl();

		billclaim.setNew(true);
		billclaim.setPrimaryKey(fooId);

		return billclaim;
	}

	/**
	 * Removes the billclaim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the billclaim
	 * @return the billclaim that was removed
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	@Override
	public Billclaim remove(long fooId) throws NoSuchBillclaimException {
		return remove((Serializable)fooId);
	}

	/**
	 * Removes the billclaim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the billclaim
	 * @return the billclaim that was removed
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	@Override
	public Billclaim remove(Serializable primaryKey)
		throws NoSuchBillclaimException {

		Session session = null;

		try {
			session = openSession();

			Billclaim billclaim = (Billclaim)session.get(
				BillclaimImpl.class, primaryKey);

			if (billclaim == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBillclaimException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(billclaim);
		}
		catch (NoSuchBillclaimException noSuchEntityException) {
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
	protected Billclaim removeImpl(Billclaim billclaim) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(billclaim)) {
				billclaim = (Billclaim)session.get(
					BillclaimImpl.class, billclaim.getPrimaryKeyObj());
			}

			if (billclaim != null) {
				session.delete(billclaim);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (billclaim != null) {
			clearCache(billclaim);
		}

		return billclaim;
	}

	@Override
	public Billclaim updateImpl(Billclaim billclaim) {
		boolean isNew = billclaim.isNew();

		if (!(billclaim instanceof BillclaimModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(billclaim.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(billclaim);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in billclaim proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Billclaim implementation " +
					billclaim.getClass());
		}

		BillclaimModelImpl billclaimModelImpl = (BillclaimModelImpl)billclaim;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(billclaim);
			}
			else {
				billclaim = (Billclaim)session.merge(billclaim);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BillclaimImpl.class, billclaimModelImpl, false, true);

		if (isNew) {
			billclaim.setNew(false);
		}

		billclaim.resetOriginalValues();

		return billclaim;
	}

	/**
	 * Returns the billclaim with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the billclaim
	 * @return the billclaim
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	@Override
	public Billclaim findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBillclaimException {

		Billclaim billclaim = fetchByPrimaryKey(primaryKey);

		if (billclaim == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBillclaimException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return billclaim;
	}

	/**
	 * Returns the billclaim with the primary key or throws a <code>NoSuchBillclaimException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the billclaim
	 * @return the billclaim
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	@Override
	public Billclaim findByPrimaryKey(long fooId)
		throws NoSuchBillclaimException {

		return findByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns the billclaim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the billclaim
	 * @return the billclaim, or <code>null</code> if a billclaim with the primary key could not be found
	 */
	@Override
	public Billclaim fetchByPrimaryKey(long fooId) {
		return fetchByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns all the billclaims.
	 *
	 * @return the billclaims
	 */
	@Override
	public List<Billclaim> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the billclaims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @return the range of billclaims
	 */
	@Override
	public List<Billclaim> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the billclaims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of billclaims
	 */
	@Override
	public List<Billclaim> findAll(
		int start, int end, OrderByComparator<Billclaim> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billclaims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of billclaims
	 */
	@Override
	public List<Billclaim> findAll(
		int start, int end, OrderByComparator<Billclaim> orderByComparator,
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

		List<Billclaim> list = null;

		if (useFinderCache) {
			list = (List<Billclaim>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BILLCLAIM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BILLCLAIM;

				sql = sql.concat(BillclaimModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Billclaim>)QueryUtil.list(
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
	 * Removes all the billclaims from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Billclaim billclaim : findAll()) {
			remove(billclaim);
		}
	}

	/**
	 * Returns the number of billclaims.
	 *
	 * @return the number of billclaims
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BILLCLAIM);

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
		return "fooId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BILLCLAIM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BillclaimModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the billclaim persistence.
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

		_finderPathWithPaginationFindByuserName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userName"}, true);

		_finderPathWithoutPaginationFindByuserName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserName",
			new String[] {String.class.getName()}, new String[] {"userName"},
			true);

		_finderPathCountByuserName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserName",
			new String[] {String.class.getName()}, new String[] {"userName"},
			false);

		_setBillclaimUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBillclaimUtilPersistence(null);

		entityCache.removeCache(BillclaimImpl.class.getName());
	}

	private void _setBillclaimUtilPersistence(
		BillclaimPersistence billclaimPersistence) {

		try {
			Field field = BillclaimUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, billclaimPersistence);
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

	private static final String _SQL_SELECT_BILLCLAIM =
		"SELECT billclaim FROM Billclaim billclaim";

	private static final String _SQL_SELECT_BILLCLAIM_WHERE =
		"SELECT billclaim FROM Billclaim billclaim WHERE ";

	private static final String _SQL_COUNT_BILLCLAIM =
		"SELECT COUNT(billclaim) FROM Billclaim billclaim";

	private static final String _SQL_COUNT_BILLCLAIM_WHERE =
		"SELECT COUNT(billclaim) FROM Billclaim billclaim WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "billclaim.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Billclaim exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Billclaim exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BillclaimPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private BillclaimModelArgumentsResolver _billclaimModelArgumentsResolver;

}