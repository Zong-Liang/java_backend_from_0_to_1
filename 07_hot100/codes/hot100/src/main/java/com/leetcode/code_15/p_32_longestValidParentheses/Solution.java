package com.leetcode.code_15.p_32_longestValidParentheses;

import java.util.Stack;

public class Solution {
    /**
     * 动态规划解法
     *
     * 算法思路：
     * 我们使用一个 dp 数组，其中 dp[i] 表示以索引 i 结尾的字符串的最长有效括号的长度。
     *
     * 状态转移方程：
     * 1. 我们初始化一个长度与字符串 s 相同的 dp 数组，并全部填为 0。
     * 2. 我们从左到右遍历字符串 s (从索引 1 开始)。
     *    - 如果 s.charAt(i) 是 '('，那么以它结尾的子串不可能是有效的括号，所以 dp[i] = 0。
     *    - 如果 s.charAt(i) 是 ')'，我们需要分两种情况考虑它前面的字符 s.charAt(i - 1)：
     *
     *      a. 如果 s.charAt(i - 1) 是 '('，这意味着我们找到了一个 "()" 对。
     *         此时，dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2。
     *         这表示 "()" 的长度 2 加上在它之前可能存在的有效括号子串的长度 (dp[i-2])。
     *
     *      b. 如果 s.charAt(i - 1) 是 ')'，形成类似 "...))" 的模式。
     *         我们需要向前寻找一个匹配的 '('。这个 '(' 的位置应该是 i - dp[i - 1] - 1。
     *         我们称这个位置为 prev_open_index。
     *         如果 prev_open_index >= 0 并且 s.charAt(prev_open_index) == '('，说明我们找到了一个匹配。
     *         那么 dp[i] 的长度就等于：
     *         i. 内部有效括号的长度：dp[i-1]
     *         ii. 包裹它的 "()" 的长度：2
     *         iii. 在这个新形成的有效子串之前可能存在的另一个有效子串的长度：dp[prev_open_index - 1]
     *         所以，dp[i] = dp[i - 1] + 2 + (prev_open_index >= 1 ? dp[prev_open_index - 1] : 0)。
     *
     * 3. 在遍历过程中，我们用一个变量 maxLen 记录下 dp 数组中的最大值，这个最大值就是最终的结果。
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int maxLen = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 情况 a: "...()"
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    // 情况 b: "...))"
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    int prevLen = (i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0;
                    dp[i] = dp[i - 1] + 2 + prevLen;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
    /**
     * 栈解法
     *
     * 算法思路：
     * 我们使用一个栈来帮助我们检查括号的有效性，并计算长度。
     * 栈底始终保持一个“基准”索引，这个基准是当前我们所计算的有效括号子串的起始点的前一个位置。
     * 1. 初始化栈，并放入 -1 作为初始的基准。
     * 2. 遍历字符串：
     *    a. 如果遇到左括号 '('，我们将其索引压入栈中。
     *    b. 如果遇到右括号 ')'，我们弹出栈顶元素。
     *       i. 如果弹出后栈为空，说明当前的右括号没有与之匹配的左括号。此时，我们将当前右括号的索引压入栈中，作为新的“基准”。
     *       ii. 如果弹出后栈不为空，说明当前的右括号找到了匹配。有效括号的长度就是当前索引 i 减去栈顶元素（新的基准）的索引。我们用这个长度更新最大长度。
     */
//    public int longestValidParentheses(String s) {
//        int maxLen = 0;
//        // 使用栈来存储左括号的索引
//        Stack<Integer> stack = new Stack<>();
//        // 关键：放入-1作为栈底，作为有效括号子串的计算边界
//        stack.push(-1);
//
//        // 遍历字符串
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                // 如果是左括号，将其索引入栈
//                stack.push(i);
//            } else {
//                // 如果是右括号，弹出栈顶元素
//                stack.pop();
//                if (stack.isEmpty()) {
//                    // 如果栈为空，说明当前的')'没有匹配的'('
//                    // 将当前索引作为新的边界入栈
//                    stack.push(i);
//                } else {
//                    // 如果栈不为空，计算当前有效长度
//                    // 长度为当前索引 - 栈顶索引（上一个未匹配的位置）
//                    maxLen = Math.max(maxLen, i - stack.peek());
//                }
//            }
//        }
//        return maxLen;
//    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "(()";
        int result1 = solution.longestValidParentheses(s1);
        System.out.println("示例 1:");
        System.out.println("输入: s = \"" + s1 + "\"");
        System.out.println("输出: " + result1); // 应输出 2
        System.out.println("解释: 最长有效括号子串是 \"()\"");

        // 示例 2
        String s2 = ")()())";
        int result2 = solution.longestValidParentheses(s2);
        System.out.println("\n示例 2:");
        System.out.println("输入: s = \"" + s2 + "\"");
        System.out.println("输出: " + result2); // 应输出 4
        System.out.println("解释: 最长有效括号子串是 \"()()\"");

        // 示例 3
        String s3 = "";
        int result3 = solution.longestValidParentheses(s3);
        System.out.println("\n示例 3:");
        System.out.println("输入: s = \"" + s3 + "\"");
        System.out.println("输出: " + result3); // 应输出 0
    }
}
