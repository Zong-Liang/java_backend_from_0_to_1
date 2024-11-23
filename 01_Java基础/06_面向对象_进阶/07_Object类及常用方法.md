# 07_Object类及常用方法

类`java.lang.Object`是类层次结构的根类，即所有其他类的父类，每个类都使用`Object`作为超类。

`Object`类中没有声明属性，提供了一个空参构造器，重点关注`Object`类中声明的方法。

[Object类官方文档](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html)

![image-20240307122415341](https://cdn.jsdelivr.net/gh/ZL85/ImageBed@main//202403071224501.png)

`equals(Object obj)`适用任何引用类型。自定义的类在没有重写`equals()`方法的情况下，调用的就是`Object`类中声明的`equals()`方法，比较的是两个对象的引用地址是否相同。

```java
// String.java
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    return (anObject instanceof String aString)
        && (!COMPACT_STRINGS || this.coder == aString.coder)
        && StringLatin1.equals(value, aString.value);
}

// StringLatin1.java
public static boolean equals(byte[] value, byte[] other) {
    if (value.length == other.length) {
        for (int i = 0; i < value.length; i++) {
            if (value[i] != other[i]) {
                return false;
            }
        }
        return true;
    }
    return false;
}
```

对于像`String`、`File`、`Date`和包装类等，都重写了`Object`类中的`equals()`方法，比较的是两个对象的实体内容是否相等。

```java
import java.io.File;
import java.util.Objects;

public class OverwriteEquals {
    public static void main(String[] args) {
        User u1 = new User("tom", 25);
        User u2 = new User("tom", 25);
        System.out.println(u1.equals(u2));  //false before overwrite

        //对于像string、File、Date和包装类等，它们都重写了0bject类中的equals()方法，用于比较两个对象的实体内容是否相等
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1.equals(s2));  //true

        File f1 = new File("d:\\ab.txt");
        File f2 = new File("d:\\ab.txt");
        System.out.println(f1.equals(f2));  //true

        //数组使用equals()
        int[] arr = new int[10];
        System.out.println(arr.equals(new int[10]));  //false
    }
}

class User {
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public boolean equals(Object anObject) {
//        if (this == anObject) {
//            return true;
//        }
//
//        if (anObject instanceof User) {
//            User user = (User) anObject;
////            if (this.age == user.age && this.name.equals(user.name)) {
////                return true;
////            } else {
////                return false;
////            }
//            return this.age == user.age && this.name.equals(user.name);
//        }
//
//        return false;
//    }

    //idea自动实现方法重写 (快捷键：alt + insert)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }
}
```

实际开发中，针对自定义的类，常常会判断两个对象是否相等，此时主要是判断对象的属性值是否相等，所以需要我们重写`Object`类中的``equals()``方法。

> 比较`==` 和 `equals()`
>
> `==` ：适用基本数据类型 (判断数据值是否相等) 和引用数据类型 (判断指向地址值是否相等)。
>
> `equals()`：只适用于引用数据类型 (未重写用于判断指向地址值是否相等)。

`Object`类中`toString()`方法的定义：

```java
public String toString() {
    retturn getClass().getName() + "@" +Integer.toHexString(hashCode());
}
```

平时在调用`System.out.println()`打印对象引用变量时，其实就是调用了对象的`toString()`方法。

自定义的类，在没有重写`Object`类中`toString()`方法时，默认返回当前对象的地址值。像`String`、`File`、`Date`和包装类等，都重写了`Object`类中`toString()`方法，返回的是当前对象的实体内容。

```java
import java.io.File;
import java.util.Date;

public class OverwriteToString {
    public static void main(String[] args) {
        User1 u1 = new User1("jerry", 12);
        System.out.println(u1);  //com.learnjava.User1@3b07d329 User1{name='jerry', age=12}
        System.out.println(u1.toString());  //com.learnjava.User1@3b07d329 User1{name='jerry', age=12}

        String s1 = "hello";
        System.out.println(s1);  //hello
        System.out.println(s1.toString());  //hello

        File f1 = new File("d:\\ab.txt");
        System.out.println(f1);  //d:\ab.txt
        System.out.println(f1.toString());  //d:\ab.txt

        Date d1 = new Date();
        System.out.println(d1);  //Sun Oct 22 10:18:41 CST 2023
        System.out.println(d1.toString());  //Sun Oct 22 10:18:41 CST 2023
    }
}

class User1 {
    String name;
    int age;

    public User1() {

    }

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

