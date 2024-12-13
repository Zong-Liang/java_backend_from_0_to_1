package com.learn_java.sec_11;

import org.junit.jupiter.api.Test;

public class UseWrapperClass {
    // 基本数据类型 to 包装类(不推荐)
    @Test
    public void test1() {
        int i1=10;
        Integer ii1 = new Integer(i1);  //'Integer(int)' is deprecated since version 9 and marked for removal
        System.out.println(ii1.toString());

        float f1 = 3.14f;
        String f2 = "2.72";
        Float ff1 = new Float(f1);  //'Float(float)' is deprecated since version 9 and marked for removal
        Float ff2 = new Float(f2);  //'Float(String)' is deprecated since version 9 and marked for removal
        System.out.println(ff1.toString());
        System.out.println(ff2.toString());

        boolean b1 = true;
        String b2 = "True";
        String b3 = "False";
        Boolean bb1 = new Boolean(b1);  //'Boolean(boolean)' is deprecated since version 9 and marked for removal
        Boolean bb2 = new Boolean(b2);  //'Boolean(String)' is deprecated since version 9 and marked for removal
        Boolean bb3 = new Boolean(b3);  //'Boolean(String)' is deprecated since version 9 and marked for removal
        System.out.println(bb1.toString());
        System.out.println(bb2.toString());// 忽略大小写，不是true就都是false
        System.out.println(bb3.toString());

    }

    // 基本数据类型 to 包装类
    // 推荐使用:调用包装类的静态方法valueOf()
    @Test
    public void test2() {
        int i1 = 10;
        Integer ii1 = Integer.valueOf(i1);
        System.out.println(ii1.toString());

        float f1 = 3.14f;
        String f2 = "2.72";
        Float ff1 = Float.valueOf(f1);
        Float ff2 = Float.valueOf(f2);
        System.out.println(ff1.toString());
        System.out.println(ff2.toString());

        boolean b1 = true;
        String b2 = "True";
        String b3 = "False";
        Boolean bb1 = Boolean.valueOf(b1);
        Boolean bb2 = Boolean.valueOf(b2);
        Boolean bb3 = Boolean.valueOf(b3);
        System.out.println(bb1.toString());
        System.out.println(bb2.toString());// 忽略大小写，不是true就都是false
        System.out.println(bb3.toString());
    }

    // 包装类 to 基本数据类型
    // 调用包装类的xxxValue()：包装类对象.xxxValue()

    @Test
    public void test3() {
        Integer ii1 = Integer.valueOf(10);
        int i1 = ii1.intValue();
        System.out.println(++i1);

        Float ff1 = Float.valueOf(3.14f);
        float f1 = ff1.floatValue();
        System.out.println(--f1);

        Boolean bb1 = Boolean.valueOf(true);
        boolean b1 = bb1.booleanValue();
        System.out.println(b1);
    }

    // 包装类和基本数据类型的区别
    @Test
    public void test4() {
        Account account = new Account();
        System.out.println(account.isFlag1);// false
        System.out.println(account.isFlag2);// null

        System.out.println(account.balance1);// 0.0
        System.out.println(account.balance2);// null

    }

    // jdk5.0 新特性：自动装箱拆箱
    @Test
    public void test5() {
        // 自动装箱
        int i1 = 10;
        System.out.println(i1);
        Integer ii1 = i1;
        System.out.println(ii1);

        float f1 = 3.14f;
        System.out.println(f1);
        Float ff1 = f1;
        System.out.println(ff1);

        boolean b1 = true;
        System.out.println(b1);
        Boolean bb1 = b1;
        System.out.println(bb1);

        // 自动拆箱
        int i2 = ii1;
        System.out.println(i2);

        float f2 = ff1;
        System.out.println(f2);

        boolean b2 = bb1;
        System.out.println(b2);
    }

    // String类 to 基本数据类型、包装类
    // 调用包装类的静态方法：parseXxx(String s)
    @Test
    public void test6() {
        String str1 = "250";
        int i1 = Integer.parseInt(str1);
        System.out.println(i1 + 1);

        String str2 = "false";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);

//        String str3 = "3.0a";
//        float f1 = Float.parseFloat(str3);  //java.lang.Float.parseFloat
    }
}
