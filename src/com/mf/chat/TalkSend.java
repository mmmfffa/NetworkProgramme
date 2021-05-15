package com.mf.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @author mf
 * @create 2021-05-15-11:55
 */
public class TalkSend implements Runnable{
    DatagramSocket socket=null;
    BufferedReader reader=null;
    private int fromPort;
    private String toIP;
    private int toPort;

    public TalkSend (int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            //1.建立socket
            socket = new DatagramSocket(fromPort);
            //准备数据:聊天，从控制台读取System.in
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            String data = null;
            try {
                data = reader.readLine();
                //2.建包
                DatagramPacket packet = new DatagramPacket(data.getBytes(), 0, data.getBytes().length,
                                                            new InetSocketAddress(this.toIP, this.toPort));
                //3.发包
                socket.send(packet);
                //关闭连接
                if (data.equals("bye")) break;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //4.关闭
        socket.close();
    }
}
