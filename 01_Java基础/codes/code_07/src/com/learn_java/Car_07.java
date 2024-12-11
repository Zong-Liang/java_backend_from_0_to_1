package com.learn_java;

public class Car_07 extends Vehicle_07 implements Power_07 {
    private String carNumber;

    public Car_07() {
    }

    public Car_07(String brand, String color, String carNumber) {
        super(brand, color);
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("燃油车烧油驱动");
    }

    @Override
    public void power() {
        System.out.println("燃油车烧油");
    }
}
