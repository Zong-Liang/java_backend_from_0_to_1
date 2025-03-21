package com.practice.prac12.bytestream_test.bytearraystream_test;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Zong Liang
 * ByteArrayInputStream：从字节数组读取数据，内存操作，无需文件。
 * ByteArrayOutputStream：将数据写入内存中的字节数组，可动态扩展。
 * 特点：适合临时存储或内存数据处理。
 */
public class ByteArrayStreamTest {
    @Test
    public void test1() {
        // 写入内存
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            String data = "Hello, ByteArray Streams!";
            baos.write(data.getBytes()); // 写入字节数组
            byte[] output = baos.toByteArray(); // 获取字节数组
            System.out.println("内存写入完成: " + new String(output));
        } catch (IOException e) {
            System.err.println("写入异常: " + e.getMessage());
        }

        // 从内存读取
        byte[] input = "Hello, ByteArray Streams!".getBytes();
        try (ByteArrayInputStream bais = new ByteArrayInputStream(input)) {
            byte[] buffer = new byte[1024];
            int bytesRead = bais.read(buffer); // 从字节数组读取
            String content = new String(buffer, 0, bytesRead);
            System.out.println("读取内容: " + content);
        } catch (IOException e) {
            System.err.println("读取异常: " + e.getMessage());
        }
        
    }
}
