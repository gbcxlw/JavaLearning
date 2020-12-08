package com.NetProgram.UDP;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new TalkSend("127.0.0.1", 7777)).start();
        new Thread(new TalkReceive(8888, "学生")).start();
    }
}
