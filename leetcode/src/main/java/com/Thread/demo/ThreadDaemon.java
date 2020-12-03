package com.Thread.demo;

public class ThreadDaemon {
    public static void main(String[] args) {
        God god = new God();
        Person person = new Person();
        Thread threadDaemon = new Thread(god);
        threadDaemon.setDaemon(true);
        threadDaemon.start();
        new Thread(person).start();
    }
}

class Person implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("活着");
        }
        System.out.println("死去");
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("守护");
        }
    }
}
