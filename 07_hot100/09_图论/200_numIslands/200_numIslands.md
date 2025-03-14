# [200_岛屿数量](https://leetcode.cn/problems/number-of-islands/)

难度：中等

## 问题描述：

给你一个由 `'1'`（陆地）和 `'0'`（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

**示例 1：**

```java
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
```

**示例 2：**

```java
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
```

**提示：`grid[i][j]` 的值为 `'0'` 或 `'1'`**

## 解题思路：



## Java代码：

```java
class Solution {
    public int numIslands(char[][] grid) {
        // 检查网格是否为空
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        // 遍历网格的每个单元格
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果找到一个陆地（'1'）
                if (grid[i][j] == '1') {
                    // 计数器增加
                    count++;
                    // 使用DFS将与当前陆地相连的所有陆地标记为已访问
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        
        return count;
    }
    
    // 深度优先搜索函数，用于标记与当前单元格相连的所有陆地
    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        // 检查当前坐标是否在网格范围内，以及是否为陆地
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }
        
        // 将当前单元格标记为已访问（将'1'改为'0'）
        grid[i][j] = '0';
        
        // 对上、下、左、右四个方向进行递归DFS
        dfs(grid, i - 1, j, rows, cols); // 上
        dfs(grid, i + 1, j, rows, cols); // 下
        dfs(grid, i, j - 1, rows, cols); // 左
        dfs(grid, i, j + 1, rows, cols); // 右
    }
}

// 测试代码
public class NumberOfIslandsTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 测试用例1
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("测试用例1的岛屿数量: " + solution.numIslands(grid1));
        
        // 测试用例2
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("测试用例2的岛屿数量: " + solution.numIslands(grid2));
    }
}
```

