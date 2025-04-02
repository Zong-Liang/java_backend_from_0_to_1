package com.leetcode.code_03.p_01_lengthOfLongestSubstring;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 边界条件：如果字符串为空，返回 0
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 使用 HashMap 记录字符最近出现的位置
        HashMap<Character, Integer> charPosition = new HashMap<>();

        // 滑动窗口的左右指针
        int left = 0;
        int maxLength = 0;

        // 遍历字符串，right 作为右指针
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果当前字符已经在窗口内（即它的位置 >= left）
            if (charPosition.containsKey(currentChar) && charPosition.get(currentChar) >= left) {
                // 更新左边界到重复字符的下一个位置
                left = charPosition.get(currentChar) + 1;
            }

            // 更新当前字符的位置
            charPosition.put(currentChar, right);

            // 计算当前窗口长度，并更新最大长度
            int currentLength = right - left + 1;
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        String s1 = "abcabcbb";
        System.out.println("Test 1: " + solution.lengthOfLongestSubstring(s1)); // 应输出 3

        // 测试用例 2
        String s2 = "bbbbb";
        System.out.println("Test 2: " + solution.lengthOfLongestSubstring(s2)); // 应输出 1

        // 测试用例 3
        String s3 = "pwwkew";
        System.out.println("Test 3: " + solution.lengthOfLongestSubstring(s3)); // 应输出 3
    }
}
