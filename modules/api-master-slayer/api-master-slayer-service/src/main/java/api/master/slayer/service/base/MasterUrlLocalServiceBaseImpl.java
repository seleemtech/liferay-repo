/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.base;

import api.master.slayer.model.MasterUrl;
import api.master.slayer.service.MasterUrlLocalService;
import api.master.slayer.service.MasterUrlLocalServiceUtil;
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
 * Provides the base implementation for the master url local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link api.master.slayer.service.impl.MasterUrlLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see api.master.slayer.service.impl.MasterUrlLocalServiceImpl
 * @generated
 */
public abstract class MasterUrlLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, MasterUrlLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>MasterUrlLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>MasterUrlLocalServiceUtil</code>.
	 */

	/**
	 * Adds the master url to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterUrlLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterUrl the master url
	 * @return the master url that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MasterUrl addMasterUrl(MasterUrl masterUrl) {
		masterUrl.setNew(true);

		return masterUrlPersistence.update(masterUrl);
	}

	/**
	 * Creates a new master url with the primary key. Does not add the master url to the database.
	 *
	 * @param masterUrlId the primary key for the new master url
	 * @return the new master url
	 */
	@Override
	@Transactional(enabled = false)
	public MasterUrl createMasterUrl(long masterUrlId) {
		return masterUrlPersistence.create(masterUrlId);
	}

	/**
	 * Deletes the master url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterUrlLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url that was removed
	 * @throws PortalException if a master url with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MasterUrl deleteMasterUrl(long masterUrlId) throws PortalException {
		return masterUrlPersistence.remove(masterUrlId);
	}

	/**
	 * Deletes the master url from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterUrlLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterUrl the master url
	 * @return the master url that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MasterUrl deleteMasterUrl(MasterUrl masterUrl) {
		return masterUrlPersistence.remove(masterUrl);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return masterUrlPersistence.dslQuery(dslQuery);
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
			MasterUrl.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return masterUrlPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterUrlModelImpl</code>.
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

		return masterUrlPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterUrlModelImpl</code>.
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

		return masterUrlPersistence.findWithDynamicQuery(
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
		return masterUrlPersistence.countWithDynamicQuery(dynamicQuery);
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

		return masterUrlPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public MasterUrl fetchMasterUrl(long masterUrlId) {
		return masterUrlPersistence.fetchByPrimaryKey(masterUrlId);
	}

	/**
	 * Returns the master url matching the UUID and group.
	 *
	 * @param uuid the master url's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public MasterUrl fetchMasterUrlByUuidAndGroupId(String uuid, long groupId) {
		return masterUrlPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the master url with the primary key.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url
	 * @throws PortalException if a master url with the primary key could not be found
	 */
	@Override
	public MasterUrl getMasterUrl(long masterUrlId) throws PortalException {
		return masterUrlPersistence.findByPrimaryKey(masterUrlId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(masterUrlLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MasterUrl.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("masterUrlId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			masterUrlLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(MasterUrl.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"masterUrlId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(masterUrlLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MasterUrl.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("masterUrlId");
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
			new ActionableDynamicQuery.PerformActionMethod<MasterUrl>() {

				@Override
				public void performAction(MasterUrl masterUrl)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, masterUrl);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(MasterUrl.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return masterUrlPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement MasterUrlLocalServiceImpl#deleteMasterUrl(MasterUrl) to avoid orphaned data");
		}

		return masterUrlLocalService.deleteMasterUrl((MasterUrl)persistedModel);
	}

	@Override
	public BasePersistence<MasterUrl> getBasePersistence() {
		return masterUrlPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return masterUrlPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the master urls matching the UUID and company.
	 *
	 * @param uuid the UUID of the master urls
	 * @param companyId the primary key of the company
	 * @return the matching master urls, or an empty list if no matches were found
	 */
	@Override
	public List<MasterUrl> getMasterUrlsByUuidAndCompanyId(
		String uuid, long companyId) {

		return masterUrlPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of master urls matching the UUID and company.
	 *
	 * @param uuid the UUID of the master urls
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching master urls, or an empty list if no matches were found
	 */
	@Override
	public List<MasterUrl> getMasterUrlsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator) {

		return masterUrlPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the master url matching the UUID and group.
	 *
	 * @param uuid the master url's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master url
	 * @throws PortalException if a matching master url could not be found
	 */
	@Override
	public MasterUrl getMasterUrlByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return masterUrlPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the master urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @return the range of master urls
	 */
	@Override
	public List<MasterUrl> getMasterUrls(int start, int end) {
		return masterUrlPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of master urls.
	 *
	 * @return the number of master urls
	 */
	@Override
	public int getMasterUrlsCount() {
		return masterUrlPersistence.countAll();
	}

	/**
	 * Updates the master url in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterUrlLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterUrl the master url
	 * @return the master url that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MasterUrl updateMasterUrl(MasterUrl masterUrl) {
		return masterUrlPersistence.update(masterUrl);
	}

	@Deactivate
	protected void deactivate() {
		MasterUrlLocalServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			MasterUrlLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		masterUrlLocalService = (MasterUrlLocalService)aopProxy;

		MasterUrlLocalServiceUtil.setService(masterUrlLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return MasterUrlLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return MasterUrl.class;
	}

	protected String getModelClassName() {
		return MasterUrl.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = masterUrlPersistence.getDataSource();

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

	@Reference
	protected ConnectedAccountsPersistence connectedAccountsPersistence;

	@Reference
	protected MasterMetaDataPersistence masterMetaDataPersistence;

	protected MasterUrlLocalService masterUrlLocalService;

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
		MasterUrlLocalServiceBaseImpl.class);

}