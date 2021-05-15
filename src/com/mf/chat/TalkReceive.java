package com.mf.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author mf
 * @create 2021-05-15-12:08
 */
public class TalkReceive implements Runnable{
    DatagramSocket socket=null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port,String msgFrom) {
        this.port = port;
        this.msgFrom=msgFrom;
        //1.建socket
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {


        while (true){
            try {
                //2.接收包
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(packet);//阻塞式接收窗口
                //断开连接
                byte[] data = packet.getData();
                String dataStr = new String(data);
                System.out.println(msgFrom+":"+dataStr);
                if(dataStr.equals("bye")) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //3.关闭
        socket.close();
    }
}
