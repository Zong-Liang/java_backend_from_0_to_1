# [279_完全平方数](https://leetcode.cn/problems/perfect-squares/)

难度：中等

## 问题描述：

给你一个整数 `n` ，返回 *和为 `n` 的完全平方数的最少数量* 。

**完全平方数** 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，`1`、`4`、`9` 和 `16` 都是完全平方数，而 `3` 和 `11` 不是。

**示例 1：**

```java
输入：n = 12
输出：3 
解释：12 = 4 + 4 + 4
```

**示例 2：**

```java
输入：n = 13
输出：2
解释：13 = 4 + 9
```

## 解题思路：

## Java代码：

```java
public class Solution {
    public int numSquares(int n) {
        // 创建dp数组，初始值设为最大可能值（即n）
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        
        // 初始化
        dp[0] = 0;
        
        // 动态规划过程
        for (int i = 1; i <= n; i++) {
            // 遍历所有小于等于i的平方根的数
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}
```

