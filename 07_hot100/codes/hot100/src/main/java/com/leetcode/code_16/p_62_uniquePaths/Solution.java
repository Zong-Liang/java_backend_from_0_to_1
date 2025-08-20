package com.leetcode.code_16.p_62_uniquePaths;

public class Solution {
    /**
     * 动态规划求解不同路径
     * @param m 网格的行数
     * @param n 网格的列数
     * @return 从左上角到右下角的不同路径总数
     */
    public int uniquePaths(int m, int n) {
        // 创建一个 m x n 的二维数组作为 DP 表
        // dp[i][j] 表示从起点 (0, 0) 到达 (i, j) 的路径数量
        int[][] dp = new int[m][n];

        // 初始化 DP 表的边界条件
        // 1. 对于第一行 (i=0)，机器人只能从左边走过来，所以路径数都为 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 2. 对于第一列 (j=0)，机器人只能从上边走过来，所以路径数也为 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 填充 DP 表的其余部分
        // 状态转移方程：到达 (i, j) 的路径数等于到达其上方格子 (i-1, j) 的路径数
        // 加上到达其左方格子 (i, j-1) 的路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 最终结果存储在右下角的格子里
        return dp[m - 1][n - 1];
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int m1 = 3, n1 = 7;
        int result1 = solution.uniquePaths(m1, n1);
        System.out.println("示例 1: " + result1); // 应输出 28

        // 示例 2
        int m2 = 3, n2 = 2;
        int result2 = solution.uniquePaths(m2, n2);
        System.out.println("示例 2: " + result2); // 应输出 3

        // 示例 3
        int m3 = 7, n3 = 3;
        int result3 = solution.uniquePaths(m3, n3);
        System.out.println("示例 3: " + result3); // 应输出 28

        // 示例 4
        int m4 = 3, n4 = 3;
        int result4 = solution.uniquePaths(m4, n4);
        System.out.println("示例 4: " + result4); // 应输出 6
    }
}
