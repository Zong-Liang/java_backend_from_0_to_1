package com.learn_java.sec_04;

public class User implements Comparable {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //只比较年龄
//    @Override
//    public int compareTo(Object o) {
//        if (this == o) {
//            return 0;
//        } else if (o instanceof User) {
//            User u = (User) o;
//            return this.age - u.age;
//        } else {
//            throw new RuntimeException();
//        }
//    }

    //先比较年龄 (从小到大)，再比较姓名 (从大到小)
    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        } else if (o instanceof User) {
            User u = (User) o;
            int value = this.age - u.age;
            if (value != 0) {
                return value;
            } else {
                return -this.name.compareTo(u.name);
            }
        } else {
            throw new RuntimeException();
        }
    }
}
