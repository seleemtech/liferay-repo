/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.base;

import api.master.slayer.model.MasterMetaData;
import api.master.slayer.service.MasterMetaDataLocalService;
import api.master.slayer.service.MasterMetaDataLocalServiceUtil;
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
 * Provides the base implementation for the master meta data local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link api.master.slayer.service.impl.MasterMetaDataLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see api.master.slayer.service.impl.MasterMetaDataLocalServiceImpl
 * @generated
 */
public abstract class MasterMetaDataLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, MasterMetaDataLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>MasterMetaDataLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>MasterMetaDataLocalServiceUtil</code>.
	 */

	/**
	 * Adds the master meta data to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterMetaDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterMetaData the master meta data
	 * @return the master meta data that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MasterMetaData addMasterMetaData(MasterMetaData masterMetaData) {
		masterMetaData.setNew(true);

		return masterMetaDataPersistence.update(masterMetaData);
	}

	/**
	 * Creates a new master meta data with the primary key. Does not add the master meta data to the database.
	 *
	 * @param mmdId the primary key for the new master meta data
	 * @return the new master meta data
	 */
	@Override
	@Transactional(enabled = false)
	public MasterMetaData createMasterMetaData(long mmdId) {
		return masterMetaDataPersistence.create(mmdId);
	}

	/**
	 * Deletes the master meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterMetaDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data that was removed
	 * @throws PortalException if a master meta data with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MasterMetaData deleteMasterMetaData(long mmdId)
		throws PortalException {

		return masterMetaDataPersistence.remove(mmdId);
	}

	/**
	 * Deletes the master meta data from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterMetaDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterMetaData the master meta data
	 * @return the master meta data that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MasterMetaData deleteMasterMetaData(MasterMetaData masterMetaData) {
		return masterMetaDataPersistence.remove(masterMetaData);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return masterMetaDataPersistence.dslQuery(dslQuery);
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
			MasterMetaData.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return masterMetaDataPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterMetaDataModelImpl</code>.
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

		return masterMetaDataPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterMetaDataModelImpl</code>.
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

		return masterMetaDataPersistence.findWithDynamicQuery(
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
		return masterMetaDataPersistence.countWithDynamicQuery(dynamicQuery);
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

		return masterMetaDataPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public MasterMetaData fetchMasterMetaData(long mmdId) {
		return masterMetaDataPersistence.fetchByPrimaryKey(mmdId);
	}

	/**
	 * Returns the master meta data matching the UUID and group.
	 *
	 * @param uuid the master meta data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData fetchMasterMetaDataByUuidAndGroupId(
		String uuid, long groupId) {

		return masterMetaDataPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the master meta data with the primary key.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data
	 * @throws PortalException if a master meta data with the primary key could not be found
	 */
	@Override
	public MasterMetaData getMasterMetaData(long mmdId) throws PortalException {
		return masterMetaDataPersistence.findByPrimaryKey(mmdId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(masterMetaDataLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MasterMetaData.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("mmdId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			masterMetaDataLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(MasterMetaData.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("mmdId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(masterMetaDataLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MasterMetaData.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("mmdId");
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
			new ActionableDynamicQuery.PerformActionMethod<MasterMetaData>() {

				@Override
				public void performAction(MasterMetaData masterMetaData)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, masterMetaData);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(MasterMetaData.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return masterMetaDataPersistence.create(
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
				"Implement MasterMetaDataLocalServiceImpl#deleteMasterMetaData(MasterMetaData) to avoid orphaned data");
		}

		return masterMetaDataLocalService.deleteMasterMetaData(
			(MasterMetaData)persistedModel);
	}

	@Override
	public BasePersistence<MasterMetaData> getBasePersistence() {
		return masterMetaDataPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return masterMetaDataPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the master meta datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the master meta datas
	 * @param companyId the primary key of the company
	 * @return the matching master meta datas, or an empty list if no matches were found
	 */
	@Override
	public List<MasterMetaData> getMasterMetaDatasByUuidAndCompanyId(
		String uuid, long companyId) {

		return masterMetaDataPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of master meta datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the master meta datas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching master meta datas, or an empty list if no matches were found
	 */
	@Override
	public List<MasterMetaData> getMasterMetaDatasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return masterMetaDataPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the master meta data matching the UUID and group.
	 *
	 * @param uuid the master meta data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching master meta data
	 * @throws PortalException if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData getMasterMetaDataByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return masterMetaDataPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the master meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>api.master.slayer.model.impl.MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @return the range of master meta datas
	 */
	@Override
	public List<MasterMetaData> getMasterMetaDatas(int start, int end) {
		return masterMetaDataPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of master meta datas.
	 *
	 * @return the number of master meta datas
	 */
	@Override
	public int getMasterMetaDatasCount() {
		return masterMetaDataPersistence.countAll();
	}

	/**
	 * Updates the master meta data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterMetaDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterMetaData the master meta data
	 * @return the master meta data that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MasterMetaData updateMasterMetaData(MasterMetaData masterMetaData) {
		return masterMetaDataPersistence.update(masterMetaData);
	}

	@Deactivate
	protected void deactivate() {
		MasterMetaDataLocalServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			MasterMetaDataLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		masterMetaDataLocalService = (MasterMetaDataLocalService)aopProxy;

		MasterMetaDataLocalServiceUtil.setService(masterMetaDataLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return MasterMetaDataLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return MasterMetaData.class;
	}

	protected String getModelClassName() {
		return MasterMetaData.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = masterMetaDataPersistence.getDataSource();

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

	protected MasterMetaDataLocalService masterMetaDataLocalService;

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
		MasterMetaDataLocalServiceBaseImpl.class);

}