package com.leetcode.code_12.p_394_decodeString;

import java.util.Stack;

public class Solution {
    /**
     * 辅助栈解法
     *
     * 算法思路：
     * 这个问题涉及到嵌套结构，非常适合使用栈来解决。我们需要两个栈：
     * 1. `countStack`: 一个整数栈，用于存储 `k[...` 中的重复次数 `k`。
     * 2. `stringStack`: 一个字符串（或 StringBuilder）栈，用于存储在遇到 `[` 之前已经解码的字符串部分。
     *
     * 我们还需要两个变量来处理当前的状态：
     * - `currentCount`: 用于累积当前的数字（因为 k 可能是多位数）。
     * - `currentString`: 一个 StringBuilder，用于构建当前层次正在解码的字符串。
     *
     * 算法流程：
     * 1. 遍历输入字符串的每一个字符 `c`。
     * 2. **如果 `c` 是数字**: 更新 `currentCount`。例如，遇到 '3' 再遇到 '2'，`currentCount` 会从 3 变为 32。
     * 3. **如果 `c` 是 '['**:
     *    - 将 `currentCount` 压入 `countStack`。
     *    - 将 `currentString` 压入 `stringStack`。
     *    - 重置 `currentCount` 为 0，并创建一个新的 `currentString`，准备开始解码括号内的新字符串。
     * 4. **如果 `c` 是 ']'**:
     *    - 从 `countStack` 弹出一个数字 `repeatCount`。
     *    - 从 `stringStack` 弹出一个 `StringBuilder` 对象 `previousString`。
     *    - 将 `currentString` 重复 `repeatCount` 次，并追加到 `previousString` 后面。
     *    - 更新 `currentString` 为这个合并后的 `previousString`。
     * 5. **如果 `c` 是字母**: 直接将 `c` 追加到 `currentString`。
     *
     * 遍历结束后，`currentString` 中保存的就是最终解码完成的字符串。
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentCount = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentCount = currentCount * 10 + (c - '0');
            } else if (c == '[') {
                // 将当前的数字和字符串状态压入栈中
                countStack.push(currentCount);
                stringStack.push(currentString);
                // 重置状态，准备处理括号内的内容
                currentCount = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                // 弹出上一层的状态
                StringBuilder decodedString = stringStack.pop();
                int repeatCount = countStack.pop();

                // 将当前字符串重复指定次数并追加到上一层的字符串中
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "3[a]2[bc]";
        String result1 = solution.decodeString(s1);
        System.out.println("示例 1:");
        System.out.println("输入: s = \"" + s1 + "\"");
        System.out.println("输出: \"" + result1 + "\""); // 应输出 "aaabcbc"

        // 示例 2
        String s2 = "3[a2[c]]";
        String result2 = solution.decodeString(s2);
        System.out.println("\n示例 2:");
        System.out.println("输入: s = \"" + s2 + "\"");
        System.out.println("输出: \"" + result2 + "\""); // 应输出 "accaccacc"

        // 示例 3
        String s3 = "2[abc]3[cd]ef";
        String result3 = solution.decodeString(s3);
        System.out.println("\n示例 3:");
        System.out.println("输入: s = \"" + s3 + "\"");
        System.out.println("输出: \"" + result3 + "\""); // 应输出 "abcabccdcdcdef"

        // 示例 4
        String s4 = "abc3[cd]xyz";
        String result4 = solution.decodeString(s4);
        System.out.println("\n示例 4:");
        System.out.println("输入: s = \"" + s4 + "\"");
        System.out.println("输出: \"" + result4 + "\""); // 应输出 "abccdcdcdxyz"
    }
}
