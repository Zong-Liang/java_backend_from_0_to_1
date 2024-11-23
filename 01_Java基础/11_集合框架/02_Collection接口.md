# 02_Collection接口

[官方文档](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)

存储一个一个的数据。

## 抽象方法

`add(E e)`、`addAll(Collection<? extends E> c)`、`size()`、`isEmpty()`、`contains(Object o)`、`containsAll(Collection<?> c)`、`equals(Object o)`、`clear()`、`remove(Object obj)`、`removeAll(Collection otherColl)`、`retainAll(Collection otherColl)`、`toArray()`、`hashCode()`、`iterator()`。

```java
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {
    @Test
    public void test1() {
        Collection coll1 = new ArrayList();

        //add(Object obj)添加元素到当前集合中
        coll1.add("abc");
        coll1.add(128); //自动装箱
        coll1.add(new Object());
        coll1.add(new Person("Tom", 12));

        System.out.println(coll1);

        //addAll(Collection otherColl)
        Collection coll2 = new ArrayList();
        coll2.add("ABC");
        coll2.add(456); //自动装箱
        coll2.add(new Object());
        coll2.add(new Person("Jerry", 21));

        System.out.println(coll1.size());
//        coll1.add(coll2); //将[ABC, 456, java.lang.Object@282003e1, Person{name='Jerry', age=21}]作为单独的一个元素
        coll1.addAll(coll2); //分别将ABC, 456, java.lang.Object@282003e1, Person{name='Jerry', age=21四个元素添加到coll1
        System.out.println(coll1);

        //size()获取当前集合中实际2存储的元素个数
        System.out.println(coll1.size());

        //isEmpty()判断当前集合中是否为空
        System.out.println(coll1.isEmpty()); //false

        //contains(Object obj)判断当前集合中是否存在一个与obj对象equals返回true的元素
        System.out.println(coll1.contains("abc")); //true
        System.out.println(coll1.contains(128)); //true
        System.out.println(coll1.contains(new Person("Tom", 12))); //false，此时调用的是Object的里面的equals()方法，重写equals()方法为比较内容大小就为true

        //containsAll(Collection otherColl)判断otherColl集合中的元素在当前集合中都存在
        System.out.println(coll1.containsAll(coll2));

        //clear()清空集合
        coll1.clear();
        System.out.println(coll1);
        System.out.println(coll1.size());

        //remove(Object obj)删除当前集合中与obj对象equals返回true的元素
        coll2.remove("ABC");
        coll2.remove(new Person("Jerry", 21)); //没重写equals()方法就删不掉
        System.out.println(coll2);

        //removeAll(Collection otherColl)差集
        Collection coll3 = new ArrayList();
        coll3.add(456);
        coll2.removeAll(coll3);
        System.out.println(coll2);

        //retainAll(Collection otherColl)交集
        Collection coll4 = new ArrayList();
        coll4.add(123);
        coll4.add("abc");
        coll4.add("ABC");
        coll4.add(new Person("Jerry", 21));
        Collection coll5 = new ArrayList();
        coll5.add(456);
        coll5.add("abc");
        coll5.add("ABC");
        coll5.add(new Person("Tom", 12));
        coll4.retainAll(coll5);
        System.out.println(coll4);

        Collection coll6 = new ArrayList();
        coll6.add(789);
        coll6.add("def");
        coll6.add(new Person("Jack", 18));

        //toArray()集合 to 数组
        Object[] arr = coll6.toArray();
        System.out.println(Arrays.toString(arr));

        //hashCode()
        System.out.println(coll6.hashCode());
        
        //数组 to 集合
        String[] s_arr = new String[]{"a", "b", "c"};
        Collection list1 = Arrays.asList(s_arr);
        System.out.println(list1);

        List list2 = Arrays.asList("A", "B", "C");
        System.out.println(list2);
    }
}

```

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person person)) return false;
//        return age == person.age && Objects.equals(name, person.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}
```

注意：向`Collection`中添加元素要求元素所属类要重写`equals()`方法，因为在比较时需要调用元素所在类的`equals()`方法。

```java
public void test2() {
    Integer[] i_arr1 = new Integer[]{1, 2, 3};
    List list1 = Arrays.asList(i_arr1);
    System.out.println(list1.size()); //3
    System.out.println(list1); //[1, 2, 3]

    int[] i_arr2 = new int[]{1, 2, 3};
    List list2 = Arrays.asList(i_arr2);
    System.out.println(list2.size()); //1
    System.out.println(list2); //[[I@5cdd8682]
}
```

## 迭代器

作用：用来遍历集合元素。

如何获取迭代器对象和进行遍历：

```java
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    @Test
    public void test1() {
        Collection coll1 = new ArrayList();

        coll1.add("abc");
        coll1.add(128);
        coll1.add(new Object());
        coll1.add(new Person("Tom", 12));

        //获取迭代器对象
        Iterator iter = coll1.iterator();
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//
//        System.out.println(iter.next()); //超出实际个数报异常NoSuchElementException

//        for (Object obj : coll1) {
//            System.out.println(obj);
//        }

        //推荐
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
```

## 增强`for`循环

针对集合来讲，增强`for`循环底层使用的还是迭代器。

增强`for`循环的执行过程中，是将集合或数组中的元素依次赋值给临时变量，注意，循环体中对临时变量的修改，可能不会导致原有集合或数组中元素的修改。

不要使用增强`for`循环来修改元素值。

```java
for (要遍历的集合或数组元素的类型 临时变量 : 要遍历的集合或数组变量) {
    操作临时变量的代码
}
```

```java
@Test
public void test2() {
    int[] i_arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    for (int i : i_arr) {
        System.out.println(i);
    }
}
```

