package com.leetcode.code_10.p_46_permute;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    /**
     * 回溯算法解法
     *
     * 算法思路：
     * 这是一个典型的排列问题，可以使用回溯算法来解决。回溯算法通过深度优先搜索（DFS）的方式
     * 探索所有可能的解。我们可以将其想象成一个决策树，在树的每一层，我们决定排列中的一个位置应该放哪个数字。
     *
     * 1. **定义回溯函数 `backtrack(result, currentPermutation, nums, used)`**:
     *    - `result`: 存储最终所有排列的列表。
     *    - `currentPermutation`: 当前正在构建的排列。
     *    - `nums`: 原始输入数组。
     *    - `used`: 一个布尔数组，用于标记 `nums` 中的某个数字是否已经被添加到 `currentPermutation` 中，以避免重复使用。
     *
     * 2. **递归的终止条件 (Base Case)**:
     *    - 当 `currentPermutation` 的长度等于 `nums` 的长度时，说明我们已经构建了一个完整的排列。
     *    - 此时，我们将 `currentPermutation` 的一个副本添加到 `result` 列表中，然后返回。
     *
     * 3. **递归的探索与回溯**:
     *    - 遍历原始数组 `nums` 中的每一个数字。
     *    - 对于数字 `nums[i]`：
     *      a. **剪枝 (Pruning)**: 如果 `used[i]` 为 `true`，说明这个数字已经在当前的 `currentPermutation` 中了，我们跳过它以避免重复。
     *      b. **选择 (Choose)**: 将 `nums[i]` 添加到 `currentPermutation` 中，并将其标记为已使用 (`used[i] = true`)。
     *      c. **探索 (Explore)**: 递归调用 `backtrack` 函数，进入下一层的决策。
     *      d. **撤销选择 (Unchoose / Backtrack)**: 当从下一层的递归调用返回后，我们需要撤销刚才的选择，以便探索其他可能性。
     *         即将 `nums[i]` 从 `currentPermutation` 中移除，并将其标记为未使用 (`used[i] = false`)。
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPermutation, int[] nums, boolean[] used) {
        // 终止条件：当排列的长度等于原数组的长度时，添加结果并返回
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字已经被使用过，则跳过
            if (used[i]) {
                continue;
            }

            // 1. 作出选择
            used[i] = true;
            currentPermutation.add(nums[i]);

            // 2. 进入下一层决策
            backtrack(result, currentPermutation, nums, used);

            // 3. 撤销选择 (回溯)
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.permute(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1));
        System.out.println("输出: " + result1);
        // 输出: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

        // 示例 2
        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = solution.permute(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + result2);
        // 输出: [[0, 1], [1, 0]]

        // 示例 3
        int[] nums3 = {1};
        List<List<Integer>> result3 = solution.permute(nums3);
        System.out.println("\n示例 3:");
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + result3);
        // 输出: [[1]]
    }
}
