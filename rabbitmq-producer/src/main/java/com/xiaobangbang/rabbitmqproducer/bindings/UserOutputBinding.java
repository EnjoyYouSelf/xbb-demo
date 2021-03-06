package com.xiaobangbang.rabbitmqproducer.bindings;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

/**
 * @author peyazhuo
 * @date 2020/1/7
 */
@Service("userOutputBinding")
public interface UserOutputBinding {
    String OUT_PUT_CHANNEL = "userOutput";
    String TEST_CHANNEL = "testOutput";


    @Output(UserOutputBinding.OUT_PUT_CHANNEL)
    MessageChannel userOutput();

    @Output(UserOutputBinding.TEST_CHANNEL)
    MessageChannel testOutput();
}
