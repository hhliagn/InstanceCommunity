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
 * @date 2019/5/24 12:24
 */
public class IOThread {

    private static InputStream in = System.in;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(in));

    public static class Input extends Thread{

        private DatagramSocket datagramSocket;

        public Input(DatagramSocket datagramSocket) {
            this.datagramSocket = datagramSocket;
        }

        @Override
        public void run() {
            while (true){
                //收数据
                byte[] bytes = new byte[1024];
                DatagramPacket receivePack = new DatagramPacket(bytes, bytes.length);
                try {
                    datagramSocket.receive(receivePack); //这里会阻塞,直到收到消息
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(new String(receivePack.getData()));
            }
        }
    }

    public static class Output extends Thread{

        private DatagramSocket datagramSocket;
        private DatagramSocket datagramSocket1;

        public Output(DatagramSocket datagramSocket, DatagramSocket datagramSocket1) {
            this.datagramSocket = datagramSocket;
            this.datagramSocket1 = datagramSocket1;
        }

        @Override
        public void run() {
            while (true){
                //阻塞等待命令行输入
                String contentToSent = null;
                try {
                    contentToSent = bf.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if ("end".equals(contentToSent)){
                    break;
                }

                //发数据
                byte[] bytes1 = contentToSent.getBytes();
                DatagramPacket packetToSend = new DatagramPacket(
                        bytes1, bytes1.length,
                        datagramSocket1.getLocalSocketAddress());
                try {
                    datagramSocket.send(packetToSend);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
