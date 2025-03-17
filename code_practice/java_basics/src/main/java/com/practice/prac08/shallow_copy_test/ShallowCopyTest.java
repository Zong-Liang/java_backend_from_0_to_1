package com.practice.prac08.shallow_copy_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class ShallowCopyTest {
    @Test
    public void test1() {
        Object originalRefObj = new Object();
        ShallowCopy original = new ShallowCopy(10, originalRefObj);

        ShallowCopy copied = original.shallowCopy();

        System.out.println("Original: " + original);
        System.out.println("Copied: " + copied);

        // 修改引用对象
        original.refObj = new Object();

        System.out.println("After modification:");
        System.out.println("Original: " + original);
        System.out.println("Copied: " + copied);
    }
}
