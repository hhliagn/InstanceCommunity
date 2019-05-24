package com.lhh.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author lhh
 * @date 2019/5/24 12:51
 */
public class Task {

    public class Input extends Thread{
        private Socket socket;
        public Input(Socket socket) throws IOException {
            this.socket = socket;
        }
        @Override
        public void run() {
            InputStream inputStream = null;
            BufferedReader bf = null;
            String content;
            try {
                inputStream = socket.getInputStream();
                bf = new BufferedReader(new InputStreamReader(inputStream));
                while (true){
                    while ((content = bf.readLine())!=null){
                        System.out.println(content);
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bf !=null){
                    try {
                        bf.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class Output extends Thread{
        private Socket socket;
        public Output(Socket socket) throws IOException {
            this.socket = socket;
        }
        @Override
        public void run() {
            PrintWriter pw = null;
            BufferedReader bf = null;
            String content;
            try {
                pw = new PrintWriter(socket.getOutputStream());
                bf = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    while ((content = bf.readLine()) != null) {
                        if ("end".equals(content)) {
                            break;
                        }
                        pw.println(content);
                        pw.flush();
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (pw != null){
                    pw.close();
                }
                if (bf != null){
                    try {
                        bf.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
