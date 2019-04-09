package com.cainiao;

public class Instance {
    public static void main(String[] args){
        Car car = new Car();
        boolean result =  car instanceof Car;
        System.out.println(result);
        System.out.println(car.getClass().getSimpleName());

    }
}

class Car{
    public Car(){

    }
}