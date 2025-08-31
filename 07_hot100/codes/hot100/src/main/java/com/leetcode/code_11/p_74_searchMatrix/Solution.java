package com.leetcode.code_11.p_74_searchMatrix;

public class Solution {
    /**
     * Z 字形查找 (或称阶梯查找) 解法
     *
     * 算法思路：
     * 这个矩阵有两个重要的特性：
     * 1. 每行从左到右递增。
     * 2. 每行的第一个数大于上一行的最后一个数。
     * 这两个特性使得整个矩阵可以被看作一个展开后的一维有序数组，因此可以使用二分查找。
     *
     * 但还有一种更直观且同样高效的方法，即“Z字形查找”。
     *
     * 1. **选择起点**：
     *    我们从矩阵的右上角（或左下角）开始搜索。这里我们选择右上角 `(row = 0, col = n-1)`。
     *    这个位置的元素 `matrix[row][col]` 很特殊：
     *    - 它是当前行的最大值。
     *    - 它是当前列的最小值。
     *
     * 2. **比较与移动**：
     *    - 我们将当前位置的元素 `current_val = matrix[row][col]` 与 `target` 进行比较。
     *    - **如果 `current_val == target`**：我们找到了目标值，返回 `true`。
     *    - **如果 `current_val > target`**：由于 `current_val` 是当前行的最大值，`target` 不可能在当前行（因为它比最大值还小）。
     *      同时，`target` 也可能在当前列的上方。因此，我们排除当前列，向左移动：`col--`。
     *    - **如果 `current_val < target`**：由于 `current_val` 是当前列的最小值，`target` 不可能在当前列（因为它比最小值还大）。
     *      `target` 可能在当前行的右侧，但我们已经排除了。`target` 也可能在下一行。因此，我们排除当前行，向下移动：`row++`。
     *
     * 3. **终止条件**：
     *    - 当 `row` 超出矩阵的行边界或 `col` 超出列边界时，循环终止。
     *    - 如果循环结束仍未找到 `target`，则说明它不存在于矩阵中，返回 `false`。
     *
     * 这种方法每次迭代都会排除一行或一列，因此其时间复杂度为 O(m + n)。
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
            } else {
                row++; // 排除当前行
            }
        }

        return false;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target1 = 3;
        boolean result1 = solution.searchMatrix(matrix1, target1);
        System.out.println("示例 1:");
        System.out.println("输入: target = " + target1);
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2
        int[][] matrix2 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target2 = 13;
        boolean result2 = solution.searchMatrix(matrix2, target2);
        System.out.println("\n示例 2:");
        System.out.println("输入: target = " + target2);
        System.out.println("输出: " + result2); // 应输出 false
    }
}
