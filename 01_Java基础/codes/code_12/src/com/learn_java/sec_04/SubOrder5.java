package com.learn_java.sec_04;

//SubOrder5是泛型类
public class SubOrder5<T, E> extends Order<T> {
    E e;

    public SubOrder5() {
    }

    public SubOrder5(E e) {
        this.e = e;
    }

    public SubOrder5(T t, int orderId) {
        super(t, orderId);
    }

    public SubOrder5(T t, int orderId, E e) {
        super(t, orderId);
        this.e = e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    @Override
    public String toString() {
        return "SubOrder5{" +
                "e=" + e +
                ", t=" + t +
                ", orderId=" + orderId +
                '}';
    }
}
