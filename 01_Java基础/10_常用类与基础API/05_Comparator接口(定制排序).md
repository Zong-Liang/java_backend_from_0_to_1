# 05_Comparator接口 (定制排序)

场景：

- 当元素的类型没有实现`java.lang.Comparable`接口而又不方便修改代码 (例如：一些第三方的类，你只有.class文件，没有源文件)。
- 如果一个类，实现了`comparable`接口，也指定了两个对象的比较大小的规则，但是此时此刻我不想按照它预定义的方法比较大小，但是我又不能随意修改，因为会影响其他地方的使用，怎么办?

JDK 在设计类库之初，也考虑到这种情况，所以又增加了一个`java.util.comparator`接口。强行对多个对象进行整体排序的比较。

- 重写`compare(object o1,0bject o2)`方法，比较`o1`和`o2`的大小，如果方法返正整数，则表示`o1`大于`o2`；如果返回0，表示相等；返回负整数，表示`o1`小于`o2`。
- 可以将`Comparator`传递给`sort()`方法 (如`Collections.sort()`或`Arrays.sort()`) ，从而允许在排序顺序上实现精确控制。

步骤：

- 创建一个实现`Comparator`接口的实现类`A`。

- 重写`Comparator`接口中的`compare(Object o1, Object o2)`方法，在此方法中指明如何判断需要比较的类的大小。

- 创建此实现类`A`的对象，并将此对象传入到相关方法的参数位置即可。

```java
package learnjava_10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class UseComparator {
    @Test
    public void test1() {
        Phone[] p_arr = new Phone[5];
        p_arr[0] = new Phone("Haiwei", 6299);
        p_arr[1] = new Phone("Xiaomi", 4999);
        p_arr[2] = new Phone("Vivo", 5999);
        p_arr[3] = new Phone("Iphone", 9999);
        p_arr[4] = new Phone("Honor", 6299);

        Comparator comparator1 = new Comparator() {
            //在此方法中指明如何判断需要比较的类的大小
            //按照价格排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Phone && o2 instanceof Phone) {
                    Phone p1 = (Phone) o1;
                    Phone p2 = (Phone) o2;

                    return Double.compare(p1.getPrice(), p2.getPrice());

                } else {
                    throw new RuntimeException();
                }
            }
        };

        Comparator comparator2 = new Comparator() {
            //在此方法中指明如何判断当前类的大小。
            //按照名称排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Phone && o2 instanceof Phone) {
                    Phone p1 = (Phone) o1;
                    Phone p2 = (Phone) o2;

                    return p1.getName().compareTo(p2.getName());

                } else {
                    throw new RuntimeException();
                }
            }
        };

//        Arrays.sort(p_arr, comparator1);
        Arrays.sort(p_arr, comparator2);

        for (Phone p : p_arr) {
            System.out.println(p);
        }
    }

    @Test
    public void test2() {
        String[] s_arr = new String[]{"Tom", "Jerry", "Jack", "Rose"};

        //降序
        Arrays.sort(s_arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;

                    return -s1.compareTo(s2);
                } else {
                    throw new RuntimeException();
                }
            }
        });

        //排序后遍历
        for (String s : s_arr) {
            System.out.println(s);
        }
    }
}
```

