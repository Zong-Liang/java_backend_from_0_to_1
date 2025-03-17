package com.practice.prac01.comparable_test;

import com.practice.prac01.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Zong Liang
 */
public class ComparableTest {
    @Test
    public void test1() {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 24);
        Person p3 = new Person("Cathe", 23);
        Person p4 = new Person("David", 22);
        Person p5 = new Person("Eli", 21);
        Person p6 = new Person("Fiona", 23);

        System.out.println("排序前：");
        Person[] persons = {p1, p2, p3, p4, p5, p6};
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("排序后：");
        Arrays.sort(persons);
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
