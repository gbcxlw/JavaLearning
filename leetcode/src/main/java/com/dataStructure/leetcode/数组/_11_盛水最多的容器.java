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

    public int maxArea2(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (begin < end) {
            int heigh = height[begin] <= height[end] ? height[begin] : height[end];
            int curArea = heigh * (end - begin);
            maxArea = maxArea >= curArea ? maxArea : curArea;
            //在此处找到下一个离当前的矮端最近，并且比矮端大的数
            if (height[begin] > height[end]) {
                while (end > begin) {
                    end --;
                    if (height[end] > height[end + 1]) {
                        break;
                    }
                }
                continue;
            }
            if (height[begin] <= height[end]) {
                while (end > begin) {
                    begin ++;
                    if (height[begin] > height[begin - 1]) {

                        break;
                    }
                }
            }

        }
        return maxArea;
    }
}
