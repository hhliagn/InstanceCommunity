package com.lhh.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author lhh
 * @date 2019/5/24 12:51
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 7777);  //创建客户端并连接

        new Task().new Input(socket).start();
        new Task().new Output(socket).start();
    }
}
