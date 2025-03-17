package com.practice.prac05.interface_test;

/**
 * @author Zong Liang
 */
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car starts.");
    }

    @Override
    public void stop() {
        System.out.println("Car stops.");
    }

    // 可以选择性地覆盖默认方法
    @Override
    public void honk() {
        System.out.println("Car honk: Beep Beep!");
    }
}
