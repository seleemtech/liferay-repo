package com.student.info.sys.hook;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = ModelListener.class)
public class SendEmail extends BaseModelListener<User> {
	@Override
	public void onAfterCreate(User user) throws ModelListenerException {
		// Send an email to the new user
		String emailAddress = user.getEmailAddress();
		String password = user.getPasswordUnencrypted();
		String fromAddress = "seleem@esquareinfo.com";
		System.out.println("onafterEmail:::::" + emailAddress);
		System.out.println("onafterPass:::::" + password);
		String subject = "Welcome to our site!";
		String body = PropsUtil.get("admin.email.user.added.body");
		MailMessage mailMessage = new MailMessage();
		try {
			InternetAddress to = new InternetAddress(emailAddress);
			InternetAddress from = new InternetAddress(fromAddress);
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			
			body = StringBundler.concat( StringPool.NEW_LINE, "Username: ", emailAddress,
					StringPool.NEW_LINE, "Password: ", password, StringPool.NEW_LINE, StringPool.NEW_LINE);
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
