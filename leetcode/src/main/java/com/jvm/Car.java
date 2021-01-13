package com.jvm;

public class Car {
    public static void main(String[] args) {
        Car car = new Car();
        Class<? extends Car> aClass = car.getClass();
        String s = "iiii";

        ClassLoader classLoader = aClass.getClassLoader();   //根加载器

        System.out.println(s.getClass().getClassLoader());
        System.out.println(classLoader);  //AppClassLoader
        System.out.println(classLoader.getParent());  //ExtClassLoader
        System.out.println(classLoader.getParent().getParent());  //根加载器
    }
}
