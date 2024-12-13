package com.learn_java.sec_07;
//接口就是规范，定义的是一组规则，体现了现实世界中“如果你是/要...则必须能...的思想”。继承是is a的关系，而接口实现是has a的关系。
public class UseVehicle {
    public static void main(String[] args) {
        Vehicle[] v = new Vehicle[3];
        v[0] = new Bicycle("捷安特", "red");
        v[2] = new ElectricVehicle("雅迪", "blue");
        v[1] = new Car("奥迪", "black", "京A8888");
    }
}
