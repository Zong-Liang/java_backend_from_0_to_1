# 01_String类

## 类的声明

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence
```

- `final`：`String`不可被继承。
- `Serializable`：可序列化的接口，凡是实现此接口的类的对象就可以通过网络或本地流进行数据的传输。
- `Comparable<String>`：凡是实现此接口的类，其对象都可以比较大小。

## 内部属性

```java
// jdk8中
private final char value[];

// jdk9开始，为了节省内存空间修改为下面的
private final byte[] value;
```

## 字符串常量存储位置

字符串常量都存储在字符串常量池 (`StringTable`) 中。

字符串常量池不允许存放两个相同的字符串常量。

```java
@Test
public void test1() {
    String s1 = "hello";
    String s2 = "hello";

    System.out.println(s1 == s2);
}
```

字符串常量池在不同 jdk 版本中存放位置不同，jdk7之前存放在方法区，jdk7及之后存放在堆空间。

## `String`的不可变性

当对字符串变量重新赋值时，需要重新指定一个字符串常量的位置进行赋值，不能在原有的位置修改。

```java
@Test
public void test2() {
    String s1 = "hello";
    String s2 = "hello";

    s2 = "hi";

    System.out.println(s1); //hello
}
```

当对现有的字符串进行拼接操作时，需要重新开辟空间保存拼接以后的字符串，不能在原有的位置修改。

```java
@Test
public void test3() {
    String s1 = "hello";
    String s2 = "hello";

    s2 += " world";

    System.out.println(s1); //hello
    System.out.println(s2); //hello world
}
```

当调用字符串的`replace()`方法时，仍需要重新开辟空间保存修改以后的字符串，不能在原有的位置修改。

```java
@Test
public void test4() {
    String s1 = "hello";
    String s2 = "hello";

    String s3 = s2.replace('l', 'w');

    System.out.println(s1); //hello
    System.out.println(s2); //hello
    System.out.println(s3); //hewwo
}
```

## `String`实例化的两种方式

```java
String s1 = "hello";
```

```java
String s2 = new String("hello");
//在内存中创建两个对象，一个是堆空间中new的对象，另一个是在字符串常量池中生成的字面量。
```

```java
@Test
public void test5() {
    String s1 = "hello";
    String s2 = "hello";

    String s3 = new String("hello");
    String s4 = new String("hello");

    System.out.println(s1 == s2); //true
    System.out.println(s1 == s3); //false
    System.out.println(s3 == s4); //false

    System.out.println(s3.equals(s1)); //true
}
```

```java
    @Test
    public void test6() {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.name = "Tom";
        p2.name = "Tom";

        p1.name = "jerry";

        System.out.println(p1.name);
        System.out.println(p2.name);

    }

class Person {
    String name;
}

