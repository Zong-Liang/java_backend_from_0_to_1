package com.practice.prac12.bytestream_test.bufferedstream_test;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Zong Liang
 * BufferedInputStream：通过缓冲区减少对底层文件系统的直接访问，提高读取效率。
 * BufferedOutputStream：缓冲字节输出，批量写入数据，提升性能。
 * 特点：处理流，适合大规模数据操作。
 */
public class BufferedStreamTest {
    @Test
    public void test1() {
        // 写入文件
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("buffered.txt"))) {
            String data = "Hello, Buffered Streams!";
            byte[] bytes = data.getBytes();
            bos.write(bytes); // 写入缓冲区
            bos.flush();      // 刷新缓冲区到文件
            System.out.println("缓冲写入完成！");
        } catch (IOException e) {
            System.err.println("写入异常: " + e.getMessage());
        }

        // 读取文件
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("buffered.txt"))) {
            byte[] buffer = new byte[1024];
            int bytesRead = bis.read(buffer); // 从缓冲区读取
            String content = new String(buffer, 0, bytesRead);
            System.out.println("读取内容: " + content);
        } catch (IOException e) {
            System.err.println("读取异常: " + e.getMessage());
        }
    }
}
