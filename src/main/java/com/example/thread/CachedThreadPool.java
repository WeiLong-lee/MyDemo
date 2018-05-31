package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by LiWeilong on 2018/4/2.
 */
public class CachedThreadPool {

    public static void main(String[] args) throws InterruptedException {
        /***
         * 这个实例会根据需要，在线程可用时，重用之前构造好的池中线程。
         * 这个线程池在执行 大量短生命周期的异步任务时（many short-lived asynchronous task），可以显著提高程序性能
         */
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new LiftOff());
            Thread.sleep(5);
        }

        exec.shutdown();


    }

}
