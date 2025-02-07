package com.ews.bus.sl.internal.search;

import com.ews.bus.sl.model.Bus;
import com.ews.bus.sl.service.BusLocalService;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerList;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerListFactory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.search.localization.SearchLocalizationHelper;
import com.liferay.portal.search.model.uid.UIDFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = Indexer.class)
public class BusIndexer extends BaseIndexer<Bus> {

	public static final String CLASS_NAME = Bus.class.getName();

	public BusIndexer() {
		setDefaultSelectedFieldNames(Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT, Field.ENTRY_CLASS_NAME,
				Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE,
				Field.UID);
		setDefaultSelectedLocalizedFieldNames(Field.CONTENT, Field.TITLE);
		setPermissionAware(false);
		setFilterSearch(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected void doDelete(Bus bus) throws Exception {
		deleteDocument(bus.getCompanyId(), bus.getBusId());

	}

	@Override
	protected Document doGetDocument(Bus bus) throws Exception {
		Document document = getBaseModelDocument(CLASS_NAME, bus);

		document.addKeyword(Field.NAME, bus.getName());
		document.addKeyword(Field.ENTRY_CLASS_PK, bus.getBusId());
		document.addKeyword("type", bus.getType());

		_log.info("Bus " + bus + " indexed successfully");

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		Summary summary = createSummary(
				document, Field.ENTRY_CLASS_PK, Field.NAME);

			summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
		_log.info("redindex  tring className, long classPK" + className + ">>>>>>" + classPK);
		Bus bus = _busLocalService.getBus(classPK);
		doReindex(bus);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		long companyId = GetterUtil.getLong(ids[0]);
		_log.info("redindex  String[] ids companyId " + companyId);
		_reindex(companyId);

	}

	@Override
	protected void doReindex(Bus bus) throws Exception {
		_log.info("redindex bus" + bus.getName());
		_indexWriterHelper.updateDocument(bus.getCompanyId(), getDocument(bus));

	}

//	@Activate
//	protected void activate(BundleContext bundleContext) {
//		_serviceTrackerList = ServiceTrackerListFactory.open(bundleContext,
//				(Class<ModelDocumentContributor<Bus>>) (Class<?>) ModelDocumentContributor.class,
//				"(indexer.class.name=com.ews.bus.sl.model.Bus)");
//	}

//	@Deactivate
//	protected void deactivate() {
//		_serviceTrackerList.close();
//	}

	@Override
	public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext)
			throws Exception {
		_log.info("postProcessContextBooleanFilter >>>>>>>>>>>>>>>>>" + searchContext.getKeywords());
		//addStatus(contextBooleanFilter, searchContext);
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext) throws Exception {
		_log.info("postProcessSearchQuery >>>>>>>>>>>>>>>>>" + searchContext.getKeywords());
		
		addSearchTerm(searchQuery, searchContext, Field.NAME, false);
		addSearchTerm(searchQuery, searchContext, Field.ENTRY_CLASS_PK, false);
		addSearchTerm(searchQuery, searchContext, "type", false);
	}

	private void _reindex(long companyId) throws Exception {
		ActionableDynamicQuery actionableDynamicQuery = _busLocalService.getActionableDynamicQuery();

		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery
				.setPerformActionMethod((Bus bus) -> _reindexEntries(companyId, bus.getGroupId(), bus.getBusId()));

		actionableDynamicQuery.performActions();
	}

	private void _reindexEntries(long companyId, long groupId, long busId) throws PortalException {
		_log.info("bus id >>>>>>" + busId);
		_log.info(" groupId >>>>>>" + groupId);
		_log.info("companyId >>>>>>" + busId);
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = _busLocalService
				.getIndexableActionableDynamicQuery();

//		indexableActionableDynamicQuery.setAddCriteriaMethod(
//			dynamicQuery -> {
//				Property nodeIdProperty = PropertyFactoryUtil.forName("nodeId");
//
//				dynamicQuery.add(nodeIdProperty.eq(nodeId));
//
//				Property headProperty = PropertyFactoryUtil.forName("head");
//
//				dynamicQuery.add(headProperty.eq(true));
//			});
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod((Bus bus) -> {
			try {
				Document document = getDocument(bus);
				indexableActionableDynamicQuery.addDocuments(document);
				_log.info("document.ENTRY_CLASS_PK >>>>>>" + document.get(Field.ENTRY_CLASS_PK));
				_log.info("document.NAME >>>>>>" + document.get(Field.NAME));
				_log.info("document.type >>>>>>" + document.get(Field.TYPE));
			} catch (PortalException portalException) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to Bus " + bus.getBusId(), portalException);
				}
			}
		});

		indexableActionableDynamicQuery.performActions();
	}

	private static final Log _log = LogFactoryUtil.getLog(BusIndexer.class);

	@Reference
	private IndexWriterHelper _indexWriterHelper;

	@Reference
	private Localization _localization;

	@Reference
	private SearchLocalizationHelper _searchLocalizationHelper;

	@Reference
	private BusLocalService _busLocalService;

	@Reference
	protected UIDFactory uidFactory;

	private ServiceTrackerList<ModelDocumentContributor<Bus>> _serviceTrackerList;

}
