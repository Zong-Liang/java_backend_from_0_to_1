package com.learn_java.sec_04;

import java.util.ArrayList;

public class Order<T> {
    //声明了泛型参数以后就可以在类里面使用此泛型参数
    T t;
    int orderId;

    public Order() {
    }

    public Order(T t, int orderId) {
        this.t = t;
        this.orderId = orderId;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "t=" + t +
                ", orderId=" + orderId +
                '}';
    }

    //不可以在静态方法中使用类的泛型
//    public static void show(T t){
//        System.out.println(t);
//    }

    //自定义泛型方法
    public <E> E method(E e) {
        return null;
    }

    //定义泛型方法，将E[]数组元素添加到对于类型的Arrayist中，并返回
    public <E> ArrayList<E> copyElements(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

}
