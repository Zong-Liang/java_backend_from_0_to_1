package com.practice.prac12.charstream_test.buffered_test;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Zong Liang
 * BufferedReader：缓冲字符输入流，支持按行读取（如 readLine()）。
 * BufferedWriter：缓冲字符输出流，减少底层调用。
 * 特点：处理流，提升文本处理效率。
 */
public class BufferedTest {
    @Test
    public void test1() {
        // 写入文件
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bufferedchar.txt"))) {
            bw.write("Hello, Buffered Character Streams!");
            bw.newLine(); // 写入换行符
            bw.write("Second line.");
            bw.flush();
            System.out.println("缓冲字符写入完成！");
        } catch (IOException e) {
            System.err.println("写入异常: " + e.getMessage());
        }

        // 读取文件
        try (BufferedReader br = new BufferedReader(new FileReader("bufferedchar.txt"))) {
            String line;
            while ((line = br.readLine()) != null) { // 按行读取
                System.out.println("读取一行: " + line);
            }
        } catch (IOException e) {
            System.err.println("读取异常: " + e.getMessage());
        }
    }
}
