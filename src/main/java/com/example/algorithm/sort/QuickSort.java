package com.example.algorithm.sort;

import java.util.*;

/**
 * Created by LiWeilong on 2018/5/11.
 *  排序算法
 */
public class QuickSort {


    public static void main(String[] args) {
        List list =  new ArrayList();
        for(int i =0;i< 10;i ++){
            list.add(new Random().nextInt(1000));
        }
        System.out.println(list);

        int[] quickArray = new int[20];
        for(int i =0;i< 20;i++){
            quickArray[i] = new Random().nextInt(1000);
        }
        System.out.println(Arrays.toString(quickArray));
        QuickSort(quickArray,0,list.size()-1);
        System.out.println(Arrays.toString(quickArray));

    }
    /***
     *
     * 快速排序
     *
     * @param array
     */

    public static void QuickSort(int[] array,int left,int right){
        if(array ==null || array.length ==0){
            return ;
        }
        // 将数组一分为二
        if(left < right){
            int p = position(array,left,right);
            QuickSort(array,left,p -1);
            QuickSort(array,p+1,right);
        }
    }

    private static int position(int[] array,int left,int right){

        int p = array[left];
        while(left < right){  // 需要多次交换，左右坐标相等时停止
            while (left < right && array[right] > p)
                right --;
            array[left] = array[right]; // 赋给左边
            while(left < right && array[left] < p)
                left ++;
            array[right] = array[left];
        }
        array[left] = p;   // 最后左边的数换成标志位
        return left;  // 返回标志位
    }


}
