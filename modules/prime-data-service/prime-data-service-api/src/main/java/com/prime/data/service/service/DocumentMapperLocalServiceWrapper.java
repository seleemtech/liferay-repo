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

package com.prime.data.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentMapperLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMapperLocalService
 * @generated
 */
public class DocumentMapperLocalServiceWrapper
	implements DocumentMapperLocalService,
			   ServiceWrapper<DocumentMapperLocalService> {

	public DocumentMapperLocalServiceWrapper(
		DocumentMapperLocalService documentMapperLocalService) {

		_documentMapperLocalService = documentMapperLocalService;
	}

	/**
	 * Adds the document mapper to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentMapperLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentMapper the document mapper
	 * @return the document mapper that was added
	 */
	@Override
	public com.prime.data.service.model.DocumentMapper addDocumentMapper(
		com.prime.data.service.model.DocumentMapper documentMapper) {

		return _documentMapperLocalService.addDocumentMapper(documentMapper);
	}

	@Override
	public com.prime.data.service.model.DocumentMapper AddOrUpdateDocument(
		long recordId, String moduleName, long classPk, String documentName,
		long documentId, java.util.Date createdDate,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _documentMapperLocalService.AddOrUpdateDocument(
			recordId, moduleName, classPk, documentName, documentId,
			createdDate, modifiedDate, serviceContext);
	}

	/**
	 * Creates a new document mapper with the primary key. Does not add the document mapper to the database.
	 *
	 * @param recordId the primary key for the new document mapper
	 * @return the new document mapper
	 */
	@Override
	public com.prime.data.service.model.DocumentMapper createDocumentMapper(
		long recordId) {

		return _documentMapperLocalService.createDocumentMapper(recordId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMapperLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the document mapper from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentMapperLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentMapper the document mapper
	 * @return the document mapper that was removed
	 */
	@Override
	public com.prime.data.service.model.DocumentMapper deleteDocumentMapper(
		com.prime.data.service.model.DocumentMapper documentMapper) {

		return _documentMapperLocalService.deleteDocumentMapper(documentMapper);
	}

	/**
	 * Deletes the document mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentMapperLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper that was removed
	 * @throws PortalException if a document mapper with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.DocumentMapper deleteDocumentMapper(
			long recordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMapperLocalService.deleteDocumentMapper(recordId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMapperLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _documentMapperLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _documentMapperLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentMapperLocalService.dynamicQuery();
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

		return _documentMapperLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.DocumentMapperModelImpl</code>.
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

		return _documentMapperLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.DocumentMapperModelImpl</code>.
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

		return _documentMapperLocalService.dynamicQuery(
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

		return _documentMapperLocalService.dynamicQueryCount(dynamicQuery);
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

		return _documentMapperLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.DocumentMapper fetchDocumentMapper(
		long recordId) {

		return _documentMapperLocalService.fetchDocumentMapper(recordId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _documentMapperLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the document mapper with the primary key.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper
	 * @throws PortalException if a document mapper with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.DocumentMapper getDocumentMapper(
			long recordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMapperLocalService.getDocumentMapper(recordId);
	}

	/**
	 * Returns a range of all the document mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.DocumentMapperModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document mappers
	 * @param end the upper bound of the range of document mappers (not inclusive)
	 * @return the range of document mappers
	 */
	@Override
	public java.util.List<com.prime.data.service.model.DocumentMapper>
		getDocumentMappers(int start, int end) {

		return _documentMapperLocalService.getDocumentMappers(start, end);
	}

	/**
	 * Returns the number of document mappers.
	 *
	 * @return the number of document mappers
	 */
	@Override
	public int getDocumentMappersCount() {
		return _documentMapperLocalService.getDocumentMappersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _documentMapperLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentMapperLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMapperLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the document mapper in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentMapperLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentMapper the document mapper
	 * @return the document mapper that was updated
	 */
	@Override
	public com.prime.data.service.model.DocumentMapper updateDocumentMapper(
		com.prime.data.service.model.DocumentMapper documentMapper) {

		return _documentMapperLocalService.updateDocumentMapper(documentMapper);
	}

	@Override
	public DocumentMapperLocalService getWrappedService() {
		return _documentMapperLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentMapperLocalService documentMapperLocalService) {

		_documentMapperLocalService = documentMapperLocalService;
	}

	private DocumentMapperLocalService _documentMapperLocalService;

}