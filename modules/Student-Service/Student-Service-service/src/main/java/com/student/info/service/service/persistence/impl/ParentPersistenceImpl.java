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

package com.student.info.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.student.info.service.exception.NoSuchParentException;
import com.student.info.service.model.Parent;
import com.student.info.service.model.ParentTable;
import com.student.info.service.model.Student;
import com.student.info.service.model.impl.ParentImpl;
import com.student.info.service.model.impl.ParentModelImpl;
import com.student.info.service.service.persistence.ParentPersistence;
import com.student.info.service.service.persistence.ParentUtil;
import com.student.info.service.service.persistence.impl.constants.STPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the parent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ParentPersistence.class)
public class ParentPersistenceImpl
	extends BasePersistenceImpl<Parent> implements ParentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ParentUtil</code> to access the parent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ParentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ParentPersistenceImpl() {
		setModelClass(Parent.class);

		setModelImplClass(ParentImpl.class);
		setModelPKClass(long.class);

		setTable(ParentTable.INSTANCE);
	}

	/**
	 * Caches the parent in the entity cache if it is enabled.
	 *
	 * @param parent the parent
	 */
	@Override
	public void cacheResult(Parent parent) {
		entityCache.putResult(ParentImpl.class, parent.getPrimaryKey(), parent);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the parents in the entity cache if it is enabled.
	 *
	 * @param parents the parents
	 */
	@Override
	public void cacheResult(List<Parent> parents) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (parents.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Parent parent : parents) {
			if (entityCache.getResult(
					ParentImpl.class, parent.getPrimaryKey()) == null) {

				cacheResult(parent);
			}
		}
	}

	/**
	 * Clears the cache for all parents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ParentImpl.class);

		finderCache.clearCache(ParentImpl.class);
	}

	/**
	 * Clears the cache for the parent.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Parent parent) {
		entityCache.removeResult(ParentImpl.class, parent);
	}

	@Override
	public void clearCache(List<Parent> parents) {
		for (Parent parent : parents) {
			entityCache.removeResult(ParentImpl.class, parent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ParentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ParentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new parent with the primary key. Does not add the parent to the database.
	 *
	 * @param parentId the primary key for the new parent
	 * @return the new parent
	 */
	@Override
	public Parent create(long parentId) {
		Parent parent = new ParentImpl();

		parent.setNew(true);
		parent.setPrimaryKey(parentId);

		parent.setCompanyId(CompanyThreadLocal.getCompanyId());

		return parent;
	}

	/**
	 * Removes the parent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent that was removed
	 * @throws NoSuchParentException if a parent with the primary key could not be found
	 */
	@Override
	public Parent remove(long parentId) throws NoSuchParentException {
		return remove((Serializable)parentId);
	}

	/**
	 * Removes the parent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parent
	 * @return the parent that was removed
	 * @throws NoSuchParentException if a parent with the primary key could not be found
	 */
	@Override
	public Parent remove(Serializable primaryKey) throws NoSuchParentException {
		Session session = null;

		try {
			session = openSession();

			Parent parent = (Parent)session.get(ParentImpl.class, primaryKey);

			if (parent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(parent);
		}
		catch (NoSuchParentException noSuchEntityException) {
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
	protected Parent removeImpl(Parent parent) {
		parentToStudentTableMapper.deleteLeftPrimaryKeyTableMappings(
			parent.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(parent)) {
				parent = (Parent)session.get(
					ParentImpl.class, parent.getPrimaryKeyObj());
			}

			if (parent != null) {
				session.delete(parent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (parent != null) {
			clearCache(parent);
		}

		return parent;
	}

	@Override
	public Parent updateImpl(Parent parent) {
		boolean isNew = parent.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(parent);
			}
			else {
				parent = (Parent)session.merge(parent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ParentImpl.class, parent, false, true);

		if (isNew) {
			parent.setNew(false);
		}

		parent.resetOriginalValues();

		return parent;
	}

	/**
	 * Returns the parent with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parent
	 * @return the parent
	 * @throws NoSuchParentException if a parent with the primary key could not be found
	 */
	@Override
	public Parent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchParentException {

		Parent parent = fetchByPrimaryKey(primaryKey);

		if (parent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return parent;
	}

	/**
	 * Returns the parent with the primary key or throws a <code>NoSuchParentException</code> if it could not be found.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent
	 * @throws NoSuchParentException if a parent with the primary key could not be found
	 */
	@Override
	public Parent findByPrimaryKey(long parentId) throws NoSuchParentException {
		return findByPrimaryKey((Serializable)parentId);
	}

	/**
	 * Returns the parent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent, or <code>null</code> if a parent with the primary key could not be found
	 */
	@Override
	public Parent fetchByPrimaryKey(long parentId) {
		return fetchByPrimaryKey((Serializable)parentId);
	}

	/**
	 * Returns all the parents.
	 *
	 * @return the parents
	 */
	@Override
	public List<Parent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @return the range of parents
	 */
	@Override
	public List<Parent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parents
	 */
	@Override
	public List<Parent> findAll(
		int start, int end, OrderByComparator<Parent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parents
	 */
	@Override
	public List<Parent> findAll(
		int start, int end, OrderByComparator<Parent> orderByComparator,
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

		List<Parent> list = null;

		if (useFinderCache) {
			list = (List<Parent>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PARENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PARENT;

				sql = sql.concat(ParentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Parent>)QueryUtil.list(
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
	 * Removes all the parents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Parent parent : findAll()) {
			remove(parent);
		}
	}

	/**
	 * Returns the number of parents.
	 *
	 * @return the number of parents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PARENT);

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

	/**
	 * Returns the primaryKeys of students associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @return long[] of the primaryKeys of students associated with the parent
	 */
	@Override
	public long[] getStudentPrimaryKeys(long pk) {
		long[] pks = parentToStudentTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the parent associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the parents associated with the student
	 */
	@Override
	public List<Parent> getStudentParents(long pk) {
		return getStudentParents(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the parent associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of parents associated with the student
	 */
	@Override
	public List<Parent> getStudentParents(long pk, int start, int end) {
		return getStudentParents(pk, start, end, null);
	}

	/**
	 * Returns all the parent associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parents associated with the student
	 */
	@Override
	public List<Parent> getStudentParents(
		long pk, int start, int end,
		OrderByComparator<Parent> orderByComparator) {

		return parentToStudentTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of students associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @return the number of students associated with the parent
	 */
	@Override
	public int getStudentsSize(long pk) {
		long[] pks = parentToStudentTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the student is associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPK the primary key of the student
	 * @return <code>true</code> if the student is associated with the parent; <code>false</code> otherwise
	 */
	@Override
	public boolean containsStudent(long pk, long studentPK) {
		return parentToStudentTableMapper.containsTableMapping(pk, studentPK);
	}

	/**
	 * Returns <code>true</code> if the parent has any students associated with it.
	 *
	 * @param pk the primary key of the parent to check for associations with students
	 * @return <code>true</code> if the parent has any students associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsStudents(long pk) {
		if (getStudentsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPK the primary key of the student
	 */
	@Override
	public void addStudent(long pk, long studentPK) {
		Parent parent = fetchByPrimaryKey(pk);

		if (parent == null) {
			parentToStudentTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, studentPK);
		}
		else {
			parentToStudentTableMapper.addTableMapping(
				parent.getCompanyId(), pk, studentPK);
		}
	}

	/**
	 * Adds an association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param student the student
	 */
	@Override
	public void addStudent(long pk, Student student) {
		Parent parent = fetchByPrimaryKey(pk);

		if (parent == null) {
			parentToStudentTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, student.getPrimaryKey());
		}
		else {
			parentToStudentTableMapper.addTableMapping(
				parent.getCompanyId(), pk, student.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPKs the primary keys of the students
	 */
	@Override
	public void addStudents(long pk, long[] studentPKs) {
		long companyId = 0;

		Parent parent = fetchByPrimaryKey(pk);

		if (parent == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = parent.getCompanyId();
		}

		parentToStudentTableMapper.addTableMappings(companyId, pk, studentPKs);
	}

	/**
	 * Adds an association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param students the students
	 */
	@Override
	public void addStudents(long pk, List<Student> students) {
		addStudents(
			pk, ListUtil.toLongArray(students, Student.STUDENT_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the parent and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent to clear the associated students from
	 */
	@Override
	public void clearStudents(long pk) {
		parentToStudentTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPK the primary key of the student
	 */
	@Override
	public void removeStudent(long pk, long studentPK) {
		parentToStudentTableMapper.deleteTableMapping(pk, studentPK);
	}

	/**
	 * Removes the association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param student the student
	 */
	@Override
	public void removeStudent(long pk, Student student) {
		parentToStudentTableMapper.deleteTableMapping(
			pk, student.getPrimaryKey());
	}

	/**
	 * Removes the association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPKs the primary keys of the students
	 */
	@Override
	public void removeStudents(long pk, long[] studentPKs) {
		parentToStudentTableMapper.deleteTableMappings(pk, studentPKs);
	}

	/**
	 * Removes the association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param students the students
	 */
	@Override
	public void removeStudents(long pk, List<Student> students) {
		removeStudents(
			pk, ListUtil.toLongArray(students, Student.STUDENT_ID_ACCESSOR));
	}

	/**
	 * Sets the students associated with the parent, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPKs the primary keys of the students to be associated with the parent
	 */
	@Override
	public void setStudents(long pk, long[] studentPKs) {
		Set<Long> newStudentPKsSet = SetUtil.fromArray(studentPKs);
		Set<Long> oldStudentPKsSet = SetUtil.fromArray(
			parentToStudentTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeStudentPKsSet = new HashSet<Long>(oldStudentPKsSet);

		removeStudentPKsSet.removeAll(newStudentPKsSet);

		parentToStudentTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeStudentPKsSet));

		newStudentPKsSet.removeAll(oldStudentPKsSet);

		long companyId = 0;

		Parent parent = fetchByPrimaryKey(pk);

		if (parent == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = parent.getCompanyId();
		}

		parentToStudentTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newStudentPKsSet));
	}

	/**
	 * Sets the students associated with the parent, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param students the students to be associated with the parent
	 */
	@Override
	public void setStudents(long pk, List<Student> students) {
		try {
			long[] studentPKs = new long[students.size()];

			for (int i = 0; i < students.size(); i++) {
				Student student = students.get(i);

				studentPKs[i] = student.getPrimaryKey();
			}

			setStudents(pk, studentPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "parentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PARENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ParentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the parent persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		parentToStudentTableMapper = TableMapperFactory.getTableMapper(
			"ST_Students_Parents#parentId", "ST_Students_Parents", "companyId",
			"parentId", "studentId", this, Student.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setParentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setParentUtilPersistence(null);

		entityCache.removeCache(ParentImpl.class.getName());

		TableMapperFactory.removeTableMapper("ST_Students_Parents#parentId");
	}

	private void _setParentUtilPersistence(
		ParentPersistence parentPersistence) {

		try {
			Field field = ParentUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, parentPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = STPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = STPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = STPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	protected TableMapper<Parent, Student> parentToStudentTableMapper;

	private static final String _SQL_SELECT_PARENT =
		"SELECT parent FROM Parent parent";

	private static final String _SQL_COUNT_PARENT =
		"SELECT COUNT(parent) FROM Parent parent";

	private static final String _ORDER_BY_ENTITY_ALIAS = "parent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Parent exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ParentPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}