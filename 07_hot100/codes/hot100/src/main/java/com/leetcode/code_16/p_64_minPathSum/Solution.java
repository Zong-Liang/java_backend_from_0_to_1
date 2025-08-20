package com.leetcode.code_16.p_64_minPathSum;

public class Solution {
    /**
     * 动态规划解法
     * @param grid 一个包含非负整数的 m x n 网格
     * @return 从左上角到右下角的最小路径和
     */
    public int minPathSum(int[][] grid) {
        // 检查输入是否有效
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // 使用 grid 数组本身作为 DP 表，grid[i][j] 将存储到达 (i, j) 的最小路径和

        // 初始化第一行：只能从左边过来
        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }

        // 初始化第一列：只能从上边过来
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        // 填充 DP 表的其余部分
        // 对于 grid[i][j]，它可以从 grid[i-1][j] (上) 或 grid[i][j-1] (左) 到达
        // 我们选择路径和较小的那一个
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        // 最终结果存储在右下角
        return grid[m - 1][n - 1];
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int result1 = solution.minPathSum(grid1);
        System.out.println("示例 1: " + result1); // 应输出 7

        // 示例 2
        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int result2 = solution.minPathSum(grid2);
        System.out.println("示例 2: " + result2); // 应输出 12
    }
}
