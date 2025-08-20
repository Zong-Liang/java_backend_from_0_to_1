package com.leetcode.code_16.p_72_minDistance;

public class Solution {
    /**
     * 动态规划求解编辑距离
     * @param word1 单词1
     * @param word2 单词2
     * @return 将 word1 转换成 word2 所使用的最少操作数
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] 表示 word1 的前 i 个字符转换成 word2 的前 j 个字符所使用的最少操作数
        int[][] dp = new int[m + 1][n + 1];

        // 初始化边界条件
        // 当 word2 为空时，将 word1 转换为空字符串需要删除 i 个字符
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // 当 word1 为空时，将空字符串转换为 word2 需要插入 j 个字符
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 填充 dp 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 获取当前比较的字符
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);

                if (c1 == c2) {
                    // 如果两个字符相同，则不需要任何操作
                    // 操作数等于 dp[i-1][j-1]
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果两个字符不同，则需要进行一次操作（插入、删除或替换）
                    // 取三者中的最小值
                    // 1. 替换：dp[i-1][j-1] + 1 (将 word1[i-1] 替换为 word2[j-1])
                    // 2. 删除：dp[i-1][j] + 1 (删除 word1[i-1])
                    // 3. 插入：dp[i][j-1] + 1 (在 word1 后插入 word2[j-1])
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        // 返回最终结果
        return dp[m][n];
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String word1_1 = "horse";
        String word2_1 = "ros";
        int result1 = solution.minDistance(word1_1, word2_1);
        System.out.println("示例 1: " + result1); // 应输出 3

        // 示例 2
        String word1_2 = "intention";
        String word2_2 = "execution";
        int result2 = solution.minDistance(word1_2, word2_2);
        System.out.println("示例 2: " + result2); // 应输出 5
    }
}
