package com.example.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by LiWeilong on 2018/5/25.
 */
public class Calculator {

    // 常用计算符号
    private static char operators[] = {'+','-','*','/'};

    private static Integer cal(String str){
        if(StringUtils.isBlank(str)){
            return  null;
        }
        String[] temps;
        for(int i =0;i< operators.length;i++){
            if (!str.contains( CharSequence.class.cast(operators[i]))) {
                continue;
            }
            temps= str.split(String.valueOf(operators[i]));
        }


        return null;
    }
}
