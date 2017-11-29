package org.man.sender.service;

import org.man.sender.model.request.NotificationRequest;
import org.man.sender.model.response.NotificationResponse;
import org.man.sender.service.stream.MyStreamChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding({Source.class, MyStreamChannel.class})
public class NotificationService {

    @Autowired
    Source source;

    @Autowired
    MyStreamChannel myStreamChannel;

    public NotificationResponse sendNotification(NotificationRequest notificationRequest){
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setNotificationMessage(notificationRequest.getNotificationMessage());
        notificationResponse.setStatus("COMPLETED");
        //source and method output is default interface for pushing message to Kafka
        source.output().send(MessageBuilder.withPayload(notificationRequest).build());

        return notificationResponse;
    }

    public NotificationResponse sendNotificationWithMyStreamChannel(NotificationRequest notificationRequest){
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setNotificationMessage(notificationRequest.getNotificationMessage());
        notificationResponse.setStatus("COMPLETED");
        //output is default interface for pushing message to Kafka
        myStreamChannel.myoutput().send(MessageBuilder.withPayload(notificationRequest).build());

        return notificationResponse;
    }

}
