package com.sort;

import java.util.Iterator;

/**
 * 冒泡排序
 */
public class Bubble {

    static int[]  funBubbleSort(int[] array) {
        boolean flag = true;
        for(int i = 0;i<array.length-1 && flag;i++){
            flag=false;
            for(int j=0;j<array.length-i-1;j++) {
                 if (array[j]>array[j+1]){
                     int temp = array[j];
                     array[j] = array[j+1];
                     array[j+1] = temp;
                     flag=true;
                 }
            }
        }
        return array;
    }
    public static void main(String[] args){

        int[] data = {1,5,3,2};
        int[] result = funBubbleSort(data);
        for (int dd:result) {
            System.out.println(dd);
        }
    }
}
