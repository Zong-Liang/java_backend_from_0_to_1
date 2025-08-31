package com.leetcode.code_15.p_416_canPartition;

import java.util.Arrays;

public class Solution {
    /**
     * 动态规划解法 (0/1 背包问题)
     *
     * 算法思路：
     * 这个问题可以转化为一个经典的 “0/1 背包” 问题。
     *
     * 1. 问题转换：
     *    - 首先，计算整个数组的总和 `sum`。
     *    - 如果 `sum` 是奇数，那么不可能将它分割成两个和相等的子集，直接返回 `false`。
     *    - 如果 `sum` 是偶数，那么我们的目标就是找到一个子集，其和恰好等于 `target = sum / 2`。
     *    - 如果能找到这样的子集，剩下的元素之和也必然是 `target`，问题就解决了。
     *    - 所以，问题就变成了：能否从数组 `nums` 中选取若干个元素，使得它们的和等于 `target`？
     *
     * 2. 状态定义 (0/1 背包)：
     *    - `dp[j]` 是一个布尔值，表示是否存在一个子集，其和为 `j`。
     *    - 我们创建一个大小为 `target + 1` 的 `dp` 数组。`dp[j] = true` 意味着可以凑成和为 `j`。
     *
     * 3. 状态转移方程：
     *    - 我们遍历数组中的每一个数字 `num`。
     *    - 对于每一个 `num`，我们更新 `dp` 数组。
     *    - 状态转移的核心是：`dp[j] = dp[j] || dp[j - num]`。
     *      - `dp[j]` (旧): 在不考虑当前 `num` 的情况下，是否能凑成和 `j`。
     *      - `dp[j - num]`: 在不考虑当前 `num` 的情况下，是否能凑成和 `j - num`。如果可以，那么加上 `num` 之后就能凑成和 `j`。
     *    - 为了确保每个数字只被使用一次（0/1背包），我们需要从后向前遍历 `j` (从 `target` 到 `num`)。
     *
     * 4. 初始化：
     *    - `dp[0] = true`，因为不选取任何数字，总和为 0，这是我们的出发点。
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果总和为奇数，不可能分割
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        // base case
        dp[0] = true;

        // 遍历物品 (数字)
        for (int num : nums) {
            // 遍历背包容量 (目标和)，必须从后往前
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 5, 11, 5};
        boolean result1 = solution.canPartition(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1));
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2
        int[] nums2 = {1, 2, 3, 5};
        boolean result2 = solution.canPartition(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + result2); // 应输出 false
    }
}
