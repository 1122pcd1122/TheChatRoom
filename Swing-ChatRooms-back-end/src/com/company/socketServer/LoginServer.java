package com.company.socketServer;

import com.alibaba.fastjson.JSONObject;
import com.company.model.entity.Ip;
import com.company.model.entity.Login;
import com.company.model.dao.UserDao;
import com.company.model.daoimpl.UserDaoImpl;
import com.company.utils.IpUtil;
import com.company.utils.UserInfoUtil;

import java.io.IOException;
import java.net.*;

/**
 * @author peichendong
 */
public class LoginServer {

    /**
     * UDP套接字
     */
    private DatagramSocket dSocket;

    /**
     * 登录信息
     */
    private Login login;

    private int port;

    public static void main(String[] args) {
        new LoginServer();
    }


    /**
     * 开启服务器的‘4700’端口来处理用户的登录逻辑
     */
    public LoginServer() {
        try {
            dSocket = new DatagramSocket(4700);
            new GetLoginThread().start();
            System.out.println("正在查询用户信息......");
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否登录成功并发送状态消息
     */
    public void getLoginStatus(){
        UserDao userDao = new UserDaoImpl();
        boolean isLogin = userDao.getUserInfo(login.getAccount(),login.getPassWord());
        sendLoginStatus(isLogin);
    }


    /**
     * 获取登录信息的线程
     */
    class GetLoginThread extends Thread{
        @Override
        public void run() {
            try {
                getLoginInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                dSocket.close();
            }
        }
    }

    /**
     * 获取登录信息
     */
    public void getLoginInfo() {
        byte[] buffer = new byte[1024];

        System.out.println("服务端正在等待登录信息...");
        //数据包
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        while (true){
            //获取数据包
            try {
                dSocket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String data = new String(packet.getData(),0, packet.getLength());
            //打印
            System.out.println("准备登录的用户信息:"+data);
            System.out.println("来自主机:"+ packet.getAddress().toString()+",端口号:"+ packet.getPort());
            IpUtil.getIp().setIp(packet.getAddress().toString());
            IpUtil.getIp().setPort(packet.getPort());
            //json解析为login实体类
            login = JSONObject.parseObject(data, Login.class);
            //获取登录状态
            getLoginStatus();
        }

    }

    /**
     * 发送登录状态
     * @param status 状态
     */
    public void sendLoginStatus(boolean status){
        String info;
        if (status){
            info = "登录成功";
        }else {
            info = "登录失败";
        }
        //信息
        byte[] infos = JSONObject.toJSONString(info).getBytes();
        //用户信息
        byte[] infos1 = JSONObject.toJSONString(UserInfoUtil.getUser()).getBytes();

        //发送
        try {
            DatagramPacket packet = new DatagramPacket(infos,0,infos.length, InetAddress.getByName("127.0.0.1"),IpUtil.getIp().getPort());
            DatagramPacket packet1 = new DatagramPacket(infos1,0,infos1.length,InetAddress.getByName("127.0.0.1"), IpUtil.getIp().getPort());
            dSocket.send(packet);
            dSocket.send(packet1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
