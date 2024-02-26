/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import api.master.slayer.model.ApiMapKey;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ApiMapKey. This utility wraps
 * <code>api.master.slayer.service.impl.ApiMapKeyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ApiMapKeyLocalService
 * @generated
 */
public class ApiMapKeyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>api.master.slayer.service.impl.ApiMapKeyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ApiMapKey addApiMapKey(ApiMapKey apiMapKey) {
		return getService().addApiMapKey(apiMapKey);
	}

	/**
	 * Creates a new api map key with the primary key. Does not add the api map key to the database.
	 *
	 * @param apiMapKeyId the primary key for the new api map key
	 * @return the new api map key
	 */
	public static ApiMapKey createApiMapKey(long apiMapKeyId) {
		return getService().createApiMapKey(apiMapKeyId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static ApiMapKey deleteApiMapKey(ApiMapKey apiMapKey) {
		return getService().deleteApiMapKey(apiMapKey);
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
	public static ApiMapKey deleteApiMapKey(long apiMapKeyId)
		throws PortalException {

		return getService().deleteApiMapKey(apiMapKeyId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ApiMapKey fetchApiMapKey(long apiMapKeyId) {
		return getService().fetchApiMapKey(apiMapKeyId);
	}

	/**
	 * Returns the api map key matching the UUID and group.
	 *
	 * @param uuid the api map key's UUID
	 * @param groupId the primary key of the group
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public static ApiMapKey fetchApiMapKeyByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchApiMapKeyByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static ApiMapKey getApiKeyData(String name) {
		return getService().getApiKeyData(name);
	}

	/**
	 * Returns the api map key with the primary key.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key
	 * @throws PortalException if a api map key with the primary key could not be found
	 */
	public static ApiMapKey getApiMapKey(long apiMapKeyId)
		throws PortalException {

		return getService().getApiMapKey(apiMapKeyId);
	}

	/**
	 * Returns the api map key matching the UUID and group.
	 *
	 * @param uuid the api map key's UUID
	 * @param groupId the primary key of the group
	 * @return the matching api map key
	 * @throws PortalException if a matching api map key could not be found
	 */
	public static ApiMapKey getApiMapKeyByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getApiMapKeyByUuidAndGroupId(uuid, groupId);
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
	public static List<ApiMapKey> getApiMapKeys(int start, int end) {
		return getService().getApiMapKeys(start, end);
	}

	public static List<ApiMapKey> getApiMapKeysByUserId(long userId) {
		return getService().getApiMapKeysByUserId(userId);
	}

	/**
	 * Returns the number of api map keys.
	 *
	 * @return the number of api map keys
	 */
	public static int getApiMapKeysCount() {
		return getService().getApiMapKeysCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static ApiMapKey updateApiMapKey(ApiMapKey apiMapKey) {
		return getService().updateApiMapKey(apiMapKey);
	}

	public static ApiMapKeyLocalService getService() {
		return _service;
	}

	public static void setService(ApiMapKeyLocalService service) {
		_service = service;
	}

	private static volatile ApiMapKeyLocalService _service;

}