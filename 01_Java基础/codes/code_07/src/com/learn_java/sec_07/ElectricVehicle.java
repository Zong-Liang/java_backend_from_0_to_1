package com.learn_java.sec_07;

public class ElectricVehicle extends Vehicle implements Power {
    public ElectricVehicle() {
    }

    public ElectricVehicle(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void run() {
        System.out.println("电车用电瓶驱动");
    }

    @Override
    public void power() {
        System.out.println("电车用电");
    }
}
