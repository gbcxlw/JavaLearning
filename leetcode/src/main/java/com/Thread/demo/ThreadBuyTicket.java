package com.Thread.demo;

public class ThreadBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        Thread t1 = new Thread(buyTicket, "我");
        Thread t2 = new Thread(buyTicket, "其他人");
        Thread t3 = new Thread(buyTicket, "黄牛");

        t1.start();
        t2.start();
        t3.start();
    }
}

class BuyTicket implements Runnable {
    private static int ticketNum = 50;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        if (ticketNum <= 0) {
            flag = false;
            return;
        }

        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum -- + "票");
    }
}
