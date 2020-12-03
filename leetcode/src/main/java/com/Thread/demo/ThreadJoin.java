package com.Thread.demo;

/**
 * sleep 不会释放锁，sleep时间到后线程进入就绪状态，sleep可以模拟网络延时、倒计时等
 * yield 让当前线程暂停，但不阻塞，将线程从运行态转为就绪态，让cpu重新调度，礼让不一定成功
 * join 插队，其他线程阻塞
 */

public class ThreadJoin implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i ++)
            System.out.println("插入线程");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread t = new Thread(threadJoin);
        t.start();
        for (int i = 0; i < 100; i ++) {
            if (i == 50) {
                t.join();
            }
            System.out.println("主线程");
        }
    }
}
