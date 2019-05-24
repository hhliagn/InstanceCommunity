package com.lhh.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lhh
 * @date 2019/5/24 12:51
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 7777));
        while (true){
            Socket socket = serverSocket.accept();

            new Task().new Input(socket).start();   //写入数据线程
            new Task().new Output(socket).start();  //输出数据线程
        }
    }
}
