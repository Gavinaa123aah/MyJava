package com;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyAutomic
 * @Author Gavin
 * @Date 2019/9/10 上午10:46
 **/
public class MyAutomic {

    static AtomicInteger num = new AtomicInteger(0);
    public static void main(String[] args){

        for (int i=0;i<10;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0; j<10;j++){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        System.out.println(Thread.currentThread().getName()+":"+ num.incrementAndGet());
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }

}

