# 03_Thread类

[构造器](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)

`public Thread()`：分配一个新的线程对象。

`public Thread(String name)`：分配一个指定名字的新的线程对象。

`public Thread(Runnable target)`：指定创建线程的目标对象，它实现了`Runnable`接口中的`run()`方法。

`public Thread(Runnable target, String name)`：分配一个带有指定目标新的线程对象并指定名字。

[方法](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)

`start()`：启动线程，调用线程的`run()`方法。

`run()`：将线程要执行的操作声明在`run()`方法中。

`currentThread()`：获取当前执行代码对应的线程。

`getName()`：获取线程名。

`setName(String name)`：设置线程名。

`sleep(long millis)`：静态方法，调用时可以使当前线程睡眠指定的毫秒数。

`yield()`：静态方法，一旦执行此方法，会释放CPU执行权。

`join(long millis)`：在线程`a`中通过线程`b`调用`join()`方法，就意味着线程`a`进入阻塞状态，直到线程`b`结束，线程`a`才结束阻塞状态，继续执行。

`isAlive()`：判断当前线程是否存活。

`getPriority()`：获取线程优先级。

`setPriority(int newPriority)`：设置线程优先级 (1-10)。

线程的生命周期：创建、就绪、运行、阻塞、死亡。

![temp_pic.drawio](https://cdn.jsdelivr.net/gh/ZL85/ImageBed@main//202403111124896.png)