package com.leetcode.code_15.p_198_rob;

public class Solution {
    /**
     * 动态规划解法 (空间优化)
     *
     * 算法思路：
     * 这个问题是动态规划的经典入门案例。对于每一间房屋，我们都有两种选择：偷或者不偷。
     *
     * 1. 状态定义：
     *    `dp[i]` 表示偷到第 `i` 间房屋时，能够获得的最大金额。
     *
     * 2. 状态转移方程：
     *    当我们考虑第 `i` 间房屋时：
     *    a) 如果我们选择偷第 `i` 间房屋，那么我们就不能偷第 `i-1` 间。此时的最大金额为 `dp[i-2] + nums[i]` (前 `i-2` 间的最大金额加上当前房屋的金额)。
     *    b) 如果我们选择不偷第 `i` 间房屋，那么最大金额就等于偷到第 `i-1` 间房屋时的最大金额，即 `dp[i-1]`。
     *
     *    因此，状态转移方程为：`dp[i] = max(dp[i-1], dp[i-2] + nums[i])`
     *
     * 3. 空间优化：
     *    我们发现，计算 `dp[i]` 只需要 `dp[i-1]` 和 `dp[i-2]` 的信息。所以，我们不需要一个完整的 `dp` 数组，
     *    只需要两个变量来记录前两个状态即可，从而将空间复杂度从 O(n) 降到 O(1)。
     *
     *    - `prevMax`: 相当于 `dp[i-2]`，记录偷到上上间房时的最大金额。
     *    - `currMax`: 相当于 `dp[i-1]`，记录偷到上一间房时的最大金额。
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prevMax = 0; // 记录偷到 i-2 房时的最大金额
        int currMax = 0; // 记录偷到 i-1 房时的最大金额

        // 遍历每一间房屋
        for (int num : nums) {
            // 临时变量存下上一次的 currMax (即 dp[i-1])
            int temp = currMax;
            // 计算偷到当前房屋时的最大金额
            // max(不偷当前房, 偷当前房)
            currMax = Math.max(currMax, prevMax + num);
            // 更新 prevMax, 为下一次迭代做准备
            prevMax = temp;
        }

        return currMax;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 2, 3, 1};
        int result1 = solution.rob(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = [1, 2, 3, 1]");
        System.out.println("输出: " + result1); // 应输出 4

        // 示例 2
        int[] nums2 = {2, 7, 9, 3, 1};
        int result2 = solution.rob(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = [2, 7, 9, 3, 1]");
        System.out.println("输出: " + result2); // 应输出 12
    }
}
