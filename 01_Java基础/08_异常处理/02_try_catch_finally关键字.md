# 02_try_catch关键字

将可能出现异常的代码声明在`try`语句中，一旦代码出现异常，就会自动生成一个对应异常类的对象，并将此对象抛出。针对`try`中抛出的异常类对象，使用之后的`catch`语句进行匹配，一旦匹配上，就进入`catch`语句块进行处理。一旦处理结束，代码就继续向下执行。

如果声明了多个`catch`结构，不同的异常类型在不存在子父类关系的前提下，声明先后无要求，但若存在子父类关系，就必须将子类声明在父类结构上面，否则报错。

`catch`中处理异常的方式：自己编写输出语句、`printStackTrace()`打印异常详细信息、`getMessage()`获取发生异常的原因。

`try`中声明的变量只在`try`结构内生效。

开发中对运行时异常不做显示处理，一旦程序运行中出现运行时异常，只需要根据异常提示信息修改代码即可。对于编译时异常，必须做显示处理。

无论`try` 或`catch`中是否存在未被处理的异常或`return`语句，`finally`中的语句一定会执行。

```java
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleException {
    @Test
    public void test1() {
        try {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt(); //InputMismatchException
            System.out.println(i);
        } catch (InputMismatchException e) {
            System.out.println("出现InputMismatchException");
        }

        System.out.println("异常处理结束，继续执行代码");
    }

    @Test
    public void test2() {
        try {
            String str = "123";
            str = "abc";
            int i = Integer.parseInt(str);
            System.out.println(i);
        } catch (NumberFormatException e) {
            e.printStackTrace(); //推荐
//            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            File file = new File("hello.txt");

            FileInputStream fis = new FileInputStream(file); //java.io.FileNotFoundException

            int data = fis.read(); //java.io.IOException
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read(); //java.io.IOException
            }
            fis.close(); //java.io.IOException
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("读取数据结束");
    }

    public void test4() {
        try {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt(); //InputMismatchException
            System.out.println(i);
        } catch (InputMismatchException e) {
            System.out.println("出现InputMismatchException");
            System.out.println(10 / 0); //在catch中存在异常
        } finally {
            System.out.println("异常处理结束，继续执行代码");

        }

    }
}
```

![image-20240310141537791](https://cdn.jsdelivr.net/gh/ZL85/ImageBed@main//202403101422115.png)

```java
public class Finally {
    //    public static void main(String[] args) {
//        int result = test("8");
//        System.out.println(result);
//    }
//
//    public static int test(String str) {
//        try {
//            Integer.parseInt(str);
//            return 1;
//        } catch (NumberFormatException e) {
//            return -1;
//        } finally {
//            System.out.println("test结束");
//        }
//    }

//    public static void main(String[] args) {
//        int result = test("a");
//        System.out.println(result);
//    }
//
//    public static int test(String str) {
//        try {
//            Integer.parseInt(str);
//            return 1;
//        } catch (NumberFormatException e) {
//            return -1;
//        } finally {
//            System.out.println("test结束");
//        }
//    }

//    public static void main(String[] args) {
//        int result = test("a");
//        System.out.println(result);
//    }
//
//    public static int test(String str) {
//        try {
//            Integer.parseInt(str);
//            return 1;
//        } catch (NumberFormatException e) {
//            return -1;
//        } finally {
//            System.out.println("test结束");
//            return 0;
//        }
//    }

    public static void main(String[] args) {
        int result = test(10);
        System.out.println(result);
    }

    public static int test(int i) {
        try {
            return i;
        } catch (NumberFormatException e) {
            return i--;
        } finally {
            System.out.println("test结束");
//            return ++i; //11
            ++i; //10
        }
    }
}
```

什么样的代码一定要声明在`finally`里面？

在开发中，有一些资源 (输入输出流、数据库连接、socket 连接等) 在使用完之后必须显示的进行关闭，不然GC不会自动回收这些资源，进而导致内存的泄漏。为了保证这些资源在使用完以后，不管是否出现了未被处理的情况，这些资源能被关闭，这是就需要把操作声明在`finally`中。

`try-catch`结构可以嵌套使用。

```java
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Finally {
    @Test
    public void test1() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");

            fis = new FileInputStream(file); //java.io.FileNotFoundException

            int data = fis.read(); //java.io.IOException
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read(); //java.io.IOException
            }
            //java.io.IOException
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //将流资源的关闭操作放在finally中
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("读取数据结束");
    }
}
```

