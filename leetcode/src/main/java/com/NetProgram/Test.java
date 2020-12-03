package com.NetProgram;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
        System.out.println(inetAddress1);

        InetAddress inetAddress2 = InetAddress.getByName("www.csdn.net");
        System.out.println(inetAddress2);

        InetAddress inetAddress3=InetAddress.getLocalHost();
        System.out.println(inetAddress3);

        System.out.println(inetAddress2.getHostAddress());//ip
        System.out.println(inetAddress2.getHostName());//域名
    }
}
