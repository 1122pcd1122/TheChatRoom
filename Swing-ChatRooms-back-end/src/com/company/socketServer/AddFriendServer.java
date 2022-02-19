package com.company.socketServer;

import com.alibaba.fastjson.JSONObject;
import com.company.model.daoimpl.FriendDaoImpl;
import com.company.model.entity.Ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author peichendong
 */
public class AddFriendServer {

    /**
     * UDP套接字
     */
    private DatagramSocket socket;


    private int port;
    private String addFriendInfo;
    private FriendDaoImpl friendDao;

    public static void main(String[] args) {
        new AddFriendServer();
    }


    /**
     * 开启服务器的‘4700’端口来处理用户的登录逻辑
     */
    public AddFriendServer() {
        try {
            socket = new DatagramSocket(4900);
            System.out.println("正在添加好友......");
            new GetFriendApply().start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     */
    class GetFriendApply extends Thread{
        @Override
        public void run() {
            byte[] requestInfo = new byte[1024];
            DatagramPacket packet = new DatagramPacket(requestInfo,requestInfo.length);
            try {
                while (true){
                    socket.receive(packet);
                    String jsonRequest = new String(packet.getData(),0,packet.getLength());
                    addFriendInfo = JSONObject.parseObject(jsonRequest, String.class);
                    System.out.println(addFriendInfo);
                    if (!"".equals(addFriendInfo)){
                        String[] split = addFriendInfo.split(",");
                        friendDao = new FriendDaoImpl();
                        boolean b = friendDao.insertFriend(split[1], split[0]);
                        System.out.println(b);
                        sendApplyInfo(String.valueOf(b));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                socket.close();
            }
        }
    }

    /**
     * 具体发送逻辑
     * @param s json字符串(好友信息/好友Ip信息)
     */
    private void sendApplyInfo(String s) {
        System.out.println(s);
        byte[] friendApply = s.getBytes();
        try {
            String[] split = addFriendInfo.split(",");
            Ip userIp = friendDao.getUserIp(split[1]);
            System.out.println(userIp.getPort());
            DatagramPacket packet = new DatagramPacket(friendApply,friendApply.length, InetAddress.getByName("127.0.0.1"), userIp.getPort());
            socket.send(packet);
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
