# 03_日期时间API

## jdk8之前

`System`类的`currentTimeMillis()`方法：获取当前时间与1970年1月1日0时0分0秒之间的毫秒数，`long`类型，时间戳，常用来计算时间差。

两个`Date`类：

`java.util.Date`：

- 构造器：`public Date()`、`public Date(long date)`

- 方法：`toString()`、`long getTime()`

```java
import java.util.Date;
@Test
public void test1() {
    Date d1 = new Date(); //创建一个基于当前系统时间的Date实例
    System.out.println(d1.toString());
    System.out.println("对应毫秒数为：" + d1.getTime()); //1710915097018

    Date d2 = new Date(1710915097018L); // 创建一个基于指定时间戳的Date实例
    System.out.println(d2.toString()); //Wed Mar 20 14:11:37 CST 2024
}
```

- `java.sql.Date`：对应数据库中的`date`类型。

```java
@Test
public void test2() {
    java.sql.Date d1 = new java.sql.Date(1710915097018L);
    System.out.println(d1.toString()); //2024-03-20
    System.out.println(d1.getTime()); //1710915097018
}
```

`java.text.SimpleDateFormat`类是一个不与语言环境有关的方式来格式化和解析日期的具体类。

- 格式化：日期 to 字符串
- 解析：字符串 to 日期

![image-20240320143807597](https://cdn.jsdelivr.net/gh/ZL85/ImageBed@main/202403201444303.png)

```java
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
```

`java.util.Calendar`抽象类

- 实例化：由于`Calendar`是一个抽象类，所以我们需要创建其子类实例，可以通过`Calendar`的静态方法`getInstance()`获取。
- 常用方法：`get(int field)`、`set(int field, xx)`、`add(int field, xx)`、`getTime()`、`setTime()`

```java
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
```

将`java.util.Date`的实例转换为`java.sql.Date`的实例：

```java
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
```

## jdk8及之后

本地日期时间：`LocalDate`、`LocalTime`、`LocalDateTime` (类似`Calendar`)。

- 实例化：`now()`、`of(xx, xx, xx)`。
- 方法：`get()`、`withXx()`、`plusXx()`、`minusXx()`...

```java
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
```

瞬时：`Instant` (类似`Date`)。

- 实例化：`now()`、`ofEpochMilli(xx, xx, xx)`。
- 方法：`toEpochMilli()`。

```java
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
```

`DateTimeFormatter` (类似`SimpleDateFormat`)：用于格式化解析`LocalDate`、`LocalTime`、`LocalDateTime`。

```java
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
```

