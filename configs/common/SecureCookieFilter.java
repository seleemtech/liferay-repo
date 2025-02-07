package com.icici.mfa.otp.web.override.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
/**
 * @author Mahammed Seleem
 */
@Component(property = { "after-filter=Absolute Redirects Filter", "before-filter=Auto Login Filter",
		"dispatcher=FORWARD", "servlet-context-name=", "servlet-filter-name=Secure Cookie Filter",
		"url-pattern=/web/*" }, service = Filter.class)
public class SecureCookieFilter extends BaseFilter {

	@Override
	protected Log getLog() {
		return LogFactoryUtil.getLog(SecureCookieFilter.class);
	}

	@Override
	protected void processFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws Exception {

		Cookie[] cookiesList = httpServletRequest.getCookies();

		for (Cookie cookie : cookiesList) {
			String sessionCookie = cookie.getName() + "=" + cookie.getValue()
					+ "; SameSite=Strict; HttpOnly; Secure; ";
			httpServletResponse.addHeader("Set-Cookie", sessionCookie);
		}
		super.processFilter(httpServletRequest, httpServletResponse, filterChain);
	}

}
