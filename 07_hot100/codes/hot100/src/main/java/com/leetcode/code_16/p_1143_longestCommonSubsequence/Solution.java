package com.leetcode.code_16.p_1143_longestCommonSubsequence;

public class Solution {
    /**
     * 动态规划求解最长公共子序列
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 最长公共子序列的长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // 创建 DP 表，dp[i][j] 表示 text1 的前 i 个字符和 text2 的前 j 个字符的最长公共子序列的长度
        // DP 表大小为 (m+1) x (n+1) 是为了方便处理边界情况（即一个字符串为空时）
        int[][] dp = new int[m + 1][n + 1];

        // 遍历两个字符串，填充 DP 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 获取当前比较的字符
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);

                // 状态转移方程
                if (c1 == c2) {
                    // 如果当前两个字符相等，则最长公共子序列长度等于它们各自前一个位置的LCS长度加一
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果当前两个字符不相等，则最长公共子序列长度等于 text1 前 i-1 个字符与 text2 前 j 个字符的LCS
                    // 或者 text1 前 i 个字符与 text2 前 j-1 个字符的LCS 中的较大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // dp[m][n] 存储了整个 text1 和 text2 的最长公共子序列的长度
        return dp[m][n];
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String text1_1 = "abcde";
        String text2_1 = "ace";
        int result1 = solution.longestCommonSubsequence(text1_1, text2_1);
        System.out.println("示例 1: " + result1); // 应输出 3

        // 示例 2
        String text1_2 = "abc";
        String text2_2 = "abc";
        int result2 = solution.longestCommonSubsequence(text1_2, text2_2);
        System.out.println("示例 2: " + result2); // 应输出 3

        // 示例 3
        String text1_3 = "abc";
        String text2_3 = "def";
        int result3 = solution.longestCommonSubsequence(text1_3, text2_3);
        System.out.println("示例 3: " + result3); // 应输出 0
    }
}
