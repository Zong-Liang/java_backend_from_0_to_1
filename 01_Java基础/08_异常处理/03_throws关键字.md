# 03_throws关键字

从编译是否能通过的角度看，`throws`的方式仅是将可能出现的异常抛给了此方法的调用者，此调用者仍然需要考虑如何处理相关异常，所以，`throws`的方式不算是真正意义上处理了异常。

子类重写的方法抛出的异常类型可以与父类被重写的方法抛出的异常类型相同，或是父类被重写的方法抛出的异常类型的子类。

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Throws {
    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");

        FileInputStream fis = new FileInputStream(file); //java.io.FileNotFoundException

        int data = fis.read(); //java.io.IOException
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read(); //java.io.IOException
        }
        fis.close(); //java.io.IOException
    }

    public static void method2() throws IOException {
        method1();
    }

    public static void method3() {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        method3();
//        method2();
    }
}
```

实际开发中，编译时异常处理方式的选择：

- 如果程序代码中，涉及到资源的调用 (流、数据库连接、网络连接等)，则必须考虑使用`try-catch-finally`来处理，保证不出现内存泄漏。
- 如果父类被重写的方法没有`throws`异常类型，则子类重写的方法中如果出现异常，只能考虑使用`try-catch-finally`进行处理，不能`throws`。
- 开发中，方法`a`中依次调用了方法`b,c,d`等方法，方法`b,c,d`之间是递进关系。此时，如果方法`b,c,d`中有异常，我们通常选择使用`throws`，而方法`a`中通常选择使用`try-catch-finally`。