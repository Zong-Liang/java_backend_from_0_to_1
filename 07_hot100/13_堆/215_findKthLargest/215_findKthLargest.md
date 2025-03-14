# [215_数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/)

难度：中等

## 问题描述：

给定整数数组 `nums` 和整数 `k`，请返回数组中第 `**k**` 个最大的元素。

请注意，你需要找的是数组排序后的第 `k` 个最大的元素，而不是第 `k` 个不同的元素。

你必须设计并实现时间复杂度为 $O(n)$ 的算法解决此问题。

 **示例 1:**

```java
输入: [3,2,1,5,6,4], k = 2
输出: 5
```

**示例 2:**

```java
输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4
```

## 解题思路：



## Java代码：

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 将第k大转换为第(n-k+1)小，这样便于使用快速选择算法
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int kSmallest) {
        // 如果数组只包含一个元素，直接返回
        if (left == right) {
            return nums[left];
        }
        
        // 选择一个随机位置作为枢轴，并进行分区
        int pivotIndex = left + (int)(Math.random() * (right - left + 1));
        pivotIndex = partition(nums, left, right, pivotIndex);
        
        // 如果枢轴正好是我们要找的位置
        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } 
        // 如果kSmallest小于pivotIndex，则在左分区查找
        else if (kSmallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        } 
        // 否则在右分区查找
        else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        }
    }
    
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        
        // 将枢轴移到末尾
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        
        // 将小于枢轴值的元素移到左侧
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        
        // 将枢轴放回正确的位置
        swap(nums, storeIndex, right);
        
        return storeIndex;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
```

