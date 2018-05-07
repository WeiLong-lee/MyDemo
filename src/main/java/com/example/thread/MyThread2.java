package com.example.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiWeilong on 2018/1/10.
 */
public class MyThread2 {

    private volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        final MyThread1 mt = new MyThread1();

        final Object object = new Object();
        new Thread(){
            @Override
            public void run(){
                System.out.println("线程2开始");
                if(mt.size() !=5){
                    synchronized (object){
                        try {
                            object.wait();
                            object.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("线程2结束");
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                System.out.println("线程1开始");
                synchronized (object){
                    for(int i=0;i<10;i++){
                        mt.add(i);
                        System.out.println("线程1添加"+i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(mt.size() ==5){
                            object.notify();
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                System.out.println("线程1结束");
            }
        }.start();


    }

}
