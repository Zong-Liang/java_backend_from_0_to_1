package com.learn_java.sec_01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UseCollection {
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
        Object[] o_arr = coll6.toArray();
        System.out.println(Arrays.toString(o_arr));

        //hashCode()
        System.out.println(coll6.hashCode());

        //数组 to 集合
        String[] s_arr = new String[]{"a", "b", "c"};
        Collection list1 = Arrays.asList(s_arr);
        System.out.println(list1);

        Collection list2 = Arrays.asList("A", "B", "C");
        System.out.println(list2);
    }

    @Test
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
}
