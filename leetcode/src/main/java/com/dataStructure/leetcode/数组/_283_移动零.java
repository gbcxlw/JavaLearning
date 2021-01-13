package com.dataStructure.leetcode.数组;

public class _283_移动零 {
    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        moveZero(nums);
        moveZero2(nums);
    }

    public static void moveZero(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j ++;
            }
        }

        for (; j < nums.length; j ++) {
            nums[j] = 0;
        }
    }

    public static void moveZero2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
            }
            j ++;
        }
    }
}
