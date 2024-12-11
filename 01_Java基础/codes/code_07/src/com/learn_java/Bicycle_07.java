package com.learn_java;

public class Bicycle_07 extends Vehicle_07 implements Power_07 {
    public Bicycle_07() {
    }

    public Bicycle_07(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void run() {
        System.out.println("自行车脚踩驱动");
    }


    @Override
    public void power() {
        System.out.println("自行车用脚踩");
    }
}
