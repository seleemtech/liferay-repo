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

package SendOtpService.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SendDbLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SendDbLocalService
 * @generated
 */
public class SendDbLocalServiceWrapper
	implements SendDbLocalService, ServiceWrapper<SendDbLocalService> {

	public SendDbLocalServiceWrapper() {
		this(null);
	}

	public SendDbLocalServiceWrapper(SendDbLocalService sendDbLocalService) {
		_sendDbLocalService = sendDbLocalService;
	}

	@Override
	public SendOtpService.model.SendDb addData(String Name, long mobileNumber) {
		return _sendDbLocalService.addData(Name, mobileNumber);
	}

	/**
	 * Adds the send db to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SendDbLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sendDb the send db
	 * @return the send db that was added
	 */
	@Override
	public SendOtpService.model.SendDb addSendDb(
		SendOtpService.model.SendDb sendDb) {

		return _sendDbLocalService.addSendDb(sendDb);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sendDbLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new send db with the primary key. Does not add the send db to the database.
	 *
	 * @param sendId the primary key for the new send db
	 * @return the new send db
	 */
	@Override
	public SendOtpService.model.SendDb createSendDb(long sendId) {
		return _sendDbLocalService.createSendDb(sendId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sendDbLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the send db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SendDbLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sendId the primary key of the send db
	 * @return the send db that was removed
	 * @throws PortalException if a send db with the primary key could not be found
	 */
	@Override
	public SendOtpService.model.SendDb deleteSendDb(long sendId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sendDbLocalService.deleteSendDb(sendId);
	}

	/**
	 * Deletes the send db from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SendDbLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sendDb the send db
	 * @return the send db that was removed
	 */
	@Override
	public SendOtpService.model.SendDb deleteSendDb(
		SendOtpService.model.SendDb sendDb) {

		return _sendDbLocalService.deleteSendDb(sendDb);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _sendDbLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _sendDbLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sendDbLocalService.dynamicQuery();
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

		return _sendDbLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendOtpService.model.impl.SendDbModelImpl</code>.
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

		return _sendDbLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendOtpService.model.impl.SendDbModelImpl</code>.
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

		return _sendDbLocalService.dynamicQuery(
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

		return _sendDbLocalService.dynamicQueryCount(dynamicQuery);
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

		return _sendDbLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public SendOtpService.model.SendDb fetchSendDb(long sendId) {
		return _sendDbLocalService.fetchSendDb(sendId);
	}

	/**
	 * Returns the send db with the matching UUID and company.
	 *
	 * @param uuid the send db's UUID
	 * @param companyId the primary key of the company
	 * @return the matching send db, or <code>null</code> if a matching send db could not be found
	 */
	@Override
	public SendOtpService.model.SendDb fetchSendDbByUuidAndCompanyId(
		String uuid, long companyId) {

		return _sendDbLocalService.fetchSendDbByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sendDbLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sendDbLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sendDbLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sendDbLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the send db with the primary key.
	 *
	 * @param sendId the primary key of the send db
	 * @return the send db
	 * @throws PortalException if a send db with the primary key could not be found
	 */
	@Override
	public SendOtpService.model.SendDb getSendDb(long sendId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sendDbLocalService.getSendDb(sendId);
	}

	/**
	 * Returns the send db with the matching UUID and company.
	 *
	 * @param uuid the send db's UUID
	 * @param companyId the primary key of the company
	 * @return the matching send db
	 * @throws PortalException if a matching send db could not be found
	 */
	@Override
	public SendOtpService.model.SendDb getSendDbByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sendDbLocalService.getSendDbByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the send dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendOtpService.model.impl.SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @return the range of send dbs
	 */
	@Override
	public java.util.List<SendOtpService.model.SendDb> getSendDbs(
		int start, int end) {

		return _sendDbLocalService.getSendDbs(start, end);
	}

	/**
	 * Returns the number of send dbs.
	 *
	 * @return the number of send dbs
	 */
	@Override
	public int getSendDbsCount() {
		return _sendDbLocalService.getSendDbsCount();
	}

	/**
	 * Updates the send db in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SendDbLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sendDb the send db
	 * @return the send db that was updated
	 */
	@Override
	public SendOtpService.model.SendDb updateSendDb(
		SendOtpService.model.SendDb sendDb) {

		return _sendDbLocalService.updateSendDb(sendDb);
	}

	@Override
	public SendDbLocalService getWrappedService() {
		return _sendDbLocalService;
	}

	@Override
	public void setWrappedService(SendDbLocalService sendDbLocalService) {
		_sendDbLocalService = sendDbLocalService;
	}

	private SendDbLocalService _sendDbLocalService;

}