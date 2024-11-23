# 05_UDP编程案例

```java
import org.junit.jupiter.api.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPTest {
    @Test
    public void test1() {
        //发送端
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        InetAddress address = null;
        DatagramPacket packet = null;
        try {
            address = InetAddress.getByName("172.19.12.214");
            int port = 8989;
            byte[] data = "我是发送端".getBytes();
            packet = new DatagramPacket(data, 0, data.length, address, port);
            socket.send(packet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        socket.close();
    }

    @Test
    public void test2() {
        //接收端
        int port = 8989;
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = null;
        try {
            packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        socket.close();
    }
}
```

