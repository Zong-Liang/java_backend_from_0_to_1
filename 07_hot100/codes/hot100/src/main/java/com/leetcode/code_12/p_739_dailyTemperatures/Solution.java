package com.leetcode.code_12.p_739_dailyTemperatures;

import java.util.Stack;
import java.util.Arrays;

public class Solution {
    /**
     * 单调栈解法
     *
     * 算法思路：
     * 这个问题要求我们为每一天找到未来第一个更暖和的日子。这是一个典型的“寻找下一个更大元素”的问题，
     * 非常适合使用单调栈来解决。
     *
     * 1. **维护一个单调递减栈**：
     *    - 我们使用一个栈来存储日期的索引。
     *    - 我们要确保栈中索引所对应的温度是单调递减的（从栈底到栈顶）。
     *
     * 2. **遍历与计算**：
     *    - 我们从左到右遍历温度数组。对于当前天 `i` 和其温度 `T[i]`：
     *    - 我们查看栈顶的索引 `prev_i`。如果当前温度 `T[i]` 比栈顶索引对应的温度 `T[prev_i]` 要高，
     *      这意味着我们为 `prev_i` 这一天找到了答案。
     *    - 我们将 `prev_i` 从栈中弹出，并计算等待天数 `i - prev_i`，然后将结果存入 `answer[prev_i]`。
     *    - 我们持续这个过程，直到栈为空或者栈顶的温度不低于当前温度。
     *    - 最后，我们将当前天的索引 `i` 压入栈中，以备未来寻找比它更暖和的日子。
     *
     * 3. **结果**：
     *    - 我们初始化一个结果数组 `answer`，所有元素都为 0。
     *    - 遍历结束后，如果栈中还有剩余的索引，说明这些天之后再也没有更暖和的日子了，
     *      它们对应的 `answer` 值保持为初始的 0 即可。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // 栈中存储的是数组的索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 当栈不为空，且当前温度高于栈顶索引对应的温度时
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 弹出栈顶索引
                int prevIndex = stack.pop();
                // 计算天数差并记录
                answer[prevIndex] = i - prevIndex;
            }
            // 将当前索引压入栈中
            stack.push(i);
        }

        return answer;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = solution.dailyTemperatures(temperatures1);
        System.out.println("示例 1:");
        System.out.println("输入: temperatures = " + Arrays.toString(temperatures1));
        System.out.println("输出: " + Arrays.toString(result1)); // 应输出 [1, 1, 4, 2, 1, 1, 0, 0]

        // 示例 2
        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.println("\n示例 2:");
        System.out.println("输入: temperatures = " + Arrays.toString(temperatures2));
        System.out.println("输出: " + Arrays.toString(result2)); // 应输出 [1, 1, 1, 0]

        // 示例 3
        int[] temperatures3 = {30, 60, 90};
        int[] result3 = solution.dailyTemperatures(temperatures3);
        System.out.println("\n示例 3:");
        System.out.println("输入: temperatures = " + Arrays.toString(temperatures3));
        System.out.println("输出: " + Arrays.toString(result3)); // 应输出 [1, 1, 0]
    }
}
