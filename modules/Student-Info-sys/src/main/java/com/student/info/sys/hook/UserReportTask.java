package com.student.info.sys.hook;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

@Component(immediate = true, property = { "cron.expression=0 27 19 ? * MON-FRI *" // scheduler runs every day at 1pm
}, service = UserReportTask.class)
public class UserReportTask extends BaseMessageListener {

	private static final Log _log = LogFactoryUtil.getLog(UserReportTask.class);

	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub 0 0/05 1/1 1/1 * ?
		System.out.println("came to do proccess Schudular Task:::::::::::::::::::");
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			Date today = new Date();
			ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, portalClassLoader);
			Criterion criterion = RestrictionsFactoryUtil.between("createDate", calendar.getTime(), today);
			dynamicQuery.add(criterion);

			List<User> users = UserLocalServiceUtil.dynamicQuery(dynamicQuery);

			StringBuilder bodyBuilder = new StringBuilder();

			bodyBuilder.append("<table>")
			    .append("<tr>")
			    .append("<td colspan='4'><h2>The following users were created today:</h2></td>")
			    .append("</tr>")
			    .append("<tr>")
			    .append("<th>User Name</th>")
			    .append("<th>First Name</th>")
			    .append("<th>Last Name</th>")
			    .append("<th>Date of Birth</th>")
			    .append("</tr>");

			for (User user : users) {
			    StringBuilder userBuilder = new StringBuilder();

			    userBuilder.append("<tr>")
			        .append("<td>").append(user.getScreenName()).append("</td>")
			        .append("<td>").append(user.getFirstName()).append("</td>")
			        .append("<td>").append(user.getLastName()).append("</td>")
			        .append("<td>").append(user.getBirthday()).append("</td>")
			        .append("</tr>");

			    bodyBuilder.append(userBuilder);
			}

			bodyBuilder.append("</table>");

			String body = bodyBuilder.toString();
			
			System.out.println("User Schudular Task 2::::::::::::::::::::::");

		
			System.out.println("User Schudular Task 3::::::::::::::::::::::");
			String subject = "Daily User Report (" + today.toString() + ")";


			MailMessage mailMessage = new MailMessage();
			System.out.println("User Schudular Task 4::::::::::::::::::::::");
			InternetAddress to = new InternetAddress("mseleem969@gmail.com");
			InternetAddress from = new InternetAddress("seleem@esquareinfo.com");
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);

			MailServiceUtil.sendEmail(mailMessage);
			_log.debug("Mail sent successfully::::::::::::::::");
		} catch (Exception e) {
			_log.error("Failed to send user report email", e);
			throw new MessageListenerException(e);
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {
		System.out.println("User Schudular Task:::::::::::::::::::");
		try {
			String cronExpression = GetterUtil.getString(properties.get("cron.expression"), "cronExpression");
			_log.info(" cronExpression: " + cronExpression);

			String listenerClass = getClass().getName();
			Trigger jobTrigger = TriggerFactoryUtil.createTrigger(listenerClass, listenerClass, cronExpression);
			_log.info("job jobTrigger :::::::::::::::::: " + jobTrigger);
			SchedulerEntryImpl schedulerEntryImpl = new SchedulerEntryImpl(listenerClass, jobTrigger);

			SchedulerEngineHelperUtil.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
			_log.info(" cronExpression activate completed: " + cronExpression);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	@Deactivate
	protected void deactive() {
		SchedulerEngineHelperUtil.unregister(this);
	}

}
