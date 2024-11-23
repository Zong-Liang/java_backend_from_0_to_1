# 04_final关键字

`final` 是Java中的一个关键字，可以用于修饰类、方法、变量等，具有不同的含义和作用，取决于它所修饰的内容。

## 修饰变量

```java
public class MyClass {
    // 声明为final的实例变量，必须在声明时或构造方法中进行初始化
    private final int constantValue = 42;

    public void exampleMethod() {
        // 无法再次为final变量赋值
        // constantValue = 10; // 会导致编译错误
    }
}
```

当 `final` 用于修饰变量时，表示该变量的值一旦被初始化就不能再被修改。对于实例变量，可以在声明时直接初始化，在代码块里初始化，或者在构造方法中初始化。对于局部变量，必须在声明时进行初始化。

## 修饰方法

```java
public class AnotherClass {
    // 修饰方法，表示该方法不能被子类重写
    public final void finalMethod() {
        // 方法体
    }
}
```

当 `final` 用于修饰方法时，表示该方法不能被子类重写（覆盖）。这在设计类时希望某个方法的实现不被修改时很有用。

## 修饰类

```java
public final class FinalClass {
    // 类体
}
```

当 `final` 用于修饰类时，表示该类不能被继承。这通常用于防止其他类继承或修改特定的类。

## 修饰引用变量

```java
public class ReferenceExample {
    public static void main(String[] args) {
        final int a = 10;
        // a = 20; // 编译错误，无法重新分配值给final变量

        final StringBuilder sb = new StringBuilder("Hello");
        // sb = new StringBuilder("World"); // 编译错误，无法重新分配引用给final变量

        // 但是可以修改final引用指向的对象的内容
        sb.append(", World");
        System.out.println(sb.toString()); // 输出：Hello, World
    }
}
```

当 `final` 用于修饰引用变量时，表示该引用变量只能指向初始化时分配的对象，但并不表示对象本身是不可变的。对象内部的状态（比如数组元素、集合内容等）仍然可以被修改。

`static`和`final`同时修饰变量，此变量就是全局常量。

```java
static final float PI = 3.14f;
```