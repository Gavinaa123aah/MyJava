package com.chongxie;

import java.util.Objects;

public class Person {
    int age;
    String name;
    public Person(int age,String name){
        this.age=age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }



    public static void main(String[] args){
        Person p1 = new Person(10,"aa");
        Person p2 = new Person(10,"aa");
        Person p3= p1;
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));

    }
}
