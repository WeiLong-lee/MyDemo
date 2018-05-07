package com.example.collection;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by LiWeilong on 2017/11/28.
 */
public class ListTest {

    public static void stackTest(){

        Deque stack = new ArrayDeque();

        for(String str : "My Life Has a Good Start".split(" ")){
            stack.push(str);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() +" ");
        }
    }
    public static void ListTestDisplay(){

    }

    public static void main(String[] args) {
        ListTest.stackTest();

    }

}
