package com.learn_java.sec_07;

public class Bicycle extends Vehicle implements Power {
    public Bicycle() {
    }

    public Bicycle(String brand, String color) {
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
