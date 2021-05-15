package com.mf.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author mf
 * @create 2021-05-15-11:04
 */
public class UdpReceive {
    public static void main(String[] args) throws Exception {
        //1.建socket
        DatagramSocket socket = new DatagramSocket(6666);
        while (true){
            //2.接收包
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet);//阻塞式接收窗口
            //断开连接
            byte[] data = packet.getData();
            String dataStr = new String(data);
            if(dataStr.equals("bye")) break;
            System.out.println(dataStr);
        }

        //3.关闭
        socket.close();
    }
}
