package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName C
 * @Author Gavin
 * @Date 2019/9/19 下午4:17
 **/
public class C implements A,B{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int point = 0;

        while (point < m){
            if (arr[arr.length-1]==0){
                System.out.println(0);
                point++;
                continue;
            }
            if (arr[point]==0){
                point++;
                m++;
                continue;
            }
            System.out.println(arr[point]);
            int temp = arr[point];
            for (int i=0;i<arr.length;i++){
                if (arr[i]>0){
                    arr[i] -= temp;
                }
            }
            point++;
        }
    }
}

