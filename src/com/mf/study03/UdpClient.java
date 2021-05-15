package com.mf.study03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author mf
 * @create 2021-05-15-10:40
 */
//不需要连接服务器
public class UdpClient {
    public static void main(String[] args) throws Exception {
        //1.建立一个socket
        DatagramSocket socket = new DatagramSocket();
        //2.建个包,发给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port=9090;
        String msg="欢迎使用Udp通信";
        //数据，数据起始，目的地址，目的端口
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        //3.发个包
        socket.send(packet);
        //4.关闭流
        socket.close();
    }
}
