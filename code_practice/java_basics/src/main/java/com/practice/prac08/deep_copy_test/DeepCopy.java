package com.practice.prac08.deep_copy_test;

/**
 * @author Zong Liang
 * 深拷贝是指创建一个新对象，然后递归地复制当前对象的所有字段。
 * 如果字段是值类型，则直接复制值；如果字段是引用类型，则创建一个新的对象并复制其内容。
 * 因此，原始对象和副本对象完全独立，互不影响。
 */
public class DeepCopy {
    private int num;
    Object refObj;

    public DeepCopy(int num, Object refObj) {
        this.num = num;
        this.refObj = refObj;
    }

    // 深拷贝实现
    public DeepCopy deepCopy() {
        Object newRefObj = new Object(); // 创建一个新的引用对象
        return new DeepCopy(this.num, newRefObj);
    }

    @Override
    public String toString() {
        return "DeepCopy{" +
                "num=" + num +
                ", refObj=" + refObj +
                '}';
    }
}
