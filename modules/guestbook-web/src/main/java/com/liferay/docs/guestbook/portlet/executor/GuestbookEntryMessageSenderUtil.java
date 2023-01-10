package com.liferay.docs.guestbook.portlet.executor;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.background.task.service.BackgroundTaskLocalServiceUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskThreadLocal;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;

import java.util.Date;

public class GuestbookEntryMessageSenderUtil {
    void sendNotification(int status) throws Exception {
            long backgroundTaskId = BackgroundTaskThreadLocal.getBackgroundTaskId();
        System.out.println("Task is: "+backgroundTaskId);
        User user = UserLocalServiceUtil.getUser(BackgroundTaskLocalServiceUtil.getBackgroundTask(backgroundTaskId).getUserId());
        sendUserNotification(user, _getPayloadJSONObject(backgroundTaskId, status));
    }
    public JSONObject _getPayloadJSONObject(
            long backgroundTaskId, int status) {

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

        jsonObject.put(
                "backgroundTaskId", backgroundTaskId
        ).put(
                "status", status
        );

        return jsonObject;
    }

    private void sendUserNotification(User user, JSONObject payload) throws PortalException {
        ExportImportUserNotificationHandler hndlr = new ExportImportUserNotificationHandler();

        UserNotificationEvent notification =
                UserNotificationEventLocalServiceUtil.createUserNotificationEvent(
                        CounterLocalServiceUtil.increment()
                );

        notification.setCompanyId(user.getCompanyId());
        notification.setUserId(user.getUserId());
        notification.setPayload(payload.toString());
        notification.setDeliveryType(UserNotificationDeliveryConstants.TYPE_WEBSITE);
        notification.setTimestamp(new Date().getTime());
        notification.setArchived(false);
        notification.setDelivered(true);
        notification.setType(hndlr.getPortletId());

        UserNotificationEventLocalServiceUtil.addUserNotificationEvent(notification);
    }
}
