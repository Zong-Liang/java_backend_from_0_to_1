package com.practice.prac11.arrays_test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArraysTest {
    @Test
    public void test1() {
        // 创建数组
        int[] array = {5, 2, 8, 1, 9};
        System.out.println("初始数组: " + Arrays.toString(array));

        // 排序
        Arrays.sort(array);
        System.out.println("排序后: " + Arrays.toString(array));

        // 二分查找
        System.out.println("查找8的位置: " + Arrays.binarySearch(array, 8));

        // 复制数组
        int[] copy = Arrays.copyOf(array, 3);
        System.out.println("复制前3个元素: " + Arrays.toString(copy));

        // 填充
        Arrays.fill(array, 0);
        System.out.println("填充后: " + Arrays.toString(array));
    }
}
