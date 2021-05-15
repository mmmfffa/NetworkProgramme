package com.mf.study02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mf
 * @create 2021-05-14-21:45
 */
public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream is=null;;
        ByteArrayOutputStream bao=null;
        try {
            //1.我需要一个地址
            serverSocket = new ServerSocket(9999);
            //2.等待客户端连接过来,监听
            socket = serverSocket.accept();
            //3.读取客户端消息
            is = socket.getInputStream();
            //管道流(在输出流和输入流之间加了一个黑盒子即管道流),可能存在乱码，包装过滤层
            bao = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                bao.write(buffer,0,len);
            }
            System.out.println(bao.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源  先开后关
            if(bao!=null){
                try {
                    bao.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
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
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
