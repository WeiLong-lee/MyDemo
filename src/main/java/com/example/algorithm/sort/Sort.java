package com.example.algorithm.sort;

import java.util.*;

/**
 * Created by LiWeilong on 2018/5/11.
 *  排序算法
 */
public class Sort {


    public static void main(String[] args) {
        List<Integer> list =  new ArrayList();
        for(int i =0;i< 10;i ++){
            list.add(new Random().nextInt(1000));
        }
        System.out.println(list);
        list.removeAll(list.subList(5,list.size()));
        System.out.println(list);

       /* List<Integer> list =  new ArrayList();
        for(int i =1;i< 1000;i ++){
            list.add(new Random().nextInt(1000));
        }
        System.out.println(list);
        Integer [] integer = new Integer[list.size()];
        list.toArray(integer);
        BubbleSort(integer,integer.length);
        System.out.println(Arrays.asList(integer));
        list.clear();
        for(int i =1;i< 10000;i ++){
            list.add(new Random().nextInt(100000));
        }
        System.out.println(list);
        Integer [] integer2 = new Integer[list.size()];
        list.toArray(integer2);
        BubbleSort(integer2,integer2.length);
        System.out.println(Arrays.asList(integer2));


        Integer [] integer_good = integer.clone();
        System.out.println(Arrays.asList(integer_good));
        BubbleSort(integer_good,integer_good.length);
        System.out.println(Arrays.asList(integer_good));

        Integer [] integer2_good = integer2.clone();
        System.out.println(Arrays.asList(integer2_good));
        BubbleSort(integer2_good,integer2_good.length);
        System.out.println(Arrays.asList(integer2_good));*/
    }

    /***
     * 　冒泡排序是一种极其简单的排序算法，也是我所学的第一个排序算法。
     *   它重复地走访过要排序的元素，依次比较相邻两个元素，如果他们的顺序错误就把他们调换过来，
     *   直到没有元素再需要交换，排序完成。这个算法的名字由来是因为越小(或越大)的元素会经由交换慢慢“浮”到数列的顶端。
     　　   冒泡排序算法的运作如下：
             1、比较相邻的元素，如果前一个比后一个大，就把它们两个调换位置。
             2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
             3、针对所有的元素重复以上的步骤，除了最后一个。
             4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

        最好情况：O(n)
        最坏情况：O(n^2)
     */

    public static void BubbleSort(Integer[] arr, int n){
        long start = System.currentTimeMillis();
        for(int i= 0;i< n -1;i++){
            for(int j = 0;j <n -1 -i;j++){
                  if(arr[j] > arr[j+1]){
                      Swap(arr,j,j+1);
                  }
            }
        }
        long end =  System.currentTimeMillis();
        System.out.println("用时："+(end-start)  +" ms");
    }

    public static void Swap(Integer[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
