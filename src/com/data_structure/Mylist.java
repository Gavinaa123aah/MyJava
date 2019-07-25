package com.data_structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mylist {

    public static void main(String[] args){
        List list = new ArrayList<String>();
        list.add("dadad");
        list.add("nnnn");
        list.add("ssss");
        Iterator<String> iterable = list.iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }


    }
}
