package com.Thread.demo;

public class ThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("99999999999999");
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        System.out.println(state);

        while (state != Thread.State.TERMINATED) {
            System.out.println(state);
            state = thread.getState();
        }


    }
}
