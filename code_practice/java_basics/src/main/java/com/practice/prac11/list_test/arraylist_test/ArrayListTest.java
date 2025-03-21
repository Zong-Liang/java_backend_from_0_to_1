package com.practice.prac11.list_test.arraylist_test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    @Test
    public void test1() {
        // 创建ArrayList对象
        List<String> arrayList = new ArrayList<>();

        // 添加元素
        arrayList.add("Apple");              // 添加到末尾
        arrayList.add(1, "Banana");         // 在指定位置插入
        arrayList.addAll(List.of("Orange", "Grape")); // 添加集合
        System.out.println("初始列表: " + arrayList);

        // 获取元素
        System.out.println("索引1的元素: " + arrayList.get(1)); // 获取指定索引元素

        // 修改元素
        arrayList.set(0, "Mango");          // 替换指定位置元素
        System.out.println("修改后: " + arrayList);

        // 删除元素
        arrayList.remove("Banana");         // 删除指定元素
        arrayList.remove(1);                // 删除指定索引元素
        System.out.println("删除后: " + arrayList);

        // 查询
        System.out.println("是否包含Orange: " + arrayList.contains("Orange"));
        System.out.println("列表大小: " + arrayList.size());
        System.out.println("是否为空: " + arrayList.isEmpty());

        // 清空列表
        arrayList.clear();
        System.out.println("清空后: " + arrayList);
    }
}
