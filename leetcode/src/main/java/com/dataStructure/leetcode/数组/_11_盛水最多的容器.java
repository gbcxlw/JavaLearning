package com.dataStructure.leetcode.数组;

public class _11_盛水最多的容器 {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left != right) {
            int temp = 0;
            if (height[left] <= height[right]) {
                temp = height[left];
                left ++;
            } else {
                temp = height[right];
                right --;
            }
            int area = temp * (right - left + 1);    //由于前面在判断大小时已经对left或right进行过++，所以此处计算时的实际坐标还需算上
            max = area > max ? area : max;

        }
        return max;
    }
}
