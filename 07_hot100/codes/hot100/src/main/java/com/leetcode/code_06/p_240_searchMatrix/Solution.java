package com.leetcode.code_06.p_240_searchMatrix;

public class Solution {

    /**
     * Z 字形查找 (或称阶梯查找) 解法
     *
     * 算法思路：
     * 这个矩阵的特性是每一行从左到右递增，每一列从上到下递增。
     * 这个特性与第 74 题略有不同（第 74 题是整体有序），但我们可以利用这个局部有序性来设计一个高效的搜索算法。
     *
     * 1. **选择起点**:
     *    - 我们选择矩阵的 **右上角**（或左下角）作为搜索的起点。这里我们以右上角 `(row = 0, col = n-1)` 为例。
     *    - 这个位置的元素 `matrix[row][col]` 非常特殊，它有以下性质：
     *      - 它是当前行的最大值。
     *      - 它是当前列的最小值。
     *
     * 2. **比较与移动 (缩小搜索范围)**:
     *    - 我们将当前位置的元素 `current_val = matrix[row][col]` 与目标值 `target` 进行比较。
     *    - **情况 1: `current_val == target`**:
     *      - 我们找到了目标值，直接返回 `true`。
     *    - **情况 2: `current_val > target`**:
     *      - 由于 `current_val` 是其所在行的最大值，那么 `target` 必定不在当前行（因为它比最大值还小）。
     *      - 因此，我们可以安全地排除当前列，向左移动：`col--`。
     *    - **情况 3: `current_val < target`**:
     *      - 由于 `current_val` 是其所在列的最小值，那么 `target` 必定不在当前列（因为它比最小值还大）。
     *      - 因此，我们可以安全地排除当前行，向下移动：`row++`。
     *
     * 3. **终止条件**:
     *    - 当 `row` 超出矩阵的行边界或 `col` 超出列边界时，循环终止。
     *    - 如果循环结束仍未找到 `target`，则说明它不存在于矩阵中，返回 `false`。
     *
     * 这种方法在每次比较后都能排除一行或一列，从而逐步缩小搜索空间。其时间复杂度为 O(m + n)。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从右上角开始搜索
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // 排除当前列
            } else { // matrix[row][col] < target
                row++; // 排除当前行
            }
        }

        return false;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
                {1,  4,  7, 11, 15},
                {2,  5,  8, 12, 19},
                {3,  6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        // 示例 1
        int target1 = 5;
        boolean result1 = solution.searchMatrix(matrix, target1);
        System.out.println("示例 1:");
        System.out.println("输入: target = " + target1);
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2
        int target2 = 20;
        boolean result2 = solution.searchMatrix(matrix, target2);
        System.out.println("\n示例 2:");
        System.out.println("输入: target = " + target2);
        System.out.println("输出: " + result2); // 应输出 false
    }
}
