# [322_零钱兑换](https://leetcode.cn/problems/coin-change/)

难度：中等

## 问题描述：

给你一个整数数组 `coins` ，表示不同面额的硬币；以及一个整数 `amount` ，表示总金额。

计算并返回可以凑成总金额所需的 **最少的硬币个数** 。如果没有任何一种硬币组合能组成总金额，返回 `-1` 。

你可以认为每种硬币的数量是无限的。

**示例 1：**

```java
输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1
```

**示例 2：**

```java
输入：coins = [2], amount = 3
输出：-1
```

**示例 3：**

```java
输入：coins = [1], amount = 0
输出：0
```

## 解题思路：



## Java代码：

```java
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // 创建dp数组，初始值设为amount+1（一个不可能的值，因为最多只需要amount个面值为1的硬币）
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        // 基础情况：凑成金额0需要0个硬币
        dp[0] = 0;
        
        // 动态规划过程
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        // 如果dp[amount]没有被更新，说明无法凑成总金额
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```

