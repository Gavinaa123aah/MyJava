package com.designPattern;
//单例判断线程是否安全只需查看是否会出现多个实例的
/**
 * 饿汉式
 * 线程安全
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    public static Singleton getInstance(){
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        return singleton;
    }
}

/**
 * 懒汉式
 * 线程不安全
 */
class SingletonB {
    private static SingletonB singleton = null;
    private SingletonB(){}
    public static SingletonB getInstance(){
        if (singleton==null){
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            singleton=new SingletonB();
        }
        return singleton;
    }
}

/**
 * 懒汉式
 * 线程安全(同步方法)
 * 效率低
 */
class SingletonC {
    private static SingletonC singleton = null;
    private SingletonC(){}
    public static synchronized SingletonC getInstance(){
        if (singleton==null){
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            singleton=new SingletonC();
        }
        return singleton;
    }
}

/**
 * 懒汉式
 * 线程安全(同步代码块)（此方法效率也不是特别高，若仅仅同步new SingletonD那一行会导致线程不安全)
 * 效率低
 */
class SingletonD {
    private static SingletonD singleton = null;
    private SingletonD(){}
    public static  SingletonD getInstance(){
        synchronized(SingletonD.class) {
        if (singleton==null){
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }

                singleton = new SingletonD();
            }
        }
        return singleton;
    }
}

/**
 * 最佳方法(兼顾了多线程的安全性和效率问题)
 * 双重锁校验机制
 * volatile
 */
class MySingleton {

    //使用volatile关键字保其可见性
    volatile private static MySingleton instance = null;

    private MySingleton(){}

    public static MySingleton getInstance() {
        try {
            if(instance != null){//懒汉式

            }else{
                //创建实例之前可能会有一些准备性的耗时工作
                Thread.sleep(300);
                synchronized (MySingleton.class) {
                    if(instance == null){//二次检查
                        instance = new MySingleton();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }
}



class MyTest extends Thread{

    public void run(){
        System.out.println(MySingleton.getInstance().hashCode());
    }

    public static void main(String[] args){
        MyTest[] myTests = new MyTest[10];

        for (int i=0;i<myTests.length;i++){
            myTests[i] = new MyTest();
        }

        for (int i=0;i<myTests.length;i++){
            myTests[i].start();
        }
    }
}