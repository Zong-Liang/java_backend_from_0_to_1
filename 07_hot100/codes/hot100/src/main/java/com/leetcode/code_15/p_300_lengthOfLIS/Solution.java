package com.leetcode.code_15.p_300_lengthOfLIS;

import java.util.Arrays;

public class Solution {
    /**
     * 动态规划解法 (O(n^2))
     *
     * 算法思路：
     * 这个问题是动态规划中的一个经典模型。
     *
     * 1. 状态定义：
     *    `dp[i]` 表示以 `nums[i]` 这个数结尾的最长递增子序列的长度。
     *
     * 2. 状态转移方程：
     *    当我们计算 `dp[i]` 时，我们需要回头看 `i` 之前的所有元素 `nums[j]` (其中 `0 <= j < i`)。
     *    如果 `nums[i] > nums[j]`，这意味着 `nums[i]` 可以接在以 `nums[j]` 结尾的递增子序列的后面，
     *    从而形成一个更长的递增子序列。
     *    因此，我们可以更新 `dp[i]` 的值。我们需要遍历所有满足条件的 `j`，并取其中的最大值。
     *    状态转移方程为：`dp[i] = max(dp[i], dp[j] + 1)` for all `j` where `0 <= j < i` and `nums[i] > nums[j]`.
     *
     * 3. 初始化：
     *    我们创建一个长度为 `n` 的 `dp` 数组。
     *    将 `dp` 数组的所有元素都初始化为 1。因为每个元素自身都可以构成一个长度为 1 的递增子序列。
     *
     * 4. 结果：
     *    最终的结果不是 `dp[n-1]`，因为最长递增子序列不一定以最后一个元素结尾。
     *    我们需要遍历整个 `dp` 数组，找到其中的最大值。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        // 初始化 dp 数组，每个元素自身都是长度为 1 的子序列
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果当前元素大于之前的某个元素
                if (nums[i] > nums[j]) {
                    // 更新 dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新全局最大长度
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int result1 = solution.lengthOfLIS(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = [10, 9, 2, 5, 3, 7, 101, 18]");
        System.out.println("输出: " + result1); // 应输出 4

        // 示例 2
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int result2 = solution.lengthOfLIS(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = [0, 1, 0, 3, 2, 3]");
        System.out.println("输出: " + result2); // 应输出 4

        // 示例 3
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        int result3 = solution.lengthOfLIS(nums3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = [7, 7, 7, 7, 7, 7, 7]");
        System.out.println("输出: " + result3); // 应输出 1
    }
}
