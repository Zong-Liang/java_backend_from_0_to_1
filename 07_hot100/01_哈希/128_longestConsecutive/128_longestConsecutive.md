# [128_最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/)

## 问题描述：

给定一个未排序的整数数组 `nums` ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 $O(n)$ 的算法解决此问题。

**示例 1：**

```java
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
```

**示例 2：**

```java
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
```

**示例 3：**

```java
输入：nums = [1,0,1,2]
输出：3
```

## 解题思路：

## Java代码：

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        // 边界条件判断
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 将所有数字加入哈希集合
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // 优化：直接从集合中遍历，而不是从原数组遍历
        // 这样可以避免重复元素带来的额外计算
        for (int num : numSet) {
            // 只有当num-1不存在时，才开始向后查找连续序列
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 向后查找连续的数字
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // 更新最长连续序列的长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
```

