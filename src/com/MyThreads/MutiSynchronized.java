package com.MyThreads;

public class MutiSynchronized implements Runnable{
    private String data;
    private Integer tag;
    public static int count = 0;
    public static int max = 9;
    public static int flag = 0;


    public MutiSynchronized(String s, Integer tag){
        this.data = s;
        this.tag=tag;
    }

    @Override
    public void run() {
       while (true) {
           synchronized (this){
           if (count == max) break;
           else if (tag == flag) {
               System.out.println(this.data);
               count++;
               if (flag == 2) flag = 0;
               else flag++;
           }
       }
       }
    }

    public static void main(String[] args){
        MutiSynchronized a = new MutiSynchronized("A",0);
        MutiSynchronized b = new MutiSynchronized("B",1);
        MutiSynchronized c = new MutiSynchronized("C",2);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);

        t1.start();
        t2.start();
        t3.start();
        int[] p = new int[]{3,4,5,5,8};
        System.out.println(p);


    }
}