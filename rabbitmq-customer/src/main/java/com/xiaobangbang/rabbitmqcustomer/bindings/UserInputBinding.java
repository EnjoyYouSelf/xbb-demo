package com.xiaobangbang.rabbitmqcustomer.bindings;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

/**
 * @author peyazhuo
 * @date 2020/1/7
 */
@Service("userInputBinding")
public interface UserInputBinding{
    String IN_OUT_CHANNEL = "userInput";
    String TEST_CHANNEL = "testInput";

    @Input(UserInputBinding.IN_OUT_CHANNEL)
    SubscribableChannel userInput();

    @Input(UserInputBinding.TEST_CHANNEL)
    SubscribableChannel testInput();
}
