package com.practice.prac09.date_test;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Zong Liang
 * java.util.Date 是 Java 中一个历史悠久的类，用于表示日期和时间。
 * 它在 Java 早期版本中被广泛使用，但由于其设计上的缺陷（如可变性、线程不安全、缺乏清晰的时间日期模型等），
 * 在 Java 8 引入了新的日期时间 API（java.time 包）后，java.util.Date 的使用逐渐减少。
 */
public class DateTest {
    @Test
    public void test1() {
        Date now = new Date(); // 获取当前日期和时间
        System.out.println(now); // 输出：Mon Mar 17 12:34:56 CST 2025

        Date specificDate = new Date(1672502400000L); // 使用时间戳（毫秒）
        System.out.println(specificDate); // 输出：Mon Jan 01 00:00:00 CST 2023

        Date d1 = new Date();
        long timestamp = d1.getTime(); // 获取时间戳
        System.out.println("Timestamp: " + timestamp);
        d1.setTime(1672502400000L); // 设置时间戳
        System.out.println(d1); // 输出：Mon Jan 01 00:00:00 CST 2023

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(d1); // 格式化为字符串
        System.out.println(formattedDate); // 输出：2025-03-17 12:34:56

        String dateStr = "2025-03-17 12:34:56";
        try {
            Date d2 = formatter.parse(dateStr); // 解析字符串为 Date 对象
            System.out.println(d2); // 输出：Mon Mar 17 12:34:56 CST 2025
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date d3 = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d3);

        // 加10天
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date d4 = calendar.getTime();

        System.out.println("Original Date: " + d3);
        System.out.println("New Date: " + d4);
    }
}
