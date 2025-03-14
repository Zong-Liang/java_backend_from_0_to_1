# [32_最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/)

难度：困难

## 问题描述：

给你一个只包含 `'('` 和 `')'` 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

**示例 1：**

```java
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
```

**示例 2：**

```java
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
```

**示例 3：**

```java
输入：s = ""
输出：0
```

## 解题思路：



## Java代码：

```java
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        
        int maxLen = 0;
        int left = 0, right = 0;
        
        // 从左到右遍历
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLen = Math.max(maxLen, left + right);
            } else if (right > left) {
                // 右括号多了，重置计数器
                left = right = 0;
            }
        }
        
        // 重置计数器
        left = right = 0;
        
        // 从右到左遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            
            if (left == right) {
                maxLen = Math.max(maxLen, left + right);
            } else if (left > right) {
                // 左括号多了，重置计数器
                left = right = 0;
            }
        }
        
        return maxLen;
    }
}
```

