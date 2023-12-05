package com.comments.headless.internal.resource.v1_0;

import com.comments.headless.dto.v1_0.Notification;
import com.comments.headless.resource.v1_0.NotificationResource;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.TimeZoneThreadLocal;
import com.liferay.portal.vulcan.pagination.Page;

import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author E2Software-011
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/notification.properties", scope = ServiceScope.PROTOTYPE, service = NotificationResource.class)
public class NotificationResourceImpl extends BaseNotificationResourceImpl {

	@Override
	public Page<Notification> getUserNotification(Long userId) throws Exception {
		_log.info("Getting Current UserId" + userId);
		List<Notification> notificationPage = new ArrayList<>();
		List<UserNotificationEvent> UserNotificationEventList = UserNotificationEventLocalServiceUtil
				.getDeliveredUserNotificationEvents(userId, UserNotificationDeliveryConstants.TYPE_WEBSITE, true, false,
						-1, -1);
		UserNotificationEventList.stream().forEach(notification -> notificationPage.add(_toNotification(notification)));
		Collections.reverse(notificationPage);
		return Page.of(notificationPage);
	}

	private Notification _toNotification(UserNotificationEvent userNotificationEvent) {
		return new Notification() {
			{
				notificationEventId = userNotificationEvent.getUserNotificationEventId();
				try {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
					notificationMessage = jsonObject.getString("notificationMessage");
					workflowTaskId = jsonObject.getLong("workflowTaskId");
				} catch (Exception e) {
					_log.error("Unable to print notificationMessage");
				}
				Locale locale = LocaleThreadLocal.getDefaultLocale();
				TimeZone timeZone = TimeZoneThreadLocal.getDefaultTimeZone();
				Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
				notificationTimeDiff = Time.getRelativeTimeDescription(userNotificationEvent.getTimestamp(), locale,
						timeZone, dateFormatDateTime);
				userId = userNotificationEvent.getUserId();

			}
		};
	}

	private Log _log = LogFactoryUtil.getLog(NotificationResourceImpl.class);

}