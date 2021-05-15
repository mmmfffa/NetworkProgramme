package com.mf.chat;

/**
 * @author mf
 * @create 2021-05-15-17:17
 */
public class TalkTeacher {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"学生")).start();

    }
}
