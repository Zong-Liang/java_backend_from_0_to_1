package com.leetcode.code_10.p_79_exist;


public class Solution {
    /**
     * 回溯算法 (DFS) 解法
     *
     * 算法思路：
     * 我们可以将二维网格看作一个图，其中每个单元格是一个节点，相邻的单元格之间有边。
     * 我们的目标是在这个图中找到一条路径，使得路径上的字符序列与目标单词 `word` 匹配。
     * 这是一个典型的图遍历问题，非常适合使用深度优先搜索（DFS）和回溯来解决。
     *
     * 1. **主函数 `exist`**:
     *    - 遍历网格中的每一个单元格 `(i, j)`。
     *    - 如果单元格 `board[i][j]` 的字符与 `word` 的第一个字符匹配，就以此单元格为起点，
     *      调用回溯函数 `backtrack` (或 `dfs`) 来尝试寻找单词的剩余部分。
     *    - 如果 `backtrack` 返回 `true`，说明找到了完整的单词，我们立即返回 `true`。
     *    - 如果遍历完所有单元格都未能找到，则返回 `false`。
     *
     * 2. **回溯函数 `backtrack(board, word, i, j, k)`**:
     *    - **参数**: `i`, `j` 是当前单元格的坐标，`k` 是 `word` 中当前待匹配字符的索引。
     *    - **终止条件 (Base Cases)**:
     *      a. **越界检查**: 如果 `i` 或 `j` 超出网格边界，或者 `board[i][j]` 与 `word.charAt(k)` 不匹配，说明此路不通，返回 `false`。
     *      b. **成功找到**: 如果 `k` 等于 `word.length() - 1`，说明已经匹配到单词的最后一个字符，我们成功找到了单词，返回 `true`。
     *
     *    - **探索与回溯**:
     *      a. **选择 (Choose)**: 为了防止在路径中重复使用同一个单元格，我们将当前单元格 `board[i][j]` 临时修改为一个特殊字符（如 '#'），标记为“已访问”。
     *      b. **探索 (Explore)**: 从当前单元格的四个相邻方向（上、下、左、右）递归调用 `backtrack`，尝试匹配单词的下一个字符 `k + 1`。
     *         只要有一个方向的探索成功（返回 `true`），就说明找到了路径。
     *      c. **撤销选择 (Unchoose / Backtrack)**: 在探索完所有方向后（无论成功与否），都必须将 `board[i][j]` 恢复为其原始字符。
     *         这一步是回溯的关键，它保证了其他搜索路径可以正常使用该单元格。
     */
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int k) {
        // 终止条件 1: 越界或字符不匹配
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }

        // 终止条件 2: 找到了单词的所有字符
        if (k == word.length() - 1) {
            return true;
        }

        // 1. 作出选择 (标记为已访问)
        char temp = board[i][j];
        board[i][j] = '#';

        // 2. 进入下一层决策 (探索四个方向)
        boolean found = backtrack(board, word, i + 1, j, k + 1)
                || backtrack(board, word, i - 1, j, k + 1)
                || backtrack(board, word, i, j + 1, k + 1)
                || backtrack(board, word, i, j - 1, k + 1);

        // 3. 撤销选择 (回溯)
        board[i][j] = temp;

        return found;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        char[][] board1 = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word1 = "ABCCED";
        boolean result1 = solution.exist(board1, word1);
        System.out.println("示例 1:");
        System.out.println("输入: word = \"" + word1 + "\"");
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2
        char[][] board2 = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word2 = "SEE";
        boolean result2 = solution.exist(board2, word2);
        System.out.println("\n示例 2:");
        System.out.println("输入: word = \"" + word2 + "\"");
        System.out.println("输出: " + result2); // 应输出 true

        // 示例 3
        char[][] board3 = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word3 = "ABCB";
        boolean result3 = solution.exist(board3, word3);
        System.out.println("\n示例 3:");
        System.out.println("输入: word = \"" + word3 + "\"");
        System.out.println("输出: " + result3); // 应输出 false
    }
}
