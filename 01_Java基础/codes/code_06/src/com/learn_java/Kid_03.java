package com.learn_java;
/*
子类在继承父类以后，就获取了父类中声明的所有方法。但是，父类中的方法可能不太适用于子类，换句话说，子类需要对父类中继承过来的方法进行覆盖、覆写操作。

- 父类被重写的方法与子类重写的方法的方法名和形参列表必须相同。

- 子类重写的方法权限修饰符不小于父类被重写的方法的权限修饰符。
- 子类不能重写父类中用private修饰的方法。
- 父类被重写的方法的返回值类型是void，则子类重写的方法的返回值类型也必须是void。
- 父类被重写的方法的返回值类型是基本数据类型，则子类重写的方法的返回值类型必须与父类被重写的方法的返回值类型保持一致。
- 父类被重写的方法的返回值类型是引用数据类型，则子类重写的方法的返回值类型可以与父类被重写的方法的返回值类型相同或是父类被重写的方法的返回值类型的子类。
- 子类重写的方法抛出的异常类型可以与父类被重写的方法抛出的异常类型相同，或是父类被重写的方法抛出的异常类型的子类。
 */
public class Kid_03 extends Mankind_03 {
    private int age;


    public void setAge(int age) {
        this.age = age;
    }

    public void getAge() {
        System.out.println("age: " + age);
    }

    //重写父类方法
    //用super调用父类方法
    public void employed() {
        super.employed();
        System.out.println("kid should study and have no job");
    }

    public void getInfo() {
        System.out.println("kid's info");
    }
}
