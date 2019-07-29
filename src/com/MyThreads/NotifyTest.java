package com.MyThreads;

/**
 * @ClassName NotifyTest
 * @Author Gavin
 * @Date 2019/7/29 上午1:34
 **/

public class NotifyTest {
    public void testWait(){
        System.out.println(Thread.currentThread().getName() +" Start-----");
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" End-------");
    }

    public static void main(String[] args) throws InterruptedException {
        final NotifyTest test = new NotifyTest();
        for(int i=0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.testWait();
                }
            }).start();
        }

        synchronized (test) {
            test.notify();
        }
        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");

        synchronized (test) {
            test.notifyAll();
        }
    }
}

