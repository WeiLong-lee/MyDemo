package com.example.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Created by LiWeilong on 2018/6/5.
 */
public class SortUtils {



    public static void changeIndex(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }

    public static Boolean isEmpty(Object obj){
        if(Objects.isNull(obj)){
            return true;
        }
        return false;
    }

    public static boolean isInteger(String str){
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        System.out.println("结果："+isInteger("d"));

        System.out.println(!"3".equals(null));
    }
}
