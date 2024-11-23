# 05_Map接口及其不同实现类

[`java.util.Map`](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)：存储一对一对的数据 (key-value 对)。

- `HashMap`：主要实现类，线程不安全，效率高；可以添加`null`的 key 和 value 值；底层使用数组+单向链表+红黑树结构存储 (jdk8)。

  ```java
  @Test
  public void test1(){
      Map map = new HashMap();
  
      map.put(null,null);
  
      System.out.println(map);
  }
  ```

  - `LinkedHashMap`：是`HashMap`的子类，在`HashMap`使用的数据结构的基础上增加了一对双向链表，用于记录添加元素的先后顺序，进而我们在遍历元素时，就可以按照添加的顺序显示。开发中，对于频繁的便利操作，建议使用此类。

    ```java
    @Test
    public void test3(){
        LinkedHashMap map = new LinkedHashMap();
    
        map.put("Tom",23);
        map.put("a",new Date());
        map.put(1,"b");
    
        System.out.println(map);
    }
    ```

- `HashTable`：古老实现类，线程安全，效率低；底层使用数组+单向链表结构存储 (jdk8)。

  ```java
  @Test
  public void test2(){
      Map map = new Hashtable();
  
      //        map.put("a",null); //NullPointerException
      //        map.put(null,1); //NullPointerException
      map.put("a",1);
  
      System.out.println(map);
  }
  ```

- `TreeMap`：底层使用红黑树存储；可以按照添加的 key-value 中 key 元素的指定属性的大小顺序进行遍历，需要考虑使用自然排序或定制排序。

  - `Properties`：其 key 和 value 值都是`String`类型，常用来处理属性文件。

`HashMap`中元素的特点：

- `HashMap`中所有的 key 彼此之间是不可重复的，无序的，所有的 key 就构成一个`Set`集合 (key 所在类要重写`hashCode()`和`equals()`方法)。
- `HashMap`中所有的 value 彼此之间是可重复的，无序的，所有的 value 就构成一个`Collection`集合 (value 所在类要重写`equals()`方法)。
- `HashMap`中的一个 key-value，就构成了一个 entry。
- `HashMap`中所有的 entry 之间是不可重复的，无序的，所有的 key 就构成一个`Set`集合。

`Map`中的常用方法：

```java
@Test
public void test4() {
    var map = new HashMap();

    //put(Object key, Object value)
    map.put("a", 1);
    map.put(2, "b");
    map.put(new Person("Tom", 16), "p");
    System.out.println(map);

    //size()
    System.out.println(map.size());

    //remove(Object key)
    System.out.println(map.remove(new Person("Tom", 16)));
    System.out.println(map);

    //put(Object key, Object value)
    map.put("a", 8);
    System.out.println(map);

    //get(Object key)
    System.out.println(map.get(2));
}

@Test
public void test5() {
    HashMap map = new HashMap();

    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.put(new Person("Jerry", 15), "d");
    map.put(new Person("Jack", 16), "e");

    //遍历key
    var keys = map.keySet();
    for (Object o : keys) {
        System.out.println(o);
    }

    //遍历value
    var values = map.values();
    for (Object o : values) {
        System.out.println(o);
    }

    //遍历entry
    var entries = map.entrySet();
    for (Object o : entries) {
        System.out.println(o);
    }
}
```

`TreeMap`的使用：

```java
//自然排序
@Test
public void test6() {
    var map = new TreeMap();

    var u1 = new User("Tom", 16);
    var u2 = new User("Jerry", 17);
    var u3 = new User("Jack", 18);
    var u4 = new User("Rose", 16);
    var u5 = new User("Robbin", 26);

    map.put(u1, 99);
    map.put(u2, 89);
    map.put(u3, 82);
    map.put(u4, 96);
    map.put(u5, 66);

    var entries = map.entrySet();
    for (Object o : entries) {
        System.out.println(o);
    }

    System.out.println(map.containsKey(new User("Robbin", 26)));
}

//定制排序
@Test
public void test7() {
    var comparator = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof User && o2 instanceof User) {
                User u1 = (User) o1;
                User u2 = (User) o2;

                int value = u1.getName().compareTo(u2.getName());

                if (value != 0) {
                    return value;
                } else {
                    return -(u1.getAge() - u2.getAge());
                }
            } else {
                throw new RuntimeException();
            }
        }
    };

    var map = new TreeMap(comparator);

    var u1 = new User("Tom", 16);
    var u2 = new User("Jerry", 17);
    var u3 = new User("Jack", 18);
    var u4 = new User("Rose", 16);
    var u5 = new User("Robbin", 26);

    map.put(u1, 99);
    map.put(u2, 89);
    map.put(u3, 82);
    map.put(u4, 96);
    map.put(u5, 66);

    var entries = map.entrySet();
    for (Object o : entries) {
        System.out.println(o);
    }
}
```

`Properties`的使用：

```java
@Test
public void test8() {
    //方式1：数据和代码耦合度高，如果修改需要重写编译代码，打包发布，繁琐
    //数据
    //        var name = "zl";
    //        var password = "123456";
    //操作name、password的代码
    //...

    //方式2：将数据封装到具体的配置文件中，在程序中读取配置文件的信息，实现了数据和代码的解耦，省去了重新编译打包的过程。
    var file = new File("info.properties"); //要提前创建好
    System.out.println(file.getAbsoluteFile());

    FileInputStream fis = null;
    try {
        fis = new FileInputStream(file);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

    var props = new Properties();
    try {
        props.load(fis); //加载流中的数据
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    var name = props.getProperty("name");
    var pwd = props.getProperty("password");

    System.out.println(name + ": " + pwd);

    try {
        fis.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
```

