package com.dataStructure.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
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
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
