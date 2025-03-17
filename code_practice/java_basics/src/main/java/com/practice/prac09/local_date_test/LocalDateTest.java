package com.practice.prac09.local_date_test;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Zong Liang
 * LocalDate 是 Java 8 引入的日期和时间 API（java.time 包）中的一个类，用于表示没有时间部分的日期（年、月、日）。
 * 它是不可变的（immutable）和线程安全的，非常适合在多线程环境中使用。
 */
public class LocalDateTest {
    @Test
    public void test1() {
        // 创建日期
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2025, 3, 17);

        System.out.println("Today: " + today);
        System.out.println("Specific Date: " + specificDate);

        // 日期计算
        LocalDate plusDays = specificDate.plusDays(10);
        LocalDate minusMonths = specificDate.minusMonths(1);

        System.out.println("Plus 10 days: " + plusDays);
        System.out.println("Minus 1 month: " + minusMonths);

        // 获取特定日期
        LocalDate firstDayOfYear = specificDate.with(TemporalAdjusters.firstDayOfYear());
        LocalDate lastDayOfMonth = specificDate.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("First day of year: " + firstDayOfYear);
        System.out.println("Last day of month: " + lastDayOfMonth);

        // 格式化日期
        String formattedDate = specificDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("Formatted Date: " + formattedDate);

        // 比较日期
        boolean isBefore = specificDate.isBefore(today);
        System.out.println("Is specific date before today? " + isBefore);
    }
}
