# [438_找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/)

难度：中等

## 问题描述：

给定两个字符串 `s` 和 `p`，找到 `s` 中所有 `p` 的 **异位词** 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

 

**示例 1:**

```
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
```

 **示例 2:**

```
输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
```

## 解题思路：



## Java代码：

```java
import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        
        // 统计模式串p中每个字符的出现次数
        int[] pCount = new int[26]; // 假设只包含小写字母
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        
        // 滑动窗口
        int[] sCount = new int[26];
        int pLength = p.length();
        
        // 初始化第一个窗口
        for (int i = 0; i < pLength - 1; i++) {
            if (i < s.length()) {
                sCount[s.charAt(i) - 'a']++;
            }
        }
        
        // 滑动窗口遍历字符串s
        for (int i = pLength - 1; i < s.length(); i++) {
            // 添加当前字符到窗口
            sCount[s.charAt(i) - 'a']++;
            
            // 检查当前窗口是否是p的字母异位词
            if (Arrays.equals(sCount, pCount)) {
                result.add(i - pLength + 1);
            }
            
            // 移除窗口最左边的字符
            sCount[s.charAt(i - pLength + 1) - 'a']--;
        }
        
        return result;
    }
}
```

```java
import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        
        int[] count = new int[26]; // 字符计数差异数组
        
        // 初始化计数差异数组
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        
        int left = 0, right = 0;
        int diff = p.length(); // 需要匹配的字符数
        
        // 滑动窗口
        while (right < s.length()) {
            // 右指针字符进入窗口
            if (count[s.charAt(right) - 'a'] > 0) {
                diff--;
            }
            count[s.charAt(right) - 'a']--;
            right++;
            
            // 如果所有字符都匹配上了
            if (diff == 0) {
                result.add(left);
            }
            
            // 当窗口大小等于p的长度时，左指针向右移动
            if (right - left == p.length()) {
                if (count[s.charAt(left) - 'a'] >= 0) {
                    diff++;
                }
                count[s.charAt(left) - 'a']++;
                left++;
            }
        }
        
        return result;
    }
}
```

