package com.leetcode.code_01.p_01_twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 暴力解法
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[] { i, j };
//                }
//            }
//        }
//        return new int[] {};
//    }

    // 哈希表解法
    public int[] twoSum(int[] nums, int target) {
        // 创建哈希表，存储数字和索引
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 如果 complement 存在于哈希表中，说明找到了答案
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            // 否则将当前数字和索引存入哈希表
            map.put(nums[i], i);
        }

        // 题目保证有解，这里不会执行到
        return new int[] {};
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("示例 1: [" + result1[0] + ", " + result1[1] + "]"); // 应输出 [0, 1]

        // 测试用例 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("示例 2: [" + result2[0] + ", " + result2[1] + "]"); // 应输出 [1, 2]

        // 测试用例 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("示例 3: [" + result3[0] + ", " + result3[1] + "]"); // 应输出 [0, 1]
    }
}
