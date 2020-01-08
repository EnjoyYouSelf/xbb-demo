package com.xiaobangbang.rabbitmqcustomer.receiver;

import com.xiaobangbang.rabbitmqcustomer.bindings.UserInputBinding;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @author peyazhuo
 * @date 2020/1/7
 */
@EnableBinding(UserInputBinding.class)
@Service("userReceiver")
public class UserReceiver {

    @Autowired
    private UserInputBinding userInputBinding;


    @StreamListener(UserInputBinding.IN_OUT_CHANNEL)
    public void userRevice(Message message){
        MessageProperties messageProperties = message.getMessageProperties();
        System.out.println(messageProperties.getHeaders());

        System.out.println(message);


    }

}
