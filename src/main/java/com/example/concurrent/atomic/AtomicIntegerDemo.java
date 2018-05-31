package com.example.concurrent.atomic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by LiWeilong on 2018/5/30.
 */
public class AtomicIntegerDemo {

   AtomicInteger atomicInteger = new AtomicInteger(100);

   ExecutorService executorService = Executors.newCachedThreadPool();

}
