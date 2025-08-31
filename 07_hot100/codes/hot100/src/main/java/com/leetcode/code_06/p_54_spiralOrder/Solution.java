package com.leetcode.code_06.p_54_spiralOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 按层模拟遍历解法
     *
     * 算法思路：
     * 我们可以将螺旋遍历看作是一层一层地“剥开”矩阵。我们维护四个变量来表示当前待遍历层的边界：
     * `top`, `bottom`, `left`, `right`。
     *
     * 1. **循环条件**:
     *    - 只要 `left <= right` 并且 `top <= bottom`，就说明还有元素未被遍历，循环继续。
     *
     * 2. **遍历一层 (四步)**:
     *    a. **从左到右 (上边界)**: 遍历 `top` 行，从 `left` 列到 `right` 列，将元素加入结果列表。
     *       完成后，上边界向下收缩 (`top++`)。
     *
     *    b. **从上到下 (右边界)**: 遍历 `right` 列，从 `top` 行到 `bottom` 行，将元素加入结果列表。
     *       完成后，右边界向左收缩 (`right--`)。
     *
     *    c. **从右到左 (下边界)**: 遍历 `bottom` 行，从 `right` 列到 `left` 列，将元素加入结果列表。
     *       完成后，下边界向上收缩 (`bottom--`)。
     *
     *    d. **从下到上 (左边界)**: 遍历 `left` 列，从 `bottom` 行到 `top` 行，将元素加入结果列表。
     *       完成后，左边界向右收缩 (`left++`)。
     *
     * 3. **边界检查**:
     *    - 在第 c 步和第 d 步开始前，需要进行一次额外的边界检查 (`if (top <= bottom)` 和 `if (left <= right)`)。
     *    - 这是为了处理那些只有一行或一列的矩阵，防止在收缩边界后重复遍历。
     *
     * 4. **返回结果**:
     *    - 当循环结束时，所有元素都已被按螺旋顺序添加到结果列表中。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (left <= right && top <= bottom) {
            // 从左到右
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // 从上到下
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // 检查是否还有行可以遍历
            if (top <= bottom) {
                // 从右到左
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // 检查是否还有列可以遍历
            if (left <= right) {
                // 从下到上
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result1 = solution.spiralOrder(matrix1);
        System.out.println("示例 1:");
        System.out.println("输入: [[1,2,3],[4,5,6],[7,8,9]]");
        System.out.println("输出: " + result1); // 应输出: [1,2,3,6,9,8,7,4,5]

        // 示例 2
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> result2 = solution.spiralOrder(matrix2);
        System.out.println("\n示例 2:");
        System.out.println("输入: [[1,2,3,4],[5,6,7,8],[9,10,11,12]]");
        System.out.println("输出: " + result2); // 应输出: [1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
