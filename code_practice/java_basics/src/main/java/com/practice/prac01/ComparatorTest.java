package com.practice.prac01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Zong Liang
 */
public class ComparatorTest {
    Person p1 = new Person("Alice", 25);
    Person p2 = new Person("Bob", 24);
    Person p3 = new Person("Cathe", 23);
    Person p4 = new Person("David", 22);
    Person p5 = new Person("Eli", 21);
    Person p6 = new Person("Fiona", 23);

    @Test
    public void test1() {
        Person[] persons = {p1, p2, p3, p4, p5, p6};

        System.out.println("排序前：");
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("排序后：");
        //Comparator接口的匿名实现类
//        Arrays.sort(persons, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                int vaule = o1.getAge() - o2.getAge();
//                if (vaule != 0) {
//                    return vaule;
//                }
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        //Lambda表达式
//        Arrays.sort(persons, (o1, o2) -> {
//            int vaule = o1.getAge() - o2.getAge();
//            if (vaule != 0) {
//                return vaule;
//            }
//            return o1.getName().compareTo(o2.getName());
//        });
        //Lambda表达式简化
//        Arrays.sort(persons, (o1, o2) -> (o1.getAge() - o2.getAge()) != 0 ? (o1.getAge() - o2.getAge()) : o1.getName().compareTo(o2.getName()));
        //方法引用
        Arrays.sort(persons, Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    @Test
    public void test2() {
        List<Person> people = Arrays.asList(p1, p2, p3, p4, p5, p6);

        System.out.println("排序前：");
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("排序后：");

        people.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        people.forEach(System.out::println);

    }
}
