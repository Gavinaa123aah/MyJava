package com.sort;

/**
 * InsertSort
 * (1) 第一趟，将第1个元素放到第1个位置
 * (2) 第二趟，将第2个元素根据大小插入到已经排号序的位置
 * (3) 第三趟，将第3个元素根据大小插入到[1,2]的合适位置
 * (4) 第四趟，将第4个元素根据大小插入到[1,3]的合适位置
 * ......
 * (5) 第n趟，将第n个元素根据大小插入到[1,n-1]的合适的位置
 *
 **/
public class InsertSort {

    static int[] insertSort(int[] arrays){
        for(int i=1;i<arrays.length;i++){

            int preIndex = i-1;
            int current = arrays[i];

            while (current<arrays[preIndex] && preIndex>=0){
                arrays[preIndex+1]=arrays[preIndex];
                preIndex--;
            }
            arrays[preIndex+1] = current;
        }
        return arrays;
    }

    public static void main(String[] args){

        int[] data = {1,5,3,2};
        int[] result = insertSort(data);
        for (int dd:result) {
            System.out.println(dd);
        }
    }
}

