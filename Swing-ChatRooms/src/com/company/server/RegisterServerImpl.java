package com.company.server;

import com.alibaba.fastjson.JSONObject;
import com.company.model.User;
import com.company.server.server.RegisterServer;
import com.company.utils.SocketUtil;
import com.company.utils.FriendInfoUtil;

import java.io.IOException;
import java.net.*;

/**
 * @author peichendong
 */
public class RegisterServerImpl implements RegisterServer {

    private DatagramSocket dSocket;
    private String statusInfo;



    @Override
    public boolean registerIng(User user) {

       sendRegisterInfo();
       return "注册成功".equals(statusInfo);
    }



    /**
     * 发送注册信息
     */
    public void sendRegisterInfo(){

            dSocket = SocketUtil.getDatagramSocket();
            System.out.println("连接服务器.....");
            //转为json字符串
            String registerInfo = JSONObject.toJSONString(FriendInfoUtil.getUser());
            byte[] jsonRegisterInfo = registerInfo.getBytes();
            System.out.println(registerInfo);
            try {
                DatagramPacket packet = new DatagramPacket(jsonRegisterInfo, 0, jsonRegisterInfo.length, InetAddress.getByName("127.0.0.1"), 4600);
                dSocket.send(packet);
                System.out.println("发送成功");
                getRegisterStatus();
                getUserInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    /**
     * 获取注册状态
     */
    public void getRegisterStatus(){
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        try {
            dSocket.receive(packet);
            statusInfo = new String(packet.getData(),0,packet.getLength());
            statusInfo = JSONObject.parseObject(statusInfo,String.class);
            System.out.println(statusInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取用户信息
     */
    public void getUserInfo(){
        byte[] info = new byte[1024];
        getInfo(info);
    }

     public void getInfo(byte[] info) {
        DatagramPacket packet = new DatagramPacket(info,info.length);
        try {
            dSocket.receive(packet);
            String userInfo = new String(packet.getData(),0,packet.getLength());
            System.out.println(userInfo);
            FriendInfoUtil.user = JSONObject.parseObject(userInfo, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
