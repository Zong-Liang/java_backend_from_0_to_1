package com.leetcode.code_13.p_295_MedianFinder;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 核心解法：MedianFinder 类的实现
 *
 * 算法思路 (双堆法):
 * 我们可以将数据流分为两部分：较小的一半和较大的一半。为了能快速访问这两部分的边界值（即中位数相关的数），我们使用两个堆：
 *
 * 1. 最大堆 (smallHalf): 存储数据流中较小的一半数字。堆顶是这半部分中的最大值。
 * 2. 最小堆 (largeHalf): 存储数据流中较大的一半数字。堆顶是这半部分中的最小值。
 *
 * 我们需要始终维护两个堆的平衡，使它们的数量满足：
 * - 如果总数为偶数，`smallHalf.size() == largeHalf.size()`。
 * - 如果总数为奇数，`smallHalf.size() == largeHalf.size() + 1`。
 *
 * `addNum(num)` 方法逻辑:
 * a. 将新数字 `num` 先加入最大堆 `smallHalf`。
 * b. 为了维持 `smallHalf` 里都是较小的数，我们将其堆顶（最大值）弹出，并加入到最小堆 `largeHalf` 中。
 * c. 检查平衡：如果 `smallHalf` 的数量变得比 `largeHalf` 少了，就从 `largeHalf` 弹出堆顶（最小值），并加入 `smallHalf`，恢复平衡。
 *
 * `findMedian()` 方法逻辑:
 * a. 如果两个堆大小相等（总数为偶数），中位数就是两个堆顶元素的平均值。
 * b. 如果 `smallHalf` 比 `largeHalf` 多一个元素（总数为奇数），中位数就是 `smallHalf` 的堆顶元素。
 */
class MedianFinder {

    private PriorityQueue<Integer> smallHalf; // 最大堆
    private PriorityQueue<Integer> largeHalf; // 最小堆

    /** 初始化数据结构 */
    public MedianFinder() {
        // Java 的 PriorityQueue 默认是最小堆，所以最大堆需要提供一个反向比较器
        smallHalf = new PriorityQueue<>(Collections.reverseOrder());
        largeHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. 先将元素加入最大堆
        smallHalf.offer(num);

        // 2. 将最大堆的堆顶（最大元素）移动到最小堆
        largeHalf.offer(smallHalf.poll());

        // 3. 维护平衡，确保 smallHalf 的大小 >= largeHalf 的大小
        if (smallHalf.size() < largeHalf.size()) {
            smallHalf.offer(largeHalf.poll());
        }
    }

    public double findMedian() {
        // 如果两个堆大小相等，说明总元素个数为偶数
        if (smallHalf.size() == largeHalf.size()) {
            return (smallHalf.peek() + largeHalf.peek()) / 2.0;
        } else {
            // 否则总元素个数为奇数，中位数在 smallHalf 的堆顶
            return smallHalf.peek();
        }
    }
}


// 这是为了匹配题目要求的输出格式而创建的测试类
public class Solution {
    // 算法的核心实现在上面的 MedianFinder 类中。
    // main 方法用于演示 MedianFinder 类的使用，并模拟示例输入/输出。
    public static void main(String[] args) {
        System.out.println("示例 1:");
        System.out.println("输入: [\"MedianFinder\", \"addNum\", \"addNum\", \"findMedian\", \"addNum\", \"findMedian\"]");
        System.out.println("     [[], [1], [2], [], [3], []]");

        MedianFinder medianFinder = new MedianFinder();
        // 输出: [null, null, null, 1.5, null, 2.0]
        System.out.print("输出: [null");

        medianFinder.addNum(1);
        System.out.print(", null");

        medianFinder.addNum(2);
        System.out.print(", null");

        System.out.print(", " + medianFinder.findMedian());

        medianFinder.addNum(3);
        System.out.print(", null");

        System.out.println(", " + medianFinder.findMedian() + "]");
    }
}
