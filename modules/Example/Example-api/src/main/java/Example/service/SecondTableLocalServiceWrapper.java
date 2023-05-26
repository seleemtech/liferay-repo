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

package Example.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SecondTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SecondTableLocalService
 * @generated
 */
public class SecondTableLocalServiceWrapper
	implements SecondTableLocalService,
			   ServiceWrapper<SecondTableLocalService> {

	public SecondTableLocalServiceWrapper() {
		this(null);
	}

	public SecondTableLocalServiceWrapper(
		SecondTableLocalService secondTableLocalService) {

		_secondTableLocalService = secondTableLocalService;
	}

	@Override
	public void addFirstTableSecondTable(long soId, long coId) {
		_secondTableLocalService.addFirstTableSecondTable(soId, coId);
	}

	@Override
	public void addFirstTableSecondTable(
		long soId, Example.model.SecondTable secondTable) {

		_secondTableLocalService.addFirstTableSecondTable(soId, secondTable);
	}

	@Override
	public void addFirstTableSecondTables(
		long soId, java.util.List<Example.model.SecondTable> secondTables) {

		_secondTableLocalService.addFirstTableSecondTables(soId, secondTables);
	}

	@Override
	public void addFirstTableSecondTables(long soId, long[] coIds) {
		_secondTableLocalService.addFirstTableSecondTables(soId, coIds);
	}

	/**
	 * Adds the second table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SecondTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param secondTable the second table
	 * @return the second table that was added
	 */
	@Override
	public Example.model.SecondTable addSecondTable(
		Example.model.SecondTable secondTable) {

		return _secondTableLocalService.addSecondTable(secondTable);
	}

	@Override
	public void clearFirstTableSecondTables(long soId) {
		_secondTableLocalService.clearFirstTableSecondTables(soId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _secondTableLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new second table with the primary key. Does not add the second table to the database.
	 *
	 * @param coId the primary key for the new second table
	 * @return the new second table
	 */
	@Override
	public Example.model.SecondTable createSecondTable(long coId) {
		return _secondTableLocalService.createSecondTable(coId);
	}

	@Override
	public void deleteFirstTableSecondTable(long soId, long coId) {
		_secondTableLocalService.deleteFirstTableSecondTable(soId, coId);
	}

	@Override
	public void deleteFirstTableSecondTable(
		long soId, Example.model.SecondTable secondTable) {

		_secondTableLocalService.deleteFirstTableSecondTable(soId, secondTable);
	}

	@Override
	public void deleteFirstTableSecondTables(
		long soId, java.util.List<Example.model.SecondTable> secondTables) {

		_secondTableLocalService.deleteFirstTableSecondTables(
			soId, secondTables);
	}

	@Override
	public void deleteFirstTableSecondTables(long soId, long[] coIds) {
		_secondTableLocalService.deleteFirstTableSecondTables(soId, coIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _secondTableLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the second table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SecondTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coId the primary key of the second table
	 * @return the second table that was removed
	 * @throws PortalException if a second table with the primary key could not be found
	 */
	@Override
	public Example.model.SecondTable deleteSecondTable(long coId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _secondTableLocalService.deleteSecondTable(coId);
	}

	/**
	 * Deletes the second table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SecondTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param secondTable the second table
	 * @return the second table that was removed
	 */
	@Override
	public Example.model.SecondTable deleteSecondTable(
		Example.model.SecondTable secondTable) {

		return _secondTableLocalService.deleteSecondTable(secondTable);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _secondTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _secondTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _secondTableLocalService.dynamicQuery();
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

		return _secondTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Example.model.impl.SecondTableModelImpl</code>.
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

		return _secondTableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Example.model.impl.SecondTableModelImpl</code>.
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

		return _secondTableLocalService.dynamicQuery(
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

		return _secondTableLocalService.dynamicQueryCount(dynamicQuery);
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

		return _secondTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public Example.model.SecondTable fetchSecondTable(long coId) {
		return _secondTableLocalService.fetchSecondTable(coId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _secondTableLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the soIds of the first tables associated with the second table.
	 *
	 * @param coId the coId of the second table
	 * @return long[] the soIds of first tables associated with the second table
	 */
	@Override
	public long[] getFirstTablePrimaryKeys(long coId) {
		return _secondTableLocalService.getFirstTablePrimaryKeys(coId);
	}

	@Override
	public java.util.List<Example.model.SecondTable> getFirstTableSecondTables(
		long soId) {

		return _secondTableLocalService.getFirstTableSecondTables(soId);
	}

	@Override
	public java.util.List<Example.model.SecondTable> getFirstTableSecondTables(
		long soId, int start, int end) {

		return _secondTableLocalService.getFirstTableSecondTables(
			soId, start, end);
	}

	@Override
	public java.util.List<Example.model.SecondTable> getFirstTableSecondTables(
		long soId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Example.model.SecondTable> orderByComparator) {

		return _secondTableLocalService.getFirstTableSecondTables(
			soId, start, end, orderByComparator);
	}

	@Override
	public int getFirstTableSecondTablesCount(long soId) {
		return _secondTableLocalService.getFirstTableSecondTablesCount(soId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _secondTableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _secondTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _secondTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the second table with the primary key.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table
	 * @throws PortalException if a second table with the primary key could not be found
	 */
	@Override
	public Example.model.SecondTable getSecondTable(long coId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _secondTableLocalService.getSecondTable(coId);
	}

	/**
	 * Returns a range of all the second tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Example.model.impl.SecondTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of second tables
	 * @param end the upper bound of the range of second tables (not inclusive)
	 * @return the range of second tables
	 */
	@Override
	public java.util.List<Example.model.SecondTable> getSecondTables(
		int start, int end) {

		return _secondTableLocalService.getSecondTables(start, end);
	}

	/**
	 * Returns the number of second tables.
	 *
	 * @return the number of second tables
	 */
	@Override
	public int getSecondTablesCount() {
		return _secondTableLocalService.getSecondTablesCount();
	}

	@Override
	public boolean hasFirstTableSecondTable(long soId, long coId) {
		return _secondTableLocalService.hasFirstTableSecondTable(soId, coId);
	}

	@Override
	public boolean hasFirstTableSecondTables(long soId) {
		return _secondTableLocalService.hasFirstTableSecondTables(soId);
	}

	@Override
	public void setFirstTableSecondTables(long soId, long[] coIds) {
		_secondTableLocalService.setFirstTableSecondTables(soId, coIds);
	}

	/**
	 * Updates the second table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SecondTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param secondTable the second table
	 * @return the second table that was updated
	 */
	@Override
	public Example.model.SecondTable updateSecondTable(
		Example.model.SecondTable secondTable) {

		return _secondTableLocalService.updateSecondTable(secondTable);
	}

	@Override
	public SecondTableLocalService getWrappedService() {
		return _secondTableLocalService;
	}

	@Override
	public void setWrappedService(
		SecondTableLocalService secondTableLocalService) {

		_secondTableLocalService = secondTableLocalService;
	}

	private SecondTableLocalService _secondTableLocalService;

}