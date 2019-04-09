package com.cainiao;

/**
 * string:不可变，变化时生成一个新的字符串
 * stringbuffer:线程安全/速度慢
 * stringbuilder:线程不安全/速度快
 */
public class MyStringBuffer {
    public static void main(String[] args){
        StringBuffer stringBuffer = new StringBuffer("hello");
        stringBuffer.append(" world");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.capacity());



    }

}
