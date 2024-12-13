package com.learn_java.sec_08;


public class InnerClass {
    public static void main(String[] args) {

    }

    public void method(){
        //局部内部类
        class A{
            //可以声明属性、方法等
        }
    }

    //开发中的场景
    public Comparable getInstance() {
        //提供实现Comparable接口的实现类
        //方式1：提供接口的实现类的有名对象
//        class MyComparable implements Comparable {
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        Comparable c = new MyComparable();
//        return c;

        //方式2：提供接口的实现类的匿名对象
//        class MyComparable implements Comparable {
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        return new MyComparable();

        //方式3：提供接口的匿名实现类的有名对象
//        Comparable c = new Comparable() {
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        };
//        return c;

        //方式4：提供接口的匿名实现类的匿名对象
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

}

//外部类
class Human {
    String name = "Tom";
    int age = 1;

    public void eat() {
        System.out.println("human eat");
    }

    //内部类

    //静态成员内部类
    static class Dog {
        public void eat() {
            System.out.println("dog eat");
        }
    }

    //非静态成员内部类
    class Bird {
        String name = "啄木鸟";

        public void eat() {
            System.out.println("bird eat");
        }

        public void show1(String name) {
            System.out.println("human age：" + age);
            System.out.println("形参 name：" + name);
            System.out.println("bird name：" + this.name);
            System.out.println("human name：" + Human.this.name);
        }

        public void show2() {
            eat();
            this.eat();
            Human.this.eat();
        }
    }

    public void method() {


        //局部内部类
        class InnerClass {

        }
    }

    public Human() {
        //局部内部类
        class InnerClass {

        }
    }

    {
        //局部内部类
        class InnerClass {
        }
    }
}
