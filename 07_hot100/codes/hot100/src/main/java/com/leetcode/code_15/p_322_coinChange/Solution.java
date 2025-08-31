package com.leetcode.code_15.p_322_coinChange;

import java.util.Arrays;

public class Solution {
    /**
     * 动态规划解法
     *
     * 算法思路：
     * 这个问题是一个典型的完全背包问题：给定一堆物品（硬币），每种物品可以无限次使用，
     * 问装满一个特定容量的背包（总金额 amount）最少需要多少件物品。
     *
     * 1. 状态定义：
     *    `dp[i]` 表示凑成总金额为 `i` 所需要的最少的硬币个数。
     *    我们的目标是求解 `dp[amount]`。
     *
     * 2. 状态转移方程：
     *    要计算 `dp[i]`，我们可以考虑构成金额 `i` 的最后一枚硬币。
     *    假设最后一枚硬币的面值为 `coin`，那么凑成金额 `i` 的最少硬币数就等于凑成金额 `i - coin` 的最少硬幣数再加 1。
     *    由于我们有多种面值的硬币，我们需要遍历所有硬币，找出能使 `dp[i]` 值最小的那个。
     *    状态转移方程为：`dp[i] = min(dp[i], dp[i - coin] + 1)`，其中 `coin` 是 `coins` 数组中的一种硬币面值，且 `i >= coin`。
     *
     * 3. 初始化：
     *    - 我们创建一个长度为 `amount + 1` 的 `dp` 数组。
     *    - `dp[0] = 0`，因为凑成金额 0 需要 0 个硬币。
     *    - 将 `dp` 数组的其他元素初始化为一个“极大值”，表示当前金额还无法凑成。
     *      这里我们使用 `amount + 1` 作为极大值，因为硬币面值最小为 1，凑成 `amount` 最多需要 `amount` 个硬币，所以 `amount + 1` 是一个有效的“不可能”值。
     *
     * 4. 结果：
     *    遍历完成后，如果 `dp[amount]` 的值仍然是我们初始化的极大值 `amount + 1`，说明无法凑成总金额，返回 -1。
     *    否则，返回 `dp[amount]`。
     */
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑成金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        // 初始化为一个不可能的值 (amount + 1)
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;

        // 遍历 1 到 amount 的所有金额
        for (int i = 1; i <= amount; i++) {
            // 遍历所有硬币面值
            for (int coin : coins) {
                // 如果当前金额可以由这个硬币组成
                if (i >= coin) {
                    // 状态转移
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果 dp[amount] 没有被更新过，说明无法凑成，返回 -1
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int result1 = solution.coinChange(coins1, amount1);
        System.out.println("示例 1:");
        System.out.println("输入: coins = [1, 2, 5], amount = 11");
        System.out.println("输出: " + result1); // 应输出 3

        // 示例 2
        int[] coins2 = {2};
        int amount2 = 3;
        int result2 = solution.coinChange(coins2, amount2);
        System.out.println("\n示例 2:");
        System.out.println("输入: coins = [2], amount = 3");
        System.out.println("输出: " + result2); // 应输出 -1

        // 示例 3
        int[] coins3 = {1};
        int amount3 = 0;
        int result3 = solution.coinChange(coins3, amount3);
        System.out.println("\n示例 3:");
        System.out.println("输入: coins = [1], amount = 0");
        System.out.println("输出: " + result3); // 应输出 0
    }
}
