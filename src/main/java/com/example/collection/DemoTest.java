package com.example.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by LiWeilong on 2018/3/28.
 */
public class DemoTest {

    private static Integer temp =0;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for(int i=0;i<100;i++){
            list.add((int)(Math.random()*100));
        }
        System.out.println("list:"+list);
        Integer [] arr = list.toArray(new Integer[list.size()]);
        System.out.println("arr:"+arr);
        for(int i=0;i<arr.length;i++){
            if(temp < arr[i]){
                temp = arr[i];
            }
            //temp = Math.max(temp,arr[i]);
        }
        System.out.println("最大值："+temp);

    }
}
