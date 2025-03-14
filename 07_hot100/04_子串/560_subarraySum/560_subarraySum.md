# [560_和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/)

难度：中等

## 问题描述：

给你一个整数数组 `nums` 和一个整数 `k` ，请你统计并返回 *该数组中和为 `k` 的子数组的个数* 。

子数组是数组中元素的连续非空序列。

 

**示例 1：**

```
输入：nums = [1,1,1], k = 2
输出：2
```

**示例 2：**

```
输入：nums = [1,2,3], k = 3
输出：2
```

## 解题思路：

## Java代码：

```java
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 边界条件检查
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int count = 0;
        int sum = 0;
        
        // 哈希表：key为前缀和，value为该前缀和出现的次数
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        
        // 初始化：前缀和为0出现了1次（空子数组）
        prefixSumCount.put(0, 1);
        
        for (int num : nums) {
            // 累加当前前缀和
            sum += num;
            
            // 检查是否存在前缀和为(sum-k)的子数组
            // 如果存在，说明从该子数组之后到当前位置的子数组和为k
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            
            // 更新哈希表，增加当前前缀和的计数
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
```

