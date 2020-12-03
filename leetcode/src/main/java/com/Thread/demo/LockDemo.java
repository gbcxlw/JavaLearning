package com.Thread.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock为显示锁，手动开启和关闭，synchronize是隐式锁，除了作用域自动释放
 * lock只有代码块锁，synchronize有代码块锁和方法锁
 * lock锁，jvm将使用较少的时间调度线程，性能更好，具有更好的扩展性
 * 使用顺序：
 * lock >  同步代码块 > 同步方法
 */
public class LockDemo {
    public static void main(String[] args) {
        Ticket  t = new Ticket();
//        Ticket  t0 = new Ticket();
        Thread t1 = new Thread(t, "t1");
        Thread t2 = new Thread(t, "t2");
        Thread t3 = new Thread(t, "t3");
//        Thread t4 = new Thread(t0, "t4");

        t1.start();
        t2.start();
        t3.start();
//        t4.start();
    }
}

class Ticket implements Runnable {
    private static int ticketNum = 100;
    private boolean flag = true;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (flag) {
            try {
                lock.lock();
                buyTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private void buyTicket() throws InterruptedException {
        if (ticketNum > 0) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "-" + ticketNum--);
        } else {
            flag = false;
        }
    }
}
