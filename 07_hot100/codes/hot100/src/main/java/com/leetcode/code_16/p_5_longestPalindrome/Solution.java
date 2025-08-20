package com.leetcode.code_16.p_5_longestPalindrome;

public class Solution {
    /**
     * 中心扩展法求解最长回文子串
     * @param s 输入字符串
     * @return s 中最长的回文子串
     */
    public String longestPalindrome(String s) {
        // 边界条件判断
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0; // 记录最长回文子串的起始位置
        int end = 0;   // 记录最长回文子串的结束位置

        // 遍历字符串，以每个字符（或字符间的空隙）为中心进行扩展
        for (int i = 0; i < s.length(); i++) {
            // 1. 以 s[i] 为中心的回文（奇数长度）
            int len1 = expandAroundCenter(s, i, i);
            // 2. 以 s[i] 和 s[i+1] 之间的空隙为中心的回文（偶数长度）
            int len2 = expandAroundCenter(s, i, i + 1);

            // 取两种情况中较长的回文长度
            int len = Math.max(len1, len2);

            // 如果找到了更长的回文子串，则更新起始和结束位置
            if (len > end - start) {
                // 根据中心和长度计算新的起始和结束位置
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // 根据记录的起始和结束位置截取子串
        return s.substring(start, end + 1);
    }

    /**
     * 辅助函数：从给定的中心向两边扩展，查找回文串的长度
     * @param s 输入字符串
     * @param left 左边界
     * @param right 右边界
     * @return 以 [left, right] 为中心的回文串的长度
     */
    private int expandAroundCenter(String s, int left, int right) {
        // 当左右指针没有越界，并且指向的字符相同时，继续向两边扩展
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 返回回文串的长度
        // 循环结束时, left 和 right 指向的是回文串边界之外的第一个不匹配的字符
        // 所以回文串的长度是 right - left - 1
        return right - left - 1;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "babad";
        String result1 = solution.longestPalindrome(s1);
        System.out.println("示例 1: \"" + result1 + "\""); // 应输出 "bab" 或 "aba"

        // 示例 2
        String s2 = "cbbd";
        String result2 = solution.longestPalindrome(s2);
        System.out.println("示例 2: \"" + result2 + "\""); // 应输出 "bb"
    }
}
