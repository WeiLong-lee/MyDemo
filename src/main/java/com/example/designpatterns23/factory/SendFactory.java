package com.example.designpatterns23.factory;

import com.example.designpatterns23.factory.common.MailSender;
import com.example.designpatterns23.factory.common.Sender;
import com.example.designpatterns23.factory.common.SmsSender;

/**
 * Created by LiWeilong on 2018/5/7.
 *  工厂类
 */
public class SendFactory {

    public Sender produce(String type){
          if ("mail".equals(type)) {
                     return new MailSender();
                 } else if ("sms".equals(type)) {
                     return new SmsSender();
                 } else {
                    System.out.println("请输入正确的类型!");
                    return null;
                 }
    }

    /***
     *  多个工厂类
     * @return
     */

    public Sender produceMail(){
       return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}
