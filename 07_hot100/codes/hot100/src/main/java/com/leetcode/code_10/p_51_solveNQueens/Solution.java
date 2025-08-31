package com.leetcode.code_10.p_51_solveNQueens;

import java.util.*;

public class Solution {
    private List<List<String>> result;
    private Set<Integer> columns;       // 记录被占用的列
    private Set<Integer> diagonals1;    // 记录被占用的主对角线 (row - col)
    private Set<Integer> diagonals2;    // 记录被占用的副对角线 (row + col)

    /**
     * 回溯算法解法
     *
     * 算法思路：
     * N皇后问题是回溯算法的经典应用。我们尝试在棋盘的每一行放置一个皇后，并确保新放置的皇后
     * 不与任何已放置的皇后互相攻击。
     *
     * 1. **决策树模型**：
     *    - 我们可以按行来构建决策树。树的第 `row` 层代表我们在棋盘的第 `row` 行决定放置皇后的位置（列）。
     *    - 在第 `row` 行，我们有 `n` 个选择（`n` 个列）。
     *
     * 2. **剪枝条件（约束）**:
     *    - 在尝试将皇后放在 `(row, col)` 位置之前，我们必须检查该位置是否安全。
     *    - 安全意味着该位置所在的列、主对角线和副对角线都没有其他皇后。
     *    - 为了在 O(1) 时间内完成检查，我们使用三个集合（Set）来记录被占用的位置：
     *      - `columns`: 存储已被占用的列索引。
     *      - `diagonals1`: 存储已被占用的主对角线。同一条主对角线上的所有点 `(r, c)`，其 `r - c` 的值是恒定的。
     *      - `diagonals2`: 存储已被占用的副对角线。同一条副对角线上的所有点 `(r, c)`，其 `r + c` 的值是恒定的。
     *
     * 3. **回溯过程**:
     *    - **`backtrack(row, n, board)`**:
     *      - **终止条件**: 如果 `row == n`，说明我们成功地在 n 行中都放置了皇后，找到了一个解。我们将当前棋盘布局 `board` 格式化后存入结果集。
     *      - **遍历选择**: 遍历当前行的所有列 `col` from 0 to n-1。
     *        - 如果在 `(row, col)` 放置皇后是安全的（通过检查三个集合），则：
     *          a. **选择**: 将皇后放在 `(row, col)`，并更新三个集合，标记该位置为不安全。
     *          b. **探索**: 递归调用 `backtrack(row + 1, n, board)`，进入下一行。
     *          c. **撤销选择 (回溯)**: 当从下一行的递归返回后，将皇后从 `(row, col)` 移除，并从三个集合中移除相应的标记，恢复状态。
     */
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        columns = new HashSet<>();
        diagonals1 = new HashSet<>();
        diagonals2 = new HashSet<>();
        // 使用一个整数数组来表示棋盘，queens[row] = col 表示皇后在 (row, col)
        int[] queens = new int[n];

        backtrack(0, n, queens);
        return result;
    }

    private void backtrack(int row, int n, int[] queens) {
        // 终止条件：成功放置了 n 个皇后
        if (row == n) {
            result.add(generateBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            // 检查当前位置是否安全
            if (columns.contains(col)) continue;
            int diagonal1 = row - col;
            if (diagonals1.contains(diagonal1)) continue;
            int diagonal2 = row + col;
            if (diagonals2.contains(diagonal2)) continue;

            // 1. 作出选择
            queens[row] = col;
            columns.add(col);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);

            // 2. 进入下一行决策
            backtrack(row + 1, n, queens);

            // 3. 撤销选择 (回溯)
            // queens[row] will be overwritten in the next iteration
            columns.remove(col);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    // 根据 queens 数组生成最终的棋盘格式
    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int n1 = 4;
        List<List<String>> result1 = solution.solveNQueens(n1);
        System.out.println("示例 1:");
        System.out.println("输入: n = " + n1);
        System.out.println("输出: " + result1);
        // 输出: [[".Q..", "...Q", "Q...", "..Q."], ["..Q.", "Q...", "...Q", ".Q.."]]

        // 示例 2
        int n2 = 1;
        List<List<String>> result2 = solution.solveNQueens(n2);
        System.out.println("\n示例 2:");
        System.out.println("输入: n = " + n2);
        System.out.println("输出: " + result2);
        // 输出: [["Q"]]
    }
}
