package com.icici.mfa.otp.web.override.filter;

import com.icici.mfa.otp.web.override.policy.ContentSecurityPolicyNonceManager;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mahammed Seleem
 */
@Component(property = { "after-filter=Portal CORS Servlet Filter", "dispatcher=FORWARD", "dispatcher=REQUEST",
		"servlet-context-name=", "servlet-filter-name=Content Security Policy Filter",
		"url-pattern=/*" }, service = Filter.class)
public class CSPFilter extends BasePortalFilter {
	public static final String POLICYS = "default-src 'self'; "
		    + "script-src 'self' http://localhost:8080 '[$NONCE$]'; "
		    + "style-src 'self' http://localhost:8080 '[$NONCE$]'; "
		    + "base-uri 'self';";
	
	public static final String POLICYSS = "default-src 'none'; "
		    + "script-src 'self' 'unsafe-inline' 'unsafe-eval'; "
		    + "connect-src 'self'; "
		    + "img-src 'self'; "
		    + "style-src 'self' 'unsafe-inline'; "  
		    + "frame-ancestors 'self'; "
		    + "form-action 'self';";


	public static final String POLICY = "default-src 'self'; " + "base-uri 'self'; "
			+ "connect-src 'self' http://localhost:8080; "
			+ "script-src 'self' 'strict-dynamic' 'unsafe-eval' http://localhost:8080; "
			+ "style-src 'self' 'unsafe-inline'; " + "font-src 'self'; " + "img-src 'self'; " + "frame-src 'self';";

	@Override
	protected Log getLog() {

		return LogFactoryUtil.getLog(getClass());
	}

	@Override
	protected void processFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws Exception {
		getLog().info("is csp filter>>>>>>>>>>>>");
		String nonce = _contentSecurityPolicyNonceManager.setNonce(httpServletRequest);
		getLog().info("nonce >>>>>>>>" + nonce);
		try {
			httpServletResponse.setContentType("text/html; charset=UTF-8");

			// Set Content Security Policy header
			String policy = CSPFilter.POLICYSS;
			policy = StringUtil.replace(policy, "[$NONCE$]", "nonce-" + nonce);
			httpServletResponse.setHeader("Content-Security-Policy", policy);

			   // Add X-XSS-Protection header
	        httpServletResponse.setHeader("X-XSS-Protection", "1; mode=block");

	        // Add Strict-Transport-Security header
	        httpServletResponse.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
	        
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		} finally {
			_contentSecurityPolicyNonceManager.cleanUpNonce(httpServletRequest);
		}
	}

	@Reference
	private ContentSecurityPolicyNonceManager _contentSecurityPolicyNonceManager;

}
