package com.practice.prac02.basic_data_type_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class BasicDataTypeTest {
    @Test
    public void test1() {
        // byte
        byte b = 100;
        System.out.println("byte value: " + b);

        // short
        short s = 5000;
        System.out.println("short value: " + s);

        // int
        int i = 100000;
        System.out.println("int value: " + i);

        // long
        long l = 1234567890123456789L;
        System.out.println("long value: " + l);

        // float
        float f = 3.14f;
        System.out.println("float value: " + f);

        // double
        double d = 3.141592653589793;
        System.out.println("double value: " + d);

        // char
        char c = 'A';
        System.out.println("char value: " + c);

        // boolean
        boolean flag = true;
        System.out.println("boolean value: " + flag);

    }
}
