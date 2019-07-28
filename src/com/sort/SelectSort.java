package com.sort;

/**
 * 选择排序：每趟从未排序的部分，选出最小的值放到排好序的部分的末尾
 * （1）第一趟，从[1,n]中选取最小的放到第1个位置
 * （2）第二趟，从第[2,n]中选取最小的放到第2个位置
 *  ...
 * （3）第m趟，从[m,n]（m<=n）中选取最小的放到第m个位置
 */
public class SelectSort {

    static int[] selectSort(int[] arrays){
        int minIndex;
        for (int i=0; i<arrays.length-1; i++){
            minIndex = i;
            for (int j=i; j<arrays.length; j++){
                if (arrays[j] < arrays[minIndex]){
                    minIndex = j;
                }
            }
           // 注意：这个地方用到引用传递
           swap(arrays, i, minIndex);
        }
        return arrays;
    }

    static void swap(int arrays[], int i, int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void main(String[] args){

        int[] data = {1,5,3,2};
        int[] result = selectSort(data);
        for (int dd:result) {
            System.out.println(dd);
        }
    }
}
