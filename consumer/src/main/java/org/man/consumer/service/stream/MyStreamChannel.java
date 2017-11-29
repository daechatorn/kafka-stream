package org.man.consumer.service.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MyStreamChannel {
    String MYINPUT = "myinput";

    @Input("myinput")
    MessageChannel myinput();
}
