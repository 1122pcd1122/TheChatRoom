package com.company.socketServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author peichendong
 */
public class Server {

    /**
     *获取信息
     */
    ServerSocket serverSocket;

    /**
     * 发送信息
     */
    BufferedReader bufferedReader;
    private Socket socket;

    private String info;

    public Server() {
        try {
            System.out.println("正在创建服务器");
            serverSocket = new ServerSocket(5600);
            System.out.println("服务器创建成功");
            System.out.println("获取连接中......");
            socket = serverSocket.accept();
            if (socket != null){
                System.out.println("连接成功......");
            }
            new GetInfoThread().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();

    }

    /**
     * 获取用户发来的信息
     */
    class GetInfoThread extends Thread{
        @Override
        public void run() {

            try {
                while (true){
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String s = bufferedReader.readLine();
                    setInfo("我获取到了");
                    System.out.println("获取的信息是"+s);
                    new SendInfoThread().start();
                    if ("".equals(s)){
                        break;
                    }
                }
                bufferedReader.close();
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送信息
     */
    class SendInfoThread extends Thread{
        @Override
        public void run() {
            try {
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
                printWriter.println(getInfo());
                printWriter.flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
