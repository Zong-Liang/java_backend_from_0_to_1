package com.leetcode.code_10.p_131_partition;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 回溯算法解法
     *
     * 算法思路：
     * 这个问题要求我们找到所有可能的分割方案，这是一个典型的组合搜索问题，非常适合使用回溯算法。
     * 我们可以将问题看作：从字符串的开头开始，尝试切分出第一个子串，如果这个子串是回文串，
     * 那么我们就对剩余的部分递归地进行同样的操作。
     *
     * 1. **定义回溯函数 `backtrack(s, start, currentPartition, result)`**:
     *    - `s`: 原始输入字符串。
     *    - `start`: 当前正在处理的子串的起始索引。
     *    - `currentPartition`: 当前已经构建好的一个分割方案（一个字符串列表）。
     *    - `result`: 存储最终所有有效分割方案的列表。
     *
     * 2. **递归的终止条件 (Base Case)**:
     *    - 当 `start` 索引到达或超过字符串的末尾（`start >= s.length()`）时，
     *      说明我们已经成功地将整个字符串分割完毕。
     *    - 此时，我们将 `currentPartition` 的一个副本添加到 `result` 列表中，并结束当前递归路径。
     *
     * 3. **递归的探索与回溯**:
     *    - 我们从 `start` 索引开始，向后遍历，尝试不同的分割点 `i`。
     *    - 对于每一个 `i`（从 `start` 到 `s.length() - 1`），我们检查子串 `s.substring(start, i + 1)` 是否为回文串。
     *    - 如果 `s.substring(start, i + 1)` 是一个回文串：
     *      a. **选择 (Choose)**: 将这个回文子串添加到 `currentPartition`。
     *      b. **探索 (Explore)**: 递归调用 `backtrack` 函数，处理剩余的字符串，新的起始点为 `i + 1`。
     *      c. **撤销选择 (Unchoose / Backtrack)**: 当从下一层的递归调用返回后，我们需要撤销刚才的选择，
     *         即将刚刚添加的回文子串从 `currentPartition` 中移除。这使得我们可以回溯到之前的状态，
     *         去探索更长的第一个回文子串的可能性（即增大 `i`）。
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // 终止条件：如果起始位置已经到达字符串末尾，说明找到了一个完整的分割方案
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // 遍历所有可能的分割点
        for (int i = start; i < s.length(); i++) {
            // 检查从 start 到 i 的子串是否是回文串
            if (isPalindrome(s, start, i)) {
                // 1. 作出选择
                String palindrome = s.substring(start, i + 1);
                currentPartition.add(palindrome);

                // 2. 进入下一层决策
                backtrack(s, i + 1, currentPartition, result);

                // 3. 撤销选择 (回溯)
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    // 辅助函数：判断一个子串是否为回文串
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "aab";
        List<List<String>> result1 = solution.partition(s1);
        System.out.println("示例 1:");
        System.out.println("输入: s = \"" + s1 + "\"");
        System.out.println("输出: " + result1);
        // 应输出: [["a", "a", "b"], ["aa", "b"]]

        // 示例 2
        String s2 = "a";
        List<List<String>> result2 = solution.partition(s2);
        System.out.println("\n示例 2:");
        System.out.println("输入: s = \"" + s2 + "\"");
        System.out.println("输出: " + result2);
        // 应输出: [["a"]]
    }
}
