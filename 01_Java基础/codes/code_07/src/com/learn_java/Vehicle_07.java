package com.learn_java;

public abstract class Vehicle_07 {
    private String brand;
    private String color;

    public Vehicle_07() {
    }

    public Vehicle_07(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void run();
}
