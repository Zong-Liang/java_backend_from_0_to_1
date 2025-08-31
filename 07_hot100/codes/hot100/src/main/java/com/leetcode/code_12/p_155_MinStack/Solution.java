package com.leetcode.code_12.p_155_MinStack;

import java.util.Stack;

/**
 * 核心解法：MinStack 类的实现
 *
 * 算法思路 (辅助栈法):
 * 为了能够在常数时间 O(1) 内获取最小值，我们不能在每次 `getMin()` 调用时都遍历整个栈。
 * 解决方法是使用一个额外的辅助栈 (`minStack`)，它与主数据栈 (`dataStack`) 同步操作，专门用来存储历史最小元素。
 *
 * 1. **数据结构**:
 *    - `dataStack`: 一个普通的栈，用于存储所有推入的元素，支持 `push`, `pop`, `top` 操作。
 *    - `minStack`: 一个辅助栈。其栈顶元素始终是 `dataStack` 中当前所有元素的最小值。
 *
 * 2. **`push(val)` 方法逻辑**:
 *    a. 将新元素 `val` 正常推入 `dataStack`。
 *    b. 检查 `minStack`：
 *       - 如果 `minStack` 为空，或者 `val` 小于等于 `minStack` 的栈顶元素，那么 `val` 就是新的（或并列的）最小元素。
 *       - 在这种情况下，也将 `val` 推入 `minStack`。
 *
 * 3. **`pop()` 方法逻辑**:
 *    a. 从 `dataStack` 弹出一个元素。
 *    b. 检查弹出的这个元素是否等于 `minStack` 的栈顶元素。
 *       - 如果相等，说明我们弹出了当前的最小元素。为了更新最小值，我们必须同时从 `minStack` 中也弹出栈顶元素。
 *       - 这样，`minStack` 的新栈顶就会是下一个（即之前的）最小元素。
 *
 * 4. **`top()` 和 `getMin()` 方法逻辑**:
 *    - `top()`: 直接返回 `dataStack` 的栈顶元素。
 *    - `getMin()`: 直接返回 `minStack` 的栈顶元素，这是一个 O(1) 操作。
 */
class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /** 初始化数据结构 */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        dataStack.push(val);
        // 如果 minStack 为空或新值小于等于当前最小值，则推入 minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // 使用 .equals() 来处理 Integer 对象的缓存问题，虽然对于本题范围的数字直接用 == 也可以
        if (dataStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


// 这是为了匹配题目要求的格式而创建的测试类
public class Solution {
    // 算法的核心实现在上面的 MinStack 类中。
    // main 方法用于演示 MinStack 类的使用，并模拟示例输入/输出。
    public static void main(String[] args) {
        System.out.println("示例 1:");

        MinStack minStack = new MinStack();
        System.out.println("MinStack minStack = new MinStack();");

        minStack.push(-2);
        System.out.println("minStack.push(-2);");

        minStack.push(0);
        System.out.println("minStack.push(0);");

        minStack.push(-3);
        System.out.println("minStack.push(-3);");

        // getMin 操作
        int min1 = minStack.getMin();
        System.out.println("minStack.getMin(); // --> 返回 " + min1); // 应返回 -3

        // pop 操作
        minStack.pop();
        System.out.println("minStack.pop();");

        // top 操作
        int top1 = minStack.top();
        System.out.println("minStack.top();    // --> 返回 " + top1); // 应返回 0

        // getMin 操作
        int min2 = minStack.getMin();
        System.out.println("minStack.getMin(); // --> 返回 " + min2); // 应返回 -2
    }
}
