# 04_throw关键字

为什么要手动抛出异常类的对象？

在实际开发中，如果出现不满足具体场景的代码问题，我们就有必要手动抛出一个指定类型的异常对象。

```java
public class Throw {
    public static void main(String[] args) {
        Student s1 = new Student();

        try {
            s1.register1(10);
            s1.register1(-10);
            System.out.println(s1);
        } catch (RuntimeException e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());
        }

        try {
            s1.register2(10);
            s1.register2(-10);
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student {
    int id;

    public void register1(int id) {
        if (id > 0) {
            this.id = id;
        } else {
//            System.out.println("输入的id非法");
            //手动抛出异常类的对象
            throw new RuntimeException("输入的id非法1");
        }
    }

    public void register2(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
//            System.out.println("输入的id非法");
            //手动抛出异常类的对象
//            throw new RuntimeException("输入的id非法");
            throw new Exception("输入的id非法2");
//            System.out.println("此语句不能被执行");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
```

