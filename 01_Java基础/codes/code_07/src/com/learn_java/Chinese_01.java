package com.learn_java;
/*
我们有时希望无论是否产生了对象或无论产生了多少对象，某些特定的数据在内存空间中只有一份。
此外，在类中声明的实例方法，在类的外面必须要先创建对象，才能调用。
但是有些方法的调用者和当前类的对象无关，这样的方法通常被声明为类方法，由于不需要创建对象就可以调用类方法，从而简化了方法的调用。
 */
public class Chinese_01 {
    String name;
    int age;
    static String nation = "china";

    public Chinese_01() {
    }

    public Chinese_01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Chinese_01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                '}';
    }

    //static修饰的方法内，不能使用this和super。
    public static void  selfIntro(){
        System.out.println("I come from "+ nation);
//        System.out.println("I come from "+ this.nation);  //报错
//        System.out.println("I come from "+ Chinese_01.nation);  //正确
    }
}
