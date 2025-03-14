# [300_最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/)

难度：中等

## 问题描述：

给你一个整数数组 `nums` ，找到其中最长严格递增子序列的长度。

**子序列** 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，`[3,6,2,7]` 是数组 `[0,3,1,6,2,2,7]` 的子序列。

**示例 1：**

```java
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
```

**示例 2：**

```java
输入：nums = [0,1,0,3,2,3]
输出：4
```

**示例 3：**

```java
输入：nums = [7,7,7,7,7,7,7]
输出：1
```

**进阶：**你能将算法的时间复杂度降低到 `O(n log(n))` 吗?

## 解题思路：



## Java代码：

```java
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        // dp[i] 表示以 nums[i] 结尾的最长递增子序列长度
        int[] dp = new int[n];
        // 初始化：每个元素自身构成长度为1的子序列
        Arrays.fill(dp, 1);
        
        int maxLen = 1;
        // 动态规划过程
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}
```

```java
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // tails[i] 表示长度为i+1的递增子序列的最小末尾值
        int[] tails = new int[nums.length];
        int size = 0;
        
        for (int num : nums) {
            // 二分查找插入位置
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            // 更新tails数组
            tails[left] = num;
            // 如果插入位置等于size，说明找到了一个更长的子序列
            if (left == size) {
                size++;
            }
        }
        
        return size;
    }
}
```

