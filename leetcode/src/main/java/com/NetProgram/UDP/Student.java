package com.NetProgram.UDP;

public class Student {
    public static void main(String[] args) {
        new Thread(new TalkSend("127.0.0.1", 8888)).start();
        new Thread(new TalkReceive(7777, "老师")).start();
    }
}
