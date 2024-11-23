# 04_TCP编程案例

`Socket`类：

网络上具有唯一标识的 IP 地址和端口号组合在一起构成唯一能识别的标识符套接字 (`Socket`)。

- 利用套接字 (`Socket`) 开发网络应用程序早已被广泛的采用，以至于成为事实上的标准。网络通信其实就是`Socket`间的通信。

- 通信的两端都要有`Socket`，是两台机器间通信的端点。

- `Socket`允许程序把网络连接当成一个流，数据在两个`Socket`间通过 `IO` 传输。

- 一般主动发起通信的应用程序属客户端，等待通信请求的为服务端。

- `Socket`分类：
  - 流套接字 (`stream socket`)：使用 TCP 提供可依赖的字节流服务。
    - `ServerSocket`：此类实现TCP服务器套接字。服务器套接字等待请求通过网络传入。
    - `Socket`：此类实现客户端套接字 (也可以就叫“套接字”)。套接字是两台机器间通信的端点。
  - 数据报套接字 (`datagram socket`)：使用 UDP 提供“尽力而为”的数据报服务。
    - `DatagramSocket`：此类表示用来发送和接收 UDP 数据报包的套接字。

```java
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest1 {
    //客户端发送内容给服务端，服务端将内容打印到控制台上
    @Test
    public void test1() {
        //客户端
        //1.创建Socket对象，指明服务器端的IP和端口号
        InetAddress address = null;
        try {
            address = InetAddress.getByName("172.19.12.214");//声明服务端IP
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int port = 8989;//声明服务端端口号
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket(address, port);

            //2.获取一个输出流，用于输出数据
            //3.写出数据的操作
            os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //4.资源关闭
        try {
            os.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void test2() {
        //服务端
        //1.创建ServerSocket对象，绑定监听的端口
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        try {
            int port = 8989;//声明端口号
            ss = new ServerSocket(port);

            //2.调用accept()方法接收客户端的Socket对象
            socket = ss.accept();//阻塞式方法
            System.out.println("服务端已开启，等待客户端连接...");

            //3.获取一个输入流，用于输入数据
            //4.读取数据的操作
            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自于" + socket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //5.资源关闭
        try {
            is.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

```java
package learnjava_15;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest2 {
    //客户端发送内容给服务端，服务端将内容保存到本地
    //客户端
    @Test
    public void test1() {
        //1.创建Socket对象，指明服务器端的IP和端口号
        InetAddress address = null;
        try {
            address = InetAddress.getByName("172.19.12.214");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int port = 8989;
        Socket socket = null;
        File file = new File("Wukong.png");
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            socket = new Socket(address, port);
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //2.获取一个输出流，用于输出数据
                os = socket.getOutputStream();
                //3.写出数据的操作
                os.write(buffer, 0, len);
            }
            System.out.println("文件传输完成");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //4.资源关闭
        try {
            os.close();
            fis.close();
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //服务端
    @Test
    public void test2() {
        //1.创建ServerSocket对象，绑定监听的端口
        int port = 8989;
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(port);
            //2.调用accept()方法接收客户端的Socket对象
            socket = ss.accept();
            System.out.println("服务端已开启，等待客户端连接...");
            is = socket.getInputStream();

            //3.获取一个输入流，用于输入数据
            File file = new File("Wukong_copy.png");
            os = new java.io.FileOutputStream(file);

            //4.读取数据的操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            System.out.println("文件传输完成");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //5.资源关闭
        try {
            os.close();
            is.close();
            socket.close();
            ss.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
```

```java
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest3 {
    //客户端发送内容给服务端，服务端将内容保存到本地
    //客户端
    @Test
    public void test1() {
        //1.创建Socket对象，指明服务器端的IP和端口号
        InetAddress address = null;
        try {
            address = InetAddress.getByName("172.19.12.214");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int port = 8989;
        Socket socket = null;
        File file = new File("Wukong.png");
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            socket = new Socket(address, port);
            fis = new FileInputStream(file);
            byte[] buffer1 = new byte[1024];
            int len1;
            while ((len1 = fis.read(buffer1)) != -1) {
                //2.获取一个输出流，用于输出数据
                os = socket.getOutputStream();
                //3.写出数据的操作
                os.write(buffer1, 0, len1);
            }
            System.out.println("文件传输完成");

            //客户端表明不再发送数据
            socket.shutdownOutput();

            //4.接收服务端的反馈
            InputStream is = socket.getInputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            //避免出现乱码
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len2 = is.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }
            System.out.println(baos.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //5.资源关闭
        try {
            os.close();
            fis.close();
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //服务端
    @Test
    public void test2() {
        //1.创建ServerSocket对象，绑定监听的端口
        int port = 8989;
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(port);
            //2.调用accept()方法接收客户端的Socket对象
            socket = ss.accept();
            System.out.println("服务端已开启，等待客户端连接...");
            is = socket.getInputStream();

            //3.获取一个输入流，用于输入数据
            File file = new File("Wukong_copy_1.png");
            os = new java.io.FileOutputStream(file);

            //4.读取数据的操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            System.out.println("文件传输完成");

            //5.发送数据给客户端
            os = socket.getOutputStream();
            os.write("已收到你的图片".getBytes());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //6.资源关闭
        try {
            os.close();
            is.close();
            socket.close();
            ss.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
```

