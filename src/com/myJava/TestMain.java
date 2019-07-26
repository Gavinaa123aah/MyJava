package com.myJava;


import com.advance.lambda.A;

/**
 * @ClassName TestMain
 * @Author Gavin
 * @Date 2019/7/25 下午11:25
 **/




public class TestMain {


    public static void main(String[] args){

        //equals  和 ==
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = "hello";
        String s4 = new String("hello");
        s3.hashCode();

        System.out.println(s1.equals(s3));
        System.out.println(s1==s3);
        System.out.println(s2.equals(s4));
        System.out.println(s2==s4);


        // hashcode
        TestModel testModel = new TestModel();
        TestModel testModel2 = new TestModel();
        System.out.println(testModel.hashCode());
        System.out.println(testModel2.hashCode());
    }
}


