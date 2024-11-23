# 01_this关键字

在声明一个属性对应的setter方法时，通过形参给对应的属性赋值。如果形参和属性名同名了，应该如何区分这两个变量？

使用`this`关键字，有`this.`的是属性，没有`this.`的是形参。

`this`可以调用成员变量 (属性)、方法、构造器。

```java
public class Chinese {
    String name;
    int age;

    public Chinese() {
    }
    
    public Chinese(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

```java
public class Student {
    String name;
    int age;
    String school;
    String major;

    public Student(String n, int a) {
        name = n;
        age = a;
    }

    public Student(String n, int a, String s) {
        this(n, a);  // this(参数列表);必须放在首行，最多声明一个
        school = s;
    }

    public Student(String n, int a, String s, String m) {
        this(n, a, s);
        major = m;
    }
}
```

模拟客户在银行存钱取钱：

```java
public class Account {
    private double balance;  //余额

    public Account(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    //存钱
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("成功存入：" + amount);
        }
    }

    //取钱
    public void withdraw(double amount) {
        if (balance >= amount && amount > 0) {
            balance -= amount;
            System.out.println("成功取出：" + amount);
        } else {
            System.out.println("取款数额有误或余额不足");
        }
    }
}
```

```java
public class Customer {
    private String firstName;  //名
    private String lastName;  //姓

    private Account account;

    public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
```

```java
public class Bank {
    private Customer[] customers;  //用于保存多个客户
    private int numOfCustomer;  //用于记录存储客户的个数

    public Bank() {
        customers = new Customer[10];
    }


    /**
     * 将指定姓名的客户保存在银行客户列表中
     *
     * @param f
     * @param l
     */
    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
//        customers[numOfCustomer] = customer;
//        numOfCustomer++;
        customers[numOfCustomer++] = customer;

    }

    /**
     * 获取指定索引位置上的客户
     *
     * @param index
     * @return
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= numOfCustomer) {
            return null;
        }

        return customers[index];
    }

    /**
     * 获取客户列表中客户个数
     *
     * @return
     */
    public int getNumOfCustomer() {
        return numOfCustomer;
    }

}
```

```java
public class UseBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("l", "z");
        bank.addCustomer("h", "w");

        bank.getCustomer(0).setAccount(new Account(1000));
        bank.getCustomer(0).getAccount().withdraw(50);
        bank.getCustomer(0).getAccount().deposit(100);

        System.out.println("账户余额为：" + bank.getCustomer(0).getAccount().getBalance());
    }
}
```

