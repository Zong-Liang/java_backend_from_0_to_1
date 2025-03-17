package com.practice.prac07.static_import_test;

import org.junit.jupiter.api.Test;

// 静态导入是一种语法糖，允许直接使用类的静态成员，而无需通过类名访问。
import static java.lang.Math.PI;

/**
 * @author Zong Liang
 */
public class StaticImportTest {
    @Test
    public void test1() {
        System.out.println("Value of PI: " + PI); // 直接使用PI
    }

}
