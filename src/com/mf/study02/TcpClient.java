package com.mf.study02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * @author mf
 * @create 2021-05-14-21:44
 */
public class TcpClient {
    public static void main(String[] args) {
        InetAddress serverIP=null;
        Socket socket=null;
        OutputStream os=null;
        try {
            //1.要知道服务端的地址  ,端口号
            serverIP = InetAddress.getByName("127.0.0.1");
            int port=9999;
            //2.创建socket连接
            socket = new Socket(serverIP,port);
            //3.发送消息  IO流
            os = socket.getOutputStream();
            os.write("欢迎学习Tcp通信".getBytes(StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
