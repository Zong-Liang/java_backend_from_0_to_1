package com.practice.prac07.static_variable_test;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class StaticVariableTest {
    @Test
    public void test1() {
        Counter.displayCount(); // 输出：Total instances: 0
        new Counter();
        new Counter();
        Counter.displayCount(); // 输出：Total instances: 2
    }
}
