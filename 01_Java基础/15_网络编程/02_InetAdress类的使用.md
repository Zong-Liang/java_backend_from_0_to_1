# 02_InetAdress类的使用

[`InetAdress`](https://docs.oracle.com/javase/8/docs/api/java/net/InetAddress.html)类的一个实例就代表一个具体的 IP 地址。

`getByName(String host)`、`	getLocalHost()`方法实例化`InetAddress`对象。

常用方法：`getHostName()`、`getHostAddress()`。

```java
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    @Test
    public void test1() {
        //实例化InetAddress对象
        try {
            //getByName(String host): 获取指定IP对应的InetAddress实例
            InetAddress address1 = InetAddress.getByName("www.baidu.com");
            System.out.println(address1);

            InetAddress address2 = InetAddress.getByName("183.2.172.42");
            System.out.println(address2);

            //getLocalHost(): 获取本地IP对应的InetAddress实例
            InetAddress address3 = InetAddress.getLocalHost();
            System.out.println(address3);

            InetAddress address4 = InetAddress.getByName("127.0.0.1");
            System.out.println(address4);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        //常用方法
        try {
            InetAddress address5 = InetAddress.getByName("www.baidu.com");
            //getHostName(): 获取IP对应的域名
            System.out.println(address5.getHostName());
            //getHostAddress(): 获取IP地址
            System.out.println(address5.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
```

