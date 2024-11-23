# 02_lambda表达式

`lambda`表达式作为接口的实现类的对象，也可叫做匿名函数。

```java
import com.sun.source.doctree.StartElementTree;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {
    @Test
    public void test1() {
        //1. 无参数，无返回值
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda!");
            }
        };
        r1.run();

        System.out.println("-".repeat(100));

        //Lambda写法
        Runnable r2 = () -> System.out.println("Hello Lambda!");
        r2.run();
    }

    @Test
    public void test2() {
        //2. 有一个参数，无返回值
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(com1.compare(12, 21));

        System.out.println("-".repeat(100));

        //Lambda写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(12, 21));
                
        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        System.out.println(com3.compare(12, 21));
    }

    @Test
    public void test3() {
        //3. 有两个以上的参数，有返回值，并且Lambda体中有多条语句
        Comparator<Integer> com1 = (o1, o2) -> {
            System.out.println("函数式接口");
            return Integer.compare(o1, o2);
        };
        System.out.println(com1.compare(12, 21));
    }

    @Test
    public void test4() {
        //4. Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即“类型推断”
        Comparator<Integer> com1 = (Integer o1, Integer o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(12, 21));

        System.out.println("-".repeat(100));

        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(12, 21));
    }

    @Test
    public void test5() {
        //5. Lambda表达式若只需要一个参数时，参数的小括号可以省略
        Consumer<String> con1 = (x) -> System.out.println(x);
        con1.accept("Hello Lambda!");

        System.out.println("-".repeat(100));

        Consumer<String> con2 = x -> System.out.println(x);
        con2.accept("Hello Lambda!");
    }

    @Test
    public void test6() {
        //6. Lambda表达式的方法体如果只有一条语句，return和大括号都可以省略
        Comparator<Integer> com1 = (o1, o2) -> {
            return Integer.compare(o1, o2);
        };
        System.out.println(com1.compare(12, 21));

        System.out.println("-".repeat(100));

        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(12, 21));
    }
}
```

