package com.mf.chat;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author mf
 * @create 2021-05-15-11:04
 */
public class UdpSend {
    public static void main(String[] args) throws Exception {
        //1.建立socket
        DatagramSocket socket = new DatagramSocket(8888);
        while (true){
            //准备数据:聊天，从控制台读取System.in
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String data = reader.readLine();
            //关闭连接
            if (data.equals("bye")) break;
            //2.建包
            InetAddress localhost = InetAddress.getByName("localhost");
            int port=6666;
            DatagramPacket packet = new DatagramPacket(data.getBytes(),0,data.getBytes().length,localhost,port);

            //3.发包
            socket.send(packet);
        }

        //4.关闭
        socket.close();
    }
}
