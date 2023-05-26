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

package com.att.hr.onestop.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NewsEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NewsEntryLocalService
 * @generated
 */
public class NewsEntryLocalServiceWrapper
	implements NewsEntryLocalService, ServiceWrapper<NewsEntryLocalService> {

	public NewsEntryLocalServiceWrapper() {
		this(null);
	}

	public NewsEntryLocalServiceWrapper(
		NewsEntryLocalService newsEntryLocalService) {

		_newsEntryLocalService = newsEntryLocalService;
	}

	/**
	 * Adds the news entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsEntry the news entry
	 * @return the news entry that was added
	 */
	@Override
	public com.att.hr.onestop.services.model.NewsEntry addNewsEntry(
		com.att.hr.onestop.services.model.NewsEntry newsEntry) {

		return _newsEntryLocalService.addNewsEntry(newsEntry);
	}

	/**
	 * Creates a new news entry with the primary key. Does not add the news entry to the database.
	 *
	 * @param newsEntryId the primary key for the new news entry
	 * @return the new news entry
	 */
	@Override
	public com.att.hr.onestop.services.model.NewsEntry createNewsEntry(
		long newsEntryId) {

		return _newsEntryLocalService.createNewsEntry(newsEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteEntries(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_newsEntryLocalService.deleteEntries(groupId);
	}

	@Override
	public com.att.hr.onestop.services.model.NewsEntry deleteEntry(
			com.att.hr.onestop.services.model.NewsEntry newsEntry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsEntryLocalService.deleteEntry(newsEntry);
	}

	/**
	 * Deletes the news entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry that was removed
	 * @throws PortalException if a news entry with the primary key could not be found
	 */
	@Override
	public com.att.hr.onestop.services.model.NewsEntry deleteNewsEntry(
			long newsEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsEntryLocalService.deleteNewsEntry(newsEntryId);
	}

	/**
	 * Deletes the news entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsEntry the news entry
	 * @return the news entry that was removed
	 */
	@Override
	public com.att.hr.onestop.services.model.NewsEntry deleteNewsEntry(
		com.att.hr.onestop.services.model.NewsEntry newsEntry) {

		return _newsEntryLocalService.deleteNewsEntry(newsEntry);
	}

	@Override
	public com.att.hr.onestop.services.model.NewsEntry deleteNewsEntryById(
			long newsEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _newsEntryLocalService.deleteNewsEntryById(newsEntryId);
	}

	@Override
	public void deleteNewsEntryByPillarLayout(long plId) {
		_newsEntryLocalService.deleteNewsEntryByPillarLayout(plId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _newsEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _newsEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _newsEntryLocalService.dynamicQuery();
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

		return _newsEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.att.hr.onestop.services.model.impl.NewsEntryModelImpl</code>.
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

		return _newsEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.att.hr.onestop.services.model.impl.NewsEntryModelImpl</code>.
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

		return _newsEntryLocalService.dynamicQuery(
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

		return _newsEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _newsEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.att.hr.onestop.services.model.NewsEntry fetchNewsEntry(
		long newsEntryId) {

		return _newsEntryLocalService.fetchNewsEntry(newsEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _newsEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _newsEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the news entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.att.hr.onestop.services.model.impl.NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of news entries
	 */
	@Override
	public java.util.List<com.att.hr.onestop.services.model.NewsEntry>
		getNewsEntries(int start, int end) {

		return _newsEntryLocalService.getNewsEntries(start, end);
	}

	/**
	 * Returns the number of news entries.
	 *
	 * @return the number of news entries
	 */
	@Override
	public int getNewsEntriesCount() {
		return _newsEntryLocalService.getNewsEntriesCount();
	}

	/**
	 * Returns the news entry with the primary key.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry
	 * @throws PortalException if a news entry with the primary key could not be found
	 */
	@Override
	public com.att.hr.onestop.services.model.NewsEntry getNewsEntry(
			long newsEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsEntryLocalService.getNewsEntry(newsEntryId);
	}

	@Override
	public java.util.List<com.att.hr.onestop.services.model.NewsEntry>
		getNewsEntryByGroupId(long groupId) {

		return _newsEntryLocalService.getNewsEntryByGroupId(groupId);
	}

	@Override
	public java.util.List<com.att.hr.onestop.services.model.NewsEntry>
		getNewsEntryByStatus(long groupId, int status) {

		return _newsEntryLocalService.getNewsEntryByStatus(groupId, status);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _newsEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.att.hr.onestop.services.model.NewsEntry publishToLive(
			long newsEntryId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsEntryLocalService.publishToLive(
			newsEntryId, serviceContext);
	}

	@Override
	public com.att.hr.onestop.services.model.NewsEntry toggleArchiveNewsEntry(
			long newsEntryId, boolean archive)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _newsEntryLocalService.toggleArchiveNewsEntry(
			newsEntryId, archive);
	}

	@Override
	public com.att.hr.onestop.services.model.NewsEntry updateNewsEntry(
			long newsEntryId, String newsTitle, String newsSummary,
			String newsContent, long newsImageId, long newsScopeId,
			java.util.Date expireDate, boolean archive, boolean isApproved,
			boolean isAllowedInDashBoard, String ToEmail,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _newsEntryLocalService.updateNewsEntry(
			newsEntryId, newsTitle, newsSummary, newsContent, newsImageId,
			newsScopeId, expireDate, archive, isApproved, isAllowedInDashBoard,
			ToEmail, serviceContext);
	}

	/**
	 * Updates the news entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsEntry the news entry
	 * @return the news entry that was updated
	 */
	@Override
	public com.att.hr.onestop.services.model.NewsEntry updateNewsEntry(
		com.att.hr.onestop.services.model.NewsEntry newsEntry) {

		return _newsEntryLocalService.updateNewsEntry(newsEntry);
	}

	@Override
	public com.att.hr.onestop.services.model.NewsEntry updateStatus(
			long userId, long resourcePrimKey, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _newsEntryLocalService.updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	@Override
	public NewsEntryLocalService getWrappedService() {
		return _newsEntryLocalService;
	}

	@Override
	public void setWrappedService(NewsEntryLocalService newsEntryLocalService) {
		_newsEntryLocalService = newsEntryLocalService;
	}

	private NewsEntryLocalService _newsEntryLocalService;

}