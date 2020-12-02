package com.Thread.demo;

public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        new WeddingCompany(you).marry();
    }
}
interface Marry {
    void marry();
}

class You implements Marry {

    public void marry() {
        System.out.println("marry");
    }
}

class WeddingCompany implements Marry {
    private Marry person;

    public WeddingCompany(Marry person) {
        this.person = person;
    }

    public void marry() {
        before();
        this.person.marry();
        after();
    }

    private void before() {
        System.out.println("准备");
    }

    private void after() {
        System.out.println("结束");
    }
}