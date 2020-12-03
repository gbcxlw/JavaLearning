package com.Thread.demo;

public class ThreadYield implements Runnable{

    public static void main(String[] args) {
        ThreadYield t = new ThreadYield();
        new Thread(t, "first").start();
        new Thread(t, "second").start();
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "启动");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "停止");
    }
}

class TestYield implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName() + "启动");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "停止");
    }
}