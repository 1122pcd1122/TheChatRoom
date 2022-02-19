package com.company.socketServer;


import com.alibaba.fastjson.JSONObject;
import com.company.model.entity.Ip;
import com.company.model.entity.User;
import com.company.model.daoimpl.UserDaoImpl;
import com.company.utils.IpUtil;

import java.net.*;
import java.util.Random;

/**
 * @author peichendong
 */
public class RegisterServer {

    public String userInfo;
    private Ip ip;

    private UserDaoImpl userDao;
    private DatagramSocket dSocket;

    public static void main(String[] args) {
        new RegisterServer();
    }

    public RegisterServer() {
        try {
            dSocket = new DatagramSocket(4600);
            new GetRegisterThread().start();
            userDao = new UserDaoImpl();
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取用户信息数据包线程
     */
     class GetRegisterThread extends Thread{
        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            try {

                System.out.println("服务端正在等待注册信息......");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                while (true){
                    dSocket.receive(packet);
                    userInfo = new String(packet.getData(),0,packet.getLength());
                    System.out.println("来自主机:"+packet.getAddress().toString()+",端口号:"+packet.getPort());
                    //设置ip
                    ip = new Ip();
                    ip.setIp(packet.getAddress().toString());
                    ip.setPort(packet.getPort());

                    System.out.println("数据为:"+ userInfo);
                    insertUserInfo();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                dSocket.close();
            }

        }
    }





    /**
     * 插入数据
     */
    public void insertUserInfo(){
        System.out.println("准备向服务器中插入数据......");

        if (userInfo!=null){
            User user = parsing();
            boolean b = userDao.insertUserInfo(user);
            ip.setId(user.getId());
            boolean b1 = userDao.insertIp(ip);
            if (!b && !b1){
                System.out.println("插入成功");
                sendRegisterStatus("注册成功");
            }else {
                System.out.println("插入失败");
                sendRegisterStatus("注册失败");
            }
            //发送用户信息
            sendUserInfo(user);
        }
    }

    public void sendRegisterStatus(String status){

        byte[] infos = JSONObject.toJSONString(status).getBytes();
        try {
            DatagramPacket packet = new DatagramPacket(infos,0,infos.length, InetAddress.getByName("127.0.0.1"), 5022);
            dSocket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendUserInfo(User user){
        byte[] users = JSONObject.toJSONString(user).getBytes();
        try {
            DatagramPacket packet = new DatagramPacket(users,0,users.length,InetAddress.getByName("127.0.0.1"),5022);
            dSocket.send(packet);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }



    /**
     * @return 返回用户信息
     */
    public User parsing(){
        User user = JSONObject.parseObject(userInfo,User.class);
        user.setId(randomId());
        return user;
    }

    /**
     * @return 生成账号
     */
    public String randomId(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int id = random.nextInt(10);
            stringBuilder.append(id);
        }
        return stringBuilder.toString();
    }

}
