# [31_下一个排列](https://leetcode.cn/problems/next-permutation/)

难度：中等

## 问题描述：

整数数组的一个 **排列** 就是将其所有成员以序列或线性顺序排列。

- 例如，`arr = [1,2,3]` ，以下这些都可以视作 `arr` 的排列：`[1,2,3]`、`[1,3,2]`、`[3,1,2]`、`[2,3,1]` 。

整数数组的 **下一个排列** 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 **下一个排列** 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

- 例如，`arr = [1,2,3]` 的下一个排列是 `[1,3,2]` 。
- 类似地，`arr = [2,3,1]` 的下一个排列是 `[3,1,2]` 。
- 而 `arr = [3,2,1]` 的下一个排列是 `[1,2,3]` ，因为 `[3,2,1]` 不存在一个字典序更大的排列。

给你一个整数数组 `nums` ，找出 `nums` 的下一个排列。

必须**[ 原地 ](https://baike.baidu.com/item/原地算法)**修改，只允许使用额外常数空间。

**示例 1：**

```java
输入：nums = [1,2,3]
输出：[1,3,2]
```

**示例 2：**

```java
输入：nums = [3,2,1]
输出：[1,2,3]
```

**示例 3：**

```java
输入：nums = [1,1,5]
输出：[1,5,1]
```

## 解题思路：



## Java代码：

```java
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int n = nums.length;
        int i = n - 2;
        
        // 步骤1: 从后向前找第一个满足 nums[i] < nums[i+1] 的元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // 如果找到了这样的元素
        if (i >= 0) {
            int j = n - 1;
            
            // 步骤2: 从后向前找第一个大于 nums[i] 的元素
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            
            // 步骤3: 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }
        
        // 步骤4: 反转 nums[i+1] 到数组末尾的所有元素
        reverse(nums, i + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
```

