package com.NetProgram;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MessageTransportClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            //获取服务器端口与端口号
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //创建socket连接
            socket = new Socket(serverIp, port);

            os = socket.getOutputStream();
            os.write("hello world".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
