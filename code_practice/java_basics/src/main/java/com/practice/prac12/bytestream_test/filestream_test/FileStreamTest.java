package com.practice.prac12.bytestream_test.filestream_test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Zong Liang
 * FileInputStream：从文件中读取字节数据，适用于二进制文件或文本文件。
 * FileOutputStream：将字节数据写入文件，可选择覆盖或追加模式。
 * 特点：直接操作文件，是节点流，适合小规模文件操作。
 */
public class FileStreamTest {
    @Test
    public void test1() {
        // 写入文件
        try (FileOutputStream fos = new FileOutputStream("file.txt")) {
            String data = "Hello, File Streams!";
            byte[] bytes = data.getBytes(); // 转换为字节数组
            fos.write(bytes);              // 写入字节数据
            fos.flush();                   // 刷新缓冲区
            System.out.println("数据写入完成！");
        } catch (IOException e) {
            System.err.println("写入异常: " + e.getMessage());
        }

        // 读取文件
        try (FileInputStream fis = new FileInputStream("file.txt")) {
            byte[] buffer = new byte[1024]; // 缓冲区
            int bytesRead = fis.read(buffer); // 读取字节到缓冲区
            String content = new String(buffer, 0, bytesRead); // 转换为字符串
            System.out.println("读取内容: " + content);
        } catch (IOException e) {
            System.err.println("读取异常: " + e.getMessage());
        }
    }
}
