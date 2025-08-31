package com.leetcode.code_06.p_48_rotate;

import java.util.Arrays;

public class Solution {

    /**
     * 先水平翻转，再主对角线翻转的解法
     *
     * 算法思路：
     * 直接原地进行顺时针 90 度旋转的坐标变换比较复杂。我们可以将这个操作分解为两个更简单的步骤：
     *
     * 1. **上下水平翻转**:
     *    - 将矩阵的第 `i` 行与第 `n - 1 - i` 行进行交换。
     *    - 例如，第 0 行与最后一行交换，第 1 行与倒数第二行交换，以此类推。
     *
     * 2. **沿主对角线翻转 (转置)**:
     *    - 经过第一步翻转后，我们再将矩阵沿主对角线（从左上到右下）进行翻转。
     *    - 这意味着交换元素 `matrix[i][j]` 和 `matrix[j][i]`。
     *
     * 经过这两步操作后，得到的结果就等同于将原始矩阵顺时针旋转了 90 度。
     * 这种方法的优点是逻辑清晰，易于实现，并且是原地操作。
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. 上下水平翻转
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }

        // 2. 沿主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
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
        System.out.println("示例 1:");
        System.out.println("输入: " + Arrays.deepToString(matrix1));
        solution.rotate(matrix1);
        System.out.println("输出: " + Arrays.deepToString(matrix1));
        // 应输出: [[7,4,1],[8,5,2],[9,6,3]]

        // 示例 2
        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        System.out.println("\n示例 2:");
        System.out.println("输入: " + Arrays.deepToString(matrix2));
        solution.rotate(matrix2);
        System.out.println("输出: " + Arrays.deepToString(matrix2));
        // 应输出: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }
}
