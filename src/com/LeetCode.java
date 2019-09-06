package com;


import javax.swing.tree.TreeNode;
import java.util.*;

public class LeetCode {


    public static String replaceSpace(StringBuffer str) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i<str.length();i++){
            char temp =  str.charAt(i);
            if (temp==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(temp);
            }
        }

        return stringBuilder.toString();

    }
    public int Fibonacci(int n) {
        if(n==0 || n == 1){
            return n;
        }
        int[] ret = new int[3];
        ret[0] = 0;
        ret[1] = 1;
        int current = 2;
        while (current<=n){
            ret[2] = ret[0] + ret[1];
            ret[0] = ret[1];
            ret[1] = ret[2];
            current ++;
        }

        return ret[2];
    }
    public static String countSubstrings(String s) {
        return s.substring(0,1);
    }
    public static void main(String[] args){

            int[] array = {1,3,4,5,6};
            int[] m = Arrays.copyOfRange(array,1,3);
            for (int i =0;i<m.length;i++){
                System.out.println(m[i]);
            }

            System.out.println(replaceSpace(new StringBuffer("hello world")));



    }
}
