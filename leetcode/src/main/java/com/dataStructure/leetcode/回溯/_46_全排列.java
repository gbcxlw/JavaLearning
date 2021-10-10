package com.dataStructure.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums).toString());
    }


    public static List<List<Integer>> permute(int[] nums) {
//        ArrayList source = new ArrayList<>(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        for (int i = 0; i < len; i++) {
            used[i] = false;
        }
        List<Integer> path = new ArrayList<>();
        dfs(result, used, 0, len, path, nums);

        return result;
    }

    public static void dfs(List<List<Integer>> result,
                                boolean[] used,
                                int depth,
                                int len,
                                List<Integer> path,
                                int[] nums) {
        if (depth == len) {
            result.add(new ArrayList<>(path));
            return;
        } else {
            for (int i = 0; i < len; i ++) {
                if (used[i]) continue;
                path.add(nums[i]);
                used[i] = true;
                dfs(result, used, depth + 1, len, path, nums);
                //下面的代码为回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> list = new ArrayList();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        for (int i = 0; i < nums.length; i ++) {
            int []nums2 = new int[nums.length - 1];
            int j1 = 0;
            int j2 = 0;
            while (j1 < nums.length) {
                if (nums[j1] != nums[i]) {
                    nums2[j2] = nums[j1];
                    j2 ++;
                }
                j1 ++;
            }
            List<List<Integer>> lastResult = permute(nums2);
            for (List<Integer> tmpList : lastResult) {
                tmpList.add(nums[i]);
                result.add(tmpList);
            }
        }
        return result;

    }
}
