# 01_static关键字

我们有时希望无论是否产生了对象或无论产生了多少对象，某些特定的数据在内存空间中只有一份。此外，在类中声明的实例方法，在类的外面必须要先创建对象，才能调用。但是有些方法的调用者和当前类的对象无关，这样的方法通常被声明为类方法，由于不需要创建对象就可以调用类方法，从而简化了方法的调用。

这里的类变量、类方法、只需要使用`static`修饰即可，也称为静态变量、静态方法。

```java
public class Chinese {
    String name;
    int age;
    static String nation = "china";

    public Chinese() {
    }

    public Chinese(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Chinese{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                '}';
    }
    public static void show() {
        System.out.println("I'm Chinese");
    }
}
```

```java
public class UseChinese {
    public static void main(String[] args) {
        //static修饰的属性、方法可以通过类直接访问
        System.out.println(Chinese.nation);
        Chinese.show();

        Chinese c1 = new Chinese("zl", 25);
        System.out.println(c1);
        Chinese c2 = new Chinese("wh", 25);
        System.out.println(c2);

        System.out.println(c1.nation);
        c2.nation = "uk";
        System.out.println(c2.nation);
    }
}
```

