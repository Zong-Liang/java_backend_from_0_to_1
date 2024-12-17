package com.learn_java.sec_04;

//SubOrder4是泛型类
public class SubOrder4<E> extends Order<Integer> {
    E e;

    public SubOrder4() {
    }

    public SubOrder4(E e) {
        this.e = e;
    }

    public SubOrder4(Integer integer, int orderId) {
        super(integer, orderId);
    }

    public SubOrder4(Integer integer, int orderId, E e) {
        super(integer, orderId);
        this.e = e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }


}
