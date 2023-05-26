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

package com.intranet.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link skillsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see skillsLocalService
 * @generated
 */
public class skillsLocalServiceWrapper
	implements ServiceWrapper<skillsLocalService>, skillsLocalService {

	public skillsLocalServiceWrapper() {
		this(null);
	}

	public skillsLocalServiceWrapper(skillsLocalService skillsLocalService) {
		_skillsLocalService = skillsLocalService;
	}

	/**
	 * Adds the skills to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect skillsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skills the skills
	 * @return the skills that was added
	 */
	@Override
	public com.intranet.model.skills addskills(
		com.intranet.model.skills skills) {

		return _skillsLocalService.addskills(skills);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skillsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new skills with the primary key. Does not add the skills to the database.
	 *
	 * @param skillId the primary key for the new skills
	 * @return the new skills
	 */
	@Override
	public com.intranet.model.skills createskills(long skillId) {
		return _skillsLocalService.createskills(skillId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skillsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect skillsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills that was removed
	 * @throws PortalException if a skills with the primary key could not be found
	 */
	@Override
	public com.intranet.model.skills deleteskills(long skillId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skillsLocalService.deleteskills(skillId);
	}

	/**
	 * Deletes the skills from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect skillsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skills the skills
	 * @return the skills that was removed
	 */
	@Override
	public com.intranet.model.skills deleteskills(
		com.intranet.model.skills skills) {

		return _skillsLocalService.deleteskills(skills);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _skillsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _skillsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _skillsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _skillsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.skillsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _skillsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.skillsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _skillsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _skillsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _skillsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.intranet.model.skills fetchskills(long skillId) {
		return _skillsLocalService.fetchskills(skillId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _skillsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _skillsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _skillsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skillsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the skills with the primary key.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills
	 * @throws PortalException if a skills with the primary key could not be found
	 */
	@Override
	public com.intranet.model.skills getskills(long skillId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skillsLocalService.getskills(skillId);
	}

	/**
	 * Returns a range of all the skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.skillsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of skillses
	 * @param end the upper bound of the range of skillses (not inclusive)
	 * @return the range of skillses
	 */
	@Override
	public java.util.List<com.intranet.model.skills> getskillses(
		int start, int end) {

		return _skillsLocalService.getskillses(start, end);
	}

	/**
	 * Returns the number of skillses.
	 *
	 * @return the number of skillses
	 */
	@Override
	public int getskillsesCount() {
		return _skillsLocalService.getskillsesCount();
	}

	/**
	 * Updates the skills in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect skillsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skills the skills
	 * @return the skills that was updated
	 */
	@Override
	public com.intranet.model.skills updateskills(
		com.intranet.model.skills skills) {

		return _skillsLocalService.updateskills(skills);
	}

	@Override
	public skillsLocalService getWrappedService() {
		return _skillsLocalService;
	}

	@Override
	public void setWrappedService(skillsLocalService skillsLocalService) {
		_skillsLocalService = skillsLocalService;
	}

	private skillsLocalService _skillsLocalService;

}