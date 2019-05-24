package com.lhh.udp;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author lhh
 * @date 2019/5/24 12:24
 */
public class Start {
    public static void main(String[] args) throws SocketException {
        DatagramSocket socket1 = new DatagramSocket(new InetSocketAddress("127.0.0.1",5555));
        DatagramSocket socket2 = new DatagramSocket(new InetSocketAddress("127.0.0.1",6666));

        new IOThread.Input(socket1).start();
        new IOThread.Input(socket2).start();

        new IOThread.Output(socket1, socket2).start();
        new IOThread.Output(socket2, socket1).start();
    }
}
