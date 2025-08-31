package com.leetcode.code_14.p_763_partitionLabels;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 贪心算法 + 双指针 解法
     *
     * 算法思路：
     * 我们的目标是将字符串划分为尽可能多的片段，同时保证同一个字母只出现在一个片段中。
     * 这意味着对于任何一个片段，其中所有字母的最后出现位置都必须在这个片段内部。
     *
     * 我们可以采用贪心策略：
     * 1. **预处理**：首先，遍历一次字符串，记录下每个字母（'a' 到 'z'）最后出现的位置。
     *    我们可以使用一个大小为 26 的数组 `lastIndices` 来存储这些信息。
     *
     * 2. **划分**：再次遍历字符串，维护两个指针：
     *    - `start`: 当前正在构建的片段的起始位置。
     *    - `end`: 当前片段必须延伸到的最远位置。
     *
     *    当我们遍历到索引 `i` 时，我们查看当前字符 `s.charAt(i)` 的最后出现位置。
     *    然后，我们更新 `end` 为 `Math.max(end, lastIndices[s.charAt(i) - 'a'])`。
     *    这样，`end` 就始终记录着当前片段中所有字符的最远“终点”。
     *
     * 3. **确定片段**：当我们的遍历索引 `i` 恰好等于 `end` 时，这意味着我们已经到达了当前片段的边界，
     *    并且这个片段内所有字符的最后出现位置都不会超过 `i`。此时，我们找到了一个有效的片段。
     *    - 我们记录下这个片段的长度 (`end - start + 1`)。
     *    - 然后，我们将 `start` 更新为 `i + 1`，开始寻找下一个片段。
     */
    public List<Integer> partitionLabels(String s) {
        // 创建一个数组来存储每个字母最后出现的位置
        int[] lastIndices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndices[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0; // 当前片段的起始位置
        int end = 0;   // 当前片段需要到达的最远位置

        for (int i = 0; i < s.length(); i++) {
            // 更新当前片段的最远边界
            end = Math.max(end, lastIndices[s.charAt(i) - 'a']);

            // 如果当前位置 i 到达了最远边界，说明一个片段结束了
            if (i == end) {
                result.add(end - start + 1);
                // 更新下一个片段的起始位置
                start = i + 1;
            }
        }

        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "abacbcabadefegdehijhklij";
        List<Integer> result1 = solution.partitionLabels(s1);
        System.out.println("示例 1:");
        System.out.println("输入: s = \"" + s1 + "\"");
        System.out.println("输出: " + result1); // 应输出 [9, 7, 8]

        // 示例 2
        String s2 = "eccbbbbdec";
        List<Integer> result2 = solution.partitionLabels(s2);
        System.out.println("\n示例 2:");
        System.out.println("输入: s = \"" + s2 + "\"");
        System.out.println("输出: " + result2); // 应输出 [10]
    }
}
