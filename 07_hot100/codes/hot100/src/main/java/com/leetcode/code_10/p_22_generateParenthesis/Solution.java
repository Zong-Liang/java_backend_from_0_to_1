package com.leetcode.code_10.p_22_generateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 回溯算法解法
     *
     * 算法思路：
     * 我们可以通过构建一个决策树来生成所有可能的括号组合。在每一步，我们都有两种选择：添加一个左括号 '(' 或添加一个右括号 ')'。
     * 为了确保生成的组合是有效的，我们需要设置一些约束条件（剪枝）。
     *
     * 1. **定义回溯函数 `backtrack(result, currentString, open, close, n)`**:
     *    - `result`: 存储最终所有有效组合的列表。
     *    - `currentString`: 当前正在构建的字符串。
     *    - `open`: 当前已使用的左括号数量。
     *    - `close`: 当前已使用的右括号数量。
     *    - `n`: 目标括号对数。
     *
     * 2. **剪枝条件（约束）**:
     *    a. 我们可以随时添加左括号，只要已使用的左括号数量 `open` 小于 `n`。
     *    b. 我们可以添加右括号，只要已使用的右括号数量 `close` 小于已使用的左括号数量 `open`。这个条件保证了括号的有效性（不会出现 `)(` 这样的情况）。
     *
     * 3. **递归的终止条件 (Base Case)**:
     *    - 当 `currentString` 的长度达到 `2 * n` 时，说明我们已经用完了所有 `n` 对括号。
     *    - 此时，我们找到了一个完整的有效组合，将其添加到 `result` 列表中，并结束当前递归路径。
     *
     * 4. **递归的探索与回溯**:
     *    - 在递归的每一步，我们都尝试应用上述两个约束条件。
     *    - 如果可以添加左括号，我们就添加它，然后递归进入下一层。完成后，我们会通过 `deleteCharAt` 将其移除（回溯），以便探索其他可能性。
     *    - 如果可以添加右括号，我们也进行同样的操作：添加、递归、移除（回溯）。
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder currentString, int open, int close, int n) {
        // 终止条件：当字符串长度达到 2*n 时，添加结果并返回
        if (currentString.length() == n * 2) {
            result.add(currentString.toString());
            return;
        }

        // 尝试添加左括号
        if (open < n) {
            currentString.append('(');
            backtrack(result, currentString, open + 1, close, n);
            currentString.deleteCharAt(currentString.length() - 1); // 回溯
        }

        // 尝试添加右括号
        if (close < open) {
            currentString.append(')');
            backtrack(result, currentString, open, close + 1, n);
            currentString.deleteCharAt(currentString.length() - 1); // 回溯
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int n1 = 3;
        List<String> result1 = solution.generateParenthesis(n1);
        System.out.println("示例 1:");
        System.out.println("输入: n = " + n1);
        System.out.println("输出: " + result1);
        // 应输出 ["((()))", "(()())", "(())()", "()(())", "()()()"]

        // 示例 2
        int n2 = 1;
        List<String> result2 = solution.generateParenthesis(n2);
        System.out.println("\n示例 2:");
        System.out.println("输入: n = " + n2);
        System.out.println("输出: " + result2); // 应输出 ["()"]
    }
}
