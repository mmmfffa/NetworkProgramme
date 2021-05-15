package com.mf.study04;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author mf
 * @create 2021-05-15-18:05
 */
public class UrlDown {
    public static void main(String[] args) throws Exception {
        //1.下载地址
        URL url = new URL("https://webfs.yun.kugou.com/202105151832/c997ea63cbc1e5c519f036072c7c3f7b/part/0/960187/KGTX/CLTX001/549d8158cad3b78a92cf4fa171226a72.mp3");
        //2.连接这个地址 HTTP
        HttpURLConnection urlConnection =( HttpURLConnection) url.openConnection();
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("3.mp3");
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
        urlConnection.disconnect();
    }
}
