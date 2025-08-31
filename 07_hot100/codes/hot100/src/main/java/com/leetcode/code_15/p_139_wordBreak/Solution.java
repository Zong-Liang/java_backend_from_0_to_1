package com.leetcode.code_15.p_139_wordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * 动态规划解法
     *
     * 算法思路：
     * 这个问题可以被看作是一个组合问题，非常适合使用动态规划来解决。
     *
     * 1. 状态定义：
     *    我们创建一个布尔类型的数组 `dp`，长度为 `s.length() + 1`。
     *    `dp[i]` 表示字符串 `s` 的前 `i` 个字符（即 `s.substring(0, i)`）是否可以被拆分成字典中的单词。
     *
     * 2. 状态转移方程：
     *    要确定 `dp[i]` 的值，我们需要遍历所有可能的分割点 `j` (其中 `0 <= j < i`)。
     *    如果 `dp[j]` 为 `true`（表示 `s` 的前 `j` 个字符可以被拆分），并且从 `j` 到 `i-1` 的子字符串 `s.substring(j, i)` 存在于字典中，
     *    那么 `dp[i]` 就为 `true`。
     *    只要找到一个满足条件的分割点 `j`，我们就可以确定 `dp[i]` 为 `true` 并停止对 `j` 的搜索。
     *    公式可以表示为：`dp[i] = OR(dp[j] && wordDict.contains(s.substring(j, i)))` for `0 <= j < i`
     *
     * 3. 初始化：
     *    `dp[0] = true`。这是一个重要的基础情况，它表示一个空字符串可以被（空）拆分，这为我们的递推提供了起点。
     *
     * 4. 优化：
     *    为了快速查询一个单词是否存在于字典中，我们将 `wordDict` 列表转换为一个哈希集合 (HashSet)。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将字典列表转换为哈希集合，以提高查询效率
        Set<String> wordSet = new HashSet<>(wordDict);
        // dp[i] 表示 s 的前 i 位是否可以用 wordDict 中的单词表示
        boolean[] dp = new boolean[s.length() + 1];

        // 初始化：空字符串总是可以被表示
        dp[0] = true;

        // 遍历字符串 s 的所有前缀
        for (int i = 1; i <= s.length(); i++) {
            // 遍历所有可能的分割点 j
            for (int j = 0; j < i; j++) {
                // 如果 s[0..j-1] 可以被表示，并且 s[j..i-1] 是一个字典单词
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // 只要找到一种拆分方式，就可以确定 dp[i] 为 true，跳出内层循环
                    break;
                }
            }
        }

        // 返回整个字符串 s 是否可以被拆分
        return dp[s.length()];
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        boolean result1 = solution.wordBreak(s1, wordDict1);
        System.out.println("示例 1:");
        System.out.println("输入: s = \"" + s1 + "\", wordDict = " + wordDict1);
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        boolean result2 = solution.wordBreak(s2, wordDict2);
        System.out.println("\n示例 2:");
        System.out.println("输入: s = \"" + s2 + "\", wordDict = " + wordDict2);
        System.out.println("输出: " + result2); // 应输出 true

        // 示例 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean result3 = solution.wordBreak(s3, wordDict3);
        System.out.println("\n示例 3:");
        System.out.println("输入: s = \"" + s3 + "\", wordDict = " + wordDict3);
        System.out.println("输出: " + result3); // 应输出 false
    }
}
