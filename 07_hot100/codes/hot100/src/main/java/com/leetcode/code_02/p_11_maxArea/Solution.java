package com.leetcode.code_02.p_11_maxArea;

import java.util.Arrays;

public class Solution {

    /**
     * 双指针解法
     *
     * 算法思路：
     * 暴力解法是尝试所有可能的柱子对，计算它们的面积并找出最大值，时间复杂度为 O(n^2)，会超时。
     * 我们可以使用双指针法来优化这个过程。
     *
     * 1. **初始化**:
     *    - 设置一个左指针 `left` 指向数组的开头 (索引 0)。
     *    - 设置一个右指针 `right` 指向数组的末尾 (索引 `n-1`)。
     *    - 初始化 `maxArea` 为 0，用于记录最大面积。
     *
     * 2. **移动指针与计算**:
     *    - 当 `left < right` 时，循环继续。
     *    - 在每一步，我们计算由 `left` 和 `right` 指针所构成的容器的面积：
     *      - `width = right - left`
     *      - `height = min(height[left], height[right])` (容器的高度由较短的板决定)
     *      - `currentArea = width * height`
     *    - 用 `currentArea` 更新 `maxArea`。
     *
     * 3. **指针移动策略 (贪心思想)**:
     *    - 这是算法的关键。在计算完当前面积后，我们应该移动哪个指针？
     *    - 容器的面积由 `宽度` 和 `较短的板的高度` 共同决定。
     *    - 如果我们移动较高的那块板，那么新的宽度会变小，而新的高度 **最多** 保持不变（如果新板更高）或者变小。
     *      这意味着面积 **不可能** 变得更大。
     *    - 因此，为了寻找到可能更大的面积，我们必须尝试增加容器的高度。这只能通过移动 **较短** 的那块板来实现。
     *      - 如果 `height[left] < height[right]`，我们就移动左指针：`left++`。
     *      - 否则，移动右指针：`right--`。
     *
     * 4. **返回结果**:
     *    - 当 `left` 与 `right` 相遇时，循环结束，`maxArea` 中存储的就是最大面积。
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // 计算当前容器的面积
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);

            // 移动指向较短板的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result1 = solution.maxArea(height1);
        System.out.println("示例 1:");
        System.out.println("输入: height = " + Arrays.toString(height1));
        System.out.println("输出: " + result1); // 应输出 49

        // 示例 2
        int[] height2 = {1, 1};
        int result2 = solution.maxArea(height2);
        System.out.println("\n示例 2:");
        System.out.println("输入: height = " + Arrays.toString(height2));
        System.out.println("输出: " + result2); // 应输出 1
    }
}
