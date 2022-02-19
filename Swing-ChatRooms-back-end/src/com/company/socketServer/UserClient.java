package com.company.socketServer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author peichendong
 */
public class UserClient   {

    /**
     * 信息
     */
    private String sendInfo;
    private String getInfo;

    /**
     * 客户端服务器
     */
    private Socket clientSocket;


    /**
     * 连接服务器
     */
    public UserClient() {

        try {
            /*
             *客户端服务器
             */
            System.out.println("正在连接服务器......");
            clientSocket = new Socket("127.0.0.1", 4700);
            System.out.println("成功连接到服务器......");
        } catch (IOException e) {
            System.out.println("未连接到服务器");
        }
    }


    /**
     * 发送信息
     */
    public class SendInfoThread extends Thread{
        @Override
        public void run() {
            try {
                PrintWriter clientPrintToServer = new PrintWriter(clientSocket.getOutputStream(), true);
                System.out.println("...信息发送就绪...");
                String info = getSendInfo();
                System.out.println("内容是:"+info);
                if (info != null){
                    clientPrintToServer.println(info);
                    clientPrintToServer.flush();
                    new GetInfoThread().start();
                    System.out.println("向服务器发送信息:"+info);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取用户发来的信息
     */
    class GetInfoThread extends Thread{
        @Override
        public void run() {
            try {

                BufferedReader infoReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String s = infoReader.readLine();
                if (s != null){
                    setGetInfo(s);
                    System.out.println("获取的信息:"+s);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    /**
     * @param sendInfo 需要发送的信息
     */
    public void setSendInfo(String sendInfo){
        this.sendInfo = sendInfo;
    }

    /**
     * @return 获取发送的信息
     */
    public String getSendInfo() {
        return sendInfo;
    }


    /**
     * @param getInfo 用户发送过来的信息
     */
    public void setGetInfo(String getInfo) {
        this.getInfo = getInfo;
    }

    /**
     * @return 获取的信息
     */
    public String getGetInfo() {
        return getInfo;
    }
}
