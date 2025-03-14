# [155_最小栈](https://leetcode.cn/problems/min-stack/)

难度：中等

## 问题描述：

设计一个支持 `push` ，`pop` ，`top` 操作，并能在常数时间内检索到最小元素的栈。

实现 `MinStack` 类:

- `MinStack()` 初始化堆栈对象。
- `void push(int val)` 将元素val推入堆栈。
- `void pop()` 删除堆栈顶部的元素。
- `int top()` 获取堆栈顶部的元素。
- `int getMin()` 获取堆栈中的最小元素。

**示例 1:**

```java
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
```

**提示：**

- `pop`、`top` 和 `getMin` 操作总是在 **非空栈** 上调用

## 解题思路：



## Java代码：

```java
class MinStack {
    private Stack<Integer> mainStack;    // 主栈，存储所有元素
    private Stack<Integer> minStack;     // 辅助栈，存储最小值
    
    /** 初始化堆栈对象 */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    /** 将元素val推入堆栈 */
    public void push(int val) {
        mainStack.push(val);
        
        // 如果辅助栈为空或当前元素小于等于辅助栈顶元素，将其也压入辅助栈
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    /** 删除堆栈顶部的元素 */
    public void pop() {
        // 如果主栈要弹出的元素等于当前最小值，辅助栈也要弹出
        if (!mainStack.isEmpty() && mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        
        if (!mainStack.isEmpty()) {
            mainStack.pop();
        }
    }
    
    /** 获取堆栈顶部的元素 */
    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        throw new RuntimeException("栈为空");
    }
    
    /** 获取堆栈中的最小元素 */
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new RuntimeException("栈为空");
    }
}
```

