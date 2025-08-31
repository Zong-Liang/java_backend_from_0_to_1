package com.leetcode.code_02.p_42_trap;

import java.util.Arrays;

public class Solution {

    /**
     * 双指针解法
     *
     * 算法思路：
     * 一个位置 `i` 能够接到的雨水量，取决于它左边的最高墙 `left_max` 和右边的最高墙 `right_max` 中的较小者。
     * 具体来说，`water[i] = min(left_max, right_max) - height[i]`。
     *
     * 暴力法需要为每个 `i` 都向左和向右扫描来找到 `left_max` 和 `right_max`，时间复杂度为 O(n^2)。
     * 我们可以使用双指针法来优化这个过程，只需一次遍历。
     *
     * 1. **初始化**:
     *    - 设置左指针 `left = 0` 和右指针 `right = n - 1`。
     *    - 设置 `leftMax = 0` 和 `rightMax = 0`，分别记录从左到 `left` 的最高墙和从右到 `right` 的最高墙。
     *    - 初始化 `totalWater = 0`。
     *
     * 2. **移动指针与计算**:
     *    - 当 `left < right` 时，循环继续。
     *    - **核心逻辑**: 我们比较 `height[left]` 和 `height[right]`。
     *      - **如果 `height[left] < height[right]`**:
     *        - 这意味着此时右侧的 `rightMax`（虽然我们还没精确计算出 `right` 到 `n-1` 的 `rightMax`，但我们知道它一定大于等于当前的 `height[right]`）
     *          必然大于等于左侧的 `leftMax`（到目前为止的 `leftMax`）。
     *        - 因此，对于 `left` 位置来说，决定其蓄水量的瓶颈是左侧的 `leftMax`。
     *        - 我们更新 `leftMax = max(leftMax, height[left])`。
     *        - 计算 `left` 位置的蓄水量：`totalWater += leftMax - height[left]`。
     *        - 将左指针右移：`left++`。
     *
     *      - **如果 `height[left] >= height[right]`**:
     *        - 同理，对于 `right` 位置来说，决定其蓄水量的瓶颈是右侧的 `rightMax`。
     *        - 我们更新 `rightMax = max(rightMax, height[right])`。
     *        - 计算 `right` 位置的蓄水量：`totalWater += rightMax - height[right]`。
     *        - 将右指针左移：`right--`。
     *
     * 3. **返回结果**:
     *    - 当 `left` 与 `right` 相遇时，循环结束，`totalWater` 中存储的就是总的雨水量。
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result1 = solution.trap(height1);
        System.out.println("示例 1:");
        System.out.println("输入: height = " + Arrays.toString(height1));
        System.out.println("输出: " + result1); // 应输出 6

        // 示例 2
        int[] height2 = {4, 2, 0, 3, 2, 5};
        int result2 = solution.trap(height2);
        System.out.println("\n示例 2:");
        System.out.println("输入: height = " + Arrays.toString(height2));
        System.out.println("输出: " + result2); // 应输出 9
    }
}
