package com.NetProgram.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class TalkSend implements Runnable {

    DatagramSocket socket = null;
    BufferedReader reader = null;

    private String toIp;
    private int toPort;

    public TalkSend(String toIp, int toPort) {
        this.toIp = toIp;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket();
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        byte[] data = new byte[0];
        while (true) {
            try {
                data = reader.readLine().getBytes();
                socket.send(new DatagramPacket(data, 0, data.length, InetAddress.getByName(toIp), toPort));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String msg = new String(data, 0, data.length);
            if (msg.equals("bye"))
                break;
        }

        try {
            if (reader != null)
                reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (socket != null)
            socket.close();
    }
}
