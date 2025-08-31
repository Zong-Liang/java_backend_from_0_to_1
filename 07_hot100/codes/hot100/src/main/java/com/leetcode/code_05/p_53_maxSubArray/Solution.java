package com.leetcode.code_05.p_53_maxSubArray;

import java.util.Arrays;

public class Solution {

    /**
     * 动态规划 (Kadane's 算法) 解法
     *
     * 算法思路：
     * 这个问题可以通过一次遍历来解决。我们维护两个变量：
     * 1. `currentSum`: 表示以当前元素结尾的连续子数组的最大和。
     * 2. `maxSum`: 表示到目前为止，我们找到的全局最大子数组和。
     *
     * **状态转移**:
     * 当我们遍历到 `nums[i]` 时，要计算以 `nums[i]` 结尾的 `currentSum`，我们有两个选择：
     * a. 将 `nums[i]` 加入到之前的子数组中，新的和为 `currentSum + nums[i]`。
     * b. 从 `nums[i]` 开始一个新的子数组，和就是 `nums[i]` 本身。
     *
     * 我们选择这两种情况中较大的那个作为新的 `currentSum`。
     * `currentSum = max(nums[i], currentSum + nums[i])`
     *
     * 这个选择的逻辑是：如果之前的 `currentSum` 是负数，那么它对当前 `nums[i]` 来说是个“累赘”，
     * 加上它只会让和变小。在这种情况下，我们还不如从 `nums[i]` 重新开始计算。
     *
     * **更新全局最大值**:
     * 在每一步计算出新的 `currentSum` 后，我们都用它来更新 `maxSum`，以确保 `maxSum` 始终记录着
     * 我们在整个遍历过程中遇到的最大子数组和。
     * `maxSum = max(maxSum, currentSum)`
     *
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // 或者根据题目约束抛出异常
        }

        // maxSum 初始化为数组的第一个元素
        int maxSum = nums[0];
        // currentSum 也初始化为数组的第一个元素
        int currentSum = nums[0];

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 状态转移：决定是继续累加还是重新开始
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // 更新全局最大和
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArray(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1));
        System.out.println("输出: " + result1); // 应输出 6

        // 示例 2
        int[] nums2 = {1};
        int result2 = solution.maxSubArray(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + result2); // 应输出 1

        // 示例 3
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = solution.maxSubArray(nums3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + result3); // 应输出 23
    }
}
