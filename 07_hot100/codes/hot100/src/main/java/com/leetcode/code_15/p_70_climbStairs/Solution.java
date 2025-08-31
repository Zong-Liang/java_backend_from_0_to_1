package com.leetcode.code_15.p_70_climbStairs;

public class Solution {
    /**
     * 动态规划解法 (滚动数组/空间优化)
     *
     * 算法思路：
     * 这个问题可以被分解为一个个子问题，符合动态规划的特征。
     * 假设 dp[i] 是爬到第 i 阶楼梯的方法数。
     *
     * 1. 状态定义：dp[i] 表示到达第 i 阶楼梯的总方法数。
     *
     * 2. 状态转移方程：
     *    - 要想到达第 i 阶，我们只能从第 i-1 阶（爬1阶）或第 i-2 阶（爬2阶）上来。
     *    - 因此，到达第 i 阶的方法数等于到达第 i-1 阶和第 i-2 阶的方法数之和。
     *    - dp[i] = dp[i-1] + dp[i-2]
     *    - 这正是斐波那契数列的递推公式。
     *
     * 3. 初始化 (Base Case):
     *    - dp[1] = 1 (到第1阶只有1种方法：1)
     *    - dp[2] = 2 (到第2阶有2种方法：1+1, 2)
     *
     * 4. 空间优化：
     *    - 我们注意到，计算 dp[i] 只需要 dp[i-1] 和 dp[i-2] 的值。
     *    - 因此，我们不需要一个完整的 dp 数组，只需要两个变量来存储前两个状态即可，这被称为“滚动数组”思想，可以将空间复杂度从 O(n) 优化到 O(1)。
     */
    public int climbStairs(int n) {
        // 当 n <= 2 时，方法数就等于 n
        if (n <= 2) {
            return n;
        }

        // 使用两个变量来模拟滚动数组
        // p 代表 dp[i-2]，q 代表 dp[i-1]
        int p = 1; // 对应 dp[1]
        int q = 2; // 对应 dp[2]

        // 从第 3 阶开始循环
        for (int i = 3; i <= n; i++) {
            // r 代表 dp[i]
            int r = p + q;
            // 更新 p 和 q 的值，为下一次循环做准备
            p = q;
            q = r;
        }

        // 循环结束后，q 的值就是 dp[n] 的结果
        return q;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int n1 = 2;
        int result1 = solution.climbStairs(n1);
        System.out.println("示例 1:");
        System.out.println("输入: n = " + n1);
        System.out.println("输出: " + result1); // 应输出 2

        // 示例 2
        int n2 = 3;
        int result2 = solution.climbStairs(n2);
        System.out.println("\n示例 2:");
        System.out.println("输入: n = " + n2);
        System.out.println("输出: " + result2); // 应输出 3
    }
}
