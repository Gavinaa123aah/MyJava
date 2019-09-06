package com.MyThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName MyNewCacheThreadPool
 * @Author Gavin
 * @Date 2019/9/6 下午3:15
 **/
public class MyNewCacheThreadPool {

    public static void main(String[] args){
        /**
         *  1. 创建一个可缓存线程池，如果线程池长度超过处理需要,可灵活回收空闲线程，若无可回收，则新建线程。
         *  2. 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
         */

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i=0;i<1000;i++){
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

    }

}

