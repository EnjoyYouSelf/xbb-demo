package com.xiaobangbang.rabbitmqproducer.senders;

import com.xiaobangbang.rabbitmqproducer.bindings.UserOutputBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author peyazhuo
 * @date 2020/1/7
 */
@EnableBinding(UserOutputBinding.class)
@Service("userSender")
public class UserSender{
    @Resource
    private UserOutputBinding userOutputBinding;

    public boolean sendMessage(Object messageBody, Map<String,Object> messageHeader){
        //设置请求头map类型 请求体：自定义类
        MessageHeaders mhs = new MessageHeaders(messageHeader);
        //MessageHeaderAccessor messageHeaderAccessor = new MessageHeaderAccessor();
        //发送请求信息
        Message<Object> message = MessageBuilder.createMessage(messageBody, mhs);
        boolean sendStatus = userOutputBinding.userOutput().send(message);
        return sendStatus;
    }


}
