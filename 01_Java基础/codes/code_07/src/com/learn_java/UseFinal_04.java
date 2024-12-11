package com.learn_java;

/*
当final用于修饰变量时，表示该变量的值一旦被初始化就不能再被修改。对于实例变量，可以在声明时直接初始化，在代码块里初始化，或者在构造方法中初始化。对于局部变量，必须在声明时进行初始化。
当final用于修饰方法时，表示该方法不能被子类重写（覆盖）。这在设计类时希望某个方法的实现不被修改时很有用。
当final用于修饰类时，表示该类不能被继承。这通常用于防止其他类继承或修改特定的类。
当final用于修饰引用变量时，表示该引用变量只能指向初始化时分配的对象，但并不表示对象本身是不可变的。对象内部的状态（比如数组元素、集合内容等）仍然可以被修改。

static和final同时修饰变量，此变量就是全局常量。
*/


//1.final variable
public class UseFinal_04 {
    public static void main(String[] args) {
        final int MAX_VALUE = 100;
        // MAX_VALUE = 200; // This will cause a compilation error
        System.out.println("Max value is: " + MAX_VALUE);
    }
}

//2.final method
//class ParentClass {
//    public final void display() {
//        System.out.println("This is a final method.");
//    }
//}
//
//class ChildClass extends ParentClass {
//    // public void display() { // This will cause a compilation error
//    //     System.out.println("Trying to override.");
//    // }
//}


//3.final class
//public final class FinalClass {
//    public void show() {
//        System.out.println("This is a final class.");
//    }
//}
//
//// class SubClass extends FinalClass { // This will cause a compilation error
//// }

//4.final parameter
//public class FinalParameterExample {
//    public void display(final int number) {
//        // number = 10; // This will cause a compilation error
//        System.out.println("The number is: " + number);
//    }
//
//    public static void main(String[] args) {
//        FinalParameterExample example = new FinalParameterExample();
//        example.display(5);
//    }
//}
