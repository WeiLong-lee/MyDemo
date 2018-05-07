package com.example.thread;

/**
 * Created by LiWeilong on 2018/4/2.
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        for(int i=0;i< 5;i++)
                 new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
}
