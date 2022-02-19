package com.company.socketServer;

import com.alibaba.fastjson.JSONObject;
import com.company.model.daoimpl.FriendDaoImpl;
import com.company.model.entity.Ip;
import com.company.model.entity.User;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author peichendong
 */
public class MainFrameServer {

    DatagramSocket socket;
    private FriendDaoImpl friendDao;
    private String userId;

    public static void main(String[] args) {
        new MainFrameServer();
    }

    public MainFrameServer() {
        try {
            friendDao = new FriendDaoImpl();
            socket = new DatagramSocket(4800);
            new SendFriendsInfoThread().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    class SendFriendsInfoThread extends Thread{
        @Override
        public void run() {
            byte[] requestInfo = new byte[1024];
            DatagramPacket packet = new DatagramPacket(requestInfo,requestInfo.length);
            try {
                while (true){
                    socket.receive(packet);
                    String jsonRequest = new String(packet.getData(),0,packet.getLength());
                    userId = JSONObject.parseObject(jsonRequest, String.class);
                    System.out.println(userId);
                    if (!"".equals(userId)){
                        sendFriendInfo();
                        sendFriendIp();
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
     * 发送好友列表
     */
    private void sendFriendInfo() {
        List< String > friends = friendDao.getFriends(userId);
        List< User > friendInfos = new ArrayList<>();
        for (String friend : friends) {
            User friendInfo = friendDao.getFriendInfo(friend);
            friendInfos.add(friendInfo);
        }
        System.out.println(friends);
        sendInfo(JSONObject.toJSONString(friendInfos));
    }

    /**
     * 发送好友IP
     */
    private void sendFriendIp(){
        List< String > friends = friendDao.getFriends(userId);
        List<Ip> friendIps = new ArrayList<>();
        for (String friend : friends) {
            Ip userIp1 = friendDao.getUserIp(friend);
            friendIps.add(userIp1);
        }
        System.out.println(friendIps);
        sendInfo(JSONObject.toJSONString(friendIps));
    }

    /**
     * 具体发送逻辑
     * @param s json字符串(好友信息/好友Ip信息)
     */
    private void sendInfo(String s) {
        byte[] jsonFriendIps = s.getBytes();
        try {
            Ip userIp = friendDao.getUserIp(userId);
            System.out.println(userIp.getPort());
            DatagramPacket packet = new DatagramPacket(jsonFriendIps,jsonFriendIps.length, InetAddress.getByName("127.0.0.1"), userIp.getPort());
            socket.send(packet);
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
