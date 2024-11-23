# 10_JavaBean

JavaBean是一种Java语言写成的可重用组件，是指符合以下标准的Java类：

- 类是公共的。
- 有一个无参的公共的构造器。
- 有属性，且有对应的getter、setter方法。

```java
public class Customer {
    private String firstName;  //名
    private String lastName;  //姓

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
```