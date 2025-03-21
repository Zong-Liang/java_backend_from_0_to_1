package com.practice.prac11.list_test.vector_test;

import org.junit.jupiter.api.Test;

import java.util.Vector;

/**
 * @author Zong Liang
 * Vector 是⼀个古⽼的集合类，它的⽅法都是同步的，因此是线程安全的。
 * 然⽽，它相对较重，不够灵活，现在通常建议使⽤ ArrayList 。
 */
public class VectorTest {
    @Test
    public void test1() {
        // 创建Vector对象（线程安全）
        Vector<Integer> vector = new Vector<>();

        // 添加元素
        vector.add(10);                     // 添加到末尾
        vector.addElement(20);              // 添加元素（Vector特有方法）
        vector.insertElementAt(15, 1);      // 在指定位置插入
        System.out.println("初始向量: " + vector);

        // 获取元素
        System.out.println("第一个元素: " + vector.firstElement());
        System.out.println("最后一个元素: " + vector.lastElement());

        // 修改元素
        vector.setElementAt(25, 0);         // 替换指定位置元素
        System.out.println("修改后: " + vector);

        // 删除元素
        vector.removeElement(15);           // 删除指定元素
        System.out.println("删除后: " + vector);

        // 查询
        System.out.println("容量: " + vector.capacity());
        System.out.println("大小: " + vector.size());
    }
}
