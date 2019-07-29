package com.MyThreads;

import java.util.concurrent.locks.Lock;

class PrintfABCThread implements Runnable {
    private String name;
    private Lock lock;
    private Integer flag;

    public static int count = 0;

    public static final int MAX = 9;

    public PrintfABCThread(String name, Lock lock, Integer flag) {
        this.name = name;
        this.lock = lock;
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();

            if (count >= MAX) {
                lock.unlock();
                return;
            }

            if (count % 3 == flag) {
                System.out.println(name);
                count++;
            }
            lock.unlock();
        }
    }
}

