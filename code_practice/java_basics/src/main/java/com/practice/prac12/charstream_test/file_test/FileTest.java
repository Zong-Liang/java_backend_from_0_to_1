package com.practice.prac12.charstream_test.file_test;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Zong Liang
 * FileReader：从文件中读取字符数据，适合文本文件。
 * FileWriter：将字符数据写入文件，支持追加模式。
 * 特点：节点流，直接操作文件。
 */
public class FileTest {
    @Test
    public void test1() {
        // 写入文件
        try (FileWriter fw = new FileWriter("filechar.txt")) {
            String data = "Hello, File Character Streams!";
            fw.write(data); // 写入字符数据
            fw.flush();     // 刷新缓冲区
            System.out.println("字符写入完成！");
        } catch (IOException e) {
            System.err.println("写入异常: " + e.getMessage());
        }

        // 读取文件
        try (FileReader fr = new FileReader("filechar.txt")) {
            char[] buffer = new char[1024];
            int charsRead = fr.read(buffer); // 读取字符到缓冲区
            String content = new String(buffer, 0, charsRead);
            System.out.println("读取内容: " + content);
        } catch (IOException e) {
            System.err.println("读取异常: " + e.getMessage());
        }
        
    }
}
