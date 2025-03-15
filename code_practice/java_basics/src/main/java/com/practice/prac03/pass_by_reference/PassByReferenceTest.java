package com.practice.prac03.pass_by_reference;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Zong Liang
 */
public class PassByReferenceTest {
    private static void changeArray(int[] arr) {
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
    }

    @Test
    public void test1() {
        int[] array = {1, 2, 3};
        System.out.println("Before method call: array = " + Arrays.toString(array)); // 输出：[1, 2, 3]

        // 调用方法
        changeArray(array);
        System.out.println("After method call: array = " + Arrays.toString(array));
    }
}
