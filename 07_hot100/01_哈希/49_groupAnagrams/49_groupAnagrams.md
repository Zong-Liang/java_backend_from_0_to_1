# [49_字母异位词分组](https://leetcode.cn/problems/group-anagrams/)

## 问题描述：

给你一个字符串数组，请你将 **字母异位词** 组合在一起。可以按任意顺序返回结果列表。

**字母异位词** 是由重新排列源单词的所有字母得到的一个新单词。

**示例 1:**

```java
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

**示例 2:**

```java
输入: strs = [""]
输出: [[""]]
```

**示例 3:**

```java
输入: strs = ["a"]
输出: [["a"]]
```

## 解题思路：



## Java代码：

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 边界条件检查
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // 创建哈希表，键是排序后的字符串，值是原始字符串列表
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 将当前字符串转为字符数组并排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // 如果哈希表中不存在这个键，则创建新列表
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            // 将原始字符串添加到相应的列表中
            map.get(sortedStr).add(str);
        }

        // 返回哈希表中所有的值（列表）
        return new ArrayList<>(map.values());
    }
}

```
