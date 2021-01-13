package com.jvm;

import java.util.ArrayList;

public class TestDemo03 {
    byte[] arrays = new byte[1*1024*1024];

    public static void main(String[] args) {
        ArrayList<TestDemo03> list = new ArrayList<>();
        int count = 0;

        try {
            while (true) {
                list.add(new TestDemo03());
                count ++;
            }
        } catch (Error e) {
            System.out.println(count);
            e.printStackTrace();
        }

    }
}
