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

package com.fitness.club.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FitnessLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FitnessLocalService
 * @generated
 */
public class FitnessLocalServiceWrapper
	implements FitnessLocalService, ServiceWrapper<FitnessLocalService> {

	public FitnessLocalServiceWrapper() {
		this(null);
	}

	public FitnessLocalServiceWrapper(FitnessLocalService fitnessLocalService) {
		_fitnessLocalService = fitnessLocalService;
	}

	/**
	 * Adds the fitness to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FitnessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fitness the fitness
	 * @return the fitness that was added
	 */
	@Override
	public com.fitness.club.service.model.Fitness addFitness(
		com.fitness.club.service.model.Fitness fitness) {

		return _fitnessLocalService.addFitness(fitness);
	}

	/**
	 * Creates a new fitness with the primary key. Does not add the fitness to the database.
	 *
	 * @param trainerId the primary key for the new fitness
	 * @return the new fitness
	 */
	@Override
	public com.fitness.club.service.model.Fitness createFitness(
		long trainerId) {

		return _fitnessLocalService.createFitness(trainerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fitnessLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the fitness from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FitnessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fitness the fitness
	 * @return the fitness that was removed
	 */
	@Override
	public com.fitness.club.service.model.Fitness deleteFitness(
		com.fitness.club.service.model.Fitness fitness) {

		return _fitnessLocalService.deleteFitness(fitness);
	}

	/**
	 * Deletes the fitness with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FitnessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness that was removed
	 * @throws PortalException if a fitness with the primary key could not be found
	 */
	@Override
	public com.fitness.club.service.model.Fitness deleteFitness(long trainerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fitnessLocalService.deleteFitness(trainerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fitnessLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fitnessLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fitnessLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fitnessLocalService.dynamicQuery();
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

		return _fitnessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.fitness.club.service.model.impl.FitnessModelImpl</code>.
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

		return _fitnessLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.fitness.club.service.model.impl.FitnessModelImpl</code>.
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

		return _fitnessLocalService.dynamicQuery(
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

		return _fitnessLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fitnessLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.fitness.club.service.model.Fitness fetchFitness(long trainerId) {
		return _fitnessLocalService.fetchFitness(trainerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fitnessLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the fitness with the primary key.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness
	 * @throws PortalException if a fitness with the primary key could not be found
	 */
	@Override
	public com.fitness.club.service.model.Fitness getFitness(long trainerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fitnessLocalService.getFitness(trainerId);
	}

	/**
	 * Returns a range of all the fitnesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.fitness.club.service.model.impl.FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @return the range of fitnesses
	 */
	@Override
	public java.util.List<com.fitness.club.service.model.Fitness> getFitnesses(
		int start, int end) {

		return _fitnessLocalService.getFitnesses(start, end);
	}

	/**
	 * Returns the number of fitnesses.
	 *
	 * @return the number of fitnesses
	 */
	@Override
	public int getFitnessesCount() {
		return _fitnessLocalService.getFitnessesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fitnessLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fitnessLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fitnessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the fitness in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FitnessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fitness the fitness
	 * @return the fitness that was updated
	 */
	@Override
	public com.fitness.club.service.model.Fitness updateFitness(
		com.fitness.club.service.model.Fitness fitness) {

		return _fitnessLocalService.updateFitness(fitness);
	}

	@Override
	public FitnessLocalService getWrappedService() {
		return _fitnessLocalService;
	}

	@Override
	public void setWrappedService(FitnessLocalService fitnessLocalService) {
		_fitnessLocalService = fitnessLocalService;
	}

	private FitnessLocalService _fitnessLocalService;

}