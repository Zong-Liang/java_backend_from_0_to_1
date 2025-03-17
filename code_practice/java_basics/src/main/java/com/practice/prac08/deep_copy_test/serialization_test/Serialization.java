package com.practice.prac08.deep_copy_test.serialization_test;

import java.io.*;
import java.util.Date;

/**
 * @author Zong Liang
 * 序列化是一种将对象转换为字节流的过程，反序列化则是将字节流还原为对象。
 * 通过序列化和反序列化，可以实现深拷贝。
 */
public class Serialization implements Serializable {
    private int num;
    Date date;

    public Serialization(int num, Date date) {
        this.num = num;
        this.date = date;
    }

    // 深拷贝实现
    public Serialization deepCopy() throws IOException, ClassNotFoundException {
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        oos.flush();

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Serialization) ois.readObject();
    }

    @Override
    public String toString() {
        return "Serialization{" +
                "num=" + num +
                ", date=" + date +
                '}';
    }
}
