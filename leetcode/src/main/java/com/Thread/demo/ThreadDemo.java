package com.Thread.demo;

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i ++) {
            System.out.println("11111111");
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        for (int i = 0; i < 2000; i ++) {
            System.out.println("2222222");
        }
    }
}
