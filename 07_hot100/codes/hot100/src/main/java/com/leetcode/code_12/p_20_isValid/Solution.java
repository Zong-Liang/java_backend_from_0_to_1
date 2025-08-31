package com.leetcode.code_12.p_20_isValid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    /**
     * 栈解法
     *
     * 算法思路：
     * 这个问题是判断括号匹配的经典场景，非常适合使用栈（后进先出）来解决。
     *
     * 1. 遍历字符串中的每个字符。
     * 2. 如果遇到一个左括号（'(', '[', '{'），我们就将其压入栈中。
     *    这表示我们“期待”在未来遇到一个对应的右括号来与之匹配。
     * 3. 如果遇到一个右括号（')', ']', '}'），我们检查栈顶的元素：
     *    a. 如果此时栈是空的，说明没有左括号与之匹配，字符串无效。
     *    b. 如果栈顶的左括号与当前的右括号不是同一类型，说明括号闭合顺序错误，字符串无效。
     *    c. 如果栈顶的左括号与当前右括号是匹配的，那么我们将栈顶元素弹出，表示这对括号成功匹配。
     * 4. 遍历完整个字符串后，如果栈是空的，说明所有的左括号都找到了匹配的右括号，字符串是有效的。
     *    如果栈中还有剩余的左括号，说明它们没有被闭合，字符串无效。
     *
     * 为了方便匹配，我们可以使用一个哈希表来存储左右括号的对应关系。
     */
    public boolean isValid(String s) {
        // 使用栈来存储左括号
        Stack<Character> stack = new Stack<>();
        // 使用哈希表存储括号的匹配关系
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');

        // 遍历字符串
        for (char c : s.toCharArray()) {
            // 如果是右括号
            if (mappings.containsKey(c)) {
                // 检查栈是否为空，以及栈顶元素是否匹配
                // 如果栈为空，返回'#'作为虚拟栈顶，确保不匹配
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // 如果是左括号，压入栈中
                stack.push(c);
            }
        }

        // 如果遍历结束后栈为空，则说明所有括号都已匹配
        return stack.isEmpty();
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        String s1 = "()";
        System.out.println("示例 1:");
        System.out.println("输入: s = \"" + s1 + "\"");
        System.out.println("输出: " + solution.isValid(s1)); // 应输出 true

        // 示例 2
        String s2 = "()[]{}";
        System.out.println("\n示例 2:");
        System.out.println("输入: s = \"" + s2 + "\"");
        System.out.println("输出: " + solution.isValid(s2)); // 应输出 true

        // 示例 3
        String s3 = "(]";
        System.out.println("\n示例 3:");
        System.out.println("输入: s = \"" + s3 + "\"");
        System.out.println("输出: " + solution.isValid(s3)); // 应输出 false

        // 示例 4
        String s4 = "{[]}";
        System.out.println("\n示例 4:");
        System.out.println("输入: s = \"" + s4 + "\"");
        System.out.println("输出: " + solution.isValid(s4)); // 应输出 true

        // 示例 5
        String s5 = "([)]";
        System.out.println("\n示例 5:");
        System.out.println("输入: s = \"" + s5 + "\"");
        System.out.println("输出: " + solution.isValid(s5)); // 应输出 false
    }
}
