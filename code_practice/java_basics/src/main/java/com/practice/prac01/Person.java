package com.practice.prac01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zong Liang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    //先按年龄再按姓名自然升序排序，要想降序排序，只需在返回值前加负号即可
    @Override
    public int compareTo(Person o) {
        int value = this.age - o.age;
        if (value != 0) {
            return value;
        }
        return this.name.compareTo(o.name);
    }
}
