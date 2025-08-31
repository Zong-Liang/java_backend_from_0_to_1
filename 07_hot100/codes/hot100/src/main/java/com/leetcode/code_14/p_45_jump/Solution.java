package com.leetcode.code_14.p_45_jump;

public class Solution {
    /**
     * 贪心算法解法
     *
     * 算法思路：
     * 我们的目标是使用最少的跳跃次数到达数组的末尾。我们可以采用贪心策略，在每一步都做出当前看起来最优的选择。
     * 这里的“最优选择”是指，在当前可跳跃的范围内，选择一个能够使我们下一次跳得最远的位置。
     *
     * 我们维护三个变量：
     * 1. `jumps`: 当前已经跳跃的次数。
     * 2. `currentEnd`: 当前这一跳能够到达的最远边界。
     * 3. `farthest`: 从当前位置 `i` 出发，在 `currentEnd` 范围内，我们能到达的最远位置。
     *
     * 算法流程：
     * 1. 我们从左到右遍历数组。
     * 2. 在遍历过程中，不断更新 `farthest`，其值为 `max(farthest, i + nums[i])`。
     *    这表示在当前这一跳的覆盖范围内，我们能为下一跳找到的最远起跳点。
     * 3. 当我们的遍历索引 `i` 到达了 `currentEnd` 时，意味着当前这一跳已经到了它的边界。
     *    此时，我们必须进行下一次跳跃。
     *    - 跳跃次数 `jumps` 加 1。
     *    - 将下一跳的边界 `currentEnd` 更新为我们之前计算出的 `farthest`。
     * 4. 循环直到我们遍历完所有可以作为起跳点的位置（即 `nums.length - 1`）。
     */
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // 我们不需要访问最后一个元素，因为我们是从最后一个元素之前的位置跳到它
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新在当前跳跃范围内，能到达的最远位置
            farthest = Math.max(farthest, i + nums[i]);

            // 如果到达了当前跳跃的边界
            if (i == currentEnd) {
                // 进行下一次跳跃
                jumps++;
                // 更新下一次跳跃的边界
                currentEnd = farthest;

                // 优化：如果下一跳的边界已经可以覆盖或超过终点，可以直接返回结果
                if (currentEnd >= nums.length - 1) {
                    return jumps;
                }
            }
        }
        return jumps;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {2, 3, 1, 1, 4};
        int result1 = solution.jump(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = [2, 3, 1, 1, 4]");
        System.out.println("输出: " + result1); // 应输出 2

        // 示例 2
        int[] nums2 = {2, 3, 0, 1, 4};
        int result2 = solution.jump(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = [2, 3, 0, 1, 4]");
        System.out.println("输出: " + result2); // 应输出 2
    }
}
