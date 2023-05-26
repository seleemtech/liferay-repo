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

import com.intranet.exception.NoSuchSpecializationException;
import com.intranet.model.Specialization;
import com.intranet.model.SpecializationTable;
import com.intranet.model.impl.SpecializationImpl;
import com.intranet.model.impl.SpecializationModelImpl;
import com.intranet.service.persistence.SpecializationPersistence;
import com.intranet.service.persistence.SpecializationUtil;
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
 * The persistence implementation for the specialization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {SpecializationPersistence.class, BasePersistence.class})
public class SpecializationPersistenceImpl
	extends BasePersistenceImpl<Specialization>
	implements SpecializationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SpecializationUtil</code> to access the specialization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SpecializationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBygraduationCode;
	private FinderPath _finderPathWithoutPaginationFindBygraduationCode;
	private FinderPath _finderPathCountBygraduationCode;

	/**
	 * Returns all the specializations where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @return the matching specializations
	 */
	@Override
	public List<Specialization> findBygraduationCode(String graduationCode) {
		return findBygraduationCode(
			graduationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Specialization> findBygraduationCode(
		String graduationCode, int start, int end) {

		return findBygraduationCode(graduationCode, start, end, null);
	}

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
	@Override
	public List<Specialization> findBygraduationCode(
		String graduationCode, int start, int end,
		OrderByComparator<Specialization> orderByComparator) {

		return findBygraduationCode(
			graduationCode, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Specialization> findBygraduationCode(
		String graduationCode, int start, int end,
		OrderByComparator<Specialization> orderByComparator,
		boolean useFinderCache) {

		graduationCode = Objects.toString(graduationCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBygraduationCode;
				finderArgs = new Object[] {graduationCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBygraduationCode;
			finderArgs = new Object[] {
				graduationCode, start, end, orderByComparator
			};
		}

		List<Specialization> list = null;

		if (useFinderCache) {
			list = (List<Specialization>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Specialization specialization : list) {
					if (!graduationCode.equals(
							specialization.getGraduationCode())) {

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

			sb.append(_SQL_SELECT_SPECIALIZATION_WHERE);

			boolean bindGraduationCode = false;

			if (graduationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_GRADUATIONCODE_GRADUATIONCODE_3);
			}
			else {
				bindGraduationCode = true;

				sb.append(_FINDER_COLUMN_GRADUATIONCODE_GRADUATIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SpecializationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGraduationCode) {
					queryPos.add(graduationCode);
				}

				list = (List<Specialization>)QueryUtil.list(
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
	 * Returns the first specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialization
	 * @throws NoSuchSpecializationException if a matching specialization could not be found
	 */
	@Override
	public Specialization findBygraduationCode_First(
			String graduationCode,
			OrderByComparator<Specialization> orderByComparator)
		throws NoSuchSpecializationException {

		Specialization specialization = fetchBygraduationCode_First(
			graduationCode, orderByComparator);

		if (specialization != null) {
			return specialization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("graduationCode=");
		sb.append(graduationCode);

		sb.append("}");

		throw new NoSuchSpecializationException(sb.toString());
	}

	/**
	 * Returns the first specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialization, or <code>null</code> if a matching specialization could not be found
	 */
	@Override
	public Specialization fetchBygraduationCode_First(
		String graduationCode,
		OrderByComparator<Specialization> orderByComparator) {

		List<Specialization> list = findBygraduationCode(
			graduationCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialization
	 * @throws NoSuchSpecializationException if a matching specialization could not be found
	 */
	@Override
	public Specialization findBygraduationCode_Last(
			String graduationCode,
			OrderByComparator<Specialization> orderByComparator)
		throws NoSuchSpecializationException {

		Specialization specialization = fetchBygraduationCode_Last(
			graduationCode, orderByComparator);

		if (specialization != null) {
			return specialization;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("graduationCode=");
		sb.append(graduationCode);

		sb.append("}");

		throw new NoSuchSpecializationException(sb.toString());
	}

	/**
	 * Returns the last specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialization, or <code>null</code> if a matching specialization could not be found
	 */
	@Override
	public Specialization fetchBygraduationCode_Last(
		String graduationCode,
		OrderByComparator<Specialization> orderByComparator) {

		int count = countBygraduationCode(graduationCode);

		if (count == 0) {
			return null;
		}

		List<Specialization> list = findBygraduationCode(
			graduationCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the specializations before and after the current specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param spCode the primary key of the current specialization
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specialization
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	@Override
	public Specialization[] findBygraduationCode_PrevAndNext(
			long spCode, String graduationCode,
			OrderByComparator<Specialization> orderByComparator)
		throws NoSuchSpecializationException {

		graduationCode = Objects.toString(graduationCode, "");

		Specialization specialization = findByPrimaryKey(spCode);

		Session session = null;

		try {
			session = openSession();

			Specialization[] array = new SpecializationImpl[3];

			array[0] = getBygraduationCode_PrevAndNext(
				session, specialization, graduationCode, orderByComparator,
				true);

			array[1] = specialization;

			array[2] = getBygraduationCode_PrevAndNext(
				session, specialization, graduationCode, orderByComparator,
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

	protected Specialization getBygraduationCode_PrevAndNext(
		Session session, Specialization specialization, String graduationCode,
		OrderByComparator<Specialization> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SPECIALIZATION_WHERE);

		boolean bindGraduationCode = false;

		if (graduationCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_GRADUATIONCODE_GRADUATIONCODE_3);
		}
		else {
			bindGraduationCode = true;

			sb.append(_FINDER_COLUMN_GRADUATIONCODE_GRADUATIONCODE_2);
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
			sb.append(SpecializationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindGraduationCode) {
			queryPos.add(graduationCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						specialization)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Specialization> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the specializations where graduationCode = &#63; from the database.
	 *
	 * @param graduationCode the graduation code
	 */
	@Override
	public void removeBygraduationCode(String graduationCode) {
		for (Specialization specialization :
				findBygraduationCode(
					graduationCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(specialization);
		}
	}

	/**
	 * Returns the number of specializations where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @return the number of matching specializations
	 */
	@Override
	public int countBygraduationCode(String graduationCode) {
		graduationCode = Objects.toString(graduationCode, "");

		FinderPath finderPath = _finderPathCountBygraduationCode;

		Object[] finderArgs = new Object[] {graduationCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPECIALIZATION_WHERE);

			boolean bindGraduationCode = false;

			if (graduationCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_GRADUATIONCODE_GRADUATIONCODE_3);
			}
			else {
				bindGraduationCode = true;

				sb.append(_FINDER_COLUMN_GRADUATIONCODE_GRADUATIONCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGraduationCode) {
					queryPos.add(graduationCode);
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

	private static final String _FINDER_COLUMN_GRADUATIONCODE_GRADUATIONCODE_2 =
		"specialization.graduationCode = ?";

	private static final String _FINDER_COLUMN_GRADUATIONCODE_GRADUATIONCODE_3 =
		"(specialization.graduationCode IS NULL OR specialization.graduationCode = '')";

	public SpecializationPersistenceImpl() {
		setModelClass(Specialization.class);

		setModelImplClass(SpecializationImpl.class);
		setModelPKClass(long.class);

		setTable(SpecializationTable.INSTANCE);
	}

	/**
	 * Caches the specialization in the entity cache if it is enabled.
	 *
	 * @param specialization the specialization
	 */
	@Override
	public void cacheResult(Specialization specialization) {
		entityCache.putResult(
			SpecializationImpl.class, specialization.getPrimaryKey(),
			specialization);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the specializations in the entity cache if it is enabled.
	 *
	 * @param specializations the specializations
	 */
	@Override
	public void cacheResult(List<Specialization> specializations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (specializations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Specialization specialization : specializations) {
			if (entityCache.getResult(
					SpecializationImpl.class, specialization.getPrimaryKey()) ==
						null) {

				cacheResult(specialization);
			}
		}
	}

	/**
	 * Clears the cache for all specializations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SpecializationImpl.class);

		finderCache.clearCache(SpecializationImpl.class);
	}

	/**
	 * Clears the cache for the specialization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Specialization specialization) {
		entityCache.removeResult(SpecializationImpl.class, specialization);
	}

	@Override
	public void clearCache(List<Specialization> specializations) {
		for (Specialization specialization : specializations) {
			entityCache.removeResult(SpecializationImpl.class, specialization);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SpecializationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SpecializationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new specialization with the primary key. Does not add the specialization to the database.
	 *
	 * @param spCode the primary key for the new specialization
	 * @return the new specialization
	 */
	@Override
	public Specialization create(long spCode) {
		Specialization specialization = new SpecializationImpl();

		specialization.setNew(true);
		specialization.setPrimaryKey(spCode);

		return specialization;
	}

	/**
	 * Removes the specialization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCode the primary key of the specialization
	 * @return the specialization that was removed
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	@Override
	public Specialization remove(long spCode)
		throws NoSuchSpecializationException {

		return remove((Serializable)spCode);
	}

	/**
	 * Removes the specialization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the specialization
	 * @return the specialization that was removed
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	@Override
	public Specialization remove(Serializable primaryKey)
		throws NoSuchSpecializationException {

		Session session = null;

		try {
			session = openSession();

			Specialization specialization = (Specialization)session.get(
				SpecializationImpl.class, primaryKey);

			if (specialization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecializationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(specialization);
		}
		catch (NoSuchSpecializationException noSuchEntityException) {
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
	protected Specialization removeImpl(Specialization specialization) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(specialization)) {
				specialization = (Specialization)session.get(
					SpecializationImpl.class,
					specialization.getPrimaryKeyObj());
			}

			if (specialization != null) {
				session.delete(specialization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (specialization != null) {
			clearCache(specialization);
		}

		return specialization;
	}

	@Override
	public Specialization updateImpl(Specialization specialization) {
		boolean isNew = specialization.isNew();

		if (!(specialization instanceof SpecializationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(specialization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					specialization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in specialization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Specialization implementation " +
					specialization.getClass());
		}

		SpecializationModelImpl specializationModelImpl =
			(SpecializationModelImpl)specialization;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(specialization);
			}
			else {
				specialization = (Specialization)session.merge(specialization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SpecializationImpl.class, specializationModelImpl, false, true);

		if (isNew) {
			specialization.setNew(false);
		}

		specialization.resetOriginalValues();

		return specialization;
	}

	/**
	 * Returns the specialization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the specialization
	 * @return the specialization
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	@Override
	public Specialization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecializationException {

		Specialization specialization = fetchByPrimaryKey(primaryKey);

		if (specialization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecializationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return specialization;
	}

	/**
	 * Returns the specialization with the primary key or throws a <code>NoSuchSpecializationException</code> if it could not be found.
	 *
	 * @param spCode the primary key of the specialization
	 * @return the specialization
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	@Override
	public Specialization findByPrimaryKey(long spCode)
		throws NoSuchSpecializationException {

		return findByPrimaryKey((Serializable)spCode);
	}

	/**
	 * Returns the specialization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCode the primary key of the specialization
	 * @return the specialization, or <code>null</code> if a specialization with the primary key could not be found
	 */
	@Override
	public Specialization fetchByPrimaryKey(long spCode) {
		return fetchByPrimaryKey((Serializable)spCode);
	}

	/**
	 * Returns all the specializations.
	 *
	 * @return the specializations
	 */
	@Override
	public List<Specialization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Specialization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Specialization> findAll(
		int start, int end,
		OrderByComparator<Specialization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Specialization> findAll(
		int start, int end, OrderByComparator<Specialization> orderByComparator,
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

		List<Specialization> list = null;

		if (useFinderCache) {
			list = (List<Specialization>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SPECIALIZATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SPECIALIZATION;

				sql = sql.concat(SpecializationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Specialization>)QueryUtil.list(
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
	 * Removes all the specializations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Specialization specialization : findAll()) {
			remove(specialization);
		}
	}

	/**
	 * Returns the number of specializations.
	 *
	 * @return the number of specializations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SPECIALIZATION);

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
		return "spCode";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SPECIALIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SpecializationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the specialization persistence.
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

		_finderPathWithPaginationFindBygraduationCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygraduationCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"graduationCode"}, true);

		_finderPathWithoutPaginationFindBygraduationCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygraduationCode",
			new String[] {String.class.getName()},
			new String[] {"graduationCode"}, true);

		_finderPathCountBygraduationCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygraduationCode",
			new String[] {String.class.getName()},
			new String[] {"graduationCode"}, false);

		_setSpecializationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSpecializationUtilPersistence(null);

		entityCache.removeCache(SpecializationImpl.class.getName());
	}

	private void _setSpecializationUtilPersistence(
		SpecializationPersistence specializationPersistence) {

		try {
			Field field = SpecializationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, specializationPersistence);
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

	private static final String _SQL_SELECT_SPECIALIZATION =
		"SELECT specialization FROM Specialization specialization";

	private static final String _SQL_SELECT_SPECIALIZATION_WHERE =
		"SELECT specialization FROM Specialization specialization WHERE ";

	private static final String _SQL_COUNT_SPECIALIZATION =
		"SELECT COUNT(specialization) FROM Specialization specialization";

	private static final String _SQL_COUNT_SPECIALIZATION_WHERE =
		"SELECT COUNT(specialization) FROM Specialization specialization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "specialization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Specialization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Specialization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SpecializationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private SpecializationModelArgumentsResolver
		_specializationModelArgumentsResolver;

}