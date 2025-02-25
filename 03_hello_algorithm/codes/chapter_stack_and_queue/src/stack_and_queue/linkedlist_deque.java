package stack_and_queue;

import java.util.Arrays;
import java.util.List;

// 双向链表节点
class ListNode {
    int val;// 节点值
    ListNode next;// 后继节点引用
    ListNode prev;// 前驱节点引用

    ListNode(int val) {
        this.val = val;
        prev = next = null;
    }
}

// 基于双向链表实现的双向队列
class LinkedListDeque {
    private ListNode front, rear;// 头节点 front ，尾节点 rear
    private int queSize = 0;// 双向队列的长度

    public LinkedListDeque() {
        front = rear = null;
    }

    // 获取双向队列的长度
    public int size() {
        return queSize;
    }

    // 判断双向队列是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 入队操作
    private void push(int num, boolean isFront) {
        ListNode node = new ListNode(num);
        if (isEmpty()) {// 若链表为空，则令 front 和 rear 都指向 node
            front = rear = node;
        } else if (isFront) {// 队首入队操作
            front.prev = node;// 将 node 添加至链表头部
            node.next = front;
            front = node;// 更新头节点
        } else {// 队尾入队操作
            rear.next = node;// 将 node 添加至链表尾部
            node.prev = rear;
            rear = node;// 更新尾节点
        }
        queSize++;// 更新队列长度
    }

    // 队首入队
    public void pushFirst(int num) {
        push(num, true);
    }

    // 队尾入队
    public void pushLast(int num) {
        push(num, false);
    }

    // 出队操作
    private int pop(boolean isFront) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        int val;
        if (isFront) {
            val = front.val;
            ListNode fNext = front.next;
            if (fNext == null) ;
            {
                fNext.prev = null;
                front.next = null;
            }
            front = fNext;
        } else {
            val = rear.val;
            ListNode rPrev = rear.prev;
            if (rPrev == null) {
                rPrev.next = null;
                rear.prev = null;
            }
            rear = rPrev;
        }
        queSize--;
        return val;
    }

    // 队首出队
    public int popFirst() {
        return pop(true);
    }

    // 队尾出队
    public int popLast() {
        return pop(false);
    }

    // 访问队首元素
    public int peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        return front.val;
    }

    // 访问队尾元素
    public int peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        return rear.val;
    }

    // 返回数组用于打印
    public int[] toArray() {
        ListNode node = front;
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }

}

public class linkedlist_deque {
    public static void main(String[] args) {
        // 初始化双向队列
        LinkedListDeque deque = new LinkedListDeque();

        deque.pushLast(3);
        deque.pushLast(2);
        deque.pushLast(5);
        System.out.println("双向队列 deque = " + Arrays.toString(deque.toArray()));

        // 访问元素
        int peekFirst = deque.peekFirst();
        System.out.println("队首元素 peekFirst = " + peekFirst);
        int peekLast = deque.peekLast();
        System.out.println("队尾元素 peekLast = " + peekLast);

        // 元素入队
        deque.pushLast(4);
        System.out.println("元素 4 队尾入队后 deque = " + Arrays.toString(deque.toArray()));
        deque.pushFirst(1);
        System.out.println("元素 1 队首入队后 deque = " + Arrays.toString(deque.toArray()));

        // 元素出队
        int popLast = deque.popLast();
        System.out.println("队尾出队元素 = " + popLast + "，队尾出队后 deque = " + Arrays.toString(deque.toArray()));
        int popFirst = deque.popFirst();
        System.out.println("队首出队元素 = " + popFirst + "，队首出队后 deque = " + Arrays.toString(deque.toArray()));

        // 获取双向队列的长度
        int size = deque.size();
        System.out.println("双向队列的长度 = " + size);

        // 判断双向队列是否为空
        boolean isEmpty = deque.isEmpty();
        System.out.println("双向队列是否为空 = " + isEmpty);
    }
}
