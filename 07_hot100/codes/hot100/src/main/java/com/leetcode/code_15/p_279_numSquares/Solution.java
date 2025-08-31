package com.leetcode.code_15.p_279_numSquares;

import java.util.Arrays;

public class Solution {
    /**
     * 动态规划解法
     *
     * 算法思路：
     * 这个问题可以转化为一个完全背包问题：有一系列物品，即完全平方数 (1, 4, 9, ...)，
     * 我们需要用最少的物品来凑成目标值 n。
     *
     * 1. 状态定义：
     *    `dp[i]` 表示和为 `i` 的完全平方数的最少数量。我们的目标是求 `dp[n]`。
     *
     * 2. 状态转移方程：
     *    要计算 `dp[i]`，我们可以考虑最后一个加上的完全平方数是什么。
     *    假设最后一个加上的数是 `j*j` (其中 `j*j <= i`)，那么 `dp[i]` 就等于 `dp[i - j*j] + 1`。
     *    因为我们要找的是最少数量，所以我们需要遍历所有可能的 `j`，并取其中的最小值。
     *    状态转移方程为：`dp[i] = min(dp[i], dp[i - j*j] + 1)`，其中 `1 <= j*j <= i`。
     *
     * 3. 初始化：
     *    - 我们创建一个长度为 `n+1` 的 `dp` 数组。
     *    - `dp[0] = 0`，因为和为 0 不需要任何数。
     *    - 将数组的其他元素初始化为一个较大的值（例如 `Integer.MAX_VALUE`），以便在 `min` 操作中被正确替换。
     */
    public int numSquares(int n) {
        // dp[i] 表示和为 i 的完全平方数的最少数量
        int[] dp = new int[n + 1];

        // 初始化 dp 数组
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 遍历 1 到 n 的所有数字
        for (int i = 1; i <= n; i++) {
            // 遍历所有小于等于 i 的完全平方数
            for (int j = 1; j * j <= i; j++) {
                // 更新 dp[i]
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int n1 = 12;
        int result1 = solution.numSquares(n1);
        System.out.println("示例 1:");
        System.out.println("输入: n = " + n1);
        System.out.println("输出: " + result1); // 应输出 3

        // 示例 2
        int n2 = 13;
        int result2 = solution.numSquares(n2);
        System.out.println("\n示例 2:");
        System.out.println("输入: n = " + n2);
        System.out.println("输出: " + result2); // 应输出 2
    }
}
