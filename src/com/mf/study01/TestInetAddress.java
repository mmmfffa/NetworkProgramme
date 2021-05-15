package com.mf.study01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author mf
 * @create 2021-05-14-21:06
 */
//测试IP
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress address1 = InetAddress.getByName("127.0.0.1");
            System.out.println(address1);
            InetAddress address3 = InetAddress.getByName("localhost");
            System.out.println(address3);
            InetAddress address4 = InetAddress.getLocalHost();
            System.out.println(address4);
            //查询网络地址
            InetAddress address2 = InetAddress.getByName("www.baidu.com");
            System.out.println(address2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
