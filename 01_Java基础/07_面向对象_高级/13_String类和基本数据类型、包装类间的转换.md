# 13_String类和基本数据类型、包装类间的转换

基本数据类型、包装类 to String类：调用`String`类里重载的静态方法`valueOf()`。

String类 to 基本数据类型、包装类：调用`包装类`里的静态方法`parseXxx()`。

```java
import org.junit.jupiter.api.Test;

public class WrapperTest2 {
    // 基本数据类型、包装类 to String类
    @Test
    public void test1() {
        int i1 = 66;
        String str1 = String.valueOf(i1);
        System.out.println(str1);// "10"

        boolean b1 = true;
        Boolean b2 = b1;
        String str2 = String.valueOf(b1);
        String str3 = String.valueOf(b2);

        String str4 = i1 + "";
        String str5 = b1 + "";
    }

    // String类 to 基本数据类型、包装类
    @Test
    public void test2() {
        String str1 = "111";
        int i1 = Integer.parseInt(str1);
        System.out.println(i1 + 1);

        String str2 = "fasle";
        boolean b1 = Boolean.parseBoolean(str2);

//        String str3 = "1a";
//        int i2 = Integer.parseInt(str3);//java.lang.NumberFormatException: For input string: "1a"
    }
}
```