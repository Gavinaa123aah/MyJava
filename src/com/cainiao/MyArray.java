package com.cainiao;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class MyArray {
    public void array_description(){
        //声明
        double[] myList;
        myList = new double[10];
        myList[0]=21;
        myList[1]=56;
        myList[3]=3;
        int total = 0;
        for (double temp:myList
        ) {
            total +=temp;
        }
        System.out.println(total);
    }

    //数组作为参数
    public static void array_as_args(double[] list){
        int total = 0;
        for (double temp:list
        ) {
            total +=temp;
        }
        System.out.println(total);
    }

    //数组作为返回值
    public static double[] reverse(double[] list){
       double[] result = new double[list.length];

       for (int i=0,j=list.length-1;i<list.length;i++,j--){
           result[i] = list[j];
       }
       return result;
    }

    //多纬数组
    public static void multi_array(){
        String[][] s=new String[3][4];

        String[][] SS = new String[2][];


    }

    public static void main(String[] args){
        double[] myList;
        myList = new double[10];
        myList[0]=21;
        myList[1]=56;
        myList[3]=3;
//        array_as_args(myList);
        double[] r = reverse(myList);
        for (double temp:r){
            System.out.println(temp);
        }



    }
}
