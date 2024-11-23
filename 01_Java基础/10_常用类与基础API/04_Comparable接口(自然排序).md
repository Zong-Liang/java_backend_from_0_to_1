# 04_Comparable接口 (自然排序)

步骤：

- 具体的类实现`Comparable`接口。

- 重写`Comparable`接口中的`compareTo(Object o)`方法，在此方法中指明如何判断当前类的大小。

- 创建多个类进行排序或比较大小。

```java
package learnjava_10;

import com.sun.source.doctree.StartElementTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class UseComparable {
    @Test
    public void test1() {
        String[] s_arr = new String[]{"Tom", "Jerry", "Jack", "Rose"};

        Arrays.sort(s_arr);

        //排序后遍历
        for (String s : s_arr) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() {
        Phone[] p_arr = new Phone[5];
        p_arr[0] = new Phone("Haiwei", 6299);
        p_arr[1] = new Phone("Xiaomi", 4999);
        p_arr[2] = new Phone("Vivo", 5999);
        p_arr[3] = new Phone("Iphone", 9999);
        p_arr[4] = new Phone("Honor", 6299);

        Arrays.sort(p_arr); //ClassCastException

        for (Phone p : p_arr) {
            System.out.println(p);
        }
    }

    @Test
    public void test3() {
        Phone p1 = new Phone("Haiwei", 6299);
        Phone p2 = new Phone("Honor", 6299);

        int value = p1.compareTo(p2);
//        if (value > 0) {
//            System.out.println("p1大");
//        } else if (value == 0) {
//            System.out.println("一样大");
//        } else {
//            System.out.println("p2大");
//        }
        if (value > 0) {
            System.out.println("p1小");
        } else if (value == 0) {
            System.out.println("一样大");
        } else {
            System.out.println("p2小");
        }
    }
}

class Phone implements Comparable {
    String name;
    double price;

    public Phone() {
    }

    public Phone(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //当前类需要实现Comparable接口中的抽象方法compareTo(Object o)
    //在此方法中指明如何判断当前类的大小，比如按照价格排序
//    @Override
//    public int compareTo(Object o) {
//        if (o == this) {
//            return 0;
//        } else if (o instanceof Phone) {
//            Phone p = (Phone) o;
//            return Double.compare(this.price, p.price);
//        } else {
//            throw new RuntimeException();
//        }
//    }
    //价格一样按照名称排序，从小到大
//    @Override
//    public int compareTo(Object o) {
//        if (o == this) {
//            return 0;
//        } else if (o instanceof Phone) {
//            Phone p = (Phone) o;
//            int value = Double.compare(this.price, p.price);
//            if (value != 0) {
//                return value;
//            } else {
//                return this.name.compareTo(p.name);
//            }
//        } else {
//            throw new RuntimeException();
//        }
//    }
    //从大到小
    @Override
    public int compareTo(Object o) {
        if (o == this) {
            return 0;
        } else if (o instanceof Phone) {
            Phone p = (Phone) o;
            int value = Double.compare(this.price, p.price);
            if (value != 0) {
                return -value;
            } else {
                return -this.name.compareTo(p.name);
            }
        } else {
            throw new RuntimeException();
        }
    }
}
```

