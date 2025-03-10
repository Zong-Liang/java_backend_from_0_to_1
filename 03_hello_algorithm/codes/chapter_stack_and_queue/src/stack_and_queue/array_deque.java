package stack_and_queue;

import java.util.Arrays;

// 基于环形数组实现的双向队列
class ArrayDeque {
    private int[] nums;
    private int front;
    private int queSize;

    public ArrayDeque(int capacity) {
        this.nums = new int[capacity];
        front = queSize = 0;
    }

    // 获取双向队列的容量
    public int capacity() {
        return nums.length;
    }

    // 获取双向队列的长度
    public int size() {
        return queSize;
    }

    // 判断双向队列是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 计算环形数组索引
    private int index(int i) {
        // 通过取余操作实现数组首尾相连
        // 当 i 越过数组尾部后，回到头部
        // 当 i 越过数组头部后，回到尾部
        return (i + capacity()) % capacity();
    }

    // 队首入队
    public void pushFirst(int num) {
        if (size() == capacity())
            throw new IllegalArgumentException("双向队列已满");
        // 队首指针向左移动一位
        // 通过取余操作实现 front 越过数组头部后回到尾部
        front = index(front - 1);
        // 将 num 添加至队首
        nums[front] = num;
        queSize++;
    }

    // 队尾入队
    public void pushLast(int num) {
        if (size() == capacity())
            throw new IllegalArgumentException("双向队列已满");
        // 将 num 添加至队尾
        int rear = index(front + queSize);
        nums[rear] = num;
        queSize++;
    }

    // 队首出队
    public int popFirst() {
        int num = peekFirst();
        // 队首指针向后移动一位
        front = index(front + 1);
        queSize--;
        return num;
    }

    // 队尾出队
    public int popLast() {
        int num = peekLast();
        queSize--;
        return num;
    }

    // 访问队首元素
    public int peekFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("双向队列为空");
        return nums[front];
    }


    // 访问队尾元素
    public int peekLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("双向队列为空");
        // 计算尾元素索引：通过取余操作实现 rear 越过数组尾部后回到头部
        int last = index(front + queSize - 1);
        return nums[last];
    }


    // 返回数组用于打印
    public int[] toArray() {
        // 仅转换有效长度范围内的列表元素
        int[] res = new int[size()];
        for (int i = 0, j = front; i < queSize; i++, j++) {
            res[i] = nums[index(j)];
        }
        return res;
    }
}

public class array_deque {
    public static void main(String[] args) {
        // 初始化双向队列
        ArrayDeque deque = new ArrayDeque(10);
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
        deque.pushLast(4);
        System.out.println("元素 4 队尾入队后 deque = " + Arrays.toString(deque.toArray()));
        deque.pushFirst(1);
        System.out.println("元素 1 队首入队后 deque = " + Arrays.toString(deque.toArray()));

        // 获取双向队列的长度
        int size = deque.size();
        System.out.println("双向队列长度 size = " + size);

        // 判断双向队列是否为空
        boolean isEmpty = deque.isEmpty();
        System.out.println("双向队列是否为空 = " + isEmpty);
    }

}
