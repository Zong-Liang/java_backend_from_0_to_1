package com.learn_java.sec_05;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class UseMap {
    @Test
    public void test1() {
        Map map = new HashMap();

        map.put(null, null);

        System.out.println(map);
    }

    @Test
    public void test2() {
        Map map = new Hashtable();

//        map.put("a",null); //NullPointerException
//        map.put(null,1); //NullPointerException
        map.put("a", 1);

        System.out.println(map);
    }

    @Test
    public void test3() {
        LinkedHashMap map = new LinkedHashMap();

        map.put("Tom", 23);
        map.put("a", new Date());
        map.put(1, "b");

        System.out.println(map);
    }

    @Test
    public void test4() {
        var map = new HashMap();

        //put(Object key, Object value)
        map.put("a", 1);
        map.put(2, "b");
        map.put(new Person("Tom", 16), "p");
        System.out.println(map);

        //size()
        System.out.println(map.size());

        //remove(Object key)
        System.out.println(map.remove(new Person("Tom", 16)));
        System.out.println(map);

        //put(Object key, Object value)
        map.put("a", 8);
        System.out.println(map);

        //get(Object key)
        System.out.println(map.get(2));
    }

    @Test
    public void test5() {
        HashMap map = new HashMap();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(new Person("Jerry", 15), "d");
        map.put(new Person("Jack", 16), "e");

        //遍历key
        var keys = map.keySet();
        for (Object o : keys) {
            System.out.println(o);
        }

        //遍历value
        var values = map.values();
        for (Object o : values) {
            System.out.println(o);
        }

        //遍历entry
        var entries = map.entrySet();
        for (Object o : entries) {
            System.out.println(o);
        }
    }

    //自然排序
    @Test
    public void test6() {
        var map = new TreeMap();

        var u1 = new User("Tom", 16);
        var u2 = new User("Jerry", 17);
        var u3 = new User("Jack", 18);
        var u4 = new User("Rose", 16);
        var u5 = new User("Robbin", 26);

        map.put(u1, 99);
        map.put(u2, 89);
        map.put(u3, 82);
        map.put(u4, 96);
        map.put(u5, 66);

        var entries = map.entrySet();
        for (Object o : entries) {
            System.out.println(o);
        }

        System.out.println(map.containsKey(new User("Robbin", 26)));
    }

    //定制排序
    @Test
    public void test7() {
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

        var map = new TreeMap(comparator);

        var u1 = new User("Tom", 16);
        var u2 = new User("Jerry", 17);
        var u3 = new User("Jack", 18);
        var u4 = new User("Rose", 16);
        var u5 = new User("Robbin", 26);

        map.put(u1, 99);
        map.put(u2, 89);
        map.put(u3, 82);
        map.put(u4, 96);
        map.put(u5, 66);

        var entries = map.entrySet();
        for (Object o : entries) {
            System.out.println(o);
        }
    }

    @Test
    public void test8() {
        //方式1：数据和代码耦合度高，如果修改需要重写编译代码，打包发布，繁琐
        //数据
//        var name = "zl";
//        var password = "123456";
        //操作name、password的代码
        //...

        //方式2：将数据封装到具体的配置文件中，在程序中读取配置文件的信息，实现了数据和代码的解耦，省去了重新编译打包的过程。
        var file = new File("src/com/learn_java/sec_05/info.properties"); //要提前创建好
        System.out.println(file.getAbsoluteFile());

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        var props = new Properties();
        try {
            props.load(fis); //加载流中的数据
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var name = props.getProperty("name");
        var pwd = props.getProperty("password");

        System.out.println(name + ": " + pwd);

        try {
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
