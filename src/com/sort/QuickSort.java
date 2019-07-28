package com.sort;

/**
 *快速排序:
 *从数列中挑出一个元素，称为 “基准”（base）；
 *重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 *递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 复杂度：
 * 平均：o(n*log(n))
 * 最好：o(n*log(n))
 * 最坏：o(n*n)
 * 空间：o(nlog(n))
 */
public class QuickSort   {

    public static int[] quick(int left,int right, int[] arrays){
        if (left>right){
            return new int[]{};
        }

        int i = left;
        int j = right;
        int base = arrays[i];

        while (i<j){
            while (arrays[j]>=base && i<j){
                j--;
            }
            while (arrays[i]<=base && i<j){
                i++;
            }

            if (i<j){
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
            }
        }

        arrays[left] = arrays[i];
        arrays[i] = base;// 一趟排序结束

        quick(left, i-1, arrays);
        quick(i+1,right,arrays);

        return arrays;

    }


    public static void main(String[] args){
        int[] array={18,15,6,67,8,19};
        int result[] = quick(0,array.length-1,array);

        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }

}

