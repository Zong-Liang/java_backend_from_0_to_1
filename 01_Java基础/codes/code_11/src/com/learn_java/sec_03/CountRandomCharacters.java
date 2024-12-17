package com.learn_java.sec_03;

import java.util.ArrayList;
import java.util.Collection;

//创建集合，存储30个随机生成的小写字母，统计某个字母出现的次数
public class CountRandomCharacters {

    public static void main(String[] args) {
        var list = new ArrayList();

        for (int i = 0; i < 30; i++) {
            list.add((char) (Math.random() * (122 - 97 + 1) + 97) + "");
        }
        System.out.println(list);

        System.out.println("字母a在随机生成的字母列表中出现的次数为：" + countCharacters(list, "a"));
    }

    public static int countCharacters(Collection coll, String s) {
        int count = 0;
        for (Object o : coll) {
            if (s.equals(o)) {
                count++;
            }
        }
        return count;
    }

}
