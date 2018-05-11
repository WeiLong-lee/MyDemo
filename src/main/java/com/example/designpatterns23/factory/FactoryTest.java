package com.example.designpatterns23.factory;

import com.example.designpatterns23.factory.SendFactory;
import com.example.designpatterns23.factory.common.Sender;

/**
 * Created by LiWeilong on 2018/5/7.
 */
public class FactoryTest {

	 public static void main(String[] args) {
	        /*** 普通工厂类 */
             SendFactory factory = new SendFactory();
             Sender sender = factory.produce("sms");
             sender.Send();

             /*** 多个工厂类 */
             Sender sender1 =  factory.produceMail();
             sender1.Send();


       }


}
