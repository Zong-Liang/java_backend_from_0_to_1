# 06_var关键字

有些时候，类型的名字太长，写起来比较麻烦。

```java
StringBuilder sb = new StringBuilder();
```

这个时候，如果想省略变量类型，可以使用`var`关键字。

```java
var sb = new StringBuilder();
```

编译器会根据赋值语句自动推断出变量`sb`的类型是`StringBuilder`。因此，使用`var`定义变量，仅仅是少写了变量类型而已。