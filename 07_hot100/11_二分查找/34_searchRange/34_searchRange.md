# [34_在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)

难度：中等

## 问题描述：

给你一个按照非递减顺序排列的整数数组 `nums`，和一个目标值 `target`。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 `target`，返回 `[-1, -1]`。

你必须设计并实现时间复杂度为 `O(log n)` 的算法解决此问题。

 **示例 1：**

```java
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
```

**示例 2：**

```java
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
```

**示例 3：**

```java
输入：nums = [], target = 0
输出：[-1,-1]
```

**提示：**`nums` 是一个非递减数组

## 解题思路：



## Java代码：

```java
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        // 找第一个大于等于target的位置
        int firstPosition = findPosition(nums, target);
        
        // 如果找不到目标值或第一个位置越界
        if (firstPosition == nums.length || nums[firstPosition] != target) {
            return new int[]{-1, -1};
        }
        
        // 找第一个大于target的位置，再减1
        int lastPosition = findPosition(nums, target + 1) - 1;
        
        return new int[]{firstPosition, lastPosition};
    }
    
    // 查找数组中第一个大于等于target的位置
    private int findPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
```

