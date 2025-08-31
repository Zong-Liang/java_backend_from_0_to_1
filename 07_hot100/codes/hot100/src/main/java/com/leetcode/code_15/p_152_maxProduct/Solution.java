package com.leetcode.code_15.p_152_maxProduct;

public class Solution {
    /**
     * 动态规划解法
     *
     * 算法思路：
     * 这个问题与“最大子序和”类似，但由于存在负数，情况变得复杂。一个负数乘以一个最小的负数，可能会得到一个最大的正数。
     * 因此，在遍历数组时，我们需要同时维护两个状态：
     * 1. 以当前元素结尾的【最大乘积】
     * 2. 以当前元素结尾的【最小乘积】
     *
     * 1. 状态定义：
     *    - `maxSoFar`: 遍历到当前位置时，以当前数字结尾的连续子数组的最大乘积。
     *    - `minSoFar`: 遍历到当前位置时，以当前数字结尾的连续子数组的最小乘积。
     *    - `result`: 全局的最大乘积，是我们在整个遍历过程中遇到的所有 `maxSoFar` 的最大值。
     *
     * 2. 状态转移方程：
     *    当我们遍历到 `nums[i]` 时，新的 `maxSoFar` 和 `minSoFar` 可能来自三种情况：
     *    a. `nums[i]` 本身。
     *    b. `nums[i]` 乘以之前的 `maxSoFar`。
     *    c. `nums[i]` 乘以之前的 `minSoFar` (如果 `nums[i]` 是负数，这可能成为新的最大值)。
     *
     *    所以，状态转移可以写作：
     *    - `new_maxSoFar = max(nums[i], nums[i] * old_maxSoFar, nums[i] * old_minSoFar)`
     *    - `new_minSoFar = min(nums[i], nums[i] * old_maxSoFar, nums[i] * old_minSoFar)`
     *
     * 3. 初始化：
     *    - 我们将 `maxSoFar`, `minSoFar`, 和 `result` 都初始化为数组的第一个元素 `nums[0]`。
     *
     * 4. 遍历与更新：
     *    - 从数组的第二个元素开始遍历。
     *    - 在每次循环中，先用一个临时变量存下 `old_maxSoFar`，因为它在计算 `new_minSoFar` 时还需要使用。
     *    - 计算出 `new_maxSoFar` 和 `new_minSoFar`，并更新 `maxSoFar` 和 `minSoFar` 的值。
     *    - 用 `maxSoFar` 更新全局的 `result`。
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 初始化
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // 必须用一个临时变量存储旧的 maxSoFar，因为它在计算新的 minSoFar 时要用到
            int tempMax = maxSoFar;

            // 更新以当前元素结尾的最大乘积
            maxSoFar = Math.max(num, Math.max(num * tempMax, num * minSoFar));
            // 更新以当前元素结尾的最小乘积
            minSoFar = Math.min(num, Math.min(num * tempMax, num * minSoFar));

            // 更新全局最大乘积
            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {2, 3, -2, 4};
        int result1 = solution.maxProduct(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = [2, 3, -2, 4]");
        System.out.println("输出: " + result1); // 应输出 6

        // 示例 2
        int[] nums2 = {-2, 0, -1};
        int result2 = solution.maxProduct(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = [-2, 0, -1]");
        System.out.println("输出: " + result2); // 应输出 0

        // 附加测试
        int[] nums3 = {-2, 3, -4};
        int result3 = solution.maxProduct(nums3);
        System.out.println("\n附加测试:");
        System.out.println("输入: nums = [-2, 3, -4]");
        System.out.println("输出: " + result3); // 应输出 24
    }
}
