# [20_有效的括号](https://leetcode.cn/problems/valid-parentheses/)

难度：简单

## 问题描述：

给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串 `s` ，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。
3. 每个右括号都有一个对应的相同类型的左括号。

**示例 1：**

```java
输入：s = "()"
输出：true
```

**示例 2：**

```java
输入：s = "()[]{}"
输出：true
```

**示例 3：**

```java
输入：s = "()[]{}"
输出：true
```

**示例 4：**

```java
输入：s = "([])"
输出：true
```

**提示：**`s` 仅由括号 `'()[]{}'` 组成

## 解题思路：



## Java代码：

```java
public class Solution {
    public boolean isValid(String s) {
        // 创建一个栈来存储左括号
        Stack<Character> stack = new Stack<>();
        
        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 如果是左括号，将其压入栈中
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // 如果是右括号
            else {
                // 如果栈为空，没有左括号可以匹配，返回false
                if (stack.isEmpty()) {
                    return false;
                }
                
                // 弹出栈顶元素进行匹配
                char top = stack.pop();
                
                // 检查是否匹配
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // 遍历结束后，栈应该为空，所有左括号都有对应的右括号
        return stack.isEmpty();
    }
}
```

