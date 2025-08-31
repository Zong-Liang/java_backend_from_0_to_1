package com.leetcode.code_01.p_01_twoSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Solution {
    /**
     * 哈希表解法
     *
     * 算法思路：
     * 我们可以通过一次遍历来解决这个问题。在遍历数组的同时，我们使用一个哈希表来存储已经遍历过的数字及其索引。
     *
     * 1. 创建一个哈希表 `map`，用于存储 <数字, 索引> 的键值对。
     * 2. 遍历数组 `nums`，对于每个数字 `nums[i]`：
     *    a. 计算我们需要寻找的目标补数 `complement = target - nums[i]`。
     *    b. 检查哈希表中是否存在这个 `complement`。
     *       - 如果存在，说明我们找到了解。`complement` 的索引（存储在哈希表中）和当前数字的索引 `i` 就是答案。
     *       - 直接返回 `[map.get(complement), i]`。
     *    c. 如果 `complement` 不在哈希表中，就将当前数字 `nums[i]` 及其索引 `i` 存入哈希表，
     *       以备后续的数字进行匹配。
     *
     * 这种方法的时间复杂度为 O(n)，因为我们只遍历数组一次，并且哈希表的查找和插入操作的平均时间复杂度都是 O(1)。
     */
    public int[] twoSum(int[] nums, int target) {
        // 创建哈希表，存储 <数字, 索引>
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 如果 complement 存在于哈希表中，说明找到了答案
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            // 否则将当前数字和索引存入哈希表
            map.put(nums[i], i);
        }

        // 题目保证有解，这里不会执行到
        throw new IllegalArgumentException("No two sum solution");
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("示例 1: " + Arrays.toString(result1)); // 应输出 [0, 1]

        // 示例 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("示例 2: " + Arrays.toString(result2)); // 应输出 [1, 2]

        // 示例 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("示例 3: " + Arrays.toString(result3)); // 应输出 [0, 1]
    }
}
