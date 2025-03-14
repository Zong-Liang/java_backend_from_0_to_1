# [416_分割等和子集](https://leetcode.cn/problems/partition-equal-subset-sum/)

难度：中等

## 问题描述：

给你一个 **只包含正整数** 的 **非空** 数组 `nums` 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

**示例 1：**

```java
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
```

**示例 2：**

```java
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
```

## 解题思路：



## Java代码：

```java
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        // 计算数组总和
        for (int num : nums) {
            sum += num;
        }
        
        // 如果总和是奇数，无法分割成两个和相等的子集
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        
        // 创建动态规划数组
        boolean[] dp = new boolean[target + 1];
        
        // 初始条件：和为0的子集总是存在的（空子集）
        dp[0] = true;
        
        // 动态规划过程
        for (int num : nums) {
            // 从后向前遍历，避免重复使用同一个数字
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }
}
```

```java
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int maxNum = 0;
        
        // 计算数组总和和找出最大元素
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        
        // 如果总和是奇数，无法分割成两个和相等的子集
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        
        // 如果最大元素大于目标值，无法分割
        if (maxNum > target) {
            return false;
        }
        
        // 如果最大元素等于目标值，可以直接分割
        if (maxNum == target) {
            return true;
        }
        
        // 创建动态规划数组
        boolean[] dp = new boolean[target + 1];
        
        // 初始条件：和为0的子集总是存在的（空子集）
        dp[0] = true;
        
        // 动态规划过程
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
            
            // 如果已经找到解，提前返回
            if (dp[target]) {
                return true;
            }
        }
        
        return dp[target];
    }
}
```

