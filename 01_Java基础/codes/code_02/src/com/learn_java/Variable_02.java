package com.learn_java;
/*
在类体中所定义的变量被称为成员变量，成员变量在整个类中都有效。
如果在成员变量的类型前面加上关键字static，这样的成员变量称为静态变量。
静态变量的有效范围可以跨类，甚至可达到整个应用程序之内。
对于静态变量，除了能在定义它的类内存取，还能直接以“类名.静态变量”的方式在其他类内使用。

在类的方法体中定义的变量称为局部变量。局部变量只在当前代码块中有效。
*/

/*Java中变量名命名规则：
1.变量名只能包含字母、数字、下划线和美元符号，不能包含空格
2.变量名不能以数字开头
3.变量名不能是Java关键字
4.变量名区分大小写
5.变量名最好能够体现变量的含义
6.变量名采用驼峰命名法，即除第一个单词外，其他单词首字母大写
7.变量名尽量简洁，但不要太简单，要有意义
*/
public class Variable_02 {
    //成员变量
    static String str = "HELLO WORLD!";

    public static void main(String[] args) {
        System.out.println(str);

        //局部变量
        //局部变量可与成员变量的名字相同，此时成员变量在此方法中暂时失效。
        String str = "HELLO AHU!";
        System.out.println(str);

        //Java中变量声明格式：数据类型 变量名 = 变量值;
        int age = 18;
        System.out.println(age);
    }
}
