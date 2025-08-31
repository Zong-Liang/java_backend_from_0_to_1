package com.leetcode.code_03.p_01_lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 滑动窗口 + 哈希表解法
     *
     * 算法思路：
     * 我们可以使用“滑动窗口”的思想来解决这个问题。窗口由两个指针 `left` 和 `right` 构成，
     * `[left, right]` 区间表示我们当前正在检查的无重复字符的子串。
     *
     * 1. **扩展窗口**: 我们不断地移动右指针 `right` 来扩展窗口。
     *
     * 2. **处理重复**: 当我们遇到一个在当前窗口中已经存在的字符时，说明窗口内出现了重复。
     *    此时，我们需要收缩窗口，即移动左指针 `left`。
     *
     * 3. **优化**: 为了快速判断一个字符是否在当前窗口内，并快速定位其位置以移动 `left` 指针，
     *    我们使用一个哈希表 `map` 来存储每个字符及其最近出现过的索引。
     *
     * 4. **算法流程**:
     *    a. 初始化左指针 `left = 0`，最大长度 `maxLength = 0`，以及一个哈希表 `map`。
     *    b. 使用右指针 `right` 遍历整个字符串。
     *    c. 对于当前字符 `s.charAt(right)`：
     *       i.  检查它是否已经在 `map` 中。如果存在，说明我们遇到了重复字符。
     *       ii. 为了保证窗口内没有重复，我们需要将左指针 `left` 移动到这个重复字符上一次出现位置的 **下一个** 位置。
     *           同时，`left` 指针不能向后退，所以我们取 `max(left, map.get(currentChar) + 1)`。
     *    d. 更新当前字符在 `map` 中的位置为当前的 `right` 索引。
     *    e. 计算当前窗口的长度 `right - left + 1`，并用它来更新 `maxLength`。
     *    f. 遍历结束后，`maxLength` 就是最终的结果。
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // map 用于存储 <字符, 其最近出现的索引>
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0; // 滑动窗口的左边界

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果窗口中已包含当前字符，则移动左边界
            if (map.containsKey(currentChar)) {
                // left 只能向右移动，所以取 max
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // 更新当前字符的最新位置
            map.put(currentChar, right);
            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "abcabcbb";
        int result1 = solution.lengthOfLongestSubstring(s1);
        System.out.println("示例 1:");
        System.out.println("输入: s = \"" + s1 + "\"");
        System.out.println("输出: " + result1); // 应输出 3

        // 示例 2
        String s2 = "bbbbb";
        int result2 = solution.lengthOfLongestSubstring(s2);
        System.out.println("\n示例 2:");
        System.out.println("输入: s = \"" + s2 + "\"");
        System.out.println("输出: " + result2); // 应输出 1

        // 示例 3
        String s3 = "pwwkew";
        int result3 = solution.lengthOfLongestSubstring(s3);
        System.out.println("\n示例 3:");
        System.out.println("输入: s = \"" + s3 + "\"");
        System.out.println("输出: " + result3); // 应输出 3
    }
}
