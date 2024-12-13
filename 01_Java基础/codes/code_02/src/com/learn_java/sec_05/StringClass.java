package com.learn_java.sec_05;
/*
Java中由双引号（" "）包围的都是字符串
声明字符串变量必须经过初始化才能使用
*/
public class StringClass {
    public static void main(String[] args) {
        //字符串的定义
        String str = "Hello Java!";
        System.out.println(str);

        //字符串的拼接
        String str1 = "Hello";
        String str2 = "Java";
        String str3 = str1 + " " + str2 + "!";
        System.out.println(str3);

        //字符串的比较
        String str4 = "Hello Java!";
        System.out.println(str == str4);
        System.out.println(str.equals(str4));

        //字符串的长度
        System.out.println(str.length());

        //字符串的截取
        System.out.println(str.substring(6));
        System.out.println(str.substring(0, 5));

        //字符串的查找
        System.out.println(str.indexOf("Java"));
        System.out.println(str.indexOf("Python"));

        //字符串的替换
        System.out.println(str.replace("Java", "Python"));

        //字符串的分割
        String str5 = "Hello,Java,Python";
        String[] str6 = str5.split(",");
        for (String s : str6) {
            System.out.println(s);
        }

        //字符串的大小写转换
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());

        //字符串的去空格
        String str7 = " Hello Java! ";
        System.out.println(str7.trim());

        //字符串的比较(忽略大小写)
        String str8 = "Hello Java!";
        String str9 = "hello java!";
        System.out.println(str8.equalsIgnoreCase(str9));

        //字符串的格式化
        String str10 = "Hello %s! I am %d years old. I am %.2f meters tall.";
        System.out.println(String.format(str10, "Java", 18, 1.75));

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

        //格式化常见的日期时间组合
        //%tF    “年-月-日”格式（4位年份）
        //%tD    “月/日/年”格式（2位年份）
        //%tc    全部日期和时间信息
        //%tr    “时:分:秒 PM （AM）”格式（12时制）
        //%tT    “时:分:秒”格式（24时制）
        //%tR    “时:分”格式（24时制）

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
        //%%        字面值%

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
    }
}
