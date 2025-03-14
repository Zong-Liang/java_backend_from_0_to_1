# [394_字符串解码](https://leetcode.cn/problems/decode-string/)

难度：中等

## 问题描述：

给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: `k[encoded_string]`，表示其中方括号内部的 `encoded_string` 正好重复 `k` 次。注意 `k` 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 `k` ，例如不会出现像 `3a` 或 `2[4]` 的输入。

**示例 1：**

```java
输入：s = "3[a]2[bc]"
输出："aaabcbc"
```

**示例 2：**

```java
输入：s = "3[a2[c]]"
输出："accaccacc"
```

**示例 3：**

```java
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
```

**示例 4：**

```java
输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
```

**提示：**

- `s` 由小写英文字母、数字和方括号 `'[]'` 组成
- `s` 保证是一个 **有效** 的输入。
- `s` 中所有整数的取值范围为 `[1, 300]` 

## 解题思路：



## Java代码：

```java
import java.util.*;

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // 累积数字
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                // 遇到左括号，将当前数字和字符串入栈
                countStack.push(count);
                stringStack.push(currentString);
                // 重置计数器和字符串构建器
                count = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                // 遇到右括号，处理重复字符串
                StringBuilder temp = currentString;
                currentString = stringStack.pop();
                int repeatTimes = countStack.pop();
                // 重复指定次数
                for (int i = 0; i < repeatTimes; i++) {
                    currentString.append(temp);
                }
            } else {
                // 普通字符，直接添加到当前字符串
                currentString.append(ch);
            }
        }
        
        return currentString.toString();
    }
}
```

```java
public class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= '0' && ch <= '9') {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                count = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                String repeatedStr = currentString.toString();
                currentString = stringStack.pop();
                int repeatTimes = countStack.pop();
                
                // 优化重复字符串的构建
                if (repeatTimes > 0) {
                    while (repeatTimes > 0) {
                        currentString.append(repeatedStr);
                        repeatTimes--;
                    }
                }
            } else {
                currentString.append(ch);
            }
        }
        
        return currentString.toString();
    }
}
```

