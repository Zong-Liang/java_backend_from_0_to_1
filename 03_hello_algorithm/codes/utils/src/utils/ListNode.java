package utils;

// 链表节点
public class ListNode {
    public int val;// 存储节点的值，类型为 int
    public ListNode next;// 指向下一个节点的指针，类型为 utils.ListNode


    public ListNode(int x) {// 构造函数 utils.ListNode(int x) 用于初始化节点的值
        val = x;
    }

    // 将列表反序列化为链表
    public static ListNode arrToLinkedList(int[] arr) {
        ListNode dum = new ListNode(0);// 创建一个哑节点（dummy node），作为链表的头节点
        ListNode head = dum;// 使用 head 指针来构建链表
        for (int val : arr) {// 遍历数组
            head.next = new ListNode(val);// 创建新节点，并将其值设置为数组中的当前值
            head = head.next;// 将 head 指针移动到新节点
        }
        return dum.next;// 返回链表的第一个实际节点
    }
}
