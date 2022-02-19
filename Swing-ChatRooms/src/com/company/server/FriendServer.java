package com.company.server;

import com.alibaba.fastjson.JSONObject;
import com.company.utils.SocketUtil;
import com.company.utils.UserInfoUtil;

import java.io.IOException;
import java.net.*;

/**
 * @author peichendong
 */
public class FriendServer {
    DatagramSocket socket;

    public FriendServer() {
       friendServer();
    }

    public void friendServer(){
        try {
            socket = SocketUtil.getDatagramSocket();
            String friendInfo = UserInfoUtil.getUser().getId();
            byte[] jsonFriendInfo = JSONObject.toJSONString(friendInfo).getBytes();
            DatagramPacket packet = new DatagramPacket(jsonFriendInfo,jsonFriendInfo.length, InetAddress.getByName("127.0.0.1"),4800);
            socket.send(packet);
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getFriendsInfo(){

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        try {
            socket.receive(packet);
            String jsonFriInfo = new String(packet.getData(),0,packet.getLength());
            System.out.println(jsonFriInfo);
            return jsonFriInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getFriendsIp(){
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        try {
            socket.receive(packet);
            String jsonIps = new String(packet.getData(),0,packet.getLength());
            System.out.println(jsonIps);
            return jsonIps;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendFriendApply(String account){
        try {
            socket = SocketUtil.getDatagramSocket();
            byte[] jsonFriendInfo = JSONObject.toJSONString(account).getBytes();
            DatagramPacket packet = new DatagramPacket(jsonFriendInfo,jsonFriendInfo.length, InetAddress.getByName("127.0.0.1"),4900);
            socket.send(packet);
            System.out.println("发送成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean getApply(){
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        try {
            socket.receive(packet);
            String apply = new String(packet.getData(),0,packet.getLength());
            String applyString = JSONObject.parseObject(apply, String.class);
            System.out.println("内容是"+applyString);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
