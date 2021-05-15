package com.mf.study04;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author mf
 * @create 2021-05-15-17:40
 */
public class TestUrl {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=mafu&password=999");
        System.out.println("协议名=>"+url.getProtocol());
        System.out.println("主机=>" + url.getHost());
        System.out.println("端口=>" + url.getPort());
        System.out.println("文件=>" + url.getPath());
        System.out.println("文件全路径=>" + url.getFile());
        System.out.println("参数=>" + url.getQuery());

    }
}
