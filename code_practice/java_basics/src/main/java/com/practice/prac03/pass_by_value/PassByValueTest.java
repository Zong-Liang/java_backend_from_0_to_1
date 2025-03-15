package com.practice.prac03.pass_by_value;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class PassByValueTest {
    private static void changeValue(int value) {
        value = 20;
        System.out.println("Inside method: value = " + value); // 输出：20
    }

    @Test
    public void test1() {
        int a = 10;
        System.out.println("Before method call: a = " + a); // 输出：10

        // 调用方法
        changeValue(a);
        System.out.println("After method call: a = " + a); // 输出：10
    }
}
