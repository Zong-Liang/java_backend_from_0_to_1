package com.practice.prac12.bytestream_test.objectstream_test;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Zong Liang
 * ObjectInputStream：从输入流读取对象（反序列化），支持 Java 对象。
 * ObjectOutputStream：将对象写入输出流（序列化），用于持久化。
 * 特点：需要对象实现 Serializable 接口。
 */
public class ObjectStreamTest {
    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
    
    @Test
    public void test1() {
        // 写入对象
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            Person person = new Person("Alice", 25);
            oos.writeObject(person); // 序列化对象
            System.out.println("对象写入完成: " + person);
        } catch (IOException e) {
            System.err.println("写入异常: " + e.getMessage());
        }

        // 读取对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
            Person person = (Person) ois.readObject(); // 反序列化对象
            System.out.println("读取对象: " + person);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("读取异常: " + e.getMessage());
        }
    }
}
