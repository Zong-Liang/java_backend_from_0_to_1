package com.learn_java.sec_04;

import org.junit.jupiter.api.Test;

import java.util.*;

public class UseSet {
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

    //自然排序
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

    //定制排序
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
}
