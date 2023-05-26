<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Stick+No+Bills:wght@200;600&display=swap" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div id="wrapper">
<div class="shadow-div">
	<header id="banner" role="banner">
	<div class="main-head">
		<div id="heading">
			<div aria-level="1" class="site-title" role="heading">
				<a class="${logo_css_class}  href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" class="logo_custom_css" src="${site_logo}" width="${site_logo_width}" />
				</a>

				<#if show_site_name>
					<span class="site-name" id="custom_site" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			</div>
		</div>
<div>
		<#if !is_signed_in>
			<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if>
		

		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
		</div>
		</div>
	</header>
</div>
	<section id="content">
		<h2 class="hide-accessible sr-only" role="heading" aria-level="1">${the_title}</h2>

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
<p class="powered-by">
			<@liferay.language_format
				arguments='<a href="http://www.liferay.com" rel="external">Liferay</a>'
				key="powered-by-x"
			/>
		</p>
	<div id="footer" role="contentinfo">
	<div class="footer-main">
	<div>
	<span>About BCM</span>
     <span class="second-span">Consistency is the true foundation of trust.Either keep your promises or do not make them.</span>
	 <div>
	      <ul class="social-link">
	          <li>
	               <a>
	                  <span class="icon-twitter"></span>
	               </a>
	          </li>
	      </ul>
		  <ul class="social-link">
	          <li>
	               <a>
	                  <span class="icon-facebook"></span>
	               </a>
	          </li>
	      </ul>
		  <ul class="social-link">
	          <li>
	               <a>
	                  <span class="icon-instagram"></span>
	               </a>
	          </li>
	      </ul>
	 </div>

	</div>

	<div>
	<span>Links</span>
	<div class="second-main-div">
     <span class="icon-long-arrow-right main"></i><a href="">Home</a></span>
	 <span class="icon-long-arrow-right main"><a href="">About</a></span>
	 <span class="icon-long-arrow-right main"><a href="">Service</a></span>
	 <span class="icon-long-arrow-right main"><a href="">Contact Us</a></span>
	 </div>
	</div>

<div>
	<span>Have A Questions</span>
	<div class="second-main-div">
	<div class="inside-span">
     <i class="icon-map-marker"></i><span>Kammanahalli 84 Bangloore 560084</span></div>
<div class="inside-span">	 
 <i class="icon-phone main"></i><span>709033 6666
</span>
</div>
<div class="inside-span">
<i class="icon-envelope main"></i><span>sales@buraqcreditmanagement.com</span></div>
</div>
	
	
	
	</div>
		
	</div>

	<div class="last-copy-div">Copyright ©2022 All rights reserved | This template is made by Seleem</div>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>