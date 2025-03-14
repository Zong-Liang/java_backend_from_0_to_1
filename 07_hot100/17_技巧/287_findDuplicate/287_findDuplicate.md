# [287_寻找重复数](https://leetcode.cn/problems/find-the-duplicate-number/)

难度：中等

## 问题描述：

给定一个包含 `n + 1` 个整数的数组 `nums` ，其数字都在 `[1, n]` 范围内（包括 `1` 和 `n`），可知至少存在一个重复的整数。

假设 `nums` 只有 **一个重复的整数** ，返回 **这个重复的数** 。

你设计的解决方案必须 **不修改** 数组 `nums` 且只用常量级 $O(1)$ 的额外空间。

**示例 1：**

```java
输入：nums = [1,3,4,2,2]
输出：2
```

**示例 2：**

```java
输入：nums = [3,1,3,4,2]
输出：3
```

**示例 2：**

```java
输入：nums = [3,3,3,3,3]
输出：3
```

**提示：**`nums` 中 **只有一个整数** 出现 **两次或多次** ，其余整数均只出现 **一次**

## 解题思路：



## Java代码：

```java
public class Solution {
    public int findDuplicate(int[] nums) {
        // 初始化快慢指针
        int slow = nums[0];
        int fast = nums[0];
        
        // 第一阶段：找到相遇点
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // 第二阶段：找到环的入口
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
```

