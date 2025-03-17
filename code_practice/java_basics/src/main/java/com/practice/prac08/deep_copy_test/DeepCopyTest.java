package com.practice.prac08.deep_copy_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class DeepCopyTest {
    @Test
    public void test1() {
        Object originalRefObj = new Object();
        DeepCopy original = new DeepCopy(10, originalRefObj);

        DeepCopy copied = original.deepCopy();

        System.out.println("Original: " + original);
        System.out.println("Copied: " + copied);

        // 修改引用对象
        original.refObj = new Object();

        System.out.println("After modification:");
        System.out.println("Original: " + original);
        System.out.println("Copied: " + copied);
    }
}
