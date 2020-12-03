package com.Thread.demo;

/**
 * 管程法
 */
public class ProducerConsumer1 {
    public static void main(String[] args) {
        Container container = new Container();
        new Thread(new Producer(container)).start();
        new Thread(new Customer(container)).start();
    }
}

class Producer implements Runnable {
    private Container container;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken chicken = new Chicken(i);
            container.push(chicken);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class  Customer implements Runnable {
    private Container container;

    public Customer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            container.pop();
//            System.out.println("消费了第" + container.pop().i + "只鸡");
        }
    }
}

class Chicken {
    public int i;

    public Chicken(int i) {
        this.i = i;
    }
}

class Container {
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    public synchronized void push(Chicken chicken) {
        if (count == 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        chickens[count] = chicken;
        count ++;
        System.out.println("生产了第" + chicken.i + "只鸡");
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Chicken chicken = chickens[count - 1];
        chickens[count -1] = null;
        count --;
        System.out.println("消费了" + chicken.i + "只鸡");
        this.notifyAll();
        return chicken;
    }
}