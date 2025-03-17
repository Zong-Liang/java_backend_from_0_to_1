package com.practice.prac08.shallow_copy_test;

/**
 * @author Zong Liang
 * 浅拷贝是指创建一个新对象，然后将当前对象的非静态字段复制到新对象中。
 * 如果字段是值类型的（如基本数据类型或字符串），那么将复制字段的值；
 * 如果字段是引用类型的（如数组或其他对象），则复制引用但不复制引用的对象。
 * 因此，原始对象和副本对象将引用同一个对象。
 */
public class ShallowCopy {
    private int num;
    Object refObj;

    public ShallowCopy(int num, Object refObj) {
        this.num = num;
        this.refObj = refObj;
    }

    // 浅拷贝实现
    public ShallowCopy shallowCopy() {
        return new ShallowCopy(this.num, this.refObj); // 直接复制引用
    }

    @Override
    public String toString() {
        return "ShallowCopy{" +
                "num=" + num +
                ", refObj=" + refObj +
                '}';
    }
}
