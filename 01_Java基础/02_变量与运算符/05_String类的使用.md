# 05_String类的使用

除了基本类型的变量，剩下的都是引用类型。

引用类型最常用的就是`String`字符串，使用双引号`"`。

```java
String str = "hello";
```

> 引用类型的变量类似于C语言的指针，它内部存储一个“地址”，指向某个对象在内存的位置。

Java中由双引号（" "）包围的都是字符串，声明字符串变量必须经过初始化才能使用。

```java
import java.util.Date;


public class StringClass {
    public static void main(String[] args) {
        //String(char a[])
        //用一个字符数组a创建String对象
        char[] a = {'H','E','L','L','O'};
        java.lang.String s = new java.lang.String(a);
        System.out.println(s);
        //等价于String s = new String("HELLO");

        //String(char a[], int offset, int length)
        //提取字符数组a中的一部分创建一个字符串对象
        //数offset表示开始截取字符串的位置
        //length表示截取字符串的长度
        char[] a1 = {'H','E','L','L','O'};
        java.lang.String s1 = new java.lang.String(a1,2,3);
        System.out.println(s1);
        //等价于String s1 = new String("LLO");

        //String(char[] value)
        //分配一个新的String对象，使其表示字符数组参数中所有元素连接的结果
        char[] a2 = {'W','O','R','L','D'};
        java.lang.String s2 = new java.lang.String(a2);
        System.out.println(s2);
        //等价于String s2 = new String("HELLO");

        //引用字符串常量来创建字符串变量
        java.lang.String str1,str2;
        str1 = "HELLO";
        str2 = "WORLD";
        System.out.println(str1);
        System.out.println(str2);

        //“+”运算符连接多个字符串并产生一个String对象
        System.out.println(str1+str2);

        //字符串同其他基本数据类型进行连接会将这些数据直接转换成字符串
        int read = 2;
        float practice = 2.5F;
        //将字符串与整型、浮点型变量相连
        //read和practice与字符串相连时会自动调用toString()方法，换成字符串形式参与连接
        System.out.println("I spend "+read+" hours reading books and "+practice+" hours praticing oral English a day.");

        //获取字符串长度
        //str.length();
        System.out.println("str1的长度是"+str1.length());

        //字符串查找
        //indexOf(String s)用于返回参数字符串s在指定字符串中首次出现的索引位置
        //str.indexOf(substr)
        //str：任意字符串对象
        //substr：要搜索的字符串
        java.lang.String str3 = "HELLO WORLD";
        int pos = str3.indexOf(str1);
        System.out.println("str1在str3中的位置索引是"+pos);

        //lastIndexOf(String str)用于返回指定字符串最后一次出现的索引位置
        //str. lastIndexOf(substr)
        //str：任意字符串对象
        //substr：要搜索的字符串
        //如果lastIndexOf()方法中的参数是空字符串""，则返回的结果与调用该字符串length()方法的返回结果相同
        int len = str3.lastIndexOf("");
        System.out.println("空字符串在str3中的位置索引是"+len);
        System.out.println("str3的长度是"+str3.length());

        //获取指定索引位置的字符
        //str.charAt(int index)
        //str：任意字符串
        //index：整型值，用于指定要返回字符的下标
        System.out.println("str3中第5个字符是"+str3.charAt(4));

        //获取子字符串
        //substring(int beginIndex)返回的是从指定的索引位置开始截取直到该字符串结尾的子串
        //str.substring(int beginIndex)
        //beginIndex指定从某一索引处开始截取字符串
        System.out.println("从第4个字符开始截取str3得到的子串是"+ str3.substring(3));

        //substring(int beginIndex, int endIndex)返回的是从字符串某一索引位置开始截取至某一索引位置结束的子串
        //str.substring(int beginIndex, int endIndex)
        //beginIndex：开始截取子字符串的索引位置
        //endIndex：子字符串在整个字符串中的结束位置
        System.out.println("截取str3第4个字符到第8个字符得到的子串是"+ str3.substring(3,8));

        //去除空格
        //trim()方法返回字符串的副本，忽略前导空格和尾部空格
        //str.trim()
        //str为任意字符串对象
        java.lang.String str4 = "  hh  ";
        System.out.println("str4: "+str4);
        System.out.println("去除前后空格的str4得到的字符串副本为："+str4.trim());

        //字符串替换
        //replace()方法可实现将指定的字符或字符串替换成新的字符或字符串
        //str.replace(char oldChar,char newChar)
        //oldChar：要替换的字符或字符串
        //newChar：用于替换原来字符串的内容
        System.out.println("str4中的h替换为H后得到的字符串为："+str4.replace('h','H'));

        //判断字符串的开始与结尾
        //startsWith()用于判断当前字符串对象的前缀是否为参数指定的字符串
        //str.startsWith(String prefix)
        //prefix是指作为前缀的字符
        System.out.println("str3是以HELLO开始的吗？"+str3.startsWith("HELLO"));

        //endsWith()用于判断当前字符串是否为以给定的子字符串结束
        //str.endsWith(String suffix)
        //suffix是指作为后缀的字符串
        System.out.println("str3是以WORLD结束的吗？"+str3.endsWith("WORLD"));

        //判断字符串是否相等
        //对字符串对象进行比较不能简单地使用比较运算符“==”，因为比较运算符比较的是两个字符串的地址是否相同
        //即使两个字符串的内容相同，两个对象的内存地址也是不同的，使用比较运算符仍然会返回false
        java.lang.String str5 = new java.lang.String("yep");
        java.lang.String str6 = new java.lang.String("yep");
        System.out.println("str5和str6相等吗？"+(str5==str6));

        //equals()
        //如果两个字符串具有相同的字符和长度，则使用equals()方法进行比较时，返回true
        //使用equals()方法对字符串进行比较时是区分大小写的，
        //str.equals(String otherstr)
        //str、otherstr是要比较的两个字符串对象
        java.lang.String str7 = new java.lang.String("Nope");
        java.lang.String str8 = new java.lang.String("nope");
        System.out.println("str7和str8相等吗？"+str7.equals(str8));
        //equalsIgnoreCase()
        //而使用equalsIgnoreCase()方法是在忽略了大小写的情况下比较两个字符串是否相等，返回结果仍为boolean类型
        //str.equalsIgnoreCase(String otherstr)
        //str、otherstr是要比较的两个字符串对象
        System.out.println("str7和str8相等吗（忽略大小写）？"+str7.equalsIgnoreCase(str8));

        //按字典顺序比较两个字符串
        //compareTo()方法为按字典顺序比较两个字符串，该比较基于字符串中各个字符的Unicode值，
        //按字典顺序将此String对象表示的字符序列与参数字符串所表示的字符序列进行比较。
        //如果按字典顺序此String对象位于参数字符串之前，则比较结果为一个负整数
        //如果按字典顺序此String对象位于参数字符串之后，则比较结果为一个正整数
        //如果这两个字符串相等，则结果为0
        //compareTo()方法只有在equals(Object)方法返回true时才返回0
        //str.compareTo(String otherstr)
        //str、otherstr是要比较的两个字符串对象
        java.lang.String str9 = "a";
        java.lang.String str10 = "b";
        java.lang.String str11 = "c";
        System.out.println("按字典顺序比较str10和str9："+str10.compareTo(str9));
        System.out.println("按字典顺序比较str10和str11："+str10.compareTo(str11));
        //str.compareToIgnoreCase()按字典顺序比较两个字符串（忽略大小写）
        System.out.println("按字典顺序比较str7和str8（忽略大小写）"+str7.compareToIgnoreCase(str8));

        //字母大小写转换
        //使用toLowerCase()方法和toUpperCase()方法进行大小写转换时，数字或非字符不受影响
        //toLowerCase()将String转换为小写
        //str.toLowerCase()
        //str是要进行转换的字符串
        System.out.println("将str1转为小写："+str1.toLowerCase());

        //toUpperCase()将String转换为大写
        //str.toUpperCase()
        //str是要进行转换的字符串
        System.out.println("将str9转为大写："+str9.toUpperCase());

        //字符串分割
        //split()可以使字符串按指定的分割字符或字符串对内容进行分割，并将分割后的结果存放在字符串数组中
        //split(String sign)可根据给定的分割符对字符串进行拆分
        //str.split(String sign)
        //sign为分割字符串的分割符，也可以使用正则表达式
        //没有统一的对字符进行分割的符号。如果想定义多个分割符，可使用符号“|”。例如，“,|=”表示分割符分别为“,”和“=”。
        java.lang.String str12 = "It's a nice day today!";
        java.lang.String[] arr = str12.split(" ");
        System.out.printf("将str12按照空格进行分割得到的结果是：");
        for (java.lang.String i:arr) {
            System.out.printf("["+i+"]");
        }

        System.out.println();
        //split(String sign,int limit)可根据给定的分割符对字符串进行拆分，并限定拆分的次数。
        //str.split(String sign,int limit)
        //sign：分割字符串的分割符，也可以使用正则表达式
        //limit：限制的分割次数
        java.lang.String[] arr1 = str12.split(" ",3);
        System.out.printf("将str12按照空格进行三次分割得到的结果是：");
        for (java.lang.String i:arr1) {
            System.out.printf("["+i+"]");
        }

        //格式化字符串
        //String类的静态format()方法用于创建格式化的字符串
        //format(String format,Object…args)使用指定的格式字符串和参数返回一个格式化字符串，新字符串使用本地默认的语言环境
        //str.format(String format,Object…args)
        //format：格式字符串
        //args：格式字符串中由格式说明符引用的参数。如果还有格式说明符以外的参数，则忽略这些额外的参数。此参数的数目是可变的，可以为0

        //format(Local l,String format,Object…args)
        //l：格式化过程中要应用的语言环境。如果l为null，则不进行本地化。
        //format：格式字符串
        //args：格式字符串中由格式说明符引用的参数。如果还有格式说明符以外的参数，则忽略这些额外的参数。此参数的数目是可变的，可以为0

        //日期和时间字符串格式化
        //日期格式化
        //%te    一个月中的某一天
        //%tb    指定语言环境的月份简称
        //%tB    指定语言环境的月份全称
        //%tA    指定语言环境的星期几全称
        //%ta    指定语言环境的星期几简称
        //%tc    包括全部日期和时间信息
        //%tY    4位年份
        //%tj    一年中的第几天（001~366）
        //%tm    月份
        //%td    一个月中的第几天（01~31）
        //%ty    2位年份

        System.out.println();
        //返回一个月中的天数
        Date date = new Date();
        java.lang.String str13 = java.lang.String.format("%te",date);
        System.out.println("当前日期中的天数是："+str13);
        java.lang.String year = java.lang.String.format("%tY",date);
        java.lang.String month = java.lang.String.format("%tm",date);
        java.lang.String day = java.lang.String.format("%td",date);
        System.out.println("现在是"+year+"年"+month+"月"+day+"号");

        //时间格式化
        //%tH    2位数字的24时制的小时（00~23）
        //%tI    2位数字的12时制的小时（00~23）
        //%tk    2位数字的24时制的小时（0~23）
        //%tl    2位数字的12时制的小时（1~12）
        //%tM    2位数字的分钟（00~59）
        //%tS    2位数字的秒数（00-60）
        //%tL    3位数字的毫秒数（000~999）
        //%tN    9位数字的微秒数（000000000~999999999）
        //%tp    指定语言环境下上午或下午标记
        //%tz    相对于GMT RFC 82格式的数字时区偏移量
        //%tZ    时区缩写形式的字符串
        //%ts    1970-01-01 00:00:00至现在经过的秒数
        //%tQ    1970-01-01 00:00:00至现在经过的毫秒数
        java.lang.String hour = java.lang.String.format("%tH",date);
        java.lang.String minute = java.lang.String.format("%tM",date);
        java.lang.String second = java.lang.String.format("%tS",date);
        System.out.println("现在是"+hour+"时"+minute+"分"+second+"秒");

        //格式化常见的日期时间组合
        //%tF    “年-月-日”格式（4位年份）
        //%tD    “月/日/年”格式（2位年份）
        //%tc    全部日期和时间信息
        //%tr    “时:分:秒 PM （AM）”格式（12时制）
        //%tT    “时:分:秒”格式（24时制）
        //%tR    “时:分”格式（24时制）
        java.lang.String time = java.lang.String.format("%tr",date);
        java.lang.String form = java.lang.String.format("%tF",date);
        System.out.println("全部时间信息是："+time);
        System.out.println("年-月-日格式："+form);

        //常规类型格式化
        //%b、%B    格式化为布尔类型
        //%h、%H    格式化为散列码
        //%s、%S    格式化为字符串类型
        //%c、%C    格式化为字符类型
        //%d        格式化为十进制整数
        //%o        格式化为八进制整数
        //%x、%X    格式化为十六进制整数
        //%e        格式化为用科学计数法形式表示的十进制数
        //%a        格式化为罗有效位数和指数的十六进制浮点值
        //%n        特定于平台的行分隔符
        //%%        字面值%'
        java.lang.String str14 = java.lang.String.format("%d",400/2);
        java.lang.String str15 = java.lang.String.format("%b",3>5);
        java.lang.String str16 = java.lang.String.format("%x",200);
        System.out.println("400/2="+str14);
        System.out.println("3>5? "+str15);
        System.out.println("200的十六进制表示是："+str16);

        //使用正则表达式
        //正则表达式通常被用于判断语句中，用来检查某一字符串是否满足某一格式
        //正则表达式是含有一些具有特殊意义字符的字符串，这些特殊字符称为正则表达式的元字符
        //元字符        正则表达式中的写法        意义
        //.             .                       代表任意一个字符
        //\d            \\d                     代表0~9的任意一个数字
        //\D            \\D                     代表任意一个非数字数字
        //\s            \\s                     代表空白字符，如'\t'、'\n'
        //\S            \\S                     代表非空白字符
        //\w            \\w                     代表可用作标识符的字符，但不包括"$"
        //\W            \\W                     代表不可用于标识符的字符
        //\p{Lower}     \\p{Lower}              代表小写字母a~z
        //\p{Upper}     \\p{Upper}              代表大写字母A~Z
        //\p{ASCII}     \\p{ASCII}              ASCII字符
        //\p{Alpha}     \\p{Alpha}              字母字符
        //\p{Digit}     \\p{Digit}              十进制数字，即0~9
        //\p{Alnum}     \\p{Alnum}              数字或字母字符
        //\p{Punct}     \\p{Punct}              标点符号
        //\p{Graph}     \\p{Graph}              可见字符
        //\p{Print}     \\p{Print}              可打印字符
        //\p{Blank}     \\p{Blank}              空格或制表符
        //\p{Cntrl}     \\p{Cntrl}              控制字符
        //在正则表达式中“.”代表任何一个字符，因此在正则表达式中如果想使用普通意义的点字符“.”，必须使用转义字符“\”。

        //在正则表达式中可以使用方括号括起若干个字符来表示一个元字符，该元字符可代表方括号中的任何一个字符。
        //例如，reg = "[abc]4"，这样字符串a4、b4、c4都是和正则表达式匹配的字符串。方括号元字符还可以为其他格式。
        //[^456]：代表4、5、6之外的任何字符。
        //[a-r]：代表a~r中的任何一个字母。
        //[a-zA-Z]：可表示任意一个英文字母。
        //[a-e[g-z]]：代表a~e或g~z中的任何一个字母（并运算）。
        //[a-o&&[def]]：代表字母d、e、f（交运算）。
        //[a-d&&[^bc]]：代表字母a、d（差运算）。

        //在正则表达式中允许使用限定修饰符来限定元字符出现的次数。
        //例如，“A*”代表A可在字符串中出现0次或多次。
        //限定修饰符        意义        示例
        //?                0次或1次     A?
        //*                0次或多次    A*
        //+                一次或多次   A+
        //{n}              正好出现n次  A{2}
        //{n,}             至少出现n次  A{3,}
        //{n,m}            出现n~m次   A{2,6}

        //实现使用正则表达式来判断指定的变量是否为合法的E-mail地址
        java.lang.String regex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
        java.lang.String str17 = "aaa@";
        java.lang.String str18 = "aaaaa";
        java.lang.String str19 = "1111@111ffyu.dfg.com";
        if (str17.matches(regex)){
            System.out.println(str17+"是一个合法的E-mail地址格式");
        } else if (str18.matches(regex)) {
            System.out.println(str18+"是一个合法的E-mail地址格式");
        } else if (str19.matches(regex)) {
            System.out.println(str19+"是一个合法的E-mail地址格式");
        }
        //通常情况下E-mail的格式为“X@X.com.cn”。
        //字符X表示任意的一个或多个字符，@为E-mail地址中的特有符号，符号@后还有一个或多个字符，之后是字符“.com”，也可能后面还有类似“.cn”的标记。
        //总结E-mail地址的这些特点，因此可以书写正则表达式“\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}”来匹配E-mail地址。
        //字符集“\\w”匹配任意字符，符号“+”表示字符可以出现1次或多次，表达式“(\\.\\w{2,3})*”表示形如“.com”格式的字符串可以出现0次或多次。
        //而最后的表达式“\\.\\w{2,3}”用于匹配E-mail地址中的结尾字符，如“.com”。

        //字符串生成器
        //创建成功的字符串对象，其长度是固定的，内容不能被改变和编译。
        //虽然使用“+”可以达到附加新字符或字符串的目的，但“+”会产生一个新的String实例，会在内存中创建新的字符串对象。
        //如果重复地对字符串进行修改，将极大地增加系统开销。

        //验证字符串操作和字符串生成器操作的效率
        java.lang.String str20 = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            str20 += i;
        }
        long endTime = System.currentTimeMillis();
        long timespent = endTime -startTime;
        System.out.println("String消耗时间："+timespent);
        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for (int j = 0; j < 10000; j++) {
            builder.append(j);
        }
        endTime = System.currentTimeMillis();
        timespent = endTime -startTime;
        System.out.println("StringBuilder消耗时间："+timespent);

        //新创建的StringBuilder对象初始容量是16个字符，可以自行指定初始长度。
        //如果附加的字符超过可容纳的长度，则StringBuilder对象将自动增加长度以容纳被附加的字符。
        //若要使用StringBuilder最后输出字符串结果，可使用toString()方法。
        //利用StringBuilder类中的方法可动态地执行添加、删除和插入等字符串的编辑操作。

        //append()方法
        //用于向字符串生成器中追加内容
        //append(content)
        //content表示要追加到字符串生成器中的内容，可以是任何类型的数据或者其他对象

        //insert(int offset, arg)方法
        //用于向字符串生成器中的指定位置插入数据内容
        //insert(int offset arg)
        //offset：字符串生成器的位置。该参数必须大于等于0，且小于等于此序列的长度
        //arg：将插入至字符串生成器的位置。该参数可以是任何的数据类型或其他对象
        StringBuilder bd = new StringBuilder("hello ");
        bd.insert(6,"world");
        System.out.println(bd.toString());

        //delete(int start , int end)方法
        //移除此序列的子字符串中的字符
        //delete(int start , int end)
        //start：将要删除的字符串的起点位置
        //end：将要删除的字符串的终点位
        bd.delete(5,7);
        System.out.println(bd);

        //toUpperCase()方法
        java.lang.String str21 = "artificial intelligence";
        System.out.println(str21.toUpperCase());

        //toLowerCase()方法
        System.out.println(str21.toUpperCase().toLowerCase());
    }
}
```

> Java的编译器对字符串做了特殊照顾，可以使用`+`连接任意字符串和其他数据类型，这样极大地方便了字符串的处理。如果用`+`连接字符串和其他数据类型，会将其他数据类型先自动转型为字符串，再连接。

Java的字符串除了是一个引用类型外，还有个重要特点，就是字符串不可变。

```java
public class Main {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(s);  // 显示 hello
        s = "world";
        System.out.println(s);  // 显示 world
    }
}
```

> 变的不是字符串，而是变量`s`的“指向”。

引用类型的变量可以指向一个空值`null`，它表示不存在，即该变量不指向任何对象。

> 注意要区分空值`null`和空字符串`""`，空字符串是一个有效的字符串对象，它不等于`null`。

在Java中，判断值类型的变量是否相等，可以使用`==`运算符。但要判断引用类型的变量内容是否相等，必须使用`equals()`方法。
