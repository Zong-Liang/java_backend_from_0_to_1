package com.leetcode.code_03.p_438_findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 滑动窗口解法
     *
     * 算法思路：
     * 这个问题要求我们在字符串 `s` 中找到所有与字符串 `p` 互为“字母异位词”的子串。
     * “字母异位词”意味着两个字符串包含的字符种类和数量完全相同。
     * 我们可以使用一个固定大小的滑动窗口来解决这个问题，窗口的大小就等于 `p` 的长度。
     *
     * 1. **字符计数**:
     *    - 我们需要一种方法来比较窗口内的子串和 `p` 的字符构成是否相同。
     *    - 由于题目说明只包含小写字母，我们可以使用两个长度为 26 的整数数组 `pCounts` 和 `sCounts` 来分别记录 `p` 和当前窗口内子串的字符频率。
     *
     * 2. **初始化窗口**:
     *    - 首先，计算 `p` 的字符频率并存入 `pCounts`。
     *    - 然后，在 `s` 中构建第一个窗口（从索引 0 到 `p.length() - 1`），并计算其字符频率存入 `sCounts`。
     *
     * 3. **滑动与比较**:
     *    - 比较初始窗口的 `sCounts` 和 `pCounts` 是否相等。如果相等，说明找到了一个异位词，将起始索引 0 加入结果列表。
     *    - 然后，我们开始滑动窗口，每次向右移动一格：
     *      a. **移入新字符**: 将 `s` 中新进入窗口的字符的频率在 `sCounts` 中加 1。
     *      b. **移出旧字符**: 将 `s` 中离开窗口的字符的频率在 `sCounts` 中减 1。
     *      c. **比较**: 在每次滑动后，都比较 `sCounts` 和 `pCounts` 是否相等。如果相等，就将当前窗口的起始索引加入结果列表。
     *
     * 4. **返回结果**:
     *    - 当窗口滑动到 `s` 的末尾时，遍历结束，返回包含所有起始索引的结果列表。
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return result;
        }

        // 使用数组来存储字符频率
        int[] pCounts = new int[26];
        int[] sCounts = new int[26];

        // 初始化 p 的频率和 s 的第一个窗口的频率
        for (int i = 0; i < pLen; i++) {
            pCounts[p.charAt(i) - 'a']++;
            sCounts[s.charAt(i) - 'a']++;
        }

        // 检查第一个窗口
        if (Arrays.equals(pCounts, sCounts)) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = 0; i < sLen - pLen; i++) {
            // 移出窗口左侧的字符
            sCounts[s.charAt(i) - 'a']--;
            // 移入窗口右侧的新字符
            sCounts[s.charAt(i + pLen) - 'a']++;

            // 检查当前窗口是否是异位词
            if (Arrays.equals(pCounts, sCounts)) {
                result.add(i + 1);
            }
        }

        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        List<Integer> result1 = solution.findAnagrams(s1, p1);
        System.out.println("示例 1:");
        System.out.println("输入: s = \"" + s1 + "\", p = \"" + p1 + "\"");
        System.out.println("输出: " + result1); // 应输出: [0, 6]

        // 示例 2
        String s2 = "abab";
        String p2 = "ab";
        List<Integer> result2 = solution.findAnagrams(s2, p2);
        System.out.println("\n示例 2:");
        System.out.println("输入: s = \"" + s2 + "\", p = \"" + p2 + "\"");
        System.out.println("输出: " + result2); // 应输出: [0, 1, 2]
    }
}
