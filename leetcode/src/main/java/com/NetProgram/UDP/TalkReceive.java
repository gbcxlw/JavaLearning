package com.NetProgram.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {

    DatagramSocket datagramSocket = null;
    private int port;
    private String name;

    public TalkReceive(int port, String name) {
        this.port = port;
        this.name = name;

        try {
            datagramSocket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
                datagramSocket.receive(datagramPacket);

                String msg = new String(datagramPacket.getData());
                System.out.println(name + ":" + msg);
                if (msg.equals("bye"))
                    break;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        datagramSocket.close();
    }
}