```

## 字符串连接操作

+

`intern()`

`concat()`

```java
@Test
public void test7() {
    String s1 = "hello";
    String s2 = "world";

    String s3 = "helloworld";
    String s4 = "hello" + "world";
    String s5 = s1 + "world";
    String s6 = "hello" + s2;
    String s7 = s1 + s2;

    System.out.println(s3 == s4); //true
    System.out.println(s3 == s5); //false
    System.out.println(s3 == s6); //false
    System.out.println(s3 == s7); //false
    System.out.println(s5 == s6); //false
    System.out.println(s5 == s7); //false

    String s8 = s5.intern(); //intern()方法返回字符串常量池中字面量的地址
    System.out.println(s3 == s8);
}
```

```java
@Test
public void test8() {
    final String s1 = "hello";
    final String s2 = "world";

    String s3 = "helloworld";
    String s4 = "hello" + "world";
    String s5 = s1 + "world"; //通过查看字节码文件发现调用了StringBuilder的toString()方法
    String s6 = "hello" + s2;
    String s7 = s1 + s2;

    System.out.println(s3 == s4); //true
    System.out.println(s3 == s5); //true
    System.out.println(s3 == s6); //true
    System.out.println(s3 == s7); //true
}
```

```java
@Test
public void test9() {
    String s1 = "hello";
    String s2 = "world";

    String s3 = s1.concat(s2);
    String s4 = "hello".concat("world");
    String s5 = s1.concat("world");
    String s6 = "hello".concat(s2);

    System.out.println(s3 == s4); //false
    System.out.println(s3 == s5); //false
    System.out.println(s4 == s5); //false
}
```

## 构造器

`public String()`：

`public String(String original)`：

`public String(char[] value)`：

`public String(char[] value, int offset, int count)`：

`public String(byte[] bytes)`：

`public String(byte[] bytes, String charsetName)`：

```java
@Test
public void test10() {
    String s1 = new String();
    String s2 = new String("");
    String s3 = new String(new char[]{'a', 'b', 'c'});
    System.out.println(s3);
}
```

在UTF-8字符集中，一个汉字占用3个字节，一个字母占用1个字节。

在GBK字符集中，一个汉字占用2个字节，一个字母占用1个字节。

UTF-8和GBK都向下兼容ASCII码。

编码字符集和解码字符集需要一致，否则会乱码。

```java
@Test
public void test11() throws UnsupportedEncodingException {
    int num = 10;
    //复习：基本数据类型、包装类 to String
    String s1 = num + "";
    String s2 = String.valueOf(num);
    //复习：String to 基本数据类型、包装类
    String s3 = "123";
    int i1 = Integer.parseInt(s3);

    //String to char[]，调用String的toCharArray()方法
    String s4 = "hello";
    char[] c_arr = s4.toCharArray();
    for (char c : c_arr) {
        System.out.println(c);
    }
    //char[] to String
    String s5 = new String(c_arr);
    System.out.println(s5);

    //String to byte[]，调用String的getBytes()方法
    String s6 = "abc中国";
    byte[] b_arr = s6.getBytes(); //使用默认字符集
    for (byte b : b_arr) {
        System.out.println(b);
    }
    String s8 = "ABC中国";
    byte[] b_arr1 = s8.getBytes("GBK"); //使用默认字符集
    for (byte b : b_arr1) {
        System.out.println(b);
    }
    //byte[] to String
    String s7 = new String(b_arr);
    System.out.println(s7);
    String s9 = new String(b_arr1, "GBK");
    System.out.println(s9);
}
```

## 方法

`isEmpty()`

`length()`

`concat(String str)`

`equals(Object anObject)`

`equalsIgnoreCase(String anotherString)`

`compareTo(String anotherString)`

`compareToIgnoreCase(String str)`

`toLowerCase()`

`toUpperCase()`

`trim()`

`intern()`

`contains(CharSequence s)`

`indexOf(int ch)`

`indexOf(String str, int fromIndex)`

`lastIndexOf(int ch)`

`lastIndexOf(String str, int fromIndex)`

`substring(int beginIndex)`

`substring(int beginIndex, int endIndex)`

`charAt(int index)`

`toCharArray()`

`valueOf(char c)`

`valueOf(char[] data, int offset, int count)`

`copyValueOf(char[] data)`

`copyValueOf(char[] data, int offset, int count)`

`startsWith(String prefix)`

`startsWith(String prefix, int toffset)`

`endsWith(String suffix)`

`replace(char oldChar, char newChar)`

`replace(CharSequence target, CharSequence replacement)`

`replaceAll(String regex, String replacement)`

`replaceFirst(String regex, String replacement)`

```java
@Test
public void test12() {
    String s1 = "";
    String s2 = new String();
    String s3 = new String("");

    System.out.println(s1.isEmpty());
    System.out.println(s2.isEmpty());
    System.out.println(s3.isEmpty());

    //        String s4 = null;
    //        System.out.println(s4.isEmpty()); //NullPointerException

    String s5 = "hello";
    System.out.println(s5.length());

    String s6 = " world";
    String s7 = s5.concat(s6);
    System.out.println(s7);

    String s8 = "Hello";
    System.out.println(s5.equals(s8));
    System.out.println(s5.equalsIgnoreCase(s8));

    System.out.println(s5.compareTo(s8)); //正数，调用方法的String大
    System.out.println(s5.compareToIgnoreCase(s8));//0，两个String一样大

    String s9 = "AhU";
    System.out.println(s9.toLowerCase());
    System.out.println(s9.toUpperCase());

    String s10 = "   Ah U   ";
    System.out.println(s10.trim()); //除去字符串前后的空格

    String s11 = "helloolleh";
    System.out.println(s11.contains("e"));
    System.out.println(s11.indexOf("ll"));
    System.out.println(s11.indexOf("A")); //没有返回-1
    System.out.println(s11.indexOf("ll", 3));
    System.out.println(s11.lastIndexOf("ll"));
    System.out.println(s11.lastIndexOf("ll", 3));

    System.out.println(s11.substring(5));
    System.out.println(s11.substring(0, 5));

    String s12 = "AHU";
    System.out.println(s12.charAt(1));

    String s13 = String.valueOf(new char[]{'a', 'b', 'c'});
    String s14 = String.copyValueOf(new char[]{'a', 'b', 'c'});
    System.out.println(s13);
    System.out.println(s14);
    System.out.println(s13 == s14);

    System.out.println(s12.startsWith("A"));
    System.out.println(s12.startsWith("H", 1));
    System.out.println(s12.endsWith("U"));

    String s15 = "hhh";
    String s16 = s15.replace("h", "wu");
    System.out.println(s16);
}
```

