package com.MyThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Thread a = new Thread(new PrintfABCThread("A", lock, 0));
        Thread b = new Thread(new PrintfABCThread("B", lock, 1));
        Thread c = new Thread(new PrintfABCThread("C", lock, 2));

        a.start();
        b.start();
        c.start();
    }
}
