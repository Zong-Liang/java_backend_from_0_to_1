package com.leetcode.code_01.p_49_groupAnagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建哈希表，键是排序后的字符串，值是该组的字符串列表
        Map<String, List<String>> map = new HashMap<>();

        // 遍历输入数组
        for (String str : strs) {
            // 将字符串转换为字符数组并排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 将排序后的字符数组转换回字符串，作为哈希表的键
            String sortedStr = new String(chars);

            // 如果哈希表中没有这个键，创建一个新的列表
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            // 将当前字符串加入对应的列表
            map.get(sortedStr).add(str);
        }

        // 将哈希表中的所有值（列表）加入结果
        return new ArrayList<>(map.values());
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strs1);
        System.out.println("示例 1: " + result1);
        // 应输出：[["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

        // 测试用例 2
        String[] strs2 = {""};
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        System.out.println("示例 2: " + result2);
        // 应输出：[[""]]

        // 测试用例 3
        String[] strs3 = {"a"};
        List<List<String>> result3 = solution.groupAnagrams(strs3);
        System.out.println("示例 3: " + result3);
        // 应输出：[["a"]]
    }
}
