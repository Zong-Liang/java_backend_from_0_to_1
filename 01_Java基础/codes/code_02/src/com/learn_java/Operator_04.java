package com.learn_java;

import java.text.DecimalFormat;

/*
通常优先级由高到低的顺序依次是：
增量和减量运算
算术运算
比较运算
逻辑运算
赋值运算
*/

public class Operator_04 {
    public static void main(String[] args) {
        //赋值运算符
        int num = 6;
        System.out.println(num);

        //加+
        float num1 = 3.14f + 2;
        System.out.println(num1);

        //减-
        float num2 = 5.20f - 2;
        System.out.println(num2);

        //乘*
        float num3 = 3.14f * 2;
        System.out.println(num3);

        //除/
        float num4 = 13.14f / 2;
        System.out.println(num4);

        //求余%
        int num5 = 19 % 3;
        System.out.println(num5);

        //自增++
        int count = 0;
        for (int i = 0; i < 2; i++) {
            count++;
            System.out.println(count);
        }

        //自减--
        int count1 = 6;
        for (int i = 2; i > 0; i--) {
            count1--;
            System.out.println(count1);
        }

        //大于>
        System.out.println(5 > 10);

        //小于<
        System.out.println(10 < 5);

        //等于==
        System.out.println(9 == 5);

        //大于等于>=
        System.out.println(5 >= 5);

        //小于等于<=
        System.out.println(9 <= 9);

        //不等于!=
        System.out.println(9 != 6);

        boolean b1 = true;
        boolean b2 = false;
        //逻辑与&&、&
        //“&&”属于“短路”运算符，而“&”则属于“非短路”运算符。
        //“&&”是针对boolean类型的类进行判断，当第一个表达式为false时则不去判断第二个表达式
        //“&”会判断两个表达式
        System.out.println(b2 && b1);
        System.out.println(b1 & b2);

        //逻辑或|
        System.out.println(b1 | b2);

        //逻辑非!
        System.out.println(!b1);
        System.out.println(!b2);

        //按位与&
        DecimalFormat df = new DecimalFormat("0000000000000000");
        System.out.println(df.format(Integer.valueOf(Integer.toBinaryString(5 & -4))));

        //按位或|
        System.out.println(df.format(Integer.valueOf(Integer.toBinaryString(3 | 6))));

        //按位取反~
        //System.out.println(df.format(Integer.valueOf(Integer.toBinaryString(~7))));

        //按位异或^
        System.out.println(df.format(Integer.valueOf(Integer.toBinaryString(10 ^ 3))));

        //移位运算符适用的数据类型有byte、short、char、int和long
        //移位可以实现整数除以或乘以2n的效果
        //左移<<
        System.out.println(df.format(Integer.valueOf(Integer.toBinaryString(2 << 1))));

        //右移>>
        System.out.println(df.format(Integer.valueOf(Integer.toBinaryString(8 >> 1))));

        //无符号右移>>>，无论最高位是0还是1，左侧被移空的高位都填入0
        System.out.println(df.format(Integer.valueOf(Integer.toBinaryString(8 >>> 1))));

        //条件运算符: 条件式?值1:值2
        int num6 = 15, num7 = 26;
        System.out.println(num6 > num7 ? num6 : num7);
    }
}
