package com.leetcode.code_17.p_136_singleNumber;

public class Solution {
    // 位运算 XOR 解法：相同的数字异或结果为 0，任何数字与 0 异或结果为自己。
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {2, 2, 1};
        int result1 = solution.singleNumber(nums1);
        System.out.println("示例 1: " + result1); // 应输出 1

        // 示例 2
        int[] nums2 = {4, 1, 2, 1, 2};
        int result2 = solution.singleNumber(nums2);
        System.out.println("示例 2: " + result2); // 应输出 4

        // 示例 3
        int[] nums3 = {1};
        int result3 = solution.singleNumber(nums3);
        System.out.println("示例 3: " + result3); // 应输出 1
    }
}
