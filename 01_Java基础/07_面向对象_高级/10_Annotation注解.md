# 10_Annotation注解

注解格式：`@注解名`。Annotation 可以用于修饰、类、构造器、方法属性、参数、局部变量声明。还可以添加一些参数值，这些信息被保存在 Annotation 的`name = value`对中。注解可以在类编译、运行时进行加载，体现不同的功能。

![image-20240308151714192](https://cdn.jsdelivr.net/gh/ZL85/ImageBed@main//202403081517243.png)

一定程度上可以说：框架=注解+反射+设计模式。

```java
public @interface AnnotationTest {
    String value();
}
```

```java
@AnnotationTest("类")
public class Employee {
    private String name;
    private int age;
    private Status status;

    public Employee() {
    }

    public Employee(String name, int age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
```

```java
@AnnotationTest("枚举类型")
public enum Status {
    BUSY, FREE, VACATION, DISMISSAL;
}
```

```java
public class EmployeeTest {
    @AnnotationTest("main方法，程序入口")
    public static void main(String[] args) {
        Employee e = new Employee("Tom", 21, Status.DISMISSAL);
        System.out.println(e);
    }
}
```

元注解：对现有注解进行解释说明的注解。

4个元注解：

- `@Target`：用于描述注解的使用范围，可以通过枚举类型`ElementType`的10个常量 (`TYPE、METHOD、CONSTRUCTOR、PACKAGE...`) 对象来指定。
- `@Retention`：用于描述注解的生命周期。可以通过枚举类型`RetentionPolicy`的3个常量对象 `SOURCE (源代码)、CLASS (字节码)、RUNTIME (运行时) `来指定，唯有` RUNTIME `阶段才能被反射读取到。
- `@Documented`：表明这个注解应该被 javadoc 工具记录。
- `@Inherited`：允许子类继承父类中的注解。
