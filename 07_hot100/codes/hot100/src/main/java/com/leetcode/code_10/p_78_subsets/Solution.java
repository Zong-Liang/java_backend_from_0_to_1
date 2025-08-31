package com.leetcode.code_10.p_78_subsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * 回溯算法解法
     *
     * 算法思路：
     * 这个问题要求我们找出所有可能的子集（幂集）。我们可以将这个问题看作是一个决策树，
     * 对于原数组中的每一个元素，我们都有两种选择：“选择”它加入当前子集，或者“不选择”它。
     * 回溯算法正是用来系统地探索这棵决策树的。
     *
     * 1. **定义回溯函数 `backtrack(result, currentSubset, nums, start)`**:
     *    - `result`: 存储最终所有子集的列表。
     *    - `currentSubset`: 当前正在构建的子集。
     *    - `nums`: 原始输入数组。
     *    - `start`: 当前决策的起点索引。这个参数用于避免生成重复的子集，确保我们只考虑当前元素及其之后的元素。
     *
     * 2. **递归的探索与回溯**:
     *    - 首先，将当前构建的 `currentSubset`（无论其内容如何）的一个副本添加到 `result` 列表中。
     *      因为从空集到包含所有元素的集合，在构建过程中的每一步都是一个有效的子集。
     *    - 然后，我们从 `start` 索引开始遍历 `nums` 数组。
     *    - 对于每一个元素 `nums[i]`：
     *      a. **选择 (Choose)**: 将 `nums[i]` 添加到 `currentSubset`。
     *      b. **探索 (Explore)**: 递归调用 `backtrack` 函数，进入下一层决策。
     *         下一层的起始索引是 `i + 1`，表示下一个选择将从 `nums[i]` 之后的元素开始。
     *      c. **撤销选择 (Unchoose / Backtrack)**: 当从下一层的递归调用返回后，我们需要撤销刚才的选择，
     *         即将 `nums[i]` 从 `currentSubset` 中移除。这使得我们可以回溯到之前的状态，去探索不包含 `nums[i]` 的其他分支。
     *
     * 3. **初始调用**:
     *    - 我们从 `backtrack(result, new ArrayList<>(), nums, 0)` 开始，
     *      初始子集为空，并从数组的第 0 个元素开始决策。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // 将当前子集（包括空集）添加到结果列表中
        result.add(new ArrayList<>(currentSubset));

        // 从 start 索引开始遍历，为当前子集添加新元素
        for (int i = start; i < nums.length; i++) {
            // 1. 作出选择
            currentSubset.add(nums[i]);
            // 2. 进入下一层决策
            backtrack(result, currentSubset, nums, i + 1);
            // 3. 撤销选择 (回溯)
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.subsets(nums1);
        System.out.println("示例 1:");
        System.out.println("输入: nums = " + Arrays.toString(nums1));
        System.out.println("输出: " + result1);
        // 输出: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]] (顺序可能不同)

        // 示例 2
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsets(nums2);
        System.out.println("\n示例 2:");
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + result2);
        // 输出: [[], [0]]
    }
}
