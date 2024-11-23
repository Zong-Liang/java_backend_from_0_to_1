# 04_super关键字

子类继承父类以后，对父类的方法进行了重写，如何在子类中对父类中被重写的方法进行调用？

子类继承父类以后，如何区分子类和父类中同名的属性？

使用`super`关键字，有`super.`的就是父类的，没有`super.`就是子类自己的。

- 子类继承父类时，不会继承父类的构造器。只能通过`super(形参列表)`的方式调用父类指定的构造器。

- `super(形参列表)`只能声明在构造器首行。

- 在构造器首行，`this(形参列表)`和`super(形参列表)`只能二选一。
- 如果在子类构造器没有显示的使用`super(形参列表)`和`this(形参列表)`，则子类此构造器默认调用`super()`，即父类中空参的构造器。
- 子类的任何一个构造器，要么调用本类中重载的构造器，要么调用父类的构造器。
- 一个类中声明有n个构造器，最多有n-1个构造器中使用`this(形参列表)`，剩下那个一定使用`super(形参列表)`。

```java
public class Mankind {
    private int gender;
    private double salary;

    public Mankind() {
    }

    public Mankind(int gender, double salary) {
        this.gender = gender;
        this.salary = salary;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void maleOrFemale() {
        if (gender == 1) {
            System.out.println("male");
        } else if (gender == 0) {
            System.out.println("female");
        }
    }

    public void employed() {
        if (salary == 0) {
            System.out.println("have no job");
        } else {
            System.out.println("have job");
        }
    }
}
```

```java
public class Kid extends Mankind {
    private int age;

    
    public void setAge(int age) {
        this.age = age;
    }

    public void getAge() {
        System.out.println("age: " + age);
    }

    //重写父类方法
    //用super调用父类方法
    public void employed() {
        super.employed();
        System.out.println("kid should study and have no job");
    }

    public void getInfo() {
        System.out.println("kid' info");
    }
}
```

我们在通过子类的构造器创建对象时，一定在调用子类构造器的过程中，直接或间接的调用到父类的构造器。也正因为调用过父类的构造器，我们才会将父类中声明的属性或方法加载到内存中，供子类对象使用。