package com.mf.study03;

import java.io.ByteArrayOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author mf
 * @create 2021-05-15-10:53
 */
//还是要等待客户端连接
public class UdpServer {
    public static void main(String[] args) throws Exception {
        //1.开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //2.接收包

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);//接收
        socket.receive(packet);//阻塞接收
        System.out.println(packet.getAddress().getHostAddress());
        //new String(packet.getData())不能这么写，否则会出现很多空格
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        //3.关闭连接
        socket.close();
    }
}
