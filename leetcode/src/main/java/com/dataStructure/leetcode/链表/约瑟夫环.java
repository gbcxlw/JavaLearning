package com.dataStructure.leetcode.链表;

import java.util.ArrayList;
import java.util.List;

public class 约瑟夫环 {
    public static void main (String[] args) {

        int[] a = {3, 8, 9, 10};
        int[] b = {1, 1, 1, 1};
        List numberList = new ArrayList();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);
        numberList.add(7);
        numberList.add(8);
        List flagList = new ArrayList();
        flagList.add(1);
        flagList.add(1);
        flagList.add(1);
        flagList.add(1);
        flagList.add(1);
        flagList.add(1);
        flagList.add(1);
        flagList.add(1);
        int index = -1;
        while (flagList.contains(1)) {
            for (int i = 0; i < 3; i ++) {
                index ++;
                while (flagList.get(index % numberList.size()).equals(0)) {
                    index ++;
                }
            }
            flagList.set(index % numberList.size(), 0);
            System.out.println(numberList.get(index % numberList.size()));
        }
    }
}
