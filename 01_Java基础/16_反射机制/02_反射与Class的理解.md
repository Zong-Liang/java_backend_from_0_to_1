# 02_反射与Class的理解

Java 反射机制提供的功能：

- 在运行时判断任意一个对象所属得类。
- 在运行时构造任意一个类的对象。
- 在运行时判断任意一个类所具有的成员变量和方法。
- 在运行时获取泛型信息。
- 在运行时调用任意一个对象的成员变量和方法。
- 在运行时处理注解。
- 生成动态代理。

[`java.lang.reflect`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/package-summary.html)

反射的优点：

- 提高了 Java程序的灵活性和扩展性，降低了耦合性，提高了自适应能力。
- 允许程序创建和控制任何类的对象，无需提前硬编码目标类。

反射的缺点：

- 性能较低，主要应用在对灵活性和扩展性很高的系统框架上。
- 反射会模糊程序内部逻辑，可读性较差。

[`java.lang.Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)

针对于编写好的`.java`源文件进行编译，会生成一个或多个`.class`字节码文件。接着，我们使用`java.exe`命令对指定的`.class`文件进行解释运行，在解释运行的过程中，我们需要将`.class`字节码文件加载 (使用类的加载器) 到内存中 (存在方法区)，加载到内存中的`.class`文件对应的结构即为`Class`类的是个实例。比如，加载到内存中的`Person`类作为一个`Class`的实例，`Class clazz = Person.class //运行时类`。

`Class`类可以看做是反射的源头。

获取`Class`类实例的方式：

- 调用运行时类的属性：`.class`。
- 通过运行时类的对象，调用`getClass()`。
- 调用Class的静态方法：`forName(String classPath)`。
- 使用类的加载器：`ClassLoader`。

```java
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;

public class ClassTest {
    //获取Class类实例的方式
    @Test
    public void test1() {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        System.out.println(clazz1 == clazz2);//true

        //方式三：调用Class的静态方法：forName(String classPath)
        try {
            Class clazz3 = Class.forName("learnjava_16.Person");//注意这里的参数是类的全类名
            System.out.println(clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        try {
            Class clazz4 = classLoader.loadClass("learnjava_16.Person");
            System.out.println(clazz4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = Override.class;
        Class c6 = ElementType.class;
        Class c7 = Integer.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        System.out.println(c10 == c11);
    }
}
```

