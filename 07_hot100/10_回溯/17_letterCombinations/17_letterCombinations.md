# [17_电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/)

难度：

## 问题描述：

给定一个仅包含数字 `2-9` 的字符串，返回所有它能表示的字母组合。答案可以按 **任意顺序** 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

![img](../../assets/imgs/200px-telephone-keypad2svg.png)

**示例 1：**

```java
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

**示例 2：**

```java
输入：digits = ""
输出：[]
```

**示例 3：**

```java
输入：digits = "2"
输出：["a","b","c"]
```

**提示：**

- `0 <= digits.length <= 4`
- `digits[i]` 是范围 `['2', '9']` 的一个数字。

## 解题思路：





## Java代码：

```java
import java.util.*;

class Solution {
    // 建立数字到字母的映射
    private static final String[] LETTERS = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 边界情况：如果输入为空，则返回空列表
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // 进行回溯
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }
    
    private void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        // 如果当前索引等于digits的长度，说明已经处理完所有数字
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // 获取当前数字
        char digit = digits.charAt(index);
        // 获取数字对应的字母
        String letters = LETTERS[digit - '0'];
        
        // 遍历每个字母并递归处理
        for (int i = 0; i < letters.length(); i++) {
            // 添加当前字母
            current.append(letters.charAt(i));
            // 递归处理下一个数字
            backtrack(result, digits, index + 1, current);
            // 回溯，移除最后添加的字母
            current.deleteCharAt(current.length() - 1);
        }
    }
}
```

