package com.practice.prac08.deep_copy_test.serialization_test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

/**
 * @author Zong Liang
 */
public class SerializationTest {
    @Test
    public void test1() throws IOException, ClassNotFoundException {
        Date originalDate = new Date();
        Serialization original = new Serialization(10, originalDate);

        Serialization cloned = original.deepCopy();

        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // 修改原始对象的引用对象
        original.date = new Date(originalDate.getTime() + 1000);

        System.out.println("After modification:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
    }
}
