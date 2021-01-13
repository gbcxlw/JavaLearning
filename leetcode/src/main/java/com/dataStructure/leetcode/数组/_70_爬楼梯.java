package com.dataStructure.leetcode.数组;

import java.util.ArrayList;

public class _70_爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs2(2));
    }

    //递归
    //例如：爬5层可以拆分为先爬1层，然后爬4层，加上先爬2层，然后爬3层
    public static int climbStairs(int n) {
        if (n == 0 || n ==1)
            return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    //递推
    public static int climbStairs2(int n) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(1);

        for (int i = 2; i <= n; i ++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }

        return list.get(n);
    }

    //递推2,动态规划，压缩空间
    public static int climbStairs3(int n) {
        int prev = 1;
        int cur = 1;

        for (int i = 2; i <= n; i ++) {
            int temp = cur;
            cur = cur + prev;
            prev = temp;
        }

        return cur;
    }
}
