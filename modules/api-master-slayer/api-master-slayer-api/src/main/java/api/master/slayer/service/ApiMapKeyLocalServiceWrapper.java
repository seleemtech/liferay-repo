/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ApiMapKeyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApiMapKeyLocalService
 * @generated
 */
public class ApiMapKeyLocalServiceWrapper
	implements ApiMapKeyLocalService, ServiceWrapper<ApiMapKeyLocalService> {

	public ApiMapKeyLocalServiceWrapper() {
		this(null);
	}

	public ApiMapKeyLocalServiceWrapper(
		ApiMapKeyLocalService apiMapKeyLocalService) {

		_apiMapKeyLocalService = apiMapKeyLocalService;
	}

	/**
	 * Adds the api map key to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApiMapKeyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apiMapKey the api map key
	 * @return the api map key that was added
	 */
	@Override
	public api.master.slayer.model.ApiMapKey addApiMapKey(
		api.master.slayer.model.ApiMapKey apiMapKey) {

		return _apiMapKeyLocalService.addApiMapKey(apiMapKey);
	}

	/**
	 * Creates a new api map key with the primary key. Does not add the api map key to the database.
	 *
	 * @param apiMapKeyId the primary key for the new api map key
	 * @return the new api map key
	 */
	@Override
	public api.master.slayer.model.ApiMapKey createApiMapKey(long apiMapKeyId) {
		return _apiMapKeyLocalService.createApiMapKey(apiMapKeyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiMapKeyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the api map key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApiMapKeyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apiMapKey the api map key
	 * @return the api map key that was removed
	 */
	@Override
	public api.master.slayer.model.ApiMapKey deleteApiMapKey(
		api.master.slayer.model.ApiMapKey apiMapKey) {

		return _apiMapKeyLocalService.deleteApiMapKey(apiMapKey);
	}

	/**
	 * Deletes the api map key with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApiMapKeyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key that was removed
	 * @throws PortalException if a api map key with the primary key could not be found
	 */
	@Override
	public api.master.slayer.model.ApiMapKey deleteApiMapKey(long apiMapKeyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiMapKeyLocalService.deleteApiMapKey(apiMapKeyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiMapKeyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _apiMapKeyLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _apiMapKeyLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _apiMapKeyLocalService.dynamicQuery();
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

		return _apiMapKeyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.ApiMapKeyModelImpl</code>.
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

		return _apiMapKeyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.ApiMapKeyModelImpl</code>.
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

		return _apiMapKeyLocalService.dynamicQuery(
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

		return _apiMapKeyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _apiMapKeyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public api.master.slayer.model.ApiMapKey fetchApiMapKey(long apiMapKeyId) {
		return _apiMapKeyLocalService.fetchApiMapKey(apiMapKeyId);
	}

	/**
	 * Returns the api map key matching the UUID and group.
	 *
	 * @param uuid the api map key's UUID
	 * @param groupId the primary key of the group
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	@Override
	public api.master.slayer.model.ApiMapKey fetchApiMapKeyByUuidAndGroupId(
		String uuid, long groupId) {

		return _apiMapKeyLocalService.fetchApiMapKeyByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _apiMapKeyLocalService.getActionableDynamicQuery();
	}

	@Override
	public api.master.slayer.model.ApiMapKey getApiKeyData(String name) {
		return _apiMapKeyLocalService.getApiKeyData(name);
	}

	/**
	 * Returns the api map key with the primary key.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key
	 * @throws PortalException if a api map key with the primary key could not be found
	 */
	@Override
	public api.master.slayer.model.ApiMapKey getApiMapKey(long apiMapKeyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiMapKeyLocalService.getApiMapKey(apiMapKeyId);
	}

	/**
	 * Returns the api map key matching the UUID and group.
	 *
	 * @param uuid the api map key's UUID
	 * @param groupId the primary key of the group
	 * @return the matching api map key
	 * @throws PortalException if a matching api map key could not be found
	 */
	@Override
	public api.master.slayer.model.ApiMapKey getApiMapKeyByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiMapKeyLocalService.getApiMapKeyByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the api map keys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @return the range of api map keys
	 */
	@Override
	public java.util.List<api.master.slayer.model.ApiMapKey> getApiMapKeys(
		int start, int end) {

		return _apiMapKeyLocalService.getApiMapKeys(start, end);
	}

	@Override
	public java.util.List<api.master.slayer.model.ApiMapKey>
		getApiMapKeysByUserId(long userId) {

		return _apiMapKeyLocalService.getApiMapKeysByUserId(userId);
	}

	/**
	 * Returns the number of api map keys.
	 *
	 * @return the number of api map keys
	 */
	@Override
	public int getApiMapKeysCount() {
		return _apiMapKeyLocalService.getApiMapKeysCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _apiMapKeyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _apiMapKeyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _apiMapKeyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the api map key in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ApiMapKeyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param apiMapKey the api map key
	 * @return the api map key that was updated
	 */
	@Override
	public api.master.slayer.model.ApiMapKey updateApiMapKey(
		api.master.slayer.model.ApiMapKey apiMapKey) {

		return _apiMapKeyLocalService.updateApiMapKey(apiMapKey);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _apiMapKeyLocalService.getBasePersistence();
	}

	@Override
	public ApiMapKeyLocalService getWrappedService() {
		return _apiMapKeyLocalService;
	}

	@Override
	public void setWrappedService(ApiMapKeyLocalService apiMapKeyLocalService) {
		_apiMapKeyLocalService = apiMapKeyLocalService;
	}

	private ApiMapKeyLocalService _apiMapKeyLocalService;

}