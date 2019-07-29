package com.MyThreads;

public class MyThread extends Thread {
    private String name;
    private int tag;
    public static int flag = 1;
    public static int count = 0;



    public MyThread(String name,int tag){
        this.name = name;
        this.tag = tag;
    }

    @Override
    public void run() {

            while (true) {
                if (count>=9){
                    break;
                }
                if (flag == this.tag) {
                    System.out.println(this.name);
                    if (flag == 3) {
                        flag = 1;
                    } else if (flag == 2) {
                        flag = 3;
                    } else {
                        flag = 2;
                    }
                    count++;
                } else {
                    continue;
                }

            }
    }

    public static void main(String[] args){
        MyThread t1 = new MyThread("a",1);
        MyThread t2 = new MyThread("b",2);
        MyThread t3 = new MyThread("c",3);

        t1.start();
        t2.start();
        t3.start();
    }
}
