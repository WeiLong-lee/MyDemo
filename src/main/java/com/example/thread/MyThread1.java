package com.example.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiWeilong on 2018/1/10.
 */
public class MyThread1 {
    private volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        final MyThread1 mt = new MyThread1();
        new Thread(){
            @Override
            public void run(){
               for(int i=0;i<10;i++){
                   mt.add(i);
                   System.out.println("线程1增加了"+i);
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                System.out.println("线程2开始");
                while(true){
                    if(mt.size() ==5){
                        System.out.println("线程2退出");
                        break;
                    }
                }
            }
        }.start();
    }
}
