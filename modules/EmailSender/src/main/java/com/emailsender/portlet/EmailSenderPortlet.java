package com.emailsender.portlet;

import com.emailsender.constants.EmailSenderPortletKeys;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.mail.InternetAddressUtil;
import com.liferay.petra.mail.MailEngine;
import com.liferay.petra.mail.MailEngineException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmailSender",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmailSenderPortletKeys.EMAILSENDER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmailSenderPortlet extends MVCPortlet {
	public void sendMails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortletException, AddressException {
		// TODO Auto-generated method stub
	String tomail=ParamUtil.getString(actionRequest, "tomail");
	String frommail=ParamUtil.getString(actionRequest, "frommail");
	String body=ParamUtil.getString(actionRequest, "body");
		InternetAddress to=new InternetAddress(tomail);
		InternetAddress from=new InternetAddress(frommail);
		System.out.println("from mail"+from);
		System.out.println("to mail"+to);
		MailMessage mail=new MailMessage();
		mail.setFrom(from);
		mail.setBody(body);
		mail.setTo(to);
		MailServiceUtil.sendEmail(mail);
	}
}