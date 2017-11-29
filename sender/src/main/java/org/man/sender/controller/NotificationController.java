package org.man.sender.controller;

import org.man.sender.model.request.NotificationRequest;
import org.man.sender.model.response.NotificationResponse;
import org.man.sender.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping("/notifications/v1")
    public NotificationResponse payPost(@RequestBody NotificationRequest request) {
        System.out.println("Called payPost");
        return notificationService.sendNotification(request);
    }

    @PostMapping("/notifications/v2")
    public NotificationResponse payPostWithMyStreamChannel(@RequestBody NotificationRequest request) {
        System.out.println("Called payPost");
        return notificationService.sendNotificationWithMyStreamChannel(request);
    }
}
