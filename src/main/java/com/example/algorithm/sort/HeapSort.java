package com.example.algorithm.sort;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by LiWeilong on 2018/6/5.
 * Java 堆排序
 */
public class HeapSort {
    /***
     * 构建最大堆（大顶堆）
     */

    public static void adjustHeap(int[] a,int i,int len){
        int temp,j;
        temp = a[i];
        for(j =2*i;j<len;j*=2){
            if(j< len && a[j] < a[j+1])
                ++j;           // j为关键字中较大记录的下标
            if(temp >= a[j])
                break;
            a[i] = a[j];
            i =j;
        }
        a[i] =temp;
    }
    public static void heapSort(int [] a){
        System.out.println("开始堆排序...");
        int len = a.length;
        for(int i =0;i<len -1;i++){
            // 建堆
            buildMaxHeap(a,len -1 -i);
            // 交换堆顶和最后一个元素
            swap(a,0,len-1-i);
            System.out.println(Arrays.toString(a));
        }
    }
    public static void heapSort(Object [] objects){
        System.out.println("开始堆排序...");
        int len = objects.length;
        for(int i =0;i<len -1;i++){
            // 建堆
            buildMinHeap(objects,len -1 -i);
            // 交换堆顶和最后一个元素
            swap(objects,0,len-1-i);
            System.out.println(Arrays.toString(objects));
        }

    }
    // 建最大堆
    private static void buildMaxHeap(int[] a,int lastIndex){
        // 从lastIndex 处节点（最后一个节点）的父节点开始
        for(int i= (lastIndex - 1)/2;i>=0;i--){
            // 当前位置坐标
            int k = i;
            while(k*2+1 <= lastIndex){
                int child = k*2+1;
                // 如果k 节点的右字数存在
                if(child < lastIndex){
                    if(a[child] < a[child+1])  // 如果右节点大于左节点，记录 右节点
                        child ++;
                }
                // 如果k节点的值小于子节点的值
                if(a[k] < a[child]){
                    swap(a,k,child);
                    k = child;
                }else{
                    break;
                }
            }
        }
    }
    private static void buildMaxHeap(Object[] objects,int lastIndex){
        // 从lastIndex 处节点（最后一个节点）的父节点开始
        for(int i= (lastIndex - 1)/2;i>=0;i--){
            // 当前位置坐标
            int k = i;
            while(k*2+1 <= lastIndex){
                int child = k*2+1;
                // 如果k 节点的右字数存在
                if(child < lastIndex){
                    if(objects[child] instanceof Map.Entry){
                       Map.Entry<String,Integer> entryL =(Map.Entry<String,Integer>)objects[child];
                       Map.Entry<String,Integer> entryR =(Map.Entry<String,Integer>)objects[child+1];
                        if( entryL.getValue() < entryR.getValue())  // 如果右节点大于左节点，记录 右节点
                                    child ++;
                    }
                }
                // 如果k节点的值小于子节点的值
                Map.Entry<String,Integer> entryK =(Map.Entry<String,Integer>)objects[k];
                Map.Entry<String,Integer> entryC =(Map.Entry<String,Integer>)objects[child];
                if(entryK.getValue() < entryC.getValue()){
                    swap(objects,k,child);
                    k = child;
                }else{
                    break;
                }
            }
        }
    }
    // 建最小堆
    private static void buildMinHeap(int[] a,int lastIndex){
        for(int i= (lastIndex - 1)/2;i>=0;i--){
            // 当前位置坐标
            int k = i;
            while(k*2+1 <= lastIndex){
                int child = k*2+1;
                // 如果k 节点的右字数存在
                if(child < lastIndex){
                    if(a[child] > a[child+1])  // 如果右节点小于左节点，记录 右节点
                            child ++;
                }
                // 如果k节点的值大于子节点的值， 交换数值
                if(a[k] > a[child]){
                    swap(a,k,child);
                    k = child;
                }else{
                    break;
                }
            }
        }
    }
    private static void buildMinHeap(Object[] objects,int lastIndex){
        // 从lastIndex 处节点（最后一个节点）的父节点开始
        for(int i= (lastIndex - 1)/2;i>=0;i--){
            // 当前位置坐标
            int k = i;
            while(k*2+1 <= lastIndex){
                int child = k*2+1;
                // 如果k 节点的右字数存在
                if(child < lastIndex){
                    if(objects[child] instanceof Map.Entry){
                        Map.Entry<String,Integer> entryL =(Map.Entry<String,Integer>)objects[child];
                        Map.Entry<String,Integer> entryR =(Map.Entry<String,Integer>)objects[child+1];
                        if( entryL.getValue() > entryR.getValue())  // 如果右节点大于左节点，记录 右节点
                            child ++;
                    }
                }
                // 如果k节点的值小于子节点的值
                Map.Entry<String,Integer> entryK =(Map.Entry<String,Integer>)objects[k];
                Map.Entry<String,Integer> entryC =(Map.Entry<String,Integer>)objects[child];
                if(entryK.getValue() > entryC.getValue()){
                    swap(objects,k,child);
                    k = child;
                }else{
                    break;
                }
            }
        }
    }

    private static void swap(int[] data,int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static void swap(Object[] data,int i,int j){
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }



    public static void main(String[] args) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};

        heapSort(a);
    }

}
