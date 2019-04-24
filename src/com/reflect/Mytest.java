package com.reflect;

import java.lang.reflect.Method;
import java.util.Iterator;

public class Mytest {
    public static void main(String[] args){
        Class clazz=null;
        try {
            clazz = Class.forName("com.reflect.Person");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods
             ) {
            System.out.print(" "+method.getName());
        }

    }
}
