package com.mf.study02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author mf
 * @create 2021-05-15-9:53
 */
public class TcpClient02 {
    public static void main(String[] args) throws IOException {
        //1.创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //2.创建输出流
        OutputStream os = socket.getOutputStream();
        //3.文件流
        FileInputStream fis = new FileInputStream("3.jpeg");
        //4.写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //通知服务器已经传输完毕
        socket.shutdownOutput();

        //确定服务器接收完毕才能断开连接
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=is.read(buffer2))!=-1){
            bao.write(buffer2,0,len2);
        }
        System.out.println(bao.toString());
        //5.关闭资源
        fis.close();
        os.close();
        socket.close();

    }
}
