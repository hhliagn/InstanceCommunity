package com.lhh.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @author lhh
 * @date 2019/5/24 0:06
 */
public class Client1 {

    public static void main(String[] args) throws IOException {
//        //发数据
//        DatagramSocket socket = new DatagramSocket(new InetSocketAddress("127.0.0.1",5555));
//        byte[] bytes = "Client1: this is Client1.".getBytes();
//        DatagramPacket packetToSend = new DatagramPacket(
//                bytes, bytes.length,
//                new InetSocketAddress("127.0.0.1",6666));
//        socket.send(packetToSend);
//
//        //收数据
//        byte[] bytes1 = new byte[1024];
//        DatagramPacket packetToReceive = new DatagramPacket(bytes1, bytes1.length);
//        socket.receive(packetToReceive);
//        byte[] data = packetToReceive.getData();
//        System.out.println(new String(packetToReceive.getData()));

        DatagramSocket socket = new DatagramSocket(new InetSocketAddress("127.0.0.1",5555));
        InputStream in = System.in;
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        while (true){

            //收数据
            byte[] bytes = new byte[1024];
            DatagramPacket receivePack = new DatagramPacket(bytes, bytes.length);
            socket.receive(receivePack); //这里会阻塞,直到收到消息
            System.out.println(new String(receivePack.getData()));

            //阻塞等待命令行输入
            String contentToSent = bf.readLine();
            if ("end".equals(contentToSent)){
                break;
            }

            //发数据
            byte[] bytes1 = contentToSent.getBytes();
            DatagramPacket packetToSend = new DatagramPacket(
                    bytes1, bytes1.length,
                    new InetSocketAddress("127.0.0.1",6666));
            socket.send(packetToSend);
        }

        socket.close();
    }
}
