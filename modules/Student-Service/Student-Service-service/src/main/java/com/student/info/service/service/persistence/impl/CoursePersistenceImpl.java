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

import com.student.info.service.exception.NoSuchCourseException;
import com.student.info.service.model.Course;
import com.student.info.service.model.CourseTable;
import com.student.info.service.model.Student;
import com.student.info.service.model.Teacher;
import com.student.info.service.model.impl.CourseImpl;
import com.student.info.service.model.impl.CourseModelImpl;
import com.student.info.service.service.persistence.CoursePersistence;
import com.student.info.service.service.persistence.CourseUtil;
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
 * The persistence implementation for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CoursePersistence.class)
public class CoursePersistenceImpl
	extends BasePersistenceImpl<Course> implements CoursePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CourseUtil</code> to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CourseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CoursePersistenceImpl() {
		setModelClass(Course.class);

		setModelImplClass(CourseImpl.class);
		setModelPKClass(long.class);

		setTable(CourseTable.INSTANCE);
	}

	/**
	 * Caches the course in the entity cache if it is enabled.
	 *
	 * @param course the course
	 */
	@Override
	public void cacheResult(Course course) {
		entityCache.putResult(CourseImpl.class, course.getPrimaryKey(), course);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	@Override
	public void cacheResult(List<Course> courses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (courses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Course course : courses) {
			if (entityCache.getResult(
					CourseImpl.class, course.getPrimaryKey()) == null) {

				cacheResult(course);
			}
		}
	}

	/**
	 * Clears the cache for all courses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CourseImpl.class);

		finderCache.clearCache(CourseImpl.class);
	}

	/**
	 * Clears the cache for the course.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Course course) {
		entityCache.removeResult(CourseImpl.class, course);
	}

	@Override
	public void clearCache(List<Course> courses) {
		for (Course course : courses) {
			entityCache.removeResult(CourseImpl.class, course);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CourseImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CourseImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	@Override
	public Course create(long courseId) {
		Course course = new CourseImpl();

		course.setNew(true);
		course.setPrimaryKey(courseId);

		course.setCompanyId(CompanyThreadLocal.getCompanyId());

		return course;
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the course
	 * @return the course that was removed
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	@Override
	public Course remove(long courseId) throws NoSuchCourseException {
		return remove((Serializable)courseId);
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course that was removed
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	@Override
	public Course remove(Serializable primaryKey) throws NoSuchCourseException {
		Session session = null;

		try {
			session = openSession();

			Course course = (Course)session.get(CourseImpl.class, primaryKey);

			if (course == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(course);
		}
		catch (NoSuchCourseException noSuchEntityException) {
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
	protected Course removeImpl(Course course) {
		courseToStudentTableMapper.deleteLeftPrimaryKeyTableMappings(
			course.getPrimaryKey());

		courseToTeacherTableMapper.deleteLeftPrimaryKeyTableMappings(
			course.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(course)) {
				course = (Course)session.get(
					CourseImpl.class, course.getPrimaryKeyObj());
			}

			if (course != null) {
				session.delete(course);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (course != null) {
			clearCache(course);
		}

		return course;
	}

	@Override
	public Course updateImpl(Course course) {
		boolean isNew = course.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(course);
			}
			else {
				course = (Course)session.merge(course);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(CourseImpl.class, course, false, true);

		if (isNew) {
			course.setNew(false);
		}

		course.resetOriginalValues();

		return course;
	}

	/**
	 * Returns the course with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	@Override
	public Course findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseException {

		Course course = fetchByPrimaryKey(primaryKey);

		if (course == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return course;
	}

	/**
	 * Returns the course with the primary key or throws a <code>NoSuchCourseException</code> if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	@Override
	public Course findByPrimaryKey(long courseId) throws NoSuchCourseException {
		return findByPrimaryKey((Serializable)courseId);
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 */
	@Override
	public Course fetchByPrimaryKey(long courseId) {
		return fetchByPrimaryKey((Serializable)courseId);
	}

	/**
	 * Returns all the courses.
	 *
	 * @return the courses
	 */
	@Override
	public List<Course> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of courses
	 */
	@Override
	public List<Course> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of courses
	 */
	@Override
	public List<Course> findAll(
		int start, int end, OrderByComparator<Course> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of courses
	 */
	@Override
	public List<Course> findAll(
		int start, int end, OrderByComparator<Course> orderByComparator,
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

		List<Course> list = null;

		if (useFinderCache) {
			list = (List<Course>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COURSE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COURSE;

				sql = sql.concat(CourseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Course>)QueryUtil.list(
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
	 * Removes all the courses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Course course : findAll()) {
			remove(course);
		}
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COURSE);

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
	 * Returns the primaryKeys of students associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return long[] of the primaryKeys of students associated with the course
	 */
	@Override
	public long[] getStudentPrimaryKeys(long pk) {
		long[] pks = courseToStudentTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the course associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the courses associated with the student
	 */
	@Override
	public List<Course> getStudentCourses(long pk) {
		return getStudentCourses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the course associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of courses associated with the student
	 */
	@Override
	public List<Course> getStudentCourses(long pk, int start, int end) {
		return getStudentCourses(pk, start, end, null);
	}

	/**
	 * Returns all the course associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of courses associated with the student
	 */
	@Override
	public List<Course> getStudentCourses(
		long pk, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return courseToStudentTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of students associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the number of students associated with the course
	 */
	@Override
	public int getStudentsSize(long pk) {
		long[] pks = courseToStudentTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the student is associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @param studentPK the primary key of the student
	 * @return <code>true</code> if the student is associated with the course; <code>false</code> otherwise
	 */
	@Override
	public boolean containsStudent(long pk, long studentPK) {
		return courseToStudentTableMapper.containsTableMapping(pk, studentPK);
	}

	/**
	 * Returns <code>true</code> if the course has any students associated with it.
	 *
	 * @param pk the primary key of the course to check for associations with students
	 * @return <code>true</code> if the course has any students associated with it; <code>false</code> otherwise
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
	 * Adds an association between the course and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param studentPK the primary key of the student
	 */
	@Override
	public void addStudent(long pk, long studentPK) {
		Course course = fetchByPrimaryKey(pk);

		if (course == null) {
			courseToStudentTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, studentPK);
		}
		else {
			courseToStudentTableMapper.addTableMapping(
				course.getCompanyId(), pk, studentPK);
		}
	}

	/**
	 * Adds an association between the course and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param student the student
	 */
	@Override
	public void addStudent(long pk, Student student) {
		Course course = fetchByPrimaryKey(pk);

		if (course == null) {
			courseToStudentTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, student.getPrimaryKey());
		}
		else {
			courseToStudentTableMapper.addTableMapping(
				course.getCompanyId(), pk, student.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the course and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param studentPKs the primary keys of the students
	 */
	@Override
	public void addStudents(long pk, long[] studentPKs) {
		long companyId = 0;

		Course course = fetchByPrimaryKey(pk);

		if (course == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = course.getCompanyId();
		}

		courseToStudentTableMapper.addTableMappings(companyId, pk, studentPKs);
	}

	/**
	 * Adds an association between the course and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param students the students
	 */
	@Override
	public void addStudents(long pk, List<Student> students) {
		addStudents(
			pk, ListUtil.toLongArray(students, Student.STUDENT_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the course and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course to clear the associated students from
	 */
	@Override
	public void clearStudents(long pk) {
		courseToStudentTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the course and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param studentPK the primary key of the student
	 */
	@Override
	public void removeStudent(long pk, long studentPK) {
		courseToStudentTableMapper.deleteTableMapping(pk, studentPK);
	}

	/**
	 * Removes the association between the course and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param student the student
	 */
	@Override
	public void removeStudent(long pk, Student student) {
		courseToStudentTableMapper.deleteTableMapping(
			pk, student.getPrimaryKey());
	}

	/**
	 * Removes the association between the course and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param studentPKs the primary keys of the students
	 */
	@Override
	public void removeStudents(long pk, long[] studentPKs) {
		courseToStudentTableMapper.deleteTableMappings(pk, studentPKs);
	}

	/**
	 * Removes the association between the course and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param students the students
	 */
	@Override
	public void removeStudents(long pk, List<Student> students) {
		removeStudents(
			pk, ListUtil.toLongArray(students, Student.STUDENT_ID_ACCESSOR));
	}

	/**
	 * Sets the students associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param studentPKs the primary keys of the students to be associated with the course
	 */
	@Override
	public void setStudents(long pk, long[] studentPKs) {
		Set<Long> newStudentPKsSet = SetUtil.fromArray(studentPKs);
		Set<Long> oldStudentPKsSet = SetUtil.fromArray(
			courseToStudentTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeStudentPKsSet = new HashSet<Long>(oldStudentPKsSet);

		removeStudentPKsSet.removeAll(newStudentPKsSet);

		courseToStudentTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeStudentPKsSet));

		newStudentPKsSet.removeAll(oldStudentPKsSet);

		long companyId = 0;

		Course course = fetchByPrimaryKey(pk);

		if (course == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = course.getCompanyId();
		}

		courseToStudentTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newStudentPKsSet));
	}

	/**
	 * Sets the students associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param students the students to be associated with the course
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
	 * Returns the primaryKeys of teachers associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return long[] of the primaryKeys of teachers associated with the course
	 */
	@Override
	public long[] getTeacherPrimaryKeys(long pk) {
		long[] pks = courseToTeacherTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the course associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the courses associated with the teacher
	 */
	@Override
	public List<Course> getTeacherCourses(long pk) {
		return getTeacherCourses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the course associated with the teacher.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the teacher
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @return the range of courses associated with the teacher
	 */
	@Override
	public List<Course> getTeacherCourses(long pk, int start, int end) {
		return getTeacherCourses(pk, start, end, null);
	}

	/**
	 * Returns all the course associated with the teacher.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the teacher
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of courses associated with the teacher
	 */
	@Override
	public List<Course> getTeacherCourses(
		long pk, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return courseToTeacherTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of teachers associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the number of teachers associated with the course
	 */
	@Override
	public int getTeachersSize(long pk) {
		long[] pks = courseToTeacherTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the teacher is associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @param teacherPK the primary key of the teacher
	 * @return <code>true</code> if the teacher is associated with the course; <code>false</code> otherwise
	 */
	@Override
	public boolean containsTeacher(long pk, long teacherPK) {
		return courseToTeacherTableMapper.containsTableMapping(pk, teacherPK);
	}

	/**
	 * Returns <code>true</code> if the course has any teachers associated with it.
	 *
	 * @param pk the primary key of the course to check for associations with teachers
	 * @return <code>true</code> if the course has any teachers associated with it; <code>false</code> otherwise
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
	 * Adds an association between the course and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teacherPK the primary key of the teacher
	 */
	@Override
	public void addTeacher(long pk, long teacherPK) {
		Course course = fetchByPrimaryKey(pk);

		if (course == null) {
			courseToTeacherTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, teacherPK);
		}
		else {
			courseToTeacherTableMapper.addTableMapping(
				course.getCompanyId(), pk, teacherPK);
		}
	}

	/**
	 * Adds an association between the course and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teacher the teacher
	 */
	@Override
	public void addTeacher(long pk, Teacher teacher) {
		Course course = fetchByPrimaryKey(pk);

		if (course == null) {
			courseToTeacherTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, teacher.getPrimaryKey());
		}
		else {
			courseToTeacherTableMapper.addTableMapping(
				course.getCompanyId(), pk, teacher.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the course and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teacherPKs the primary keys of the teachers
	 */
	@Override
	public void addTeachers(long pk, long[] teacherPKs) {
		long companyId = 0;

		Course course = fetchByPrimaryKey(pk);

		if (course == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = course.getCompanyId();
		}

		courseToTeacherTableMapper.addTableMappings(companyId, pk, teacherPKs);
	}

	/**
	 * Adds an association between the course and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teachers the teachers
	 */
	@Override
	public void addTeachers(long pk, List<Teacher> teachers) {
		addTeachers(
			pk, ListUtil.toLongArray(teachers, Teacher.TEACHER_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the course and its teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course to clear the associated teachers from
	 */
	@Override
	public void clearTeachers(long pk) {
		courseToTeacherTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the course and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teacherPK the primary key of the teacher
	 */
	@Override
	public void removeTeacher(long pk, long teacherPK) {
		courseToTeacherTableMapper.deleteTableMapping(pk, teacherPK);
	}

	/**
	 * Removes the association between the course and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teacher the teacher
	 */
	@Override
	public void removeTeacher(long pk, Teacher teacher) {
		courseToTeacherTableMapper.deleteTableMapping(
			pk, teacher.getPrimaryKey());
	}

	/**
	 * Removes the association between the course and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teacherPKs the primary keys of the teachers
	 */
	@Override
	public void removeTeachers(long pk, long[] teacherPKs) {
		courseToTeacherTableMapper.deleteTableMappings(pk, teacherPKs);
	}

	/**
	 * Removes the association between the course and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teachers the teachers
	 */
	@Override
	public void removeTeachers(long pk, List<Teacher> teachers) {
		removeTeachers(
			pk, ListUtil.toLongArray(teachers, Teacher.TEACHER_ID_ACCESSOR));
	}

	/**
	 * Sets the teachers associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teacherPKs the primary keys of the teachers to be associated with the course
	 */
	@Override
	public void setTeachers(long pk, long[] teacherPKs) {
		Set<Long> newTeacherPKsSet = SetUtil.fromArray(teacherPKs);
		Set<Long> oldTeacherPKsSet = SetUtil.fromArray(
			courseToTeacherTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeTeacherPKsSet = new HashSet<Long>(oldTeacherPKsSet);

		removeTeacherPKsSet.removeAll(newTeacherPKsSet);

		courseToTeacherTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeTeacherPKsSet));

		newTeacherPKsSet.removeAll(oldTeacherPKsSet);

		long companyId = 0;

		Course course = fetchByPrimaryKey(pk);

		if (course == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = course.getCompanyId();
		}

		courseToTeacherTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newTeacherPKsSet));
	}

	/**
	 * Sets the teachers associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the course
	 * @param teachers the teachers to be associated with the course
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
		return "courseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COURSE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CourseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the course persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		courseToStudentTableMapper = TableMapperFactory.getTableMapper(
			"ST_Students_Courses#courseId", "ST_Students_Courses", "companyId",
			"courseId", "studentId", this, Student.class);

		courseToTeacherTableMapper = TableMapperFactory.getTableMapper(
			"ST_Courses_Teachers#courseId", "ST_Courses_Teachers", "companyId",
			"courseId", "teacherId", this, Teacher.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setCourseUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCourseUtilPersistence(null);

		entityCache.removeCache(CourseImpl.class.getName());

		TableMapperFactory.removeTableMapper("ST_Students_Courses#courseId");
		TableMapperFactory.removeTableMapper("ST_Courses_Teachers#courseId");
	}

	private void _setCourseUtilPersistence(
		CoursePersistence coursePersistence) {

		try {
			Field field = CourseUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, coursePersistence);
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

	protected TableMapper<Course, Student> courseToStudentTableMapper;
	protected TableMapper<Course, Teacher> courseToTeacherTableMapper;

	private static final String _SQL_SELECT_COURSE =
		"SELECT course FROM Course course";

	private static final String _SQL_COUNT_COURSE =
		"SELECT COUNT(course) FROM Course course";

	private static final String _ORDER_BY_ENTITY_ALIAS = "course.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Course exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CoursePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}