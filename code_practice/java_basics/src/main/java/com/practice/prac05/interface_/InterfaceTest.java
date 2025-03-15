package com.practice.prac05.interface_;

import org.junit.jupiter.api.Test;

/**
 * @author Zong Liang
 */
public class InterfaceTest {
    @Test
    public void test1() {
        Car car = new Car();
        car.start(); // 输出：Car starts.
        car.honk(); // 输出：Car honk: Beep Beep!
        Vehicle.info(); // 输出：This is a Vehicle interface.
    }
}
