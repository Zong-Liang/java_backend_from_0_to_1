package com.leetcode.code_17.p_169_majorityElement;

public class Solution {
    // Boyer-Moore 投票算法
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {3, 2, 3};
        int result1 = solution.majorityElement(nums1);
        System.out.println("示例 1: " + result1); // 应输出 3

        // 示例 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int result2 = solution.majorityElement(nums2);
        System.out.println("示例 2: " + result2); // 应输出 2
    }
}
