package com.learn_java.sec_03;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

public class UseGenerics {
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * (99 - 0 + 1));
            list.add(random);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }

        //使用removeIf()删除其中偶数，为Predicate接口指定泛型<Integer>
        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });

        System.out.println();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
