package com.leetcode.code_10.p_17_letterCombinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    // 存储数字到字母的映射
    private static final Map<Character, String> PHONE_MAP = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     * 回溯算法解法
     *
     * 算法思路：
     * 这是一个典型的组合问题，可以使用回溯算法来解决。回溯算法本质上是一种深度优先搜索（DFS），
     * 通过递归来探索所有可能的解。
     *
     * 1. **定义回溯函数 `backtrack(index, currentCombination)`**:
     *    - `index`: 当前正在处理的输入数字字符串 `digits` 的索引。
     *    - `currentCombination`: 一个 `StringBuilder`，用于构建当前的字母组合。
     *
     * 2. **递归的终止条件 (Base Case)**:
     *    - 当 `index` 等于 `digits` 的长度时，说明我们已经为每个数字选择了一个字母，形成了一个完整的组合。
     *    - 此时，我们将 `currentCombination` 转换为字符串并添加到最终的结果列表中，然后返回。
     *
     * 3. **递归的探索与回溯**:
     *    - 获取当前索引 `index` 对应的数字 `digit`。
     *    - 从映射中找到该数字对应的字母字符串 `letters` (例如, '2' -> "abc")。
     *    - 遍历 `letters` 中的每一个字母 `letter`：
     *      a. **选择 (Choose)**: 将 `letter` 追加到 `currentCombination` 的末尾。
     *      b. **探索 (Explore)**: 递归调用 `backtrack(index + 1, currentCombination)`，进入下一层决策。
     *      c. **撤销选择 (Unchoose / Backtrack)**: 在从下一层递归返回后，将 `currentCombination` 末尾的 `letter` 删除。
     *         这一步至关重要，它使得程序可以返回到当前状态，并尝试 `letters` 中的下一个字母。
     */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, new StringBuilder(), digits, 0);
        return combinations;
    }

    private void backtrack(List<String> combinations, StringBuilder currentCombination, String digits, int index) {
        // 终止条件：当组合的长度等于数字的长度时，添加结果并返回
        if (index == digits.length()) {
            combinations.add(currentCombination.toString());
            return;
        }

        // 获取当前数字对应的字母
        char digit = digits.charAt(index);
        String letters = PHONE_MAP.get(digit);

        // 遍历所有可能的字母
        for (char letter : letters.toCharArray()) {
            // 1. 作出选择
            currentCombination.append(letter);
            // 2. 进入下一层决策
            backtrack(combinations, currentCombination, digits, index + 1);
            // 3. 撤销选择 (回溯)
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String digits1 = "23";
        List<String> result1 = solution.letterCombinations(digits1);
        System.out.println("示例 1:");
        System.out.println("输入: digits = \"" + digits1 + "\"");
        System.out.println("输出: " + result1); // 应输出 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

        // 示例 2
        String digits2 = "";
        List<String> result2 = solution.letterCombinations(digits2);
        System.out.println("\n示例 2:");
        System.out.println("输入: digits = \"" + digits2 + "\"");
        System.out.println("输出: " + result2); // 应输出 []

        // 示例 3
        String digits3 = "2";
        List<String> result3 = solution.letterCombinations(digits3);
        System.out.println("\n示例 3:");
        System.out.println("输入: digits = \"" + digits3 + "\"");
        System.out.println("输出: " + result3); // 应输出 ["a", "b", "c"]
    }
}
