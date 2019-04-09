package com.cainiao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {

    static void test_time(){
        System.out.println("starting");
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException i){
            i.printStackTrace();
        }
        long ending = System.currentTimeMillis();
        long diff= ending-start;
        System.out.println("ending");
        System.out.println("diff :"+diff+"ms");


    }

    public static void main(String args[]) {
        //日期参数是从1970年1月1日起的毫秒数。
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        //格式输出
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        //解析字符串为date
        SimpleDateFormat sf = new SimpleDateFormat("yy/MM/dd");
        String string_date = "2005/12/01";
        try {
            System.out.println(sf.parse(string_date));
            System.out.println(sf.parse(string_date).getTime());
        }catch (ParseException e){
            e.printStackTrace();
        }


        //检测程序运行时间
        test_time();

    }
}
