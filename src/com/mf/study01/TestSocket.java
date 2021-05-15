package com.mf.study01;

import java.net.InetSocketAddress;

/**
 * @author mf
 * @create 2021-05-14-21:31
 */
public class TestSocket {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(socketAddress);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",8080);
        System.out.println(socketAddress2);

        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getHostName());//地址
        System.out.println(socketAddress.getPort());//端口
    }
}

