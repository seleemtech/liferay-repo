package com.docter.web.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
@Component(
        immediate = true,
        property = {
                "servlet-context-name=",
                "servlet-filter-name= Document Filter",
                "url-pattern=/documents/*"
        },
        service = Filter.class
)
public class DocumentFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
try {
	HttpServletRequest request=(HttpServletRequest) servletRequest;
	HttpServletResponse response=(HttpServletResponse) servletResponse;
	String documentUri=(String) servletRequest.getAttribute(WebKeys.INVOKER_FILTER_URI);
	if(documentUri.contains(".pdf")) {
		long userId=(long) servletRequest.getAttribute(WebKeys.USER_ID);
		User user=UserLocalServiceUtil.getUser(userId);
		boolean isAdmin=PortalUtil.isOmniadmin(user);
		System.out.println("Admin Can access Document");
		if(!isAdmin) {
			System.out.println("Admin Cannot access Document");
			PortalUtil.sendError(403, new PrincipalException("Access to document denied."),request,response);
		}
	}
	chain.doFilter(servletRequest, servletResponse);

	
}catch (Exception e) {
	// TODO: handle exception
	_log.warn("Failed to check document access.");
	chain.doFilter(servletRequest, servletResponse);
}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	private static final Log _log=LogFactoryUtil.getLog(DocumentFilter.class);

}
