package com.leetcode.code_09.p_994_orangesRotting;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * 广度优先搜索 (BFS) 解法
     *
     * 算法思路：
     * 这个问题可以看作是一个在图上寻找最短路径的问题，其中腐烂过程是从所有初始腐烂的橘子（多个源点）同时开始的。
     * 多源广度优先搜索（Multi-source BFS）是解决此类问题的完美模型。
     *
     * 1. **初始化**:
     *    - 我们需要一个队列 `queue` 来存储所有腐烂橘子的坐标。
     *    - 我们需要一个计数器 `freshCount` 来记录新鲜橘子的总数。
     *    - 首先，遍历整个网格，将所有初始腐烂橘子 (值为 2) 的坐标加入队列，并统计所有新鲜橘子 (值为 1) 的数量。
     *
     * 2. **处理边界情况**:
     *    - 如果初始时 `freshCount` 为 0，说明没有新鲜橘子需要腐烂，直接返回 0 分钟。
     *
     * 3. **BFS 过程**:
     *    - 我们以“分钟”为单位，逐层进行 BFS 遍历。
     *    - 初始化一个 `minutes` 计时器为 -1（因为第一轮处理的是 0 分钟时的状态）。
     *    - 当队列不为空时，我们开始一轮（一分钟）的传播：
     *      a. 计时器 `minutes` 加 1。
     *      b. 记录当前队列的大小 `levelSize`。这代表了在这一分钟开始时，所有新变为腐烂的橘子。
     *      c. 循环 `levelSize` 次，处理当前层的所有腐烂橘子。
     *      d. 对于每个出队的腐烂橘子，检查其上、下、左、右四个相邻的单元格。
     *      e. 如果相邻单元格是一个新鲜橘子，就将其变为腐烂状态（值设为 2），`freshCount` 减 1，并将其坐标加入队列，以便在下一分钟传播。
     *
     * 4. **判断结果**:
     *    - BFS 过程结束后（队列为空），我们检查 `freshCount`。
     *    - 如果 `freshCount` 为 0，说明所有橘子都已被腐烂，返回最终的 `minutes`。
     *    - 如果 `freshCount` 大于 0，说明有些新鲜橘子无法被触及（被空格子隔开），返回 -1。
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // 1. 初始化：统计新鲜橘子，并将腐烂橘子入队
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    freshCount++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        // 2. 边界情况：如果没有新鲜橘子
        if (freshCount == 0) {
            return 0;
        }

        int minutes = -1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 3. BFS 过程
        while (!queue.isEmpty()) {
            minutes++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // 检查新坐标是否有效且为新鲜橘子
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        // 4. 判断结果
        return freshCount == 0 ? minutes : -1;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[][] grid1 = {{2,1,1}, {1,1,0}, {0,1,1}};
        int result1 = solution.orangesRotting(grid1);
        System.out.println("示例 1:");
        System.out.println("输出: " + result1); // 应输出 4

        // 示例 2
        int[][] grid2 = {{2,1,1}, {0,1,1}, {1,0,1}};
        int result2 = solution.orangesRotting(grid2);
        System.out.println("\n示例 2:");
        System.out.println("输出: " + result2); // 应输出 -1

        // 示例 3
        int[][] grid3 = {{0,2}};
        int result3 = solution.orangesRotting(grid3);
        System.out.println("\n示例 3:");
        System.out.println("输出: " + result3); // 应输出 0
    }
}
