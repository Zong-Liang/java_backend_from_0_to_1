package com.leetcode.code_15.p_118_generate;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 动态规划/迭代解法
     *
     * 算法思路：
     * 杨辉三角的每一行都依赖于上一行。我们可以通过迭代的方式，逐行构建杨辉三角。
     *
     * 1. 初始化一个最终的结果列表 `triangle`，它将包含所有生成的行。
     * 2. 遍历从 0 到 numRows - 1 的每一行（我们用索引 i 代表第 i+1 行）。
     * 3. 在每次循环中，创建一个新的列表 `row` 来表示当前行。
     * 4. 遍历当前行的每一个元素（我们用索引 j 代表当前行的第 j+1 个元素）。
     * 5. 根据杨辉三角的性质：
     *    - 每一行的第一个元素和最后一个元素总是 1。
     *    - 其他位置的元素 `row[j]` 等于它上一行（即 `triangle[i-1]`）的 `prev_row[j-1] + prev_row[j]`。
     * 6. 将生成的 `row` 添加到 `triangle` 列表中。
     * 7. 循环结束后，返回 `triangle`。
     */
    public List<List<Integer>> generate(int numRows) {
        // 创建最终返回的列表
        List<List<Integer>> triangle = new ArrayList<>();

        // 如果 numRows 为 0，直接返回空列表
        if (numRows == 0) {
            return triangle;
        }

        // 循环生成每一行
        for (int i = 0; i < numRows; i++) {
            // 创建当前行
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 判断是否为行首或行尾
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 获取上一行
                    List<Integer> prevRow = triangle.get(i - 1);
                    // 计算当前元素的值
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(sum);
                }
            }
            // 将当前行添加到结果中
            triangle.add(row);
        }

        return triangle;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int numRows1 = 5;
        List<List<Integer>> result1 = solution.generate(numRows1);
        System.out.println("示例 1:");
        System.out.println("输入: numRows = " + numRows1);
        System.out.println("输出: " + result1); // 应输出 [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

        // 示例 2
        int numRows2 = 1;
        List<List<Integer>> result2 = solution.generate(numRows2);
        System.out.println("\n示例 2:");
        System.out.println("输入: numRows = " + numRows2);
        System.out.println("输出: " + result2); // 应输出 [[1]]
    }
}
