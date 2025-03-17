package com.practice.prac08.deep_copy_test.clone_test;

import java.util.Date;

/**
 * @author Zong Liang
 * clone()方法是Java提供的一个浅拷贝机制，但它可以通过重写实现深拷贝。
 */
public class Clone implements Cloneable {
    private int num;
    Date date;

    public Clone(int num, Date date) {
        this.num = num;
        this.date = date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 调用父类的clone()方法
        Clone cloned = (Clone) super.clone();
        // 手动实现深拷贝
        cloned.date = new Date(this.date.getTime());
        return cloned;
    }

    @Override
    public String toString() {
        return "CloneExample{" +
                "num=" + num +
                ", date=" + date +
                '}';
    }
}
