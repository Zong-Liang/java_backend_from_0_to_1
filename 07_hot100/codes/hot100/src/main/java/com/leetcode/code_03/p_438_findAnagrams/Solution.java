package com.leetcode.code_03.p_438_findAnagrams;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // 边界条件
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        
        // 假设字符集为小写字母，长度为 26
        int[] pFreq = new int[26]; // p 的字符频率
        int[] windowFreq = new int[26]; // 滑动窗口的字符频率
        
        // 计算 p 的字符频率
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }
        
        // 初始化窗口：前 p.length() 个字符
        for (int i = 0; i < p.length(); i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }
        
        // 检查初始窗口是否匹配
        if (isFreqEqual(pFreq, windowFreq)) {
            result.add(0);
        }
        
        // 滑动窗口
        for (int i = p.length(); i < s.length(); i++) {
            // 移除窗口最左边的字符
            windowFreq[s.charAt(i - p.length()) - 'a']--;
            // 添加窗口最右边的新字符
            windowFreq[s.charAt(i) - 'a']++;
            
            // 检查当前窗口是否匹配
            if (isFreqEqual(pFreq, windowFreq)) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
    
    // 比较两个频率数组是否相等
    private boolean isFreqEqual(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 测试用例 1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println("Test 1: " + solution.findAnagrams(s1, p1)); // 应输出 [0, 6]
        
        // 测试用例 2
        String s2 = "abab";
        String p2 = "ab";
        System.out.println("Test 2: " + solution.findAnagrams(s2, p2)); // 应输出 [0, 1, 2]
    }
}
