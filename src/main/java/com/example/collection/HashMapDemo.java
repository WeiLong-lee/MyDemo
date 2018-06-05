package com.example.collection;


import com.example.algorithm.sort.HeapSort;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by LiWeilong on 2018/5/31.
 */
public class HashMapDemo {



    public static void main(String[] args) {
        Map<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("a",10);
        treeMap.put("b",20);
        treeMap.put("c",5);
        treeMap.put("d",7);
        treeMap.put("e",9);
        treeMap.put("f",30);
        getTopTen(treeMap);
        getTopKHeap(treeMap);
    }


    public static void getTopTen(Map<String,Integer> hashMap){
        List<String> list = hashMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("排序结果："+list);
    }

    public static void getTopKHeap(Map<String,Integer> hashMap){
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        List<Map.Entry<String,Integer>> aList = new LinkedList<Map.Entry<String, Integer>>(entries);
        Object[] objects = aList.toArray();
        HeapSort.heapSort(objects);
        objects =Arrays.stream(objects).limit(5).toArray();
        System.out.println("排序结果："+ Arrays.toString(objects));

    }




}
