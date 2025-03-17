package com.practice.prac09.local_date_time_test;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Zong Liang
 */
public class LocalDateTimeTest {
    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now(); // 获取当前日期和时间
        System.out.println(now);

        LocalDateTime future = now.plusDays(10); // 加10天
        System.out.println(future);

        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(formattedDate);
    }
}
