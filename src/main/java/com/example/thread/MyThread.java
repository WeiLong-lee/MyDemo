package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by LiWeilong on 2018/1/10.
 */
public class MyThread {

    private volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        final MyThread mt = new MyThread();

        final CountDownLatch latch = new CountDownLatch(1);

        new Thread(){
            @Override
            public void run(){
                System.out.println("线程1启动");
                if(mt.size() !=5){
                   try{
                       latch.await();
                   }catch(InterruptedException e){
                       e.printStackTrace();
                   }
                }
                System.out.println("线程1结束");
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                for(int i=0;i<10;i++){
                    mt.add(i);
                    System.out.println("线程2添加了"+i);
                    if(mt.size() ==4){
                        //打开门闩，让另一个线程得以执行
                        latch.countDown();
                    }
                }
            }
        }.start();

    }

}
