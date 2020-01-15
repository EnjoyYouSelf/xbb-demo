package com.xiaobangbnag.pojo.dto;

import com.xiaobangbang.entity.User;

/**
 * mq消息发送实体
 * @author peyazhuo
 * @date 2020/1/9
 */
public class MessageDTO {

    /**
     *业务类型
     */
    private Integer businessType;
    /**
     *传输的数据
     */
    private String context;
    /**
     *学生
     */
    private User user;

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "businessType=" + businessType +
                ", context='" + context + '\'' +
                ", user=" + user +
                '}';
    }
}
