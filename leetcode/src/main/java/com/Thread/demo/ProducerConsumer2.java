package com.Thread.demo;

/**
 * 信号量
 */
public class ProducerConsumer2 {
    public static void main(String[] args) {
        TV show = new TV();
        new Thread(new Actor(show)).start();
        new Thread(new Watcher(show)).start();
    }
}

class Actor implements Runnable {
    private TV show;

    public Actor(TV show) {
        this.show = show;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                show.play("天天向上第" + (i + 1) + "片段");
            } else {
                show.play("快乐大本营第" + (i + 1) + "片段");
            }
        }
    }
}

class Watcher implements Runnable {
    private TV show;

    public Watcher(TV show) {
        this.show = show;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            show.watch();
        }
    }
}

class TV {
    String name;
    boolean flag = true;

    public synchronized void play(String name) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.name = name;
        flag = !flag;
        System.out.println("表演了" + this.name);
        this.notifyAll();
    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了" + this.name);
        flag = !flag;
        this.notifyAll();

    }
}