package com.example.algorithm.sort;

import com.example.utils.SortUtils;

/**
 * Created by LiWeilong on 2018/6/5.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {1,2,8,4,3,10};
        BubbleSort.sort(a);
        SortUtils.printArray(a);
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
     空间复杂度：O(1)
     稳定性：稳定
     */

    public static void sort(int[] arr){
        boolean isSort;  // 判断是否有序
        if(SortUtils.isEmpty(arr)){
            return;
        }
        for(int i= 0;i< arr.length;i++){
            isSort = true;
            for(int j = 0;j <arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                     SortUtils.changeIndex(arr,j,j+1);
                     isSort = false;
                }
            }
            if(isSort) return;   // 如果有序直接退出
        }
    }


}
