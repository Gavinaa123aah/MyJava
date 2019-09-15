package com.MyThreads;


import com.advance.lambda.A;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThread{
    public  static int count = 0;




    public static void main(String[] args){



            ExecutorService executor = Executors.newCachedThreadPool();
            for (int i=0;i<1000;i++){
                Task task = new Task();
                Future<Integer> result = executor.submit(task);
            }

    }



    static class Task implements Callable{
        @Override
        public Object call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(3000);
            int sum = 0;
            for(int i=0;i<100000;i++)
                sum += i;
            return sum;
        }
    }
}
