public List<Document> search(long companyId, String keywords) throws SearchException{
        System.out.println("-----BusLocalServiceImpl search called------");
        List<Document> documentsList = new ArrayList<>();
        SearchContext searchContext = new SearchContext();
        searchContext.setAndSearch(false);


        Map<String, Serializable> attributes = new HashMap<String, Serializable>();

        attributes.put("name", keywords);
        attributes.put("type", keywords);

        searchContext.setAttributes(attributes);
        searchContext.setCompanyId(companyId);
        searchContext.setKeywords(keywords);

        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                Bus.class);
        
        Hits hits = indexer.search(searchContext);

		Document[] documents = hits.getDocs();

		if (documents.length != 0) {
			Collections.addAll(documentsList, documents);
		}
		
		System.out.println("after bus doc length"+documentsList.size());
	    System.out.println("after bus doc "+documentsList.toString());

        System.out.println("-----BusLocalServiceImpl search called------"+indexer);
      List<Document> userDocumentList =  getUserDocument(companyId, keywords);
      documentsList.addAll(userDocumentList);
      
		System.out.println("after merged"+documentsList.size());
	    System.out.println("after merged doc "+documentsList.toString());

        return documentsList;
    }
	
	private List<Document> getUserDocument(long companyId, String keywords) throws SearchException{
	        List<Document> documentsList = new ArrayList<>();
	        SearchContext searchContext = new SearchContext();
	        searchContext.setAndSearch(false);


	        Map<String, Serializable> attributes = new HashMap<String, Serializable>();

	        attributes.put("firstName", keywords);
	        attributes.put("lastName", keywords);
	        attributes.put("screenName", keywords);
	        attributes.put("jobTitle", keywords);

	        searchContext.setAttributes(attributes);
	        searchContext.setCompanyId(companyId);
	        searchContext.setKeywords(keywords);

	        Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
	                User.class);
	        
	        Hits hits = indexer.search(searchContext);

			Document[] documents = hits.getDocs();

			if (documents.length != 0) {
				Collections.addAll(documentsList, documents);
			}
			
			System.out.println("after User doc length"+documentsList.size());
		    System.out.println("after User doc "+documentsList.toString());

			return documentsList;
	}


package com.ews.search.web.command;

import com.ews.bus.sl.model.Bus;
import com.ews.bus.sl.service.BusLocalServiceUtil;
import com.ews.search.web.constants.SearchWebPortletKeys;
import com.ews.search.web.dto.ResultDTO;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.LinkedList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + SearchWebPortletKeys.SEARCHRESULT,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class DefaultSearchResultsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyword = ServiceContextThreadLocal.getServiceContext().getRequest().getParameter("keyword");
		_log.info("keyword >>>>>>>>>>>>>>>." + keyword);
		List<ResultDTO> resultDTOs = new LinkedList<>();
		if (Validator.isNotNull(keyword)) {
			try {
				List<Document> resultsDocs = BusLocalServiceUtil.search(themeDisplay.getCompanyId(), keyword);

				_log.info("resultsDocs >>>>>>>>>>>>>>>." + resultsDocs.size());
				_log.info("main class name " + Bus.class.getName());
				resultsDocs.stream().forEach(doc -> {
					ResultDTO resultDTO = new ResultDTO();
					if (doc.get("entryClassName").equals(Bus.class.getName())) {
						resultDTO = setBusResult(Long.valueOf(doc.get("entryClassPK")));
						resultDTOs.add(resultDTO);
					} else if (doc.get("entryClassName").equals(User.class.getName())) {
						resultDTO = setUserResult(Long.valueOf(doc.get("entryClassPK")));
						resultDTOs.add(resultDTO);
					}

				});
			} catch (SearchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		renderRequest.setAttribute("resultDTOs", resultDTOs);
		return "/search-results/view.jsp";
	}

	private ResultDTO setUserResult(long primaryKey) {
		ResultDTO resultDTO = new ResultDTO();
		User user = UserLocalServiceUtil.fetchUser(primaryKey);

		if (Validator.isNull(user)) {
			return resultDTO;
		}

		resultDTO.setPrimaryKey(user.getUserId());
		resultDTO.setModel("User");
		resultDTO.setName(user.getFullName());
		resultDTO.setCreatedBy(getCreatedByUserName(user.getUserId()));
		return resultDTO;

	}

	private ResultDTO setBusResult(long primaryKey) {
		ResultDTO resultDTO = new ResultDTO();
		Bus bus = BusLocalServiceUtil.fetchBus(primaryKey);

		if (Validator.isNull(bus)) {
			return resultDTO;
		}

		resultDTO.setPrimaryKey(bus.getPrimaryKey());
		resultDTO.setModel("Bus");
		resultDTO.setName(bus.getName());
		resultDTO.setType(bus.getType());
		resultDTO.setCreatedBy(getCreatedByUserName(bus.getUserId()));
		return resultDTO;

	}

	private String getCreatedByUserName(long primaryKey) {
		User user = UserLocalServiceUtil.fetchUser(primaryKey);
		return user != null ? user.getFullName() : StringPool.BLANK;
	}

	private static final Log _log = LogFactoryUtil.getLog(DefaultSearchResultsMVCRenderCommand.class);
}

