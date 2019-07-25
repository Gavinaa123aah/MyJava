package com.constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName TestMain
 * @Author Gavin
 * @Date 2019/6/10 下午3:14
 **/
public class TestMain {
    Map<Integer, List<String>> m = new HashMap<>();

    public static void main(String[] args){
      System.out.println(MyConstant.BAD);
      System.out.println(MyConstant.GOOD);

        for (MyConstant m:MyConstant.values()) {
            System.out.println(m.getCode());
        }

        Map<Integer, List<String>> m = new TreeMap<>();
        ((TreeMap<Integer, List<String>>) m).firstKey();

    }

    public String longestCommonPrefix(String[] strs) {
        int[] a = new int[10];
        return"";
    }
}

