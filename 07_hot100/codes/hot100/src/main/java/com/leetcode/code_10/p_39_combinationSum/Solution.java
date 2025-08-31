package com.leetcode.code_10.p_39_combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * 回溯算法 + 剪枝 解法
     *
     * 算法思路：
     * 这是一个典型的组合搜索问题，非常适合使用回溯算法。由于每个数字可以被无限次重复使用，
     * 我们需要在递归中设计一种方式来体现这一点。
     *
     * 1. **预处理**：
     *    - 为了进行有效的剪枝，我们首先对 `candidates` 数组进行排序。
     *
     * 2. **定义回溯函数 `backtrack(result, currentCombination, remainder, start)`**:
     *    - `result`: 存储最终所有有效组合的列表。
     *    - `currentCombination`: 当前正在构建的组合。
     *    - `remainder`: 剩余需要凑成的目标和。
     *    - `start`: 当前选择的起点索引。这个参数是避免产生重复组合（如 `[2,2,3]` 和 `[2,3,2]`）的关键。
     *
     * 3. **递归的终止条件 (Base Case)**:
     *    - 如果 `remainder` 变为 0，说明我们找到了一个有效的组合。我们将 `currentCombination` 的一个副本添加到 `result` 列表中，然后返回。
     *    - 如果 `remainder` 变为负数，说明当前路径不可行，直接返回。
     *
     * 4. **递归的探索与剪枝**:
     *    - 我们从 `start` 索引开始遍历 `candidates` 数组。
     *    - **剪枝**: 如果 `remainder < candidates[i]`，由于数组已排序，后续的候选数只会更大，不可能凑成 `remainder`。因此，我们可以直接中断循环。
     *    - **探索**:
     *      a. **选择 (Choose)**: 将 `candidates[i]` 添加到 `currentCombination`。
     *      b. **递归 (Explore)**: 递归调用 `backtrack`。注意，下一个选择的起点仍然是 `i`，
     *         `backtrack(..., remainder - candidates[i], i)`。这允许我们重复使用当前的数字 `candidates[i]`。
     *      c. **撤销选择 (Unchoose / Backtrack)**: 在从递归返回后，将 `currentCombination` 末尾的元素移除，以便探索其他分支。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int[] candidates, int remainder, int start) {
        // 终止条件 1: 找到了一个有效的组合
        if (remainder == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        // 终止条件 2: 剩余和小于0，此路不通
        if (remainder < 0) {
            return;
        }

        // 从 start 索引开始，避免重复组合
        for (int i = start; i < candidates.length; i++) {
            // 剪枝：如果当前候选数已经大于剩余和，后续的数也一样，直接中断
            if (candidates[i] > remainder) {
                break;
            }

            // 1. 作出选择
            currentCombination.add(candidates[i]);
            // 2. 进入下一层决策 (注意：下一轮的起点仍然是 i，因为元素可以重复使用)
            backtrack(result, currentCombination, candidates, remainder - candidates[i], i);
            // 3. 撤销选择 (回溯)
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result1 = solution.combinationSum(candidates1, target1);
        System.out.println("示例 1:");
        System.out.println("输入: candidates = " + Arrays.toString(candidates1) + ", target = " + target1);
        System.out.println("输出: " + result1); // 应输出 [[2, 2, 3], [7]]

        // 示例 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = solution.combinationSum(candidates2, target2);
        System.out.println("\n示例 2:");
        System.out.println("输入: candidates = " + Arrays.toString(candidates2) + ", target = " + target2);
        System.out.println("输出: " + result2); // 应输出 [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        // 示例 3
        int[] candidates3 = {2};
        int target3 = 1;
        List<List<Integer>> result3 = solution.combinationSum(candidates3, target3);
        System.out.println("\n示例 3:");
        System.out.println("输入: candidates = " + Arrays.toString(candidates3) + ", target = " + target3);
        System.out.println("输出: " + result3); // 应输出 []
    }
}
