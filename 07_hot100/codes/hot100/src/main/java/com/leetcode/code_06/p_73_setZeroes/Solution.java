package com.leetcode.code_06.p_73_setZeroes;

import java.util.Arrays;

public class Solution {

    /**
     * 使用第一行和第一列作为标记的常数空间解法
     *
     * 算法思路：
     * 一个简单的方法是使用 O(m+n) 的额外空间来记录哪些行和列需要被置零。
     * 为了实现 O(1) 的常数空间复杂度，我们可以复用矩阵自身的第一行和第一列来作为这个标记空间。
     *
     * 1. **特殊标记第一行/列**:
     *    - 我们需要两个独立的标记来记录第一行和第一列本身是否需要被置零。
     *    - `isFirstRowZero`: 一个布尔值，检查第一行中是否原本就存在 0。
     *    - `isFirstColZero`: 一个布尔值，检查第一列中是否原本就存在 0。
     *
     * 2. **第一遍遍历：使用第一行/列记录信息**:
     *    - 遍历除第一行和第一列之外的矩阵部分（从 `matrix[1][1]` 开始）。
     *    - 如果发现 `matrix[i][j] == 0`，就将这个信息记录在对应的第一行和第一列上，
     *      即 `matrix[i][0] = 0` 和 `matrix[0][j] = 0`。
     *
     * 3. **第二遍遍历：根据标记置零**:
     *    - 再次遍历除第一行和第一列之外的矩阵部分。
     *    - 如果 `matrix[i][0] == 0` 或者 `matrix[0][j] == 0`，就说明 `matrix[i][j]` 所在的行或列
     *      在原始矩阵中有 0，因此将 `matrix[i][j]` 置为 0。
     *
     * 4. **最后处理第一行/列**:
     *    - 根据我们最初记录的 `isFirstRowZero` 和 `isFirstColZero` 标记，
     *      决定是否需要将整个第一行和第一列置为 0。
     */
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean isFirstColZero = false;

        // 1. 检查第一列是否需要置零，并用一个变量记录
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        // 2. 检查第一行是否需要置零，并用第一行的第一个元素 matrix[0][0] 记录
        // 注意：matrix[0][0] 同时属于第一行和第一列，我们让它优先代表第一行
        // 第一列的状态已经由 isFirstColZero 记录
        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                matrix[0][0] = 0;
                break;
            }
        }

        // 3. 遍历内部矩阵，用第一行和第一列记录 0 的位置
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 4. 根据标记将内部矩阵置零
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 5. 根据标记 matrix[0][0] 将第一行置零
        if (matrix[0][0] == 0) {
            for (int j = 1; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // 6. 根据标记 isFirstColZero 将第一列置零
        if (isFirstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println("示例 1:");
        System.out.println("输入: " + Arrays.deepToString(matrix1));
        solution.setZeroes(matrix1);
        System.out.println("输出: " + Arrays.deepToString(matrix1));
        // 应输出: [[1,0,1],[0,0,0],[1,0,1]]

        // 示例 2
        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        System.out.println("\n示例 2:");
        System.out.println("输入: " + Arrays.deepToString(matrix2));
        solution.setZeroes(matrix2);
        System.out.println("输出: " + Arrays.deepToString(matrix2));
        // 应输出: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    }
}
