package org.man.sender.service.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyStreamChannel {
    String MYOUTPUT = "myoutput";

    @Output("myoutput")
    MessageChannel myoutput();
}
