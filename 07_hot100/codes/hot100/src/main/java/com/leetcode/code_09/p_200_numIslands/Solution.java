package com.leetcode.code_09.p_200_numIslands;

public class Solution {
    /**
     * 深度优先搜索 (DFS) 解法
     *
     * 算法思路：
     * 我们可以将二维网格看作一个图，其中陆地单元格 ('1') 是节点，相邻的陆地之间有边。
     * 我们的目标是计算这个图中连通分量的数量，每一个连通分量就是一个岛屿。
     *
     * 1. **遍历网格**:
     *    - 我们从左到右，从上到下遍历整个网格。
     *    - 当我们遇到一个值为 '1' 的单元格时，我们知道我们发现了一个新岛屿（或者是某个岛屿的一部分）。
     *
     * 2. **计数与淹没**:
     *    - 一旦发现 '1'，我们将岛屿计数器 `count` 加 1。
     *    - 然后，我们立即从这个单元格开始进行深度优先搜索（DFS），目的是找到所有与它相连的陆地单元格，
     *      并将它们“淹没”（即将 '1' 修改为 '0' 或其他标记）。
     *    - “淹没”操作至关重要，它确保了同一个岛屿的所有部分只被计算一次。
     *
     * 3. **DFS 过程**:
     *    - DFS 函数 `dfs(grid, r, c)` 会递归地探索当前单元格 `(r, c)` 的所有四个方向（上、下、左、右）。
     *    - **终止条件**: 如果探索到了网格边界之外，或者遇到了水 ('0')，递归就停止。
     *    - **核心操作**: 将当前陆地单元格 `grid[r][c]` 修改为 '0'，然后对其所有相邻的陆地单元格递归调用 DFS。
     *
     * 遍历完整个网格后，`count` 的值就是岛屿的总数。
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // 如果是陆地，则岛屿数量+1，并淹没相连的陆地
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c);
                }
            }
        }
        return islandCount;
    }

    // 深度优先搜索，用于淹没与 (r, c) 相连的所有陆地
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 越界或遇到水，则返回
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // 将当前陆地淹没
        grid[r][c] = '0';

        // 向四个方向递归
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int result1 = solution.numIslands(grid1);
        System.out.println("示例 1:");
        System.out.println("输出: " + result1); // 应输出 1

        // 示例 2
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result2 = solution.numIslands(grid2);
        System.out.println("\n示例 2:");
        System.out.println("输出: " + result2); // 应输出 3
    }
}
