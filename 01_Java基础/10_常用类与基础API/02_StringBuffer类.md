# 02_StringBuffer类和StringBuilder类

`String`：不可变字符序列。

`StringBuffer`：可变字符序列 (jdk1.0，线程安全，效率低)。

`StringBuilder`：可变字符序列 (jdk5.0，线程不安全，效率高)。

## 可变性分析 (源码)

回顾`String`：

```java
String s1 = new String(); //char[] value = new char[0];

String s2 = new String("abc"); //char[] value = new char[]{'a', 'b', 'c'};
```

针对`StringBuilder`，内部属性有：

```java
    /**
     * The value is used for character storage.
     */
    byte[] value;

    /**
     * The id of the encoding used to encode the bytes in {@code value}.
     */
    byte coder;

    /**
     * The count is the number of characters used.
     */
    int count;
```

```java
    /**
     * Constructs a string builder with no characters in it and an
     * initial capacity of 16 characters.
     */
    @IntrinsicCandidate
    public StringBuilder() {
        super(16);
    }
```

```java
StringBuilder sbd1 = new StringBuilder(); //char[] value = new cahr[16];

StringBuilder sbd2 = new StringBuilder("abc"); //char[] value = new cahr[16 + "abc".length];

sbd1.append("ab"); //value[0] = 'a'; value[1] = 'b';
sbd1.append("ab"); //value[1] = 'v';
//不断地添加，一旦count超过value.lenght就需要扩容，默认扩容为原来的2倍+2，并将原来的内容复制到新的数组中。
```

如果开发中需要频繁的针对字符串进行增删改等操作，建议使用`StringBuffer`或`StringBuilder`提高效率。

如果开发中不涉及线程安全问题，建议使用`StringBuilder`提高效率。

如果开发中大致确定需要操作的字符个数，建议使用带`int capacity`参数的构造器，避免多次扩容操作提高效率。

## 方法

`append(xx)`

`delete(int start, int end)`

`deleteCharAt(int index)`

`replace(int start, int end, String str)`

`setCharAt(int index, char ch)`

`charAt(int index)`

`insert(int offset, xx)`

`length()`

`reverse()`

```java
@Test
public void test1() {
    StringBuilder sbd1 = new StringBuilder();
    sbd1.append("1").append("2").append("3");
    System.out.println(sbd1);

    sbd1.insert(2, "4");
    sbd1.insert(2, "false");
    System.out.println(sbd1);

    StringBuilder sbd2 = sbd1.reverse();
    System.out.println(sbd1);
    System.out.println(sbd1 == sbd2);

    System.out.println(sbd1.length()); //实际存储字符的个数

    sbd1.setLength(3);
    System.out.println(sbd1);

    StringBuffer sbf1 = new StringBuffer();
    sbf1.append("1").append("2").append("3");
    System.out.println(sbf1);

    sbf1.insert(2, "4");
    sbf1.insert(2, "false");
    System.out.println(sbf1);

    StringBuffer sbf2 = sbf1.reverse();
    System.out.println(sbf1);
    System.out.println(sbf1 == sbf2);

    System.out.println(sbf1.length()); //实际存储字符的个数

    sbf1.setLength(3);
    System.out.println(sbf1);
}
```

## 效率排序

`StringBuilder`>`StringBuffer`>`String`。

```java
@Test
public void test2() {
    long startTime = 0L;
    long endTime = 0L;
    String str = "";

    StringBuilder sbd = new StringBuilder("");
    StringBuffer sbf = new StringBuffer("");

    startTime = System.currentTimeMillis();
    for (int i = 0; i < 20000; i++) {
        sbd.append(String.valueOf(i));
    }
    endTime = System.currentTimeMillis();
    System.out.println("StringBuilder执行时间：" + (endTime - startTime)); //2

    startTime = System.currentTimeMillis();
    for (int i = 0; i < 20000; i++) {
        sbf.append(String.valueOf(i));
    }
    endTime = System.currentTimeMillis();
    System.out.println("StringBuffer执行时间：" + (endTime - startTime)); //4

    startTime = System.currentTimeMillis();
    for (int i = 0; i < 20000; i++) {
        str += i;
    }
    endTime = System.currentTimeMillis();
    System.out.println("String执行时间：" + (endTime - startTime)); //250
}
```

