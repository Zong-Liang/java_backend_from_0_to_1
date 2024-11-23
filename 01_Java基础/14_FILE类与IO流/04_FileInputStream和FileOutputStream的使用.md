# 04_FileInputStream和FileOutputStream的使用

步骤：

- 创建读取或写入的File类的对象。

- 创建输入输出流。
- 具体的读取或写入过程。
  - 读取：`read(byte[] buffer)`。
  - 写入：`write(byte[] buffer, 0, len)`。
- 关闭流资源，避免内存泄漏。

因为涉及到流资源的关闭操作，所以使用try-catch-finally来处理异常。

对于输入流来讲，要求`File`类的对象对应的物理磁盘文件必须存在，否则，会报`FileNotFoundException`。

对于输出流来讲，`File`类的对象对应的物理磁盘文件可以不存在，文件不存在的话会自动创建，文件存在的话和使用的构造器有关，使用`FileOutputStream(File file)`或`FileOutputStream(File file, false)`时会对现有文件进行覆盖，使用`FileOutputStream(File file, true)`会追加到现有文件内容之后。

对于字符流，只能用来操作文本文件，不能用来处理非文本文件。

对于字节流，通常用来处理非文本文件，如果涉及文本文件的复制操作，也可以使用字节流，不过要注意中文乱码问题。

```java
import org.junit.jupiter.api.Test;

import java.io.*;

public class FileInputOutputStreamTest {
    //使用 FileInputStream 和 FileOutputStream 复制文件
    @Test
    public void test1() {
        //创建相关的File类的对象
        File file1 = new File("Wukong.png");
        File file2 = new File("Wukong_copy.png");

        //创建相关的字节流
        FileInputStream fis = null;
        FileOutputStream fos = null;

        //数据的读入和写出操作
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            byte[] buffer = new byte[1024];
            int len; //记录每次读入到 buffer 中的字节的个数
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            try {
                assert fis != null;
                fis.close();
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //复制hello.txt文件为hello3.txt
    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("hello3.txt");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            assert fis != null;
            fis.close();
            assert fos != null;
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //读取hello.txt文件输出到控制台上
    @Test
    public void test4() {
        File file = new File("hello.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buffer = new byte[5]; //输出乱码
//            byte[] buffer = new byte[20]; //正常输出
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            assert fis != null;
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

文本文件：`.txt`、`.java`、`.c`、`.cpp`、`.py`等。

非文本文件：`.doc`、`.xls`、`.jpg`、`.pdf`、`.mp3`、`.mp4`、`.avi`等。
