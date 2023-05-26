<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
	<div class="sub"   id="subnavigation" >
	      <div class="container">
	           <div class="pull-left contacts">
	                <li class="list-left">
	                      <a href="" class="a_test">
	                         
<i class='fa fa-phone'></i>
	                           
	                          <span class="con-num">+91-9739316409</span>
	                      </a>
	                 </li>
	                <li class="list-left">
	                      <a href="" class="a_test">
	                         <i class='fa fa-envelope-open'></i>
	                          
	                        <span class="email">seleem@esquareinfo.com</span>
	                      </a>
	                </li>
	           </div>
	           <ul class="right_side">
	                <li class="right_list"><a href="" class="a_test">Blog</a></li>
	                <li class="right_list"><a href="" class="a_test">Latest News</a></li>
	                <li class="right_list"><a href="" class="a_test">Recent Events</a></li>
	                <li class="right_list"><a href="" class="a_test">Careers</a></li>
	                <li class="right_list"><a href="" class="a_test"><span class="con-us">Contact Us<span></a></li>
	                <li class="right_list">
	                <#if !is_signed_in>
			<a class="sign" data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if></li>
	           
	           </ul>
	      </div>
	</div>
		<div id="heading">
		    <div class="container home">
		       <div class="row-fluid">
			
			       <div class="span3">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
				</a>

				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
		           </div>
				
			
		             <div class="span9">
		           
			
			<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
		
		
		
		             </div>
		
			  </div>
		  </div>
		</div>
		
		

	<#--<@liferay_portlet["runtime"]
    portletName="com_crud_web_CrudWebPortlet_INSTANCE_cV2of8W1AtMQ"/>-->

<@embedJournalArticle journalArticleTitle="singlework" portletInstanceId="GUD32lwyqhkw" />
	</header>

	<section id="content">
		<h2 class="hide-accessible" role="heading" aria-level="1">${the_title}</h2>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>


	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>