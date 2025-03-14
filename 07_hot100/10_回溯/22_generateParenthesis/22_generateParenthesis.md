# [22_括号生成](https://leetcode.cn/problems/generate-parentheses/)

难度：中等

## 问题描述：

数字 `n` 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 **有效的** 括号组合。

**示例 1：**

```java
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
```

**示例 2：**

```java
输入：n = 1
输出：["()"]
```

## 解题思路：



## Java代码：

```java
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    /**
     * @param result 存储结果的列表
     * @param current 当前生成的字符串
     * @param open 已使用的左括号数量
     * @param close 已使用的右括号数量
     * @param max 括号对数
     */
    private void backtrack(List<String> result, String current, 
                         int open, int close, int max) {
        // 如果字符串长度达到要求，添加到结果集
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // 如果左括号数量小于n，可以添加左括号
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // 如果右括号数量小于左括号数量，可以添加右括号
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
```

