# 04_Set接口及其不同实现类

[官方文档](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html)

存储无序的、不可重复的数据。

较`List`、`Map`来说，`Set`使用的较少。

用来过滤重复的数据。

```java
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
    @Test
    public void test1() {
        var set = new HashSet();

        set.add("a");
        set.add(123);
        set.add("c");
        set.add(new Person("Tom", 16));

        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println(set.contains(new Person("Tom", 16)));
    }
}
```

`HashSet`：主要实现类，底层使用的是`HashMap`，用数组+单向链表+红黑树进行存储。

`LinkedHashSet`：是`HashSet`的子类，在数组+单向链表+红黑树的基础上，又添加了双向链表，用于记录添加元素的先后顺序，使得我们可以按照添加元素的顺序进行遍历，便于平凡的查询操作。

```java
@Test
public void test2() {
    var set = new LinkedHashSet();

    set.add("a");
    set.add(123);
    set.add("c");
    set.add(new Person("Tom", 16));

    Iterator iter = set.iterator();
    while (iter.hasNext()) {
        System.out.println(iter.next());
    }
}
```

添加到`HashSet`和`LinkedHashSet`中的元素要求重写`equals()`方法和`hashCode()`方法，哈希值相同且`equals()`方法返回true则认为元素是相同的。

```java
import java.util.Objects;

public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

`TreeSet`：底层使用红黑树进行存储，可以按照添加的元素的指定的属性进行遍历。

要求添加到`TreeSet`中的元素必须是同一类型的对象，否则会报`ClassCastException`异常。

```java
@Test
public void test3() {
    var set = new TreeSet();

    //TreeSet()必须添加同一类型的元素
    set.add("a");
    set.add("c");
    set.add("b");
    set.add("e");
    set.add("d");

    Iterator iter = set.iterator();
    while (iter.hasNext()) {
        System.out.println(iter.next());
    }
}
```

添加到`TreeSet`中的元素所在类不需要重写`equals()`方法和`hashCode()`方法。

添加到`TreeSet`中的元素需要考虑排序，比较元素大小是考虑自然排序和定制排序中`compareTo()`或`compare()`方法的返回值，如果返回值为0，，则两个比较的对象是相等的。

自然排序：

```java
@Test
public void test4() {
    var set = new TreeSet();

    var u1 = new User("Tom", 16);
    var u2 = new User("Jerry", 17);
    var u3 = new User("Jack", 18);
    var u4 = new User("Rose", 16);
    var u5 = new User("Robbin", 26);

    set.add(u1);
    set.add(u2);
    set.add(u3);
    set.add(u4);
    set.add(u5);

    Iterator iter = set.iterator();
    while (iter.hasNext()) {
        System.out.println(iter.next());
    }
}
```

```java
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
```

定制排序：

```java
@Test
public void test5() {
    var comparator = new Comparator() {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof User && o2 instanceof User) {
                User u1 = (User) o1;
                User u2 = (User) o2;

                int value = u1.getName().compareTo(u2.getName());

                if (value != 0) {
                    return value;
                } else {
                    return -(u1.getAge() - u2.getAge());
                }
            } else {
                throw new RuntimeException();
            }
        }
    };


    var set = new TreeSet(comparator);

    var u1 = new User("Tom", 16);
    var u2 = new User("Jerry", 17);
    var u3 = new User("Jack", 18);
    var u4 = new User("Rose", 16);
    var u5 = new User("Robbin", 26);

    set.add(u1);
    set.add(u2);
    set.add(u3);
    set.add(u4);
    set.add(u5);

    Iterator iter = set.iterator();
    while (iter.hasNext()) {
        System.out.println(iter.next());
    }
}
```

