# [1_两数之和](https://leetcode.cn/problems/two-sum/)

## 问题描述：

给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 **和为目标值** *`target`* 的那 **两个** 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。

你可以按任意顺序返回答案。

**示例 1：**

```java
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

**示例 2：**

```java
输入：nums = [3,2,4], target = 6
输出：[1,2]
```

**示例 3：**

```java
输入：nums = [3,3], target = 6
输出：[0,1]
```

**进阶：**你可以想出一个时间复杂度小于 $O(n^2)$ 的算法吗？

## 解题思路：



## Java代码：

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 创建哈希表，用于存储数组元素的值和索引
        Map<Integer, Integer> map = new HashMap<>();
        
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素与目标值的差值(补数)
            int complement = target - nums[i];
            
            // 检查哈希表中是否存在这个补数
            if (map.containsKey(complement)) {
                // 如果存在，返回补数的索引和当前索引
                return new int[] { map.get(complement), i };
            }
            
            // 如果不存在，将当前元素的值和索引添加到哈希表中
            map.put(nums[i], i);
        }
        
        // 根据题目假设，应该总是有解的，但为了完整性添加以下返回
        throw new IllegalArgumentException("No solution found");
    }
}
```
