<#--
This file allows you to override and define new FreeMarker variables.
-->


<#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService")/>			

<#macro embedJournalArticle journalArticleTitle portletInstanceId>
	<#if validator.isNotNull(serviceLocator)>
		<#if validator.isNotNull(journalArticleLocalService)>
			<#if validator.isNotNull(journalArticleTitle) && !validator.isBlank(journalArticleTitle)>
				<#assign journalArticleUrlTitle=journalArticleTitle?lower_case?replace(" ", "-")?replace("_", "-")/>
				<#if validator.isNotNull(journalArticleUrlTitle) && !validator.isBlank(journalArticleUrlTitle)>
					<#assign journalArticle=journalArticleLocalService.fetchArticleByUrlTitle(group_id,journalArticleUrlTitle)/> 
				</#if>
			</#if>
		</#if>	
	</#if>	

  <#if validator.isNotNull(journalArticle)>	
		<#assign journalArticlePreferencesMap = 
					{
						"portletSetupPortletDecoratorId": "barebone", 
						"groupId": getterUtil.getString(group_id),
						"articleId":getterUtil.getString(journalArticle.getArticleId())
					} 
					
				/>
		<#assign journalArticlePreferences = freeMarkerPortletPreferences.getPreferences(journalArticlePreferencesMap) />
		<@liferay_portlet["runtime"]
				defaultPreferences= journalArticlePreferences
				instanceId=portletInstanceId
				portletProviderAction=portletProviderAction.VIEW
				portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" 
				/>
	</#if>
</#macro>