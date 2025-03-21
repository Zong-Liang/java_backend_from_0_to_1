package com.practice.prac11.collections_test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    @Test
    public void test1() {
        // 创建一个List
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        System.out.println("初始列表: " + list);

        // 排序
        Collections.sort(list);
        System.out.println("排序后: " + list);

        // 反转
        Collections.reverse(list);
        System.out.println("反转后: " + list);

        // 打乱顺序
        Collections.shuffle(list);
        System.out.println("打乱后: " + list);

        // 查找
        System.out.println("最大值: " + Collections.max(list));
        System.out.println("最小值: " + Collections.min(list));
        System.out.println("2出现次数: " + Collections.frequency(list, 2));

        // 填充
        Collections.fill(list, 0);
        System.out.println("填充后: " + list);
    }
}
