package com.lhh.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author lhh
 * @date 2019/5/24 0:06
 */
public class Client2 {

    public static void main(String[] args) throws IOException {
//        //收数据
//        DatagramSocket socket = new DatagramSocket(new InetSocketAddress("127.0.0.1",6666));
//        byte[] bytes = new byte[1024];
//        DatagramPacket receivePack = new DatagramPacket(bytes, bytes.length);
//        socket.receive(receivePack);
//        System.out.println(new String(receivePack.getData()));
//
//        //发数据
//        byte[] bytes1 = "Client2: this is Client2.".getBytes();
//        DatagramPacket packetToSend = new DatagramPacket(
//                bytes1, bytes1.length,
//                new InetSocketAddress("127.0.0.1",5555));
//        socket.send(packetToSend);

        //循环收发
        DatagramSocket socket = new DatagramSocket(new InetSocketAddress("127.0.0.1",6666));
        InputStream in = System.in;
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        while (true){
            String contentToSent = bf.readLine();
            if ("end".equals(contentToSent)){
                break;
            }

            //发数据
            byte[] bytes1 = contentToSent.getBytes();
            DatagramPacket packetToSend = new DatagramPacket(
                    bytes1, bytes1.length,
                    new InetSocketAddress("127.0.0.1",5555));
            socket.send(packetToSend);

            //收数据
            byte[] bytes = new byte[1024];
            DatagramPacket receivePack = new DatagramPacket(bytes, bytes.length);
            socket.receive(receivePack);
            System.out.println(new String(receivePack.getData()));
        }
        socket.close();
    }
}
