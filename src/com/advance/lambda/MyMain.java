package com.advance.lambda;

public class MyMain {
    public static void main(String[] args){

        A addition = (int num1, int num2)->{ return num1+num2;};
//        A subtraction = (int num1, int num2)->{return num1-num2;};
        MyLambda myLambda = new MyLambda();
        System.out.println(myLambda.operation(10,20,(int num1, int num2)->{ return num1+num2;}));
    }
}
