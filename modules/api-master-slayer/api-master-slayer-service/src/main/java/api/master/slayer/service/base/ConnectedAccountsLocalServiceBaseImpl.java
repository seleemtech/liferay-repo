/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.base;

import api.master.slayer.model.ConnectedAccounts;
import api.master.slayer.service.ConnectedAccountsLocalService;
import api.master.slayer.service.ConnectedAccountsLocalServiceUtil;
import api.master.slayer.service.persistence.ApiMapKeyPersistence;
import api.master.slayer.service.persistence.ConnectedAccountsPersistence;
import api.master.slayer.service.persistence.MasterMetaDataPersistence;
import api.master.slayer.service.persistence.MasterUrlPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the connected accounts local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link api.master.slayer.service.impl.ConnectedAccountsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see api.master.slayer.service.impl.ConnectedAccountsLocalServiceImpl
 * @generated
 */
public abstract class ConnectedAccountsLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, ConnectedAccountsLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ConnectedAccountsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ConnectedAccountsLocalServiceUtil</code>.
	 */

	/**
	 * Adds the connected accounts to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectedAccountsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectedAccounts the connected accounts
	 * @return the connected accounts that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ConnectedAccounts addConnectedAccounts(
		ConnectedAccounts connectedAccounts) {

		connectedAccounts.setNew(true);

		return connectedAccountsPersistence.update(connectedAccounts);
	}

	/**
	 * Creates a new connected accounts with the primary key. Does not add the connected accounts to the database.
	 *
	 * @param c_accountId the primary key for the new connected accounts
	 * @return the new connected accounts
	 */
	@Override
	@Transactional(enabled = false)
	public ConnectedAccounts createConnectedAccounts(long c_accountId) {
		return connectedAccountsPersistence.create(c_accountId);
	}

	/**
	 * Deletes the connected accounts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectedAccountsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts that was removed
	 * @throws PortalException if a connected accounts with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ConnectedAccounts deleteConnectedAccounts(long c_accountId)
		throws PortalException {

		return connectedAccountsPersistence.remove(c_accountId);
	}

	/**
	 * Deletes the connected accounts from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectedAccountsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectedAccounts the connected accounts
	 * @return the connected accounts that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ConnectedAccounts deleteConnectedAccounts(
		ConnectedAccounts connectedAccounts) {

		return connectedAccountsPersistence.remove(connectedAccounts);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return connectedAccountsPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ConnectedAccounts.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return connectedAccountsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return connectedAccountsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return connectedAccountsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return connectedAccountsPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return connectedAccountsPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ConnectedAccounts fetchConnectedAccounts(long c_accountId) {
		return connectedAccountsPersistence.fetchByPrimaryKey(c_accountId);
	}

	/**
	 * Returns the connected accounts matching the UUID and group.
	 *
	 * @param uuid the connected accounts's UUID
	 * @param groupId the primary key of the group
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchConnectedAccountsByUuidAndGroupId(
		String uuid, long groupId) {

		return connectedAccountsPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the connected accounts with the primary key.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts
	 * @throws PortalException if a connected accounts with the primary key could not be found
	 */
	@Override
	public ConnectedAccounts getConnectedAccounts(long c_accountId)
		throws PortalException {

		return connectedAccountsPersistence.findByPrimaryKey(c_accountId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			connectedAccountsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ConnectedAccounts.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("c_accountId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			connectedAccountsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ConnectedAccounts.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"c_accountId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			connectedAccountsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ConnectedAccounts.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("c_accountId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<ConnectedAccounts>() {

				@Override
				public void performAction(ConnectedAccounts connectedAccounts)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, connectedAccounts);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(ConnectedAccounts.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return connectedAccountsPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement ConnectedAccountsLocalServiceImpl#deleteConnectedAccounts(ConnectedAccounts) to avoid orphaned data");
		}

		return connectedAccountsLocalService.deleteConnectedAccounts(
			(ConnectedAccounts)persistedModel);
	}

	@Override
	public BasePersistence<ConnectedAccounts> getBasePersistence() {
		return connectedAccountsPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return connectedAccountsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the connected accountses matching the UUID and company.
	 *
	 * @param uuid the UUID of the connected accountses
	 * @param companyId the primary key of the company
	 * @return the matching connected accountses, or an empty list if no matches were found
	 */
	@Override
	public List<ConnectedAccounts> getConnectedAccountsesByUuidAndCompanyId(
		String uuid, long companyId) {

		return connectedAccountsPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of connected accountses matching the UUID and company.
	 *
	 * @param uuid the UUID of the connected accountses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching connected accountses, or an empty list if no matches were found
	 */
	@Override
	public List<ConnectedAccounts> getConnectedAccountsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return connectedAccountsPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the connected accounts matching the UUID and group.
	 *
	 * @param uuid the connected accounts's UUID
	 * @param groupId the primary key of the group
	 * @return the matching connected accounts
	 * @throws PortalException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts getConnectedAccountsByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return connectedAccountsPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the connected accountses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of connected accountses
	 */
	@Override
	public List<ConnectedAccounts> getConnectedAccountses(int start, int end) {
		return connectedAccountsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of connected accountses.
	 *
	 * @return the number of connected accountses
	 */
	@Override
	public int getConnectedAccountsesCount() {
		return connectedAccountsPersistence.countAll();
	}

	/**
	 * Updates the connected accounts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConnectedAccountsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param connectedAccounts the connected accounts
	 * @return the connected accounts that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ConnectedAccounts updateConnectedAccounts(
		ConnectedAccounts connectedAccounts) {

		return connectedAccountsPersistence.update(connectedAccounts);
	}

	@Deactivate
	protected void deactivate() {
		ConnectedAccountsLocalServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ConnectedAccountsLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		connectedAccountsLocalService = (ConnectedAccountsLocalService)aopProxy;

		ConnectedAccountsLocalServiceUtil.setService(
			connectedAccountsLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ConnectedAccountsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ConnectedAccounts.class;
	}

	protected String getModelClassName() {
		return ConnectedAccounts.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				connectedAccountsPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected ApiMapKeyPersistence apiMapKeyPersistence;

	protected ConnectedAccountsLocalService connectedAccountsLocalService;

	@Reference
	protected ConnectedAccountsPersistence connectedAccountsPersistence;

	@Reference
	protected MasterMetaDataPersistence masterMetaDataPersistence;

	@Reference
	protected MasterUrlPersistence masterUrlPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		ConnectedAccountsLocalServiceBaseImpl.class);

}