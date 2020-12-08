package com.NetProgram.UDP;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        //建立socket
        DatagramSocket socket = new DatagramSocket();

        //打包数据包
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        int port = 9090;
        String msg = "hello world";
//        new DatagramPacket(msg.getBytes(),0,msg.getBytes().length);
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, ip, port);

        socket.send(datagramPacket);
        socket.close();
    }
}
