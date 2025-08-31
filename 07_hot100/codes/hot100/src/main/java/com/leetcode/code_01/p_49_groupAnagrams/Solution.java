package com.leetcode.code_01.p_49_groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * 哈希表 + 排序 解法
     *
     * 算法思路：
     * “字母异位词”是指由相同字母以不同顺序排列构成的单词。这意味着，如果我们将一个字母异位词的字符进行排序，
     * 它们都会得到完全相同的字符串。例如，"eat", "tea", "ate" 排序后都是 "aet"。
     *
     * 我们可以利用这个特性，将排序后的字符串作为唯一的“签名”或“键”，来将所有异位词分组。
     *
     * 1. **创建哈希表**:
     *    - 我们创建一个哈希表 `map`，其中：
     *      - `Key`: 是排序后的字符串（例如 "aet"）。
     *      - `Value`: 是一个列表，存储所有排序后等于该 `Key` 的原始字符串（例如 `["eat", "tea", "ate"]`）。
     *
     * 2. **遍历输入数组**:
     *    - 遍历输入的字符串数组 `strs` 中的每一个字符串 `s`。
     *    - 对于每个 `s`：
     *      a. 将其转换为字符数组 `charArray`。
     *      b. 对 `charArray`进行排序。
     *      c. 将排序后的字符数组转换回字符串，得到 `key`。
     *      d. 使用这个 `key` 在哈希表中查找对应的列表。如果列表不存在，就创建一个新的。
     *      e. 将原始字符串 `s` 添加到该列表中。
     *
     * 3. **返回结果**:
     *    - 遍历结束后，哈希表中 `map.values()` 就包含了所有分组后的字母异位词列表。
     *    - 我们将 `map.values()` 转换为一个新的列表并返回。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // 如果 map 中没有这个 key，则创建一个新的列表
            map.putIfAbsent(key, new ArrayList<>());

            // 将原始字符串加入到对应的列表中
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strs1);
        System.out.println("示例 1:");
        System.out.println("输入: " + Arrays.toString(strs1));
        System.out.println("输出: " + result1);
        // 输出: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]] (顺序可能不同)

        // 示例 2
        String[] strs2 = {""};
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        System.out.println("\n示例 2:");
        System.out.println("输入: " + Arrays.toString(strs2));
        System.out.println("输出: " + result2); // 输出: [[""]]

        // 示例 3
        String[] strs3 = {"a"};
        List<List<String>> result3 = solution.groupAnagrams(strs3);
        System.out.println("\n示例 3:");
        System.out.println("输入: " + Arrays.toString(strs3));
        System.out.println("输出: " + result3); // 输出: [["a"]]
    }
}
