package com.learn_java;

public class ElectricVehicle_07 extends Vehicle_07 implements Power_07 {
    public ElectricVehicle_07() {
    }

    public ElectricVehicle_07(String brand, String color) {
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
