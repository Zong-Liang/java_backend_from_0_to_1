package com.learn_java.sec_02;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

public class UseGenerics {
    //自然排序：按照name排序
    @Test
    public void test1() {
        TreeSet<Employee> set = new TreeSet<>();

        set.add(new Employee("Tom", 23, new MyDate(1998, 5, 23)));
        set.add(new Employee("Jerry", 22, new MyDate(1999, 6, 5)));
        set.add(new Employee("Jack", 24, new MyDate(1997, 7, 26)));
        set.add(new Employee("Rose", 21, new MyDate(2000, 8, 26)));
        set.add(new Employee("Robin", 21, new MyDate(2001, 6, 16)));

        for (Employee employee : set) {
            System.out.println(employee);
        }
    }


    //定制排序：按照生日先后进行排序
    @Test
    public void test2() {
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int minusYear = o1.getBirthday().getYear() - o2.getBirthday().getYear();
                if (minusYear != 0) {
                    return minusYear;
                }

                int minusMonth = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                if (minusMonth != 0) {
                    return minusMonth;
                }

                return o1.getBirthday().getDay() - o2.getBirthday().getDay();
            }
        };

        TreeSet<Employee> set = new TreeSet<>(comparator);

        set.add(new Employee("Tom", 23, new MyDate(1998, 5, 23)));
        set.add(new Employee("Jerry", 22, new MyDate(1999, 6, 5)));
        set.add(new Employee("Jack", 24, new MyDate(1997, 7, 26)));
        set.add(new Employee("Rose", 21, new MyDate(2000, 8, 26)));
        set.add(new Employee("Robin", 21, new MyDate(2001, 6, 16)));

        for (Employee employee : set) {
            System.out.println(employee);
        }
    }
}
