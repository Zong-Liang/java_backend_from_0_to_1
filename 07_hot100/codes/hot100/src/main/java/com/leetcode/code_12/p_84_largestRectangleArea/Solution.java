package com.leetcode.code_12.p_84_largestRectangleArea;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class Solution {
    /**
     * 单调栈解法
     *
     * 算法思路：
     * 问题的核心是对于每一个柱子 `i`，找到以它为高度所能构成的最大矩形的面积。
     * 这个矩形的宽度由 `i` 左边第一个比它矮的柱子和右边第一个比它矮的柱子决定。
     * 单调栈（Monotonic Stack）是一种非常适合解决这类“寻找下一个更大/更小元素”问题的数据结构。
     *
     * 1. **维护一个单调递增栈**：我们使用一个栈来存储柱子的索引，并确保栈中索引对应的高度是单调递增的。
     *
     * 2. **遍历与计算**：
     *    - 我们从左到右遍历每个柱子 `i`。
     *    - 如果当前柱子的高度 `heights[i]` 小于栈顶索引所对应的柱子高度，说明我们找到了栈顶柱子的“右边界”（即当前柱子 `i`）。
     *    - 此时，我们将栈顶元素弹出，并计算以它为高度的矩形面积：
     *      - **高度 (height)**：就是刚刚弹出的栈顶索引所对应的柱子高度 `heights[top]`。
     *      - **右边界 (right)**：是当前遍历到的索引 `i`。
     *      - **左边界 (left)**：是弹出 `top` 之后，新的栈顶索引。如果栈变为空，说明左侧没有比它更矮的柱子，左边界为 -1。
     *      - **宽度 (width)**：`right - left - 1`。
     *      - **面积 (area)**：`height * width`。
     *    - 我们不断重复这个弹出和计算的过程，直到栈顶柱子的高度小于等于当前柱子的高度。
     *    - 最后，将当前柱子的索引 `i` 压入栈中，维持栈的单调性。
     *
     * 3. **处理剩余元素**：
     *    - 遍历完所有柱子后，栈中可能还剩下一些索引。这些柱子的右边界可以看作是整个柱状图的末尾（索引 `n`）。
     *    - 我们依次将它们弹出，并按照同样的方式计算面积，直到栈为空。
     *    - 为了简化代码，我们可以在遍历时，将 `i` 循环到 `n`（`n` 是 `heights` 的长度），并假设 `heights[n]` 的高度为 0，这样就能确保所有元素都被处理。
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        // Deque is preferred over Stack for stack operations
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            // Use a sentinel height of 0 to process all remaining bars in the stack
            int h = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                int height = heights[stack.pop()];

                // Calculate width
                // Right boundary is i. Left boundary is the new stack top.
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            // Push current index to stack
            stack.push(i);
        }

        return maxArea;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        int result1 = solution.largestRectangleArea(heights1);
        System.out.println("示例 1:");
        System.out.println("输入: heights = " + Arrays.toString(heights1));
        System.out.println("输出: " + result1); // 应输出 10

        // 示例 2
        int[] heights2 = {2, 4};
        int result2 = solution.largestRectangleArea(heights2);
        System.out.println("\n示例 2:");
        System.out.println("输入: heights = " + Arrays.toString(heights2));
        System.out.println("输出: " + result2); // 应输出 4
    }
}
