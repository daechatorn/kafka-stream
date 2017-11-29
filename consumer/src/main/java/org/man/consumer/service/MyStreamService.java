package org.man.consumer.service;

import org.man.consumer.model.response.NotificationResponse;
import org.man.consumer.service.stream.MyStreamChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(MyStreamChannel.class)
public class MyStreamService {

    @Autowired
    MyStreamChannel myStreamChannel;

    @StreamListener(MyStreamChannel.MYINPUT)
    public void received(NotificationResponse response) {
        System.out.println("Man ::: "+response.getNotificationMessage());
    }

}
