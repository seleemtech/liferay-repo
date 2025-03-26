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
