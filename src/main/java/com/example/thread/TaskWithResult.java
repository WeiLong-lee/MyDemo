package com.example.thread;

import java.util.concurrent.Callable;

/**
 * Created by LiWeilong on 2018/4/2.
 */
public class TaskWithResult implements Callable {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public Object call() throws Exception {
        return  "result of TaskWithResult :"+id;
    }
}
