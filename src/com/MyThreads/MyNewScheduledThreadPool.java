package com.MyThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyNewScheduledThreadPool
 * @Author Gavin
 * @Date 2019/9/6 上午11:04
 **/

public class MyNewScheduledThreadPool {
    public static void main(String[] args){
        /**
         * 创建一个定长线程池，支持定时及周期性任务执行
         */
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i=0;i<4;i++){
            // 定时
            executorService.schedule(new Runnable() {

                @Override
                public void run() {
                    System.out.println("delay 3 seconds");
                }
            }, 3, TimeUnit.SECONDS);
        }

        // 周期性
        executorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);


    }
}

