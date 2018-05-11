package com.example.designpatterns23.factory.common;

/**
 * Created by LiWeilong on 2018/5/7.
 */
public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
