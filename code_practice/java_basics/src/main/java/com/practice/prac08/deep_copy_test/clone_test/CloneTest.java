package com.practice.prac08.deep_copy_test.clone_test;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class CloneTest {
    @Test
    public void test1() throws CloneNotSupportedException {
        Date originalDate = new Date();
        Clone original = new Clone(10, originalDate);

        Clone cloned = (Clone) original.clone();

        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // 修改原始对象的引用对象
        original.date = new Date(originalDate.getTime() + 1000);

        System.out.println("After modification:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
    }
}
