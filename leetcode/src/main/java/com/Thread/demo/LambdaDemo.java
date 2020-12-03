package com.Thread.demo;

public class LambdaDemo {

    public static void main(String[] args) {
        Ilove ilove = (int a) -> {
            System.out.println(a);
        };
        ilove.love(521);

        ilove = a -> {
            System.out.println("a" + a);
        };
        ilove.love(521);
    }
}

interface Ilove {
    void love(int a);
}