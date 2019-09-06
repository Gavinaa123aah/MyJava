package com.MyThreads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyNewFixedThreadPool {

    public static void main(String[] args){
        // 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        ExecutorService threadPool1 = Executors.newFixedThreadPool(3);

        for (int i=0;i<1000;i++){
            final int index = i;

            threadPool1.execute(() -> {
                System.out.println(index);
                System.out.println(Thread.currentThread().getName());
            });
        }

    }
}


