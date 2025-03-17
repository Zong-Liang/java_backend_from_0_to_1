package com.practice.prac02.wrapper_class_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class WrapperClassTest {
    @Test
    public void test1() {
        //基本类型到包装类的自动装箱
        //装箱其实就是调⽤了 包装类的valueOf() ⽅法，拆箱其实就是调⽤了 xxxValue() ⽅法。
        Byte b = 100;
        System.out.println("Byte value: " + b);

        Short s = 5000;
        System.out.println("Short value: " + s);

        Integer i = 100000;
        System.out.println("Integer value: " + i);

        Long l = 1234567890123456789L;
        System.out.println("Long value: " + l);

        Float f = 3.14f;
        System.out.println("Float value: " + f);

        Double d = 3.141592653589793;
        System.out.println("Double value: " + d);

        Character c = 'A';
        System.out.println("Character value: " + c);

        Boolean flag = true;
        System.out.println("Boolean value: " + flag);

    }

    @Test
    public void test2() {
        Integer intMaxValue = Integer.MAX_VALUE;
        Integer intMinValue = Integer.MIN_VALUE;
        String intToString = Integer.toString(888);
        int stringToInt = Integer.parseInt("666");

        System.out.println("Integer max value: " + intMaxValue);
        System.out.println("Integer min value: " + intMinValue);
        System.out.println("Integer to string: " + intToString);
        System.out.println("String to integer: " + stringToInt);
        System.out.println(intMaxValue.equals(intMinValue));

    }
}
