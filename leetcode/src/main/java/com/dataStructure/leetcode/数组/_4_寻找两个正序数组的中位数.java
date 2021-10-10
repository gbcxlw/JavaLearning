package com.dataStructure.leetcode.数组;

public class _4_寻找两个正序数组的中位数 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        double left = 0;
        double right = 0;
        int length = nums1.length + nums2.length;
        int count = 0;
        while (count <= length / 2) {
            left = right;
            //此处判断的先后顺序很关键
            if (index1 < nums1.length && (index2 >= nums2.length || nums1[index1] < nums2[index2])) {
                right = nums1[index1 ++];
            } else {
                right = nums2[index2 ++];
            }
            count ++;
        }
        return length % 2 == 0 ? (left + right) / 2 : right;
    }


    public static void main(String[] args) {
        int []nums1 = {1,2};
        int []nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
