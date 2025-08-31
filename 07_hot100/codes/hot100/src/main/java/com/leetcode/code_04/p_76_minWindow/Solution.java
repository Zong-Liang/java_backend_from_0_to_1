package com.leetcode.code_04.p_76_minWindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 滑动窗口解法
     *
     * 算法思路：
     * 这个问题可以使用滑动窗口来解决。我们维护一个窗口 `[left, right]`，它表示 s 的一个子串。
     * 我们的目标是：
     * 1. 扩展窗口的右边界 `right`，直到窗口内的子串包含了 `t` 中的所有字符。
     * 2. 在满足条件后，收缩窗口的左边界 `left`，以寻找一个可能更短的、仍然满足条件的子串。
     *
     * 为了高效地检查窗口是否满足条件，我们使用两个哈希表：
     * - `needs`: 存储 `t` 中每个字符及其所需的数量。
     * - `window`: 存储当前滑动窗口 `[left, right]` 中每个字符及其出现的数量。
     *
     * 1. **初始化**:
     *    - 填充 `needs` 哈希表，记录 `t` 中所有字符的需求量。
     *    - 初始化 `left = 0`, `right = 0`。
     *    - `valid` 变量用于记录 `window` 中有多少个字符已经满足了 `needs` 的需求。
     *    - `start` 和 `len` 用于记录找到的最小覆盖子串的起始位置和长度。
     *
     * 2. **扩展窗口**:
     *    - 移动 `right` 指针向右遍历字符串 `s`。
     *    - 对于 `s[right]` 的字符 `c`，如果 `c` 是 `needs` 中需要的字符，就更新 `window` 中 `c` 的计数。
     *    - 如果 `window` 中 `c` 的数量恰好等于 `needs` 中 `c` 的数量，说明这个字符的需求已经满足，`valid` 加 1。
     *
     * 3. **收缩窗口**:
     *    - 当 `valid` 的值等于 `needs` 的大小（即 `t` 中所有不同字符的需求都已满足）时，进入一个内部循环。
     *    - 在这个循环中，我们首先检查并更新最小子串的记录 (`start` 和 `len`)。
     *    - 然后，移动 `left` 指针向右，收缩窗口。
     *    - 对于 `s[left]` 的字符 `d`，如果 `d` 是 `needs` 中需要的字符，就更新 `window` 中 `d` 的计数。
     *    - 如果 `window` 中 `d` 的数量从“满足”变为“不满足”（即 `window[d] < needs[d]`），
     *      那么 `valid` 就减 1，外部循环将继续扩展 `right` 以寻找新的满足条件的窗口。
     *
     * 4. **返回结果**:
     *    - 遍历结束后，如果 `len` 仍然是初始的最大值，说明没有找到任何覆盖子串，返回空字符串。
     *    - 否则，根据记录的 `start` 和 `len` 从 `s` 中截取子串并返回。
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0; // 记录窗口中满足 needs 条件的字符个数

        // 记录最小覆盖子串的起始索引和长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;

            // 进行窗口内数据的一系列更新
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == needs.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;

                // 进行窗口内数据的一系列更新
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        String result1 = solution.minWindow(s1, t1);
        System.out.println("示例 1:");
        System.out.println("输入: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("输出: \"" + result1 + "\""); // 应输出 "BANC"

        // 示例 2
        String s2 = "a", t2 = "a";
        String result2 = solution.minWindow(s2, t2);
        System.out.println("\n示例 2:");
        System.out.println("输入: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("输出: \"" + result2 + "\""); // 应输出 "a"

        // 示例 3
        String s3 = "a", t3 = "aa";
        String result3 = solution.minWindow(s3, t3);
        System.out.println("\n示例 3:");
        System.out.println("输入: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("输出: \"" + result3 + "\""); // 应输出 ""
    }
}
