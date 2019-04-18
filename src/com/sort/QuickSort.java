package com.sort;

public class QuickSort   {

    public static int[] quick(int left,int right, int[] a){
        if (right<left)
            return new int[]{};
        int base,i,j;
        i=left;
        j=right;
        base = a[left];
        while (i<j){
            while (a[j]>=base&&i<j)j--;
            while (a[i]<=base&&i<j)i++;
            if (i<j){
                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        a[left] = a[i];
        a[i] = base;
        //一个循环走完一趟
        quick(left,i-1,a);
        quick(i+1,right,a);

        return a;
    }

    public static void main(String[] args){
        int[] array={18,15,6,67,8,19};
        int result[] = quick(0,array.length-1,array);

        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

}
