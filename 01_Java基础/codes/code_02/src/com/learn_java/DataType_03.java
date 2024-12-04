package com.learn_java;

/*
Java中的数据类型：
1.基本数据类型
    整数型：byte、short、int、long
    浮点型：float、double
    字符型：char
    布尔型：boolean
2.引用数据类型
    类：class
    接口：interface
    数组：[]
    枚举：enum
    注解：@interface
    字符串：String
    日期：Date
    等等

Java中的数据类型转换：
1.自动类型转换
    从小到大自动转换 byte、short、char < int < long < float < double
2.强制类型转换
    从大到小需要强制转换
    (类型名)要转换的值
    注意：强制类型转换可能导致精度降低或溢出
 */


public class DataType_03 {
    public static void main(String[] args) {
        //定义变量
        //数据类型 变量名称[=值]
        //定义byte型变量
        byte num = 66;
        System.out.println(num);

        //定义short型变量
        short num1 = 520;
        System.out.println(num1);

        //定义int型变量
        int num2 = 1314;
        System.out.println(num2);

        //定义long型变量
        //若赋给的值大于int型的最大值或小于int型的最小值，则需要在数字后加L或l，表示该数值为长整数
        long num3 = 2147483650L;
        System.out.println(num3);

        //定义float型变量
        //在默认情况下，小数都被看作double型
        //若使用float型小数，需要在小数后面添加F或f
        float num4 = 3.14F;
        System.out.println(num4);

        //定义double型变量
        double num5 = 2.7654321D;
        System.out.println(num5);

        //定义char类型变量
        char char1 = 'a';
        System.out.println(char1 + "\n" + (int) char1);

        //定义bool类型变量
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1);
        System.out.println(b2);

        //隐式类型转换
        byte my_byte = 127;
        short my_short = 150;
        int my_int = 1;
        float my_float = 3.14F;
        double my_double = 3.15D;
        char my_char = 97;
        System.out.println(my_byte + my_short);
        System.out.println(my_short + my_int);
        System.out.println(my_int + my_float);
        System.out.println(my_float + my_double);
        System.out.println(my_double + my_char);

        //强制类型转换
        //(类型名)要转换的值
        int a = (int) 3.14;
        System.out.println(a);
        float b = (float) 3;
        System.out.println(b);
        int c = (int) 'd';
        System.out.println(c);
    }
}
