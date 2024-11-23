# 01_File类的使用

[File类](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)位于`java.io`包下，`File`类的一个对象对应于操作系统下的一个文件或一个文件目录 (文件夹)。

使用说明：

- 构造器：`File(String pathname)`、`File(String parent, String child)`、`File(File parent, String child)`。

```java
//构造器的使用
@Test
public void test1() {
    //File(String pathname)
    File file1 = new File("hello.txt");
    File file2 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\src\\learnjava_14\\hello.txt");

    System.out.println(file1.getAbsoluteFile());
    System.out.println(file2.getAbsoluteFile());

    //File(String parent, String child)
    //第一个参数是父目录
    //第二个参数是子目录或文件
    File file3 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\src\\learnjava_14", "hello");
    File file4 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\src\\learnjava_14", "hello.txt");

    //File(File parent, String child)
    //第一个参数是父目录
    //第二个参数是子目录或文件
    File file5 = new File(file3, "hello.txt");
}
```

- 方法：`getName()`、`	getPath()`、`getAbsolutePath()`、`getAbsoluteFile()`、`getParent()`、`length()`、`lastModified()`、`	list()`、`listFiles()`、`renameTo(File dest)`、`exists()`、`isDirectory()`、`isFile()`、`canRead()`、`canWrite()`、`isHidden()`、`createNewFile()`、`mkdir()`、`mkdirs()`、`delete()`。

```java
//常用方法
@Test
public void test2() {
    File file1 = new File("hello.txt");
    System.out.println(file1.getName());
    System.out.println(file1.getPath());
    System.out.println(file1.getAbsolutePath());
    System.out.println(file1.getAbsoluteFile());
    System.out.println(file1.getAbsoluteFile().getParent());
    System.out.println(file1.getParent());
    System.out.println(file1.length());
    System.out.println(file1.lastModified());

    System.out.println("-".repeat(100));

    File file2 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello.txt");
    System.out.println(file2.getName());
    System.out.println(file2.getPath());
    System.out.println(file2.getAbsolutePath());
    System.out.println(file2.getAbsoluteFile());
    System.out.println(file2.getAbsoluteFile().getParent());
    System.out.println(file2.getParent());
    System.out.println(file2.length());
    System.out.println(file2.lastModified());

    System.out.println("-".repeat(100));

    File file3 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14");
    String[] f_arr = file3.list();
    for (String s : f_arr) {
        System.out.println(s);
    }
    File[] f_arr2 = file3.listFiles();
    assert f_arr2 != null;
    for (File f : f_arr2) {
        System.out.println(f);
        //            System.out.println(f.getName());
    }

    System.out.println("-".repeat(100));

    //要求file1存在，file2不存在，且file2所在的目录存在
    File file4 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello1.txt");
    File file5 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello2.txt");

    boolean renameTo = file4.renameTo(file5);
    System.out.println(renameTo ? "success" : "fail");

    System.out.println("-".repeat(100));

    File file6 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello2.txt");
    System.out.println(file6.exists());
    System.out.println(file6.isDirectory());
    System.out.println(file6.isFile());
    System.out.println(file6.canRead());
    System.out.println(file6.canWrite());
    System.out.println(file6.isHidden());

    System.out.println("-".repeat(100));

    File file7 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello");
    System.out.println(file7.exists());
    System.out.println(file7.isDirectory());
    System.out.println(file7.isFile());
    System.out.println(file7.canRead());
    System.out.println(file7.canWrite());
    System.out.println(file7.isHidden());

    System.out.println("-".repeat(100));

    File file8 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello1.txt");
    if (!file8.exists()) {
        try {
            boolean newFile = file8.createNewFile();
            System.out.println(newFile ? "success" : "fail");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        file8.delete();
        System.out.println("delete success");
    }

    System.out.println("-".repeat(100));

    File file9 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello1");
    System.out.println(file9.mkdir());

    File file10 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello2");
    System.out.println(file10.mkdirs());

    File file11 = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14\\hello3\\hello3_1");
    System.out.println(file11.mkdirs());
}
```

`Java`中的删除不走回收站，要删除一个文件目录，请注意该文件目录内不能包含文件或文件目录。

相关概念：

- 绝对路径：以`windows`操作系统为例，包括盘符在内的文件或文件目录的完整路径。

- 相对路径：相对于某一个文件目录来讲的相对路径。IDEA中，如果使用单元测试方法，是相对于当前`module`来讲；如果使用`main`方法是相对于当前`project`来讲。

```java
@Test
public void test3() {
    //判断指定目录下是否有后缀名为.png的文件，如果有，输出改文件名
    File file = new File("D:\\Desktop\\zongliang\\learn_java\\code\\chapter_14");
    String[] list1 = file.list();
    assert list1 != null;
    for (String s : list1) {
        if (s.endsWith(".png")) {
            System.out.println(s);
        }
    }

    String[] list2 = file.list(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".png");
        }
    });

    for (String s : list2) {
        System.out.println(s);
    }
}
```

