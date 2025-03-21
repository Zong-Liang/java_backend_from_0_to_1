package com.practice.prac12.charstream_test.stringprint_test;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author Zong Liang
 * StringReader：从字符串读取字符数据，内存操作。
 * PrintWriter：方便的字符输出流，支持格式化输出。
 * 特点：StringReader 用于内存字符串，PrintWriter 功能强大。
 */
public class StringPrintTest {
    @Test
    public void test1() {
        // 写入文件
        try (PrintWriter pw = new PrintWriter(new FileWriter("printchar.txt"))) {
            pw.println("Hello, PrintWriter!"); // 写入一行并换行
            pw.printf("Formatted: %s, %d", "Age", 25); // 格式化输出
            pw.flush();
            System.out.println("PrintWriter写入完成！");
        } catch (IOException e) {
            System.err.println("写入异常: " + e.getMessage());
        }

        // 从字符串读取
        String data = "Hello, StringReader!";
        try (StringReader sr = new StringReader(data)) {
            char[] buffer = new char[1024];
            int charsRead = sr.read(buffer);
            String content = new String(buffer, 0, charsRead);
            System.out.println("读取内容: " + content);
        } catch (IOException e) {
            System.err.println("读取异常: " + e.getMessage());
        }
    }
}
