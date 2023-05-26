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

package com.master.data.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentMappingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMappingLocalService
 * @generated
 */
public class DocumentMappingLocalServiceWrapper
	implements DocumentMappingLocalService,
			   ServiceWrapper<DocumentMappingLocalService> {

	public DocumentMappingLocalServiceWrapper(
		DocumentMappingLocalService documentMappingLocalService) {

		_documentMappingLocalService = documentMappingLocalService;
	}

	/**
	 * Adds the document mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentMapping the document mapping
	 * @return the document mapping that was added
	 */
	@Override
	public com.master.data.model.DocumentMapping addDocumentMapping(
		com.master.data.model.DocumentMapping documentMapping) {

		return _documentMappingLocalService.addDocumentMapping(documentMapping);
	}

	@Override
	public com.master.data.model.DocumentMapping AddorUpdateDocument(
		long recordId, String moduleName, long classPk, String documentName,
		long documentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _documentMappingLocalService.AddorUpdateDocument(
			recordId, moduleName, classPk, documentName, documentId,
			serviceContext);
	}

	/**
	 * Creates a new document mapping with the primary key. Does not add the document mapping to the database.
	 *
	 * @param recordId the primary key for the new document mapping
	 * @return the new document mapping
	 */
	@Override
	public com.master.data.model.DocumentMapping createDocumentMapping(
		long recordId) {

		return _documentMappingLocalService.createDocumentMapping(recordId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMappingLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the document mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentMapping the document mapping
	 * @return the document mapping that was removed
	 */
	@Override
	public com.master.data.model.DocumentMapping deleteDocumentMapping(
		com.master.data.model.DocumentMapping documentMapping) {

		return _documentMappingLocalService.deleteDocumentMapping(
			documentMapping);
	}

	/**
	 * Deletes the document mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping that was removed
	 * @throws PortalException if a document mapping with the primary key could not be found
	 */
	@Override
	public com.master.data.model.DocumentMapping deleteDocumentMapping(
			long recordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMappingLocalService.deleteDocumentMapping(recordId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMappingLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _documentMappingLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _documentMappingLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentMappingLocalService.dynamicQuery();
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

		return _documentMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.master.data.model.impl.DocumentMappingModelImpl</code>.
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

		return _documentMappingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.master.data.model.impl.DocumentMappingModelImpl</code>.
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

		return _documentMappingLocalService.dynamicQuery(
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

		return _documentMappingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _documentMappingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.master.data.model.DocumentMapping fetchDocumentMapping(
		long recordId) {

		return _documentMappingLocalService.fetchDocumentMapping(recordId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _documentMappingLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the document mapping with the primary key.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping
	 * @throws PortalException if a document mapping with the primary key could not be found
	 */
	@Override
	public com.master.data.model.DocumentMapping getDocumentMapping(
			long recordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMappingLocalService.getDocumentMapping(recordId);
	}

	/**
	 * Returns a range of all the document mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.master.data.model.impl.DocumentMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document mappings
	 * @param end the upper bound of the range of document mappings (not inclusive)
	 * @return the range of document mappings
	 */
	@Override
	public java.util.List<com.master.data.model.DocumentMapping>
		getDocumentMappings(int start, int end) {

		return _documentMappingLocalService.getDocumentMappings(start, end);
	}

	/**
	 * Returns the number of document mappings.
	 *
	 * @return the number of document mappings
	 */
	@Override
	public int getDocumentMappingsCount() {
		return _documentMappingLocalService.getDocumentMappingsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _documentMappingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentMappingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentMappingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the document mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentMapping the document mapping
	 * @return the document mapping that was updated
	 */
	@Override
	public com.master.data.model.DocumentMapping updateDocumentMapping(
		com.master.data.model.DocumentMapping documentMapping) {

		return _documentMappingLocalService.updateDocumentMapping(
			documentMapping);
	}

	@Override
	public DocumentMappingLocalService getWrappedService() {
		return _documentMappingLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentMappingLocalService documentMappingLocalService) {

		_documentMappingLocalService = documentMappingLocalService;
	}

	private DocumentMappingLocalService _documentMappingLocalService;

}