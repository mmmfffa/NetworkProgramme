package com.mf.study02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author mf
 * @create 2021-05-15-10:03
 */
public class TcpServer02 {
    public static void main(String[] args) throws IOException {
        //1.创建一个端口
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.监听客户端的连接
        Socket socket = serverSocket.accept();//阻塞式监听，一致等待客户端的socket连接
        //3.获取输入流
        InputStream is = socket.getInputStream();
        //4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.jpeg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //通知客户端接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("已接收完毕！".getBytes(StandardCharsets.UTF_8));
        //5.关闭资源
        fos.close();
        is.close();
        socket.close();

    }
}
