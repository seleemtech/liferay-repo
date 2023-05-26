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

import com.student.info.service.exception.NoSuchStudentException;
import com.student.info.service.model.Course;
import com.student.info.service.model.Parent;
import com.student.info.service.model.Student;
import com.student.info.service.model.StudentTable;
import com.student.info.service.model.Teacher;
import com.student.info.service.model.impl.StudentImpl;
import com.student.info.service.model.impl.StudentModelImpl;
import com.student.info.service.service.persistence.StudentPersistence;
import com.student.info.service.service.persistence.StudentUtil;
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
 * The persistence implementation for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StudentPersistence.class)
public class StudentPersistenceImpl
	extends BasePersistenceImpl<Student> implements StudentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StudentUtil</code> to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StudentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public StudentPersistenceImpl() {
		setModelClass(Student.class);

		setModelImplClass(StudentImpl.class);
		setModelPKClass(long.class);

		setTable(StudentTable.INSTANCE);
	}

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	@Override
	public void cacheResult(Student student) {
		entityCache.putResult(
			StudentImpl.class, student.getPrimaryKey(), student);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	@Override
	public void cacheResult(List<Student> students) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (students.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Student student : students) {
			if (entityCache.getResult(
					StudentImpl.class, student.getPrimaryKey()) == null) {

				cacheResult(student);
			}
		}
	}

	/**
	 * Clears the cache for all students.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StudentImpl.class);

		finderCache.clearCache(StudentImpl.class);
	}

	/**
	 * Clears the cache for the student.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Student student) {
		entityCache.removeResult(StudentImpl.class, student);
	}

	@Override
	public void clearCache(List<Student> students) {
		for (Student student : students) {
			entityCache.removeResult(StudentImpl.class, student);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(StudentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StudentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	@Override
	public Student create(long studentId) {
		Student student = new StudentImpl();

		student.setNew(true);
		student.setPrimaryKey(studentId);

		student.setCompanyId(CompanyThreadLocal.getCompanyId());

		return student;
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student remove(long studentId) throws NoSuchStudentException {
		return remove((Serializable)studentId);
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student remove(Serializable primaryKey)
		throws NoSuchStudentException {

		Session session = null;

		try {
			session = openSession();

			Student student = (Student)session.get(
				StudentImpl.class, primaryKey);

			if (student == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(student);
		}
		catch (NoSuchStudentException noSuchEntityException) {
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
	protected Student removeImpl(Student student) {
		studentToParentTableMapper.deleteLeftPrimaryKeyTableMappings(
			student.getPrimaryKey());

		studentToCourseTableMapper.deleteLeftPrimaryKeyTableMappings(
			student.getPrimaryKey());

		studentToTeacherTableMapper.deleteLeftPrimaryKeyTableMappings(
			student.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(student)) {
				student = (Student)session.get(
					StudentImpl.class, student.getPrimaryKeyObj());
			}

			if (student != null) {
				session.delete(student);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (student != null) {
			clearCache(student);
		}

		return student;
	}

	@Override
	public Student updateImpl(Student student) {
		boolean isNew = student.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(student);
			}
			else {
				student = (Student)session.merge(student);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(StudentImpl.class, student, false, true);

		if (isNew) {
			student.setNew(false);
		}

		student.resetOriginalValues();

		return student;
	}

	/**
	 * Returns the student with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentException {

		Student student = fetchByPrimaryKey(primaryKey);

		if (student == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or throws a <code>NoSuchStudentException</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student findByPrimaryKey(long studentId)
		throws NoSuchStudentException {

		return findByPrimaryKey((Serializable)studentId);
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 */
	@Override
	public Student fetchByPrimaryKey(long studentId) {
		return fetchByPrimaryKey((Serializable)studentId);
	}

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 */
	@Override
	public List<Student> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of students
	 */
	@Override
	public List<Student> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students
	 */
	@Override
	public List<Student> findAll(
		int start, int end, OrderByComparator<Student> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of students
	 */
	@Override
	public List<Student> findAll(
		int start, int end, OrderByComparator<Student> orderByComparator,
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

		List<Student> list = null;

		if (useFinderCache) {
			list = (List<Student>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STUDENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENT;

				sql = sql.concat(StudentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Student>)QueryUtil.list(
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
	 * Removes all the students from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Student student : findAll()) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STUDENT);

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
	 * Returns the primaryKeys of parents associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return long[] of the primaryKeys of parents associated with the student
	 */
	@Override
	public long[] getParentPrimaryKeys(long pk) {
		long[] pks = studentToParentTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the student associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @return the students associated with the parent
	 */
	@Override
	public List<Student> getParentStudents(long pk) {
		return getParentStudents(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the student associated with the parent.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the parent
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @return the range of students associated with the parent
	 */
	@Override
	public List<Student> getParentStudents(long pk, int start, int end) {
		return getParentStudents(pk, start, end, null);
	}

	/**
	 * Returns all the student associated with the parent.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the parent
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students associated with the parent
	 */
	@Override
	public List<Student> getParentStudents(
		long pk, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return studentToParentTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of parents associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the number of parents associated with the student
	 */
	@Override
	public int getParentsSize(long pk) {
		long[] pks = studentToParentTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the parent is associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @param parentPK the primary key of the parent
	 * @return <code>true</code> if the parent is associated with the student; <code>false</code> otherwise
	 */
	@Override
	public boolean containsParent(long pk, long parentPK) {
		return studentToParentTableMapper.containsTableMapping(pk, parentPK);
	}

	/**
	 * Returns <code>true</code> if the student has any parents associated with it.
	 *
	 * @param pk the primary key of the student to check for associations with parents
	 * @return <code>true</code> if the student has any parents associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsParents(long pk) {
		if (getParentsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPK the primary key of the parent
	 */
	@Override
	public void addParent(long pk, long parentPK) {
		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			studentToParentTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, parentPK);
		}
		else {
			studentToParentTableMapper.addTableMapping(
				student.getCompanyId(), pk, parentPK);
		}
	}

	/**
	 * Adds an association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parent the parent
	 */
	@Override
	public void addParent(long pk, Parent parent) {
		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			studentToParentTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, parent.getPrimaryKey());
		}
		else {
			studentToParentTableMapper.addTableMapping(
				student.getCompanyId(), pk, parent.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPKs the primary keys of the parents
	 */
	@Override
	public void addParents(long pk, long[] parentPKs) {
		long companyId = 0;

		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = student.getCompanyId();
		}

		studentToParentTableMapper.addTableMappings(companyId, pk, parentPKs);
	}

	/**
	 * Adds an association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parents the parents
	 */
	@Override
	public void addParents(long pk, List<Parent> parents) {
		addParents(
			pk, ListUtil.toLongArray(parents, Parent.PARENT_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the student and its parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student to clear the associated parents from
	 */
	@Override
	public void clearParents(long pk) {
		studentToParentTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPK the primary key of the parent
	 */
	@Override
	public void removeParent(long pk, long parentPK) {
		studentToParentTableMapper.deleteTableMapping(pk, parentPK);
	}

	/**
	 * Removes the association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parent the parent
	 */
	@Override
	public void removeParent(long pk, Parent parent) {
		studentToParentTableMapper.deleteTableMapping(
			pk, parent.getPrimaryKey());
	}

	/**
	 * Removes the association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPKs the primary keys of the parents
	 */
	@Override
	public void removeParents(long pk, long[] parentPKs) {
		studentToParentTableMapper.deleteTableMappings(pk, parentPKs);
	}

	/**
	 * Removes the association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parents the parents
	 */
	@Override
	public void removeParents(long pk, List<Parent> parents) {
		removeParents(
			pk, ListUtil.toLongArray(parents, Parent.PARENT_ID_ACCESSOR));
	}

	/**
	 * Sets the parents associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPKs the primary keys of the parents to be associated with the student
	 */
	@Override
	public void setParents(long pk, long[] parentPKs) {
		Set<Long> newParentPKsSet = SetUtil.fromArray(parentPKs);
		Set<Long> oldParentPKsSet = SetUtil.fromArray(
			studentToParentTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeParentPKsSet = new HashSet<Long>(oldParentPKsSet);

		removeParentPKsSet.removeAll(newParentPKsSet);

		studentToParentTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeParentPKsSet));

		newParentPKsSet.removeAll(oldParentPKsSet);

		long companyId = 0;

		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = student.getCompanyId();
		}

		studentToParentTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newParentPKsSet));
	}

	/**
	 * Sets the parents associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parents the parents to be associated with the student
	 */
	@Override
	public void setParents(long pk, List<Parent> parents) {
		try {
			long[] parentPKs = new long[parents.size()];

			for (int i = 0; i < parents.size(); i++) {
				Parent parent = parents.get(i);

				parentPKs[i] = parent.getPrimaryKey();
			}

			setParents(pk, parentPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	/**
	 * Returns the primaryKeys of courses associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return long[] of the primaryKeys of courses associated with the student
	 */
	@Override
	public long[] getCoursePrimaryKeys(long pk) {
		long[] pks = studentToCourseTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the student associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the students associated with the course
	 */
	@Override
	public List<Student> getCourseStudents(long pk) {
		return getCourseStudents(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the student associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the course
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of students associated with the course
	 */
	@Override
	public List<Student> getCourseStudents(long pk, int start, int end) {
		return getCourseStudents(pk, start, end, null);
	}

	/**
	 * Returns all the student associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the course
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students associated with the course
	 */
	@Override
	public List<Student> getCourseStudents(
		long pk, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return studentToCourseTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of courses associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the number of courses associated with the student
	 */
	@Override
	public int getCoursesSize(long pk) {
		long[] pks = studentToCourseTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the course is associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @param coursePK the primary key of the course
	 * @return <code>true</code> if the course is associated with the student; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCourse(long pk, long coursePK) {
		return studentToCourseTableMapper.containsTableMapping(pk, coursePK);
	}

	/**
	 * Returns <code>true</code> if the student has any courses associated with it.
	 *
	 * @param pk the primary key of the student to check for associations with courses
	 * @return <code>true</code> if the student has any courses associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCourses(long pk) {
		if (getCoursesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePK the primary key of the course
	 */
	@Override
	public void addCourse(long pk, long coursePK) {
		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			studentToCourseTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, coursePK);
		}
		else {
			studentToCourseTableMapper.addTableMapping(
				student.getCompanyId(), pk, coursePK);
		}
	}

	/**
	 * Adds an association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param course the course
	 */
	@Override
	public void addCourse(long pk, Course course) {
		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			studentToCourseTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, course.getPrimaryKey());
		}
		else {
			studentToCourseTableMapper.addTableMapping(
				student.getCompanyId(), pk, course.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePKs the primary keys of the courses
	 */
	@Override
	public void addCourses(long pk, long[] coursePKs) {
		long companyId = 0;

		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = student.getCompanyId();
		}

		studentToCourseTableMapper.addTableMappings(companyId, pk, coursePKs);
	}

	/**
	 * Adds an association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param courses the courses
	 */
	@Override
	public void addCourses(long pk, List<Course> courses) {
		addCourses(
			pk, ListUtil.toLongArray(courses, Course.COURSE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the student and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student to clear the associated courses from
	 */
	@Override
	public void clearCourses(long pk) {
		studentToCourseTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePK the primary key of the course
	 */
	@Override
	public void removeCourse(long pk, long coursePK) {
		studentToCourseTableMapper.deleteTableMapping(pk, coursePK);
	}

	/**
	 * Removes the association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param course the course
	 */
	@Override
	public void removeCourse(long pk, Course course) {
		studentToCourseTableMapper.deleteTableMapping(
			pk, course.getPrimaryKey());
	}

	/**
	 * Removes the association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePKs the primary keys of the courses
	 */
	@Override
	public void removeCourses(long pk, long[] coursePKs) {
		studentToCourseTableMapper.deleteTableMappings(pk, coursePKs);
	}

	/**
	 * Removes the association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param courses the courses
	 */
	@Override
	public void removeCourses(long pk, List<Course> courses) {
		removeCourses(
			pk, ListUtil.toLongArray(courses, Course.COURSE_ID_ACCESSOR));
	}

	/**
	 * Sets the courses associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePKs the primary keys of the courses to be associated with the student
	 */
	@Override
	public void setCourses(long pk, long[] coursePKs) {
		Set<Long> newCoursePKsSet = SetUtil.fromArray(coursePKs);
		Set<Long> oldCoursePKsSet = SetUtil.fromArray(
			studentToCourseTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeCoursePKsSet = new HashSet<Long>(oldCoursePKsSet);

		removeCoursePKsSet.removeAll(newCoursePKsSet);

		studentToCourseTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeCoursePKsSet));

		newCoursePKsSet.removeAll(oldCoursePKsSet);

		long companyId = 0;

		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = student.getCompanyId();
		}

		studentToCourseTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newCoursePKsSet));
	}

	/**
	 * Sets the courses associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param courses the courses to be associated with the student
	 */
	@Override
	public void setCourses(long pk, List<Course> courses) {
		try {
			long[] coursePKs = new long[courses.size()];

			for (int i = 0; i < courses.size(); i++) {
				Course course = courses.get(i);

				coursePKs[i] = course.getPrimaryKey();
			}

			setCourses(pk, coursePKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	/**
	 * Returns the primaryKeys of teachers associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return long[] of the primaryKeys of teachers associated with the student
	 */
	@Override
	public long[] getTeacherPrimaryKeys(long pk) {
		long[] pks = studentToTeacherTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the student associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the students associated with the teacher
	 */
	@Override
	public List<Student> getTeacherStudents(long pk) {
		return getTeacherStudents(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the student associated with the teacher.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the teacher
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @return the range of students associated with the teacher
	 */
	@Override
	public List<Student> getTeacherStudents(long pk, int start, int end) {
		return getTeacherStudents(pk, start, end, null);
	}

	/**
	 * Returns all the student associated with the teacher.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the teacher
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students associated with the teacher
	 */
	@Override
	public List<Student> getTeacherStudents(
		long pk, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return studentToTeacherTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of teachers associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the number of teachers associated with the student
	 */
	@Override
	public int getTeachersSize(long pk) {
		long[] pks = studentToTeacherTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the teacher is associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPK the primary key of the teacher
	 * @return <code>true</code> if the teacher is associated with the student; <code>false</code> otherwise
	 */
	@Override
	public boolean containsTeacher(long pk, long teacherPK) {
		return studentToTeacherTableMapper.containsTableMapping(pk, teacherPK);
	}

	/**
	 * Returns <code>true</code> if the student has any teachers associated with it.
	 *
	 * @param pk the primary key of the student to check for associations with teachers
	 * @return <code>true</code> if the student has any teachers associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsTeachers(long pk) {
		if (getTeachersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPK the primary key of the teacher
	 */
	@Override
	public void addTeacher(long pk, long teacherPK) {
		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			studentToTeacherTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, teacherPK);
		}
		else {
			studentToTeacherTableMapper.addTableMapping(
				student.getCompanyId(), pk, teacherPK);
		}
	}

	/**
	 * Adds an association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacher the teacher
	 */
	@Override
	public void addTeacher(long pk, Teacher teacher) {
		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			studentToTeacherTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, teacher.getPrimaryKey());
		}
		else {
			studentToTeacherTableMapper.addTableMapping(
				student.getCompanyId(), pk, teacher.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPKs the primary keys of the teachers
	 */
	@Override
	public void addTeachers(long pk, long[] teacherPKs) {
		long companyId = 0;

		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = student.getCompanyId();
		}

		studentToTeacherTableMapper.addTableMappings(companyId, pk, teacherPKs);
	}

	/**
	 * Adds an association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teachers the teachers
	 */
	@Override
	public void addTeachers(long pk, List<Teacher> teachers) {
		addTeachers(
			pk, ListUtil.toLongArray(teachers, Teacher.TEACHER_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the student and its teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student to clear the associated teachers from
	 */
	@Override
	public void clearTeachers(long pk) {
		studentToTeacherTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPK the primary key of the teacher
	 */
	@Override
	public void removeTeacher(long pk, long teacherPK) {
		studentToTeacherTableMapper.deleteTableMapping(pk, teacherPK);
	}

	/**
	 * Removes the association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacher the teacher
	 */
	@Override
	public void removeTeacher(long pk, Teacher teacher) {
		studentToTeacherTableMapper.deleteTableMapping(
			pk, teacher.getPrimaryKey());
	}

	/**
	 * Removes the association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPKs the primary keys of the teachers
	 */
	@Override
	public void removeTeachers(long pk, long[] teacherPKs) {
		studentToTeacherTableMapper.deleteTableMappings(pk, teacherPKs);
	}

	/**
	 * Removes the association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teachers the teachers
	 */
	@Override
	public void removeTeachers(long pk, List<Teacher> teachers) {
		removeTeachers(
			pk, ListUtil.toLongArray(teachers, Teacher.TEACHER_ID_ACCESSOR));
	}

	/**
	 * Sets the teachers associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPKs the primary keys of the teachers to be associated with the student
	 */
	@Override
	public void setTeachers(long pk, long[] teacherPKs) {
		Set<Long> newTeacherPKsSet = SetUtil.fromArray(teacherPKs);
		Set<Long> oldTeacherPKsSet = SetUtil.fromArray(
			studentToTeacherTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeTeacherPKsSet = new HashSet<Long>(oldTeacherPKsSet);

		removeTeacherPKsSet.removeAll(newTeacherPKsSet);

		studentToTeacherTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeTeacherPKsSet));

		newTeacherPKsSet.removeAll(oldTeacherPKsSet);

		long companyId = 0;

		Student student = fetchByPrimaryKey(pk);

		if (student == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = student.getCompanyId();
		}

		studentToTeacherTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newTeacherPKsSet));
	}

	/**
	 * Sets the teachers associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teachers the teachers to be associated with the student
	 */
	@Override
	public void setTeachers(long pk, List<Teacher> teachers) {
		try {
			long[] teacherPKs = new long[teachers.size()];

			for (int i = 0; i < teachers.size(); i++) {
				Teacher teacher = teachers.get(i);

				teacherPKs[i] = teacher.getPrimaryKey();
			}

			setTeachers(pk, teacherPKs);
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
		return "studentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STUDENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StudentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the student persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		studentToParentTableMapper = TableMapperFactory.getTableMapper(
			"ST_Students_Parents#studentId", "ST_Students_Parents", "companyId",
			"studentId", "parentId", this, Parent.class);

		studentToCourseTableMapper = TableMapperFactory.getTableMapper(
			"ST_Students_Courses#studentId", "ST_Students_Courses", "companyId",
			"studentId", "courseId", this, Course.class);

		studentToTeacherTableMapper = TableMapperFactory.getTableMapper(
			"ST_Students_Teachers#studentId", "ST_Students_Teachers",
			"companyId", "studentId", "teacherId", this, Teacher.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setStudentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStudentUtilPersistence(null);

		entityCache.removeCache(StudentImpl.class.getName());

		TableMapperFactory.removeTableMapper("ST_Students_Parents#studentId");
		TableMapperFactory.removeTableMapper("ST_Students_Courses#studentId");
		TableMapperFactory.removeTableMapper("ST_Students_Teachers#studentId");
	}

	private void _setStudentUtilPersistence(
		StudentPersistence studentPersistence) {

		try {
			Field field = StudentUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, studentPersistence);
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

	protected TableMapper<Student, Parent> studentToParentTableMapper;
	protected TableMapper<Student, Course> studentToCourseTableMapper;
	protected TableMapper<Student, Teacher> studentToTeacherTableMapper;

	private static final String _SQL_SELECT_STUDENT =
		"SELECT student FROM Student student";

	private static final String _SQL_COUNT_STUDENT =
		"SELECT COUNT(student) FROM Student student";

	private static final String _ORDER_BY_ENTITY_ALIAS = "student.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Student exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		StudentPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}