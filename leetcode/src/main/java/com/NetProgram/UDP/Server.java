package com.NetProgram.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);

        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(datagramPacket);  //阻塞接收
        System.out.println(new String(datagramPacket.getData()));

        //关闭连接
        socket.close();
    }
}
