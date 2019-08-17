package com.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 分治法思想
 * 最好时间复杂度nlogn
 * 最坏nlogn
 * 平均nlogn
 *
 * 空间复杂度：n
 */

/**
 * @ClassName MergeSort
 * @Author Gavin
 * @Date 2019/8/17 上午11:09
 **/
public class MergeSort {

    public static int[] mergesort(int arrays[]){

     if (arrays.length<2){
         return arrays;
     }

     int mid = arrays.length/2;

     int[] left = Arrays.copyOfRange(arrays,0,mid);
     int[] right = Arrays.copyOfRange(arrays,mid,arrays.length);
     return merge(mergesort(left),mergesort(right));

    }

    static int[] merge(int[] left, int[] right){

        int[] result = new int[left.length+right.length];
        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex<left.length && rightIndex<right.length){
            if (left[leftIndex]<=right[rightIndex]){
                result[resultIndex]=left[leftIndex];
                leftIndex++;
                resultIndex++;
            }else {
                result[resultIndex] = right[rightIndex];
                resultIndex++;
                rightIndex++;
            }
        }
        while (leftIndex<left.length){
            result[resultIndex]=left[leftIndex];
            leftIndex++;
            resultIndex++;
        }
        while (rightIndex<right.length){
            result[resultIndex] = right[rightIndex];
            resultIndex++;
            rightIndex++;
        }

        return result;
    }

    public static void main(String args[]){

        int data[] = {3,2,1,5,4,1};
        int result[] = mergesort(data);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }

}

