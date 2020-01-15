package com.xiaobangbang.rabbitmqcustomer.receiver;

import com.xiaobangbang.rabbitmqcustomer.bindings.UserInputBinding;
import com.xiaobangbnag.pojo.dto.MessageDTO;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author peyazhuo
 * @date 2020/1/7
 */
@EnableBinding(UserInputBinding.class)
@Service("userReceiver")
public class UserReceiver {

    @Resource
    private UserInputBinding userInputBinding;


    @StreamListener(value = UserInputBinding.IN_OUT_CHANNEL)
    public void userRevice(Message message){
        MessageHeaders headers = message.getHeaders();
        System.out.println(headers);
        System.out.println(message);
    }

    @StreamListener(value = UserInputBinding.TEST_CHANNEL)
    public void userRevice2(Message<MessageDTO> message){
        MessageHeaders headers = message.getHeaders();
        System.out.println("============================");
        System.out.println(headers);
        System.out.println(message.getPayload().toString());
    }

}
