package com.example.designpatterns23.factory.abstractdemo;

import com.example.designpatterns23.factory.common.Sender;

/**
 * Created by LiWeilong on 2018/5/7.
 *   抽象工厂接口
 */
public interface Provider {
    public Sender produce();
}
