package com.sort;

/**
 * 选择排序
 */
public class SelectSort {

    static int[]  selectSort(int[] array){
        int minindex,temp;
        for (int i = 0;i<array.length-1;i++){
            minindex=i;
            for (int j = i;j<array.length;j++){
                if (array[j]<array[minindex]){
                    minindex=j;
                }
            }
            temp=array[i];
            array[i]=array[minindex];
            array[minindex]=temp;
        }
        return array;
    }

    public static void main(String[] args){

        int[] data = {1,5,3,2};
        int[] result = selectSort(data);
        for (int dd:result) {
            System.out.println(dd);
        }
    }
}
