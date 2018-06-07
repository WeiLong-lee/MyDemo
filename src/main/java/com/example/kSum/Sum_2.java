package com.example.kSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by LiWeilong on 2018/6/7.
 * 双指针问题
 */
public class Sum_2 {

    public static void main(String[] args) {
        int array[] = {1,6,4,2,8};
        int target = 6;
        System.out.println("HashMap 处理结果："+ Arrays.toString(two_Sum(array,target)));
    }


    /***
     * 利用hashmap，key存放数值，value存放出现的位置。从前到后进行遍历，将target值减去当前的值，看是否存在map中，
        若存在map中则取出相应的标号，退出。
     */
    public static int[] two_SumForHashMap(int[] nums,int target){

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int result[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int num = target -nums[i];
            if(map.containsKey(num)){
                result[0] = map.get(num);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static int[] two_Sum(int[] nums,int target){
        // 先排序
        int[] nums_temp =Arrays.stream(nums).sorted().toArray();
        int i = 0,j=nums.length -1;
        int result[] = new int[2];
        while(i<j){
            int sum = nums_temp[i] +nums_temp[j];
            if(sum == target){
                result[0] = i;
                result[1] = j;
                return result;
            }else if(sum < target){
                ++i;
            }else if(sum > target)
                --j;
        }
        return result;
    }



}
