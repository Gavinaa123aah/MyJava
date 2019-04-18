package com.MyThreads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MythreadPool implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args){
        ExecutorService pool = Executors.newSingleThreadExecutor();

        MythreadPool r1 = new MythreadPool();
        MythreadPool r2 = new MythreadPool();
        MythreadPool r3 = new MythreadPool();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);


    }
}


