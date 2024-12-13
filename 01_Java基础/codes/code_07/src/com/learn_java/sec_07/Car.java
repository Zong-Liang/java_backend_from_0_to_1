package com.learn_java.sec_07;

public class Car extends Vehicle implements Power {
    private String carNumber;

    public Car() {
    }

    public Car(String brand, String color, String carNumber) {
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
