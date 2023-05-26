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

import com.student.info.service.exception.NoSuchTeacherException;
import com.student.info.service.model.Course;
import com.student.info.service.model.Student;
import com.student.info.service.model.Teacher;
import com.student.info.service.model.TeacherTable;
import com.student.info.service.model.impl.TeacherImpl;
import com.student.info.service.model.impl.TeacherModelImpl;
import com.student.info.service.service.persistence.TeacherPersistence;
import com.student.info.service.service.persistence.TeacherUtil;
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
 * The persistence implementation for the teacher service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TeacherPersistence.class)
public class TeacherPersistenceImpl
	extends BasePersistenceImpl<Teacher> implements TeacherPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TeacherUtil</code> to access the teacher persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TeacherImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TeacherPersistenceImpl() {
		setModelClass(Teacher.class);

		setModelImplClass(TeacherImpl.class);
		setModelPKClass(long.class);

		setTable(TeacherTable.INSTANCE);
	}

	/**
	 * Caches the teacher in the entity cache if it is enabled.
	 *
	 * @param teacher the teacher
	 */
	@Override
	public void cacheResult(Teacher teacher) {
		entityCache.putResult(
			TeacherImpl.class, teacher.getPrimaryKey(), teacher);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the teachers in the entity cache if it is enabled.
	 *
	 * @param teachers the teachers
	 */
	@Override
	public void cacheResult(List<Teacher> teachers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (teachers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Teacher teacher : teachers) {
			if (entityCache.getResult(
					TeacherImpl.class, teacher.getPrimaryKey()) == null) {

				cacheResult(teacher);
			}
		}
	}

	/**
	 * Clears the cache for all teachers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TeacherImpl.class);

		finderCache.clearCache(TeacherImpl.class);
	}

	/**
	 * Clears the cache for the teacher.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Teacher teacher) {
		entityCache.removeResult(TeacherImpl.class, teacher);
	}

	@Override
	public void clearCache(List<Teacher> teachers) {
		for (Teacher teacher : teachers) {
			entityCache.removeResult(TeacherImpl.class, teacher);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TeacherImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TeacherImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new teacher with the primary key. Does not add the teacher to the database.
	 *
	 * @param teacherId the primary key for the new teacher
	 * @return the new teacher
	 */
	@Override
	public Teacher create(long teacherId) {
		Teacher teacher = new TeacherImpl();

		teacher.setNew(true);
		teacher.setPrimaryKey(teacherId);

		teacher.setCompanyId(CompanyThreadLocal.getCompanyId());

		return teacher;
	}

	/**
	 * Removes the teacher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher that was removed
	 * @throws NoSuchTeacherException if a teacher with the primary key could not be found
	 */
	@Override
	public Teacher remove(long teacherId) throws NoSuchTeacherException {
		return remove((Serializable)teacherId);
	}

	/**
	 * Removes the teacher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the teacher
	 * @return the teacher that was removed
	 * @throws NoSuchTeacherException if a teacher with the primary key could not be found
	 */
	@Override
	public Teacher remove(Serializable primaryKey)
		throws NoSuchTeacherException {

		Session session = null;

		try {
			session = openSession();

			Teacher teacher = (Teacher)session.get(
				TeacherImpl.class, primaryKey);

			if (teacher == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTeacherException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(teacher);
		}
		catch (NoSuchTeacherException noSuchEntityException) {
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
	protected Teacher removeImpl(Teacher teacher) {
		teacherToStudentTableMapper.deleteLeftPrimaryKeyTableMappings(
			teacher.getPrimaryKey());

		teacherToCourseTableMapper.deleteLeftPrimaryKeyTableMappings(
			teacher.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(teacher)) {
				teacher = (Teacher)session.get(
					TeacherImpl.class, teacher.getPrimaryKeyObj());
			}

			if (teacher != null) {
				session.delete(teacher);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (teacher != null) {
			clearCache(teacher);
		}

		return teacher;
	}

	@Override
	public Teacher updateImpl(Teacher teacher) {
		boolean isNew = teacher.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(teacher);
			}
			else {
				teacher = (Teacher)session.merge(teacher);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(TeacherImpl.class, teacher, false, true);

		if (isNew) {
			teacher.setNew(false);
		}

		teacher.resetOriginalValues();

		return teacher;
	}

	/**
	 * Returns the teacher with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the teacher
	 * @return the teacher
	 * @throws NoSuchTeacherException if a teacher with the primary key could not be found
	 */
	@Override
	public Teacher findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTeacherException {

		Teacher teacher = fetchByPrimaryKey(primaryKey);

		if (teacher == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTeacherException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return teacher;
	}

	/**
	 * Returns the teacher with the primary key or throws a <code>NoSuchTeacherException</code> if it could not be found.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher
	 * @throws NoSuchTeacherException if a teacher with the primary key could not be found
	 */
	@Override
	public Teacher findByPrimaryKey(long teacherId)
		throws NoSuchTeacherException {

		return findByPrimaryKey((Serializable)teacherId);
	}

	/**
	 * Returns the teacher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher, or <code>null</code> if a teacher with the primary key could not be found
	 */
	@Override
	public Teacher fetchByPrimaryKey(long teacherId) {
		return fetchByPrimaryKey((Serializable)teacherId);
	}

	/**
	 * Returns all the teachers.
	 *
	 * @return the teachers
	 */
	@Override
	public List<Teacher> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the teachers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @return the range of teachers
	 */
	@Override
	public List<Teacher> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the teachers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of teachers
	 */
	@Override
	public List<Teacher> findAll(
		int start, int end, OrderByComparator<Teacher> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the teachers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of teachers
	 */
	@Override
	public List<Teacher> findAll(
		int start, int end, OrderByComparator<Teacher> orderByComparator,
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

		List<Teacher> list = null;

		if (useFinderCache) {
			list = (List<Teacher>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TEACHER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TEACHER;

				sql = sql.concat(TeacherModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Teacher>)QueryUtil.list(
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
	 * Removes all the teachers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Teacher teacher : findAll()) {
			remove(teacher);
		}
	}

	/**
	 * Returns the number of teachers.
	 *
	 * @return the number of teachers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TEACHER);

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
	 * Returns the primaryKeys of students associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return long[] of the primaryKeys of students associated with the teacher
	 */
	@Override
	public long[] getStudentPrimaryKeys(long pk) {
		long[] pks = teacherToStudentTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the teacher associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the teachers associated with the student
	 */
	@Override
	public List<Teacher> getStudentTeachers(long pk) {
		return getStudentTeachers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the teacher associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of teachers associated with the student
	 */
	@Override
	public List<Teacher> getStudentTeachers(long pk, int start, int end) {
		return getStudentTeachers(pk, start, end, null);
	}

	/**
	 * Returns all the teacher associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of teachers associated with the student
	 */
	@Override
	public List<Teacher> getStudentTeachers(
		long pk, int start, int end,
		OrderByComparator<Teacher> orderByComparator) {

		return teacherToStudentTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of students associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the number of students associated with the teacher
	 */
	@Override
	public int getStudentsSize(long pk) {
		long[] pks = teacherToStudentTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the student is associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPK the primary key of the student
	 * @return <code>true</code> if the student is associated with the teacher; <code>false</code> otherwise
	 */
	@Override
	public boolean containsStudent(long pk, long studentPK) {
		return teacherToStudentTableMapper.containsTableMapping(pk, studentPK);
	}

	/**
	 * Returns <code>true</code> if the teacher has any students associated with it.
	 *
	 * @param pk the primary key of the teacher to check for associations with students
	 * @return <code>true</code> if the teacher has any students associated with it; <code>false</code> otherwise
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
	 * Adds an association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPK the primary key of the student
	 */
	@Override
	public void addStudent(long pk, long studentPK) {
		Teacher teacher = fetchByPrimaryKey(pk);

		if (teacher == null) {
			teacherToStudentTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, studentPK);
		}
		else {
			teacherToStudentTableMapper.addTableMapping(
				teacher.getCompanyId(), pk, studentPK);
		}
	}

	/**
	 * Adds an association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param student the student
	 */
	@Override
	public void addStudent(long pk, Student student) {
		Teacher teacher = fetchByPrimaryKey(pk);

		if (teacher == null) {
			teacherToStudentTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, student.getPrimaryKey());
		}
		else {
			teacherToStudentTableMapper.addTableMapping(
				teacher.getCompanyId(), pk, student.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPKs the primary keys of the students
	 */
	@Override
	public void addStudents(long pk, long[] studentPKs) {
		long companyId = 0;

		Teacher teacher = fetchByPrimaryKey(pk);

		if (teacher == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = teacher.getCompanyId();
		}

		teacherToStudentTableMapper.addTableMappings(companyId, pk, studentPKs);
	}

	/**
	 * Adds an association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param students the students
	 */
	@Override
	public void addStudents(long pk, List<Student> students) {
		addStudents(
			pk, ListUtil.toLongArray(students, Student.STUDENT_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the teacher and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher to clear the associated students from
	 */
	@Override
	public void clearStudents(long pk) {
		teacherToStudentTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPK the primary key of the student
	 */
	@Override
	public void removeStudent(long pk, long studentPK) {
		teacherToStudentTableMapper.deleteTableMapping(pk, studentPK);
	}

	/**
	 * Removes the association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param student the student
	 */
	@Override
	public void removeStudent(long pk, Student student) {
		teacherToStudentTableMapper.deleteTableMapping(
			pk, student.getPrimaryKey());
	}

	/**
	 * Removes the association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPKs the primary keys of the students
	 */
	@Override
	public void removeStudents(long pk, long[] studentPKs) {
		teacherToStudentTableMapper.deleteTableMappings(pk, studentPKs);
	}

	/**
	 * Removes the association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param students the students
	 */
	@Override
	public void removeStudents(long pk, List<Student> students) {
		removeStudents(
			pk, ListUtil.toLongArray(students, Student.STUDENT_ID_ACCESSOR));
	}

	/**
	 * Sets the students associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPKs the primary keys of the students to be associated with the teacher
	 */
	@Override
	public void setStudents(long pk, long[] studentPKs) {
		Set<Long> newStudentPKsSet = SetUtil.fromArray(studentPKs);
		Set<Long> oldStudentPKsSet = SetUtil.fromArray(
			teacherToStudentTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeStudentPKsSet = new HashSet<Long>(oldStudentPKsSet);

		removeStudentPKsSet.removeAll(newStudentPKsSet);

		teacherToStudentTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeStudentPKsSet));

		newStudentPKsSet.removeAll(oldStudentPKsSet);

		long companyId = 0;

		Teacher teacher = fetchByPrimaryKey(pk);

		if (teacher == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = teacher.getCompanyId();
		}

		teacherToStudentTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newStudentPKsSet));
	}

	/**
	 * Sets the students associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param students the students to be associated with the teacher
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

	/**
	 * Returns the primaryKeys of courses associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return long[] of the primaryKeys of courses associated with the teacher
	 */
	@Override
	public long[] getCoursePrimaryKeys(long pk) {
		long[] pks = teacherToCourseTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the teacher associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the teachers associated with the course
	 */
	@Override
	public List<Teacher> getCourseTeachers(long pk) {
		return getCourseTeachers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the teacher associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the course
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of teachers associated with the course
	 */
	@Override
	public List<Teacher> getCourseTeachers(long pk, int start, int end) {
		return getCourseTeachers(pk, start, end, null);
	}

	/**
	 * Returns all the teacher associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the course
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of teachers associated with the course
	 */
	@Override
	public List<Teacher> getCourseTeachers(
		long pk, int start, int end,
		OrderByComparator<Teacher> orderByComparator) {

		return teacherToCourseTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of courses associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the number of courses associated with the teacher
	 */
	@Override
	public int getCoursesSize(long pk) {
		long[] pks = teacherToCourseTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the course is associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePK the primary key of the course
	 * @return <code>true</code> if the course is associated with the teacher; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCourse(long pk, long coursePK) {
		return teacherToCourseTableMapper.containsTableMapping(pk, coursePK);
	}

	/**
	 * Returns <code>true</code> if the teacher has any courses associated with it.
	 *
	 * @param pk the primary key of the teacher to check for associations with courses
	 * @return <code>true</code> if the teacher has any courses associated with it; <code>false</code> otherwise
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
	 * Adds an association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePK the primary key of the course
	 */
	@Override
	public void addCourse(long pk, long coursePK) {
		Teacher teacher = fetchByPrimaryKey(pk);

		if (teacher == null) {
			teacherToCourseTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, coursePK);
		}
		else {
			teacherToCourseTableMapper.addTableMapping(
				teacher.getCompanyId(), pk, coursePK);
		}
	}

	/**
	 * Adds an association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param course the course
	 */
	@Override
	public void addCourse(long pk, Course course) {
		Teacher teacher = fetchByPrimaryKey(pk);

		if (teacher == null) {
			teacherToCourseTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, course.getPrimaryKey());
		}
		else {
			teacherToCourseTableMapper.addTableMapping(
				teacher.getCompanyId(), pk, course.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePKs the primary keys of the courses
	 */
	@Override
	public void addCourses(long pk, long[] coursePKs) {
		long companyId = 0;

		Teacher teacher = fetchByPrimaryKey(pk);

		if (teacher == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = teacher.getCompanyId();
		}

		teacherToCourseTableMapper.addTableMappings(companyId, pk, coursePKs);
	}

	/**
	 * Adds an association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param courses the courses
	 */
	@Override
	public void addCourses(long pk, List<Course> courses) {
		addCourses(
			pk, ListUtil.toLongArray(courses, Course.COURSE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the teacher and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher to clear the associated courses from
	 */
	@Override
	public void clearCourses(long pk) {
		teacherToCourseTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePK the primary key of the course
	 */
	@Override
	public void removeCourse(long pk, long coursePK) {
		teacherToCourseTableMapper.deleteTableMapping(pk, coursePK);
	}

	/**
	 * Removes the association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param course the course
	 */
	@Override
	public void removeCourse(long pk, Course course) {
		teacherToCourseTableMapper.deleteTableMapping(
			pk, course.getPrimaryKey());
	}

	/**
	 * Removes the association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePKs the primary keys of the courses
	 */
	@Override
	public void removeCourses(long pk, long[] coursePKs) {
		teacherToCourseTableMapper.deleteTableMappings(pk, coursePKs);
	}

	/**
	 * Removes the association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param courses the courses
	 */
	@Override
	public void removeCourses(long pk, List<Course> courses) {
		removeCourses(
			pk, ListUtil.toLongArray(courses, Course.COURSE_ID_ACCESSOR));
	}

	/**
	 * Sets the courses associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePKs the primary keys of the courses to be associated with the teacher
	 */
	@Override
	public void setCourses(long pk, long[] coursePKs) {
		Set<Long> newCoursePKsSet = SetUtil.fromArray(coursePKs);
		Set<Long> oldCoursePKsSet = SetUtil.fromArray(
			teacherToCourseTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeCoursePKsSet = new HashSet<Long>(oldCoursePKsSet);

		removeCoursePKsSet.removeAll(newCoursePKsSet);

		teacherToCourseTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeCoursePKsSet));

		newCoursePKsSet.removeAll(oldCoursePKsSet);

		long companyId = 0;

		Teacher teacher = fetchByPrimaryKey(pk);

		if (teacher == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = teacher.getCompanyId();
		}

		teacherToCourseTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newCoursePKsSet));
	}

	/**
	 * Sets the courses associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param courses the courses to be associated with the teacher
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

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "teacherId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TEACHER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TeacherModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the teacher persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		teacherToStudentTableMapper = TableMapperFactory.getTableMapper(
			"ST_Students_Teachers#teacherId", "ST_Students_Teachers",
			"companyId", "teacherId", "studentId", this, Student.class);

		teacherToCourseTableMapper = TableMapperFactory.getTableMapper(
			"ST_Courses_Teachers#teacherId", "ST_Courses_Teachers", "companyId",
			"teacherId", "courseId", this, Course.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setTeacherUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTeacherUtilPersistence(null);

		entityCache.removeCache(TeacherImpl.class.getName());

		TableMapperFactory.removeTableMapper("ST_Students_Teachers#teacherId");
		TableMapperFactory.removeTableMapper("ST_Courses_Teachers#teacherId");
	}

	private void _setTeacherUtilPersistence(
		TeacherPersistence teacherPersistence) {

		try {
			Field field = TeacherUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, teacherPersistence);
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

	protected TableMapper<Teacher, Student> teacherToStudentTableMapper;
	protected TableMapper<Teacher, Course> teacherToCourseTableMapper;

	private static final String _SQL_SELECT_TEACHER =
		"SELECT teacher FROM Teacher teacher";

	private static final String _SQL_COUNT_TEACHER =
		"SELECT COUNT(teacher) FROM Teacher teacher";

	private static final String _ORDER_BY_ENTITY_ALIAS = "teacher.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Teacher exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TeacherPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}