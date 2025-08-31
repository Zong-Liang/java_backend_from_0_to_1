package com.leetcode.code_05.p_56_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    /**
     * 排序 + 贪心解法
     *
     * 算法思路：
     * 要合并重叠的区间，一个直观的想法是先将所有区间按照某种顺序排列。
     * 如果我们按区间的起始位置进行升序排序，那么在遍历排序后的数组时，
     * 对于任何一个区间，能够与它发生重叠的只可能是结果集中的最后一个区间。
     *
     * 1. **排序**:
     *    - 首先，将所有区间按照它们的起始值（`start`）进行升序排序。
     *
     * 2. **初始化**:
     *    - 创建一个列表 `merged` 用于存放合并后的结果。
     *    - 将排序后的第一个区间直接加入 `merged` 列表中。
     *
     * 3. **遍历与合并**:
     *    - 从第二个区间开始遍历排序后的 `intervals` 数组。
     *    - 对于当前遍历到的区间 `currentInterval`，我们取出 `merged` 列表中的最后一个区间 `lastMerged`。
     *    - **判断是否重叠**:
     *      - 如果 `currentInterval` 的起始值小于或等于 `lastMerged` 的结束值
     *        (`currentInterval[0] <= lastMerged[1]`)，说明这两个区间有重叠。
     *      - **合并操作**: 我们需要更新 `lastMerged` 的结束值，使其扩展到能覆盖 `currentInterval`。
     *        新的结束值为 `Math.max(lastMerged[1], currentInterval[1])`。
     *    - **如果不重叠**:
     *      - 如果 `currentInterval` 的起始值大于 `lastMerged` 的结束值，
     *        说明它们不重叠，并且由于数组已经排序，`currentInterval` 也不会与 `merged` 中的其他区间重叠。
     *       - 此时，我们将 `currentInterval` 作为一个新的区间加入到 `merged` 列表中。
     *
     * 4. **返回结果**:
     *    - 遍历结束后，`merged` 列表中就存放了所有合并后的不重叠区间。
     *    - 将列表转换为二维数组并返回。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. 按照区间的起始位置进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        // 2. 将第一个区间加入结果集
        merged.add(intervals[0]);

        // 3. 遍历并合并
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastMerged = merged.get(merged.size() - 1);

            if (currentInterval[0] <= lastMerged[1]) {
                // 有重叠，合并区间
                lastMerged[1] = Math.max(lastMerged[1], currentInterval[1]);
            } else {
                // 无重叠，添加新区间
                merged.add(currentInterval);
            }
        }

        // 4. 将列表转换为数组
        return merged.toArray(new int[merged.size()][]);
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.println("示例 1:");
        System.out.println("输入: " + Arrays.deepToString(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
        System.out.println("输出: " + Arrays.deepToString(result1)); // 应输出: [[1,6],[8,10],[15,18]]

        // 示例 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = solution.merge(intervals2);
        System.out.println("\n示例 2:");
        System.out.println("输入: " + Arrays.deepToString(new int[][]{{1,4},{4,5}}));
        System.out.println("输出: " + Arrays.deepToString(result2)); // 应输出: [[1,5]]
    }
}
