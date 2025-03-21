package com.practice.prac12.charstream_test.iostream_test;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Zong Liang
 * InputStreamReader：将字节输入流转换为字符输入流，支持指定编码。
 * OutputStreamWriter：将字符输出流转换为字节输出流，支持指定编码。
 * 特点：桥梁流，用于字节流和字符流转换。
 */
public class IOStreamTest {
    @Test
    public void test1() {
        // 写入文件
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("streamchar.txt"), "UTF-8")) {
            osw.write("Hello, Stream Reader/Writer!"); // 写入字符
            osw.flush();
            System.out.println("字符流写入完成！");
        } catch (IOException e) {
            System.err.println("写入异常: " + e.getMessage());
        }

        // 读取文件
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("streamchar.txt"), "UTF-8")) {
            char[] buffer = new char[1024];
            int charsRead = isr.read(buffer);
            String content = new String(buffer, 0, charsRead);
            System.out.println("读取内容: " + content);
        } catch (IOException e) {
            System.err.println("读取异常: " + e.getMessage());
        }
    }
}
