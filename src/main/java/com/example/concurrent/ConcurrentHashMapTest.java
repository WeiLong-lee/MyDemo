package com.example.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by LiWeilong on 2018/3/26.
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap conHashMap = new  ConcurrentHashMap();
        conHashMap.put("a",1000);

        Integer value = (Integer) conHashMap.get("a");
        System.out.println(value);
    }

}
