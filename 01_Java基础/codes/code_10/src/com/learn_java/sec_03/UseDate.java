package com.learn_java.sec_03;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class UseDate {
    @Test
    public void test1() {
        Date d1 = new Date(); //创建一个基于当前系统时间的Date实例
        System.out.println(d1.toString());
        System.out.println("对应毫秒数为：" + d1.getTime()); //1710915097018

        Date d2 = new Date(1710915097018L); // 创建一个基于指定时间戳的Date实例
        System.out.println(d2.toString()); //Wed Mar 20 14:11:37 CST 2024
    }

    @Test
    public void test2() {
        java.sql.Date d1 = new java.sql.Date(1710915097018L);
        System.out.println(d1.toString()); //2024-03-20
        System.out.println(d1.getTime()); //1710915097018
    }

    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期 to 字符串
        Date d1 = new Date();
        String format = sdf.format(d1);
        System.out.println(format);

        //解析：字符串 to 日期
        Date d2 = sdf.parse("2024/3/20 下午2:26");
        System.out.println(d2);
    }

    @Test
    public void test4() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = new Date();

        String format = sdf.format(d1);
        System.out.println(format); //2024-03-20 14:42:33

        Date d2 = sdf.parse("2024-03-20 14:42:33");
        System.out.println(d2);
    }

    @Test
    public void test5() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        //get(int field)
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        //set(int field, xx)
        calendar.set(Calendar.DAY_OF_MONTH, 16);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //add(int field, xx)
        calendar.add(Calendar.DAY_OF_MONTH, 4);
        calendar.add(Calendar.DAY_OF_MONTH, -6);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime()：Calendar to Date
        Date d1 = calendar.getTime();
        System.out.println(d1);

        //setTime()：使用指定Date重置Calendar
        Date d2 = new Date();
        calendar.setTime(d2);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void test6() {
        Date d1 = new Date();
        //错误的
//        java.sql.Date d2 = (java.sql.Date) d1; //ClassCastException
//        System.out.println(d2);

        //正确的
        java.sql.Date d2 = new java.sql.Date(d1.getTime());
        System.out.println(d2);
    }

    @Test
    public void test7() {
        //now()：获取当前日期和时间对应的实例
        LocalDate ld1 = LocalDate.now();
        LocalTime lt1 = LocalTime.now();
        LocalDateTime ldt1 = LocalDateTime.now();

        System.out.println(ld1); //2024-03-20
        System.out.println(lt1); //15:25:24.767729700
        System.out.println(ldt1); //2024-03-20T15:25:24.767729700

        //of()：获取指定的日期、时间对应的实例
        LocalDate ld2 = LocalDate.of(2024, 3, 20);
        LocalDateTime ldt2 = LocalDateTime.of(2024, 3, 20, 15, 25, 24);

        System.out.println(ld2);
        System.out.println(ldt2);
    }

    @Test
    public void test8() {
        Instant ins1 = Instant.now();
        System.out.println(ins1);

        OffsetDateTime odt1 = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt1);

        Instant ins2 = Instant.ofEpochMilli(213122200L);
        System.out.println(ins2);

        long milliTime = ins1.toEpochMilli();
        System.out.println(milliTime);
    }

    @Test
    public void test9() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //格式化：日期、时间 to 字符串
        LocalDateTime ldt1 = LocalDateTime.now();
        String s1 = dtf.format(ldt1);
        System.out.println(s1);

        //解析：字符串 to 日期、时间
        TemporalAccessor ta = dtf.parse("2024-03-20 15:48:37");
        LocalDateTime ldt2 = LocalDateTime.from(ta);
        System.out.println(ldt2);
    }
}
