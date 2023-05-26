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

package com.student.info.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.student.info.service.model.Teacher;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Teacher. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TeacherLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TeacherLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.student.info.service.service.impl.TeacherLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the teacher local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TeacherLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addCourseTeacher(long courseId, long teacherId);

	public void addCourseTeacher(long courseId, Teacher teacher);

	public void addCourseTeachers(long courseId, List<Teacher> teachers);

	public void addCourseTeachers(long courseId, long[] teacherIds);

	public void addStudentTeacher(long studentId, long teacherId);

	public void addStudentTeacher(long studentId, Teacher teacher);

	public void addStudentTeachers(long studentId, List<Teacher> teachers);

	public void addStudentTeachers(long studentId, long[] teacherIds);

	public Teacher addTeacher(
		long teacherId, String teacherName, String teacherEmail,
		long companyId);

	/**
	 * Adds the teacher to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacher the teacher
	 * @return the teacher that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Teacher addTeacher(Teacher teacher);

	public void clearCourseTeachers(long courseId);

	public void clearStudentTeachers(long studentId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new teacher with the primary key. Does not add the teacher to the database.
	 *
	 * @param teacherId the primary key for the new teacher
	 * @return the new teacher
	 */
	@Transactional(enabled = false)
	public Teacher createTeacher(long teacherId);

	public void deleteCourseTeacher(long courseId, long teacherId);

	public void deleteCourseTeacher(long courseId, Teacher teacher);

	public void deleteCourseTeachers(long courseId, List<Teacher> teachers);

	public void deleteCourseTeachers(long courseId, long[] teacherIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deleteStudentTeacher(long studentId, long teacherId);

	public void deleteStudentTeacher(long studentId, Teacher teacher);

	public void deleteStudentTeachers(long studentId, List<Teacher> teachers);

	public void deleteStudentTeachers(long studentId, long[] teacherIds);

	/**
	 * Deletes the teacher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher that was removed
	 * @throws PortalException if a teacher with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Teacher deleteTeacher(long teacherId) throws PortalException;

	/**
	 * Deletes the teacher from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacher the teacher
	 * @return the teacher that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Teacher deleteTeacher(Teacher teacher);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Teacher fetchTeacher(long teacherId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the courseIds of the courses associated with the teacher.
	 *
	 * @param teacherId the teacherId of the teacher
	 * @return long[] the courseIds of courses associated with the teacher
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getCoursePrimaryKeys(long teacherId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Teacher> getCourseTeachers(long courseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Teacher> getCourseTeachers(long courseId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Teacher> getCourseTeachers(
		long courseId, int start, int end,
		OrderByComparator<Teacher> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCourseTeachersCount(long courseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the studentIds of the students associated with the teacher.
	 *
	 * @param teacherId the teacherId of the teacher
	 * @return long[] the studentIds of students associated with the teacher
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getStudentPrimaryKeys(long teacherId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Teacher> getStudentTeachers(long studentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Teacher> getStudentTeachers(long studentId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Teacher> getStudentTeachers(
		long studentId, int start, int end,
		OrderByComparator<Teacher> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStudentTeachersCount(long studentId);

	/**
	 * Returns the teacher with the primary key.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher
	 * @throws PortalException if a teacher with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Teacher getTeacher(long teacherId) throws PortalException;

	/**
	 * Returns a range of all the teachers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @return the range of teachers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Teacher> getTeachers(int start, int end);

	/**
	 * Returns the number of teachers.
	 *
	 * @return the number of teachers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTeachersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasCourseTeacher(long courseId, long teacherId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasCourseTeachers(long courseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasStudentTeacher(long studentId, long teacherId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasStudentTeachers(long studentId);

	public void setCourseTeachers(long courseId, long[] teacherIds);

	public void setStudentTeachers(long studentId, long[] teacherIds);

	public Teacher updateTeacher(
		long teacherId, String teacherName, String teacherEmail);

	/**
	 * Updates the teacher in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacher the teacher
	 * @return the teacher that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Teacher updateTeacher(Teacher teacher);

}