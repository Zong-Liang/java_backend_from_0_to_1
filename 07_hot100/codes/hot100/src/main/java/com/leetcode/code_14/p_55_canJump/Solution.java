package com.leetcode.code_14.p_55_canJump;

public class Solution {
    /**
     * 贪心算法解法
     *
     * 算法思路：
     * 我们的目标是判断是否能到达最后一个位置。我们可以使用贪心策略，在每一步都计算出当前能够到达的最远距离。
     *
     * 1. 维护一个变量 `maxReach`，表示从起点出发，目前能够到达的最远索引位置。
     * 2. 遍历数组，对于每个位置 `i`，我们首先检查它是否是可达的。如果当前位置 `i` 大于 `maxReach`，
     *    说明我们无论如何都无法到达位置 `i`，因此也就不可能到达终点，直接返回 `false`。
     * 3. 如果当前位置 `i` 是可达的，我们就利用 `nums[i]` 的跳跃能力来更新 `maxReach`。
     *    从位置 `i` 出发，最远可以跳到 `i + nums[i]`。因此，我们更新 `maxReach = max(maxReach, i + nums[i])`。
     * 4. 在遍历过程中，如果 `maxReach` 已经大于或等于数组的最后一个索引，说明终点已经可达，
     *    我们可以提前返回 `true`。
     * 5. 如果循环顺利完成，也说明最后一个位置是可达的，返回 `true`。
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int maxReach = 0; // 当前能到达的最远距离

        // 遍历数组的每个位置
        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置 i 已经超过了我们能到达的最远距离，那么就不可能到达终点
            if (i > maxReach) {
                return false;
            }

            // 更新能到达的最远距离
            maxReach = Math.max(maxReach, i + nums[i]);

            // 如果最远距离已经覆盖了数组末尾，可以直接返回 true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        // 循环结束，说明可以到达（实际上在上面的 if 中已经返回了）
        return true;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {2, 3, 1, 1, 4};
        boolean result1 = solution.canJump(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = [2, 3, 1, 1, 4]");
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2
        int[] nums2 = {3, 2, 1, 0, 4};
        boolean result2 = solution.canJump(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = [3, 2, 1, 0, 4]");
        System.out.println("输出: " + result2); // 应输出 false
    }
}
